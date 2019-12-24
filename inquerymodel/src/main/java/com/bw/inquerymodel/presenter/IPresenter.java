package com.bw.inquerymodel.presenter;

import com.bw.inquerymodel.bean.CurrentBean;
import com.bw.inquerymodel.bean.DepartmentBean;
import com.bw.inquerymodel.bean.DoctorListBean;
import com.bw.inquerymodel.bean.EndInquiryBean;
import com.bw.inquerymodel.bean.ResultBean;
import com.bw.inquerymodel.contract.DocTorContract;
import com.bw.inquerymodel.model.DocTorListModel;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/20
 * @Description:
 */
public class IPresenter extends BasePresenter<DocTorContract.IMainView> implements DocTorContract.IPresenter {

    private DocTorListModel docTorListModel;

    @Override
    public void doctorList(Map<String, Object> queryMap) {
        docTorListModel.doctorList ( queryMap, new DocTorContract.IModel.DoctorListCallBack () {
            @Override
            public void doctorListData(DoctorListBean doctorListBean) {
                getView ().success ( doctorListBean );
            }

            @Override
            public void fuilerror(String e) {
                getView ().fuilerror ( e );
            }
        } );
    }

    @Override
    public void department() {
        docTorListModel.department ( new DocTorContract.IModel.DepartmentCallBack () {
            @Override
            public void doctorListData(DepartmentBean departmentBean) {
                getView ().success ( departmentBean );
            }

            @Override
            public void fuilerror(String e) {
                getView ().fuilerror ( e );
            }
        } );
    }

    @Override
    public void current(Map<String, Object> headerMap) {
        docTorListModel.current ( headerMap, new DocTorContract.IModel.CurrentCallBack () {
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
    public void result(Map<String, Object> headerMap, int doctorId) {
         docTorListModel.result ( headerMap, doctorId, new DocTorContract.IModel.ResultCallBack () {
             @Override
             public void doctorListData(ResultBean resultBean) {
                 getView ().success ( resultBean );
             }

             @Override
             public void fuilerror(String e) {
                 getView ().fuilerror ( e );
             }
         } );
    }

    @Override
    public void endinquiry(Map<String, Object> headerMap, int recordId) {
        docTorListModel.endinquiry ( headerMap, recordId, new DocTorContract.IModel.EndinquiryCallBack () {
            @Override
            public void doctorListData(EndInquiryBean endInquiryBean) {
                getView ().success ( endInquiryBean );
            }

            @Override
            public void fuilerror(String e) {
                getView ().fuilerror ( e );
            }
        } );
    }

    @Override
    protected void initModel() {
        docTorListModel = new DocTorListModel ();
    }
}
