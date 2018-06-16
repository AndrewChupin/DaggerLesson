package com.example.a65apps.daggerlesson.di.contacts;


import com.example.a65apps.daggerlesson.di.common.AppComponent;
import com.example.a65apps.daggerlesson.di.common.MapperModule;
import com.example.core.di.scope.FragmentScope;
import com.example.a65apps.daggerlesson.presentation.contacts.ContactListFragment;

import dagger.Component;


@FragmentScope
@Component(dependencies = {AppComponent.class}, modules = {ContactListModule.class, MapperModule.class})
public interface ContactListComponent {
    void inject(ContactListFragment contact);
}