package com.example.lesson2.observer;

import android.util.Log;

import java.util.ArrayList;

public class Spam implements Observable {

    private static final String TAG = "Tag";

    private ArrayList<Observer> arrayList;
    private int counter = 1;

    //package-private
    Spam() {
        arrayList = new ArrayList<>();
    }

    //package-private
    void newSpam() {
        notifyAllObservers();
        counter++;
    }

    @Override
    public void subscribeObserver(Observer observer) {
        Log.d(TAG, "subscribeObserver: подписка оформлена. Поток: " + Thread.currentThread().getName());
        arrayList.add(observer);
    }

    @Override
    public void unsubscribeObserver(Observer observer) {
        Log.d(TAG, "unsubscribeObserver: подписка отменена. Поток: " + Thread.currentThread().getName());
        arrayList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (int i = 0; i < arrayList.size(); i++) {
            Observer observer = arrayList.get(i);
            observer.update(counter);
        }
    }
}
