package com.example.a65apps.daggerlesson.di.contacts;


import com.example.a65apps.daggerlesson.di.core.AppComponent;
import com.example.a65apps.daggerlesson.di.main.FragmentScope;
import com.example.a65apps.daggerlesson.presentation.contacts.ContactListFragment;

import dagger.Component;


@FragmentScope
@Component(dependencies = {AppComponent.class}, modules = {ContactListModule.class})
public interface ContactListComponent {
    void inject(ContactListFragment contact);
}