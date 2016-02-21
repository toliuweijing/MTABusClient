package com.example.weijingliu.mtabusclient.nearbybus;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weijingliu.mtabusclient.LocationUtils;
import com.example.weijingliu.mtabusclient.R;
import com.example.weijingliu.mtabusclient.common.HorizontalDividerItemDecoration;
import com.example.weijingliu.mtabusclient.nextbus.Config;
import com.example.weijingliu.mtabusclient.nextbus.NextBusActivity;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.obanyc.api.LocalService;
import com.obanyc.api.local.Primitives;
import com.obanyc.api.local.Queries;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class NearbyBusFragment extends Fragment implements NearbyBusAdapter.Listener {
  private RecyclerView mRecyclerView;
  private NearbyBusAdapter mNearbyBusAdapter;
  private LinearLayoutManager mLinearLayoutManager;
  private FloatingActionButton mFab;
  private LocationUtils mLocationUtils;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mLocationUtils = new LocationUtils(getActivity());
    testLocalService();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.nearby_bus_fragment_layout, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    mNearbyBusAdapter = new NearbyBusAdapter();
    mLinearLayoutManager = new LinearLayoutManager(getActivity());
    mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);

    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(mLinearLayoutManager);
    mRecyclerView.setAdapter(mNearbyBusAdapter);
    mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration());
    mNearbyBusAdapter.setListener(this);

    mFab = (FloatingActionButton) view.findViewById(R.id.fab);
    mFab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onFloatingActionButtonClicked();
      }
    });
  }

  private void onFloatingActionButtonClicked() {
    showEmptyList();

    maybeAlertLocationSettings();
    Futures.addCallback(
        mLocationUtils.pollAccurateLocation(),
        new FutureCallback<Location>() {
          @Override
          public void onSuccess(Location result) {
            fetchWithLocation(result);
          }

          @Override
          public void onFailure(Throwable t) {
          }
        }
    );
  }

  private void showEmptyList() {
    mNearbyBusAdapter.setRouteDirections(new ArrayList<Queries.RouteDirections>());
  }

  @Override
  public void onDestinationClick(
      Queries.RouteDirections routeDirections, Primitives.Direction direction) {
    Intent intent = new Intent();
    intent.putExtra(Config.TAG, new Config(routeDirections.route().id(), direction.id()));
    intent.setClass(getActivity(), NextBusActivity.class);
    startActivity(intent);
  }

  private void testLocalService() {
    maybeAlertLocationSettings();
    Location location = mLocationUtils.pollLocation();
    fetchWithLocation(location);
  }

  private void maybeAlertLocationSettings() {
    if (!mLocationUtils.isLocationSettingsEnabled()) {
      new LocationAlertDialogFragment().show(getFragmentManager(), "");
    }
  }

  private void fetchWithLocation(Location location) {
    if (location == null) {
      return;
    }
    LocalService.instance.nearbyRouteDirections(location).toList()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<List<Queries.RouteDirections>>() {
          @Override
          public void onCompleted() {

          }

          @Override
          public void onError(Throwable e) {

          }

          @Override
          public void onNext(List<Queries.RouteDirections> routeDirectionses) {
            mNearbyBusAdapter.setRouteDirections(routeDirectionses);
          }
        });
  }
}
