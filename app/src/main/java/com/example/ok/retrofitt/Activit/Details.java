package com.example.ok.retrofitt.Activit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ok.retrofitt.R;
import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {
TextView title,desc;
ImageView imgg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        title=(TextView)findViewById(R.id.details_title) ;
        desc=(TextView)findViewById(R.id.details_desc) ;
        imgg=(ImageView)findViewById(R.id.details_image);

        Intent i = getIntent();
        String name= i.getStringExtra("tit");
        String img =i.getStringExtra("img");
        String des =i.getStringExtra("des");




        title.setText(name);
        desc.setText(des);

        Picasso.with(Details.this).load(img)
                .into(imgg);
    }
}
