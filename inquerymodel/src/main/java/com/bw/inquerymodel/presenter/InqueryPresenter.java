package com.bw.inquerymodel.presenter;

import com.bw.inquerymodel.bean.CurrentBean;
import com.bw.inquerymodel.bean.EndInquiryBean;
import com.bw.inquerymodel.bean.RecordListBean;
import com.bw.inquerymodel.contract.DocTorContract;
import com.bw.inquerymodel.contract.InqueryContract;
import com.bw.inquerymodel.model.InqueryModel;
import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/24
 * @Description:
 */
public class InqueryPresenter extends BasePresenter<InqueryContract.IMainView> implements InqueryContract.IPresenter {

    private InqueryModel inqueryModel;

    @Override
    public void doctorinfo(Map<String, Object> headerMap, Map<String, Object> queryMap) {
        inqueryModel.doctorinfo ( headerMap, queryMap, new InqueryContract.IModel.DoctorinfoCallBack () {
            @Override
            public void backData(EndInquiryBean endInquiryBean) {
                getView ().success ( endInquiryBean );
            }

            @Override
            public void fuilerror(String e) {
                getView ().fuilerror ( e );
            }
        } );
    }

    @Override
    public void current(Map<String, Object> headerMap) {
        inqueryModel.current ( headerMap, new InqueryContract.IModel.CurrentCallBack () {
            @Override
            public void doctorListData(CurrentBean currentBean) {
                getView ().success ( currentBean );
            }

            @Override
            public void fuilerror(String e) {
                getView ().fuilerror ( e );
            }
        } );
    }

    @Override
    public void recordlist(Map<String, Object> headerMap, Map<String, Object> queryMap) {
        inqueryModel.recordlist ( headerMap, queryMap, new InqueryContract.IModel.RecordListCallBack () {
            @Override
            public void recordListData(RecordListBean recordListBean) {
                getView ().success ( recordListBean );
            }

            @Override
            public void fuilerror(String e) {
               getView ().fuilerror ( e );
            }
        } );
    }

    @Override
    protected void initModel() {
        inqueryModel = new InqueryModel ();
    }
}
