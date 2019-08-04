package com.picee.demo.custom.glide;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import android.util.Log;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.picee.demo.custom.glide.bean.AppInfo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AppIconFetcher implements DataFetcher<InputStream> {
    private final String TAG = "AppIconFetcher";
    private AppInfo appInfo;
    private Context context;
    private final PackageManager packageManager;
    private InputStream inputStream;
    private volatile boolean isCancelled;

    public AppIconFetcher(Context context, AppInfo appInfo) {
        this.context = context;
        this.appInfo = appInfo;
        packageManager = context.getPackageManager();
    }

    @Override
    public void loadData(@NonNull Priority priority, @NonNull DataCallback<? super InputStream> callback) {
        Log.d(TAG, "loadData: ");
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = packageManager.getApplicationInfo(appInfo.getPackageName(), 0);
            Drawable drawable = applicationInfo.loadIcon(packageManager);
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap iconBitmap = bitmapDrawable.getBitmap();
            inputStream = bitmapToInputStream(iconBitmap);
            callback.onDataReady(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            callback.onLoadFailed(e);
        }
    }

    private InputStream bitmapToInputStream(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Override
    public void cleanup() {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void cancel() {
        isCancelled = true;
    }

    @NonNull
    @Override
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @NonNull
    @Override
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}