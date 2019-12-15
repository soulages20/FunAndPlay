package com.ilkerefeyavuz.funplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EducationActivity extends AppCompatActivity {
    Button btn_math,btn_animals,btn_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);
        btn_math = findViewById(R.id.btn_math);
        btn_animals = findViewById(R.id.btn_animals);
        btn_color = findViewById(R.id.btn_color);

        btn_math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EducationActivity.this,ChooseActivity.class);
                startActivity(intent);
            }
        });
        btn_animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EducationActivity.this,AnimalActivity.class);
                startActivity(intent);
            }
        });
        btn_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EducationActivity.this,ColorsActivity.class);
                startActivity(intent);
            }
        });
    }
}
