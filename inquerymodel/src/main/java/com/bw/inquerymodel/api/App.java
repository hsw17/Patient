package com.bw.inquerymodel.api;

import android.app.Application;
import android.content.Context;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.api.BasicCallback;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/23
 * @Description:
 */
public class App extends Application {
    private Context context;
    @Override
    public void onCreate() {
        super.onCreate ();
        context = this;
        JMessageClient.init(context);
    }
}
