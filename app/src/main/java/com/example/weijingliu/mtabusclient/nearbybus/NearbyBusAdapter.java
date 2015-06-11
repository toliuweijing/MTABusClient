package com.example.weijingliu.mtabusclient.nearbybus;

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
import android.widget.TextView;

import com.example.weijingliu.mtabusclient.R;
import com.obanyc.api.where.scheduleforstop.Route;

import java.util.ArrayList;
import java.util.List;

public class NearbyBusAdapter extends RecyclerView.Adapter<NearbyBusAdapter.ViewHolder> {
  private static final String TAG = NearbyBusAdapter.class.getSimpleName();

  public static class Model {
    Route route;
    String destination1;
    String getDestination2;
  }

  private List<Model> mModels = new ArrayList<>();

  public void setModels(List<Model> models) {
    mModels.clear();
    mModels.addAll(models);
    notifyDataSetChanged();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    Log.d(TAG, "onCreateViewHolder");
    FrameLayout frameLayout = (FrameLayout) LayoutInflater
        .from(viewGroup.getContext())
        .inflate(
            R.layout.nearby_bus_row_layout,
            viewGroup,
            false);
    TextView shortNameText = (TextView) frameLayout.findViewById(R.id.bus_short_name_text);
    TextView destinationText1 = (TextView) frameLayout.findViewById(R.id.bus_destination_text_1);
    TextView destinationText2 = (TextView) frameLayout.findViewById(R.id.bus_destination_text_2);

    return new ViewHolder(frameLayout, shortNameText, destinationText1, destinationText2);
  }

  @Override
  public void onBindViewHolder(ViewHolder viewHolder, int i) {
    Model model = mModels.get(i);
    viewHolder.shortNameText.setText(model.route.getShortName());
    viewHolder.destinationText1.setText(model.destination1);
    viewHolder.destinationText2.setText(model.getDestination2);
  }

  @Override
  public int getItemCount() {
    return mModels.size();
  }

  public void setListener(Listener listener) {
    mListener = listener;
  }

  interface Listener {
    void onRouteSelected();
  }
  private Listener mListener;

  class ViewHolder extends RecyclerView.ViewHolder {
    TextView shortNameText;
    TextView destinationText1;
    TextView destinationText2;
    public ViewHolder(
        View view,
        TextView shortNameText,
        TextView destinationText1,
        TextView destinationText2) {
      super(view);
      this.shortNameText = shortNameText;
      this.destinationText1 = destinationText1;
      this.destinationText2 = destinationText2;

      view.setOnClickListener(
          new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if (mListener != null) {
                mListener.onRouteSelected();
              }
            }
          }
      );
    }}

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
