package com.example.a65apps.daggerlesson.presentation.contacts;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.a65apps.daggerlesson.R;
import com.example.a65apps.daggerlesson.app.AppDelegate;
import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.di.contacts.ContactListComponent;
import com.example.a65apps.daggerlesson.di.contacts.ContactListModule;
import com.example.a65apps.daggerlesson.di.contacts.DaggerContactListComponent;
import com.example.a65apps.daggerlesson.presentation.adapters.ContactCellInteractionDelegate;
import com.example.a65apps.daggerlesson.presentation.adapters.ContactsAdapter;
import com.example.core.presentation.BaseFragment;
import com.example.core.utils.DiffUtils;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;


public class ContactListFragment extends BaseFragment implements ContactListView, ContactCellInteractionDelegate {

    @BindView(R.id.rv_contacts)
    public RecyclerView contactsView;

    @BindView(R.id.swipe_refresh)
    public SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    private ContactsAdapter contactsAdapter;

    @InjectPresenter
    ContactListPresenter presenter;

    @Inject
    Provider<ContactListPresenter> presenterProvider;


    public static Fragment newInstance() {
        return new ContactListFragment();
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public void onAttach(Context context) {
        AppDelegate appDelegate = ((AppDelegate) getActivity().getApplication());
        ContactListComponent contactListComponent = DaggerContactListComponent.builder()
                .appComponent(appDelegate.getAppComponent())
                .contactListModule(new ContactListModule())
                .build();
        contactListComponent.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() == null) {
            return;
        }

        contactsAdapter = new ContactsAdapter(getActivity(), this);
        contactsView.setLayoutManager(new LinearLayoutManager(getContext()));
        contactsView.setAdapter(contactsAdapter);
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.refreshContacts());
    }

    @Override
    public void showContacts(@NonNull List<Contact> contacts) {
        if (contactsAdapter != null)
            DiffUtils.calculateDuffs(contactsAdapter.getItems(), contacts, (result) -> {
                contactsAdapter.setItems(contacts);
                result.dispatchUpdatesTo(contactsAdapter);
            });
    }

    @Override
    public void changeState(@NonNull String state) {

    }

    @Override
    public void isRefreshing(boolean isRefreshing) {
        swipeRefreshLayout.setRefreshing(isRefreshing);
    }

    @ProvidePresenter
    ContactListPresenter providePresenter() {
        return presenterProvider.get();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_contacts_list;
    }

    @Override
    public void onContactCellClicked(@NonNull Contact contact) {
        presenter.contactCellClicked(contact);
    }
}