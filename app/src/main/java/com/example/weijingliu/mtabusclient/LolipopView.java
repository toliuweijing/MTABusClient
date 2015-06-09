package com.example.weijingliu.mtabusclient;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import static com.example.weijingliu.mtabusclient.Utils.px;

public class LolipopView extends View {
  private final int STROKE_WIDTH_DP = 2;
  private final int CIRCLE_MARGIN_DP = 4;

  private int mCircleColor = Color.BLUE;
  private int mLineColor = Color.parseColor("#E0E0E0");

  private Paint mPaint = new Paint();

  public static final int APPEARANCE_PADDING = 1;
  public static final int APPEARANCE_REGULAR = 1<<1;
  private int mAppearance = APPEARANCE_REGULAR;

  public LolipopView(Context context) {
    this(context, null);
  }

  public LolipopView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public LolipopView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public void setAppearance(int appearance) {
    mAppearance = appearance;
    requestLayout();
  }

  public void setCircleColor(int circleColor) {
    mCircleColor = circleColor;
  }

  @Override
  protected void onDraw(Canvas canvas) {
    int left = 0;
    int top = 0;
    int right = getWidth();
    int bottom = getHeight();
    int centerX = (left + right) / 2;
    int centerY = (top + bottom) / 2;
    int radius = getWidth() / 2;
    int strokeOffset = px(STROKE_WIDTH_DP);
    int circleTop = centerY - radius + strokeOffset;
    int circleBottom = centerY + radius - strokeOffset;
    int circleLeft = left + strokeOffset;
    int circleRight = right - strokeOffset;

    mPaint.setAntiAlias(true);

    // Draw a center_vertical line.
    mPaint.setColor(mLineColor);
    mPaint.setStrokeWidth(px(2));

    if ((APPEARANCE_REGULAR & mAppearance) > 0) {
      canvas.drawLine(
          centerX,
          circleBottom + px(CIRCLE_MARGIN_DP),
          centerX,
          bottom,
          mPaint);
      canvas.drawLine(
          centerX,
          top,
          centerX,
          circleTop - px(CIRCLE_MARGIN_DP),
          mPaint);
    } else if ((APPEARANCE_PADDING & mAppearance) > 0){
      canvas.drawLine(
          centerX,
          top,
          centerX,
          bottom,
          mPaint);
    }

    if ((APPEARANCE_REGULAR & mAppearance) > 0) {
      // Draw circle.
      mPaint.setStyle(Paint.Style.STROKE);
      mPaint.setColor(mCircleColor);
      mPaint.setStrokeWidth(px(STROKE_WIDTH_DP));
      canvas.drawOval(
          circleLeft,
          circleTop,
          circleRight,
          circleBottom,
          mPaint);
    }
  }
}
