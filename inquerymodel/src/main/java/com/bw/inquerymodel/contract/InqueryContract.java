package com.bw.inquerymodel.contract;

import com.bw.inquerymodel.bean.CurrentBean;
import com.bw.inquerymodel.bean.DoctroinfoBean;
import com.bw.inquerymodel.bean.EndInquiryBean;
import com.bw.inquerymodel.bean.RecordListBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.HeaderMap;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/24
 * @Description:
 */
public interface InqueryContract {
    interface IMainView extends IBaseView {
        void success(EndInquiryBean endInquiryBean);
        void success(CurrentBean currentBean);
        void success(RecordListBean recordListBean);
        void fuilerror(String e);
    }

    interface IModel{
        void doctorinfo(Map<String,Object> headerMap,Map<String,Object> queryMap, DoctorinfoCallBack callback);
        void current( Map<String,Object> headerMap,CurrentCallBack callBack );
        void recordlist( Map<String,Object> headerMap,Map<String,Object> queryMap,RecordListCallBack callBack );

        interface DoctorinfoCallBack{
            void backData(EndInquiryBean endInquiryBean);
            void fuilerror(String e);
        }

        interface CurrentCallBack{
            void doctorListData(CurrentBean currentBean);
            void fuilerror(String e);
        }

        interface RecordListCallBack{
            void recordListData(RecordListBean recordListBean);
            void fuilerror(String e);
        }
    }



    interface IPresenter{
        void doctorinfo(Map<String,Object> headerMap,Map<String,Object> queryMap);
        void current( Map<String,Object> headerMap );
        void recordlist( Map<String,Object> headerMap,Map<String,Object> queryMap );
    }
}
