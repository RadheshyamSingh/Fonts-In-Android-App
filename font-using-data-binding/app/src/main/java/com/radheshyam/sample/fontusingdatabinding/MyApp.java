package com.radheshyam.sample.fontusingdatabinding;

import android.app.Application;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

       initializeFonts();
    }

    private void initializeFonts() {
        FontsManager.getInstance(this);
    }
}
