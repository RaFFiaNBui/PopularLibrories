package com.example.lesson4.gson;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson4.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonActivity extends AppCompatActivity {

    private static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = "{\"time_of_year\": \"summer\", \"year\": 2019}";

        Gson gson = new GsonBuilder().create();
        Season season = gson.fromJson(json, Season.class);

        Log.d(TAG, "onCreate: " + season.time_of_year);
        Log.d(TAG, "onCreate: " + season.year);
    }
}
