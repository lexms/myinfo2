package com.lexmanuel.myinfo2.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.lexmanuel.myinfo2.preference.UserPreference;
import com.lexmanuel.myinfo2.view.MainView;

// 11-08-2019
// 10116370
// Alexander M S
// IF-8

public class MainPresenter {

    private MainView view;
    private UserPreference prefs;

    public MainPresenter(Context context, MainView view) {
        this.view = view;
        prefs = new UserPreference(context);
    }

    public void isLogin() {
        if (prefs.userLogin() == null) view.toLogin();
    }

    public void addView() {
        view.addView();
    }

    public void changeView(Fragment fragment) {
        view.showView(fragment);
    }
}
