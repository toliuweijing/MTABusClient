package com.example.weijingliu.mtabusclient.alarm;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.weijingliu.mtabusclient.R;
import com.example.weijingliu.mtabusclient.Utils;
import com.example.weijingliu.mtabusclient.alarm.Models.Alarm;

import java.util.ArrayList;
import java.util.List;

public class AlarmViewerAdapter extends RecyclerView.Adapter<AlarmViewerAdapter.ViewHolder> {
  private List<Alarm> mAlarms = new ArrayList<>();

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View item = LayoutInflater.from(parent.getContext()).inflate(
        R.layout.alarm_viewer_row_layout,
        parent,
        false);
    TextView title = (TextView) item.findViewById(R.id.title_text);
    TextView subtitle = (TextView) item.findViewById(R.id.subtitle_text_1);
    TextView subtitle2 = (TextView) item.findViewById(R.id.subtitle_text_2);
    SwitchCompat switchCompat = (SwitchCompat) item.findViewById(R.id.on_off_switch);
    return new ViewHolder(
        item,
        title,
        subtitle,
        subtitle2,
        switchCompat);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, final int position) {
    final Alarm alarm = mAlarms.get(position);
    if (alarm.type() == Alarm.Type.TIME) {
      String timeString = Utils.toTimeString(alarm.time());
      SpannableStringBuilder builder = SpannableStringBuilder.valueOf(timeString);
      int start = builder.length() - 2;
      int end = builder.length();
      builder.setSpan(new RelativeSizeSpan(0.2f), start, end, 0);
      holder.title.setText(builder);
      holder.subtitle.setText("At " + alarm.stop().name());
      holder.subtitle2.setText(alarm.route().shortName());
    } else {
      SpannableStringBuilder builder = SpannableStringBuilder.valueOf(
          String.valueOf(
              alarm.nearCount()));
      int start = builder.length();
      builder.append(" stops");
      builder.setSpan(new RelativeSizeSpan(0.5f), start, builder.length(), 0);
      holder.title.setText(builder);
      holder.subtitle.setText("near " + alarm.stop().name());
      holder.subtitle2.setText(alarm.route().shortName());
    }
    holder.switchCompat.setOnCheckedChangeListener(null);
    holder.switchCompat.setChecked(true);
    holder.switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (!isChecked) {
          int toRemovePosition = holder.getAdapterPosition();
          notifyItemRemoved(toRemovePosition);
          mAlarms.remove(toRemovePosition);
          AlarmUtil.dismissAlarm(alarm, holder.itemView.getContext());
        }
      }
    });
  }

  @Override
  public int getItemCount() {
    return mAlarms.size();
  }

  public void setAlarms(List<Alarm> alarms) {
    mAlarms.addAll(alarms);
    notifyDataSetChanged();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView title;
    final TextView subtitle;
    final TextView subtitle2;
    final SwitchCompat switchCompat;
    public ViewHolder(View itemView, TextView title, TextView subtitle, TextView subtitle2, SwitchCompat switchCompat) {
      super(itemView);
      this.title = title;
      this.subtitle = subtitle;
      this.subtitle2 = subtitle2;
      this.switchCompat = switchCompat;
    }
  }
}
