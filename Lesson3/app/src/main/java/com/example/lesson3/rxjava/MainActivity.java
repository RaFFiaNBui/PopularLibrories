package com.example.lesson3.rxjava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson3.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tag";

    private Observable<String> observable;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Presenter presenter = new Presenter();
        observable = presenter.getMessage();
    }

    @OnClick(R.id.btn_subscribe)
    public void subscribe() {
        disposable = observable.observeOn(AndroidSchedulers.mainThread()).subscribe(string -> {
            Log.d(TAG, "onNext: " + string + ". Поток " + Thread.currentThread().getName());
        }, throwable -> {
            Log.e(TAG, "onError: Поток " + Thread.currentThread().getName());
        }, () -> {
            Log.d(TAG, "onComplete: Поток " + Thread.currentThread().getName());
        });
        //Log.d(TAG, "subscribe: end. Поток " + Thread.currentThread().getName());
    }

    @OnClick(R.id.btn_unsubscribe)
    public void unsubscribe(View view) {
        disposable.dispose();
        Log.d(TAG, "unsubscribe: Вы отписаны!");
    }

}
