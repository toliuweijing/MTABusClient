package com.example.weijingliu.mtabusclient.alarm;

import android.app.NotificationManager;
import android.content.Context;

import com.example.weijingliu.mtabusclient.alarm.Models.Alarm;
import com.example.weijingliu.mtabusclient.alarm.service.NearAlarmService;

/**
 * Created by toliuweijing on 2/20/16.
 */
public class AlarmUtil {
  public static void dismissAlarm(Alarm alarm, Context context) {
    AlarmStore.instance.remove(alarm);

    NotificationManager notificationManager = (NotificationManager)
        context.getSystemService(Context.NOTIFICATION_SERVICE);
    notificationManager.cancel(alarm.id());
    NearAlarmService.refreshService(context);
  }
}
