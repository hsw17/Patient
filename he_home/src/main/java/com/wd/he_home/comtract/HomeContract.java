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
        void HomeViewBannerSuccess(Object obj);
        void HomeViewBannerError(String e);
        //查询科室
        void HomeViewChaXunKeShiSuccess(EnquirySectionBean enquirySectionBean);
        void HomeViewChaXunKeShiError(String e);
    }
    //imodel
    interface HomeModel{
        //轮播
        void HomeModelBannerSuccess(HomeModelBannerCallBack homeModelBannerCallBack);
        //查询科室
        void HomeModelChaXunKeshiSuccess(HomeModelChaXunKeShiCallBack homeModelChaXunKeShiCallBack);
        //健康咨询
        void HomeModelJianKangZiXunData(HomeModelJianKangZiXunCallBack homeModelJianKangZiXunCallBack);
        //轮播接口
        interface HomeModelBannerCallBack{
            void HomeViewBannerSuccess(Object obj);
            void HomeViewBannerError(String e);
        }
        //查询科室
        interface HomeModelChaXunKeShiCallBack{
            //查询科室
            void HomeViewChaXunKeShiSuccess(EnquirySectionBean enquirySectionBean);
            void HomeViewChaXunKeShiError(String e);
        }
        //健康咨询
        interface HomeModelJianKangZiXunCallBack{
             //健康咨询
            void HomeModelJianKangZiXunSuccess(Object obj);
            void HomeModelJianKangZiXunError(String e);
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
