package com.obanyc.api;

import android.location.Location;
import android.util.Log;

import com.google.common.util.concurrent.FutureCallback;
import com.obanyc.api.local.Queries;
import com.obanyc.api.where.stopsforlocation.Route;
import com.obanyc.api.where.stopsforlocation.Stop;
import com.obanyc.api.where.stopsforlocation.StopsForLocationRoot;
import com.obanyc.api.where.stopsforroute.StopsForRouteRoot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

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
}
