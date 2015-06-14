package com.example.weijingliu.mtabusclient.nextbus;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.weijingliu.mtabusclient.R;
import com.obanyc.api.LocalService;
import com.obanyc.api.local.Queries;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

import static com.example.weijingliu.mtabusclient.LocationUtils.pollLocation;

public class NextBusActivity extends AppCompatActivity {
  //TODO
  private NextBusAdapter mNextBusAdapter;
  private LinearLayoutManager mLinearLayoutManager;
  private RecyclerView mRecyclerView;
  private CollapsingToolbarLayout mCollapsingToolbarLayout;
  private Toolbar mToolbar;
  private FloatingActionButton mFloatingActionButton;
  private CoordinatorLayout mCoordinatorLayout;
  private Config mConfig;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_next_bus);

    init();
    testApi();
  }

  private void testApi() {
    Log.d("jing", mConfig.toString());

    LocalService.instance.routeStopDirectionSchedule(
        pollLocation(this),
        mConfig.getRouteId(),
        mConfig.getDirectionId())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<Queries.RouteStopDirectionSchedules>() {
          @Override
          public void onCompleted() {
            Log.d("jing", "a");
          }

          @Override
          public void onError(Throwable e) {
            Log.d("jing", e.getMessage());

          }

          @Override
          public void onNext(Queries.RouteStopDirectionSchedules routeStopDirectionSchedules) {
            Log.d("jing", "yesssssssssssss");

            String title = routeStopDirectionSchedules.route().shortName() + " - " +
                routeStopDirectionSchedules.direction().destination();
            mCollapsingToolbarLayout.setTitle(title);
            mToolbar.setTitle(title);
            mToolbar.setTitleTextColor(Color.BLUE);
            mNextBusAdapter.setSchedules(routeStopDirectionSchedules);
          }
        });
  }

  private void init() {
    mConfig = getIntent().getParcelableExtra(Config.TAG);
    mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
    mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
    mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    mLinearLayoutManager = new LinearLayoutManager(this);
    mNextBusAdapter = new NextBusAdapter();
    mRecyclerView.setAdapter(mNextBusAdapter);
    mRecyclerView.setLayoutManager(mLinearLayoutManager);

    mCollapsingToolbarLayout = (CollapsingToolbarLayout)
        findViewById(R.id.collapsing_toolbar_layout);

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
    CoordinatorLayout.LayoutParams layoutParams =
        (CoordinatorLayout.LayoutParams) mFloatingActionButton.getLayoutParams();
    layoutParams.setAnchorId(R.id.recycler_view);
    layoutParams.anchorGravity = Gravity.RIGHT;

    mFloatingActionButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Snackbar
                .make(mCoordinatorLayout, "An alarm is set at 1:00am", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                    Snackbar.make(mCoordinatorLayout, "Removed", Snackbar.LENGTH_SHORT).show();
                  }
                })
                .show();
          }
        });
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
}
