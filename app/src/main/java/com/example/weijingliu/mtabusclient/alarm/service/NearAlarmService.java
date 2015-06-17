package com.example.weijingliu.mtabusclient.alarm.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.example.weijingliu.mtabusclient.R;
import com.example.weijingliu.mtabusclient.alarm.AlarmStore;
import com.example.weijingliu.mtabusclient.alarm.Models;
import com.example.weijingliu.mtabusclient.alarm.Models.Alarm;
import com.obanyc.api.LocalService;
import com.obanyc.api.ObaService;
import com.obanyc.api.local.Primitives;
import com.obanyc.api.local.Primitives.Stop;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class NearAlarmService extends Service {

  private Handler mHandler = new Handler();

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    List<Alarm> alarms = AlarmStore.instance.getAll(Alarm.Type.NEAR);
    if (alarms.isEmpty()) {
      stopSelf();
      return START_NOT_STICKY;
    }
    Log.d("jing", "nearby alarm service running");

    Alarm alarm = alarms.get(0);
    Notification notification = new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.ic_directions_bus_black_48dp)
        .setLargeIcon(
            BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_directions_bus_black_48dp))
        .setContentTitle("Starting realtime tracking")
        .setContentText(alarm.stop().name())
        .setSubText(alarm.route().shortName())
        .setAutoCancel(true)
        .setDefaults(Notification.DEFAULT_ALL)
        .setProgress(100, 50, false)
        .build();
    startForeground(alarm.stop().id().hashCode(), notification);

    startProcessing(alarm);

    return START_NOT_STICKY;
  }

  private void startProcessing(final Alarm alarm) {
    Stop stop = alarm.stop();
    LocalService.instance.stopMonitoredCall(
          alarm.route().id(),
          alarm.stop().id())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(new Subscriber<Primitives.MonitoredCall>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Primitives.MonitoredCall monitoredCall) {
              Notification notification = new NotificationCompat.Builder(
                  NearAlarmService.this)
                  .setSmallIcon(R.drawable.ic_directions_bus_black_48dp)
                  .setLargeIcon(
                      BitmapFactory.decodeResource(getResources(),
                          R.drawable.ic_directions_bus_black_48dp))
                  .setContentTitle(monitoredCall.presentableDistance())
                  .setContentText(alarm.stop().name())
                  .setAutoCancel(true)
                  .setDefaults(Notification.DEFAULT_ALL)
                  .setProgress(
                      monitoredCall.stopFromCall(),
                      alarm.nearCount(),
                      false)
                  .build();
              startForeground(alarm.stop().id().hashCode(), notification);

              if (monitoredCall.stopFromCall() > alarm.nearCount()) {
                mHandler.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                    startProcessing(alarm);
                  }
                },
                30000);
              } else {
                stopForeground(false);
              }
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
