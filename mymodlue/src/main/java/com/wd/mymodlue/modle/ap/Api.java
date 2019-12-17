package com.wd.mymodlue.modle.ap;


import com.wd.mymodlue.modle.bean.LoginBean;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.modle.bean.UserSignBean;
import com.wd.mymodlue.modle.bean.UserTaskListBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

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


}
