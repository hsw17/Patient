package com.wd.he_bing.presenter;

import com.bwie.mvplibrary.base.BasePresenter;
import com.wd.he_bing.bean.AdoptcircleofPatientsBean;
import com.wd.he_bing.bean.CDepartmentlistBean;
import com.wd.he_bing.bean.CFaBiaoPingLunBean;
import com.wd.he_bing.bean.CGenJuKeShiBean;
import com.wd.he_bing.bean.CListBean;
import com.wd.he_bing.bean.CMyPatientCircle;
import com.wd.he_bing.bean.CPatientCircleBean;
import com.wd.he_bing.bean.CPatientCircleDetailsBean;
import com.wd.he_bing.bean.CPostopinionBean;
import com.wd.he_bing.bean.CZuoRenWuBean;
import com.wd.he_bing.bean.KeywordsBean;
import com.wd.he_bing.bean.LoginBean;
import com.wd.he_bing.bean.PatientCirclePostsBean;
import com.wd.he_bing.bean.PatientCircleReviewBean;
import com.wd.he_bing.bean.PostPatientCircleBean;
import com.wd.he_bing.bean.UploadImageBean;
import com.wd.he_bing.contract.CHomeContract;
import com.wd.he_bing.model.CHomeModel;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;

/**
 * author: [Liu He]
 * data: 2019/12/19.
 * function：
 */
public class CHomePresenter extends BasePresenter<CHomeContract.CHomeView> implements CHomeContract.HomePresenter {

    private CHomeModel cHomeModel;

    @Override
    protected void initModel() {
        cHomeModel = new CHomeModel();
    }

