package com.bw.inquerymodel.api;

import com.bw.inquerymodel.bean.CurrentBean;
import com.bw.inquerymodel.bean.DepartmentBean;
import com.bw.inquerymodel.bean.DoctorListBean;
import com.bw.inquerymodel.bean.DoctroinfoBean;
import com.bw.inquerymodel.bean.EndInquiryBean;
import com.bw.inquerymodel.bean.ResultBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/20
 * @Description:
 */
public interface IApiservcie {
    //查询科室
    @GET("health/share/knowledgeBase/v1/findDepartment")
    Observable<DepartmentBean> department();
    //查询医生列表
    @GET("health/user/inquiry/v1/findDoctorList")
    Observable<DoctorListBean> doctrolist(@QueryMap Map<String,Object> queryMap);
    //查询医生详情
    @GET("health/user/inquiry/v1/findDoctorInfo")
    Observable<DoctroinfoBean> doctroinfo(@Query ( "doctorId" ) int doctorId);
    //查询当前问诊
    @GET("health/user/inquiry/verify/v1/findCurrentInquiryRecord")
    Observable<CurrentBean> current(@HeaderMap Map<String,Object> headerMap);
    //咨询医生
    @PUT("health/user/inquiry/verify/v1/consultDoctor")
    Observable<ResultBean> result(@HeaderMap Map<String,Object> headerMap,@Query ( "doctorId" ) int doctorId);
    //结束当前问诊
    @PUT("health/user/inquiry/verify/v1/endInquiry")
    Observable<EndInquiryBean> endinquiry(@HeaderMap Map<String,Object> headerMap,@Query ( "recordId" ) int recordId);
}
