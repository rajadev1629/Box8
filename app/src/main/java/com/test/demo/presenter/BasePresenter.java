package com.test.demo.presenter;

import com.test.demo.model.api.ApiFacade;
import com.test.demo.utils.ConnectionUtils;

public class BasePresenter<T> {

    protected ApiFacade apiFacade;
    protected T view;

    public BasePresenter() {
        this.apiFacade = new ApiFacade();
    }

    public void attachView(T view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    protected boolean isNetworkAvailable() {
        return ConnectionUtils.isInternetAvailable();
    }

}