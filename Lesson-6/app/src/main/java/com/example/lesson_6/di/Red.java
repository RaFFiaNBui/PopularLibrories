package com.example.lesson_6.di;

import android.util.Log;

public class Red {

    private Green green;

    public Red(Green green) {
        this.green = green;
        Log.d("Tag", "Red: " + green.show());
        Log.d("Tag", "Red: " + green);
    }
}
