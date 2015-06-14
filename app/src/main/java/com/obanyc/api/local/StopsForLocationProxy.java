package com.obanyc.api.local;

import com.obanyc.api.where.stopsforlocation.*;

/**
 * Created by toliuweijing on 6/13/15.
 */
public class StopsForLocationProxy {
  public static Primitives.Route toRoute(Route route) {
    return Primitives.Route.create(
        route.getColor(),
        route.getDescription(),
        route.getId(),
        route.getLongName(),
        route.getShortName(),
        route.getTextColor());
  }
}
