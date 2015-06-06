package com.example.weijingliu.mtabusclient.network;

import android.net.Uri;

import com.google.common.collect.Lists;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

public class RestApis {
  public static final String HOST_OBANYC_COM = "api.prod.obanyc.com";
  public static final String QUERY_STOP_MONITORING_XML = "/api/siri/stop-monitoring.json";
  public static final int PORT = 80;
  public static final String VALUE_KEY = "cfb3c75b-5a43-4e66-b7f8-14e666b0c1c1";
  public static final String PARAM_KEY = "key";
  public static final String PARAM_MONITORING_REF = "MonitoringRef";
  public static final String PARAM_LINE_REF = "LineRef";

  public static final int SAMPLE_STOP_CODE = 307200;
  public static final String SAMPLE_LINE_REF = "MTA NYCT_B9";

  public static class Siri {

    private static <S, T> BasicNameValuePair newBasicNameValuePair(S s, T t) {
      return new BasicNameValuePair(String.valueOf(s), String.valueOf(t));
    }

    public static Uri stopMonitoring(int stopCode) {
      List<NameValuePair> params = Lists.newArrayList();
      params.addAll(Lists.newArrayList(
          newBasicNameValuePair(PARAM_KEY, VALUE_KEY),
          newBasicNameValuePair(PARAM_MONITORING_REF, stopCode)));

      Uri uri = new Uri.Builder()
            .scheme("http")
            .authority(HOST_OBANYC_COM)
            .path(QUERY_STOP_MONITORING_XML)
            .appendQueryParameter(PARAM_KEY, VALUE_KEY)
            .appendQueryParameter(PARAM_MONITORING_REF, String.valueOf(stopCode))
            .build();
      return uri;
    }

    public static Uri stopMonitoring(int stopCode, String lineRef) {
      List<NameValuePair> params = Lists.newArrayList();
      params.addAll(Lists.newArrayList(
          newBasicNameValuePair(PARAM_KEY, VALUE_KEY),
          newBasicNameValuePair(PARAM_MONITORING_REF, stopCode),
          newBasicNameValuePair(PARAM_LINE_REF, lineRef)));

      Uri uri = new Uri.Builder()
          .scheme("http")
          .authority(HOST_OBANYC_COM)
          .path(QUERY_STOP_MONITORING_XML)
          .appendQueryParameter(PARAM_KEY, VALUE_KEY)
          .appendQueryParameter(PARAM_MONITORING_REF, String.valueOf(stopCode))
          .appendQueryParameter(PARAM_LINE_REF, lineRef)
          .build();

      return uri;
    }
  }
}
