package com.lexmanuel.myinfo2.view;

import com.lexmanuel.myinfo2.data.model.User;

// 11-08-2019
// 10116370
// Alexander M S
// IF-8

public interface HomeView {
    void showUser(User user);
    void onSignOut();
}
