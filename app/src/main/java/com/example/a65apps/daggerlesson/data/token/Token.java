package com.example.a65apps.daggerlesson.data.token;

import android.support.annotation.NonNull;


public class Token {

    public static final String CONTACTS_REQUEST_TOKEN = "contacts_request_token";

    @NonNull
    private final String key;
    @NonNull
    private final String value;

    public Token(@NonNull String key, @NonNull String value) {
        this.key = key;
        this.value = value;
    }

    @NonNull
    public String getValue() {
        return value;
    }

    @NonNull
    public String getKey() {
        return key;
    }
}