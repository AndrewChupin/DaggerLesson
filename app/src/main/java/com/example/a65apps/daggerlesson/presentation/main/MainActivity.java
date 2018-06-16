package com.example.a65apps.daggerlesson.presentation.main;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.a65apps.daggerlesson.app.AppDelegate;
import com.example.a65apps.daggerlesson.di.main.MainComponent;
import com.example.a65apps.daggerlesson.di.main.MainModule;
import com.example.core.presentation.BackPressedDelegate;

import javax.inject.Inject;
import javax.inject.Provider;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;


public class MainActivity extends MvpAppCompatActivity implements MainView {

    @Inject
    NavigatorHolder navigatorHolder;
    @Inject
    Navigator navigator;
    @Inject
    Provider<MainPresenter> presenterProvider;
    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppDelegate appDelegate = (AppDelegate) getApplication();
        MainComponent mainComponent = appDelegate.getAppComponent()
                .plusMainComponent(new MainModule(this, getSupportFragmentManager()));
        mainComponent.inject(this);

        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            presenter.onScreenReady();
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(android.R.id.content);
        if (fragment != null && fragment instanceof BackPressedDelegate) {
            boolean isReturn = ((BackPressedDelegate) fragment).onBackPressed();
            if (isReturn) {
                return;
            }
        }
        super.onBackPressed();
    }

    @ProvidePresenter
    MainPresenter providePresenter() {
        return presenterProvider.get();
    }
}