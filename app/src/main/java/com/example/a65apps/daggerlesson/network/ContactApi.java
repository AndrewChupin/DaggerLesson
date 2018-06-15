package com.example.a65apps.daggerlesson.network;

import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.data.contact.ContactDto;
import com.example.core.network.BaseContactResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ContactApi {

    @GET("/get_contacts")
    Single<BaseContactResponse<List<ContactDto>>> getContacts();

}