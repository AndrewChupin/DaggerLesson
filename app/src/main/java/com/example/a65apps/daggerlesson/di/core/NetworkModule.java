package com.example.a65apps.daggerlesson.di.core;

import com.example.a65apps.daggerlesson.network.ContactApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.moshi.Moshi;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;


@Module
public class NetworkModule {

    @Provides
    @Singleton
    public ContactApi provideApi() {
        return new Retrofit.Builder()
                .baseUrl("http://192.168.65.112:5000")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder().build()))
                .build()
                .create(ContactApi.class);
    }

}