package com.bw.inquerymodel.model;

import com.bw.inquerymodel.api.IApiservcie;
import com.bw.inquerymodel.bean.DoctroinfoBean;
import com.bw.inquerymodel.bean.EndInquiryBean;
import com.bw.inquerymodel.contract.DoctroInfoContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

import java.util.Map;

import retrofit2.http.HeaderMap;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/21
 * @Description:
 */
public class DocTorInfoModel implements DoctroInfoContract.IModel {

    private final IApiservcie iApiservcie;

    public DocTorInfoModel() {
        iApiservcie = RetrofitManager.getInstance ().create ( IApiservcie.class );
    }

    @Override
    public void doctorinfo(Map<String,Object> headerMap,int doctorId, DoctorinfoCallBack callback) {
        iApiservcie.doctroinfo ( headerMap,doctorId ).compose ( CommonSchedulers.io2main () )
                .subscribe ( new CommonObserver<DoctroinfoBean> () {
                    @Override
                    public void onNext(DoctroinfoBean doctroinfoBean) {
                        callback.backData ( doctroinfoBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                       callback.fuilerror ( e.getMessage () );
                    }
                } );
    }

    @Override
    public void followdoctor(Map<String, String> headerMap, int doctorId, FollowdoctorCallBack callback) {
        iApiservcie.followdoctor ( headerMap,doctorId )
                .compose ( CommonSchedulers.io2main () )
                .subscribe ( new CommonObserver<EndInquiryBean> () {
                    @Override
                    public void onNext(EndInquiryBean endInquiryBean) {
                        callback.backData ( endInquiryBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.fuilerror ( e.getMessage () );
                    }
                } );
    }

    @Override
    public void canceldoctor(Map<String, String> headerMap, int doctorId, FollowdoctorCallBack callback) {
         iApiservcie.canceldoctor ( headerMap,doctorId )
                 .compose ( CommonSchedulers.io2main () )
                 .subscribe ( new CommonObserver<EndInquiryBean> () {
                     @Override
                     public void onNext(EndInquiryBean endInquiryBean) {
                         callback.backData ( endInquiryBean );
                     }

                     @Override
                     public void onError(Throwable e) {
                        callback.fuilerror ( e.getMessage () );
                     }
                 } );
    }
}
