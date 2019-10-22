package com.test.demo.view.viewinterface;


import com.test.demo.model.entity.VarientBase;


public interface HomeScreenView {

    void showLoading();

    void hideLoading();

    void showError(String errorMessage);

    void setData(VarientBase varientBase);
}
