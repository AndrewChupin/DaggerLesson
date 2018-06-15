package com.example.a65apps.daggerlesson.presentation.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a65apps.daggerlesson.R;
import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.core.presentation.adapter.BaseViewHolder;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactAdapterDelegate extends AdapterDelegate<List<Contact>> {

    @NonNull
    private Activity activity;

    public ContactAdapterDelegate(@NonNull Activity activity) {
        this.activity = activity;
    }

    @Override
    protected boolean isForViewType(@NonNull List<Contact> items, int position) {
        return items.get(position) != null;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ContactViewHolder(activity.getLayoutInflater().inflate(R.layout.item_contact, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull List<Contact> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        ((ContactViewHolder) holder).bind(items.get(position));
    }

    static class ContactViewHolder extends BaseViewHolder {

        @BindView(R.id.contact_name)
        TextView contactName;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }

        void bind(Contact contact) {
            contactName.setText(contact.getName());
        }

    }

}
