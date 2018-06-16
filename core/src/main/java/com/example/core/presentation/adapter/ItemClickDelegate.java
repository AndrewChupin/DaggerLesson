package com.example.core.presentation.adapter;

public interface ItemClickDelegate<Object> {
    void onItemClicked(Object object, int position);
}