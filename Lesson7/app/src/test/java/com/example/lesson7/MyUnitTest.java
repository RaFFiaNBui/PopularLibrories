package com.example.lesson7;

import com.example.lesson7.unit.presenter.SumPresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyUnitTest {

    private SumPresenter sumPresenter;

    @Before
    public void before() {
        sumPresenter = new SumPresenter();
    }

    @Test
    public void sumIsCorrect () {
        int sum = sumPresenter.getSum();
        Assert.assertEquals(sum, 90);
    }

    @Test
    public void sumIsIncorrect () {
        int sum = sumPresenter.getSum();
        Assert.assertNotEquals(sum, 91);
    }

    @Test
    public void errorTest () {
        int sum = sumPresenter.getSum();
        Assert.assertEquals(sum, 91);
    }
}
