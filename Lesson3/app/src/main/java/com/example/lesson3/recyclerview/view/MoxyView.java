package com.example.lesson3.recyclerview.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface MoxyView extends MvpView {

    @StateStrategyType(value = AddToEndSingleStrategy.class)
    void showPicture(int position);
}
