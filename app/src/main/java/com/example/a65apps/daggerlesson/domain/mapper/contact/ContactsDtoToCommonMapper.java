package com.example.a65apps.daggerlesson.domain.mapper.contact;


import android.support.annotation.NonNull;

import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.data.contact.ContactDto;
import com.example.core.domain.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ContactsDtoToCommonMapper implements Mapper<List<ContactDto>, List<Contact>> {

    @Override
    @NonNull
    public List<Contact> map(@NonNull List<ContactDto> object) {
        List<Contact> contacts = new ArrayList<>();
        for (ContactDto contactDto: object) {
            contacts.add(new Contact(contactDto.getId(), contactDto.getName(),contactDto.getPhone(), contactDto.getImageUrl()));
        }
        return contacts;
    }
}
