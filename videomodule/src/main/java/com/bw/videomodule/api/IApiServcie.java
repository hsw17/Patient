package com.bw.videomodule.api;

import com.bw.videomodule.bean.VideoCategoryListBean;
import com.bw.videomodule.bean.VideolistBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/16
 * @Description:
 */
public interface IApiServcie {

    @GET("health/user/video/v1/findVideoCategoryList")
    Observable<VideoCategoryListBean> videocategorylist();


    @GET("health/user/video/v1/findVideoVoList")
    Observable<VideolistBean> videoList(@HeaderMap Map<String, Object> headerMap, @QueryMap Map<String, Object> queryMap);
}
