package com.test.demo.presenter;

import com.test.demo.AppInstance;
import com.test.demo.R;
import com.test.demo.model.entity.ExcludeList;
import com.test.demo.model.entity.VariantGroup;
import com.test.demo.model.entity.VarientBase;
import com.test.demo.presenter.presenterinterface.HomeScreenPresenter;
import com.test.demo.view.viewinterface.HomeScreenView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreenPresenterImpl extends BasePresenter<HomeScreenView> implements HomeScreenPresenter {


    private VarientBase varientBase;
    @Override
    public void getData() {

        if (view == null)
            return;

        if (!isNetworkAvailable()) {
            view.showError(AppInstance.getInstance().getString(R.string.error_internet));
            return;
        }

        view.showLoading();


        apiFacade.getApiService().getVariantData().enqueue(new Callback<VarientBase>() {
            @Override
            public void onResponse(Call<VarientBase> call, Response<VarientBase> response) {
                if (view == null)
                    return;
                view.hideLoading();
                if (!response.isSuccessful() && response.body() == null)
                    return;
                varientBase = response.body();
                view.setData(varientBase);

            }

            @Override
            public void onFailure(Call<VarientBase> call, Throwable t) {

            }
        });

    }

    @Override
    public void setLogic(int variantGroup, int selectedType) {
        List<VariantGroup> variantGroupData = varientBase.variants.variantGroups;

        VariantGroup group = variantGroupData.get(variantGroup);
        String groupId = group.groupId;
        String id = variantGroupData.get(variantGroup).variations.get(selectedType).id;

        for (List<ExcludeList> excludeLists : varientBase.variants.excludeList) {
            for (ExcludeList excludeList : excludeLists) {
//                if (match) {
//                    view.showError("some error message", variantGroup , selectedType);
//                }
            }
        }

//        if (group.groupId.)

    }


}
