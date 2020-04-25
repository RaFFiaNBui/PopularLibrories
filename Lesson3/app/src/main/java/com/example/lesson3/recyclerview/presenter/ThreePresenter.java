package com.example.lesson3.recyclerview.presenter;

import com.example.lesson3.recyclerview.model.Data;
import com.example.lesson3.recyclerview.view.IViewHolder;
import com.example.lesson3.recyclerview.view.MoxyView;

import java.util.List;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class ThreePresenter extends MvpPresenter<MoxyView> implements IRecyclerThreePresenter {

    private List<String> list;

    public ThreePresenter() {
        Data data = new Data();
        this.list = data.getList();
    }

    @Override
    public void bindView(IViewHolder holder) {
        holder.setImage();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void counter(int position) {
        getViewState().showPicture(position);
    }
}
