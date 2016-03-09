package com.example.weijingliu.mtabusclient.alarm.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.weijingliu.mtabusclient.alarm.AlarmStore;
import com.google.common.base.Preconditions;

/**
 * Created by toliuweijing on 3/8/16.
 */
public class NotifyCancelAlarmReceiver extends BroadcastReceiver {
  public static final String EXTRA_ALARM_ID = "extra_alarm_id";

  public static PendingIntent createPendingIntent(Context context, int alarmId) {
    Intent intent = new Intent(context, NotifyCancelAlarmReceiver.class);
    intent.putExtra(EXTRA_ALARM_ID, alarmId);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
    return pendingIntent;
  }

  @Override
  public void onReceive(Context context, Intent intent) {
    Preconditions.checkArgument(intent.hasExtra(EXTRA_ALARM_ID));
    int alarmId = intent.getIntExtra(EXTRA_ALARM_ID, 0);
    NotificationManager notificationManager =
        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

    // cancel notification and remove from alarm store.
    cancelNotificationAndRemoveFromAlarmStore(alarmId, notificationManager);

    // refresh Service so it may stop self instantly.
    NearAlarmService.refreshService(context);
  }

  private void cancelNotificationAndRemoveFromAlarmStore(
      int alarmId,
      NotificationManager notificationManager) {
    notificationManager.cancel(alarmId);
    AlarmStore.instance.remove(alarmId);
  }
}
