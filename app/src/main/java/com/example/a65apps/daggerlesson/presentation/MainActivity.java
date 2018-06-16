package com.example.a65apps.daggerlesson.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a65apps.daggerlesson.app.AppDelegate;
import com.example.a65apps.daggerlesson.di.main.DaggerMainComponent;
import com.example.a65apps.daggerlesson.di.main.MainComponent;
import com.example.a65apps.daggerlesson.presentation.common.MainNavigator;
import com.example.a65apps.daggerlesson.presentation.contacts.ContactListFragment;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;


public class MainActivity extends AppCompatActivity {

    @Inject
    public NavigatorHolder navigatorHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppDelegate appDelegate = (AppDelegate) getApplication();
        MainComponent mainComponent = DaggerMainComponent.builder()
                .appComponent(appDelegate.getAppComponent())
                .build();
        mainComponent.inject(this);

        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new ContactListFragment())
                .commit();
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(new MainNavigator(this, getSupportFragmentManager(), android.R.id.content));
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }
}