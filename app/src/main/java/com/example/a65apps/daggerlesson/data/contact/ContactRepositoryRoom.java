package com.example.a65apps.daggerlesson.data.contact;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.a65apps.daggerlesson.app.AppDatabase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;


public final class ContactRepositoryRoom implements ContactRepository<Contact, Long> {

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
        return Completable.fromAction(() -> appDatabase.getContactsDao().deleteAll());
    }

    @NonNull
    @Override
    public Single<List<Contact>> findAll() {
        return appDatabase.getContactsDao().findAll();
    }

    @Nullable
    @Override
    public Single<Contact> findById(@NonNull Long id) {
        return appDatabase.getContactsDao().findById(id);
    }
}