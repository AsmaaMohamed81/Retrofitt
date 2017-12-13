package com.example.ok.retrofitt.Activit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.ok.retrofitt.Adpter.Adapter;
import com.example.ok.retrofitt.MOdel.ArticlesItem;
import com.example.ok.retrofitt.MOdel.Model;
import com.example.ok.retrofitt.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<ArticlesItem> articlesItems;
    firstmain firstmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        articlesItems = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerImages);

        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        recyclerView.setHasFixedSize(true);

        adapter = new Adapter(MainActivity.this, articlesItems);

        recyclerView.setAdapter(adapter);
                 //Creatrot c= new Creatrot();
       Intent i = getIntent();
       String name= i.getStringExtra("name");

        Call<Model> call = Creatrot.getService().getArticles(name);

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                Toast.makeText(MainActivity.this, "sccess", Toast.LENGTH_SHORT).show();


                articlesItems.addAll(response.body().getArticles());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage() + "", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
