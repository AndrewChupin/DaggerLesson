package com.example.a65apps.daggerlesson.di.main;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.a65apps.daggerlesson.presentation.common.MainNavigator;
import com.example.a65apps.daggerlesson.presentation.main.MainPresenter;
import com.example.core.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;


@Module
public class MainModule {

    @NonNull
    private FragmentActivity activity;
    @NonNull
    private FragmentManager fragmentManager;

    public MainModule(@NonNull FragmentActivity activity, @NonNull FragmentManager fragmentManager) {
        this.activity = activity;
        this.fragmentManager = fragmentManager;
    }

    @Provides
    @ActivityScope
    public MainPresenter providePresenter(Router router) {
        return new MainPresenter(router);
    }

    @Provides
    @ActivityScope
    public Navigator provideNavigator() {
        return new MainNavigator(activity, fragmentManager, android.R.id.content);
    }


}