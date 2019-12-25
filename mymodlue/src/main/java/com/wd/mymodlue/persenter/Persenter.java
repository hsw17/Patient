package com.wd.mymodlue.persenter;


import com.bwie.mvplibrary.base.BasePresenter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;


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

    @Override
    public void doTask(Map<String, Object> map, int taskId) {
        iModel.doTask(map, taskId, new IViewContract.IModel.IModelCallback() {
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

            }

            @Override
            public void onSuccessFour(Object four) {
                getView().onSuccessFour(four);
            }



            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doReceiveReward(Map<String, Object> map, int taskId) {
        iModel.doReceiveReward(map, taskId, new IViewContract.IModel.IModelCallback() {
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

            }

            @Override
            public void onSuccessFour(Object four) {
                getView().onSuccessFour(four);

            }


            @Override
            public void onFail(String str) {
                getView().onFail(str);
            }
        });
    }

    @Override
    public void doUserWallet(Map<String, Object> map) {
        iModel.doUserWallet(map, new IViewContract.IModel.IModelCallback() {
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
    public void doRecordList(Map<String, Object> map, Map<String, Object> oap) {
        iModel.doRecordList(map, oap, new IViewContract.IModel.IModelCallback() {
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
    public void doCommentList(Map<String, Object> map, Map<String, Object> oap) {
        iModel.doCommentList(map, oap, new IViewContract.IModel.IModelCallback() {
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
    public void doInvitationCode(Map<String, Object> map) {

    }

    @Override
    public void doUserInvitation(Map<String, Object> map) {
        iModel.doUserInvitation(map, new IViewContract.IModel.IModelCallback() {
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
    public void onloadHeadPic(Map<String, Object> map, MultipartBody.Part image) {
        iModel.onloadHeadPic(map, image, new IViewContract.IModel.IModelCallback() {
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
    public void onUpdateUserPwd(Map<String, Object> map, Map<String, String> oap) {
        iModel.onUpdateUserPwd(map, oap, new IViewContract.IModel.IModelCallback() {
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
    public void onModifyNickName(Map<String, Object> map, String nickName) {
        iModel.onModifyNickName(map, nickName, new IViewContract.IModel.IModelCallback() {
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
    public void onUpdateUserSex(Map<String, Object> map, int sex) {
        iModel.onUpdateUserSex(map, sex, new IViewContract.IModel.IModelCallback() {
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
    public void onUserDoctorFollowList(Map<String, Object> map, Map<String, Object> oap) {
        iModel.onUserDoctorFollowList(map, oap, new IViewContract.IModel.IModelCallback() {
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
    public void onCancelFollow(Map<String, Object> map, int doctorId) {
        iModel.onCancelFollow(map, doctorId, new IViewContract.IModel.IModelCallback() {
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
    public void onPerfectUserInfo(Map<String, Object> map, Map<String, Object> oap) {
        iModel.onPerfectUserInfo(map, oap, new IViewContract.IModel.IModelCallback() {
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
    public void onInquiryRecord(Map<String, Object> map) {
        iModel.onInquiryRecord(map, new IViewContract.IModel.IModelCallback() {
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
    public void onEndInquiry(Map<String, Object> map, int recordId) {
        iModel.onEndInquiry(map, recordId, new IViewContract.IModel.IModelCallback() {
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
    public void onjiankangzixun(Map<String,Object> map) {
        iModel.onjiankangzixun(map,new IViewContract.IModel.IModelCallback() {
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
                getView().onFail(str);

            }
        });
    }

    @Override
    public void onHistoryInquiryRecord(Map<String, Object> map, Map<String, Object> oap) {
        iModel.onHistoryInquiryRecord(map, oap, new IViewContract.IModel.IModelCallback() {
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
    public void onDoctorEvaluate(Map<String, Object> map, int recordId) {
        iModel.onDoctorEvaluate(map, recordId, new IViewContract.IModel.IModelCallback() {
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
    public void onCollectionList(Map<String, Object> map, Map<String, Object> oap) {
        iModel.onCollectionList(map, oap, new IViewContract.IModel.IModelCallback() {
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
    public void onSickCollection(Map<String, Object> map, int sickCircleId) {
        iModel.onSickCollection(map, sickCircleId, new IViewContract.IModel.IModelCallback() {
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
    public void onGetarchives(Map<String, Object> map) {
        iModel.onGetarchives(map, new IViewContract.IModel.IModelCallback() {
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
    public void onGetdeleteUserArchives(Map<String, Object> map, int archivesId) {
        iModel.onGetdeleteUserArchives(map, archivesId, new IViewContract.IModel.IModelCallback() {
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
    public void onGetupdateUserArchives(Map<String, Object> map, Map<String, Object> oap) {
        iModel.onGetupdateUserArchives(map, oap, new IViewContract.IModel.IModelCallback() {
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
    public void onGetaddUserArchives(Map<String, Object> map, Map<String, Object> oap) {
        iModel.onGetaddUserArchives(map, oap, new IViewContract.IModel.IModelCallback() {
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
    public void onGetpicture(Map<String, Object> map, List<MultipartBody.Part> picture) {
        iModel.onGetpicture(map, picture, new IViewContract.IModel.IModelCallback() {
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
    public void onVideoCollectionList(Map<String, Object> map, Map<String, Object> oap) {
        iModel.onVideoCollectionList(map, oap, new IViewContract.IModel.IModelCallback() {
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
    public void onSickCollectionList(Map<String, Object> map, Map<String, Object> oap) {
        iModel.onSickCollectionList(map, oap, new IViewContract.IModel.IModelCallback() {
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
    public void onGiftList() {
        iModel.onGiftList(new IViewContract.IModel.IModelCallback() {
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
    public void onHandselGift(Map<String, Object> map, Map<String, Object> oap) {
        iModel.onHandselGift(map, oap, new IViewContract.IModel.IModelCallback() {
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
}
