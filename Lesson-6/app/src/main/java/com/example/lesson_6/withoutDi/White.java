package com.example.lesson_6.withoutDi;

import android.util.Log;

public class White {

    public White() {
        Green green = new Green();
        Log.d("Tag", "White: " + green.show());
        Log.d("Tag", "White: " + green);
    }
}
