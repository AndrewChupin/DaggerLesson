package com.example.a65apps.daggerlesson.data.contact;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

@Entity(tableName = "contacts")
public final class Contact implements Parcelable {

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

    protected Contact(Parcel in) {
        id = in.readLong();
        name = in.readString();
        phone = in.readString();
        imageUrl = in.readString();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != contact.id) return false;
        if (!name.equals(contact.name)) return false;
        if (!phone.equals(contact.phone)) return false;
        return imageUrl.equals(contact.imageUrl);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + imageUrl.hashCode();
        return result;
    }


    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(phone);
        dest.writeString(imageUrl);
    }
}