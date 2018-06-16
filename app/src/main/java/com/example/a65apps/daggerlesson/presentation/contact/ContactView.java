package com.example.a65apps.daggerlesson.presentation.contact;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.a65apps.daggerlesson.data.contact_info.ContactInfo;
import com.example.core.presentation.ScreenState;


public interface ContactView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showContactInfo(@NonNull ContactInfo info);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void changeState(@NonNull @ScreenState String state);

}