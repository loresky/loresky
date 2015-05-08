package com.loresky.zoom.test.MyService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.orhanobut.logger.Logger;


/**
 * Created by cy on 15-5-8.
 */
public class MyService extends Service {
    private myBinder mBinder = new myBinder();

    public class myBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.v("random", "===onCreate()===");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Logger.v("random", "===onStartCommand()===");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Logger.v("random", "===onBind()===");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Logger.v("random", "===onUnbind()===");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Logger.v("random", "===onDestroy()===");
        super.onDestroy();
    }

}
