package com.example.weijingliu.mtabusclient.alarm;

import com.example.weijingliu.mtabusclient.alarm.Models.Alarm;

import java.util.ArrayList;
import java.util.List;

import autovalue.shaded.com.google.common.common.base.Predicate;
import autovalue.shaded.com.google.common.common.collect.Iterables;

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
    Iterables.removeIf(mAlarms, new Predicate<Alarm>() {
      @Override
      public boolean apply(Alarm alarm) {
        return alarm.id() == alarmId;
      }
    });
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
}
