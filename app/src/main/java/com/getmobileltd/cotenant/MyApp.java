package com.getmobileltd.cotenant;

import android.app.Application;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "assets/fonts/sanfrancisco.otf");
    }
}
