package com.example.a65apps.daggerlesson.presentation.common;


import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.a65apps.daggerlesson.R;
import com.example.core.presentation.BackPressedDelegate;
import com.example.core.presentation.BaseFragment;


public abstract class BaseToolbarFragment extends BaseFragment implements BackPressedDelegate {

    @CallSuper
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = view.findViewById(R.id.toolbar);

        if (getActivity() instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.setSupportActionBar(toolbar);

            if (activity.getSupportActionBar() == null) {
                return;
            }

            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            activity.getSupportActionBar().setTitle(getTitle());
        }
    }

    public boolean onBackPressed() {
        return false;
    }

    public abstract String getTitle();
}