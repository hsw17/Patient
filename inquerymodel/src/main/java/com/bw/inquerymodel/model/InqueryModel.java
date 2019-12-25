package com.bw.inquerymodel.model;

import com.bw.inquerymodel.api.IApiservcie;
import com.bw.inquerymodel.bean.CurrentBean;
import com.bw.inquerymodel.bean.EndInquiryBean;
import com.bw.inquerymodel.bean.RecordListBean;
import com.bw.inquerymodel.contract.InqueryContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/24
 * @Description:
 */
public class InqueryModel implements InqueryContract.IModel {

    private final IApiservcie iApiservcie;

    public InqueryModel() {
        iApiservcie = RetrofitManager.getInstance ().create ( IApiservcie.class );
    }

    @Override
    public void doctorinfo(Map<String, Object> headerMap, Map<String, Object> queryMap, DoctorinfoCallBack callback) {
        iApiservcie.sendmessage ( headerMap,queryMap ).compose ( CommonSchedulers.io2main () )
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
    public void recordlist(Map<String, Object> headerMap, Map<String, Object> queryMap, RecordListCallBack callBack) {
        iApiservcie.recordlist ( headerMap,queryMap ).compose ( CommonSchedulers.io2main () )
                .subscribe ( new CommonObserver<RecordListBean> () {
                    @Override
                    public void onNext(RecordListBean recordListBean) {
                        callBack.recordListData ( recordListBean );
                    }

                    @Override
                    public void onError(Throwable e) {
                       callBack.fuilerror ( e.getMessage () );
                    }
                } );
    }
}
