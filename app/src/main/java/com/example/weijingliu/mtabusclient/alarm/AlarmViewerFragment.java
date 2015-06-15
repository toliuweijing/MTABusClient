package com.example.weijingliu.mtabusclient.alarm;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weijingliu.mtabusclient.R;
import com.example.weijingliu.mtabusclient.common.HorizontalDividerItemDecoration;

import static com.example.weijingliu.mtabusclient.Utils.px;

/**
 * Created by toliuweijing on 6/15/15.
 */
public class AlarmViewerFragment extends Fragment {
  private RecyclerView mRecyclerView;
  private AlarmViewerAdapter mAlarmViewerAdapter;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.alarm_viewer_fragment_layout, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    mAlarmViewerAdapter = new AlarmViewerAdapter();
    mAlarmViewerAdapter.setAlarms(AlarmStore.instance.getAll());
    mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    mRecyclerView.setAdapter(mAlarmViewerAdapter);
    mRecyclerView.addItemDecoration(
        new HorizontalDividerItemDecoration(Color.LTGRAY, px(16), px(16)));
  }
}
