package com.example.a65apps.daggerlesson.di.main;


import com.example.a65apps.daggerlesson.di.common.AppComponent;
import com.example.a65apps.daggerlesson.presentation.main.MainActivity;
import com.example.core.di.scope.ActivityScope;

import dagger.Component;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
