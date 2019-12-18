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
        //查询药品列表
        void HomeModelYaoPinLieBiaoData(String drugsCategoryId,String page,String count,HomeModelCallBack homeModelCallBack);
        //查询病状详情
        void HomeModelBingZhuangXiangQingData(String id,HomeModelCallBack homeModelCallBack);
        //查询药品详情
        void HomeModelYaoPinXiangQingData(String id,HomeModelCallBack homeModelCallBack);
        //咨询详情
        void HomeModelZiXunXiangQingData(String userId,String sessionId,String infoId,HomeModelCallBack homeModelCallBack);
        //首页搜索
        void HomeModelShouYeSouSuoData(String keyWord,HomeModelCallBack homeModelCallBack);
        //热门搜索
        void HomeModelReMenSouSuoData(HomeModelCallBack homeModelCallBack);
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
        //查询药品列表
        void HomePresenterYaoPinLieBiao(String drugsCategoryId,String page,String count);
        //查询病状详情
        void HomePresenterBingZhuangXiangQing(String id);
        //查询药品详情
        void HomePresenterYaoPinXiangQing(String id);
        //咨询详情
        void HomePresenterZiXunXiangQing(String userId,String sessionId,String infoId);
        //首页搜索
        void HomePresenterShouYeSouSuo(String keyWord);
        //热门搜索
        void HomePresenterReMenSouSuo();

    }
}
