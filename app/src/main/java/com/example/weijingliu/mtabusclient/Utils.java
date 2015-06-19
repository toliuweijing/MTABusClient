package com.example.weijingliu.mtabusclient;

import android.content.res.Resources;
import android.location.Location;

import com.example.weijingliu.mtabusclient.nearbybus.NearbyBusAdapter;
import com.obanyc.api.local.Primitives;
import com.obanyc.api.where.stopsforlocation.Stop;
import com.obanyc.api.where.stopsforlocation.StopsForLocationRoot;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {
  public static int px(int dp) {
    return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
  }

  public static float distanceTo(
      Location a,
      double latitude,
      double longitude) {
    Location stopLocation = new Location("n/a");
    stopLocation.setLatitude(latitude);
    stopLocation.setLongitude(longitude);
    return a.distanceTo(stopLocation);
  }

  public static float distanceTo(Location a, Stop stop) {
    return distanceTo(a, stop.getLat(), stop.getLon());
  }

  public static String toTimeString(Primitives.Schedule schedule) {
    Date date = new Date(schedule.arrivalTime());
    return new SimpleDateFormat("hh:mm a").format(date);
  }

  public static String toTimeString(long time) {
    Date date = new Date(time);
    return new SimpleDateFormat("hh:mm:ss a").format(date);
  }
}
