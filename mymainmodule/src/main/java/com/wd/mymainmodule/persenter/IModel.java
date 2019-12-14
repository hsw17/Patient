package com.wd.mymainmodule.persenter;

import android.widget.Toast;

import com.bwie.mvplibrary.app.App;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;
import com.wd.mymainmodule.modle.ap.Api;
import com.wd.mymainmodule.modle.bean.LoginBean;
import com.wd.mymainmodule.modle.bean.UserBean;
import com.wd.mymainmodule.view.contract.IViewContract;

import java.util.Map;

/**
 * date:2019/12/13
 * author:贺少伟(盗)
 * function:
 */
public class IModel implements IViewContract.IModel {


    @Override
    public void doLogin(String email, String pwd, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).doLogin(email,pwd)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        if (iModelCallback!=null) {
                            iModelCallback.onSuccess(loginBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iModelCallback!=null) {
                            iModelCallback.onFail(e.toString());
                        }
                    }
                });
    }

    @Override
    public void doEmailCode(String email, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).doEmailCode(email)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<UserBean>() {
                    @Override
                    public void onNext(UserBean userBean) {
                        iModelCallback.onSuccessOne(userBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (iModelCallback!=null) {
                            iModelCallback.onFail(e.toString());
                        }
                    }
                });
    }

    @Override
    public void doRegister(Map<String, Object> map, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).doRegister(map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<UserBean>() {
                    @Override
                    public void onNext(UserBean userBean) {
                            if (iModelCallback!=null) {
                                iModelCallback.onSuccess(userBean);
                            }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
