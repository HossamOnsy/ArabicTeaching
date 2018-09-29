package com.hossam.android.arabicchallenge5app;


import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.hossam.android.arabicchallenge5app.activities.MainActivity;
import com.hossam.android.arabicchallenge5app.utils.SharedPreference;

public class Alarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String s = SharedPreference.getFromSharedPref(context, "extrahours");
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.alef)
                        .setPriority(Notification.PRIORITY_MAX)
                        .setContentTitle("Reminder")
                        .setChannelId("my_channel_01")
                        .setContentText("It has been " + s + " hours since you last practiced");

        Log.v("sssssss", s);

        Intent notificationIntent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        String CHANNEL_ID = "my_channel_01";// The id of the channel.
        CharSequence name = context.getString(R.string.app_name);// The user-visible name of the channel.
        int importance = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            importance = NotificationManager.IMPORTANCE_HIGH;
        }
        NotificationChannel mChannel;
        // Add as notification
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            if (manager != null) {
                manager.createNotificationChannel(mChannel);
            }
        }
        if (manager != null) {
            manager.notify(0, builder.build());
        }
        switch (s) {
            case "24":
                Log.v("sssssss24", s);
                SharedPreference.SaveInSharedPref(context, "48", "extrahours");
                setAlarm(context);
                break;
            case "48":
                Log.v("sssssss48", s);
                SharedPreference.SaveInSharedPref(context, "72", "extrahours");
                setAlarm(context);
                break;
            case "72":
                cancelAlarm(context);
                SharedPreference.SaveInSharedPref(context, "24", "extrahours");
                break;
        }


//        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
//        PowerManager.WakeLock wl = null;
//        if (pm != null) {
//            wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
//        }
//        if (wl != null) {
//            wl.acquire(10*60*1000L /*10 minutes*/);
//        }
//
//        if (wl != null) {
//            wl.release();
//        }
    }

    public void setAlarm(Context context) {
        Log.v("sssssss", "setAlarm");
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, Alarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
        long interval = 1000 * 60 * 60 * 24;
        if (am != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + interval, pi); // Millisec * Second * Minute
            else {
                am.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + interval, pi); // Millisec * Second * Minute

            }
        }


    }

    public void cancelAlarm(Context context) {
        Log.v("sssssss", "Cancel Alarm");
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (alarmManager != null) {
            alarmManager.cancel(sender);
        }
    }
}