package com.example.lesson2.rxjava;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

//package-private
class Presenter {

    private static final String TAG = "Tag";

    //package-private
    Observable<String> getMessage() {

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                int counter = 1;
                for (int i = 0; i < 8; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    Log.d(TAG, "subscribe: Сообщение: " + counter + ". Поток " + Thread.currentThread().getName());
                    counter++;
                }
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io());

        return observable;
    }
}
