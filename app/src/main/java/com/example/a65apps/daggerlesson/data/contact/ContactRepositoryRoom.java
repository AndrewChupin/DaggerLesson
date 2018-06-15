package com.example.a65apps.daggerlesson.data.contact;

import android.support.annotation.NonNull;

import com.example.a65apps.daggerlesson.app.AppDatabase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;


public class ContactRepositoryRoom implements ContactRepository<Contact, Long> {

    @NonNull
    private AppDatabase appDatabase;

    @Inject
    public ContactRepositoryRoom(@NonNull AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @NonNull
    @Override
    public Completable insertAll(@NonNull List<Contact> objects) {
        return Completable.fromAction(() -> appDatabase.getContactsDao().insertAll(objects));
    }

    @NonNull
    @Override
    public Completable deleteAll() {
        return Completable.fromAction(appDatabase.getContactsDao()::deleteAll);
    }

    @NonNull
    @Override
    public Single<List<Contact>> findAll() {
        return Single.fromCallable(() -> appDatabase.getContactsDao().findAll());
    }

    @NonNull
    @Override
    public Single<Contact> findById(@NonNull Long id) {
        return Single.fromCallable(() -> appDatabase.getContactsDao().findById(id));
    }
}