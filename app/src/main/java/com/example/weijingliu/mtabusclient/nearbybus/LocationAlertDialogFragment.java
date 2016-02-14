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

/**
 * Created by weijingliu on 2/14/16.
 */
public class LocationAlertDialogFragment extends DialogFragment {

    private String mMessage;

    public static LocationAlertDialogFragment newInstance(String message) {
        LocationAlertDialogFragment fragment = new LocationAlertDialogFragment();
        fragment.mMessage = message;
        return fragment;
    }

    public static void maybeAlertForEnablingLocation(Fragment fragment) {
        if (!LocationUtils.isLocationSettingsEnabled(fragment.getActivity())) {
            newInstance("Please enable system location settings and click location pin.")
                    .show(fragment.getFragmentManager(), "1");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(mMessage)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        return builder.create();
    }
}
