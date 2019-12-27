package com.bw.inquerymodel.contract;

import com.bw.inquerymodel.bean.CurrentBean;
import com.bw.inquerymodel.bean.DepartmentBean;
import com.bw.inquerymodel.bean.DoctorListBean;
import com.bw.inquerymodel.bean.EndInquiryBean;
import com.bw.inquerymodel.bean.ResultBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

import retrofit2.http.Query;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/20
 * @Description:
 */
public interface DocTorContract {
    interface IMainView extends IBaseView{
        void success(DoctorListBean doctorList);
        void success(DepartmentBean departmentBean);
        void success(CurrentBean currentBean);
        void success(ResultBean resultBean);
        void success(EndInquiryBean endInquiryBean);
        void fuilerror(String e);
    }

    interface IModel{
        void doctorList( Map<String,Object> queryMap,DoctorListCallBack callBack);
        void department( DepartmentCallBack callBack );
        void current( Map<String,Object> headerMap,CurrentCallBack callBack );
        void result(Map<String,Object> headerMap, int doctorId,ResultCallBack callBack);
        void endinquiry(Map<String,Object> headerMap, int recordId,EndinquiryCallBack callBack);

        interface DoctorListCallBack{
            void doctorListData(DoctorListBean doctorListBean);
            void fuilerror(String e);
        }

        interface DepartmentCallBack{
            void doctorListData(DepartmentBean departmentBean);
            void fuilerror(String e);
        }

        interface CurrentCallBack{
            void doctorListData(CurrentBean currentBean);
            void fuilerror(String e);
        }

        interface ResultCallBack{
            void doctorListData(ResultBean resultBean);
            void fuilerror(String e);
        }

        interface EndinquiryCallBack{
            void doctorListData(EndInquiryBean endInquiryBean);
            void fuilerror(String e);
        }


    }



    interface IPresenter{
        void doctorList( Map<String,Object> queryMap);
        void department( );
        void current( Map<String,Object> headerMap );
        void result(Map<String,Object> headerMap, int doctorId);
        void endinquiry(Map<String,Object> headerMap, int recordId);
    }
}
