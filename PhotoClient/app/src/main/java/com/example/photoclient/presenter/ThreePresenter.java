package com.example.photoclient.presenter;

import android.util.Log;

import com.example.photoclient.model.gson.Hit;
import com.example.photoclient.model.gson.Photo;
import com.example.photoclient.model.retrofit.ApiRequest;
import com.example.photoclient.view.IViewHolder;
import com.example.photoclient.view.MoxyView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class ThreePresenter extends MvpPresenter<MoxyView> implements RecyclerPresenter {

    private static final String TAG = "tag";

    private List<Hit> hitList;
    private ApiRequest api;

    public ThreePresenter() {
        this.api = new ApiRequest();
    }

    @Override
    protected void onFirstViewAttach() {
        getAllPhoto();
    }

    private void getAllPhoto() {
        Observable<Photo> single = api.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(photo -> {
                    hitList = photo.hits;
                    getViewState().updateRecyclerView();
                }, throwable -> Log.d(TAG, "getAllPhoto: Error" + throwable)
        );
    }

    @Override
    public void bindView(IViewHolder holder) {
        holder.setImage(hitList.get(holder.getPos()).webformatURL);
    }

    @Override
    public int getItemCount() {
        if (hitList != null) {
            return hitList.size();
        }
        return 0;
    }

    @Override
    public void getUrl(String url) {
        getViewState().showPicture(url);
    }
}
