package com.example.a65apps.daggerlesson.di.main;


import com.example.a65apps.daggerlesson.presentation.MainActivity;
import com.example.a65apps.daggerlesson.di.core.AppComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = {AppComponent.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
