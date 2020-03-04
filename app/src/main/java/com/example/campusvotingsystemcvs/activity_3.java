package com.example.campusvotingsystemcvs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class activity_3 extends AppCompatActivity {

    Button science;
    Button edu;
    Button biz;
    Button agric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        science = (Button) findViewById(R.id.scie);
        edu =(Button) findViewById(R.id.edu);
        biz = (Button) findViewById(R.id.biz);
        agric =(Button) findViewById(R.id.agric);

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_3.this,activity_submit.class);
                startActivity(intent);



            }
        });

        edu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        biz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        agric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}
