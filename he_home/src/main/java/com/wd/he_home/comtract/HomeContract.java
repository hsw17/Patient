package com.wd.he_home.comtract;

import com.bwie.mvplibrary.base.IBaseView;
import com.wd.he_home.bean.BannerBean;

/**
 * author: [Liu He]
 * data: 2019/12/13.
 * function：
 */
public interface HomeContract {
    //view
    interface HomeView extends IBaseView {
        void HomeViewBannerSuccess(Object obj);
        void HomeViewBannerError(String e);
    }
    //imodel
    interface HomeModel{
        //轮播
        void HomeModelBannerSuccess();
        //轮播接口
        interface HomeModelBannerCallBack{
            void HomeViewBannerSuccess(Object obj);
            void HomeViewBannerError(String e);

        }
    }
    //ipresenter
    interface HomePresenter{
        void HomePresenterAttach(HomeContract.HomeView homeView);
        void HomePresenterDeach();
        //轮播
        void HomePresenterBanner();

    }
}
