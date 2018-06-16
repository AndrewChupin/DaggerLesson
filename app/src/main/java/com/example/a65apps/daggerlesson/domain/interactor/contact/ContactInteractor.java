package com.example.a65apps.daggerlesson.domain.interactor.contact;

import com.example.a65apps.daggerlesson.data.contact_info.ContactInfo;

import io.reactivex.Single;


public interface ContactInteractor {

    Single<ContactInfo> loadContactInfo(long contactId);

}