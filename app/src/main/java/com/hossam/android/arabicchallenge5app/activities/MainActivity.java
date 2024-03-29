package com.hossam.android.arabicchallenge5app.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hossam.android.arabicchallenge5app.Alarm;
import com.hossam.android.arabicchallenge5app.R;
import com.hossam.android.arabicchallenge5app.fragments.MainFragment;
import com.hossam.android.arabicchallenge5app.utils.SharedPreference;
import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;

@Puppet(containerViewId = R.id.container, stickyStack = true)
//@Swiper(parallaxOffset = 0.5f, edgeSide = SwipeEdge.ALL)
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Alarm alarm = new Alarm();
        alarm.cancelAlarm(this);

        if (SharedPreference.getFromSharedPref(this, "firsttime").equals("false")) {
            if (SharedPreference.getFromSharedPref(this, "notify").equals("true") || SharedPreference.getFromSharedPref(this, "notify") == null) {
                SharedPreference.SaveInSharedPref(this, "true", "notify");
                if (SharedPreference.getFromSharedPref(this, "extrahours").equals("")||SharedPreference.getFromSharedPref(this, "extrahours").equals("24")) {
                    SharedPreference.SaveInSharedPref(this, "24", "extrahours");
                    alarm.setAlarm(this);
                }
            } else {
                alarm.cancelAlarm(this);
            }
        } else {
            SharedPreference.SaveInSharedPref(this, "false", "firsttime");
            SharedPreference.SaveInSharedPref(this, "true", "notify");
            if (SharedPreference.getFromSharedPref(this, "extrahours").equals("")) {
                SharedPreference.SaveInSharedPref(this, "24", "extrahours");
                alarm.setAlarm(this);
            }
        }
//        startNotification();

        Rigger.enableDebugLogging(true);
//        Rigger.getRigger(this).getSwipeLayout().setShadowDrawable(new int[]{
//                R.drawable.swiper_shadow_left, R.drawable.swiper_shadow_right,
//                R.drawable.swiper_shadow_top, R.drawable.swiper_shadow_bottom
//        });

        if (savedInstanceState == null) {
            Rigger.getRigger(this).showFragment(MainFragment.newInstance(), R.id.container);
        }
    }

    private void startNotification() {

    }
}
