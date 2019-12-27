package com.bwie.mvplibrary.app;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;



/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public class App extends Application {
    public static App sContent;
    // APP_ID 替换为你的应用从官方网站申请到的合法appID
    private static final String APP_ID = "wxe3fcbe8a55cd33ff";

    @Override
    public void onCreate() {
        super.onCreate ();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
        sContent = this;
        Fresco.initialize(this);
    }

    public static App getsContent() {
        return sContent;
    }
}
