package com.loresky.zoom.test.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.loresky.zoom.MainActivity;
import com.loresky.zoom.R;

/**
 * Created by 312 on 2015/3/16.
 */
public class NotificationActivity extends Activity {
    String svcName = Context.NOTIFICATION_SERVICE;
    NotificationManager mNotifyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNotifyManager = (NotificationManager) getSystemService(svcName);

        int icon = R.mipmap.ic_launcher;
        String tickerText = "Notification";
        long when = System.currentTimeMillis();
        //新建状态栏通知
        Notification no = new Notification.Builder(this)
                .setContentTitle("好人一个")
                .setContentText("我是一个大好人")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();
        mNotifyManager.notify(0, no);

        //  点击进入notifcation进入其他页面
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!  点击进入主页面");
        // Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, MainActivity.class);

        // The stack builder object will contain an artificial back stack for the started Activity.
        // This ensures that navigating backward from the Activity leads out of your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        // Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(NotificationActivity.class);
        // Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);

        // mId allows you to update the notification later on.
        mNotifyManager.notify(1, mBuilder.build());
        mNotifyManager.cancel(0);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mNotifyManager.cancel(1);
    }
}
