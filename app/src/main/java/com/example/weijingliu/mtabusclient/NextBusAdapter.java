package com.example.weijingliu.mtabusclient;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;

import static com.example.weijingliu.mtabusclient.Utils.px;

public class NextBusAdapter extends RecyclerView.Adapter<NextBusAdapter.ViewHolder> {

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int viewType) {
    final View view = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.next_bux_row_layout, viewGroup, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder viewHolder, int position) {
    boolean isPaddingView = position == 0 || position == getItemCount() - 1;
    if (isPaddingView) {
      ViewGroup.LayoutParams layoutParams = viewHolder.frameLayout.getLayoutParams();
      layoutParams.height = px(50);
      viewHolder.frameLayout.setLayoutParams(layoutParams);
      viewHolder.textView.setText(null);
      viewHolder.lolipopView.setAppearance(LolipopView.APPEARANCE_PADDING);
    } else {
      ViewGroup.LayoutParams layoutParams = viewHolder.frameLayout.getLayoutParams();
      layoutParams.height = px(100);
      viewHolder.frameLayout.setLayoutParams(layoutParams);
      viewHolder.textView.setText(null);
      viewHolder.textView.setText(String.valueOf(position) + ":00 AM");
      viewHolder.lolipopView.setAppearance(LolipopView.APPEARANCE_REGULAR);
    }

    int color = (position % 2 == 0) ?
        Color.parseColor("#D84315") :
        Color.parseColor("#00695C");
    viewHolder.lolipopView.setCircleColor(color);

    viewHolder.frameLayout.requestLayout();
  }

  @Override
  public int getItemCount() {
    return 20;
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    LolipopView lolipopView;
    TextView textView;
    FrameLayout frameLayout;

    public ViewHolder(View view) {
      super(view);
      frameLayout = (FrameLayout) view;
      lolipopView = (LolipopView) view.findViewById(R.id.lolipop);
      textView = (TextView) view.findViewById(R.id.middle_text);
    }
  }
}
