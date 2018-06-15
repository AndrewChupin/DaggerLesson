package com.example.a65apps.daggerlesson.presentation.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
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
        View view = activity.getLayoutInflater().inflate(R.layout.item_contact, parent, false);
        view.setOnClickListener((v) -> {

        });
        return new ContactViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull List<Contact> items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        ((ContactViewHolder) holder).bind(items.get(position));
    }

    static class ContactViewHolder extends BaseViewHolder {

        @BindView(R.id.contact_name)
        TextView contactName;
        @BindView(R.id.contact_phone)
        TextView contactPhone;
        @BindView(R.id.image_contact)
        ImageView contactImage;

        ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Contact contact) {
            contactName.setText(contact.getName());
            contactPhone.setText(contact.getPhone());
            Glide.with(itemView.getContext())
                    .load(contact.getImageUrl())
                    .apply(RequestOptions.circleCropTransform())
                    .apply(RequestOptions.placeholderOf(R.drawable.placeholder_face).circleCrop())
                    .into(contactImage);

        }

    }

}
