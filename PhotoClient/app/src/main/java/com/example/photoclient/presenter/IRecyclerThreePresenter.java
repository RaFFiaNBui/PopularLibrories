package com.example.photoclient.presenter;

import com.example.photoclient.view.IViewHolder;

public interface IRecyclerThreePresenter {
    void bindView(IViewHolder iViewHolder);
    int getItemCount();
    void counter(int position);
}
