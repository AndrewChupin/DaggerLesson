package com.example.a65apps.daggerlesson.data.token;

import android.support.annotation.NonNull;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface TokenRepository {

    @NonNull
    Completable putToken(@NonNull Token token);

    @NonNull
    Single<Token> findToken(@NonNull String key);

}
