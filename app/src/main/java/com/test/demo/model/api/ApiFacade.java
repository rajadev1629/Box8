package com.test.demo.model.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.demo.AppInstance;
import com.test.demo.R;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFacade {
    private static final int TIME_OUT = 60;
    ApiService api;

    public ApiFacade() {
        setupRetrofit(getGson(false), getOkHttpClient());
    }


    private void setupRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppInstance.getInstance().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        api = retrofit.create(ApiService.class);
    }

    private OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();
    }

    private Gson getGson(boolean serializeNulls) {
        GsonBuilder builder = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        if (serializeNulls)
            builder.serializeNulls();
        return builder.create();
    }

    public ApiService getApiService() {
        return api;
    }

}