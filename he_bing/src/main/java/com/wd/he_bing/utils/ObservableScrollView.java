package com.wd.he_bing.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * date:2019/12/17
 * ScrollView有方法监听用户的滑动,但是无法在外界调用
 * function:扩展式自定义View,在ScrollView的基础上添加新的功能
 * 1.类继承继承控件,实现三个方法覆写
 * 2.自定义一个ScrollView滑动监听的接口
 * 3.覆写ScrollView自带的滑动监听(注意这个监听方法,你在外界调用不到,所以我们才要写接口暴露出去)
 * 4.提供方法,让外界可以设置ScrollView的滑动监听
 * 5.使用OBservablerScroollbIew自定义控件即可
 *
 * 做一个自定义控件的基本思路
 * 1.通过效果分析这个自定义控件属于什么类型
 * 2.如果是继承式自定义控件,那么我们就要判断这个效果是基于android哪个原生控件
 */
public class ObservableScrollView extends ScrollView {

    //在Java代码时候回调
    public ObservableScrollView(Context context) {
        this(context,null);
    }

    //在XML里面回调
    public ObservableScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    //在XML设置样式的时候回掉
    public ObservableScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //ScollView自带的一个滑动监听方法,新的X,Y坐标,和旧的X,Y坐标
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        //ScrollView暴露一个接口
        if (mScrollViewListener !=null){
            mScrollViewListener.onScrollChanged(this,l,t,oldl,oldt);
        }
    }

    //定义一个接口
    public interface ScrollViewListener{
        void onScrollChanged(ObservableScrollView scrollView, int l, int t, int oldl, int oldt);
    }

    //自己的监听对象
    private ScrollViewListener mScrollViewListener;

    //提供一个方法,去让外界设置ScrollViewListener监听对象
    public void setScrollViewListener ( ScrollViewListener scrollViewListener){
        mScrollViewListener =scrollViewListener;
    }

}
