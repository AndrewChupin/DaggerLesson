package com.example.a65apps.daggerlesson.data.contact_info;

import android.support.annotation.NonNull;

import com.squareup.moshi.Json;

public class ContactInfoDto {

    @Json(name = "info")
    private final String info;

    public ContactInfoDto(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
