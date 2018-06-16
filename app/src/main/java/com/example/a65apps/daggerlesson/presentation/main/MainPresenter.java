package com.example.a65apps.daggerlesson.presentation.main;


import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.example.a65apps.daggerlesson.presentation.common.Screens;
import com.example.core.presentation.BasePresenter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;


@InjectViewState
public class MainPresenter extends BasePresenter<MainView> {

    @NonNull
    private final Router router;

    @Inject
    public MainPresenter(@NonNull  Router router) {
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    void onScreenReady() {
        router.navigateTo(Screens.SCREEN_CONTACT_LIST);
    }
}
