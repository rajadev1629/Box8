package com.test.demo.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.test.demo.R;
import com.test.demo.model.entity.VariantGroup;
import com.test.demo.model.entity.Variation;
import com.test.demo.model.entity.VarientBase;
import com.test.demo.presenter.HomeScreenPresenterImpl;
import com.test.demo.presenter.presenterinterface.HomeScreenPresenter;
import com.test.demo.utils.DialogUtils;
import com.test.demo.view.viewinterface.HomeScreenView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HomeScreenView {


    @BindView(R.id.crust)
    RadioGroup radioGroupCrust;
    @BindView(R.id.size)
    RadioGroup radioGroupSize;
    @BindView(R.id.sauce)
    RadioGroup radioGroupSauce;

    @BindView(R.id.txt_base)
    TextView txtBase;
    @BindView(R.id.txt_size)
    TextView txtSize;
    @BindView(R.id.txt_sauce)
    TextView txtSauce;


    private HomeScreenPresenter presenter;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new HomeScreenPresenterImpl();
        presenter.attachView(this);
        presenter.getData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void showLoading() {
        DialogUtils.showProgressDialog(this);
    }

    @Override
    public void hideLoading() {
        DialogUtils.hideProgressDialog();
    }

    @Override
    public void showError(String errorMessage) {
        DialogUtils.showErrorMessage(this, errorMessage);
    }

    @Override
    public void setData(VarientBase varientBase) {
        for (VariantGroup variantGroup : varientBase.variants.variantGroups) {
            int id = 0;
            getHeadingType(variantGroup.groupId).setText(variantGroup.name);
            RadioGroup radioGroup = getType(variantGroup.groupId);

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int index) {
                    System.out.println("kkkkk radio id:: "+index);

                    presenter.setLogic(getIndex(radioGroup), index);

                }
            });
            for (Variation variation : variantGroup.variations) {

                RadioButton radioButton = new RadioButton(this);
                radioButton.setId(id);
                radioButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                radioButton.setText(variation.name);
                radioButton.setTextColor(Color.RED);
                radioGroup.addView(radioButton);
                id++;
            }
        }

    }

    private RadioGroup getType(String type) {
        if (type.equals("1"))
            return radioGroupCrust;
        else if (type.equals("2"))
            return radioGroupSize;
        else if (type.equals("3"))
            return radioGroupSauce;
        return null;
    }

    private TextView getHeadingType(String type) {
        if (type.equals("1"))
            return txtBase;
        else if (type.equals("2"))
            return txtSauce;
        else
            return txtSize;
    }

    private int getIndex(RadioGroup radioGroup) {
        if (radioGroup == radioGroupCrust)
            return 0;
        else if (radioGroup == radioGroupSize)
            return 1;
        else
            return 2;
    }


}
