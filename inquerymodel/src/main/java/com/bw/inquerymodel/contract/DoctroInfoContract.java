package com.bw.inquerymodel.contract;

import com.bw.inquerymodel.bean.DepartmentBean;
import com.bw.inquerymodel.bean.DoctorListBean;
import com.bw.inquerymodel.bean.DoctroinfoBean;
import com.bw.inquerymodel.bean.EndInquiryBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/21
 * @Description:
 */
public interface DoctroInfoContract {
    interface IMainView extends IBaseView{
        void success(DoctroinfoBean doctroinfoBean);
        void success(EndInquiryBean endInquiryBean);
        void fuilerror(String e);
    }

    interface IModel{
        void doctorinfo(Map<String,Object> headerMap,int doctorId,DoctorinfoCallBack callback);
        void followdoctor(Map<String,String> headerMap,int doctorId,FollowdoctorCallBack callback);
        void canceldoctor(Map<String,String> headerMap,int doctorId,FollowdoctorCallBack callback);

        interface DoctorinfoCallBack{
            void backData(DoctroinfoBean doctroinfoBean);
            void fuilerror(String e);
        }

        interface FollowdoctorCallBack{
            void backData(EndInquiryBean endInquiryBean);
            void fuilerror(String e);
        }
    }



    interface IPresenter{
        void doctorinfo(Map<String,Object> headerMap,int doctorId);
        void followdoctor(Map<String,String> headerMap,int doctorId);
        void canceldoctor(Map<String,String> headerMap,int doctorId);

    }
}
