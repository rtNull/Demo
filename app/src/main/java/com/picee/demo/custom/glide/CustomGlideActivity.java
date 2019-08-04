package com.picee.demo.custom.glide;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.picee.demo.R;
import com.picee.demo.custom.glide.bean.AppInfo;

public class CustomGlideActivity extends AppCompatActivity {
    private ImageView ivAppIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_glide);
        ivAppIcon = findViewById(R.id.iv_app_icon);
        Glide.with(this)
                .load(new AppInfo("com.ss.android.article.news", ""))
                .into(ivAppIcon);
    }
}
