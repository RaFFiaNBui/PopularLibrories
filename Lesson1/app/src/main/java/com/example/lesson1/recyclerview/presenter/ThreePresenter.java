package com.example.lesson1.recyclerview.presenter;

import android.util.Log;

import com.example.lesson1.recyclerview.model.Data;
import com.example.lesson1.recyclerview.view.IViewHolder;

import java.util.List;

public class ThreePresenter {

    private RecyclerThreePresenter recyclerMainPresenter = new RecyclerThreePresenter();

    private static class RecyclerThreePresenter implements IRecyclerThreePresenter {

        private Data data = new Data();
        private List<String> list = data.getList();

        @Override
        public void bindView(IViewHolder holder) {
            holder.setImage();
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        @Override
        public void counter() {
            int oldCount = data.getCount();
            int newCount = oldCount + 1;
            data.setCount(newCount);
            Log.d("TAG", "counter: " + newCount);
        }
    }

    public RecyclerThreePresenter getRecyclerMainPresenter() {
        return recyclerMainPresenter;
    }
}
