package com.example.a65apps.daggerlesson.presentation.common;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.a65apps.daggerlesson.presentation.contact.ContactFragment;
import com.example.a65apps.daggerlesson.presentation.contacts.ContactListFragment;
import com.example.core.presentation.BaseNavigator;


public class MainNavigator extends BaseNavigator {

    public MainNavigator(FragmentActivity activity, FragmentManager fragmentManager, int containerId) {
        super(activity, fragmentManager, containerId);
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (screenKey) {
            case Screens.SCREEN_CONTACT: {
                return ContactFragment.newInstance();
            }
            case Screens.SCREEN_CONTACT_LIST: {
                return ContactListFragment.newInstance();
            }
        }

        throw new IllegalArgumentException("Unsupported screen with key " + screenKey);
    }
}