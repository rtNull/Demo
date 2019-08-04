package com.picee.demo.util;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import android.util.DisplayMetrics;

public class AutoSizeUtil {

    private static float sComponentDensity;
    private static float sComponentScaledDensity;

    /**
     * 设置自定义的屏幕密度
     * 在BaseActivity中的onCreate()方法中调用
     */
    public static void setCustomDensity(@NonNull Activity activity, @NonNull final Application application) {
        final DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();

        if (sComponentDensity == 0) {
            sComponentDensity = appDisplayMetrics.density;
            sComponentScaledDensity = appDisplayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0) {
                        sComponentScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }

        final float targetDensity = appDisplayMetrics.widthPixels / 360F;//以360dp(360\*640)和宽维度来适配的
        final float targetScaledDensity = targetDensity * (sComponentScaledDensity / sComponentDensity);
        final int targetDensityDpi = (int) (160 * targetDensity);

        //赋值到application中的density中
        appDisplayMetrics.density = targetDensity;
        appDisplayMetrics.scaledDensity = targetScaledDensity;
        appDisplayMetrics.densityDpi = targetDensityDpi;

        //下面赋值到activity中的density中
        final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = targetDensity;
        appDisplayMetrics.scaledDensity = targetScaledDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;
    }
}
