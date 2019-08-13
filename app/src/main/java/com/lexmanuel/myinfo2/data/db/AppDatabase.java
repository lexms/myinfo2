package com.lexmanuel.myinfo2.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.lexmanuel.myinfo2.data.model.Friends;
import com.lexmanuel.myinfo2.data.model.User;

// 11-08-2019
// 10116370
// Alexander M S
// IF-8

@Database(entities = {Friends.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FriendsDao friendsDao();
    public abstract UserDao userDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "app_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
