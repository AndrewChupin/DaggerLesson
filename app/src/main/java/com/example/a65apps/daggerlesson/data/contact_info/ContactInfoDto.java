package com.example.a65apps.daggerlesson.data.contact_info;


import android.support.annotation.NonNull;

import com.squareup.moshi.Json;

public class ContactInfoDto {

    @Json(name = "info")
    @NonNull
    private final String info;

    public ContactInfoDto(@NonNull String info) {
        this.info = info;
    }

    @NonNull
    public String getInfo() {
        return info;
    }
}
