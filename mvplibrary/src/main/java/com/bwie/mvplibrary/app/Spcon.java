package com.bwie.mvplibrary.app;

import com.bwie.mvplibrary.utils.SPUtils;

/**
 * date:2019/12/18
 * author:贺少伟(盗)
 * function:
 */
public class Spcon {
    public  static int doId(){
        SPUtils login = new SPUtils(App.sContent, "login");
        int id = (int) login.getSharedPreference("id", 0);

        return id;
    }
    public  static String doSessiod(){
        SPUtils login = new SPUtils(App.sContent, "login");
        String sessionId = (String) login.getSharedPreference("sessionId", "");

        return sessionId;
    }
}
