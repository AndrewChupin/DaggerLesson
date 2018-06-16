package com.example.a65apps.daggerlesson.domain.interactor.contact;

import com.example.a65apps.daggerlesson.data.contact_info.ContactInfo;
import com.example.a65apps.daggerlesson.network.ContactService;
import com.example.a65apps.daggerlesson.network.ContactsInfoRequest;

import javax.inject.Inject;

import io.reactivex.Single;


public class ContactInteractorDefault implements ContactInteractor {

    private ContactService contactService;

    @Inject
    public ContactInteractorDefault(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    public Single<ContactInfo> loadContactInfo(long contactId) {
        return contactService.loadContactInfo(new ContactsInfoRequest(contactId));
    }

}