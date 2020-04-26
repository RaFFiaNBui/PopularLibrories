package com.example.lesson1.recyclerview.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson1.R;
import com.example.lesson1.recyclerview.presenter.IRecyclerThreePresenter;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private IRecyclerThreePresenter iRecyclerMainPresenter;

    //package-private
    MyAdapter(IRecyclerThreePresenter iRecyclerMainPresenter) {
        this.iRecyclerMainPresenter = iRecyclerMainPresenter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity_three, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        iRecyclerMainPresenter.bindView(holder);
    }

    @Override
    public int getItemCount() {
        return iRecyclerMainPresenter.getItemCount();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements IViewHolder {

        private ImageView imageView;

        //package-private
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iRecyclerMainPresenter.counter();
                }
            });
        }

        @Override
        public void setImage() {
            imageView.setImageResource(R.drawable.btn_rating_star_off_pressed_holo_dark);
        }
    }
}
