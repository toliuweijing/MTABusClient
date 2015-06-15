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

  public void add(Alarm alarm) {
    mAlarms.add(alarm);
  }

  public List<Alarm> getAll() {
    return mAlarms;
  }
}
