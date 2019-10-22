package com.test.demo;

import android.app.Application;

/**
 * Created by Tarun on 3/15/2016.
 */

/**
 *
 */
public class AppInstance extends Application {

    private static AppInstance instance;

    public static AppInstance getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
