package com.lexmanuel.myinfo2.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lexmanuel.myinfo2.R;
import com.lexmanuel.myinfo2.data.model.Friends;
import com.lexmanuel.myinfo2.data.model.FriendsData;
import com.lexmanuel.myinfo2.data.repo.FriendsRepository;
import com.lexmanuel.myinfo2.preference.UserPreference;

// 11-08-2019
// 10116370
// Alexander M S
// IF-8

public class SplashActivity extends AppCompatActivity {

    FriendsRepository repo;
    UserPreference prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        repo = new FriendsRepository(this);
        prefs = new UserPreference(this);

        Boolean isFirstRun = prefs.isFirstRun();
        if (isFirstRun) {
            Friends friends;
            for (String[] aData : FriendsData.initFriendsData) {
                friends = new Friends(aData[0], aData[1], aData[2], aData[3], aData[4], aData[5]);
                repo.insertFriend(friends);
            }

            prefs.setFirstRun(false);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, IntroActivity.class);
                startActivity(i);
                finish();

            }
        },2000);
    }
}
