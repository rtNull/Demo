package com.picee.demo.jetpack.net.api;

import com.picee.demo.jetpack.bean.ArticleData;
import com.picee.demo.jetpack.bean.Response;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ArticleApi {
    @GET("article/list/0/json")
    public Single<Response<ArticleData>> getArticles();
}
