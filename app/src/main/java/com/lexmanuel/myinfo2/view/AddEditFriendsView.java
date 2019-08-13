package com.lexmanuel.myinfo2.view;

import android.widget.EditText;

import com.lexmanuel.myinfo2.data.model.Friends;

// 11-08-2019
// 10116370
// Alexander M S
// IF-8

public interface AddEditFriendsView {
    void showData();
    void onFriendAdded();
    void onFriendUpdated(Friends friend);
    void showError(EditText et);
    void showFailed(String msg);
}
