package com.wd.mymainmodule.persenter;

import android.widget.Toast;

import com.bwie.mvplibrary.app.App;
import com.bwie.mvplibrary.base.BasePresenter;
import com.bwie.mvplibrary.utils.RetrofitManager;
import com.wd.mymainmodule.modle.ap.Api;
import com.wd.mymainmodule.modle.bean.LoginBean;
import com.wd.mymainmodule.view.contract.IViewContract;

import java.util.Map;

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
                if (getView()!=null) {
                    getView().onSuccess(obj);
                }
            }

            @Override
            public void onSuccessOne(Object one) {
                getView().onFail(one.toString());
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
                if (getView()!=null) {
                    getView().onFail(str);
                }
            }
        });
    }

    @Override
    public void doEmailCode(String email) {
        iModel.doEmailCode(email, new IViewContract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessOne(Object one) {
                getView().onSuccessOne(one);
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

            }
        });
    }

    @Override
    public void doRegister(Map<String, Object> map) {
        iModel.doRegister(map, new IViewContract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
                if (getView()!=null) {
                    getView().onSuccess(obj);
                }
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

            }
        });
    }
}
