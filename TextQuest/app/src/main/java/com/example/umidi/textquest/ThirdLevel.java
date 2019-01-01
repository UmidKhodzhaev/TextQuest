package com.example.umidi.textquest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdLevel extends AppCompatActivity {
    TextView sendToSchool, oge, wrongAnswer, rightAnswer, crossStreet, consequenceRed, consequenceGreen;
    Button fun, sad, nothing, answered, redLight, greenLight, dead;
    EditText answerToOGE;
    ImageView exerciseToOGE;
    boolean startOge = false, startEge = false, gotAnswer = false, died = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_level);


    }

    @Override
    protected void onResume() {
        super.onResume();
        answerToOGE = (EditText) findViewById(R.id.answerToOGE);

        exerciseToOGE = (ImageView) findViewById(R.id.exerciseToOGE);

        oge = (TextView) findViewById(R.id.oge);
        wrongAnswer = (TextView) findViewById(R.id.wrongAnswer);
        rightAnswer = (TextView) findViewById(R.id.rightAnswer);
        crossStreet = (TextView) findViewById(R.id.crossStreet);
        consequenceRed = (TextView) findViewById(R.id.consequenceRed);
        consequenceGreen = (TextView) findViewById(R.id.consequenceGreen);
        sendToSchool = (TextView) findViewById(R.id.sendToSchool);

        fun = (Button) findViewById(R.id.fun);
        nothing = (Button) findViewById(R.id.nothing);
        redLight = (Button) findViewById(R.id.redLight);
        greenLight = (Button) findViewById(R.id.greenLight);
        dead = (Button) findViewById(R.id.dead);
        answered = (Button) findViewById(R.id.answered);
        sad = (Button) findViewById(R.id.sad);

        sendToSchool.setVisibility(View.INVISIBLE);
        oge.setVisibility(View.INVISIBLE);
        wrongAnswer.setVisibility(View.INVISIBLE);
        rightAnswer.setVisibility(View.INVISIBLE);
        crossStreet.setVisibility(View.INVISIBLE);
        consequenceRed.setVisibility(View.INVISIBLE);
        consequenceGreen.setVisibility(View.INVISIBLE);
        answered.setVisibility(View.INVISIBLE);
        redLight.setVisibility(View.INVISIBLE);
        greenLight.setVisibility(View.INVISIBLE);
        dead.setVisibility(View.INVISIBLE);
        answerToOGE.setVisibility(View.INVISIBLE);
        exerciseToOGE.setVisibility(View.INVISIBLE);

        fun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOGE();
            }
        });
        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOGE();
            }
        });
        nothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOGE();
            }
        });
        answered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startOge && !gotAnswer) {
                    String otv = answerToOGE.getText().toString();
                    if (otv.equals("3-3")) {
                        startEge = true;
                        gotAnswer = true;
                        rightAnswer.setVisibility(View.VISIBLE);
                        crossStreet.setVisibility(View.VISIBLE);
                        redLight.setVisibility(View.VISIBLE);
                        greenLight.setVisibility(View.VISIBLE);

                    } else {
                        gotAnswer = true;
                        died = true;
                        wrongAnswer.setVisibility(View.VISIBLE);
                        dead.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        answerToOGE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerToOGE.setText("");
            }
        });

        redLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startEge) {
                    consequenceRed.setVisibility(View.VISIBLE);
                    died = true;
                    dead.setVisibility(View.VISIBLE);
                    startEge = false;
                }
            }
        });
        greenLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startEge) {
                    consequenceGreen.setVisibility(View.VISIBLE);
                    died = true;
                    dead.setVisibility(View.VISIBLE);
                    startEge = false;
                }
            }
        });

        dead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (died) {
                    try {
                        Intent intent = new Intent(ThirdLevel.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    void showOGE() {
        sendToSchool.setVisibility(View.VISIBLE);
        oge.setVisibility(View.VISIBLE);
        answerToOGE.setVisibility(View.VISIBLE);
        exerciseToOGE.setVisibility(View.VISIBLE);
        answered.setVisibility(View.VISIBLE);
        startOge = true;
    }
}
/*
 */