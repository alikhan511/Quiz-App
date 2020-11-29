package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView2 = findViewById(R.id.textView2);
        Intent intent = getIntent();
        int count = intent.getIntExtra("Result", -1);
        textView2.setText("Your result is " + count +"/5");
    }
}