package com.example.core.presentation;

import android.support.annotation.StringDef;

@StringDef(value = {
        ScreenStates.DATA,
        ScreenStates.UPDATING,
        ScreenStates.REFRESH,
        ScreenStates.ERROR,
        ScreenStates.CONNECT,
        ScreenStates.LOADING
})
public @interface ScreenState {}