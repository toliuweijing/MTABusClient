package com.example.weijingliu.mtabusclient.nearbybus;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.weijingliu.mtabusclient.NextBusActivity;
import com.example.weijingliu.mtabusclient.R;
import com.google.common.util.concurrent.FutureCallback;
import com.obanyc.api.LocalService;
import com.obanyc.api.ObaService;
import com.obanyc.api.local.Queries;
import com.obanyc.api.where.stopsforlocation.StopsForLocationRoot;

import retrofit.Callback;
import retrofit.RetrofitError;

public class NearbyBusActivity extends AppCompatActivity implements NearbyBusAdapter.Listener {
  private static final String TAG = NearbyBusActivity.class.getSimpleName();

  private DrawerLayout mDrawerLayout;
  private ActionBarDrawerToggle mActionBarDrawerToggle;
  private NavigationView mNavigationView;
  private Toolbar mToolbar;
  private RecyclerView mRecyclerView;
  private LinearLayoutManager mLinearLayoutManager;
  private NearbyBusAdapter mNearbyBusAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_nearby);

    init();
//    testApi();
//    testRetrofit();
    testLocalService();
  }

  private void testLocalService() {
    LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
    LocalService.instance.nearbyBusQuery(location, new FutureCallback<Queries.NearbyBusQuery>() {
      @Override
      public void onSuccess(Queries.NearbyBusQuery result) {
        Log.d(TAG, "LocalServiceNearbyQuery");
      }

      @Override
      public void onFailure(Throwable t) {
        Log.d(TAG, t.getMessage());
      }
    });
  }

  private void init() {
    // instantiate
    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    mActionBarDrawerToggle = new ActionBarDrawerToggle(
        this,
        mDrawerLayout,
        R.drawable.ic_drawer,
        R.drawable.ic_drawer);
    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
    mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    mLinearLayoutManager = new LinearLayoutManager(this);
    mNearbyBusAdapter = new NearbyBusAdapter();

    // config
    setSupportActionBar(mToolbar);
    mNavigationView.setNavigationItemSelectedListener(
        new NavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(MenuItem menuItem) {
            Log.d("TAG", menuItem.getTitle() + " selected");
            menuItem.setChecked(true);
            return true;
          }
        });
    mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(mLinearLayoutManager);
    mRecyclerView.setAdapter(mNearbyBusAdapter);
    mRecyclerView.addItemDecoration(new NearbyBusAdapter.SimpleDividerItemDecoration());
    mNearbyBusAdapter.setListener(this);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
  }

  private void testRetrofit() {
//    ObaService.getClient().getScheduleForStop(
//        "MTA_307200",
//        "test",
//        new Callback<ScheduleForStopRoot>() {
//          @Override
//          public void success(ScheduleForStopRoot scheduleForStopRoot, retrofit.client.Response response) {
//            Log.d(TAG, "ScheduleForStopRoot");
//          }
//
//          @Override
//          public void failure(RetrofitError error) {
//            Log.d(TAG, error.getMessage());
//          }
//        }
//    );
    ObaService.getClient().getStopsForLocation(
        new Callback<StopsForLocationRoot>() {
          @Override
          public void success(StopsForLocationRoot stopsForLocationRoot, retrofit.client.Response response) {
            Log.d(TAG, "StopsForLocation");
          }

          @Override
          public void failure(RetrofitError error) {
            Log.d(TAG, error.getMessage());
          }
        });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_nearby, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    if (id == android.R.id.home) {
      Log.d(TAG, "Toolbar's home clicked");
      mDrawerLayout.openDrawer(Gravity.START);
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public void onRouteSelected() {
    Intent intent = new Intent();
    intent.setClass(this, NextBusActivity.class);
    startActivity(intent);
  }
}
