package com.lexmanuel.myinfo2.presenter;

import com.lexmanuel.myinfo2.view.ContactView;

// 11-08-2019
// 10116370
// Alexander M S
// IF-8

public class ContactPresenter {

    private ContactView view;

    public ContactPresenter(ContactView view) {
        this.view = view;
    }

    public void makeCall() {
        view.actionCall();
    }

    public void sendEmail() {
        view.actionEmail();
    }

    public void openInstagram() {
        view.actionInstagram();
    }

    public void openTwitter() {
        view.actionTwitter();
    }
}
