package com.wd.mymainmodule.modle.ap;

import com.wd.mymainmodule.modle.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * date:2019/12/12
 * author:贺少伟(盗)
 * function:
 */
public interface Api {
    @FormUrlEncoded
    @POST("health/user/v1/login")
    Observable<LoginBean> doLogin(@Field("email") String email, @Field("pwd") String pwd);
}
