package com.bwie.mvplibrary.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;


/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public class App extends Application {
    public static App sContent;

    @Override
    public void onCreate() {
        super.onCreate ();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
        sContent = this;
    }

    public static App getsContent() {
        return sContent;
    }
}
