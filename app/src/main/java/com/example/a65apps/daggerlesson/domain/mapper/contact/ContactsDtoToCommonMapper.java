package com.example.a65apps.daggerlesson.domain.mapper.contact;


import android.support.annotation.NonNull;

import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.data.contact.ContactDto;
import com.example.core.domain.Mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ContactsDtoToCommonMapper implements Mapper<List<ContactDto>, List<Contact>> {

    @Override
    @NonNull
    public List<Contact> map(@NonNull List<ContactDto> object) {
        List<Contact> contacts = new ArrayList<>();
        for (ContactDto contactDto: object) {
            if (contactDto.getId() == null) {
                continue;
            }

            String name = contactDto.getName() != null
                    ? contactDto.getName()
                    : "";
            String phone = contactDto.getPhone() != null
                    ? contactDto.getPhone()
                    : "";
            String imageUrl = contactDto.getImageUrl() != null
                    ? contactDto.getImageUrl()
                    : "";

            contacts.add(new Contact(contactDto.getId(), name, phone, imageUrl));
        }

        return contacts;
    }
}
