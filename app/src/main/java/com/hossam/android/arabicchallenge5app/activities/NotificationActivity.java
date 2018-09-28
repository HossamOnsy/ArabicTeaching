package com.hossam.android.arabicchallenge5app.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;

import com.hossam.android.arabicchallenge5app.NotifyService;
import com.hossam.android.arabicchallenge5app.R;
import com.hossam.android.arabicchallenge5app.utils.SharedPreference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationActivity extends AppCompatActivity {

    @BindView(R.id.spinner_compat)
    SwitchCompat spinnerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);

        spinnerCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    SharedPreference.SaveInSharedPref(NotificationActivity.this,"true","notify");
                } else {
                    SharedPreference.SaveInSharedPref(NotificationActivity.this,"false","notify");
                }
            }
        });
    }
}
