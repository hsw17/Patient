package com.bw.inquerymodel.contract;

import com.bw.inquerymodel.bean.DepartmentBean;
import com.bw.inquerymodel.bean.DoctorListBean;
import com.bw.inquerymodel.bean.DoctroinfoBean;
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
        void fuilerror(String e);
    }

    interface IModel{
        void doctorinfo(int doctorId,DoctorinfoCallBack callback);

        interface DoctorinfoCallBack{
            void backData(DoctroinfoBean doctroinfoBean);
            void fuilerror(String e);
        }
    }



    interface IPresenter{
        void doctorinfo(int doctorId);
    }
}
