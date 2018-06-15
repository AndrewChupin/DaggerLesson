package com.example.a65apps.daggerlesson.data.contact;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;


@Dao
public interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(@NonNull List<Contact> contacts);

    @Query("SELECT * FROM contacts")
    @NonNull
    List<Contact> findAll();

    @Query("SELECT * FROM contacts WHERE id = :id")
    @Nullable
    Contact findById(long id);

    @Query("DELETE FROM contacts")
    void deleteAll();

}