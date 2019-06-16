package com.picee.demo.base.mvp;

public abstract class BaseMvpPresenter<V extends BaseMvpView> {
    private V baseMvpView;

    public void attachMvpView(V mvpView) {
        this.baseMvpView = mvpView;
    }

    public void detachMvpView() {
        this.baseMvpView = null;
    }

    public V getMvpView() {
        return baseMvpView;
    }
}
