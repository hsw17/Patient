package com.wd.mymodlue.persenter;


import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;
import com.wd.mymodlue.modle.ap.Api;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.modle.bean.UserSignBean;
import com.wd.mymodlue.modle.bean.UserTaskListBean;
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
                .compose(CommonSchedulers.io2main())
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

    @Override
    public void doFindUserSign(Map<String, Object> map, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).doFindUserSign(map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<UserSignBean>() {
                    @Override
                    public void onNext(UserSignBean userSignBean) {
                        iModelCallback.onSuccessTwo(userSignBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doHetherSignToday(Map<String, Object> map, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).doHetherSignToday(map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<UserSignBean>() {
                    @Override
                    public void onNext(UserSignBean userSignBean) {
                        iModelCallback.onSuccessOne(userSignBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doFindUserTaskList(Map<String, Object> map, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).doFindUserTaskList(map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<UserTaskListBean>() {
                    @Override
                    public void onNext(UserTaskListBean userTaskListBean) {
                        iModelCallback.onSuccessThree(userTaskListBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });

    }
}
