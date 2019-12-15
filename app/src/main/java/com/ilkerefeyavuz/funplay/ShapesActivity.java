package com.ilkerefeyavuz.funplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ShapesActivity extends AppCompatActivity {
    Button b_next,b_menu,b_restart;
    ImageView imageMain,image1,image2,image3,image4;
    TextView tv_status,tv_score;
    Integer []images = {
            R.drawable.shape1,
            R.drawable.shape2,
            R.drawable.shape3,
            R.drawable.shape4,
            R.drawable.shape5,
            R.drawable.shape6,
            R.drawable.shape7,
            R.drawable.shape8,
            R.drawable.shape9,
            R.drawable.shape10,
            R.drawable.shape11,
            R.drawable.shape12,
            R.drawable.shape13,
            R.drawable.shape14,
            R.drawable.shape15,
            R.drawable.shape16,
            R.drawable.shape17,
            R.drawable.shape18,
            R.drawable.shape19,
            R.drawable.shape20,
    };
    Integer []shadowImages = {
            R.drawable.shapesw1,
            R.drawable.shapesw2,
            R.drawable.shapesw3,
            R.drawable.shapesw4,
            R.drawable.shapesw5,
            R.drawable.shapesw6,
            R.drawable.shapesw7,
            R.drawable.shapesw8,
            R.drawable.shapesw9,
            R.drawable.shapesw10,
            R.drawable.shapesw11,
            R.drawable.shapesw12,
            R.drawable.shapesw13,
            R.drawable.shapesw14,
            R.drawable.shapesw15,
            R.drawable.shapesw16,
            R.drawable.shapesw17,
            R.drawable.shapesw18,
            R.drawable.shapesw19,
            R.drawable.shapesw20,
    };
    Integer []images_numbers = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
    int turn = 1;
    int correctAnswer = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);
        b_next = findViewById(R.id.b_next);
        imageMain = findViewById(R.id.imageMain);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        tv_status = findViewById(R.id.tv_status);
        tv_score = findViewById(R.id.tv_score);
        b_menu = findViewById(R.id.b_menu);
        b_restart = findViewById(R.id.b_restart);

        imageMain.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageMain.setVisibility(View.INVISIBLE);

            }
        },1000);

        Collections.shuffle(Arrays.asList(images_numbers));
        setImages();

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer == 1) {
                    score++;
                    tv_status.setText("Correct");
                    b_next.setVisibility(View.VISIBLE);

                } else {
                    tv_status.setText("Wrong");
                    b_next.setVisibility(View.VISIBLE);
                }
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer == 2) {
                    score++;
                    tv_status.setText("Correct");
                    b_next.setVisibility(View.VISIBLE);

                } else {
                    tv_status.setText("Wrong");
                    b_next.setVisibility(View.VISIBLE);
                }
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer == 3) {
                    score++;
                    tv_status.setText("Correct");
                    b_next.setVisibility(View.VISIBLE);

                } else {
                    tv_status.setText("Wrong");
                    b_next.setVisibility(View.VISIBLE);
                }
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (correctAnswer == 4) {
                    score++;
                    tv_status.setText("Correct");
                    b_next.setVisibility(View.VISIBLE);

                } else {
                    tv_status.setText("Wrong");
                    b_next.setVisibility(View.VISIBLE);
                }
                image1.setEnabled(false);
                image2.setEnabled(false);
                image3.setEnabled(false);
                image4.setEnabled(false);
            }
        });
        b_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn ++;
                if(turn ==11){
                    checkEnd();
                }else {
                    setImages();
                }
                imageMain.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageMain.setVisibility(View.INVISIBLE);

                    }
                },750);

            }
        });
    }
    private void setImages(){
        Random r = new Random();
        correctAnswer = r.nextInt(4) + 1;
        int wrongAnswer1,wrongAnswer2,wrongAnswer3;

        do {
            wrongAnswer1 = r.nextInt(19);
        }while (wrongAnswer1 == images_numbers[turn]);
        do {
            wrongAnswer2 = r.nextInt(19);
        }while (wrongAnswer2 == images_numbers[turn]|| wrongAnswer2 == wrongAnswer1);
        do {
            wrongAnswer3 = r.nextInt(19);
        }while (wrongAnswer3 == images_numbers[turn] || wrongAnswer3 == wrongAnswer2 || wrongAnswer1 == wrongAnswer3);
        switch (correctAnswer){
            case 1:
                image1.setImageResource(images[images_numbers[turn]]);
                image2.setImageResource(images[wrongAnswer1]);
                image3.setImageResource(images[wrongAnswer2]);
                image4.setImageResource(images[wrongAnswer3]);
                break;
            case 2:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[images_numbers[turn]]);
                image3.setImageResource(images[wrongAnswer2]);
                image4.setImageResource(images[wrongAnswer3]);
                break;
            case 3:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[wrongAnswer2]);
                image3.setImageResource(images[images_numbers[turn]]);
                image4.setImageResource(images[wrongAnswer3]);
                break;
            case 4:
                image1.setImageResource(images[wrongAnswer1]);
                image2.setImageResource(images[wrongAnswer2]);
                image3.setImageResource(images[wrongAnswer3]);
                image4.setImageResource(images[images_numbers[turn]]);
                break;

        }
        imageMain.setImageResource(shadowImages[images_numbers[turn]]);
        tv_status.setText("");
        b_next.setVisibility(View.INVISIBLE);

        image1.setEnabled(true);
        image2.setEnabled(true);
        image3.setEnabled(true);
        image4.setEnabled(true);

    }
    private void  checkEnd(){

        tv_score.setText(score + "/10");
        tv_status.setVisibility(View.INVISIBLE);
        tv_score.setVisibility(View.VISIBLE);
        b_next.setVisibility(View.INVISIBLE);
        b_menu.setVisibility(View.VISIBLE);
        b_restart.setVisibility(View.VISIBLE);

        b_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShapesActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        b_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn  = 1;
                imageMain.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageMain.setVisibility(View.INVISIBLE);

                    }
                },1000);

                Collections.shuffle(Arrays.asList(images_numbers));
                setImages();
                b_menu.setVisibility(View.INVISIBLE);
                b_restart.setVisibility(View.INVISIBLE);
                tv_score.setVisibility(View.INVISIBLE);
                tv_status.setVisibility(View.VISIBLE);
                score = 0;
            }
        });
    }

}
