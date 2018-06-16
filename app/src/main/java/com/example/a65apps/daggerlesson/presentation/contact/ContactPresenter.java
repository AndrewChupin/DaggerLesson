package com.example.a65apps.daggerlesson.presentation.contact;

import android.support.annotation.NonNull;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.example.a65apps.daggerlesson.domain.interactor.contact.ContactInteractor;
import com.example.core.presentation.BasePresenter;
import com.example.core.presentation.BaseScreenStates;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class ContactPresenter extends BasePresenter<ContactView> {

    @NonNull
    private final ContactInteractor contactInteractor;
    @NonNull
    private final Router router;

    public ContactPresenter(@NonNull ContactInteractor contactInteractor, @NonNull Router router) {
        this.contactInteractor = contactInteractor;
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Disposable disposable = contactInteractor.loadContactInfo(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe((a) -> getViewState().changeState(BaseScreenStates.LOADING))
                .doFinally(() -> getViewState().changeState(BaseScreenStates.DATA))
                .subscribe((result) -> getViewState().showContactInfo(result),
                        (error) -> {
                            error.printStackTrace();
                            getViewState().changeState(BaseScreenStates.ERROR);
                        }); // TODO
        disposeOnDelete(disposable);
    }

    void onBackPressed() {
        router.exit();
    }

}