package com.wd.mymainmodule.modle.ap;

import com.wd.mymainmodule.modle.bean.LoginBean;
import com.wd.mymainmodule.modle.bean.RechargeBean;
import com.wd.mymainmodule.modle.bean.UserBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * date:2019/12/12
 * author:贺少伟(盗)
 * function:
 */
public interface Api {
//  登录
    @POST("health/user/v1/login")
    Observable<LoginBean> doLogin(@Query("email") String email, @Query("pwd") String pwd);
//  发送验证码
    @POST("health/user/v1/sendOutEmailCode")
    Observable<UserBean> doEmailCode(@Query("email") String email);

//  注册
    @POST("health/user/v1/register")
    Observable<UserBean> doRegister(@QueryMap Map<String,Object> map);

//  重置用户密码（忘记密码用）
    @PUT("health/user/v1/resetUserPwd")
    Observable<UserBean> doUserPwd(@QueryMap Map<String,Object> map);

}
