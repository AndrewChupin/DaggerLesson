package com.example.a65apps.daggerlesson.network.requests;

import android.support.annotation.NonNull;


public class LoadContactsRequest {

    @NonNull
    private final String token;

    public LoadContactsRequest(@NonNull String token) {
        this.token = token;
    }

    @NonNull
    public String getToken() {
        return token;
    }
}