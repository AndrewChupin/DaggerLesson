package com.example.a65apps.daggerlesson.data.token;


import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class TokenRepositoryShared implements TokenRepository {

    @NonNull
    private SharedPreferences tokenPreferences;

    @Inject
    public TokenRepositoryShared(@NonNull SharedPreferences tokenPreferences) {
        this.tokenPreferences = tokenPreferences;
    }

    @NonNull
    @Override
    public Completable putToken(@NonNull Token token) {
        return Completable.fromCallable(tokenPreferences.edit()
                .putString(token.getKey(), token.getValue())
                ::commit);
    }

    @NonNull
    @Override
    public Single<Token> findToken(@NonNull String key) {
        return Single.fromCallable(() -> {
            String token = tokenPreferences.getString(key, "");
            return new Token(key, token);
        });
    }
}
