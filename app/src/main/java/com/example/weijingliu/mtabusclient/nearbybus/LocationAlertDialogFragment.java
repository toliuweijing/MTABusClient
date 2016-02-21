package com.example.weijingliu.mtabusclient.nearbybus;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;

import com.example.weijingliu.mtabusclient.LocationUtils;

public class LocationAlertDialogFragment extends DialogFragment {

  public static final String MESSAGE = "Please enable system location settings and click location pin.";
  private LocationUtils mLocationUtils;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mLocationUtils = new LocationUtils(getActivity());
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setMessage(MESSAGE)
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int id) {
          }
        });
    return builder.create();
  }
}
