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

             }
         });
    }
}
