package com.wd.he_home.model;

import android.database.Observable;
import android.util.Log;

import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;
import com.wd.he_home.app.ApiServer;
import com.wd.he_home.bean.BannerBean;
import com.wd.he_home.bean.EnquirySectionBean;
import com.wd.he_home.bean.HealthinformationBean;
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
}
