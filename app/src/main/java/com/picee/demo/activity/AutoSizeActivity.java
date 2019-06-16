package com.picee.demo.activity;

import android.os.Bundle;

import com.picee.demo.R;
import com.picee.demo.base.mvp.BaseActivity;
import com.picee.demo.mvpview.AutoSizeMvpView;
import com.picee.demo.presenter.AutoSizePresenter;

public class AutoSizeActivity extends BaseActivity<AutoSizeMvpView,AutoSizePresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_size);
    }

    @Override
    public AutoSizePresenter createPresenter() {
        return null;
    }
}
