package com.example.weijingliu.mtabusclient.rest.service;

import retrofit.RestAdapter;

public class SiriService {
  public static final SiriService sInstance = new SiriService();

  private final RestAdapter mRestAdapter;
  private final SiriApi mSiriApi;

  public SiriService() {
    mRestAdapter = new RestAdapter.Builder()
        .setEndpoint("http://api.prod.obanyc.com")
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .build();
    mSiriApi = mRestAdapter.create(SiriApi.class);
  }

  public SiriApi getSiriApi() {
    return mSiriApi;
  }
}
