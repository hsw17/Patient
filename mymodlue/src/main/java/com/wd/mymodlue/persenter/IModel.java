package com.wd.mymodlue.persenter;


import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;
import com.wd.mymodlue.modle.ap.Api;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.Map;

/**
 * date:2019/12/13
 * author:贺少伟(盗)
 * function:
 */
public class IModel implements IViewContract.IModel {

    @Override
    public void doAddSign(Map<String, Object> map, final IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).doAddSign(map)
                .compose(CommonSchedulers.<UserBean>io2main())
                .subscribe(new CommonObserver<UserBean>() {
                    @Override
                    public void onNext(UserBean userBean) {
                      iModelCallback.onSuccess(userBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }
}
