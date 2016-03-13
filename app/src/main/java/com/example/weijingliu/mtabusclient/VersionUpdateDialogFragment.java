package com.example.weijingliu.mtabusclient;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;

/**
 * Created by toliuweijing on 3/9/16.
 */
public class VersionUpdateDialogFragment extends DialogFragment {
  public static final String KEY_LATEST_VERSION = "latest_version";
  private static final String MESSAGE =
      "Version 1.1: \n  " +
          "\n" +
          "  1. Alarms can be cancelled by tapping Cancel button from its notification. \n" +
          "\n" +
          "  2. Alarms now start ringing at 2 stops away. They end when bus is less than 1 stop. \n" +
          "\n" +
          "Feel free to contact me via http://fb.me/msg/busggg for feature requests. \n" +
          "\n" +
          "Cheers.";

  public static void showVersionUpdateIfNeeded(Context context, FragmentManager fragmentManager) {
    if (performLatestVersionPreferenceUpgrate(context)) {
      new VersionUpdateDialogFragment().show(fragmentManager, "");
    }
  }

  private static boolean performLatestVersionPreferenceUpgrate(Context context) {
    try {
      String versionName = context.getPackageManager()
          .getPackageInfo(context.getPackageName(), 0).versionName;
      Log.i("jing", "current-version-" + versionName);
      SharedPreferences sharedPref = context.getSharedPreferences(
          "config",
          Context.MODE_PRIVATE);
      String latestVersion = sharedPref.getString(KEY_LATEST_VERSION, "");

      boolean needsUpgrade = !latestVersion.equals(versionName);
      sharedPref.edit().putString(KEY_LATEST_VERSION, versionName).commit();

      return needsUpgrade;
    } catch (PackageManager.NameNotFoundException e) {
      e.printStackTrace();
      return false;
    }
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
