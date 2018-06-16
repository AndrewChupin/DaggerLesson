package com.example.a65apps.daggerlesson.di.contact;


import com.example.a65apps.daggerlesson.di.core.MapperModule;
import com.example.a65apps.daggerlesson.presentation.contact.ContactFragment;
import com.example.core.di.scope.FragmentScope;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {ContactModule.class, MapperModule.class})
public interface ContactComponent {
    void inject(ContactFragment contactFragment);
}