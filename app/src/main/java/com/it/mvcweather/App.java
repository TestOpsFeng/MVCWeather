package com.it.mvcweather;

import android.app.Application;
import android.content.Context;

/**
 * Created by lenovo on 2017/10/18.
 */
public class App extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
