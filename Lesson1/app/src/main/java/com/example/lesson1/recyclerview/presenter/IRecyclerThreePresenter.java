package com.example.lesson1.recyclerview.presenter;

import com.example.lesson1.recyclerview.view.IViewHolder;

public interface IRecyclerThreePresenter {
    void bindView(IViewHolder iViewHolder);
    int getItemCount();
    void counter();
}
