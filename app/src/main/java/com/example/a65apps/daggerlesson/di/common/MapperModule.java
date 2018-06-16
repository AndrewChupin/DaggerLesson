package com.example.a65apps.daggerlesson.di.common;

import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.data.contact.ContactDto;
import com.example.a65apps.daggerlesson.data.contact_info.ContactInfo;
import com.example.a65apps.daggerlesson.data.contact_info.ContactInfoDto;
import com.example.a65apps.daggerlesson.domain.mapper.contact.ContactsDtoToCommonMapper;
import com.example.a65apps.daggerlesson.domain.mapper.contact.ContactsInfoDtoToCommonMapper;
import com.example.core.di.scope.FragmentScope;
import com.example.core.domain.Mapper;

import java.util.List;

import dagger.Module;
import dagger.Provides;


@Module
public class MapperModule {

    @Provides
    @FragmentScope
    Mapper<List<ContactDto>, List<Contact>> provideMapper() {
        return new ContactsDtoToCommonMapper();
    }


    @Provides
    @FragmentScope
    Mapper<ContactInfoDto, ContactInfo> provideMapperContactInfo() {
        return new ContactsInfoDtoToCommonMapper();
    }
}