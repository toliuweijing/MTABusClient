package com.obanyc.api.local;

import android.location.Location;

import com.example.weijingliu.mtabusclient.Utils;
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
//  public static List<Queries.RouteDirections> toRouteStopDirection(
//      Location location,
//      StopsForRouteRoot root) {
//    List<StopGroup> groups = root.getData().getEntry().getStopGroupings().get(0).getStopGroups();
//    List<Stop> stops = root.getData().getReferences().getStops();
//
//    Map<String, Stop> stopIdToStop = new HashMap<>();
//    for (Stop s : stops) {
//      stopIdToStop.put(s.getId(), s);
//    }
//
//    Map<StopGroup, Stop> stopGroupToStop = new HashMap<>();
//    for (StopGroup group : groups) {
//      Stop closetStop = null;
//      for (String stopId : group.getStopIds()) {
//        Stop stop = stopIdToStop.get(stopId);
//        if (closetStop == null ||
//            Utils.distanceTo(location, stop.getLat(), stop.getLon()) <
//                Utils.distanceTo(location, closetStop.getLat(), closetStop.getLon())) {
//          closetStop = stop;
//        }
//      }
//      stopGroupToStop.put(group, closetStop);
//    }
//
//    List<Queries.RouteDirections> routeDirectionsList = new ArrayList<>();
//    for (Map.Entry<StopGroup, Stop> entry : stopGroupToStop.entrySet()) {
//      StopGroup group = entry.getKey();
//      Stop stop = entry.getValue();
////      Queries.RouteDirections routeDirections = Queries.RouteDirections.create(
////          toRoute(route),
////          toDirection(group));
////      routeDirectionsList.add(routeDirections);
//    }
//    return routeDirectionsList;
//  }

  static Primitives.Route toRoute(Route r) {
    return Primitives.Route.create(
        r.getColor(),
        r.getDescription(),
        r.getId(),
        r.getLongName(),
        r.getShortName(),
        r.getTextColor());
  }

  static Primitives.Stop toStop(Stop s) {
    return Primitives.Stop.create(
        s.getCode(),
        s.getDirection(),
        s.getId(),
        s.getLat(),
        s.getLon(),
        s.getName());
  }

  static Primitives.Direction toDirection(StopGroup sg) {
    return Primitives.Direction.create(sg.getId(), sg.getName().getName());
  }
}
