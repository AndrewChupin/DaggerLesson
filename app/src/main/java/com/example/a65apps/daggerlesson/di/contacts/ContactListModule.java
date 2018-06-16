package com.example.a65apps.daggerlesson.di.contacts;


import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.data.contact.ContactRepository;
import com.example.a65apps.daggerlesson.data.contact.ContactRepositoryRoom;
import com.example.a65apps.daggerlesson.data.token.TokenRepository;
import com.example.a65apps.daggerlesson.data.token.TokenRepositoryShared;
import com.example.a65apps.daggerlesson.domain.interactor.contacts.ContactListInteractor;
import com.example.a65apps.daggerlesson.domain.interactor.contacts.ContactListInteractorDefault;
import com.example.a65apps.daggerlesson.network.ContactService;
import com.example.a65apps.daggerlesson.network.ContactServiceRetrofit;
import com.example.a65apps.daggerlesson.presentation.contacts.ContactListPresenter;
import com.example.core.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;


@Module
public class ContactListModule {

    @Provides
    @FragmentScope
    TokenRepository provideTokenRepository(TokenRepositoryShared tokenRepositoryShared) {
        return tokenRepositoryShared;
    }

    @Provides
    @FragmentScope
    ContactRepository<Contact, Long> provideContactsRepository(ContactRepositoryRoom contactRepositoryRoom) {
        return contactRepositoryRoom;
    }

    @Provides
    @FragmentScope
    ContactService provideContactService(ContactServiceRetrofit serviceRetrofit) {
        return serviceRetrofit;
    }

    @Provides
    @FragmentScope
    ContactListInteractor provideContactInteractor(ContactListInteractorDefault interactorDefault) {
        return interactorDefault;
    }

    @Provides
    @FragmentScope
    ContactListPresenter provideContactListPresenter(ContactListInteractor contactListInteractor, Router router) {
        return new ContactListPresenter(contactListInteractor, router);
    }

}