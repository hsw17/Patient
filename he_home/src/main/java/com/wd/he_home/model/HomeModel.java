package com.wd.he_home.model;

import android.database.Observable;
import android.util.Log;

import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;
import com.wd.he_home.app.ApiServer;
import com.wd.he_home.bean.BannerBean;
import com.wd.he_home.bean.ConditionDetailsBean;
import com.wd.he_home.bean.ConsultationDetailsBean;
import com.wd.he_home.bean.CorrespondingsymptomsBean;
import com.wd.he_home.bean.DrugClassificationBean;
import com.wd.he_home.bean.DrugDetailsBean;
import com.wd.he_home.bean.DrugListBean;
import com.wd.he_home.bean.EnquirySectionBean;
import com.wd.he_home.bean.HealthinformationBean;
import com.wd.he_home.bean.NewslistBean;
import com.wd.he_home.comtract.HomeContract;

/**
 * @describe(描述)：HomeModel
 * @data（日期）: 2019/12/13
 * @time（时间）: 15:44
 * @author（作者）: Liuhe
 **/
public class HomeModel implements HomeContract.HomeModel {
    @Override
    public void HomeModelBannerSuccess(HomeModelCallBack homeModelCallBack) {
        RetrofitManager.getInstance().create(ApiServer.class)
                .getBanner().compose(CommonSchedulers.io2main()).subscribe(new CommonObserver<BannerBean>() {
            @Override
            public void onNext(BannerBean bannerBean) {
                homeModelCallBack.HomeViewSuccess(bannerBean);
            }

            @Override
            public void onError(Throwable e) {
                homeModelCallBack.HomeViewError(e.getMessage());
            }
        });
    }

    //查询科室
    @Override
    public void HomeModelChaXunKeshiSuccess(HomeModelCallBack homeModelCallBack) {
        RetrofitManager.getInstance().create(ApiServer.class)
                .chaxunkeshi().compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<EnquirySectionBean>() {
                    @Override
                    public void onNext(EnquirySectionBean enquirySectionBean) {
                        homeModelCallBack.HomeViewSuccess(enquirySectionBean);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        homeModelCallBack.HomeViewError(throwable.getMessage());
                    }
                });
    }

    //健康咨询
    @Override
    public void HomeModelJianKangZiXunData(HomeModelCallBack homeModelCallBack) {
        RetrofitManager.getInstance().create(ApiServer.class)
                .jiankangzixun()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<HealthinformationBean>() {
                    @Override
                    public void onNext(HealthinformationBean healthinformationBean) {
                        homeModelCallBack.HomeViewSuccess(healthinformationBean);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        homeModelCallBack.HomeViewError(throwable.getMessage());
                    }
                });
    }

    //查询咨询列表
    @Override
    public void HomeModelZiXunLieBiaoData(String plateId, String page, String count, HomeModelCallBack homeModelCallBack) {
        RetrofitManager.getInstance().create(ApiServer.class)
                .zixunliebiao(plateId, page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<NewslistBean>() {
                    @Override
                    public void onNext(NewslistBean newslistBean) {
                        Log.d("aaaa", "onNext: " + newslistBean.getMessage());
                        homeModelCallBack.HomeViewSuccess(newslistBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeModelCallBack.HomeViewError(e.getMessage());
                    }
                });
    }

    //查询对应病症
    @Override
    public void HomeModelDuiYingBingZheng(String departmentId, HomeModelCallBack homeModelCallBack) {
        RetrofitManager.getInstance().create(ApiServer.class)
                .duiyingbingzheng(departmentId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CorrespondingsymptomsBean>() {
                    @Override
                    public void onNext(CorrespondingsymptomsBean correspondingsymptomsBean) {

                        homeModelCallBack.HomeViewSuccess(correspondingsymptomsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    homeModelCallBack.HomeViewError(e.getMessage());
                    }
                });
    }

    //药品分类
    @Override
    public void HomeModelYaoPinFenLeiData(HomeModelCallBack homeModelCallBack) {
        RetrofitManager.getInstance().create(ApiServer.class)
                .yaopinfenlei()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DrugClassificationBean>() {
                    @Override
                    public void onNext(DrugClassificationBean drugClassificationBean) {
                        homeModelCallBack.HomeViewSuccess(drugClassificationBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    homeModelCallBack.HomeViewError(e.getMessage());
                    }
                });
    }

    //药品列表
    @Override
    public void HomeModelYaoPinLieBiaoData(String drugsCategoryId, String page, String count, HomeModelCallBack homeModelCallBack) {
        RetrofitManager.getInstance().create(ApiServer.class)
                .yaopinliebiao(drugsCategoryId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DrugListBean>() {
                    @Override
                    public void onNext(DrugListBean drugListBean) {
                        homeModelCallBack.HomeViewSuccess(drugListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeModelCallBack.HomeViewError(e.getMessage());
                    }
                });
    }

    //查询病状详情
    @Override
    public void HomeModelBingZhuangXiangQingData(String id, HomeModelCallBack homeModelCallBack) {
        RetrofitManager.getInstance().create(ApiServer.class)
                .bingzhuangxiangqiang(id)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<ConditionDetailsBean>() {
                    @Override
                    public void onNext(ConditionDetailsBean conditionDetailsBean) {
                        homeModelCallBack.HomeViewSuccess(conditionDetailsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    homeModelCallBack.HomeViewError(e.getMessage());
                    }
                });
    }

    //查询药品详情
    @Override
    public void HomeModelYaoPinXiangQingData(String id, HomeModelCallBack homeModelCallBack) {
        RetrofitManager.getInstance().create(ApiServer.class)
                .yaopinxiangqing(id)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<DrugDetailsBean>() {
                    @Override
                    public void onNext(DrugDetailsBean drugDetailsBean) {
                        homeModelCallBack.HomeViewSuccess(drugDetailsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeModelCallBack.HomeViewError(e.getMessage());
                    }
                });
    }

    //咨询详情
    @Override
    public void HomeModelZiXunXiangQingData(String userId, String sessionId, String infoId, HomeModelCallBack homeModelCallBack) {
     RetrofitManager.getInstance().create(ApiServer.class)
     .zixunxiangqing(userId,sessionId,infoId)
     .compose(CommonSchedulers.io2main())
     .subscribe(new CommonObserver<ConsultationDetailsBean>() {
         @Override
         public void onNext(ConsultationDetailsBean consultationDetailsBean) {
             homeModelCallBack.HomeViewSuccess(consultationDetailsBean);
         }

         @Override
         public void onError(Throwable e) {
            homeModelCallBack.HomeViewError(e.getMessage());
         }
     });
    }
}
