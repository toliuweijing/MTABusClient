package com.obanyc.api.local;

import android.location.Location;
import android.util.ArrayMap;

import com.example.weijingliu.mtabusclient.Utils;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.obanyc.api.where.stopsforroute.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import autovalue.shaded.com.google.common.common.base.Function;
import autovalue.shaded.com.google.common.common.collect.Lists;
import retrofit.http.Query;

import static com.google.common.collect.Iterables.*;

/**
 * Created by toliuweijing on 6/12/15.
 */
public class StopsForRouteProxy {

  public static Queries.RouteDirections toRouteDirections(StopsForRouteRoot root) {
    final String routeId = root.getData().getEntry().getRouteId();
    List<Route> routes = root.getData().getReferences().getRoutes();
    Route route = Iterables.find(routes, new Predicate<Route>() {
          @Override
          public boolean apply(Route route) {
            return route.getId().equals(routeId);
          }
        });
    List<StopGroup> stopGroup = root.getData().getEntry().getStopGroupings().get(0).getStopGroups();
    List<Primitives.Direction> directions = Lists.transform(
        stopGroup,
        new Function<StopGroup, Primitives.Direction>() {
          @Override
          public Primitives.Direction apply(StopGroup stopGroup) {
            return toDirection(stopGroup);
          }
        });
    return Queries.RouteDirections.create(toRoute(route), directions);
  }

  public static Primitives.Stop toClosetStop(
      Location location,
      StopsForRouteRoot root,
      final String directionId) {
    List<StopGroup> stopGroups =  root
        .getData()
        .getEntry()
        .getStopGroupings()
        .get(0)
        .getStopGroups();
    List<Stop> stops = root.getData() .getReferences().getStops();

    StopGroup stopGroup = Iterables.tryFind(stopGroups, new Predicate<StopGroup>() {
      @Override
      public boolean apply(StopGroup input) {
        return input.getId().equals(directionId);
      }
    }).orNull();

    Map<String, Stop> stopIdMap = new HashMap<>();
    for (Stop stop : stops) {
      stopIdMap.put(stop.getId(), stop);
    }

    Stop closetStop = null;
    for (String id : stopGroup.getStopIds()) {
      Stop stop = stopIdMap.get(id);
      if (closetStop == null ||
          Utils.distanceTo(location, closetStop.getLat(), closetStop.getLon()) >
              Utils.distanceTo(location, stop.getLat(), stop.getLon())) {
        closetStop = stop;
      }
    }

    return toStop(closetStop);
  }

  public static Primitives.Route toRoute(final StopsForRouteRoot root) {
    Optional<Route> route = tryFind(
        root.getData().getReferences().getRoutes(),
        new Predicate<Route>() {
          @Override
          public boolean apply(@Nullable Route input) {
            return input.getId().equals(root.getData().getEntry().getRouteId());
          }
        });
    assert route.isPresent();
    return toRoute(route.orNull());
  }

  public static Primitives.Route toRoute(Route r) {
    return Primitives.Route.create(
        r.getColor(),
        r.getDescription(),
        r.getId(),
        r.getLongName(),
        r.getShortName(),
        r.getTextColor());
  }

  public static Primitives.Stop toStop(Stop s) {
    return Primitives.Stop.create(
        s.getCode(),
        s.getDirection(),
        s.getId(),
        s.getLat(),
        s.getLon(),
        s.getName());
  }

  public static Primitives.Direction toDirection(StopGroup sg) {
    return Primitives.Direction.create(sg.getId(), sg.getName().getName());
  }

  public static Primitives.Direction toDirection(StopsForRouteRoot root, final String directionId) {
    Optional<StopGroup> stopGroup = tryFind(
        root.getData().getEntry().getStopGroupings().get(0).getStopGroups(),
        new Predicate<StopGroup>() {
          @Override
          public boolean apply(@Nullable StopGroup input) {
            return input.getId().equals(directionId);
          }
        });
    assert stopGroup.isPresent();
    return toDirection(stopGroup.orNull());
  }
}
