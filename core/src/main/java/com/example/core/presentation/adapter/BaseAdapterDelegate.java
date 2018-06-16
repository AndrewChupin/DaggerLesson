package com.example.core.presentation.adapter;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;


public class BaseAdapterDelegate<Type> extends AdapterDelegatesManager<Type> {

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return (BaseViewHolder) super.onCreateViewHolder(parent, viewType); // TODO CASE
    }
}