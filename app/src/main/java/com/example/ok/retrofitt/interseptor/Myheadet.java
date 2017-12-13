package com.example.ok.retrofitt.interseptor;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ok on 13/12/2017.
 */

public class Myheadet implements Interceptor {
    Map<String, String> mapp;

    public Myheadet(Map<String, String> mapp) {
        this.mapp = mapp;
    }

    @Override

    public Response intercept(Chain chain) throws IOException {

        Request request= chain.request();

        Request.Builder builder=request.newBuilder();

        for(Map.Entry<String,String> map:mapp.entrySet()){

            builder.addHeader(map.getKey(),map.getValue());
        }


        return chain.proceed(builder.build());
    }
}
