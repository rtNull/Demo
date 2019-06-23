package com.picee.demo.custom.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.picee.demo.custom.glide.bean.AppInfo;

import java.io.InputStream;

public class AppIconModelLoader implements ModelLoader<AppInfo, InputStream> {
    private Context context;
    public AppIconModelLoader(Context context){
        this.context = context;

    }

    @Nullable
    @Override
    public LoadData<InputStream> buildLoadData(@NonNull AppInfo apkIconModel, int width, int height, @NonNull Options options) {
       return new LoadData<>(new ObjectKey(apkIconModel.getPackageName()),new AppIconFetcher(context,apkIconModel));
    }

    @Override
    public boolean handles(@NonNull AppInfo apkIconModel) {
        return true;
    }


}