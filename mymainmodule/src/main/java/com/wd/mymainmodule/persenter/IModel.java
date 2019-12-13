package com.wd.mymainmodule.persenter;

import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;
import com.wd.mymainmodule.modle.ap.Api;
import com.wd.mymainmodule.modle.bean.LoginBean;
import com.wd.mymainmodule.view.contract.IViewContract;

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
                        iModelCallback.onSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }
}
