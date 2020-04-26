package com.example.lesson2.rxjava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson2.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxjavaActivity extends AppCompatActivity {

    private static final String TAG = "Tag";

    private Observable<String> observable;
    private Disposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

        findViewById(R.id.btn_subscribe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subscribe();
            }
        });

        findViewById(R.id.btn_unsubscribe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unsubscribe();
            }
        });

        Presenter presenter = new Presenter();
        observable = presenter.getMessage();
    }

    private void subscribe() {
        observable.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: Вы подписаны! Поток " + Thread.currentThread().getName());
                RxjavaActivity.this.disposable = d;
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: Поток " + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: Поток " + Thread.currentThread().getName());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: Поток " + Thread.currentThread().getName());
            }
        });
        Log.d(TAG, "subscribe: end. Поток " + Thread.currentThread().getName());
    }

    private void unsubscribe() {
        disposable.dispose();
        Log.d(TAG, "unsubscribe: Вы отписаны!");
    }
}
