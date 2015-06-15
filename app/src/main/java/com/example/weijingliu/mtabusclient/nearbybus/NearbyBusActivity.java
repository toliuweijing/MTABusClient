package com.example.weijingliu.mtabusclient.nearbybus;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.weijingliu.mtabusclient.alarm.AlarmViewerFragment;
import com.example.weijingliu.mtabusclient.R;
import com.obanyc.api.ObaService;
import com.obanyc.api.where.stopsforlocation.StopsForLocationRoot;

import retrofit.Callback;
import retrofit.RetrofitError;

public class NearbyBusActivity extends AppCompatActivity {
  private static final String TAG = NearbyBusActivity.class.getSimpleName();

  private DrawerLayout mDrawerLayout;
  private ActionBarDrawerToggle mActionBarDrawerToggle;
  private NavigationView mNavigationView;
  private Toolbar mToolbar;
  private NearbyBusFragment mNearbyBusFragment;
  private AlarmViewerFragment mAlarmViewerFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_nearby);

    init();

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

    // config
    setSupportActionBar(mToolbar);
    mNavigationView.setNavigationItemSelectedListener(
        new NavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(MenuItem menuItem) {
            Log.d("TAG", menuItem.getTitle() + " selected");
            final int id = menuItem.getItemId();

            if (id == R.id.bus) {
              pushNearbyBusFragment();
            }
            if (id == R.id.alarm) {
              pushAlarmViewerFragment();
            }

            menuItem.setChecked(true);
            mDrawerLayout.closeDrawers();
            return true;
          }
        });
    mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

    pushNearbyBusFragment();
  }

  private void pushNearbyBusFragment() {
    if (mNearbyBusFragment == null) {
      mNearbyBusFragment = new NearbyBusFragment();
    }

    getSupportFragmentManager()
        .beginTransaction()
        .replace(
            R.id.fragment_holder,
            mNearbyBusFragment)
        .commit();

    getSupportActionBar().setTitle("Nearby Buses");
  }

  private void pushAlarmViewerFragment() {
    if (mAlarmViewerFragment == null) {
      mAlarmViewerFragment = new AlarmViewerFragment();
    }
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.fragment_holder,
            mAlarmViewerFragment)
        .commit();

    getSupportActionBar().setTitle("Alarms");
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
}
