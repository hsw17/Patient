package com.wd.mymodlue.persenter;


import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;
import com.wd.mymodlue.modle.ap.Api;
import com.wd.mymodlue.modle.bean.HeadPicBean;
import com.wd.mymodlue.modle.bean.HealthTestBean;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.modle.bean.UserCommentListBean;
import com.wd.mymodlue.modle.bean.UserConsumptionRecordListBean;
import com.wd.mymodlue.modle.bean.UserSignBean;
import com.wd.mymodlue.modle.bean.UserTaskListBean;
import com.wd.mymodlue.modle.bean.UserWalletBean;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.Map;

import okhttp3.MultipartBody;

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

    @Override
    public void doTask(Map<String, Object> map, int taskId, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).doTask(map,taskId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<UserBean>() {
                    @Override
                    public void onNext(UserBean userBean) {
                        iModelCallback.onSuccessFour(userBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());

                    }
                });
    }

    @Override
    public void doReceiveReward(Map<String, Object> map, int taskId, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).doReceiveReward(map,taskId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<UserBean>() {
                    @Override
                    public void onNext(UserBean userBean) {
                        iModelCallback.onSuccessFour(userBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());

                    }
                });
    }

    @Override
    public void doUserWallet(Map<String, Object> map, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).doUserWallet(map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<UserWalletBean>() {
                    @Override
                    public void onNext(UserWalletBean userWalletBean) {
                        iModelCallback.onSuccess(userWalletBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void doRecordList(Map<String, Object> map, Map<String, Object> oap, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).doRecordList(map,oap)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<UserConsumptionRecordListBean>() {
                    @Override
                    public void onNext(UserConsumptionRecordListBean userConsumptionRecordListBean) {
                        iModelCallback.onSuccessOne(userConsumptionRecordListBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());

                    }
                });
    }

    @Override
    public void doCommentList(Map<String, Object> map, Map<String, Object> oap, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).doCommentList(map,oap)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<UserCommentListBean>() {
                    @Override
                    public void onNext(UserCommentListBean userCommentListBean) {
                        iModelCallback.onSuccess(userCommentListBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());

                    }
                });
    }

    @Override
    public void doInvitationCode(Map<String, Object> map, IModelCallback iModelCallback) {

    }

    @Override
    public void doUserInvitation(Map<String, Object> map, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).doUserInvitation(map)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<HealthTestBean>() {
                    @Override
                    public void onNext(HealthTestBean healthTestBean) {
                        iModelCallback.onSuccess(healthTestBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());
                    }
                });
    }

    @Override
    public void onloadHeadPic(Map<String, Object> map, MultipartBody.Part image, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).onloadHeadPic(map,image)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<HeadPicBean>() {
                    @Override
                    public void onNext(HeadPicBean headPicBean) {
                        iModelCallback.onSuccess(headPicBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                        iModelCallback.onFail(e.toString());

                    }
                });
    }

    @Override
    public void onUpdateUserPwd(Map<String, Object> map, Map<String, Object> oap, IModelCallback iModelCallback) {
        RetrofitManager.getInstance().create(Api.class).onUpdateUserPwd(map,oap)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<UserBean>() {
                    @Override
                    public void onNext(UserBean userBean) {
                        iModelCallback.onSuccess(userBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFail(e.toString());

                    }
                });
    }
}
