package com.test.demo.presenter.presenterinterface;

import com.test.demo.view.viewinterface.HomeScreenView;

public interface HomeScreenPresenter {

    void attachView(HomeScreenView view);

    void detachView();

    void getData();

    void setLogic(int variantGroup, int selectedType);
}
