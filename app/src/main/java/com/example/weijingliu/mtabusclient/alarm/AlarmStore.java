package com.example.weijingliu.mtabusclient.alarm;

import com.example.weijingliu.mtabusclient.alarm.Models.Alarm;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import autovalue.shaded.com.google.common.common.base.Function;
import autovalue.shaded.com.google.common.common.collect.Lists;

/**
 * Created by toliuweijing on 6/15/15.
 */
public class AlarmStore {
  public static final AlarmStore instance = new AlarmStore();

  private final List<Alarm> mAlarms = new ArrayList<>();

  public void remove(Alarm alarm) {
    mAlarms.remove(alarm);
  }

  public void add(Alarm alarm) {
    mAlarms.add(alarm);
  }

  public List<Alarm> getAll() {
    return new ArrayList<>(mAlarms);
  }

  public List<Alarm> getAll(final Alarm.Type type) {
    List<Alarm> result = new ArrayList<>(mAlarms);
    Iterables.removeIf(result, new Predicate<Alarm>() {
      @Override
      public boolean apply(Alarm input) {
        return input.type() != type;
      }
    });
    return result;
  }
}
