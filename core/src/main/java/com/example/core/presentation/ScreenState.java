package com.example.core.presentation;

import android.support.annotation.StringDef;

@StringDef(value = {
        BaseScreenStates.DATA,
        BaseScreenStates.UPDATING,
        BaseScreenStates.REFRESH,
        BaseScreenStates.ERROR,
        BaseScreenStates.CONNECT,
        BaseScreenStates.LOADING
})
public @interface ScreenState {}