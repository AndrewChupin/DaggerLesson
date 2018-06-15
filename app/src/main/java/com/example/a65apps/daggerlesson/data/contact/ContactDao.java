package com.example.a65apps.daggerlesson.data.contact;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;


@Dao
public interface ContactDao {

    @Insert
    void insertAll(List<Contact> contacts);

    @Query("SELECT * FROM contacts")
    List<Contact> findAll();

    @Query("SELECT * FROM contacts WHERE id = :id")
    Contact findById(long id);

    @Query("DELETE FROM contacts")
    void deleteAll();

}