package com.example.photoclient.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photoclient.R;
import com.example.photoclient.presenter.ThreePresenter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MoxyView {

    private static final String URL = "url";

    MyAdapter myAdapter;

    @InjectPresenter
    ThreePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        myAdapter = new MyAdapter(presenter);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void showPicture(String url) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(URL, url);
        startActivity(intent);
    }

    @Override
    public void updateRecyclerView() {
        myAdapter.notifyDataSetChanged();
    }
}
