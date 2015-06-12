package com.obanyc.api.local;

import com.google.auto.value.AutoValue;
import com.obanyc.api.local.Primitives.Direction;
import com.obanyc.api.local.Primitives.Route;

import java.util.List;

public class Queries {
  @AutoValue
  public abstract static class NearbyBusQuery {
    abstract List<RouteDirections> routeStopDirections();

    public static NearbyBusQuery create(List<RouteDirections> a) {
      return new AutoValue_Queries_NearbyBusQuery(a);
    }
  }

  @AutoValue
  public abstract static class RouteDirections {
    abstract Route route();
    abstract List<Direction> directions();

    public static RouteDirections create(
        Route route,
        List<Direction> directions) {
      return new AutoValue_Queries_RouteDirections(route, directions);
    }
  }
}
