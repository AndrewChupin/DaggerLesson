package com.example.core.utils;

import android.content.Context;
import android.support.annotation.NonNull;

public class AndroidResourceManager implements ResourceManager {

    @NonNull
    private Context context;

    public AndroidResourceManager(@NonNull Context context) {
        this.context = context;
    }

    @Override
    @NonNull
    public String getString(int id) {
        return context.getString(id);
    }
}
