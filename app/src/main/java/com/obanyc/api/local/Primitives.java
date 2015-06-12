package com.obanyc.api.local;

import com.google.auto.value.AutoValue;

/**
 * Created by toliuweijing on 6/12/15.
 */
public class Primitives {
  @AutoValue
  public abstract static class Route {
    abstract String color();
    abstract String description();
    abstract String id();
    abstract String longName();
    abstract String shortName();
    abstract String textColor();

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
    abstract String code();
    abstract String direction();
    abstract String id();
    abstract double lat();
    abstract double lon();
    abstract String name();

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
    abstract String id();
    abstract String destination();

    public static Direction create(
        String id,
        String destination) {
      return new AutoValue_Primitives_Direction(id, destination);
    }
  }
}
