package com.obanyc.api.local;

import com.google.auto.value.AutoValue;

/**
 * Created by toliuweijing on 6/12/15.
 */
public class Primitives {
  @AutoValue
  public abstract static class Route {
    public abstract String color();
    public abstract String description();
    public abstract String id();
    public abstract String longName();
    public abstract String shortName();
    public abstract String textColor();

    public static Route create(
        String color,
        String description,
        String id,
        String longName,
        String shortName,
        String textColor) {
      return new AutoValue_Primitives_Route(color, description, id, longName, shortName, textColor);
    }
  }

  @AutoValue
  public abstract static class Stop {
    public abstract String code();
    public abstract String direction();
    public abstract String id();
    public abstract double lat();
    public abstract double lon();
    public abstract String name();

    public static Stop create(
        String code,
        String direction,
        String id,
        double lat,
        double lon,
        String name) {
      return new AutoValue_Primitives_Stop(code, direction, id, lat, lon, name);
    }
  }

  @AutoValue
  public abstract static class Direction {
    public abstract String id();
    public abstract String destination();

    public static Direction create(
        String id,
        String destination) {
      return new AutoValue_Primitives_Direction(id, destination);
    }
  }

  @AutoValue
  public abstract static class Schedule {
    public abstract long arrivalTime();
    public abstract long departureTime();

    public static Schedule create(
        long arrivalTime,
        long departureTime) {
      return new AutoValue_Primitives_Schedule(arrivalTime, departureTime);
    }
  }

  @AutoValue
  public abstract static class MonitoredCall {
    public abstract int stopFromCall();
    public abstract String presentableDistance();

    public static MonitoredCall create(
        int stopFromCall,
        String presentableDistance) {
      return new AutoValue_Primitives_MonitoredCall(stopFromCall, presentableDistance);
    }
  }
}
