package com.example.a65apps.daggerlesson.data.contact;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

@Entity(tableName = "contacts")
public final class Contact {

    @ColumnInfo(name = "id")
    private final long id;

    @ColumnInfo(name = "name")
    private final String name;

    @ColumnInfo(name = "phone")
    private final String phone;

    @ColumnInfo(name = "image_url")
    private final String imageUrl;

    public Contact(long id, String name, String phone, String imageUrl) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.imageUrl = imageUrl;
    }

    public long getId() {
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