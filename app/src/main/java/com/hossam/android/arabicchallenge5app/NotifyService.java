package com.hossam.android.arabicchallenge5app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

import com.hossam.android.arabicchallenge5app.activities.MainActivity;
import com.hossam.android.arabicchallenge5app.activities.NotificationActivity;

import static android.content.Context.NOTIFICATION_SERVICE;

public class NotifyService extends Service {

    final static String ACTION = "NotifyServiceAction";
    final static String STOP_SERVICE_BROADCAST_KEY="StopServiceBroadcastKey";
    final static int RQS_STOP_SERVICE = 1;

    NotifyServiceReceiver notifyServiceReceiver;


    @Override
    public void onCreate() {
        notifyServiceReceiver =new NotifyServiceReceiver();
        super.onCreate();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        this.unregisterReceiver(notifyServiceReceiver);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent arg0) {

        return null;
    }

    public class NotifyServiceReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context arg0, Intent arg1) {

//            int rqs = arg1.getIntExtra(STOP_SERVICE_BROADCAST_KEY, 0);
//
//            if (rqs == RQS_STOP_SERVICE){
//                stopSelf();
//                ((NotificationManager) getSystemService(NOTIFICATION_SERVICE))
//                        .cancelAll();
//            }
        }
    }

}