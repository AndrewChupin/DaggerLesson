package com.example.a65apps.daggerlesson.di.app;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.a65apps.daggerlesson.BuildConfig;
import com.example.a65apps.daggerlesson.app.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DataBaseModule {

    @Provides
    @Singleton
    public SharedPreferences provideShared(Context context) {
        return context.getSharedPreferences(BuildConfig.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    public AppDatabase provideDataBase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, BuildConfig.DATA_BASE_NAME)
                .build();
    }

}