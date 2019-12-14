package com.wd.he_home.comtract;

import com.bwie.mvplibrary.base.IBaseView;
import com.wd.he_home.bean.BannerBean;
import com.wd.he_home.bean.EnquirySectionBean;

/**
 * author: [Liu He]
 * data: 2019/12/13.
 * function：
 */
public interface HomeContract {
    //view
    interface HomeView extends IBaseView {
        //轮播图
        void HomeViewSuccess(Object obj);
        void HomeViewError(String e);
    }
    //imodel
    interface HomeModel{
        //轮播
        void HomeModelBannerSuccess(HomeModelCallBack homeModelCallBack);
        //查询科室
        void HomeModelChaXunKeshiSuccess(HomeModelCallBack homeModelCallBack);
        //健康咨询
        void HomeModelJianKangZiXunData(HomeModelCallBack homeModelCallBack);
        //接口回调
        interface HomeModelCallBack{
            void HomeViewSuccess(Object obj);
            void HomeViewError(String e);
        }

    }
    //ipresenter
    interface HomePresenter{
        //轮播
        void HomePresenterBanner();
        //查询科室
        void HomePresenterChaXunKeShi();
        //健康咨询
        void HomePresenterJianKangZiXun();

    }
}
