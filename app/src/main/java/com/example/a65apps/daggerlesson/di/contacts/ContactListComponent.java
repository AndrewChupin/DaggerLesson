package com.example.a65apps.daggerlesson.di.contacts;


import com.example.a65apps.daggerlesson.di.main.FragmentScope;
import com.example.a65apps.daggerlesson.presentation.contacts.ContactListPresenter;

import dagger.Component;

@FragmentScope
@Component(modules = {ContactListModule.class})
public interface ContactListComponent {
    ContactListPresenter provideContactListPresenter();
}