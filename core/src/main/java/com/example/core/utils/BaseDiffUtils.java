package com.example.core.utils;

import android.support.v7.util.DiffUtil;

import java.util.List;


public class BaseDiffUtils<Type> extends DiffUtil.Callback {

    private List<Type> oldList;
    private List<Type> newList;

    public BaseDiffUtils(List<Type> oldList, List<Type> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).hashCode() == newList.get(newItemPosition).hashCode();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}