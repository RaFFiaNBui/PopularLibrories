package com.example.lesson3.recyclerview.view;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.lesson3.R;
import com.example.lesson3.recyclerview.presenter.DetailPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class DetailActivity extends MvpAppCompatActivity implements DetailMoxyView {

    private static final String POSITION = "position";

    @InjectPresenter
    DetailPresenter detailPresenter;

    @BindView(R.id.detail_img)
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);
        imageView.setImageResource(R.drawable.btn_rating_star_off_pressed_holo_dark);

        int position = getIntent().getIntExtra(POSITION, 0);
        detailPresenter.showPosition(position);
    }

    @Override
    public void empty(int position) {
    }
}
