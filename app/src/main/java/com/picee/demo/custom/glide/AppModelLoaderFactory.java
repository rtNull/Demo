package com.picee.demo.custom.glide;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.picee.demo.custom.glide.bean.AppInfo;

import java.io.InputStream;

public class AppModelLoaderFactory implements ModelLoaderFactory<AppInfo, InputStream> {
    private Context context;

    public AppModelLoaderFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ModelLoader<AppInfo, InputStream> build(@NonNull MultiModelLoaderFactory multiFactory) {
        return new AppIconModelLoader(context);
    }

    @Override
    public void teardown() {

    }
}