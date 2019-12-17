package com.bw.videomodule.api;

import com.bw.videomodule.bean.VideoCategoryListBean;
import com.bw.videomodule.bean.VideolistBean;
import com.bwie.mvplibrary.base.IBaseView;

import java.util.Map;

import retrofit2.http.QueryMap;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/16
 * @Description:
 */
public interface Contract {
    interface IMainView extends IBaseView{
       void success(VideoCategoryListBean videoCategoryListBean);
       void success(VideolistBean videolistBean);
       void fuilerror(String e);
    }

    interface IModel{
        void videocategorylist(videocategorylistICallBack callBack);
        void videoList(Map<String, Object> headerMap,Map<String, Object> queryMap,videoListICallBack callBack);

        interface videocategorylistICallBack{
            void backData(VideoCategoryListBean videoCategoryListBean);
            void fuilerror(String e);
        }

        interface videoListICallBack{
            void backData(VideolistBean videolistBean);
            void fuilerror(String e);
        }
    }

    interface IPresenter{
        void videocategorylist();
        void videoList(Map<String, Object> headerMap,Map<String, Object> queryMap);

    }
}
