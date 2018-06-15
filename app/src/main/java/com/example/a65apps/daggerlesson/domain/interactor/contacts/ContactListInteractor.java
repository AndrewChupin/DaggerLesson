package com.example.a65apps.daggerlesson.domain.interactor.contacts;

import android.support.annotation.NonNull;

import com.example.a65apps.daggerlesson.data.contact.Contact;

import java.util.List;

import io.reactivex.Single;

public interface ContactListInteractor {

    @NonNull
    Single<List<Contact>> getContacts();
    @NonNull
    Single<List<Contact>> refreshContacts();
    @NonNull
    Single<List<Contact>> updateContactsContacts();

}