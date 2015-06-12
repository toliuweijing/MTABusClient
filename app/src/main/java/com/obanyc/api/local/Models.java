package com.obanyc.api.local;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import java.util.List;

public class Models {
  @AutoValue
  abstract static class NearbyBusQuery {
    abstract List<RouteStopDirection> routeStopDirections();

    @AutoValue.Builder
    abstract static class Builder {
      abstract Builder routeStopDirections(RouteStopDirection a);
      abstract Builder build();
    }
  }

  @AutoValue
  abstract static class RouteStopDirection {

  }

  @AutoValue
  abstract static class

}
