package com.example.lesson3.rxjava;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

//package-private
class Presenter {

    private static final String TAG = "Tag";

    //package-private
    Observable<String> getMessage() {

        Observable<String> observable = Observable.create((ObservableOnSubscribe<String>) emitter -> {

            try {
                for (int i = 0; i < 8; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    String string = "Сообщение: " + (i + 1);
                    Log.d(TAG, "subscribe: " + string + ". Поток " + Thread.currentThread().getName());
                    emitter.onNext(string);
                }
                emitter.onComplete();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).subscribeOn(Schedulers.io());

        return observable;
    }
}
