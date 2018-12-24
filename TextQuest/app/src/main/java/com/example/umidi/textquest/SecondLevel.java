package com.example.umidi.textquest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondLevel extends AppCompatActivity {
    Button cry, openEyes, nothingToDo, dead, superpower, nothing, to3level;
    ImageView imageRozetka;
    TextView answer, rozetka, consequences, story;
    String textCry = "Поздравляю тебя заметили, и признали живым.", textOpeneyes = "К сожалению ты погиб, тебя выкинули в мусорку, ибо ты в мире, где все слепые. УПС...",
            textNothing = "Тебя выкинули в мусорку, так как посчитали, что ты мертв. УПС...", textRozetka = "Прошло уже чуть больше 4 года\n" +
            "И ты заметил две странных круглых дырки на стене...",
            textSuperpower = "Вас ударило током, но вы каким то чудом уцелели...",
            textConsequences = "Скучный ты...";
    boolean hasAnswered = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_level);
        cry = (Button) findViewById(R.id.cry);
        openEyes = (Button) findViewById(R.id.openEyes);
        nothingToDo = (Button) findViewById(R.id.nothingToDo);
        dead = (Button) findViewById(R.id.dead);
        nothing = (Button) findViewById(R.id.nothing);
        superpower = (Button) findViewById(R.id.superPower);
        answer = (TextView) findViewById(R.id.textAnswerOnButton);
        rozetka = (TextView) findViewById(R.id.textSuperpower);
        story = (TextView) findViewById(R.id.textStory);
        consequences = (TextView) findViewById(R.id.textConsequences);
        imageRozetka = (ImageView) findViewById(R.id.imageRozetka);
        to3level =(Button)findViewById(R.id.to3level);
        imageRozetka.setVisibility(View.INVISIBLE);
        cry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hasAnswered) {
                    answer.setText(textCry);
                    hasAnswered = true;
                    alive(story, rozetka, consequences, superpower, nothing, imageRozetka);
                }
            }
        });
        openEyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hasAnswered) {
                    answer.setText(textOpeneyes);
                    hasAnswered = true;
                    died(dead);
                }
            }
        });
        nothingToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hasAnswered) {
                    answer.setText(textNothing);
                    hasAnswered = true;
                    died(dead);
                }
            }
        });
    }

void died(Button dead){
    dead.setText("Нажмите чтобы начать заного");
    dead.setBackgroundColor(Color.BLACK);
    dead.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                Intent intent = new Intent(SecondLevel.this, MainActivity.class);startActivity(intent);finish();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    });
}
private void alive(final TextView story, final TextView rozetka, final TextView consequences, Button superpower, Button nothing, ImageView imageRozetka){
        story.setText(textRozetka);
        imageRozetka.setVisibility(View.VISIBLE);
        superpower.setText("Потрогать и изучить...");
        nothing.setText("Не трогать!");
        superpower.setBackgroundColor(Color.WHITE);
        nothing.setBackgroundColor(Color.WHITE);
        superpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    rozetka.setText(textSuperpower);
                    nextlevel(to3level);
            }
        });
        nothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consequences.setText(textConsequences);
                nextlevel(to3level);
            }
        });
    }
void nextlevel(Button to3level){
    to3level.setText("Нажмите чтобы продолжить");
    to3level.setBackgroundColor(Color.CYAN);
    to3level.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                Intent intent = new Intent(SecondLevel.this, ThirdLevel.class);startActivity(intent);finish();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    });
}

}

