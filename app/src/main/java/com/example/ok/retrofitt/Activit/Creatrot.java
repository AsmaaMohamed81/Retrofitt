package com.example.ok.retrofitt.Activit;

import com.example.ok.retrofitt.MOdel.Model;
import com.example.ok.retrofitt.client.xclient;

import retrofit2.Call;

/**
 * Created by ok on 11/12/2017.
 */

public class Creatrot {
    public static Creatrot creatrot=null;

 private xclient xclient;
    public static Creatrot getService(){
        if (creatrot == null){
            creatrot = new Creatrot();
        }
        return creatrot;
    }

    private Creatrot(){
        xclient=new xclient();
    }



    public Call<Model> getArticles(String category){

     InrfMyAp ap=xclient.getRetrofit().create(InrfMyAp.class);
     Call<Model> callc=ap.call(category);
     return callc;

 }




}
