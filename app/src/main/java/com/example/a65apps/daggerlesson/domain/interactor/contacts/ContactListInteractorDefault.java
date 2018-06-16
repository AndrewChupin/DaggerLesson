package com.example.a65apps.daggerlesson.domain.interactor.contacts;

import android.support.annotation.NonNull;

import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.data.contact.ContactRepository;
import com.example.a65apps.daggerlesson.data.token.Token;
import com.example.a65apps.daggerlesson.data.token.TokenRepository;
import com.example.a65apps.daggerlesson.network.ContactService;
import com.example.a65apps.daggerlesson.network.requests.LoadContactsRequest;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class ContactListInteractorDefault implements ContactListInteractor {

    @NonNull
    private ContactService contactService;
    @NonNull
    private ContactRepository<Contact, Long> contactRepository;
    @NonNull
    private TokenRepository tokenRepository;

    @Inject
    public ContactListInteractorDefault(@NonNull ContactService contactService,
                                        @NonNull ContactRepository<Contact, Long> contactRepository,
                                        @NonNull TokenRepository tokenRepository) {
        this.contactService = contactService;
        this.contactRepository = contactRepository;
        this.tokenRepository = tokenRepository;
    }

    @NonNull
    @Override
    public Single<List<Contact>> getContacts() {
        return Single.defer(() -> contactRepository.findAll());
    }

    @NonNull
    @Override
    public Single<List<Contact>> refreshContacts() {
        return Completable.defer(() -> contactRepository.deleteAll())
                .andThen(tokenRepository.findToken(Token.CONTACTS_REQUEST_TOKEN))
                .flatMap((token) -> contactService.loadContacts(new LoadContactsRequest(token.getValue())))
                .flatMap((result) -> contactRepository.insertAll(result).toSingle(() -> result))
                .flatMap((result) -> contactRepository.findAll());
    }

    @NonNull
    @Override
    public Single<List<Contact>> updateContactsContacts() {
        return Single.defer(() -> tokenRepository.findToken(Token.CONTACTS_REQUEST_TOKEN))
                .flatMap((token) -> contactService.loadContacts(new LoadContactsRequest(token.getValue())))
                .flatMap((result) -> contactRepository.insertAll(result).toSingle(() -> result))
                .flatMap((result) -> contactRepository.findAll());
    }
}