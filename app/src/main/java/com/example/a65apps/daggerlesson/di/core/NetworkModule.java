package com.example.a65apps.daggerlesson.di.core;


import com.example.a65apps.daggerlesson.network.ChatApi;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class NetworkModule {

    @Provides
    @Singleton
    public ChatApi provideApi() {
        return new Retrofit.Builder()
                .baseUrl("")
                .build()
                .create(ChatApi.class);
    }

}