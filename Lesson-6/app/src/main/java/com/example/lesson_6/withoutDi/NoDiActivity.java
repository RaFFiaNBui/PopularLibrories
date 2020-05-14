package com.example.lesson_6.withoutDi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson_6.R;

public class NoDiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Red();
        new White();
    }
}
