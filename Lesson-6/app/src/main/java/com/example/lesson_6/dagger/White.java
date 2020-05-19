package com.example.lesson_6.dagger;

import android.util.Log;

import com.example.lesson_6.dagger.app.App;

import javax.inject.Inject;

public class White {

    @Inject
    Green green;

    public White() {
        App.getAppComponent().inject(this);
        Log.d("Tag", "White: " + green.show());
        Log.d("Tag", "White: " + green);
    }
}
