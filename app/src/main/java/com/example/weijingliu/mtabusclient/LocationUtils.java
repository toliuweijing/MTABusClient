package com.example.weijingliu.mtabusclient;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

public class LocationUtils {

  private static final String LOCATION_PROVIDER =
      BuildConfig.DEBUG ?
          LocationManager.GPS_PROVIDER :
          LocationManager.NETWORK_PROVIDER;

  private final Context mContext;

  public LocationUtils(Context context) {
    mContext = context;
  }

  public Location pollLocation() {
    LocationManager locationManager = (LocationManager) mContext.getSystemService(
        Context.LOCATION_SERVICE);
    Location location = locationManager.getLastKnownLocation(LOCATION_PROVIDER);
    return location;
  }

  public boolean isLocationSettingsEnabled() {
    LocationManager locationManager = (LocationManager) mContext.getSystemService(
        Context.LOCATION_SERVICE);
    return locationManager.isProviderEnabled(LOCATION_PROVIDER);
  }

  public ListenableFuture<Location> pollAccurateLocation() {
    if (!isLocationSettingsEnabled()) {
      return Futures.immediateFailedFuture(new Throwable("no location enabled"));
    }

    final SettableFuture<Location> future = SettableFuture.create();

    LocationManager locationManager = (LocationManager) mContext.getSystemService(
        Context.LOCATION_SERVICE);

    locationManager.requestSingleUpdate(
        LOCATION_PROVIDER,
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
