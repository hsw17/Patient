package com.wd.he_bing.model;

import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;
import com.wd.he_bing.app.CApiServer;
import com.wd.he_bing.bean.AdoptcircleofPatientsBean;
import com.wd.he_bing.bean.CDepartmentlistBean;
import com.wd.he_bing.bean.CGenJuKeShiBean;
import com.wd.he_bing.bean.CListBean;
import com.wd.he_bing.bean.CMyPatientCircle;
import com.wd.he_bing.bean.CPatientCircleBean;
import com.wd.he_bing.bean.CPatientCircleDetailsBean;
import com.wd.he_bing.bean.CPostopinionBean;
import com.wd.he_bing.bean.KeywordsBean;
import com.wd.he_bing.bean.PatientCirclePostsBean;
import com.wd.he_bing.bean.PatientCircleReviewBean;
import com.wd.he_bing.bean.PostPatientCircleBean;
import com.wd.he_bing.bean.UploadImageBean;
import com.wd.he_bing.contract.CHomeContract;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;

/**
 * author: [Liu He]
 * data: 2019/12/19.
 * function：
 */
public class CHomeModel implements CHomeContract.CHomeModel {
    //查询科室列表
    @Override
    public void CHomeModelKeShiLieBiaoData(CHomeModelCallBack cHomeModelCallBack) {
        RetrofitManager.getInstance().create(CApiServer.class)
                .keshiliebiao()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CDepartmentlistBean>() {
                    @Override
                    public void onNext(CDepartmentlistBean cDepartmentlistBean) {
                        cHomeModelCallBack.CHomeViewSuccess(cDepartmentlistBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cHomeModelCallBack.CHomeViewError(e.getMessage());
                    }
                });
    }

