package com.example.weijingliu.mtabusclient.rest.service;

import com.siri.model.StopMonitoringDeliveryRoot;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface SiriApi {
//  @GET("/api/siri/stop-monitoring.json?key=cfb3c75b-5a43-4e66-b7f8-14e666b0c1c1&MonitoringRef=307200")
  @GET("/api/siri/stop-monitoring.json")
  StopMonitoringDeliveryRoot getStopMonitoring(
      @Query("Key") String key,
      @Query("MonitoringRef") String monitoringRef);

  @GET("/api/siri/stop-monitoring.json?key=cfb3c75b-5a43-4e66-b7f8-14e666b0c1c1&MonitoringRef=307200")
  void getSample(Callback<StopMonitoringDeliveryRoot> callback);
}
