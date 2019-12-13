package com.wd.he_home.model;

import com.bwie.mvplibrary.utils.RetrofitManager;
import com.wd.he_home.app.ApiServer;
import com.wd.he_home.comtract.HomeContract;

/**
 * author: [Liu He]
 * data: 2019/12/13.
 * function：
 */
public class HomeModel implements HomeContract.HomeModel {
    @Override
    public void HomeModelBannerSuccess() {
        ApiServer apiServer = RetrofitManager.getInstance().create(ApiServer.class);

    }
}
