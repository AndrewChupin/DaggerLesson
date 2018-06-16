package com.example.a65apps.daggerlesson.di.contact;

import com.example.a65apps.daggerlesson.domain.interactor.contact.ContactInteractor;
import com.example.a65apps.daggerlesson.domain.interactor.contact.ContactInteractorDefault;
import com.example.a65apps.daggerlesson.network.ContactService;
import com.example.a65apps.daggerlesson.network.ContactServiceRetrofit;
import com.example.a65apps.daggerlesson.presentation.contact.ContactPresenter;
import com.example.core.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;


@Module
public class ContactModule {

    @Provides
    @FragmentScope
    public ContactService getContactService(ContactServiceRetrofit serviceRetrofit) {
        return serviceRetrofit;
    }

    @Provides
    @FragmentScope
    public ContactInteractor getContactInteractor(ContactInteractorDefault interactorDefault) {
        return interactorDefault;
    }

    @Provides
    @FragmentScope
    public ContactPresenter getContactPresenter(ContactInteractor contactInteractor, Router router) {
        return new ContactPresenter(contactInteractor, router);
    }

}