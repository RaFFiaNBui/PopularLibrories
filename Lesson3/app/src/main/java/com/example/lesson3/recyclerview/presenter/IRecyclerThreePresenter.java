package com.example.lesson3.recyclerview.presenter;

import com.example.lesson3.recyclerview.view.IViewHolder;

public interface IRecyclerThreePresenter {
    void bindView(IViewHolder iViewHolder);
    int getItemCount();
    void counter(int position);
}
