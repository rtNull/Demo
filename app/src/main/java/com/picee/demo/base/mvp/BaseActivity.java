package com.picee.demo.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.picee.demo.util.AutoSizeUtil;

public abstract class BaseActivity<V extends BaseMvpView, P extends BaseMvpPresenter<V>> extends AppCompatActivity implements BaseMvpView {
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AutoSizeUtil.setCustomDensity(this, getApplication());
        if (presenter == null) {
            presenter = createPresenter();
        }
        if (presenter != null) {
            presenter.attachMvpView((V) this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachMvpView();
        }
    }

    public P getPresenter() {
        return presenter;
    }

    public abstract P createPresenter();

}
