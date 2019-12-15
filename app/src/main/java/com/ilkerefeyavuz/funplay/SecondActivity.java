package com.ilkerefeyavuz.funplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button btn_education,btn_mgame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn_education = (Button)findViewById(R.id.btn_shapes);
        btn_mgame = (Button)findViewById(R.id.btn_reflex);


        View.OnClickListener btn_mathListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,EducationActivity.class);
                startActivity(intent);
            }
        };
        btn_education.setOnClickListener(btn_mathListener);

        btn_mgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this,MiniGames.class);
                startActivity(i);
            }
        });

    }
}
