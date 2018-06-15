package com.example.a65apps.daggerlesson.presentation.contacts;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.a65apps.daggerlesson.R;
import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.presentation.adapters.ContactsAdapter;
import com.example.a65apps.daggerlesson.presentation.contact.ContactPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class ContactListFragment extends MvpAppCompatFragment implements ContactListView {

    @BindView(R.id.rv_contacts)
    public RecyclerView contactsView;

    @Nullable
    private Unbinder unbinder;
    @Nullable
    private ContactsAdapter contactsAdapter;

    @InjectPresenter
    ContactListPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contactsAdapter = new ContactsAdapter(getActivity());
        contactsView.setLayoutManager(new LinearLayoutManager(getContext()));
        contactsView.setAdapter(contactsAdapter);

        presenter.updateContacts();
    }

    @Override
    public void onDestroyView() {
        if (unbinder != null)
            unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void showContacts(@NonNull List<Contact> contacts) {
        if (contactsAdapter != null)
            contactsAdapter.updateContacts(contacts);
    }

    @Override
    public void changeState(@NonNull String state) {

    }


}