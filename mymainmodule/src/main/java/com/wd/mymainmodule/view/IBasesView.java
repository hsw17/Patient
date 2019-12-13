package com.wd.mymainmodule.view;

/**
 * date:2019/9/27
 * author:贺少伟(盗)
 * function: 抽取base类的接口回调
 */
public interface IBasesView {
//    成功
    void onLogCurress(Object obj);

    void onShapeCurress(Object obj);

    void onMyCurress(Object obj);
//    Banner轮播图
    void onBannerCurress(Object obj);
    void onMovieCinema(Object obj);

//    失败
    void onLogExurr(String str);
}
