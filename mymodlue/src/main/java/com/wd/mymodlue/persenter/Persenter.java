package com.wd.mymodlue.persenter;


import com.bwie.mvplibrary.base.BasePresenter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.Map;


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
    public void doAddSign(Map<String, Object> map) {
         iModel.doAddSign(map, new IViewContract.IModel.IModelCallback() {
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

    @Override
    public void doFindUserSign(Map<String, Object> map) {
        iModel.doFindUserSign(map, new IViewContract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {
            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {
                getView().onSuccessTwo(two);

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

    @Override
    public void doHetherSignToday(Map<String, Object> map) {
        iModel.doHetherSignToday(map, new IViewContract.IModel.IModelCallback() {
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
                getView().onFail(str);

            }
        });
    }

    @Override
    public void doFindUserTaskList(Map<String, Object> map) {
        iModel.doFindUserTaskList(map, new IViewContract.IModel.IModelCallback() {
            @Override
            public void onSuccess(Object obj) {

            }

            @Override
            public void onSuccessOne(Object one) {

            }

            @Override
            public void onSuccessTwo(Object two) {

            }

            @Override
            public void onSuccessThree(Object three) {
                getView().onSuccessThree(three);
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
