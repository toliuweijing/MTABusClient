package com.example.weijingliu.mtabusclient.alarm;

import com.example.weijingliu.mtabusclient.alarm.Models.Alarm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by toliuweijing on 6/15/15.
 */
public class AlarmStore {
  public static final AlarmStore instance = new AlarmStore();

  private final List<Alarm> mAlarms = new ArrayList<>();

  public void remove(Alarm alarm) {
    mAlarms.remove(alarm);
  }

  public void remove(final int alarmId) {
    for (Alarm alarm : mAlarms) {
      if (alarm.id() == alarmId) {
        remove(alarm);
        return;
      }
    }
  }

  public void add(Alarm alarm) {
    for (Alarm a : mAlarms) {
      if (a.id() == alarm.id()) {
        return;
      }
    }
    mAlarms.add(alarm);
  }

  public List<Alarm> getAll() {
    return new ArrayList<>(mAlarms);
  }

  public void clear() {
    mAlarms.clear();
  }
}
