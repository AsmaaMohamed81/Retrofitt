package com.example.ok.retrofitt.client;

import com.example.ok.retrofitt.interseptor.Myheadet;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by ok on 13/12/2017.
 */

public class xclient extends paretclient {
    Retrofit retrofit;
    @Override
    public Interceptor getLoggingInterceptor() {
        Map<String,String> map=new HashMap<>();
        map.put("X-Api-Key","7e9737cbf47d498f97dee197078a8257");
        return new Myheadet(map);
    }

    @Override
    public Interceptor getHeaderInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public Retrofit getRetrofit() {

        return retrofit;
    }
}
