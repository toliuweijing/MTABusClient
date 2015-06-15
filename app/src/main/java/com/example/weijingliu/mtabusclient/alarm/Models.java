package com.example.weijingliu.mtabusclient.alarm;

import com.google.auto.value.AutoValue;
import com.obanyc.api.local.Primitives.*;

/**
 * Created by toliuweijing on 6/15/15.
 */
public class Models {
  @AutoValue
  public static abstract class Alarm {
    public enum Type {
      TIME, NEAR
    }

    public abstract Route route();
    public abstract Stop stop();
    public abstract Type type();
    public abstract long time();
    public abstract int nearCount();

    public static Alarm ofTime(
        Route route,
        Stop stop,
        long time) {
      return new AutoValue_Models_Alarm(route, stop, Type.TIME, time, 0);
    }

    public static Alarm ofNear(
        Route route,
        Stop stop,
        int nearCount) {
      return new AutoValue_Models_Alarm(route, stop, Type.NEAR, 0, nearCount);
    }
  }
}
