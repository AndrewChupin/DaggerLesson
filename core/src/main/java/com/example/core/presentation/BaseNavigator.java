package com.example.core.presentation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import ru.terrakok.cicerone.android.SupportAppNavigator;


public abstract class BaseNavigator extends SupportAppNavigator {

    private Activity activity;

    public BaseNavigator(FragmentActivity activity, int containerId) {
        super(activity, containerId);
        this.activity = activity;
    }

    public BaseNavigator(FragmentActivity activity, FragmentManager fragmentManager, int containerId) {
        super(activity, fragmentManager, containerId);
    }


    @Override
    protected Intent createActivityIntent(Context context, String screenKey, Object data) {
        return null;
    }

    @Override
    protected void showSystemMessage(String message) {
        Toast.makeText(activity.getBaseContext(), message, Toast.LENGTH_LONG).show();
    }
}