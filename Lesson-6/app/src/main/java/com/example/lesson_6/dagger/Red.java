package com.example.lesson_6.dagger;

import android.util.Log;

import com.example.lesson_6.dagger.app.App;

import javax.inject.Inject;

public class Red {

    @Inject
    Green green;

    public Red() {
        App.getAppComponent().inject(this);
        Log.d("Tag", "Red: " + green.show());
        Log.d("Tag", "Red: " + green);
    }
}
