package com.example.lesson3.recyclerview.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson3.R;
import com.example.lesson3.recyclerview.presenter.ThreePresenter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class ThreeActivity extends MvpAppCompatActivity implements MoxyView {

    private static final String POSITION = "position";

    @InjectPresenter
    ThreePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        MyAdapter myAdapter = new MyAdapter(presenter);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void showPicture(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(POSITION, position);
        startActivity(intent);
    }
}
