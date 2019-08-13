package com.lexmanuel.myinfo2.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import com.lexmanuel.myinfo2.data.model.User;

// 11-08-2019
// 10116370
// Alexander M S
// IF-8

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void addUser(User... users);

    @Query("SELECT * FROM user WHERE username = :username AND password = :password")
    LiveData<User> login(String username, String password);
}
