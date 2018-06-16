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

        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        appCompatActivity.setSupportActionBar(toolbar);
        appCompatActivity.getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);
        appCompatActivity.getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);
        appCompatActivity.setTitle("Blablabla");
    }



    public boolean onBackPressed() {
        return false;
    }

}