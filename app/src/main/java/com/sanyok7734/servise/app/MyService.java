package com.sanyok7734.servise.app;

import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.TimeUtils;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by sanyok7734 on 25/03/15.
 */
public class MyService extends Service {


    ExecutorService ex;
    static int count = 2;
    AlarmManager manager;
    public static Context contextMyServise;
    PendingIntent pendingIntent;


    @Override
    public void onCreate() {
        manager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Log.d("SANO", "onCreateService");
        contextMyServise = this;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Intent intentRss = new Intent(getApplication(), RssNotification.class);
        pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intentRss,
                PendingIntent.FLAG_CANCEL_CURRENT);

        manager.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), (0*60+1)*60_000, pendingIntent);

       /* ex = Executors.newFixedThreadPool(1);
        MyRun mr = new MyRun();
        ex.execute(mr);*/
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Intent intentRss = new Intent(getApplication(), RssNotification.class);
        pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intentRss,
                PendingIntent.FLAG_CANCEL_CURRENT);
        manager.cancel(pendingIntent);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    class MyRun implements Runnable {

        @Override
        public void run() {

        }

    }
}
