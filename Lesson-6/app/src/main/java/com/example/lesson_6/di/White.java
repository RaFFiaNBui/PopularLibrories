package com.example.lesson_6.di;

import android.util.Log;

public class White {

    private Green green;

    public White(Green green) {
        this.green = green;
        Log.d("Tag", "White: " + green.show());
        Log.d("Tag", "White: " + green);
    }
}
