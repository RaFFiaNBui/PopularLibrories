package com.example.lesson4.retrofit;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RetrofitPresenter {

    private static final String TAG = "tag";

    private RetrofitApi retrofitApi;

    public RetrofitPresenter() {
        retrofitApi = new RetrofitApi();
    }

    public void getString() {
        Observable<String> single = retrofitApi.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(str -> {
            Log.d(TAG, "getString: " + str);
        }, throwable -> {
            Log.e(TAG, "getString: ", throwable);
        });
    }
}
