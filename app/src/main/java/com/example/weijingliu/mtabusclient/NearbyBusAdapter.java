package com.example.weijingliu.mtabusclient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class NearbyBusAdapter extends RecyclerView.Adapter<NearbyBusAdapter.ViewHolder> {
  private static final String TAG = NearbyBusAdapter.class.getSimpleName();

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    Log.d(TAG, "onCreateViewHolder");
    FrameLayout frameLayout = (FrameLayout) LayoutInflater
        .from(viewGroup.getContext())
        .inflate(
            R.layout.nearby_bus_row_layout,
            viewGroup,
            false);

    assert frameLayout != null;
    return new ViewHolder(frameLayout);
  }

  @Override
  public void onBindViewHolder(ViewHolder viewHolder, int i) {

  }

  @Override
  public int getItemCount() {
    Log.d(TAG, "getItemCount");
    return 3;
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(View view) {
      super(view);
    }
  }

  public static class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;

    public SimpleDividerItemDecoration() {
      mDivider = new ColorDrawable(Color.LTGRAY);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
      final int dividerHeight = 1;
      int left = parent.getPaddingLeft();
      int right = parent.getWidth() - parent.getPaddingRight();

      int childCount = parent.getChildCount();
      for (int i = 0; i < childCount; i++) {
        View child = parent.getChildAt(i);

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

        int top = child.getBottom() + params.bottomMargin;
        int bottom = top + dividerHeight;

        mDivider.setBounds(left, top, right, bottom);
        mDivider.draw(c);
      }
    }
  }
}
