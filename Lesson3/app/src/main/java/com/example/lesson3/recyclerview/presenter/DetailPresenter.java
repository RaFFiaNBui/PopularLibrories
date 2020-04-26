package com.example.lesson3.recyclerview.presenter;

import android.util.Log;

import com.example.lesson3.recyclerview.view.DetailMoxyView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class DetailPresenter extends MvpPresenter<DetailMoxyView> {

    private static final String TAG = "tag";

    public void showPosition(int position) {
        Log.d(TAG, "DetailPresenter.showPosition: " + position);
    }
}
