package com.wd.mymodlue.view.contract;

import com.bwie.mvplibrary.base.IBaseView;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;

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
        //生成邀请码
        void doInvitationCode(Map<String,Object> map);
        //查询用户邀请码
        void doUserInvitation(Map<String,Object> map);
        //上传用户头像
        void onloadHeadPic(Map<String,Object> map, MultipartBody.Part image);
        //修改密码
        void onUpdateUserPwd(Map<String,Object> map,Map<String,String> oap);
        //修改用户昵称
        void onModifyNickName(Map<String,Object> map,String nickName);
        //修改用户性别
        void onUpdateUserSex(Map<String,Object> map,int sex);
        //查询用户关注医生列表
        void onUserDoctorFollowList(Map<String,Object> map,Map<String,Object> oap);
        //取消关注医生
        void onCancelFollow(Map<String,Object> map,int doctorId);
        //完善用户信息
        void onPerfectUserInfo(Map<String,Object> map,Map<String,Object> oap);

        //用户查看当前问诊
        void onInquiryRecord(Map<String,Object> map);

        //结束问诊
        void onEndInquiry(Map<String,Object> map,int recordId);

        //查询健康资讯板块
        void onjiankangzixun(Map<String,Object> map);

        //查看历史问诊
        void onHistoryInquiryRecord(Map<String,Object> map,Map<String,Object> oap);

        //查询问诊评价详情
        void onDoctorEvaluate(Map<String,Object> map,int recordId);

        //查询用户收藏病友圈列表
        void onCollectionList(Map<String,Object> map,Map<String,Object> oap);

        //取消病友圈收藏
        void onSickCollection(Map<String,Object> map,int sickCircleId);

        //查看自己的档案
        void onGetarchives(Map<String,Object> map);

        //删除档案
        void onGetdeleteUserArchives(Map<String,Object> map,int archivesId);

        //用户修改档案
        void onGetupdateUserArchives(Map<String,Object> map,Map<String,Object> oap);

        //用户添加档案
        void onGetaddUserArchives(Map<String,Object> map,Map<String,Object> oap);

        //用户档案上传图片
        void onGetpicture(Map<String,Object> map,List<MultipartBody.Part> picture);


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
//        生成邀请码
        void doInvitationCode(Map<String,Object> map, IModelCallback iModelCallback);
//        查询用户邀请码
        void doUserInvitation(Map<String,Object> map, IModelCallback iModelCallback);
//        上传用户头像
        void onloadHeadPic(Map<String,Object> map,MultipartBody.Part image, IModelCallback iModelCallback);
//       修改密码
        void onUpdateUserPwd(Map<String,Object> map,Map<String,String> oap, IModelCallback iModelCallback);
//       修改用户昵称
        void onModifyNickName(Map<String,Object> map,String nickName, IModelCallback iModelCallback);
//       修改用户性别
        void onUpdateUserSex(Map<String,Object> map,int sex, IModelCallback iModelCallback);
//       查询用户关注医生列表
        void onUserDoctorFollowList(Map<String,Object> map,Map<String,Object> oap, IModelCallback iModelCallback);
//       取消关注医生
        void onCancelFollow(Map<String,Object> map,int doctorId, IModelCallback iModelCallback);

//       完善用户信息
        void onPerfectUserInfo(Map<String,Object> map,Map<String,Object> oap, IModelCallback iModelCallback);

//       用户查看当前问诊
        void onInquiryRecord(Map<String,Object> map, IModelCallback iModelCallback);

//       结束问诊
        void onEndInquiry(Map<String,Object> map,int recordId, IModelCallback iModelCallback);

//       查询健康资讯板块
        void onjiankangzixun(Map<String,Object> map,IModelCallback iModelCallback);

//       查看历史问诊
        void onHistoryInquiryRecord(Map<String,Object> map,Map<String,Object> oap,IModelCallback iModelCallback);

//       查询问诊评价详情
        void onDoctorEvaluate(Map<String,Object> map,int recordId,IModelCallback iModelCallback);

//       查询用户收藏病友圈列表
        void onCollectionList(Map<String,Object> map,Map<String,Object> oap,IModelCallback iModelCallback);

//       取消病友圈收藏
        void onSickCollection(Map<String,Object> map,int sickCircleId,IModelCallback iModelCallback);

//       查看自己的档案
        void onGetarchives(Map<String,Object> map,IModelCallback iModelCallback);

//      删除档案
        void onGetdeleteUserArchives(Map<String,Object> map,int archivesId,IModelCallback iModelCallback);

//     用户修改档案
        void onGetupdateUserArchives(Map<String,Object> map,Map<String,Object> oap,IModelCallback iModelCallback);

//     用户添加档案
        void onGetaddUserArchives(Map<String,Object> map,Map<String,Object> oap,IModelCallback iModelCallback);

//     用户档案上传图片
        void onGetpicture(Map<String,Object> map, List<MultipartBody.Part> picture, IModelCallback iModelCallback);

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
