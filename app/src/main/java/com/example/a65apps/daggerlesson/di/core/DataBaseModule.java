package com.example.a65apps.daggerlesson.di.core;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DataBaseModule {

    @Provides
    @Singleton
    public SharedPreferences provideShared(Context context) {
        return context.getSharedPreferences("test", Context.MODE_PRIVATE);
    }

}