package com.wd.he_bing.app;

import com.wd.he_bing.bean.AdoptcircleofPatientsBean;
import com.wd.he_bing.bean.CDepartmentlistBean;
import com.wd.he_bing.bean.CFaBiaoPingLunBean;
import com.wd.he_bing.bean.CGenJuKeShiBean;
import com.wd.he_bing.bean.CListBean;
import com.wd.he_bing.bean.CMyPatientCircle;
import com.wd.he_bing.bean.CPatientCircleBean;
import com.wd.he_bing.bean.CPatientCircleDetailsBean;
import com.wd.he_bing.bean.CPostopinionBean;
import com.wd.he_bing.bean.CZuoRenWuBean;
import com.wd.he_bing.bean.KeywordsBean;
import com.wd.he_bing.bean.LoginBean;
import com.wd.he_bing.bean.PatientCirclePostsBean;
import com.wd.he_bing.bean.PatientCircleReviewBean;
import com.wd.he_bing.bean.PostPatientCircleBean;
import com.wd.he_bing.bean.UploadImageBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * author: [Liu He]
 * data: 2019/12/19.
 * function：
 */
public interface CApiServer {
    //查询科室列表
    //http://172.17.8.100/health/share/knowledgeBase/v1/findDepartment
    @GET("health/share/knowledgeBase/v1/findDepartment")
    Observable<CDepartmentlistBean> keshiliebiao();

    //查询病友圈详情
    // http://172.17.8.100/health/user/sickCircle/v1/findSickCircleInfo
    @GET("health/user/sickCircle/v1/findSickCircleInfo")
    Observable<CPatientCircleDetailsBean> bingyouquanxiangqing(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("sickCircleId") String sickCircleId);

    //查询病友圈列表
    //http://172.17.8.100/health/user/sickCircle/v1/findSickCircleList
    @GET("health/user/sickCircle/v1/findSickCircleList")
    Observable<CListBean> bingyouquanliebiao(@Query("departmentId") String departmentId, @Query("page") String page, @Query("count") String count);

    //根据关键词查询病友圈
    //http://172.17.8.100/health/user/sickCircle/v1/searchSickCircle
    @GET("health/user/sickCircle/v1/searchSickCircle")
    Observable<KeywordsBean> guanjianzichaxun(@Query("keyWord") String keyWord);

    //查询病友圈评论列表
    //http://172.17.8.100/health/user/sickCircle/v1/findSickCircleCommentList
    @GET("health/user/sickCircle/v1/findSickCircleCommentList")
    Observable<PatientCircleReviewBean> bingyouquanpinglun(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("sickCircleId") String sickCircleId, @Query("page") String page, @Query("count") String count);

    //采纳病友圈优秀的评论
    //http://172.17.8.100/health/user/sickCircle/verify/v1/adoptionProposal
    @GET("health/user/sickCircle/verify/v1/adoptionProposal")
    Observable<AdoptcircleofPatientsBean> cainaibingyouqian(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("commentId") String commentId, @Query("sickCircleId") String sickCircleId);

    //发表观点
    //http://172.17.8.100/health/user/sickCircle/verify/v1/expressOpinion
    @PUT("health/user/sickCircle/verify/v1/expressOpinion")
    Observable<CPostopinionBean> fabiaoguandian(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("commentId") String commentId, @Query("opinion") String opinion);

    //查看病友的病友圈发帖列表
    //http://172.17.8.100/health/user/sickCircle/v1/findPatientSickCircleList
    @GET("health/user/sickCircle/v1/findPatientSickCircleList")
    Observable<CPatientCircleBean> bingyoudebingyouquanliebiao(@Query("patientUserId") String patientUserId, @Query("page") String page, @Query("count") String count);

    //查看我的病友圈发帖列表
    //http://172.17.8.100/health/user/sickCircle/verify/v1/findMySickCircleList
    @GET("health/user/sickCircle/verify/v1/findMySickCircleList")
    Observable<CMyPatientCircle> wodebingyouquan(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("page") String page, @Query("count") String count);

    //查询我的病友圈帖子的评论列表
    //http://172.17.8.100/health/user/sickCircle/verify/v1/findMySickCircleCommentList
    @GET("health/user/sickCircle/verify/v1/findMySickCircleCommentList")
    Observable<PatientCirclePostsBean> bingyouquantiezi(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("sickCircleId") String sickCircleId, @Query("page") String page, @Query("count") String count);

    //发布病友圈
    //http://172.17.8.100/health/user/sickCircle/verify/v1/publishSickCircle
    @Multipart
    @POST("health/user/sickCircle/verify/v1/publishSickCircle")
    Observable<PostPatientCircleBean> fabubingyouquan(@Field("userId") String userId, @Field("sessionId") String sessionId, @Body Map<String, Object> map);

    //上传用户病友圈相关图片
    //http://172.17.8.100/health/user/sickCircle/verify/v1/uploadSickCirclePicture
    @Multipart
    @POST("health/user/sickCircle/verify/v1/uploadSickCirclePicture")
    Observable<UploadImageBean> shangchuangtupian(@Header("userId") String userId,
                                                  @Header("sessionId") String sessionId,
                                                  @Query("sickCircleId") String sickCircleId,
                                                  @Part List<MultipartBody.Part> part);

    //根据科室查询对应病症
    //http://172.17.8.100/health/share/knowledgeBase/v1/findDiseaseCategory
    @GET("health/share/knowledgeBase/v1/findDiseaseCategory")
    Observable<CGenJuKeShiBean> genjukeshichaxun(@Query("departmentId") String departmentId);

    //发表评论
    //http://172.17.8.100/health/user/sickCircle/verify/v1/publishComment
    @Multipart
    @POST("health/user/sickCircle/verify/v1/publishComment")
    Observable<CFaBiaoPingLunBean> fabiaopinglun(@Header("userId") String userId, @Header("sessionId") String sessionId, @Query("sickCircleId") String sickCircleId, @Query("content") String content);

    //登录
    //http://172.17.8.100/health/user/v1/login
    @Multipart
    @POST("health/user/v1/login")
    Observable<LoginBean> denglu(@Query("email") String email, @Query("pwd") String pwd);

    //做任务
    //http://172.17.8.100/health/user/verify/v1/doTask
    @Multipart
    @POST("health/user/verify/v1/doTask")
    Observable<CZuoRenWuBean>zuorenwu(@Header("userId") String userId, @Header("sessionId") String sessionId,@Query("taskId")String taskId);
}