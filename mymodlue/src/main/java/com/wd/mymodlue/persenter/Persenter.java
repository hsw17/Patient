package com.wd.mymodlue.persenter;


import com.bwie.mvplibrary.base.BasePresenter;
import com.wd.mymodlue.view.contract.IViewContract;



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
}
