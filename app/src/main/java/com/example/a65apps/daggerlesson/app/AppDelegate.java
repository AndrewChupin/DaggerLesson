package com.example.a65apps.daggerlesson.app;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.a65apps.daggerlesson.di.common.AppComponent;
import com.example.core.di.module.AppModule;
import com.example.a65apps.daggerlesson.di.common.DaggerAppComponent;
import com.example.a65apps.daggerlesson.di.common.DataBaseModule;


public class AppDelegate extends Application {

    @NonNull
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDependencies();
    }

    private void initDependencies() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .dataBaseModule(new DataBaseModule())
                .build();
        appComponent.inject(this);
    }

    @NonNull
    public AppComponent getAppComponent() {
        return appComponent;
    }
}