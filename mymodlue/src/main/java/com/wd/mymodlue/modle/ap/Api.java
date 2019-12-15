package com.wd.mymodlue.modle.ap;


import com.wd.mymodlue.modle.bean.LoginBean;
import com.wd.mymodlue.modle.bean.UserBean;

import java.util.Map;

import io.reactivex.Observable;

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


}
