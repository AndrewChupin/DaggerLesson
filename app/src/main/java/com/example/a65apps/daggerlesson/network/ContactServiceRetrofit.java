package com.example.a65apps.daggerlesson.network;

import android.support.annotation.NonNull;

import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.data.contact.ContactDto;
import com.example.core.domain.Mapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class ContactServiceRetrofit implements ContactService {

    @NonNull
    private ContactApi contactApi;
    @NonNull
    private Mapper<List<ContactDto>, List<Contact>> contactsMapper;

    @Inject
    public ContactServiceRetrofit(
            @NonNull ContactApi contactApi,
            @NonNull Mapper<List<ContactDto>, List<Contact>> contactsMapper) {
        this.contactApi = contactApi;
        this.contactsMapper = contactsMapper;
    }

    @Override
    @NonNull
    public Single<List<Contact>> loadContacts(@NonNull LoadContactsRequest request) {
        return Single.defer(() -> contactApi.getContacts()
                .flatMap((response) -> Single.just(contactsMapper.map(response.getDataType()))));
    }
}