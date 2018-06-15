package com.example.a65apps.daggerlesson.presentation.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import java.util.ArrayList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private AdapterDelegatesManager<List<Contact>> delegatesManager;
    private List<Contact> items = new ArrayList<>();

    public ContactsAdapter(Activity activity) {
        delegatesManager = new AdapterDelegatesManager<>();
        delegatesManager.addDelegate(new ContactAdapterDelegate(activity));
    }

    @Override
    public int getItemViewType(int position) {
        return delegatesManager.getItemViewType(items, position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        delegatesManager.onBindViewHolder(items, position, holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(@NonNull List<Contact> items) {
        this.items = items;
    }

    public List<Contact> getItems() {
        return items;
    }
}
