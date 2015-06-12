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
  }

  @AutoValue
  public abstract static class Stop {
    abstract String code();
    abstract String direction();
    abstract String id();
    abstract double lat();
    abstract double lon();
    abstract String name();
  }

  @AutoValue
  public abstract static class Direction {
    abstract String id();
    abstract String destination();
  }
}
