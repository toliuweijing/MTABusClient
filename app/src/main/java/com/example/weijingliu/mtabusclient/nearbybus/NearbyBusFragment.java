package com.example.weijingliu.mtabusclient.nearbybus;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weijingliu.mtabusclient.R;
import com.example.weijingliu.mtabusclient.common.HorizontalDividerItemDecoration;
import com.example.weijingliu.mtabusclient.nextbus.Config;
import com.example.weijingliu.mtabusclient.nextbus.NextBusActivity;
import com.obanyc.api.LocalService;
import com.obanyc.api.local.Primitives;
import com.obanyc.api.local.Queries;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

import static com.example.weijingliu.mtabusclient.LocationUtils.pollLocation;

public class NearbyBusFragment extends Fragment implements NearbyBusAdapter.Listener {
  private RecyclerView mRecyclerView;
  private NearbyBusAdapter mNearbyBusAdapter;
  private LinearLayoutManager mLinearLayoutManager;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

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
    Location location = pollLocation(getActivity());
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
