package com.ilkerefeyavuz.funplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MiniGames extends AppCompatActivity {
    Button btn_shapes,btn_reflex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_games);
        btn_shapes = findViewById(R.id.btn_shapes);
        btn_reflex = findViewById(R.id.btn_reflex);

        btn_shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MiniGames.this,ShapesActivity.class);
                startActivity(intent);
            }
        });
        btn_reflex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MiniGames.this,ReflexActivity.class);
                startActivity(intent);
            }
        });
    }
}
