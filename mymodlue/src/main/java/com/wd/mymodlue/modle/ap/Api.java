package com.wd.mymodlue.modle.ap;


import com.wd.mymodlue.modle.bean.LoginBean;
import com.wd.mymodlue.modle.bean.UserBean;

import java.util.Map;

import io.reactivex.Observable;
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


}
