package com.lexmanuel.myinfo2.presenter;

import com.lexmanuel.myinfo2.view.AboutView;

// 11-08-2019
// 10116370
// Alexander M S
// IF-8

public class AboutPresenter {

    private AboutView view;

    public AboutPresenter(AboutView view) {
        this.view = view;
    }

    public void selectionView(int tab) {
        if (tab == 0) {
            view.showApp();
        } else {
            view.showCreator();
        }
    }
}
