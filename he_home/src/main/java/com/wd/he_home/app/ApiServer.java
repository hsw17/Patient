package com.wd.he_home.app;



import com.wd.he_home.bean.BannerBean;
import com.wd.he_home.bean.EnquirySectionBean;
import com.wd.he_home.bean.HealthinformationBean;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 *@describe(描述)：ApiServer  接口
 *@data（日期）: 2019/12/13
 *@time（时间）: 15:44
 *@author（作者）: Liuhe
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




}