    //查询科室列表
    @Override
    public void CHomePresenterKeShiLieBiao() {

        cHomeModel.CHomeModelKeShiLieBiaoData(new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                CDepartmentlistBean cDepartmentlistBean = (CDepartmentlistBean) obj;
                getView().CHomeViewSuccess(cDepartmentlistBean);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //查询病友圈详情
    @Override
    public void CHomePresenterBingYouQuanXiangQing(String userId, String sessionId, String sickCircleId) {
        cHomeModel.CHomeModelBingYouQuanXiangQingData(userId, sessionId, sickCircleId, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                CPatientCircleDetailsBean cPatientCircleDetailsBean = (CPatientCircleDetailsBean) obj;
                getView().CHomeViewSuccess(cPatientCircleDetailsBean);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //查询病友圈列表
    @Override
    public void CHomePresenterBingYouQuanLieBiao(String departmentId, String page, String count) {
        cHomeModel.CHomeModelBingYouQuanLieBiaoData(departmentId, page, count, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                CListBean cListBean = (CListBean) obj;
                getView().CHomeViewSuccess(cListBean);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //根据关键词查询病友圈
    @Override
    public void CHomePresenterGuanJianCiChaXunData(String keyWord) {
        cHomeModel.CHomeModelGuanJianCiChaXunData(keyWord, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                KeywordsBean keywordsBean = (KeywordsBean) obj;
                getView().CHomeViewSuccess(keywordsBean);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //查询病友圈评论列表
    @Override
    public void CHomePresenterBingYouQuanPingLunData(String userId, String sessionId, String sickCircleId, String page, String count) {
        cHomeModel.CHomeModelBingYouQuanPingLunData(userId, sessionId, sickCircleId, page, count, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                PatientCircleReviewBean patientCircleReviewBean = (PatientCircleReviewBean) obj;
                getView().CHomeViewSuccess(patientCircleReviewBean);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //采纳病友圈优秀的评论
    @Override
    public void CHomePresenterCaiNaBingYouQuanData(String userId, String sessionId, String commentId, String sickCircleId) {
        cHomeModel.CHomeModelCaiNaBingYouQuanData(userId, sessionId, commentId, sickCircleId, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                AdoptcircleofPatientsBean adoptcircleofPatientsBean = (AdoptcircleofPatientsBean) obj;
                getView().CHomeViewSuccess(adoptcircleofPatientsBean);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //发表观点
    @Override
    public void CHomePresenterFaBiaoGuanDianData(String userId, String sessionId, String commentId, String opinion) {
        cHomeModel.CHomeModelFaBiaoGuanDianData(userId, sessionId, commentId, opinion, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                CPostopinionBean cPostopinionBean = (CPostopinionBean) obj;
                getView().CHomeViewSuccess(cPostopinionBean);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //查看病友的病友圈发帖列表
    @Override
    public void CHomePresenterBingYouDeBingYouQuanLieBiaoData(String patientUserId, String page, String count) {
        cHomeModel.CHomeModelBingYouDeBingYouQuanLieBiaoData(patientUserId, page, count, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                CPatientCircleBean cPatientCircleBean = (CPatientCircleBean) obj;
                getView().CHomeViewSuccess(cPatientCircleBean);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //查看我的病友圈发帖列表
    @Override
    public void CHomePresenterWodeBingYouQuanData(String userId, String sessionId, String page, String count) {
        cHomeModel.CHomeModelWodeBingYouQuanData(userId, sessionId, page, count, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                CMyPatientCircle cMyPatientCircle = (CMyPatientCircle) obj;
                getView().CHomeViewSuccess(cMyPatientCircle);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //查询我的病友圈帖子的评论列表
    @Override
    public void CHomePresenterBingYouQuanTieZiData(String userId, String sessionId, String sickCircleId, String page, String count) {
        cHomeModel.CHomeModelBingYouQuanTieZiData(userId, sessionId, sickCircleId, page, count, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                PatientCirclePostsBean patientCirclePostsBean = (PatientCirclePostsBean) obj;
                getView().CHomeViewSuccess(patientCirclePostsBean);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //发布病友圈
    @Override
    public void CHomePresenterFaBuBingYouQuan(String userId, String sessionId, Map<String, Object> map) {
        cHomeModel.CHomeModelFaBuBingYouQuanData(userId, sessionId, map, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                PostPatientCircleBean postPatientCircleBean = (PostPatientCircleBean) obj;
                getView().CHomeViewSuccess(postPatientCircleBean);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //上传图片
    @Override
    public void CHomePresenterShangChuanTuPian(String userId, String sessionId, String sickCircleId, List<MultipartBody.Part> part) {
        cHomeModel.CHomeModelShangChuanTuPianData(userId, sessionId, sickCircleId, part, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                UploadImageBean uploadImageBean = (UploadImageBean) obj;
                getView().CHomeViewSuccess(uploadImageBean);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //根据科室查询病症
    @Override
    public void CHomePresenterChaXunBingZheng(String departmentId) {
        cHomeModel.CHomeModelChaXunBingZhengData(departmentId, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                CGenJuKeShiBean cGenJuKeShiBean = (CGenJuKeShiBean) obj;
                getView().CHomeViewSuccess(cGenJuKeShiBean);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //病友圈发表评论
    @Override
    public void CHomePresenterFaBiaoPingLun(String userId, String sessionId, String sickCircleId, String content) {
        cHomeModel.CHomeModelFaBiaoPingLunData(userId, sessionId, sickCircleId, content, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                CFaBiaoPingLunBean cFaBiaoPingLunBean = (CFaBiaoPingLunBean) obj;
                getView().CHomeViewSuccess(cFaBiaoPingLunBean);
            }

            @Override
            public void CHomeViewError(String e) {
            getView().CHomeViewError(e);
            }
        });
    }

    //登录
    @Override
    public void CHomePresenterLogin(String email, String pwd) {
        cHomeModel.CHomeModelLoginData(email, pwd, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                LoginBean loginBean = (LoginBean) obj;
                getView().CHomeViewSuccess(loginBean);
            }

            @Override
            public void CHomeViewError(String e) {
                getView().CHomeViewError(e);
            }
        });
    }

    //做任务
    @Override
    public void CHomePresenterZuoRenWu(String userId, String sessionId, String taskId) {
        cHomeModel.CHomeModelZuoRenWuData(userId, sessionId, taskId, new CHomeContract.CHomeModel.CHomeModelCallBack() {
            @Override
            public void CHomeViewSuccess(Object obj) {
                CZuoRenWuBean cZuoRenWuBean = (CZuoRenWuBean) obj;
                getView().CHomeViewSuccess(cZuoRenWuBean);
            }

            @Override
            public void CHomeViewError(String e) {
            getView().CHomeViewError(e);
            }
        });
    }
}
