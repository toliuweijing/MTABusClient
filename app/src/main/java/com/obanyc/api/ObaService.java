package com.obanyc.api;

import com.obanyc.api.siri.StopMonitoringRoot;
import com.obanyc.api.where.ScheduleForStopRoot;
import com.obanyc.api.where.StopsForLocationRoot;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public class ObaService {
  private static final ObaService instance = new ObaService();

  private final RestAdapter mRestAdapter;
  private final Client mClient;

  private ObaService() {
    mRestAdapter = new RestAdapter.Builder()
        .setEndpoint("http://api.prod.obanyc.com")
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .build();

    mClient = mRestAdapter.create(Client.class);
  }

  public static Client getClient() {
    return instance.mClient;
  }

  public interface Client {
    @GET("/api/siri/stop-monitoring.json")
    StopMonitoringRoot getStopMonitoring(
        @Query("Key") String key,
        @Query("MonitoringRef") String monitoringRef);

    @GET("/api/siri/stop-monitoring.json?key=cfb3c75b-5a43-4e66-b7f8-14e666b0c1c1&MonitoringRef=307200")
    void getStopMonitoring(Callback<StopMonitoringRoot> callback);


    @GET("/api/where/schedule-for-stop/MTA_307200.json?key=test")
    void getScheduleForStop(Callback<ScheduleForStopRoot> callback);

    @GET("/api/where/schedule-for-stop/{stopref}.json")
    void getScheduleForStop(
        @Path("stopref") String stopRef,
        @Query("key") String key,
        Callback<ScheduleForStopRoot> callback);

    @GET("/api/where/stops-for-location.json?lat=40.638243&lon=-74.034466&latSpan=0.005&lonSpan=0.005&key=test")
    void getStopsForLocation(Callback<StopsForLocationRoot> callback);
  }
}
