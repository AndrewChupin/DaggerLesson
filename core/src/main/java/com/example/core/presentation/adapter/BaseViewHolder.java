package com.example.core.presentation.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void setListener(@Nullable View.OnClickListener listener) {
        itemView.setOnClickListener(listener);
    }

}
