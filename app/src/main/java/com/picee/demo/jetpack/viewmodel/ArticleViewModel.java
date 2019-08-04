package com.picee.demo.jetpack.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.picee.demo.jetpack.bean.Article;
import com.picee.demo.jetpack.net.RetrofitServiceManager;
import com.picee.demo.jetpack.net.api.ArticleApi;

import java.util.List;

import io.reactivex.schedulers.Schedulers;

public class ArticleViewModel extends ViewModel {
    private final String TAG = "ArticleViewModel";
    public MutableLiveData<List<Article>> articlesLiveData = new MutableLiveData<>();

    public void getArticles() {
        RetrofitServiceManager.getInstance().create(ArticleApi.class)
                .getArticles()
                .subscribeOn(Schedulers.io())
                .subscribe(articleDataResponse -> articlesLiveData.postValue(articleDataResponse.getData().getArticles())
                        , throwable -> throwable.printStackTrace());
    }
}
