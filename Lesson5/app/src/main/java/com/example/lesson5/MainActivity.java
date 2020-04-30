package com.example.lesson5;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        userPresenter = new UserPresenter();
    }

    @OnClick({R.id.btn_add_one_user, R.id.btn_add_some_user,
            R.id.btn_delete_user, R.id.btn_update_user, R.id.btn_all_users})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_one_user:
                userPresenter.addOneUser();
                break;
            case R.id.btn_add_some_user:
                userPresenter.addSomeUser();
                break;
            case R.id.btn_delete_user:
                userPresenter.deleteUser();
                break;
            case R.id.btn_update_user:
                userPresenter.updateUser();
                break;
            case R.id.btn_all_users:
                userPresenter.getAllData();
                break;
        }
    }
}
