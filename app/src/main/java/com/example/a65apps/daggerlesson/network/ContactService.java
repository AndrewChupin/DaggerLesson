package com.example.a65apps.daggerlesson.network;

import android.support.annotation.NonNull;

import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.data.contact_info.ContactInfo;

import java.util.List;

import io.reactivex.Single;

public interface ContactService {

    @NonNull
    Single<List<Contact>> loadContacts(@NonNull LoadContactsRequest request);

    @NonNull
    Single<ContactInfo> loadContactInfo(@NonNull ContactsInfoRequest request);
}