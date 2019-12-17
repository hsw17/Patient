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
        //用户签到
        void doAddSign(Map<String,Object> map);
        //查询用户连续签到天数
        void doFindUserSign(Map<String,Object> map);
        //查询用户当天是否签到
        void doHetherSignToday(Map<String,Object> map);
        //查询用户任务列表
        void doFindUserTaskList(Map<String,Object> map);
    }

    //M层
    interface IModel{
//        用户签到
        void doAddSign(Map<String,Object> map, IModelCallback iModelCallback);
//        查询用户连续签到天数
        void doFindUserSign(Map<String,Object> map, IModelCallback iModelCallback);
//        查询用户当天是否签到
        void doHetherSignToday(Map<String,Object> map, IModelCallback iModelCallback);
//        查询用户任务列表
        void doFindUserTaskList(Map<String,Object> map, IModelCallback iModelCallback);

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
