package com.example.weijingliu.mtabusclient;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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
    viewHolder.textView.setText(String.valueOf(position) + ":00");

    int appearance = LolipopView.APPEARANCE_REGULAR;
    if (position == 0) {
      appearance = LolipopView.APPEARANCE_START;
    } else if (position == getItemCount() -1) {
      appearance = LolipopView.APPEARANCE_END;
    }
    viewHolder.lolipopView.setAppearance(appearance);
  }

  @Override
  public int getItemCount() {
    return 5;
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    LolipopView lolipopView;
    TextView textView;

    public ViewHolder(View view) {
      super(view);
      lolipopView = (LolipopView) view.findViewById(R.id.lolipop);
      textView = (TextView) view.findViewById(R.id.middle_text);
    }
  }
}
