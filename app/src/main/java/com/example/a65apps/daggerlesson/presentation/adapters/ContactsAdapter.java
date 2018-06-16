package com.example.a65apps.daggerlesson.presentation.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.core.presentation.adapter.BaseAdapterDelegate;
import com.example.core.presentation.adapter.BaseRecyclerAdapter;
import com.example.core.presentation.adapter.BaseViewHolder;
import com.example.core.presentation.adapter.ItemClickDelegate;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import java.util.ArrayList;
import java.util.List;


public class ContactsAdapter extends BaseRecyclerAdapter<BaseViewHolder> {

    @NonNull
    private BaseAdapterDelegate<List<Contact>> delegatesManager;
    @NonNull
    private List<Contact> items = new ArrayList<>();
    @NonNull
    private ContactCellInteractionDelegate delegate;

    public ContactsAdapter(@NonNull Activity activity, @NonNull ContactCellInteractionDelegate delegate) {
        delegatesManager = new BaseAdapterDelegate<>();
        delegatesManager.addDelegate(new ContactAdapterDelegate(activity));
        this.delegate = delegate;
    }

    @Override
    public int getItemViewType(int position) {
        return delegatesManager.getItemViewType(items, position);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = delegatesManager.onCreateViewHolder(parent, viewType);
        viewHolder.setListener((view) -> {
            Contact contact = items.get(viewHolder.getAdapterPosition());
            delegate.onContactCellClicked(contact);
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        delegatesManager.onBindViewHolder(items, position, holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(@NonNull List<Contact> items) {
        this.items = items;
    }

    @NonNull
    public List<Contact> getItems() {
        return items;
    }
}