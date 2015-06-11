package com.example.weijingliu.mtabusclient;

import android.content.res.Resources;

import com.example.weijingliu.mtabusclient.nearbybus.NearbyBusAdapter;
import com.obanyc.api.where.stopsforlocation.StopsForLocationRoot;

import java.util.ArrayList;
import java.util.List;

public class Utils {
  public static int px(int dp) {
    return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
  }

  public static List<NearbyBusAdapter.Model> toNearbyBusAdapterModels(StopsForLocationRoot root) {
    List<NearbyBusAdapter.Model> models = new ArrayList<>();
    return models;
  }
}
