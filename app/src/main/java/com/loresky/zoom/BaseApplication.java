package com.loresky.zoom;

import android.app.Application;
import android.content.Context;

import com.loresky.zoom.daoexample.DaoMaster;
import com.loresky.zoom.daoexample.DaoSession;
import com.loresky.zoom.common.Constants;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2015/3/7.
 */
public class BaseApplication extends Application {

    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * Logger用法
         * Logger.d("hello");
         * Logger.e(exception, "message");
         * Logger.json(JSON_CONTENT);
         * 关闭日志setLogLevel(LogLevel.NONE)
         */
        Logger.init("random")               // default PRETTYLOGGER or use just init()
                .setMethodCount(3)            // default 2
                .hideThreadInfo()             // default shown
                .setLogLevel(LogLevel.FULL);  // default LogLevel.FULL
    }

    /**
     * 取得DaoMaster
     *
     * @param context
     * @return
     */
    public static DaoMaster getDaoMaster(Context context) {
        if (daoMaster == null) {
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, Constants.DB_NAME, null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    /**
     * 取得DaoSession
     *
     * @param context
     * @return
     */
    public static DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
}
