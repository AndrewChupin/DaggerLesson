package com.example.a65apps.daggerlesson.presentation.contact;

import android.support.v4.app.Fragment;

import com.example.a65apps.daggerlesson.R;
import com.example.core.presentation.BaseFragment;


public class ContactFragment extends BaseFragment {

    public static Fragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_contact;
    }

}