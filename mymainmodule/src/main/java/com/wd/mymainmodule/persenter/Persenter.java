package com.wd.mymainmodule.persenter;

import com.bwie.mvplibrary.base.BasePresenter;
import com.bwie.mvplibrary.utils.RetrofitManager;
import com.wd.mymainmodule.modle.ap.Api;
import com.wd.mymainmodule.modle.bean.LoginBean;
import com.wd.mymainmodule.view.contract.IViewContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2019/12/13
 * author:贺少伟(盗)
 * function:
 */
public class Persenter extends BasePresenter<IViewContract.IView> implements IViewContract.IPresenter{


    private IModel iModel;

    @Override
    protected void initModel() {
        iModel = new IModel();
    }

    @Override
    public void doLogin(String email, String pwd) {
        iModel.doLogin(email, pwd, new IViewContract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                getView().onSuccess(obj);
            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {

            }

            @Override
            public void onSuccessFour(Object four) {

            }

            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }
}
