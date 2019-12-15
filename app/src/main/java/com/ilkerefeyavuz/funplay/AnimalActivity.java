package com.ilkerefeyavuz.funplay;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class AnimalActivity extends AppCompatActivity {

    ImageView image1,image2,image3,image4,imageMain;
    TextView tv_question,tv_status,tv_score;
    Button b_next,b_menu,b_restart;


    Integer[] images = {

            R.drawable.aslan,
            R.drawable.ari,
            R.drawable.at,
            R.drawable.ayi,
            R.drawable.balik,
            R.drawable.inek,
            R.drawable.kamplumbaga,
            R.drawable.kedi,
            R.drawable.koala,
            R.drawable.kopek,
            R.drawable.maymun1,
            R.drawable.papagan,
            R.drawable.tavsan,
            R.drawable.tavuk,
            R.drawable.baykus,
            R.drawable.deve,
            R.drawable.domuz,
            R.drawable.esek,
            R.drawable.fil,
            R.drawable.kaplan,
            R.drawable.koyun,
            R.drawable.kurbaga,
            R.drawable.ordek,
            R.drawable.penguen,
            R.drawable.sincap,
            R.drawable.tilki,
            R.drawable.zebra,
            R.drawable.zurafa,

    };
    String [] imagesText = {
            "Lion","Bee", "Horse", "Bear", "Fish", "Cow", "Turtle", "Cat","Koala","Dog","Monkey","Parrot","Rabbit","Chicken",
            "Owl","Camel","Pig","Donkey","Elephant","Tiger","Sheep","Frog","Duck","Penguin","Squirrel","Fox","Zebra","Giraffe"
    };
    Integer []images_numbers = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    int turn = 1;

    int correctAnswer = 0;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        //imageMain = (ImageView) findViewById(R.id.imageMain);
        tv_status = findViewById(R.id.tv_status);
        tv_question = findViewById(R.id.tv_question);
        tv_score = findViewById(R.id.tv_score);

        b_next = (Button) findViewById(R.id.b_next);
        b_menu = (Button) findViewById(R.id.b_menu);
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
        correctAnswer = r.nextInt(4) + 1;
        int wrongAnswer1,wrongAnswer2,wrongAnswer3;

        do {
            wrongAnswer1 = r.nextInt(24);
        }while (wrongAnswer1 == images_numbers[turn]);
        do {
            wrongAnswer2 = r.nextInt(24);
        }while (wrongAnswer2 == images_numbers[turn]|| wrongAnswer2 == wrongAnswer1);
        do {
            wrongAnswer3 = r.nextInt(24);
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
        //imageMain.setImageResource(images[images_numbers[turn]]);
        tv_question.setText(imagesText[images_numbers[turn]]);
        tv_status.setText("");
        b_next.setVisibility(View.INVISIBLE);

        image1.setEnabled(true);
        image2.setEnabled(true);
        image3.setEnabled(true);
        image4.setEnabled(true);

    }

    private void  checkEnd(){

        tv_score.setText(score + "/10");
        tv_score.setVisibility(View.VISIBLE);
        b_next.setVisibility(View.INVISIBLE);
        b_menu.setVisibility(View.VISIBLE);
        b_restart.setVisibility(View.VISIBLE);

        b_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimalActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        b_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn  = 1;
                Collections.shuffle(Arrays.asList(images_numbers));
                setImages();
                b_menu.setVisibility(View.INVISIBLE);
                b_restart.setVisibility(View.INVISIBLE);
                tv_score.setVisibility(View.INVISIBLE);
                score = 0;
            }
        });


    }
}
