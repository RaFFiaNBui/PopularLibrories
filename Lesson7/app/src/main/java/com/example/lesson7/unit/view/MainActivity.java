package com.example.lesson7.unit.view;

import android.os.Bundle;
import android.widget.TextView;

import com.example.lesson7.R;
import com.example.lesson7.unit.presenter.SumPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements SumView {

    @BindView(R.id.textView_sum)
    TextView textViewSum;

    @InjectPresenter
    SumPresenter sumPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_sum)
    public void onClickShowSum() {
        sumPresenter.getSum();
    }

    @Override
    public void showSum(int sum) {
        textViewSum.setText(String.valueOf(sum));
    }
}
