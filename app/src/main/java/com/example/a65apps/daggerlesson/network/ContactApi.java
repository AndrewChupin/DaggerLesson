package com.example.a65apps.daggerlesson.network;

import com.example.a65apps.daggerlesson.data.contact.ContactDto;
import com.example.a65apps.daggerlesson.data.contact_info.ContactInfoDto;
import com.example.core.network.BaseContactResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ContactApi {

    @GET("/get_contacts")
    Single<BaseContactResponse<List<ContactDto>>> getContacts(
            @Query("token") String token
    );

    @GET("/get_contact_info/{contact_id}")
    Single<BaseContactResponse<ContactInfoDto>> getContactInfo(
            @Path("contact_id") long id
    );

}