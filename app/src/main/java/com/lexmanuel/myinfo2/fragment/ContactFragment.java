package com.lexmanuel.myinfo2.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.lexmanuel.myinfo2.R;
import com.lexmanuel.myinfo2.presenter.ContactPresenter;
import com.lexmanuel.myinfo2.view.ContactView;

// 11-08-2019
// 10116370
// Alexander M S
// IF-8

public class ContactFragment extends Fragment implements ContactView, View.OnClickListener {

    RelativeLayout lytPhone, lytEmail, lytIG, lytTwitter;
    ContactPresenter presenter;

    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        lytPhone = view.findViewById(R.id.lytPhone);
        lytEmail = view.findViewById(R.id.lytEmail);
        lytIG = view.findViewById(R.id.lytIg);
        lytTwitter = view.findViewById(R.id.lytTwitter);

        lytPhone.setOnClickListener(this);
        lytEmail.setOnClickListener(this);
        lytIG.setOnClickListener(this);
        lytTwitter.setOnClickListener(this);

        presenter = new ContactPresenter(this);

        return view;
    }

    @Override
    public void actionCall() {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel","085348060131", null));
        startActivity(i);
    }

    @Override
    public void actionEmail() {
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:lexms@funderasia.com"));
        startActivity(i);
    }

    @Override
    public void actionInstagram() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/lexmanuel"));
        startActivity(i);
    }

    @Override
    public void actionTwitter() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/lexms_"));
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lytPhone:
                presenter.makeCall();
                break;
            case R.id.lytEmail:
                presenter.sendEmail();
                break;
            case R.id.lytIg:
                presenter.openInstagram();
                break;
            case R.id.lytTwitter:
                presenter.openTwitter();
                break;
        }
    }
}
