package com.example.weijingliu.mtabusclient;

import android.content.res.Resources;

public class Utils {
  public static int px(int dp) {
    return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
  }
}
