package com.example.weijingliu.mtabusclient.nextbus;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.weijingliu.mtabusclient.R;
import com.example.weijingliu.mtabusclient.Utils;
import com.google.common.base.Optional;
import com.google.common.collect.Iterables;
import com.obanyc.api.local.Primitives.Schedule;
import com.obanyc.api.local.Queries.RouteStopDirectionSchedules;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import static com.example.weijingliu.mtabusclient.Utils.px;

public class NextBusAdapter extends RecyclerView.Adapter<NextBusAdapter.ViewHolder> {

  private List<Schedule> mSchedules = new ArrayList<>();

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int viewType) {
    final View view = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.next_bux_row_layout, viewGroup, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ViewHolder viewHolder, int position) {
    boolean isPaddingView = position == 0 || position == getItemCount() - 1;
//    if (isPaddingView) {
//      ViewGroup.LayoutParams layoutParams = viewHolder.frameLayout.getLayoutParams();
//      layoutParams.height = px(50);
//      viewHolder.frameLayout.setLayoutParams(layoutParams);
//      viewHolder.textView.setText(null);
//      viewHolder.lolipopView.setAppearance(LolipopView.APPEARANCE_PADDING);
//    } else {
      ViewGroup.LayoutParams layoutParams = viewHolder.frameLayout.getLayoutParams();
      layoutParams.height = px(100);
      viewHolder.frameLayout.setLayoutParams(layoutParams);

    Schedule schedule = mSchedules.get(position);
    String dateString = Utils.toTimeString(schedule);
      viewHolder.textView.setText(null);
      viewHolder.textView.setText(dateString);
      viewHolder.lolipopView.setAppearance(LolipopView.APPEARANCE_REGULAR);
//    }

    int color = (position % 2 == 0) ?
        Color.parseColor("#D84315") :
        Color.parseColor("#00695C");
    viewHolder.lolipopView.setCircleColor(color);

    viewHolder.frameLayout.requestLayout();
  }

  @Override
  public int getItemCount() {
    return mSchedules.size();
  }

  public void setSchedules(RouteStopDirectionSchedules schedules) {
    final long currentTime = System.currentTimeMillis();
    mSchedules.clear();
    mSchedules.addAll(schedules.schedules());
    Iterables.removeIf(mSchedules, new com.google.common.base.Predicate<Schedule>() {
          @Override
          public boolean apply(@Nullable Schedule input) {
            return input.arrivalTime() < currentTime;
          }
        });
    notifyDataSetChanged();
  }

  public Schedule getNextSchedule() {
    return mSchedules.isEmpty() ? null : mSchedules.get(0);
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
