package com.example.lesson1.mvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson1.R;
import com.example.lesson1.mvp.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText editText;
    private Button button;
    private TextView textView;

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        presenter = new Presenter(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                presenter.onClick(str);
                editText.setText("");
            }
        });
    }

    private void init() {
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.btn_activity_main);
        textView = findViewById(R.id.textView);
    }

    @Override
    public void setText(String str) {
        textView.setText(str);
    }
}
