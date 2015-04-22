package com.sanyok7734.servise.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by sanyok7734 on 02/04/15.
 */
public class RssNotification extends BroadcastReceiver{

    NotificationManager notificationManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        int count = intent.getIntExtra("count",0);
        showNotification(context, count);
    }

    private void showNotification(Context context, int count) {
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,
                new Intent(context, MainActivity.class), PendingIntent.FLAG_CANCEL_CURRENT);

        builder
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher))
                .setTicker("OLOLO")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("BLa - Bla")
                .setContentText("Oxoxoxo новая работа приступи прямо сейчас и получи 10 долларов на аккаунт")
                .setNumber(10);

        Notification notification = builder.build();
        long vibrate[] = new long[]{1000, 1500};
        notification.defaults = Notification.DEFAULT_VIBRATE;

        notificationManager.notify(1, notification);
    }
}
