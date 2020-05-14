package com.example.lesson_6.withoutDi;

import android.util.Log;

public class Red {

    public Red() {
        Green green = new Green();
        Log.d("Tag", "Red: " + green.show());
        Log.d("Tag", "Red: " + green);
    }
}
