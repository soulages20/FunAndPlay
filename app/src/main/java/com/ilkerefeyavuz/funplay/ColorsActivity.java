package com.ilkerefeyavuz.funplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class ColorsActivity extends AppCompatActivity {
    ImageView image1,image2,image3,image4;
    TextView tv_status,textMain,tv_score;
    Button b_next,b_menu,b_restart;

    Integer[] images ={
            R.drawable.black,
            R.drawable.blue,
            R.drawable.green,
            R.drawable.orange,
            R.drawable.purple,
            R.drawable.red,
            R.drawable.yellow,
            R.drawable.pink,
            R.drawable.brown,
            R.drawable.claret,
            R.drawable.grey,
            R.drawable.turquois,
            R.drawable.dark_blue


    };

    String[] textColor = {
            "Black","Blue","Green","Orange","Purple","Red","Yellow","Pink","Brown","Claret","Grey","Turquois","Dark Blue"
    };

    Integer[] images_numbers = {0,1,2,3,4,5,6,7,8,9,10,11,12};
    int turn =1;
    int correctAnswer = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);

        tv_status = (TextView) findViewById(R.id.tv_status);
        textMain = (TextView) findViewById(R.id.textMain);
        tv_score = (TextView) findViewById(R.id.tv_score);

        b_next = (Button) findViewById(R.id.b_next);
        b_menu = (Button)findViewById(R.id.b_menu);
        b_restart = (Button) findViewById(R.id.b_restart);

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
            }
        });


    }

    private void setImages(){
        Random r = new Random();
        correctAnswer = r.nextInt(4)+1;

        int wrongAnswer1,wrongAnswer2,wrongAnswer3;

        do {
            wrongAnswer1=r.nextInt(12);
        }while(wrongAnswer1==images_numbers[turn]);
        do {
            wrongAnswer2=r.nextInt(12);
        }while(wrongAnswer2==images_numbers[turn] || wrongAnswer2==wrongAnswer1);
        do {
            wrongAnswer3=r.nextInt(12);
        }while(wrongAnswer3==images_numbers[turn] || wrongAnswer3 == wrongAnswer2 ||wrongAnswer3==wrongAnswer1);

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


        textMain.setText(textColor[images_numbers[turn]]);

        tv_status.setText(" ");
        b_next.setVisibility(View.INVISIBLE);

        image1.setEnabled(true);
        image2.setEnabled(true);
        image3.setEnabled(true);
        image4.setEnabled(true);

    }
    private void  checkEnd(){

        tv_score.setVisibility(View.VISIBLE);
        tv_score.setText(score + "/10");
        b_menu.setVisibility(View.VISIBLE);
        b_restart.setVisibility(View.VISIBLE);
        b_next.setVisibility(View.INVISIBLE);
        tv_status.setVisibility(View.INVISIBLE);
        b_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        b_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ColorsActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

}
