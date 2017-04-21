package com.ashok.simplemvp.others;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ashok on 20/04/17.
 */

public class MyPresenter implements IPresenter {

    IPresentation presentation;

    public MyPresenter(IPresentation presentation) {
        this.presentation = presentation;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onButtonClicked() {
        final NetworkService networkService = NetworkService.retrofit.create(NetworkService.class);
        networkService.getRepoContributors("akjangra", "SimpleMVP").enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                presentation.updateText("onResponse : " + response.body().toString());
                Log.d("qwer", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                presentation.updateText("onFailure");
                Log.e("qwer", t.toString());
            }
        });
    }


    @Override
    public void onDestroy() {
        this.presentation = null;
    }
}
