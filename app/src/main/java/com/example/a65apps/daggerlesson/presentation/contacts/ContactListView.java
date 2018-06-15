package com.example.a65apps.daggerlesson.presentation.contacts;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.core.presentation.ScreenState;

import java.util.List;


public interface ContactListView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showContacts(@NonNull List<Contact> contacts);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void changeState(@NonNull @ScreenState String state);

}