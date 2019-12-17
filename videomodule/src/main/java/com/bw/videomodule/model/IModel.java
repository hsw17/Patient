package com.bw.videomodule.model;

import com.bw.videomodule.api.Contract;
import com.bw.videomodule.api.IApiServcie;
import com.bw.videomodule.bean.VideoCategoryListBean;
import com.bw.videomodule.bean.VideolistBean;
import com.bw.videomodule.utils.RetrofitUtils;
import com.bwie.mvplibrary.utils.CommonObserver;
import com.bwie.mvplibrary.utils.CommonSchedulers;

import java.util.Map;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/16
 * @Description:
 */
public class IModel implements Contract.IModel {

    private final IApiServcie iApiServcie;

    public IModel() {
        iApiServcie = RetrofitUtils.getInstance ().create ( IApiServcie.class );
    }

    @Override
    public void videocategorylist(videocategorylistICallBack callBack) {
         iApiServcie.videocategorylist ().compose ( CommonSchedulers.io2main () )
                 .subscribe ( new CommonObserver<VideoCategoryListBean> () {
                     @Override
                     public void onNext(VideoCategoryListBean videoCategoryListBean) {
                         callBack.backData ( videoCategoryListBean );
                     }

                     @Override
                     public void onError(Throwable e) {
                         callBack.fuilerror ( e.getMessage () );
                     }
                 } );
    }

    @Override
    public void videoList(Map<String, Object> headerMap, Map<String, Object> queryMap, videoListICallBack callBack) {
          iApiServcie.videoList ( headerMap,queryMap ).compose ( CommonSchedulers.io2main () )
                  .subscribe ( new CommonObserver<VideolistBean> () {
                      @Override
                      public void onNext(VideolistBean videolistBean) {
                          callBack.backData ( videolistBean );
                      }

                      @Override
                      public void onError(Throwable e) {
                          callBack.fuilerror ( e.getMessage () );
                      }
                  } );
    }
}
