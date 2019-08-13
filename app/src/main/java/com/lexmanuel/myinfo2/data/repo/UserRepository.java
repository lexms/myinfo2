package com.lexmanuel.myinfo2.data.repo;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;
import com.lexmanuel.myinfo2.data.db.AppDatabase;
import com.lexmanuel.myinfo2.data.db.UserDao;
import com.lexmanuel.myinfo2.data.model.User;

// 11-08-2019
// 10116370
// Alexander M S
// IF-8

public class UserRepository {

    private UserDao userDao;

    public UserRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        userDao = db.userDao();
    }

    public LiveData<User> selectUser(String username, String password) {
        return userDao.login(username, password);
    }

    public void insertUser(User user) {
        new insertAsync(userDao).execute(user);
    }

    private static class insertAsync extends AsyncTask<User, Void, Void> {
        private UserDao userDao;

        insertAsync(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... user) {
            userDao.addUser(user);
            return null;
        }
    }
}
