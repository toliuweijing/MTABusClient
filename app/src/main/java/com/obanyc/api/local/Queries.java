package com.obanyc.api.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import java.util.List;

public class Queries {
  @AutoValue
  public abstract static class NearbyBusQuery {
    abstract List<RouteStopDirection> routeStopDirections();

    @AutoValue.Builder
    abstract static class Builder {
      abstract Builder routeStopDirections(List<RouteStopDirection> a);
      abstract NearbyBusQuery build();
    }
  }

  @AutoValue
  public abstract static class RouteStopDirection {

  }
}
