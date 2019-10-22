package com.test.demo.model.api;

import com.test.demo.model.entity.VarientBase;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    /*
    * Add as many as you can API's for fetching data. collectively here
    * and get response on required screen/Class.
    * */

    @GET("snippets/33/raw")
    Call<VarientBase> getVariantData();
}
