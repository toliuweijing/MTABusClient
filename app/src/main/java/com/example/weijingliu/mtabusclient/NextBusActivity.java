package com.example.weijingliu.mtabusclient;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

public class NextBusActivity extends AppCompatActivity {
  //TODO
  private NextBusAdapter mNextBusAdapter;
  private LinearLayoutManager mLinearLayoutManager;
  private RecyclerView mRecyclerView;
  private CollapsingToolbarLayout mCollapsingToolbarLayout;
  private Toolbar mToolbar;
  private FloatingActionButton mFloatingActionButton;
  private CoordinatorLayout mCoordinatorLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_next_bus);

    init();
  }

  private void init() {
    mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
    mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
    mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    mLinearLayoutManager = new LinearLayoutManager(this);
    mNextBusAdapter = new NextBusAdapter();
    mRecyclerView.setAdapter(mNextBusAdapter);
    mRecyclerView.setLayoutManager(mLinearLayoutManager);

    mCollapsingToolbarLayout = (CollapsingToolbarLayout)
        findViewById(R.id.collapsing_toolbar_layout);
    mCollapsingToolbarLayout.setTitle("Kings Plaza");

    mToolbar = (Toolbar) findViewById(R.id.toolbar);

    setSupportActionBar(mToolbar);

    // config
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    CoordinatorLayout.LayoutParams layoutParams =
        (CoordinatorLayout.LayoutParams) mFloatingActionButton.getLayoutParams();
    layoutParams.setAnchorId(R.id.recycler_view);
    layoutParams.anchorGravity = Gravity.RIGHT;
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
