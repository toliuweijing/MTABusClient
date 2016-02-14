package com.example.weijingliu.mtabusclient;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

public class LocationUtils {
  public static Location pollLocation(Context context) {
    LocationManager locationManager = (LocationManager) context.getSystemService(
        Context.LOCATION_SERVICE);
    Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
    return location;
  }

  public static boolean isLocationSettingsEnabled(Context context) {
    LocationManager locationManager = (LocationManager) context.getSystemService(
            Context.LOCATION_SERVICE);
    return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) &&
            locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
  }

  public static ListenableFuture<Location> pollAccurateLocation(Context context) {
      if (!isLocationSettingsEnabled(context)) {
          return Futures.immediateFailedFuture(new Throwable("no location enabled"));
      }

      final SettableFuture<Location> future = SettableFuture.create();

      LocationManager locationManager = (LocationManager) context.getSystemService(
              Context.LOCATION_SERVICE);

      locationManager.requestSingleUpdate(
              LocationManager.NETWORK_PROVIDER,
              new LocationListener() {
                  @Override
                  public void onLocationChanged(Location location) {
                    future.set(location);
                  }

                  @Override
                  public void onStatusChanged(String provider, int status, Bundle extras) {
                  }

                  @Override
                  public void onProviderEnabled(String provider) {

                  }

                  @Override
                  public void onProviderDisabled(String provider) {

                  }
              },
              Looper.getMainLooper());
      return future;
  }

}
