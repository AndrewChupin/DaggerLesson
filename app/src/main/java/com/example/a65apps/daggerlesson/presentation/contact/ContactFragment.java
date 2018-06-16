package com.example.a65apps.daggerlesson.presentation.contact;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.a65apps.daggerlesson.R;
import com.example.a65apps.daggerlesson.app.AppDelegate;
import com.example.a65apps.daggerlesson.data.contact.Contact;
import com.example.a65apps.daggerlesson.data.contact_info.ContactInfo;
import com.example.a65apps.daggerlesson.di.contact.ContactComponent;
import com.example.a65apps.daggerlesson.presentation.common.BaseToolbarFragment;
import com.example.core.presentation.BaseScreenStates;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;


public class ContactFragment extends BaseToolbarFragment implements ContactView {

    public static final String CONTACT = "CONTACT";

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
    @BindView(R.id.text_contact_info)
    TextView textContactInfo;
    @BindView(R.id.progress_info_loading)
    ProgressBar progressInfoLoading;

    public static Fragment newInstance(Contact contact) {
        ContactFragment contactFragment = new ContactFragment();
        Bundle bundle = new Bundle();

        bundle.putParcelable(CONTACT, contact);
        contactFragment.setArguments(bundle);

        return contactFragment;
    }

    @Override
    public void onAttach(Context context) {
        AppDelegate appDelegate = (AppDelegate) getActivity().getApplication();
        ContactComponent contactComponent = appDelegate.createContactComponent();
        contactComponent.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onDestroy() {
        AppDelegate appDelegate = (AppDelegate) getActivity().getApplication();
        appDelegate.destroyMainComponent();
        super.onDestroy();
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

    @Override
    public void showContactInfo(@NonNull ContactInfo info) {
        textContactInfo.setText(info.getInfo());
    }

    @Override
    public void changeState(@NonNull String state) {
        switch (state) {
            case BaseScreenStates.LOADING: {
                textContactInfo.setVisibility(View.GONE);
                progressInfoLoading.setVisibility(View.VISIBLE);
                break;
            }
            case BaseScreenStates.DATA: {
                textContactInfo.setVisibility(View.VISIBLE);
                progressInfoLoading.setVisibility(View.GONE);
                break;
            }
        }
    }

    @Override
    public boolean onBackPressed() {
        contactPresenter.onBackPressed();
        return true;
    }

    @Override
    public String getTitle() {
        return getString(R.string.contact_title);
    }
}