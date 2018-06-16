package com.example.a65apps.daggerlesson.di.core;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.a65apps.daggerlesson.app.AppDatabase;
import com.example.a65apps.daggerlesson.app.AppDelegate;
import com.example.a65apps.daggerlesson.di.contact.ContactComponent;
import com.example.a65apps.daggerlesson.di.contact.ContactModule;
import com.example.a65apps.daggerlesson.network.ContactApi;

import javax.inject.Singleton;

import dagger.Component;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;


@Singleton
@Component(modules = {AppModule.class, DataBaseModule.class, NetworkModule.class, NavigationModule.class})
public interface AppComponent {
    // FOR DEPENDENCY COMPONENT
    SharedPreferences provideShared();
    AppDatabase provideAppDatabase();
    ContactApi provideContactApi();
    Context provideContext();
    Router provideRouter();
    NavigatorHolder provideNavigatorHolder();

    void inject(AppDelegate appDelegate);

    ContactComponent plusContactComponent();
}