package com.example.lesson3.single;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson3.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SingleActivity extends AppCompatActivity {

    private static final String TAG = "tag";

    private Single<String> single;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);

        ButterKnife.bind(this);
        SinglePresenter presenter = new SinglePresenter();
        single = presenter.getMessage();
    }

    @OnClick(R.id.btn_send)
    public void sendMessage() {
        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(string -> {
            Log.d(TAG, "sendMessage: " + string);
        }, throwable -> {
            Log.e(TAG, "sendMessage: ", throwable);
        });
    }
}
