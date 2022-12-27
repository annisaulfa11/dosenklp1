package com.example.dosenklp1;


import com.example.dosenklp1.network.StoryEndPoint;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Config {
    private String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";
    public static final Integer SUCCESS_RESULT = 1;
    public static final Integer FAILURE_RESULT = 0;

    public StoryEndPoint configRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build();
        StoryEndPoint route = retrofit.create(StoryEndPoint.class);
        return route;
    }

}
