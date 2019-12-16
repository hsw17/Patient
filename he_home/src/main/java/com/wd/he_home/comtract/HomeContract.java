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
        //查询咨询列表
        void HomeModelZiXunLieBiaoData(String plateId,String page,String count,HomeModelCallBack homeModelCallBack);
        //根据科室查询对应病症
        void HomeModelDuiYingBingZheng(String departmentId,HomeModelCallBack homeModelCallBack);
        //药品分类
        void HomeModelYaoPinFenLeiData(HomeModelCallBack homeModelCallBack);
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
        //查询咨询列表
        void HomePresenterZiXunLieBiao(String plateId,String page,String count);
        //查询对应病症
        void HomePresenterDuiYingBingZheng(String departmentId);
        //药品分类
        void HomePresenterYaoPinFenLei();

    }
}
