package com.example.weijingliu.mtabusclient.nextbus;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by toliuweijing on 6/13/15.
 */
public class Config implements Parcelable {
  public static final String TAG = Config.class.getName();

  private String mRouteId;
  private String mDirectionId;

  public String getRouteId() {
    return mRouteId;
  }

  public String getDirectionId() {
    return mDirectionId;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.mRouteId);
    dest.writeString(this.mDirectionId);
  }

  public Config() {
  }

  public Config(String routeId, String directionId) {
    mRouteId = routeId;
    mDirectionId = directionId;
  }

  protected Config(Parcel in) {
    this.mRouteId = in.readString();
    this.mDirectionId = in.readString();
  }

  public static final Parcelable.Creator<Config> CREATOR = new Parcelable.Creator<Config>() {
    public Config createFromParcel(Parcel source) {
      return new Config(source);
    }

    public Config[] newArray(int size) {
      return new Config[size];
    }
  };
}
