package com.example.a65apps.daggerlesson.app;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.a65apps.daggerlesson.di.app.AppComponent;
import com.example.a65apps.daggerlesson.di.contact.ContactComponent;
import com.example.a65apps.daggerlesson.di.main.MainComponent;
import com.example.a65apps.daggerlesson.di.main.MainModule;
import com.example.core.di.module.AppModule;
import com.example.a65apps.daggerlesson.di.common.DaggerAppComponent;
import com.example.a65apps.daggerlesson.di.app.DataBaseModule;


public class AppDelegate extends Application {

    @Nullable
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
        if (appComponent == null) {
            initDependencies();
        }
        return appComponent;
    }

}