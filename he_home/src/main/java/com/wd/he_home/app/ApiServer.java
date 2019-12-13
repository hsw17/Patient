package com.wd.he_home.app;

import android.database.Observable;

import com.wd.he_home.bean.BannerBean;

import retrofit2.http.GET;


/**
 * author: [Liu He]
 * data: 2019/12/13.
 * function：
 */
public interface ApiServer {
    //首页Banner
    //http://172.17.8.100/health/share/v1/bannersShow
    @GET("share/v1/bannersShow")
    Observable<BannerBean> getBanner();



}
