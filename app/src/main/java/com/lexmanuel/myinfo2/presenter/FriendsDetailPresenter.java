package com.lexmanuel.myinfo2.presenter;

import android.content.Context;

import com.lexmanuel.myinfo2.data.model.Friends;
import com.lexmanuel.myinfo2.data.repo.FriendsRepository;
import com.lexmanuel.myinfo2.view.FriendsDetailView;

// 11-08-2019
// 10116370
// Alexander M S
// IF-8

public class FriendsDetailPresenter {

    private FriendsDetailView view;
    private FriendsRepository repo;

    public FriendsDetailPresenter(Context context, FriendsDetailView view) {
        this.view = view;
        repo = new FriendsRepository(context);
    }

    public void getFriendsDetail(Friends fr) {
        view.showDetail(fr);
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

    public void removeFriend(Friends friend) {
        repo.deleteFriend(friend);
        view.onFriendDeleted();
    }
}
