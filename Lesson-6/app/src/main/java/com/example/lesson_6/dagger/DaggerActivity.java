package com.example.lesson_6.dagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.lesson_6.R;
import com.example.lesson_6.dagger.app.App;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity {

    @Inject
    Green green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getAppComponent().inject(this);

        new Red();
        new White();

        Log.d("Tag", "onCreate: " + green.show());
        Log.d("Tag", "onCreate: " + green);
    }
}
