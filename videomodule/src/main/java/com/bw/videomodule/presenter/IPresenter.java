package com.bw.videomodule.presenter;

import com.bw.videomodule.api.Contract;
import com.bw.videomodule.bean.VideoCategoryListBean;
import com.bw.videomodule.bean.VideolistBean;
import com.bw.videomodule.model.IModel;
import com.bwie.mvplibrary.base.BasePresenter;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/16
 * @Description:
 */
public class IPresenter extends BasePresenter<Contract.IMainView> implements Contract.IPresenter {

    private IModel iModel;

    @Override
    public void videocategorylist() {
        iModel.videocategorylist ( new Contract.IModel.videocategorylistICallBack () {
            @Override
            public void backData(VideoCategoryListBean videoCategoryListBean) {
                getView ().success ( videoCategoryListBean );
            }

            @Override
            public void fuilerror(String e) {
                getView ().fuilerror ( e );
            }
        } );
    }

    @Override
    public void videoList(Map<String, Object> headerMap, Map<String, Object> queryMap) {
        iModel.videoList ( headerMap, queryMap, new Contract.IModel.videoListICallBack () {
            @Override
            public void backData(VideolistBean videolistBean) {
                getView ().success ( videolistBean );
            }

            @Override
            public void fuilerror(String e) {
                getView ().fuilerror ( e );
            }
        } );
    }

    @Override
    protected void initModel() {
        iModel = new IModel ();
    }
}
