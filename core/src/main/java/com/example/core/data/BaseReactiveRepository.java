package com.example.core.data;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface BaseReactiveRepository<Entity, Id> {

    @NonNull
    Completable insertAll(@NonNull List<Entity> objects);

    @NonNull
    Completable deleteAll();

    @NonNull
    Single<List<Entity>> findAll();

    @NonNull
    Single<Entity> findById(@NonNull Id id);

}