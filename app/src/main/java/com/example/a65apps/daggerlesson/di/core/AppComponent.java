package com.example.a65apps.daggerlesson.di.core;

import android.content.SharedPreferences;

import com.example.a65apps.daggerlesson.app.AppDelegate;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class, DataBaseModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(AppDelegate appDelegate);
    SharedPreferences provideShared();
}