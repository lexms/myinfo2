package com.lexmanuel.myinfo2.view;

import com.lexmanuel.myinfo2.data.model.Friends;

// 11-08-2019
// 10116370
// Alexander M S
// IF-8

public interface FriendsDetailView {
    void showDetail(Friends fr);
    void actionCall();
    void actionEmail();
    void actionInstagram();
    void onFriendDeleted();
}
