package com.example.a65apps.daggerlesson.data.contact;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "contacts")
public final class Contact {

    @PrimaryKey
    private final long id;

    @ColumnInfo(name = "name")
    @NonNull
    private final String name;

    @ColumnInfo(name = "phone")
    @NonNull
    private final String phone;

    @ColumnInfo(name = "image_url")
    @NonNull
    private final String imageUrl;

    public Contact(long id, @NonNull String name, @NonNull String phone, @NonNull String imageUrl) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    @NonNull
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}