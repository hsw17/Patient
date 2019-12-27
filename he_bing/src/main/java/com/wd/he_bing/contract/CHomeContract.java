package com.wd.he_bing.contract;

import com.bwie.mvplibrary.base.IBaseView;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;

/**
 * author: [Liu He]
 * data: 2019/12/19.
 * function：
 */
public interface CHomeContract {
    //iview
    interface CHomeView extends IBaseView {
        void CHomeViewSuccess(Object obj);

        void CHomeViewError(String e);
    }

    //imodel
    interface CHomeModel {
        //查询科室列表
        void CHomeModelKeShiLieBiaoData(CHomeModelCallBack cHomeModelCallBack);

        //查看病友圈详情
        void CHomeModelBingYouQuanXiangQingData(String userId, String sessionId, String sickCircleId, CHomeModelCallBack cHomeModelCallBack);

        //查询病友圈列表
        void CHomeModelBingYouQuanLieBiaoData(String departmentId, String page, String count, CHomeModelCallBack cHomeModelCallBack);

        //根据关键词查询病友圈
        void CHomeModelGuanJianCiChaXunData(String keyWord, CHomeModelCallBack cHomeModelCallBack);

        //查询病友圈评论列表
        void CHomeModelBingYouQuanPingLunData(String userId, String sessionId, String sickCircleId, String page, String count, CHomeModelCallBack cHomeModelCallBack);

        //采纳病友圈优秀的评论
        void CHomeModelCaiNaBingYouQuanData(String userId, String sessionId, String commentId, String sickCircleId, CHomeModelCallBack cHomeModelCallBack);

        //发表观点
        void CHomeModelFaBiaoGuanDianData(String userId, String sessionId, String commentId, String opinion, CHomeModelCallBack cHomeModelCallBack);

        //查看病友的病友圈发帖列表
        void CHomeModelBingYouDeBingYouQuanLieBiaoData(String patientUserId, String page, String count, CHomeModelCallBack cHomeModelCallBack);

        //查看我的病友圈发帖列表
        void CHomeModelWodeBingYouQuanData(String userId, String sessionId, String page, String count, CHomeModelCallBack cHomeModelCallBack);

        //查询我的病友圈帖子的评论列表
        void CHomeModelBingYouQuanTieZiData(String userId, String sessionId, String sickCircleId, String page, String count, CHomeModelCallBack cHomeModelCallBack);
        // //发布病友圈
        void CHomeModelFaBuBingYouQuanData(String userId, String sessionId, Map<String, Object> map,CHomeModelCallBack cHomeModelCallBack);
       //上传图片
        void CHomeModelShangChuanTuPianData(String userId, String sessionId, String sickCircleId, List<MultipartBody.Part> part,CHomeModelCallBack cHomeModelCallBack);
        //根据科室查询病症
        void CHomeModelChaXunBingZhengData(String departmentId,CHomeModelCallBack CHomeModelCallBack);
         //接口回调
        interface CHomeModelCallBack {
            void CHomeViewSuccess(Object obj);

            void CHomeViewError(String e);
        }
    }

    //ipresenter
    interface HomePresenter {
        //查询科室列表
        void CHomePresenterKeShiLieBiao();

        //查看病友圈详情
        void CHomePresenterBingYouQuanXiangQing(String userId, String sessionId, String sickCircleId);

        //查看病友圈列表
        void CHomePresenterBingYouQuanLieBiao(String departmentId, String page, String count);

        //根据关键词查询病友圈
        void CHomePresenterGuanJianCiChaXunData(String keyWord);

        //查询病友圈评论列表
        void CHomePresenterBingYouQuanPingLunData(String userId, String sessionId, String sickCircleId, String page, String count);

        //采纳病友圈优秀的评论
        void CHomePresenterCaiNaBingYouQuanData(String userId, String sessionId, String commentId, String sickCircleId);

        //发表观点
        void CHomePresenterFaBiaoGuanDianData(String userId, String sessionId, String commentId, String opinion);

        //查看病友的病友圈发帖列表
        void CHomePresenterBingYouDeBingYouQuanLieBiaoData(String patientUserId, String page, String count);

        //查看我的病友圈发帖列表
        void CHomePresenterWodeBingYouQuanData(String userId, String sessionId, String page, String count);

        //查询我的病友圈帖子的评论列表
        void CHomePresenterBingYouQuanTieZiData(String userId, String sessionId, String sickCircleId, String page, String count);
        //发布病友圈
        void CHomePresenterFaBuBingYouQuan(String userId, String sessionId, Map<String, Object> map);
        //上传图片
        void CHomePresenterShangChuanTuPian(String userId, String sessionId, String sickCircleId, List<MultipartBody.Part> part);
        //根据科室查询病症
        void CHomePresenterChaXunBingZheng(String departmentId);
    }
}
