package com.example.weijingliu.mtabusclient.common;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by toliuweijing on 6/14/15.
 */
public class HorizontalDividerItemDecoration extends RecyclerView.ItemDecoration {
  public static final int DEFAULT_COLOR = Color.LTGRAY;

  private final Drawable mDivider;
  private final int mPaddingLeft;
  private final int mPaddingRight;

  public HorizontalDividerItemDecoration() {
    mDivider = new ColorDrawable(DEFAULT_COLOR);
    mPaddingLeft = 0;
    mPaddingRight = 0;
  }

  public HorizontalDividerItemDecoration(int color, int paddingLeft, int paddingRight) {
    mDivider = new ColorDrawable(color);
    mPaddingLeft = paddingLeft;
    mPaddingRight = paddingRight;
  }

  @Override
  public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
    final int dividerHeight = 1;
    int left = parent.getPaddingLeft() + mPaddingLeft;
    int right = parent.getWidth() - parent.getPaddingRight() - mPaddingRight;

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
