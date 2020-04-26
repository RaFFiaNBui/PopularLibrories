package com.example.lesson1.mvp.presenter;

import com.example.lesson1.mvp.model.Model;
import com.example.lesson1.mvp.view.MainView;

public class Presenter {

    private Model model;
    private MainView mainView;

    public Presenter(MainView mainView) {
        this.mainView = mainView;
        model = new Model();
    }

    private String toConnect(String str1, String str2) {
        return str1 + str2;
    }

    public void onClick(String str2) {
        String str1 = model.getString();
        String result = toConnect(str1, str2);
        model.setString(result);
        mainView.setText(result);
    }
}
