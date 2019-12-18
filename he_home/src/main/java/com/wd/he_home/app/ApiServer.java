package com.wd.he_home.app;


import com.wd.he_home.bean.BannerBean;
import com.wd.he_home.bean.ConditionDetailsBean;
import com.wd.he_home.bean.ConsultationDetailsBean;
import com.wd.he_home.bean.CorrespondingsymptomsBean;
import com.wd.he_home.bean.DrugClassificationBean;
import com.wd.he_home.bean.DrugDetailsBean;
import com.wd.he_home.bean.DrugListBean;
import com.wd.he_home.bean.EnquirySectionBean;
import com.wd.he_home.bean.HealthinformationBean;
import com.wd.he_home.bean.HomeSearchBean;
import com.wd.he_home.bean.NewslistBean;
import com.wd.he_home.bean.PopularSearchesBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;


/**
 * @describe(描述)：ApiServer 接口
 * @data（日期）: 2019/12/13
 * @time（时间）: 15:44
 * @author（作者）: Liuhe
 **/
public interface ApiServer {
    //首页Banner
    //http://172.17.8.100/health/share/v1/bannersShow
    @GET("health/share/v1/bannersShow")
    Observable<BannerBean> getBanner();

    //查询科室列表
    //http://172.17.8.100/health/share/knowledgeBase/v1/findDepartment
    @GET("health/share/knowledgeBase/v1/findDepartment")
    Observable<EnquirySectionBean> chaxunkeshi();

    //查询健康资讯板块
    //http://172.17.8.100/health/share/information/v1/findInformationPlateList
    @GET("health/share/information/v1/findInformationPlateList")
    Observable<HealthinformationBean> jiankangzixun();

    //根据资讯板块查询资讯列表
    //http://172.17.8.100/health/share/information/v1/findInformationList
    @GET("health/share/information/v1/findInformationList")
    Observable<NewslistBean> zixunliebiao(@Query("plateId") String plateId, @Query("page") String page, @Query("count") String count);

    //根据科室查询对应病症
    //http://172.17.8.100/health/share/knowledgeBase/v1/findDiseaseCategory
    @GET("health/share/knowledgeBase/v1/findDiseaseCategory")
    Observable<CorrespondingsymptomsBean> duiyingbingzheng(@Query("departmentId") String departmentId);
    //药品科目分类列表查询
    //http://172.17.8.100/health/share/knowledgeBase/v1/findDrugsCategoryList
    @GET("health/share/knowledgeBase/v1/findDrugsCategoryList")
    Observable<DrugClassificationBean> yaopinfenlei();
    //查询药品列表
    //http://172.17.8.100/health/share/knowledgeBase/v1/findDrugsKnowledgeList
    @GET("health/share/knowledgeBase/v1/findDrugsKnowledgeList")
    Observable<DrugListBean> yaopinliebiao(@Query("drugsCategoryId")String drugsCategoryId,@Query("page")String page,@Query("count")String count);
    //查询病状详情
    //http://172.17.8.100/health/share/knowledgeBase/v1/findDiseaseKnowledge
    @GET("health/share/knowledgeBase/v1/findDiseaseKnowledge")
    Observable<ConditionDetailsBean> bingzhuangxiangqiang(@Query("id")String id);
    //查询常见药品详情
    //http://172.17.8.100/health/share/knowledgeBase/v1/findDrugsKnowledge
    @GET("health/share/knowledgeBase/v1/findDrugsKnowledge")
    Observable<DrugDetailsBean> yaopinxiangqing(@Query("id")String id);
    //咨询详情
    //http://172.17.8.100/health/share/information/v1/findInformation
    @GET("health/share/information/v1/findInformation")
    Observable<ConsultationDetailsBean> zixunxiangqing(@Header("userId")String userId,@Header("sessionId")String sessionId,@Query("infoId")String infoId);
    //首页搜索
    //http://172.17.8.100/health/share/v1/homePageSearch
    @GET("health/share/v1/homePageSearch")
    Observable<HomeSearchBean> shouyesousuo(@Query("keyWord")String keyWord);
    //热门搜索
    //http://172.17.8.100/health/share/v1/popularSearch
    @GET("health/share/v1/popularSearch")
    Observable<PopularSearchesBean> remensousuo();
}
