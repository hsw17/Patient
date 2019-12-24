package com.bw.inquerymodel.model;

import com.bw.inquerymodel.api.IApiservcie;
import com.bw.inquerymodel.bean.DoctroinfoBean;
import com.bw.inquerymodel.contract.DoctroInfoContract;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;
import com.bwie.mvplibrary.utils.RetrofitManager;

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
    public void doctorinfo(int doctorId, DoctorinfoCallBack callback) {
        iApiservcie.doctroinfo ( doctorId ).compose ( CommonSchedulers.io2main () )
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
}
