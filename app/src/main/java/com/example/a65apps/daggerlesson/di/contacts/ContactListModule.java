package com.example.a65apps.daggerlesson.di.contacts;


import android.content.SharedPreferences;

import com.example.a65apps.daggerlesson.app.AppDatabase;
import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.data.contact.ContactDto;
import com.example.a65apps.daggerlesson.data.contact.ContactRepository;
import com.example.a65apps.daggerlesson.data.contact.ContactRepositoryRoom;
import com.example.a65apps.daggerlesson.data.token.TokenRepository;
import com.example.a65apps.daggerlesson.data.token.TokenRepositoryShared;
import com.example.a65apps.daggerlesson.di.main.FragmentScope;
import com.example.a65apps.daggerlesson.domain.interactor.contacts.ContactListInteractor;
import com.example.a65apps.daggerlesson.domain.interactor.contacts.ContactListInteractorDefault;
import com.example.a65apps.daggerlesson.domain.mapper.contact.ContactsDtoToCommonMapper;
import com.example.a65apps.daggerlesson.network.ContactApi;
import com.example.a65apps.daggerlesson.network.ContactService;
import com.example.a65apps.daggerlesson.network.ContactServiceRetrofit;
import com.example.a65apps.daggerlesson.presentation.contacts.ContactListPresenter;
import com.example.core.domain.Mapper;

import java.util.List;

import dagger.Module;
import dagger.Provides;


@Module
public class ContactListModule {

    @Provides
    @FragmentScope
    Mapper<List<ContactDto>, List<Contact>> provideMapper() {
        return new ContactsDtoToCommonMapper();
    }

    @Provides
    @FragmentScope
    TokenRepository provideTokenRepository(SharedPreferences sharedPreferences) { // TODO
        return new TokenRepositoryShared(sharedPreferences);
    }

    @Provides
    @FragmentScope
    ContactRepository<Contact, Long> provideContactsRepository(AppDatabase appDatabase) {
        return new ContactRepositoryRoom(appDatabase);
    }

    @Provides
    @FragmentScope
    ContactService provideContactService(ContactApi contactApi, Mapper<List<ContactDto>, List<Contact>> mapper) {
        return new ContactServiceRetrofit(contactApi, mapper);
    }

    @Provides
    @FragmentScope
    ContactListInteractor provideContactInteractor(
            ContactRepository<Contact, Long> contactRepository,
            ContactService service,
            TokenRepository tokenRepository) {
        return new ContactListInteractorDefault(service, contactRepository, tokenRepository);
    }

    @Provides
    @FragmentScope
    ContactListPresenter provideContactListPresenter(ContactListInteractor contactListInteractor) {
        return new ContactListPresenter(contactListInteractor);
    }

}