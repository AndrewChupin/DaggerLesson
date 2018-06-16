package com.example.a65apps.daggerlesson.presentation.adapters;


import android.support.annotation.NonNull;

import com.example.a65apps.daggerlesson.data.contact.Contact;


public interface ContactCellInteractionDelegate {

    void onContactCellClicked(@NonNull Contact contact);

}