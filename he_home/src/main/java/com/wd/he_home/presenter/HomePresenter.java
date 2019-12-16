package com.wd.he_home.presenter;

import android.util.Log;

import com.bwie.mvplibrary.base.BasePresenter;
import com.wd.he_home.bean.BannerBean;
import com.wd.he_home.bean.CorrespondingsymptomsBean;
import com.wd.he_home.bean.DrugClassificationBean;
import com.wd.he_home.bean.EnquirySectionBean;
import com.wd.he_home.bean.HealthinformationBean;
import com.wd.he_home.bean.NewslistBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.model.HomeModel;

/**
 * @describe(描述)：HomePresenter p层
 * @data（日期）: 2019/12/13
 * @time（时间）: 15:45
 * @author（作者）: Liuhe
 **/
public class HomePresenter extends BasePresenter<HomeContract.HomeView> implements HomeContract.HomePresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    //轮播图
    @Override
    public void HomePresenterBanner() {
        homeModel.HomeModelBannerSuccess(new HomeContract.HomeModel.HomeModelCallBack() {
            @Override
            public void HomeViewSuccess(Object obj) {
                BannerBean bannerBean = (BannerBean) obj;
                getView().HomeViewSuccess(bannerBean);
            }

            @Override
            public void HomeViewError(String e) {
                getView().HomeViewError(e);
            }


        });
    }


    //查询科室
    @Override
    public void HomePresenterChaXunKeShi() {
        homeModel.HomeModelChaXunKeshiSuccess(new HomeContract.HomeModel.HomeModelCallBack() {
            @Override
            public void HomeViewSuccess(Object obj) {
                EnquirySectionBean enquirySectionBean = (EnquirySectionBean) obj;
                getView().HomeViewSuccess(enquirySectionBean);
            }

            @Override
            public void HomeViewError(String e) {
                getView().HomeViewError(e);
            }


        });

    }

    //健康咨询
    @Override
    public void HomePresenterJianKangZiXun() {
        homeModel.HomeModelJianKangZiXunData(new HomeContract.HomeModel.HomeModelCallBack() {
            @Override
            public void HomeViewSuccess(Object obj) {
                HealthinformationBean healthinformationBean = (HealthinformationBean) obj;
                getView().HomeViewSuccess(healthinformationBean);
            }

            @Override
            public void HomeViewError(String e) {
                getView().HomeViewError(e);
            }

        });
    }

    //查询咨询列表
    @Override
    public void HomePresenterZiXunLieBiao(String plateId, String page, String count) {
        homeModel.HomeModelZiXunLieBiaoData(plateId, page, count, new HomeContract.HomeModel.HomeModelCallBack() {
            @Override
            public void HomeViewSuccess(Object obj) {
                NewslistBean newslistBean = (NewslistBean) obj;
                getView().HomeViewSuccess(newslistBean);
            }

            @Override
            public void HomeViewError(String e) {
                getView().HomeViewError(e);
            }
        });
    }

    //查询对应病症
    @Override
    public void HomePresenterDuiYingBingZheng(String departmentId) {
            homeModel.HomeModelDuiYingBingZheng(departmentId, new HomeContract.HomeModel.HomeModelCallBack() {
                @Override
                public void HomeViewSuccess(Object obj) {
                    CorrespondingsymptomsBean correspondingsymptomsBean = (CorrespondingsymptomsBean) obj;
                    getView().HomeViewSuccess(correspondingsymptomsBean);
                }

                @Override
                public void HomeViewError(String e) {
                getView().HomeViewError(e);
                }
            });
    }

   // 药品分类
    @Override
    public void HomePresenterYaoPinFenLei() {
     homeModel.HomeModelYaoPinFenLeiData(new HomeContract.HomeModel.HomeModelCallBack() {
         @Override
         public void HomeViewSuccess(Object obj) {
             DrugClassificationBean drugClassificationBean = (DrugClassificationBean) obj;
             getView().HomeViewSuccess(drugClassificationBean);
         }

         @Override
         public void HomeViewError(String e) {
            getView().HomeViewError(e);
         }
     });
    }
}
