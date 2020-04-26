package com.example.lesson3.single;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

//package-private
class SinglePresenter {

    private static final String TAG = "Tag";

    //package-private
    Single<String> getMessage() {
        Single<String> single = Single.create((SingleOnSubscribe<String>) emitter -> {
            String msg = "Сообщение";
            Log.d(TAG, "getMessage: " + msg + Thread.currentThread().getName());
            emitter.onSuccess(msg);
        }).subscribeOn(Schedulers.io());

        return single;
    }
}
