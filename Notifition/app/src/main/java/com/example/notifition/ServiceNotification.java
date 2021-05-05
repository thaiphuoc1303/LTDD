package com.example.notifition;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.SimpleTimeZone;

public class ServiceNotification extends Service {
    DataBase dataBase = new DataBase(this, "database.sqlite", null, 1);
    Cursor cursor;

    SimpleDateFormat simpleDateFormatMain = new SimpleDateFormat("HH mm");
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();

    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        createNotificationChannel();
        final Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Calendar calendar = Calendar.getInstance();
                    int thu = calendar.get(Calendar.DAY_OF_WEEK);
                    String gio = simpleDateFormatMain.format(calendar.getTime());
                    cursor = dataBase.GetData("SELECT * FROM lichhoc WHERE thu = "+thu);

                    while(cursor.moveToNext()){
                        Date d1, d2;
                        String s1 = simpleDateFormatMain.format(calendar.getTime());
                        String s2 = cursor.getString(4);
                        try {
                            d1 = simpleDateFormatMain.parse(s1);
                            d2 = simpleDateFormatMain.parse(s2);
                            long diff = d2.getTime() - d1.getTime();
                            diff = diff/(60000);
                            if (diff<=15 && diff>0){
                                String mess = "Học phần "+cursor.getString(2)+" bắt đầu sau "+diff+" phút";
                                addNotifications("Lịch học hôm nay", mess);
//                                dataBase.QueryData("UPDATE lichhoc SET trangthai = 1 WHERE id = "+ cursor.getString(0));
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    Thread.sleep(10000);
                    onStartCommand(intent, flags,startId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        backgroundThread.start();

        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public ComponentName startForegroundService(Intent service) {
        return super.startForegroundService(service);
    }

    public void addNotifications(String tde, String ndung){
        Intent notificationIntent = new Intent(this, NotificationDetailActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel")
                .setSmallIcon(R.drawable.notification)
                .setContentTitle(tde)
                .setContentText(ndung)
                .setStyle(new NotificationCompat.BigTextStyle())
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setContentIntent(pendingIntent)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setAutoCancel(true);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());

    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_description);
            String description = getString(R.string.channel_name);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("channel", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    class NotificationDetailActivity {
    }
}
