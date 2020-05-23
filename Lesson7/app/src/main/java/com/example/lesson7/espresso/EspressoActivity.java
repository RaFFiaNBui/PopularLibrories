package com.example.lesson7.espresso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.lesson7.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EspressoActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onClick() {
        textView.setText(R.string.hello);
    }
}
