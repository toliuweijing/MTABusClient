package com.obanyc.api.local;

import com.obanyc.api.siri.Distances;
import com.obanyc.api.siri.MonitoredStopVisit;
import com.obanyc.api.siri.MonitoredVehicleJourney;
import com.obanyc.api.siri.StopMonitoringDelivery;
import com.obanyc.api.siri.StopMonitoringRoot;

import java.util.List;

/**
 * Created by toliuweijing on 6/16/15.
 */
public class StopMonitoringProxy {

  public static Primitives.MonitoredCall toClosetMonitoredCall(
      StopMonitoringRoot stopMonitoringRoot) {
    List<StopMonitoringDelivery> delivery = stopMonitoringRoot
        .getSiri()
        .getServiceDelivery()
        .getStopMonitoringDelivery();
    if (delivery.isEmpty()) {
      return null;
    }

    Distances closet = null;
    List<MonitoredStopVisit> stopVisits = delivery.get(0).getMonitoredStopVisit();
    for (MonitoredStopVisit v : stopVisits) {
      MonitoredVehicleJourney j = v.getMonitoredVehicleJourney();
      Distances distances = j.getMonitoredCall().getExtensions().getDistances();
      if (closet == null || closet.getStopsFromCall() > distances.getStopsFromCall()) {
        closet = distances;
      }
    }

    Primitives.MonitoredCall ret = closet == null ? null : toMonitoredCall(closet);
    return ret;
  }

  static Primitives.MonitoredCall toMonitoredCall(Distances distances) {
    return Primitives.MonitoredCall.create(
        (int) distances.getStopsFromCall(),
        distances.getPresentableDistance());
  }
}
