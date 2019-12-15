package com.ilkerefeyavuz.funplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ChooseActivity extends AppCompatActivity {
    ImageView imageSum,imageSub,imageMult,imageDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        imageSum = findViewById(R.id.imageSum);
        imageSub = findViewById(R.id.imageSub);
        imageMult = findViewById(R.id.imageMult);
        imageDiv = findViewById(R.id.imageDiv);

        imageSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this,SumActivity.class);
                startActivity(intent);

            }
        });
        imageSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this,SubActivity.class);
                startActivity(intent);
            }
        });
        imageMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this,MultActivity.class);
                startActivity(intent);
            }
        });
        imageDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this,DivActivity.class);
                startActivity(intent);
            }
        });
    }
}
