package com.example.a65apps.daggerlesson.domain.mapper.contact;


import com.example.a65apps.daggerlesson.data.contact_info.ContactInfo;
import com.example.a65apps.daggerlesson.data.contact_info.ContactInfoDto;
import com.example.core.domain.Mapper;

import javax.inject.Inject;

public class ContactsInfoDtoToCommonMapper implements Mapper<ContactInfoDto, ContactInfo> {

    @Override
    public ContactInfo map(ContactInfoDto object) {
        return new ContactInfo(object.getInfo());
    }
}
