package com.ilkerefeyavuz.funplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    Button btn_start,btn_answer0,btn_answer1,btn_answer2,btn_answer3,btn_restart,btn_choose;
    TextView tv_score, tv_questions,tv_timer,tv_bottommessage;
    ProgressBar prog_timer;
    SubGame g = new SubGame();
    String sID;

    int secondsRemaining = 30;
    CountDownTimer timer = new CountDownTimer(30000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            secondsRemaining--;
            tv_timer.setText(Integer.toString(secondsRemaining) + "sec");
            prog_timer.setProgress(30 - secondsRemaining);
        }

        @Override
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);
            tv_bottommessage.setText("Time is up! " + g.getNumberCorrect() + "/" + (g.getTotalQuestions() - 1));
            btn_choose.setVisibility(View.VISIBLE);
            btn_restart.setVisibility(View.VISIBLE);

            btn_choose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(SubActivity.this,SecondActivity.class);
                    startActivity(i);
                }
            });
            btn_restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btn_start.setVisibility(View.VISIBLE);
                            secondsRemaining = 30;
                            SubGame g = new SubGame();


                        }
                    },500);
                }
            });


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        Intent intent = getIntent();
        sID = intent.getStringExtra("operationID");
        btn_start = findViewById(R.id.btn_start);
        btn_answer0 = findViewById(R.id.btn_answer0);
        btn_answer1 = findViewById(R.id.btn_answer1);
        btn_answer2 = findViewById(R.id.btn_answer2);
        btn_answer3 = findViewById(R.id.btn_answer3);
        btn_restart = (Button)findViewById(R.id.btn_restart);
        btn_choose = (Button)findViewById(R.id.btn_choose);
        btn_restart.setVisibility(View.INVISIBLE);
        btn_choose.setVisibility(View.INVISIBLE);
        tv_score = findViewById(R.id.tv_score);
        tv_questions = findViewById(R.id.tv_questions);
        tv_timer = findViewById(R.id.tv_time);
        tv_bottommessage = findViewById(R.id.tv_bottommessage);
        prog_timer = findViewById(R.id.prog_timer);

        tv_timer.setText("0 sec");
        tv_questions.setText("");
        tv_bottommessage.setText("Press GO");
        tv_score.setText("0 Pts");

        View.OnClickListener startButtonClickLİstener =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button start_button = (Button) v ;
                start_button.setVisibility(View.INVISIBLE);
                nextTurn();
                timer.start();

            }};
        btn_start.setOnClickListener(startButtonClickLİstener);


        View.OnClickListener answerButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button buttonClicked = (Button) v ;
                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());
                g.checkAnswer(answerSelected);
                tv_score.setText(Integer.toString(g.getScore()));
                nextTurn();
            }
        };
        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);


    }


    private void nextTurn(){

        g.makeNewQuestion();
        int [] answer = g.getCurrentQuestion().getAnswerArray();
        btn_answer0.setText(Integer.toString(answer[0]));
        btn_answer1.setText(Integer.toString(answer[1]));
        btn_answer2.setText(Integer.toString(answer[2]));
        btn_answer3.setText(Integer.toString(answer[3]));

        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);
        btn_answer3.setEnabled(true);

        btn_choose.setVisibility(View.INVISIBLE);
        btn_restart.setVisibility(View.INVISIBLE);

        tv_questions.setText(g.getCurrentQuestion().getQuestionPhrase());
        tv_bottommessage.setText(g.getNumberCorrect() + "/" + (g.getTotalQuestions() - 1));
    }
}
