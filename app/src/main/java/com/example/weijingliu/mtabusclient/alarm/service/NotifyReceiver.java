package com.example.weijingliu.mtabusclient.alarm.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.example.weijingliu.mtabusclient.R;
import com.example.weijingliu.mtabusclient.nextbus.Config;
import com.google.auto.value.AutoValue;

public class NotifyReceiver extends BroadcastReceiver {
  public static final String EXTRA_CONFIG = Config.class.getName();

  @Override
  public void onReceive(Context context, Intent intent) {
    Config config = intent.getParcelableExtra(EXTRA_CONFIG);

    NotificationManager notificationManager =
        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    Notification notification = new NotificationCompat.Builder(context)
        .setSmallIcon(R.drawable.ic_directions_bus_black_48dp)
        .setLargeIcon(
            BitmapFactory.decodeResource(context.getResources(),
                R.drawable.ic_directions_bus_black_48dp))
        .setContentTitle("Scheduled time arrived")
        .setContentText(config.stopName)
        .setSubText(config.routeName)
        .setAutoCancel(true)
        .setDefaults(Notification.DEFAULT_ALL)
        .setPriority(Notification.PRIORITY_MAX)
        .build();
    notificationManager.notify(12, notification);
  }

  public static class Config implements Parcelable {
    private String routeId;
    private String routeName;
    private String stopId;
    private String stopName;

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
    }

    public Config() {
    }

    public Config(String routeId, String routeName, String stopId, String stopName) {
      this.routeId = routeId;
      this.routeName = routeName;
      this.stopId = stopId;
      this.stopName = stopName;
    }

    protected Config(Parcel in) {
      this.routeId = in.readString();
      this.routeName = in.readString();
      this.stopId = in.readString();
      this.stopName = in.readString();
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
