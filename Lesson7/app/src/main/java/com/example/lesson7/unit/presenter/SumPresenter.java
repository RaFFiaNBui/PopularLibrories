package com.example.lesson7.unit.presenter;

import com.example.lesson7.unit.model.Numbers;
import com.example.lesson7.unit.view.SumView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class SumPresenter extends MvpPresenter<SumView> {

    private Numbers numbers;

    public SumPresenter() {
        numbers = new Numbers();
    }

    public int getSum() {
        int sum = numbers.getA() + numbers.getB();
        getViewState().showSum(sum);
        return sum;
    }
}
