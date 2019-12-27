package com.wd.mymainmodule.view.contract;

import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

/**
 * date:2019/12/13
 * author:贺少伟(盗)
 * function: 契约类
 */
public interface IViewContract {
    //V层
    interface IView extends IBaseView {
        void onSuccess(Object obj);
        void onSuccessOne(Object one);
        void onSuccessTwo(Object two);
        void onSuccessThree(Object three);
        void onSuccessFour(Object four);
        void onFail(String str);
    }

    //P层
    interface IPresenter {
        //登录
        void doLogin(String email,String pwd);
        //发送验证码
        void doEmailCode(String email);
        //注册
        void doRegister(Map<String,Object> map);
        //重置用户密码（忘记密码用）
        void doUserPwd(Map<String,Object> map);
        //完善邮箱（微信注册用户使用）
        void doEmail(Map<String,Object> oap,String email);
    }

    //M层
    interface IModel{
//        登录
        void doLogin(String email,String pwd,IModelCallback iModelCallback);
//        发送验证码
        void doEmailCode(String email,IModelCallback iModelCallback);
//        注册
        void doRegister(Map<String,Object> map, IModelCallback iModelCallback);
//        重置用户密码（忘记密码用）
        void doUserPwd(Map<String,Object> map, IModelCallback iModelCallback);
//        完善邮箱（微信注册用户使用）
        void doEmail(Map<String,Object> oap,String email, IModelCallback iModelCallback);
        interface IModelCallback{
            void onSuccess(Object obj);
            void onSuccessOne(Object one);
            void onSuccessTwo(Object two);
            void onSuccessThree(Object three);
            void onSuccessFour(Object four);
            void onFail(String str);
        }
    }
}
