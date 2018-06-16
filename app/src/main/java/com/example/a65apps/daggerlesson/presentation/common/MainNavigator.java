package com.example.a65apps.daggerlesson.presentation.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.a65apps.daggerlesson.R;
import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.presentation.contact.ContactFragment;
import com.example.a65apps.daggerlesson.presentation.contacts.ContactListFragment;
import com.example.core.presentation.BaseNavigator;

import ru.terrakok.cicerone.commands.Command;


public class MainNavigator extends BaseNavigator {

    public MainNavigator(FragmentActivity activity, FragmentManager fragmentManager, int containerId) {
        super(activity, fragmentManager, containerId);
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (screenKey) {
            case Screens.SCREEN_CONTACT: {
                if (data instanceof Contact) {
                    return ContactFragment.newInstance((Contact) data);
                }
                throw new IllegalArgumentException("data is not Contact" );
            }
            case Screens.SCREEN_CONTACT_LIST: {
                return ContactListFragment.newInstance();
            }
        }

        throw new IllegalArgumentException("Unsupported screen with key " + screenKey);
    }

    @Override
    protected void setupFragmentTransactionAnimation(Command command, Fragment currentFragment, Fragment nextFragment, FragmentTransaction fragmentTransaction) {
        super.setupFragmentTransactionAnimation(command, currentFragment, nextFragment, fragmentTransaction);
        fragmentTransaction.setCustomAnimations(
                R.anim.enter_scale,
                R.anim.exit_scale,
                R.anim.pop_enter_scale,
                R.anim.pop_exit_scale
        );
    }
}