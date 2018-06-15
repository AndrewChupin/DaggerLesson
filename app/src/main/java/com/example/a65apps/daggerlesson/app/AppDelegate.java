package com.example.a65apps.daggerlesson.app;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.a65apps.daggerlesson.di.core.AppComponent;
import com.example.a65apps.daggerlesson.di.core.AppModule;
import com.example.a65apps.daggerlesson.di.core.DaggerAppComponent;
import com.example.a65apps.daggerlesson.di.core.DataBaseModule;


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
}