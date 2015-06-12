package com.example.weijingliu.mtabusclient.nearbybus;

import android.content.Intent;
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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.weijingliu.mtabusclient.NextBusActivity;
import com.example.weijingliu.mtabusclient.R;
import com.obanyc.api.ObaService;
import com.obanyc.api.where.stopsforlocation.StopsForLocationRoot;

import org.json.JSONObject;

import retrofit.Callback;
import retrofit.RetrofitError;

public class NearbyActivity extends AppCompatActivity implements NearbyBusAdapter.Listener {
  private static final String TAG = NearbyActivity.class.getSimpleName();

  private DrawerLayout mDrawerLayout;
  private ActionBarDrawerToggle mActionBarDrawerToggle;
  private NavigationView mNavigationView;
  private Toolbar mToolbar;
  private RecyclerView mRecyclerView;
  private LinearLayoutManager mLinearLayoutManager;
  private NearbyBusAdapter mNearbyBusAdapter;

  private RequestQueue mRequestQueue;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_nearby);

    init();
//    testApi();
    testRetrofit();
  }

  private void init() {
    // instantiate
    mRequestQueue = Volley.newRequestQueue(this);
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