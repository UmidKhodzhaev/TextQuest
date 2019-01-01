package com.example.umidi.textquest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class FirstLevel extends AppCompatActivity {
    private String text1 = "Ха думал я дам тебе выбрать имя???";
    private String text2 = "Тебя будут звать...";
    private String text4 = "Ах ты так?\nВ наказание тебе не дается права выбора имени!";
    private String text5 = "Ануфрий";
    boolean ready = false, ready2 = false;
    TextView textView1, textView2, textView3;
    EditText name;
    Button cont, check, to2level;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_level);
        name =(EditText) findViewById(R.id.editText);
        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        cont = (Button)findViewById(R.id.button);
        check =(Button)findViewById(R.id.check);
        to2level =(Button)findViewById(R.id.to2level);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((name.getText().toString()).length() < 3){
                    textView1.setText(text4);
                    cont.setText(text2);
                    cont.setBackgroundColor(Color.CYAN);
                    ready = true;
                }
                else{
                    textView1.setText(text1);
                    cont.setText(text2);
                    cont.setBackgroundColor(Color.CYAN);
                    ready = true;
                }
            }
        });
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ready) {
                    textView2.setText(text5);
                    to2level.setBackgroundColor(Color.WHITE);
                    to2level.setText("Далее...");
                    ready2 = true;
                }
            }
        });
        to2level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ready2) {
                    try {
                        Intent intent = new Intent(FirstLevel.this, SecondLevel.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
