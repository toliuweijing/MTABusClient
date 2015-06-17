package com.obanyc.api;

import android.location.Location;

import com.google.common.base.Optional;
import com.obanyc.api.local.Primitives;
import com.obanyc.api.local.Primitives.Direction;
import com.obanyc.api.local.Queries;
import com.obanyc.api.local.Queries.RouteStopDirectionSchedules;
import com.obanyc.api.local.ScheduleForStopProxy;
import com.obanyc.api.local.StopMonitoringProxy;
import com.obanyc.api.local.StopsForLocationProxy;
import com.obanyc.api.local.StopsForRouteProxy;
import com.obanyc.api.siri.StopMonitoringRoot;
import com.obanyc.api.where.scheduleforstop.ScheduleForStopRoot;
import com.obanyc.api.where.stopsforlocation.Route;
import com.obanyc.api.where.stopsforlocation.Stop;
import com.obanyc.api.where.stopsforlocation.StopsForLocationRoot;
import com.obanyc.api.where.stopsforroute.StopsForRouteRoot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.JarInputStream;

import rx.Observable;
import rx.functions.Func1;

import static com.obanyc.api.local.StopsForRouteProxy.toClosetStop;
import static com.obanyc.api.local.StopsForRouteProxy.toDirection;
import static com.obanyc.api.local.StopsForRouteProxy.toRoute;
import static com.obanyc.api.local.StopsForRouteProxy.toRouteDirections;

public class LocalService {
  private static final String TAG = LocalService.class.getSimpleName();

  public static final LocalService instance = new LocalService();

  public Observable<Queries.RouteDirections> nearbyRouteDirections(final Location location) {
    final Observable<StopsForLocationRoot> stopsForLocation = ObaService
        .getClient()
        .getStopsForLocation(
            location.getLatitude(),
            location.getLongitude());

    Observable<StopsForRouteRoot> stopsForRouteRoot = stopsForLocation
        .flatMap(new Func1<StopsForLocationRoot, Observable<StopsForRouteRoot>>() {
          @Override
          public Observable<StopsForRouteRoot> call(StopsForLocationRoot stopsForLocationRoot) {
            Set<String> routes = new HashSet<>();
            for (Stop stop : stopsForLocationRoot.getData().getStops()) {
              for (Route route : stop.getRoutes()) {
                routes.add(route.getId());
              }
            }

            Observable<StopsForRouteRoot> result = Observable
                .from(routes)
                .flatMap(new Func1<String, Observable<StopsForRouteRoot>>() {
                  @Override
                  public Observable<StopsForRouteRoot> call(String routeId) {
                    return ObaService.getClient().getStopsForRoute(routeId);
                  }
                });
            return result;
          }
        });

    Observable<Queries.RouteDirections> routeStopDirection = stopsForRouteRoot
        .map(new Func1<StopsForRouteRoot, Queries.RouteDirections>() {
          @Override
          public Queries.RouteDirections call(StopsForRouteRoot stopsForRouteRoot) {
            return toRouteDirections(stopsForRouteRoot);
          }
        });
    return routeStopDirection;
  }

  public Observable<RouteStopDirectionSchedules> routeStopDirectionSchedule(
      final Location location,
      final String routeId,
      final String directionId) {
    final Observable<StopsForRouteRoot> root = ObaService.getClient().getStopsForRoute(routeId);
    final Observable<RouteStopDirectionSchedules> routeStopDirectionScheduleObservable =
        root.flatMap(new Func1<StopsForRouteRoot, Observable<RouteStopDirectionSchedules>>() {
          @Override
          public Observable<RouteStopDirectionSchedules> call(StopsForRouteRoot stopsForRouteRoot) {
            final Primitives.Route route = toRoute(stopsForRouteRoot);
            final Primitives.Stop stop = toClosetStop(location, stopsForRouteRoot, directionId);
            final Primitives.Direction direction = toDirection(stopsForRouteRoot, directionId);

            Observable<ScheduleForStopRoot> scheduleForStopRoot =
                ObaService.getClient().getScheduleForStop(stop.id());
            return scheduleForStopRoot.map(
                new Func1<ScheduleForStopRoot, RouteStopDirectionSchedules>() {
                  @Override
                  public RouteStopDirectionSchedules call(ScheduleForStopRoot scheduleForStopRoot) {
                    Optional<List<Primitives.Schedule>> schedules = ScheduleForStopProxy
                        .toSchedules(scheduleForStopRoot, routeId);

                    return RouteStopDirectionSchedules.create(
                        route,
                        stop,
                        direction,
                        schedules.orNull());
                  }
                });
          }
        });

    return routeStopDirectionScheduleObservable;
  }

  public Observable<Primitives.MonitoredCall> stopMonitoredCall(
      final String routeId,
      final String stopId) {
    return ObaService.getClient().getStopMonitoring(routeId, stopId)
        .map(new Func1<StopMonitoringRoot, Primitives.MonitoredCall>() {
          @Override
          public Primitives.MonitoredCall call(StopMonitoringRoot stopMonitoringRoot) {
            return StopMonitoringProxy.toClosetMonitoredCall(stopMonitoringRoot);
          }
        });
  }
}
