package com.example.lesson2.observer;

import android.util.Log;

public class Iam implements Observer {

    private static final String TAG = "Tag";

    @Override
    public void update(int counter) {
        Log.d(TAG, "Пришел спам №: " + counter + ". Поток: " + Thread.currentThread().getName());
    }
}
