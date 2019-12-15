package com.wd.mymodlue.view.contract;

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

    }

    //M层
    interface IModel{

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
