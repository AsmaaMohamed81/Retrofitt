package com.example.ok.retrofitt.Activit;

import com.example.ok.retrofitt.MOdel.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ok on 11/12/2017.
 */

public interface InrfMyAp {


    @GET("top-headlines")
    Call<Model> call(@Query("category")String category);

//    @GET("everything")
//    Call<Model> call(@Query("q")String category);
}
