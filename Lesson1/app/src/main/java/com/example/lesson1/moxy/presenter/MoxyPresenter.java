package com.example.lesson1.moxy.presenter;

import com.example.lesson1.moxy.model.MoxyModel;
import com.example.lesson1.moxy.view.MoxyView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MoxyPresenter extends MvpPresenter<MoxyView> {

    private MoxyModel model;

    public MoxyPresenter() {
        this.model = new MoxyModel();
    }

    private String toConnect(String str1, String str2) {
        return str1 + str2;
    }

    public void onClick(String str2) {
        String str1 = model.getString();
        String result = toConnect(str1, str2);
        model.setString(result);
        getViewState().setText(result);
    }
}
