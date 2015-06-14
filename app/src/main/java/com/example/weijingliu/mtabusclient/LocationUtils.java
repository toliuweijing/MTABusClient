package com.example.weijingliu.mtabusclient;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

public class LocationUtils {
  public static Location pollLocation(Context context) {
    LocationManager locationManager = (LocationManager) context.getSystemService(
        Context.LOCATION_SERVICE);
    Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
    if (location == null) {
      location = new Location("MOCK");
      location.setLatitude(40.6382);
      location.setLongitude(-74.0345);
      location.setAltitude(6.99672);
      location.setAccuracy(100);
    }
    return location;
  }

}
