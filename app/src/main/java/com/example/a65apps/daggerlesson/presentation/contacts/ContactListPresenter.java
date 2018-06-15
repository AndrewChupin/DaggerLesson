package com.example.a65apps.daggerlesson.presentation.contacts;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.a65apps.daggerlesson.domain.interactor.contacts.ContactListInteractor;
import com.example.core.presentation.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


@InjectViewState
public class ContactListPresenter extends BasePresenter<ContactListView> {

    @NonNull
    private ContactListInteractor contactListInteractor;

    @Inject
    public ContactListPresenter(@NonNull ContactListInteractor contactListInteractor) {
        this.contactListInteractor = contactListInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        updateContacts();
    }

    void getContacts() {
        Disposable disposable = contactListInteractor.getContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> getViewState().showContacts(result));
        disposeOnDelete(disposable);
    }

    void refreshContacts() {
        Disposable disposable = contactListInteractor.refreshContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> getViewState().isRefreshing(false))
                .subscribe((result) -> getViewState().showContacts(result));
        disposeOnDelete(disposable);
    }

    private void updateContacts() {
        Disposable disposable = contactListInteractor.updateContactsContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> getViewState().showContacts(result));
        disposeOnDelete(disposable);
    }

}