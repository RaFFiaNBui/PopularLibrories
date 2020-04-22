package com.example.lesson2.observer;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson2.R;

public class ObserverActivity extends AppCompatActivity {

    private Spam spam = new Spam();
    private Iam iam = new Iam();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);

        findViewById(R.id.btn_subscribe).setOnClickListener(listener);
        findViewById(R.id.btn_unsubscribe).setOnClickListener(listener);
        findViewById(R.id.btn_spam).setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_subscribe:
                    spam.subscribeObserver(iam);
                    break;
                case R.id.btn_unsubscribe:
                    spam.unsubscribeObserver(iam);
                    break;
                case R.id.btn_spam:
                    spam.newSpam();
                    break;
            }
        }
    };
}
