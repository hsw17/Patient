package com.wd.mymainmodule.view.contract;

import com.bwie.mvplibrary.base.IBaseView;

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
    }

    //M层
    interface IModel{
        void doLogin(String email,String pwd,IModelCallback iModelCallback);
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
