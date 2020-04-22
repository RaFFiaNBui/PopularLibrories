package com.example.lesson1.recyclerview.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson1.R;
import com.example.lesson1.recyclerview.presenter.ThreePresenter;

public class ThreeActivity extends AppCompatActivity {

    private ThreePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        presenter = new ThreePresenter();
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        MyAdapter myAdapter = new MyAdapter(presenter.getRecyclerMainPresenter());
        recyclerView.setAdapter(myAdapter);
    }
}