    //病友圈详情
    @Override
    public void CHomeModelBingYouQuanXiangQingData(String userId, String sessionId, String sickCircleId, CHomeModelCallBack cHomeModelCallBack) {
        RetrofitManager.getInstance().create(CApiServer.class)
                .bingyouquanxiangqing(userId, sessionId, sickCircleId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CPatientCircleDetailsBean>() {
                    @Override
                    public void onNext(CPatientCircleDetailsBean cPatientCircleDetailsBean) {
                        cHomeModelCallBack.CHomeViewSuccess(cPatientCircleDetailsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cHomeModelCallBack.CHomeViewError(e.getMessage());
                    }
                });
    }

    //查询病友圈列表
    @Override
    public void CHomeModelBingYouQuanLieBiaoData(String departmentId, String page, String count, CHomeModelCallBack cHomeModelCallBack) {
        RetrofitManager.getInstance().create(CApiServer.class)
                .bingyouquanliebiao(departmentId, page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CListBean>() {
                    @Override
                    public void onNext(CListBean cListBean) {
                        cHomeModelCallBack.CHomeViewSuccess(cListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cHomeModelCallBack.CHomeViewError(e.getMessage());
                    }
                });
    }

    //根据关键词查询病友圈
    @Override
    public void CHomeModelGuanJianCiChaXunData(String keyWord, CHomeModelCallBack cHomeModelCallBack) {
        RetrofitManager.getInstance().create(CApiServer.class)
                .guanjianzichaxun(keyWord)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<KeywordsBean>() {
                    @Override
                    public void onNext(KeywordsBean keywordsBean) {
                        cHomeModelCallBack.CHomeViewSuccess(keywordsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cHomeModelCallBack.CHomeViewError(e.getMessage());
                    }
                });
    }

    //查询病友圈评论列表
    @Override
    public void CHomeModelBingYouQuanPingLunData(String userId, String sessionId, String sickCircleId, String page, String count, CHomeModelCallBack cHomeModelCallBack) {
        RetrofitManager.getInstance().create(CApiServer.class)
                .bingyouquanpinglun(userId, sessionId, sickCircleId, page, count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PatientCircleReviewBean>() {
                    @Override
                    public void onNext(PatientCircleReviewBean patientCircleReviewBean) {
                        cHomeModelCallBack.CHomeViewSuccess(patientCircleReviewBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cHomeModelCallBack.CHomeViewError(e.getMessage());
                    }
                });
    }

    //采纳病友圈优秀的评论
    @Override
    public void CHomeModelCaiNaBingYouQuanData(String userId, String sessionId, String commentId, String sickCircleId, CHomeModelCallBack cHomeModelCallBack) {
        RetrofitManager.getInstance().create(CApiServer.class)
                .cainaibingyouqian(userId, sessionId, commentId, sickCircleId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<AdoptcircleofPatientsBean>() {
                    @Override
                    public void onNext(AdoptcircleofPatientsBean adoptcircleofPatientsBean) {
                        cHomeModelCallBack.CHomeViewSuccess(adoptcircleofPatientsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cHomeModelCallBack.CHomeViewError(e.getMessage());
                    }
                });
    }

    //发表观点
    @Override
    public void CHomeModelFaBiaoGuanDianData(String userId, String sessionId, String commentId, String opinion, CHomeModelCallBack cHomeModelCallBack) {
        RetrofitManager.getInstance().create(CApiServer.class)
                .fabiaoguandian(userId, sessionId, commentId, opinion)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CPostopinionBean>() {
                    @Override
                    public void onNext(CPostopinionBean cPostopinionBean) {
                        cHomeModelCallBack.CHomeViewSuccess(cPostopinionBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cHomeModelCallBack.CHomeViewError(e.getMessage());
                    }
                });
    }

    //查看病友的病友圈发帖列表
    @Override
    public void CHomeModelBingYouDeBingYouQuanLieBiaoData(String patientUserId, String page, String count, CHomeModelCallBack cHomeModelCallBack) {
        RetrofitManager.getInstance().create(CApiServer.class)
                .bingyoudebingyouquanliebiao(patientUserId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CPatientCircleBean>() {
                    @Override
                    public void onNext(CPatientCircleBean cPatientCircleBean) {
                        cHomeModelCallBack.CHomeViewSuccess(cPatientCircleBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cHomeModelCallBack.CHomeViewError(e.getMessage());
                    }
                });
    }

    //查看我的病友圈发帖列表
    @Override
    public void CHomeModelWodeBingYouQuanData(String userId, String sessionId, String page, String count, CHomeModelCallBack cHomeModelCallBack) {
        RetrofitManager.getInstance().create(CApiServer.class)
                .wodebingyouquan(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CMyPatientCircle>() {
                    @Override
                    public void onNext(CMyPatientCircle cMyPatientCircle) {
                        cHomeModelCallBack.CHomeViewSuccess(cMyPatientCircle);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cHomeModelCallBack.CHomeViewError(e.getMessage());
                    }
                });
    }

    //查询我的病友圈帖子的评论列表
    @Override
    public void CHomeModelBingYouQuanTieZiData(String userId, String sessionId, String sickCircleId, String page, String count, CHomeModelCallBack cHomeModelCallBack) {
        RetrofitManager.getInstance().create(CApiServer.class)
                .bingyouquantiezi(userId,sessionId,sickCircleId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PatientCirclePostsBean>() {
                    @Override
                    public void onNext(PatientCirclePostsBean patientCirclePostsBean) {
                        cHomeModelCallBack.CHomeViewSuccess(patientCirclePostsBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cHomeModelCallBack.CHomeViewError(e.getMessage());
                    }
                });
    }

    //发布病友圈
    @Override
    public void CHomeModelFaBuBingYouQuanData(String userId, String sessionId, Map<String, Object> map, CHomeModelCallBack cHomeModelCallBack) {
        RetrofitManager.getInstance().create(CApiServer.class)
                .fabubingyouquan(userId,sessionId,map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<PostPatientCircleBean>() {
                    @Override
                    public void onNext(PostPatientCircleBean postPatientCircleBean) {
                        cHomeModelCallBack.CHomeViewSuccess(postPatientCircleBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        cHomeModelCallBack.CHomeViewError(e.getMessage());

                    }
                });
    }

    //上传图片
    @Override
    public void CHomeModelShangChuanTuPianData(String userId, String sessionId, String sickCircleId, List<MultipartBody.Part> part, CHomeModelCallBack cHomeModelCallBack) {
    RetrofitManager.getInstance().create(CApiServer.class)
            .shangchuangtupian(userId,sessionId,sickCircleId,part)
            .compose(CommonSchedulers.io2main())
            .subscribe(new CommonObserver<UploadImageBean>() {
                @Override
                public void onNext(UploadImageBean uploadImageBean) {
                    cHomeModelCallBack.CHomeViewSuccess(uploadImageBean);
                }

                @Override
                public void onError(Throwable e) {
                    cHomeModelCallBack.CHomeViewError(e.getMessage());
                }
            });
    }

    //根据科室查询病症
    @Override
    public void CHomeModelChaXunBingZhengData(String departmentId, CHomeModelCallBack CHomeModelCallBack) {
        RetrofitManager.getInstance().create(CApiServer.class)
                .genjukeshichaxun(departmentId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CGenJuKeShiBean>() {
                    @Override
                    public void onNext(CGenJuKeShiBean cGenJuKeShiBean) {
                            CHomeModelCallBack.CHomeViewSuccess(cGenJuKeShiBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    CHomeModelCallBack.CHomeViewError(e.getMessage());
                    }
                });
    }

}
