package com.example.ok.retrofitt.client;

import android.os.Environment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ok on 13/12/2017.
 */

public  abstract class paretclient {
    
    public static final String Base_Url ="https://newsapi.org/v2/";
    private final int cach_size =20 *1024*1024;
    private final int requst_time = 15;

    public paretclient() {
        okhttpcreat();
    }

    private void okhttpcreat(){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getclient())
                .build();

        setRetrofit(retrofit);

    }

    private OkHttpClient getclient() {
        
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(requst_time, TimeUnit.SECONDS)
                .readTimeout(requst_time,TimeUnit.SECONDS)
                .writeTimeout(requst_time,TimeUnit.SECONDS)
                .cache(getcach())
                .addInterceptor(getHeaderInterceptor())
                .addInterceptor(getLoggingInterceptor())
                .build();

        return client;
        
    }

    private Cache getcach() {
        File file=new File(Environment.getExternalStorageDirectory(),"res");
        return new Cache(file,cach_size);
    }

    public abstract Interceptor getLoggingInterceptor() ;

    public abstract Interceptor getHeaderInterceptor() ;
    public abstract Retrofit getRetrofit();

    public abstract void setRetrofit(Retrofit retrofit);


}
