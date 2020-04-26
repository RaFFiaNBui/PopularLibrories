package com.example.lesson1.moxy.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface MoxyView extends MvpView {

    @StateStrategyType(value = AddToEndStrategy.class)
    void setText(String str);
}
