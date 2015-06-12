package com.obanyc.api;

import com.obanyc.api.siri.StopMonitoringRoot;
import com.obanyc.api.where.scheduleforstop.ScheduleForStopRoot;
import com.obanyc.api.where.stopsforlocation.StopsForLocationRoot;
import com.obanyc.api.where.stopsforroute.StopsForRouteRoot;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public class ObaService {
  private static final ObaService instance = new ObaService();

  private static final String KEY = "cfb3c75b-5a43-4e66-b7f8-14e666b0c1c1";
  private static final String END_POINT = "http://api.prod.obanyc.com";

  private final RestAdapter mRestAdapter;
  private final Client mClient;

  private ObaService() {
    RequestInterceptor interceptor = new RequestInterceptor() {
      @Override
      public void intercept(RequestFacade request) {
        request.addQueryParam("key",  KEY);
      }};

    mRestAdapter = new RestAdapter.Builder()
        .setEndpoint(END_POINT)
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setRequestInterceptor(interceptor)
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

    @GET("/api/where/stops-for-location.json")
    Observable<StopsForLocationRoot> getStopsForLocation(
        @Query("lat") double latitude,
        @Query("lon") double longitude);

    @GET("/api/where/stops-for-route/MTA%20NYCT_B9.json?key=test&includePolylines=false&version=2")
    Observable<StopsForRouteRoot> getStopsForRoute();

    @GET("/api/where/stops-for-route/{routeId}.json?includePolylines=false&version=2")
    Observable<StopsForRouteRoot> getStopsForRoute(
        @Path("routeId") String routeId);
  }

}

//    http://bustime.mta.info/api/where/stops-for-location.json?lat=40.638243&lon=-74.034466&radius=1000&key=test
