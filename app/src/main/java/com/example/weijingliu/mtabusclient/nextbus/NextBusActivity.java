package com.example.weijingliu.mtabusclient.nextbus;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.weijingliu.mtabusclient.LocationUtil;
import com.example.weijingliu.mtabusclient.R;
import com.example.weijingliu.mtabusclient.Utils;
import com.example.weijingliu.mtabusclient.alarm.AlarmStore;
import com.example.weijingliu.mtabusclient.alarm.Models.Alarm;
import com.example.weijingliu.mtabusclient.alarm.service.NearAlarmService;
import com.example.weijingliu.mtabusclient.alarm.service.NotifyScheduleTimeReceiver;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.obanyc.api.LocalService;
import com.obanyc.api.local.Primitives.Schedule;
import com.obanyc.api.local.Queries.RouteStopDirectionSchedules;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class NextBusActivity extends AppCompatActivity implements OnMapReadyCallback {
  //TODO
  private NextBusAdapter mNextBusAdapter;
  private LinearLayoutManager mLinearLayoutManager;
  private RecyclerView mRecyclerView;
  private Toolbar mToolbar;
  private FloatingActionButton mFloatingActionButton;
  private FrameLayout mRootLayout;
  private Config mConfig;
  private MapFragment mMapFragment;
  private RouteStopDirectionSchedules mRouteStopDirectionSchedules;
  private LocationUtil mLocationUtil;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_next_bus);

    mLocationUtil = new LocationUtil(this);
    init();
    testApi();
  }

  private void testApi() {
    Log.d("jing", mConfig.toString());

    LocalService.instance.routeStopDirectionSchedule(
        mLocationUtil.pollLocation(),
        mConfig.getRouteId(),
        mConfig.getDirectionId())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<RouteStopDirectionSchedules>() {
          @Override
          public void onCompleted() {
            Log.d("jing", "a");
          }

          @Override
          public void onError(Throwable e) {
            Log.d("jing", e.getMessage());

          }

          @Override
          public void onNext(RouteStopDirectionSchedules routeStopDirectionSchedules) {
            Log.d("jing", "yesssssssssssss");

            mRouteStopDirectionSchedules = routeStopDirectionSchedules;
            updateMap();

            String title = routeStopDirectionSchedules.route().shortName() + " - " +
                routeStopDirectionSchedules.direction().destination();
            mToolbar.setTitle(title);
            mNextBusAdapter.setSchedules(routeStopDirectionSchedules);
          }
        });
  }

  private void updateMap() {
    GoogleMap map = mMapFragment.getMap();
    if (mRouteStopDirectionSchedules == null || map == null) {
      return;
    }
    LatLng coordinate = new LatLng(
        mRouteStopDirectionSchedules.stop().lat(),
        mRouteStopDirectionSchedules.stop().lon());

    Marker newmarker = map.addMarker(
        new MarkerOptions()
            .position(coordinate)
            .title(mRouteStopDirectionSchedules.stop().name())
            .snippet(mRouteStopDirectionSchedules.route().shortName()));
    newmarker.showInfoWindow();
    CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 18);
    map.animateCamera(yourLocation);
  }

  private void init() {
    mMapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map_fragment);
    mRootLayout = (FrameLayout) findViewById(R.id.root_layout);
    mConfig = getIntent().getParcelableExtra(Config.TAG);
    mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
    mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    mLinearLayoutManager = new LinearLayoutManager(this);
    mNextBusAdapter = new NextBusAdapter();
    mRecyclerView.setAdapter(mNextBusAdapter);
    mRecyclerView.setLayoutManager(mLinearLayoutManager);

    mRecyclerView.addOnScrollListener(
        new RecyclerView.OnScrollListener() {
          @Override
          public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
          }

          @Override
          public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
          }
        }
    );

    mToolbar = (Toolbar) findViewById(R.id.toolbar);

    setSupportActionBar(mToolbar);

    // config
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    mMapFragment.getMapAsync(this);

    mFloatingActionButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            onFloatingActionButtonClicked();
          }
        });
  }

  private void onFloatingActionButtonClicked() {
    if (mRouteStopDirectionSchedules == null) {
      Toast
          .makeText(this, "Something went wrong. Try again later", Toast.LENGTH_LONG)
          .show();
      return;
    }

    Log.d("jing-stopIndex", String.valueOf(mRouteStopDirectionSchedules.stopIndex()));
    onNearAlarmSelected();
  }

  private void onNearAlarmSelected() {
    int stopAway = 2;
    Schedule schedule = mNextBusAdapter.getNextSchedule();
    if (schedule == null) {
      // No bus available today.
      return;
    }
    Alarm alarm = Alarm.ofNear(
        mRouteStopDirectionSchedules.route(),
        mRouteStopDirectionSchedules.stop(),
        stopAway,
        schedule.arrivalTime());
    AlarmStore.instance.add(alarm);

    NearAlarmService.refreshService(this);

    Snackbar
        .make(
            mRootLayout,
            String.format(
                "An alarm is set for the next approaching bus within %d stops",
                stopAway),
            Snackbar.LENGTH_LONG)
        .show();
  }

  private void onTimeAlarmSelected() {
    Schedule schedule = mNextBusAdapter.getNextSchedule();
    if (schedule == null) {
      return;
    }
    Alarm alarm = Alarm.ofTime(
        mRouteStopDirectionSchedules.route(),
        mRouteStopDirectionSchedules.stop(),
        schedule.departureTime());
    AlarmStore.instance.add(alarm);
    setupAlarmManager(mRouteStopDirectionSchedules, schedule.departureTime());

    Snackbar
        .make(
            mRootLayout,
            String.format(
                "An alarm is set at %s",
                Utils.toTimeString(schedule.departureTime())),
            Snackbar.LENGTH_LONG)
        .setAction("UNDO", new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Snackbar.make(mRootLayout, "Removed", Snackbar.LENGTH_SHORT).show();
          }
        })
        .show();
  }

  private void setupAlarmManager(
      RouteStopDirectionSchedules routeStopDirectionSchedules,
      long time) {
    NotifyScheduleTimeReceiver.Config config = new NotifyScheduleTimeReceiver.Config(
        routeStopDirectionSchedules.route().id(),
        routeStopDirectionSchedules.route().shortName(),
        routeStopDirectionSchedules.stop().id(),
        routeStopDirectionSchedules.stop().name());
    Intent intent = new Intent(this, NotifyScheduleTimeReceiver.class);
    intent.putExtra(NotifyScheduleTimeReceiver.EXTRA_CONFIG, config);
    PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);
    Log.d("jing", "alarm setup");
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int itemId = item.getItemId();

    if (itemId == android.R.id.home) {
      finish();
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_nextbus, menu);
    return true;
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    googleMap.setMyLocationEnabled(true);
    updateMap();
  }
}
