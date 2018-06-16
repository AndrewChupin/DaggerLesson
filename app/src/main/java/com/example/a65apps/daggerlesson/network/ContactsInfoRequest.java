package com.example.a65apps.daggerlesson.network;


public class ContactsInfoRequest {

    private final long contactId;

    public ContactsInfoRequest(long contactId) {
        this.contactId = contactId;
    }

    public long getContactId() {
        return contactId;
    }
}