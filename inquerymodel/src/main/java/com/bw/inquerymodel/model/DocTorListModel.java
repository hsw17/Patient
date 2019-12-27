package com.bw.inquerymodel.model;

import com.bw.inquerymodel.api.IApiservcie;
import com.bw.inquerymodel.bean.CurrentBean;
import com.bw.inquerymodel.bean.DepartmentBean;
import com.bw.inquerymodel.bean.DoctorListBean;
import com.bw.inquerymodel.bean.EndInquiryBean;
import com.bw.inquerymodel.bean.ResultBean;
import com.bw.inquerymodel.contract.DocTorContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/20
 * @Description:
 */
public class DocTorListModel implements DocTorContract.IModel {

    private final IApiservcie iApiservcie;

    public DocTorListModel() {
        iApiservcie = RetrofitManager.getInstance ().create ( IApiservcie.class );
    }


    @Override
    public void doctorList(Map<String, Object> queryMap, DoctorListCallBack callBack) {
        iApiservcie.doctrolist ( queryMap ).compose ( CommonSchedulers.io2main () )
                .subscribe ( new CommonObserver<DoctorListBean> () {
                    @Override
                    public void onNext(DoctorListBean doctorListBean) {
                        callBack.doctorListData ( doctorListBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuilerror ( e.getMessage () );
                    }
                } );
    }

    @Override
    public void department(DepartmentCallBack callBack) {
        iApiservcie.department ().compose ( CommonSchedulers.io2main () )
                .subscribe ( new CommonObserver<DepartmentBean> () {
                    @Override
                    public void onNext(DepartmentBean departmentBean) {
                        callBack.doctorListData ( departmentBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuilerror ( e.getMessage () );
                    }
                } );
    }

    @Override
    public void current(Map<String, Object> headerMap, CurrentCallBack callBack) {
        iApiservcie.current ( headerMap ).compose ( CommonSchedulers.io2main () )
                .subscribe ( new CommonObserver<CurrentBean> () {
                    @Override
                    public void onNext(CurrentBean currentBean) {
                         callBack.doctorListData ( currentBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                         callBack.fuilerror ( e.getMessage () );
                    }
                } );
    }

    @Override
    public void result(Map<String, Object> headerMap, int doctorId, ResultCallBack callBack) {
        iApiservcie.result ( headerMap,doctorId ).compose ( CommonSchedulers.io2main () )
                .subscribe ( new CommonObserver<ResultBean> () {
                    @Override
                    public void onNext(ResultBean resultBean) {
                        callBack.doctorListData ( resultBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuilerror ( e.getMessage () );
                    }
                } );
    }

    @Override
    public void endinquiry(Map<String, Object> headerMap, int recordId, EndinquiryCallBack callBack) {
        iApiservcie.endinquiry ( headerMap,recordId ).compose ( CommonSchedulers.io2main () )
                .subscribe ( new CommonObserver<EndInquiryBean> () {
                    @Override
                    public void onNext(EndInquiryBean endInquiryBean) {
                        callBack.doctorListData ( endInquiryBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.fuilerror ( e.getMessage () );
                    }
                } );
    }


}
