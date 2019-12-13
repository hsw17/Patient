package com.wd.he_home.comtract;

import com.wd.he_home.bean.BannerBean;

/**
 * author: [Liu He]
 * data: 2019/12/13.
 * function：
 */
public interface HomeContract {
    //view
    interface HomeView{
        void HomeViewBannerSuccess(Object obj);
        void HomeViewBannerError(String e);

    }
}
