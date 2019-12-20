package com.wd.mymodlue.modle.ap;


import com.wd.mymodlue.modle.bean.CurrencyNoticeListBean;
import com.wd.mymodlue.modle.bean.CurrentInquiryRecordBean;
import com.wd.mymodlue.modle.bean.HeadPicBean;
import com.wd.mymodlue.modle.bean.HealthTestBean;
import com.wd.mymodlue.modle.bean.LoginBean;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.modle.bean.UserCommentListBean;
import com.wd.mymodlue.modle.bean.UserConsumptionRecordListBean;
import com.wd.mymodlue.modle.bean.UserDoctorFollowBean;
import com.wd.mymodlue.modle.bean.UserSignBean;
import com.wd.mymodlue.modle.bean.UserTaskListBean;
import com.wd.mymodlue.modle.bean.UserWalletBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * date:2019/12/12
 * author:贺少伟(盗)
 * function:
 */
public interface Api {
// 用户签到
    @POST("health/user/verify/v1/addSign")
    Observable<UserBean> doAddSign(@HeaderMap Map<String,Object> map);

// 查询用户连续签到天数
    @GET("health/user/verify/v1/findUserSign")
    Observable<UserSignBean> doFindUserSign(@HeaderMap Map<String,Object> map);

// 查询用户当天是否签到
    @GET("health/user/verify/v1/whetherSignToday")
    Observable<UserSignBean> doHetherSignToday(@HeaderMap Map<String,Object> map);


// 查询用户任务列表
    @GET("health/user/verify/v1/findUserTaskList")
    Observable<UserTaskListBean> doFindUserTaskList(@HeaderMap Map<String,Object> map);

    // 做任务
    @POST("health/user/verify/v1/doTask")
    Observable<UserBean> doTask(@HeaderMap Map<String,Object> map, @Query("taskId")int taskId);

    // 领取任务奖励
    @POST("health/user/verify/v1/receiveReward")
    Observable<UserBean> doReceiveReward(@HeaderMap Map<String,Object> map, @Query("taskId")int taskId);

    // 我的钱包
    @GET("health/user/verify/v1/findUserWallet")
    Observable<UserWalletBean> doUserWallet(@HeaderMap Map<String,Object> map);

    // 查询用户消费记录
    @GET("health/user/verify/v1/findUserConsumptionRecordList")
    Observable<UserConsumptionRecordListBean> doRecordList(@HeaderMap Map<String,Object> map, @QueryMap Map<String,Object> oap);

    // 查询我的被采纳的建议
    @GET("health/user/verify/v1/findMyAdoptedCommentList")
    Observable<UserCommentListBean> doCommentList(@HeaderMap Map<String,Object> map, @QueryMap Map<String,Object> oap);

    // 生成邀请码
    @GET("health/user/verify/v1/makeInvitationCode")
    Observable<UserBean> doInvitationCode(@HeaderMap Map<String,Object> map);

    // 查询用户邀请码
    @GET("health/user/verify/v1/findUserInvitationCode")
    Observable<HealthTestBean> doUserInvitation(@HeaderMap Map<String,Object> map);

    //上传用户头像
    @Multipart
    @POST("health/user/verify/v1/modifyHeadPic")
    Observable<HeadPicBean> onloadHeadPic(@HeaderMap Map<String,Object> map, @Part MultipartBody.Part image);

    //修改密码
    @PUT("health/user/verify/v1/updateUserPwd")
    Observable<UserBean> onUpdateUserPwd(@HeaderMap Map<String,Object> map, @QueryMap Map<String,String> oap);

    //修改用户昵称
    @PUT("health/user/verify/v1/modifyNickName")
    Observable<UserBean> onModifyNickName(@HeaderMap Map<String,Object> map, @Query("nickName") String nickName);

    //修改用户性别
    @PUT("health/user/verify/v1/updateUserSex")
    Observable<UserBean> onUpdateUserSex(@HeaderMap Map<String,Object> map, @Query("sex") int sex);

    //查询用户关注医生列表
    @GET("health/user/verify/v1/findUserDoctorFollowList")
    Observable<UserDoctorFollowBean> onUserDoctorFollowList(@HeaderMap Map<String,Object> map, @QueryMap Map<String,Object> oap);

    //取消关注医生
    @GET("health/user/inquiry/verify/v1/cancelFollow")
    Observable<UserBean> onCancelFollow(@HeaderMap Map<String,Object> map, @Query("doctorId") int doctorId);

    //完善用户信息
    @PUT("health/user/verify/v1/perfectUserInfo")
    Observable<UserBean> onPerfectUserInfo(@HeaderMap Map<String,Object> map, @QueryMap Map<String,Object> oap);

    //用户查看当前问诊
    @GET("health/user/inquiry/verify/v1/findCurrentInquiryRecord")
    Observable<CurrentInquiryRecordBean> onInquiryRecord(@HeaderMap Map<String,Object> map);

    //结束问诊
    @PUT("health/user/inquiry/verify/v1/endInquiry")
    Observable<UserBean> onEndInquiry(@HeaderMap Map<String,Object> map,@Query("recordId") int recordId);

}
