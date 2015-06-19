package com.obanyc.api.local;

import com.google.auto.value.AutoValue;
import com.obanyc.api.local.Primitives.Direction;
import com.obanyc.api.local.Primitives.Route;
import com.obanyc.api.local.Primitives.Schedule;
import com.obanyc.api.local.Primitives.Stop;

import java.util.List;

public class Queries {
  @AutoValue
  public abstract static class NearbyBusQuery {
    public abstract List<RouteDirections> routeStopDirections();

    public static NearbyBusQuery create(List<RouteDirections> a) {
      return new AutoValue_Queries_NearbyBusQuery(a);
    }
  }

  @AutoValue
  public abstract static class RouteDirections {
    public abstract Route route();
    public abstract List<Direction> directions();

    public static RouteDirections create(
        Route route,
        List<Direction> directions) {
      return new AutoValue_Queries_RouteDirections(route, directions);
    }
  }

  @AutoValue
  public abstract static class RouteStopDirectionSchedules {
    public abstract Route route();
    public abstract Stop stop();
    public abstract Direction direction();
    public abstract List<Schedule> schedules();
    public abstract int stopIndex();

    public static RouteStopDirectionSchedules create(
        Route route,
        Stop stop,
        Direction direction,
        List<Schedule> schedules,
        int stopIndex) {
      return new AutoValue_Queries_RouteStopDirectionSchedules(
          route,
          stop,
          direction,
          schedules,
          stopIndex);
    }
  }
}
