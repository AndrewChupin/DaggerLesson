package com.example.a65apps.daggerlesson.presentation.contacts;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.a65apps.daggerlesson.domain.interactor.contacts.ContactListInteractor;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ContactListPresenter extends MvpPresenter<ContactListView> {

    @NonNull
    private ContactListInteractor contactListInteractor;

    public ContactListPresenter(@NonNull ContactListInteractor contactListInteractor) {
        this.contactListInteractor = contactListInteractor;
    }

    public void getContacts() {
        Disposable s = contactListInteractor.getContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {
                    getViewState().showContacts(result);
                }, (error) -> {

                });
    }

    public void refreshContacts() {
        Disposable s = contactListInteractor.refreshContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {
                    getViewState().showContacts(result);
                }, (error) -> {

                });
    }

    public void updateContacts() {
        Disposable s = contactListInteractor.updateContactsContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {
                    getViewState().showContacts(result);
                }, (error) -> {

                });
    }

}