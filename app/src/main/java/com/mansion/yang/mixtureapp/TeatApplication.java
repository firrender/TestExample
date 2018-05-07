package com.mansion.yang.mixtureapp;

import android.app.Application;

/**
 * Created by: Dry
 * Created on: 2018/4/29
 * Function:
 */

public class TeatApplication extends Application {


    private static TeatApplication application;

    public static TeatApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
    }
}
