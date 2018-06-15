package com.example.a65apps.daggerlesson.data.contact;

import com.squareup.moshi.Json;


public class ContactDto {

    @Json(name = "id")
    private final Long id;

    @Json(name = "name")
    private final String name;

    @Json(name = "phone_number")
    private final String phone;

    @Json(name = "image_url")
    private final String imageUrl;

    public ContactDto(Long id, String name, String phone, String imageUrl) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}