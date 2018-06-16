package com.example.a65apps.daggerlesson.network;

import android.support.annotation.NonNull;

import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.data.contact.ContactDto;
import com.example.a65apps.daggerlesson.data.contact_info.ContactInfo;
import com.example.a65apps.daggerlesson.data.contact_info.ContactInfoDto;
import com.example.core.domain.Mapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class ContactServiceRetrofit implements ContactService {

    @NonNull
    private ContactApi contactApi;
    @NonNull
    private Mapper<List<ContactDto>, List<Contact>> contactsMapper;
    @NonNull
    private Mapper<ContactInfoDto, ContactInfo> contactInfoMapper;

    @Inject
    public ContactServiceRetrofit(
            @NonNull ContactApi contactApi,
            @NonNull Mapper<List<ContactDto>, List<Contact>> contactsMapper,
            @NonNull Mapper<ContactInfoDto, ContactInfo> contactInfoMapper) {
        this.contactApi = contactApi;
        this.contactsMapper = contactsMapper;
        this.contactInfoMapper = contactInfoMapper;
    }

    @Override
    @NonNull
    public Single<List<Contact>> loadContacts(@NonNull LoadContactsRequest request) {
        return Single.defer(() -> contactApi.getContacts(request.getToken())
                .flatMap((response) -> Single.just(contactsMapper.map(response.getDataType()))));
    }

    @Override
    @NonNull
    public Single<ContactInfo> loadContactInfo(@NonNull ContactsInfoRequest request) {
        return Single.defer(() -> contactApi.getContactInfo(request.getContactId())
                .flatMap((response) -> Single.just(contactInfoMapper.map(response.getDataType()))));
    }
}