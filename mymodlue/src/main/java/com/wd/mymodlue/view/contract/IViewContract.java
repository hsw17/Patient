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
        //做任务
        void doTask(Map<String,Object> map,int taskId);
        //领取任务奖励
        void doReceiveReward(Map<String,Object> map,int taskId);
        //我的钱包
        void doUserWallet(Map<String,Object> map);
        //查询用户消费记录
        void doRecordList(Map<String,Object> map,Map<String,Object> oap);
        //查询我的被采纳的建议
        void doCommentList(Map<String,Object> map,Map<String,Object> oap);
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
//        做任务
        void doTask(Map<String,Object> map,int taskId, IModelCallback iModelCallback);
//        领取任务奖励
        void doReceiveReward(Map<String,Object> map,int taskId, IModelCallback iModelCallback);
//        我的钱包
        void doUserWallet(Map<String,Object> map, IModelCallback iModelCallback);
//        查询用户消费记录
        void doRecordList(Map<String,Object> map,Map<String,Object> oap, IModelCallback iModelCallback);
//        查询我的被采纳的建议
        void doCommentList(Map<String,Object> map,Map<String,Object> oap, IModelCallback iModelCallback);

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
