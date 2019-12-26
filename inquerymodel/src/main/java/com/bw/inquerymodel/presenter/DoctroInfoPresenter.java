package com.bw.inquerymodel.presenter;

import com.bw.inquerymodel.bean.DoctroinfoBean;
import com.bw.inquerymodel.bean.EndInquiryBean;
import com.bw.inquerymodel.contract.DoctroInfoContract;
import com.bw.inquerymodel.model.DocTorInfoModel;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/21
 * @Description:
 */
public class DoctroInfoPresenter extends BasePresenter<DoctroInfoContract.IMainView> implements DoctroInfoContract.IPresenter {

    private DocTorInfoModel docTorInfoModel;

    @Override
    public void doctorinfo(Map<String,Object> headerMap,int doctorId) {
        docTorInfoModel.doctorinfo (headerMap, doctorId, new DoctroInfoContract.IModel.DoctorinfoCallBack () {
            @Override
            public void backData(DoctroinfoBean doctroinfoBean) {
                getView ().success ( doctroinfoBean );
            }

            @Override
            public void fuilerror(String e) {
                getView ().fuilerror ( e );
            }
        } );
    }

    @Override
    public void followdoctor(Map<String, String> headerMap, int doctorId) {
        docTorInfoModel.followdoctor ( headerMap, doctorId, new DoctroInfoContract.IModel.FollowdoctorCallBack () {
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
    public void canceldoctor(Map<String, String> headerMap, int doctorId) {
        docTorInfoModel.canceldoctor ( headerMap, doctorId, new DoctroInfoContract.IModel.FollowdoctorCallBack () {
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
    protected void initModel() {
        docTorInfoModel = new DocTorInfoModel ();
    }
}
