package com.wd.mymodlue.modle.ap;


import com.wd.mymodlue.modle.bean.LoginBean;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.modle.bean.UserCommentListBean;
import com.wd.mymodlue.modle.bean.UserConsumptionRecordListBean;
import com.wd.mymodlue.modle.bean.UserSignBean;
import com.wd.mymodlue.modle.bean.UserTaskListBean;
import com.wd.mymodlue.modle.bean.UserWalletBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
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

}
