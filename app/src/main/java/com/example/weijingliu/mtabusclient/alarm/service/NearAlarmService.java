package com.example.weijingliu.mtabusclient.alarm.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.NotificationCompat;

import com.example.weijingliu.mtabusclient.R;
import com.example.weijingliu.mtabusclient.alarm.AlarmStore;
import com.example.weijingliu.mtabusclient.alarm.Models.Alarm;
import com.example.weijingliu.mtabusclient.nearbybus.NearbyBusActivity;
import com.obanyc.api.LocalService;
import com.obanyc.api.local.Primitives.MonitoredCall;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class NearAlarmService extends Service {

  private Handler mHandler;
  private NotificationHelper mNotificationHelper;
  private NotificationManager mNotificationManager;
  private boolean mForegrounded = false;

  @Override
  public void onCreate() {
    super.onCreate();
    mNotificationHelper = new NotificationHelper();
    mHandler = new Handler();
    mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
  }

  class NotificationHelper {
    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(NearAlarmService.this);
    Bitmap mBusBitmap = BitmapFactory.decodeResource(
        getResources(),
        R.drawable.ic_launcher);

    Notification status(Alarm alarm, MonitoredCall monitoredCall, boolean ongoing) {
      ongoing = false;
      int defaults = Notification.DEFAULT_LIGHTS;
      int priority = NotificationCompat.PRIORITY_DEFAULT;
      if (ongoing) {
        defaults = Notification.DEFAULT_ALL;
        priority = NotificationCompat.PRIORITY_HIGH;
      }

      return mBuilder
          .setSmallIcon(R.drawable.ic_directions_bus_black_48dp)
          .setLargeIcon(mBusBitmap)
          .setContentTitle(monitoredCall.presentableDistance())
          .setContentText(alarm.route().shortName() + " - " + alarm.stop().name())
          .setAutoCancel(false)
          .setOngoing(ongoing)
          .setDefaults(defaults)
          .setWhen(System.currentTimeMillis())
          .setPriority(priority)
          .setProgress(monitoredCall.stopFromCall(), 2, false)
          .setContentIntent(
              PendingIntent.getActivity(
                  NearAlarmService.this,
                  0,
                  NearbyBusActivity.IntentFactory.alarmViewer(NearAlarmService.this),
                  PendingIntent.FLAG_UPDATE_CURRENT))
          .build();
    }

    Notification initial() {
      return mBuilder
          .setSmallIcon(R.drawable.ic_directions_bus_black_48dp)
          .setLargeIcon(mBusBitmap)
          .setContentTitle("Start Monitering")
          .setAutoCancel(false)
          .setOngoing(true)
          .setContentIntent(
              PendingIntent.getActivity(
                  NearAlarmService.this,
                  0,
                  NearbyBusActivity.IntentFactory.alarmViewer(NearAlarmService.this),
                  PendingIntent.FLAG_UPDATE_CURRENT))
          .build();
    }
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    runAndRepeatIfNeeded();
    return START_NOT_STICKY;
  }

  private void runAndRepeatIfNeeded() {
    mHandler.removeCallbacksAndMessages(null);

    if (stopIfNeeded()) {
      return;
    }

    List<Alarm> alarms = AlarmStore.instance.getAll();
    if (!mForegrounded) {
      mForegrounded = true;
      startForeground(-1, mNotificationHelper.initial());
    }
    for (Alarm alarm : alarms) {
      run(alarm);
    }
    mHandler.postDelayed(
        new Runnable() {
          @Override
          public void run() {
            runAndRepeatIfNeeded();
          }
        },
        30000);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mHandler.removeCallbacksAndMessages(null);
  }

  private boolean stopIfNeeded() {
    if (AlarmStore.instance.getAll().isEmpty()) {
      stopForeground(true);
      stopSelf();
      return true;
    }
    return false;
  }

  private void run(final Alarm alarm) {
    LocalService.instance.stopMonitoredCall(
          alarm.route().id(),
          alarm.stop().id())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(new Subscriber<MonitoredCall>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MonitoredCall monitoredCall) {
              boolean finishing = false;
              if (monitoredCall.stopFromCall() <= alarm.nearCount()) {
                AlarmStore.instance.remove(alarm);
                finishing = true;
              }
              Notification notification = mNotificationHelper.status(
                  alarm,
                  monitoredCall,
                  !finishing);
              mNotificationManager.notify(alarm.id(), notification);

              stopIfNeeded();
            }
          });
  }

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  public static class Config implements Parcelable {
    private String routeId;
    private String routeName;
    private String stopId;
    private String stopName;
    private int nearCount;

    public Config() {
    }

    public Config(String routeId, String routeName, String stopId, String stopName, int nearCount) {
      this.routeId = routeId;
      this.routeName = routeName;
      this.stopId = stopId;
      this.stopName = stopName;
      this.nearCount = nearCount;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.routeId);
      dest.writeString(this.routeName);
      dest.writeString(this.stopId);
      dest.writeString(this.stopName);
      dest.writeInt(this.nearCount);
    }

    protected Config(Parcel in) {
      this.routeId = in.readString();
      this.routeName = in.readString();
      this.stopId = in.readString();
      this.stopName = in.readString();
      this.nearCount = in.readInt();
    }

    public static final Parcelable.Creator<Config> CREATOR = new Parcelable.Creator<Config>() {
      public Config createFromParcel(Parcel source) {
        return new Config(source);
      }

      public Config[] newArray(int size) {
        return new Config[size];
      }
    };
  }
}
