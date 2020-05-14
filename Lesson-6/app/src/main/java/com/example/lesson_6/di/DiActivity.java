package com.example.lesson_6.di;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson_6.R;

public class DiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Green green = new Green();
        Red red = new Red(green);
        White white = new White(green);
    }
}
