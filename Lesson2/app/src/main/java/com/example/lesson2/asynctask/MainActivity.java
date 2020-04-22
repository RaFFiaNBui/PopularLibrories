package com.example.lesson2.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson2.R;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_main_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute();
                Log.d(TAG, "onClick: " + Thread.currentThread().getName());
            }
        });
    }

    private static class MyAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i < 5; i++) {
                try {
                    Log.d(TAG, "doInBackground: Сообщение: " + (i + 1) + "; Поток: " + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(TAG, "onPostExecute: метод AsyncTask завершен. Поток: " + Thread.currentThread().getName());
        }
    }
}
