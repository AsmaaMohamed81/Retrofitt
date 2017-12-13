package com.example.ok.retrofitt.Activit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ok.retrofitt.R;

public class firstmain extends AppCompatActivity {
    String gatog;
Button business,business_entertainment,gaming,general,health_and_medical,music,politics,science_and_nature,sport,technology;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmain);
        business=(Button)findViewById(R.id.business);
        business_entertainment=(Button)findViewById(R.id.business_entertainment);
        gaming=(Button)findViewById(R.id.gaming);

        general=(Button)findViewById(R.id.general);
        health_and_medical=(Button)findViewById(R.id.health_and_medical);
        music=(Button)findViewById(R.id.music);

        politics=(Button)findViewById(R.id.politics);
        science_and_nature=(Button)findViewById(R.id.science_and_nature);
        sport=(Button)findViewById(R.id.sport);

        technology=(Button)findViewById(R.id.technology);

        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(firstmain.this,MainActivity.class);
                i.putExtra("name",business.getText());
                startActivity(i);
            }
        });

        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(firstmain.this,MainActivity.class);
                i.putExtra("name",sport.getText());
                startActivity(i);
            }
        });

        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(firstmain.this,MainActivity.class);
                i.putExtra("name",general.getText());
                startActivity(i);
            }
        });
    }
}
