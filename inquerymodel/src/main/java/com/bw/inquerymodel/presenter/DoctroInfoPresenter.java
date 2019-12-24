package com.bw.inquerymodel.presenter;

import com.bw.inquerymodel.bean.DoctroinfoBean;
import com.bw.inquerymodel.contract.DoctroInfoContract;
import com.bw.inquerymodel.model.DocTorInfoModel;
import com.bwie.mvplibrary.base.BasePresenter;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/21
 * @Description:
 */
public class DoctroInfoPresenter extends BasePresenter<DoctroInfoContract.IMainView> implements DoctroInfoContract.IPresenter {

    private DocTorInfoModel docTorInfoModel;

    @Override
    public void doctorinfo(int doctorId) {
        docTorInfoModel.doctorinfo ( doctorId, new DoctroInfoContract.IModel.DoctorinfoCallBack () {
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
    protected void initModel() {
        docTorInfoModel = new DocTorInfoModel ();
    }
}
