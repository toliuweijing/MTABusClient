package com.obanyc.api;

import android.location.Location;
import android.util.Log;

import com.google.common.util.concurrent.FutureCallback;
import com.obanyc.api.local.Queries;
import com.obanyc.api.where.stopsforlocation.StopsForLocationRoot;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

public class LocalService {
  private static final String TAG = LocalService.class.getSimpleName();

  public static final LocalService instance = new LocalService();

  public void nearbyBusQuery(
      Location location,
      final FutureCallback<Queries.NearbyBusQuery> callback) {
    Observable<StopsForLocationRoot> observable = ObaService.getClient().getStopsForLocation(
        location.getLatitude(),
        location.getLongitude());
    observable.subscribe(new Observer<StopsForLocationRoot>() {
      @Override
      public void onCompleted() {
        Log.d(TAG, "onCompleted");
      }

      @Override
      public void onError(Throwable e) {
        callback.onFailure(e);
      }

      @Override
      public void onNext(StopsForLocationRoot stopsForLocationRoot) {
        callback.onSuccess(null);
      }
    });
  }
}
