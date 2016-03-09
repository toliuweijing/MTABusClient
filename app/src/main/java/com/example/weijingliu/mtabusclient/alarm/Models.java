package com.example.weijingliu.mtabusclient.alarm;

import android.util.Log;

import com.google.auto.value.AutoValue;
import com.google.common.base.Objects;
import com.obanyc.api.local.Primitives.Route;
import com.obanyc.api.local.Primitives.Stop;

/**
 * Created by toliuweijing on 6/15/15.
 */
public class Models {
  @AutoValue
  public static abstract class Alarm {
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

    public abstract Route route();

    public abstract Stop stop();

    public abstract Type type();

    public abstract long time();

    public abstract int nearCount();

    public int id() {
      Log.i("jing", "hashCode-" + String.valueOf(hashCode()));
      return hashCode();
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(
          route().id(),
          stop().id(),
          type(),
          time(),
          nearCount());
    }

    public enum Type {
      TIME, NEAR
    }
  }
}
