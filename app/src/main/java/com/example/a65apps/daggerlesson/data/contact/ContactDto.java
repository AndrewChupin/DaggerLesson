package com.example.a65apps.daggerlesson.data.contact;

import android.support.annotation.Nullable;

import com.squareup.moshi.Json;


public class ContactDto {

    @Json(name = "id")
    @Nullable
    private final Long id;

    @Json(name = "name")
    @Nullable
    private final String name;

    @Json(name = "phone_number")
    @Nullable
    private final String phone;

    @Json(name = "image_url")
    @Nullable
    private final String imageUrl;

    public ContactDto(@Nullable Long id, @Nullable String name, @Nullable String phone, @Nullable String imageUrl) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.imageUrl = imageUrl;
    }

    @Nullable
    public Long getId() {
        return id;
    }

    @Nullable
    public String getName() {
        return name;
    }

    @Nullable
    public String getPhone() {
        return phone;
    }

    @Nullable
    public String getImageUrl() {
        return imageUrl;
    }

}