package com.wd.health;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bwie.mvplibrary.app.App;

/**
 * date:2019/12/12
 * author:贺少伟(盗)
 * function:
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();     // Print log
        ARouter.openDebug();   // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug mode! Online version needs to be closed, otherwise there is a security risk)
        ARouter.init(this); //
    }
}
