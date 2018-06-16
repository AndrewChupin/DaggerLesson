package com.example.a65apps.daggerlesson.presentation.contact;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.a65apps.daggerlesson.R;
import com.example.a65apps.daggerlesson.app.AppDelegate;
import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.di.contact.ContactComponent;
import com.example.core.presentation.BaseFragment;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;


public class ContactFragment extends BaseFragment implements ContactView {

    public static final String CONTACT = "CONTACT";

    public static Fragment newInstance(Contact contact) {
        ContactFragment contactFragment = new ContactFragment();
        Bundle bundle = new Bundle();

        bundle.putParcelable(CONTACT, contact);
        contactFragment.setArguments(bundle);

        return contactFragment;
    }

    @InjectPresenter
    public ContactPresenter contactPresenter;
    @Inject
    public Provider<ContactPresenter> contactPresenterProvider;

    @BindView(R.id.image_contact)
    ImageView contactPhoto;
    @BindView(R.id.text_contact_name)
    TextView contactName;
    @BindView(R.id.text_contact_phone)
    TextView contactPhone;

    @Override
    public void onAttach(Context context) {
        AppDelegate appDelegate = (AppDelegate) getActivity().getApplication();
        ContactComponent contactComponent = appDelegate.getAppComponent()
                .plusContactComponent();
        contactComponent.inject(this);
        super.onAttach(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_contact;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Contact contact = getArguments().getParcelable(CONTACT);

        Glide.with(getContext())
                .load(contact.getImageUrl())
                .apply(RequestOptions.circleCropTransform())
                .apply(RequestOptions.placeholderOf(R.drawable.placeholder_face).circleCrop())
                .into(contactPhoto);

        contactName.setText(contact.getName());
        contactPhone.setText(contact.getPhone());
    }

    @ProvidePresenter
    public ContactPresenter providePresenter() {
        return contactPresenterProvider.get();
    }
}