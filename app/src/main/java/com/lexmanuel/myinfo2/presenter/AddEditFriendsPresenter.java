package com.lexmanuel.myinfo2.presenter;

import android.content.Context;
import android.widget.EditText;

import com.lexmanuel.myinfo2.data.model.Friends;
import com.lexmanuel.myinfo2.data.repo.FriendsRepository;
import com.lexmanuel.myinfo2.view.AddEditFriendsView;

// 11-08-2019
// 10116370
// Alexander M S
// IF-8

public class AddEditFriendsPresenter {

    private FriendsRepository repo;
    private AddEditFriendsView view;

    public AddEditFriendsPresenter(Context context, AddEditFriendsView view) {
        this.view = view;
        repo = new FriendsRepository(context);
    }

    public void isEdit(int type) {
        if (type == 1) {
            view.showData();
        }
    }

    public void addFriend(Friends friend) {
        try {
            repo.insertFriend(friend);
            view.onFriendAdded();
        } catch (Exception ex) {
            view.showFailed("Failed to add friend, NIM "+friend.getNim()+" already used");
        }
    }

    public void updateFriend(Friends friend) {
        try {
            repo.updateFriend(friend);
            view.onFriendUpdated(friend);
        } catch (Exception ex) {
            view.showFailed("Failed to update friend, NIM "+friend.getNim()+" already used");
        }
    }

    public void setError(EditText et) {
        view.showError(et);
    }
}
