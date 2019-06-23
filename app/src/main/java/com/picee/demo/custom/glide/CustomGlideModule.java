package com.picee.demo.custom.glide;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
//import com.bumptech.glide.module.GlideModule;
import com.picee.demo.custom.glide.bean.AppInfo;

import java.io.InputStream;

@GlideModule
public class CustomGlideModule extends AppGlideModule {
    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        super.registerComponents(context, glide, registry);
        registry.prepend(AppInfo.class, InputStream.class, new AppModelLoaderFactory(context));
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return true;
    }

}

/**
 * 才用Glide3.X的自定义加载注册方式，需要在manifest配置
 * <meta-data
 * android:name="com.picee.demo.custom.glide.CustomGlideModule"
 * android:value="GlideModule" />
 */
//public class CustomGlideModule implements GlideModule {
//    @Override
//    public void applyOptions(Context context, GlideBuilder builder) {
//    }
//
//    @Override
//    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
//        registry.prepend(AppInfo.class, InputStream.class, new AppModelLoaderFactory(context));
//    }
//}