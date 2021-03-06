package com.example.weijingliu.mtabusclient.nearbybus;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.weijingliu.mtabusclient.R;
import com.example.weijingliu.mtabusclient.VersionUpdateDialogFragment;
import com.example.weijingliu.mtabusclient.alarm.AlarmViewerFragment;
import com.obanyc.api.ObaService;
import com.obanyc.api.where.stopsforlocation.StopsForLocationRoot;

import javax.annotation.Nullable;

import retrofit.Callback;
import retrofit.RetrofitError;

public class NearbyBusActivity extends AppCompatActivity {
  private static final String TAG = NearbyBusActivity.class.getSimpleName();

  private static final String DRAWER_ITEM_ID = "drawer_item_id";

  private DrawerLayout mDrawerLayout;
  private NavigationView mNavigationView;
  private Toolbar mToolbar;
  private NearbyBusFragment mNearbyBusFragment;
  private AlarmViewerFragment mAlarmViewerFragment;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_nearby);

    // ensure references
    mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    mNavigationView = (NavigationView) findViewById(R.id.navigation_view);

    // configure
    setSupportActionBar(mToolbar);
    mNavigationView.setNavigationItemSelectedListener(
        new NavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(MenuItem menuItem) {
            Log.d("TAG", menuItem.getTitle() + " selected");
            setCurrentMenuItem(menuItem);
            return true;
          }
        });

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

    int menuItemId = R.id.bus;
    menuItemId = getIntent().getIntExtra(DRAWER_ITEM_ID, menuItemId);
    if (savedInstanceState != null) {
      menuItemId = savedInstanceState.getInt(DRAWER_ITEM_ID, menuItemId);
    }
    MenuItem menuItem = mNavigationView.getMenu().findItem(menuItemId);
    setCurrentMenuItem(menuItem);
  }

  @Override
  protected void onStart() {
    super.onStart();
    VersionUpdateDialogFragment.showVersionUpdateIfNeeded(this, getFragmentManager());
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putInt(DRAWER_ITEM_ID, findCheckedMenuItem().getItemId());
  }

  private MenuItem findCheckedMenuItem() {
    for (int i = 0 ; i < mNavigationView.getMenu().size(); ++i) {
      MenuItem item = mNavigationView.getMenu().getItem(i);
      if (item.isChecked()) {
        return item;
      }
    }
    throw new IllegalStateException("at least one item should be checked");
  }

  private void setCurrentMenuItem(MenuItem menuItem) {
    final int id = menuItem.getItemId();

    if (id == R.id.bus) {
      pushNearbyBusFragment();
      menuItem.setChecked(true);
    }
    if (id == R.id.alarm) {
      pushAlarmViewerFragment();
      menuItem.setChecked(true);
    }
    if (id == R.id.contact_me) {
      handleContactMe();
    }

    mDrawerLayout.closeDrawers();
  }

  private void handleContactMe() {
    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fb.me/msg/busggg"));
    Intent chooser = Intent.createChooser(i, "Choose your browser");
    startActivity(chooser);
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

    if (id == android.R.id.home) {
      Log.d(TAG, "Toolbar's home clicked");
      mDrawerLayout.openDrawer(Gravity.START);
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  public static class IntentFactory {
    public static Intent alarmViewer(Context context) {
      Intent i = new Intent(context, NearbyBusActivity.class);
      i.putExtra(DRAWER_ITEM_ID, R.id.alarm);
      return i;
    }
  }
}
