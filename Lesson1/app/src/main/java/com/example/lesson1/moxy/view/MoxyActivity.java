package com.example.lesson1.moxy.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.lesson1.R;
import com.example.lesson1.moxy.presenter.MoxyPresenter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MoxyActivity extends MvpAppCompatActivity implements MoxyView {

    private EditText editText;
    private Button button;
    private TextView textView;

    @InjectPresenter
    MoxyPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                presenter.onClick(str);
                editText.setText("");
            }
        });
    }

    @Override
    public void setText(String str) {
        textView.setText(str);
    }

    private void init() {
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.btn_activity_main);
        textView = findViewById(R.id.textView);
    }
}
