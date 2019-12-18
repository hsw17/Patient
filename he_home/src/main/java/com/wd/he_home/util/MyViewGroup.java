package com.wd.he_home.util;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 *@describe(描述)：MyViewGroup  自定义View流式布局
 *@data（日期）: 2019/12/17
 *@time（时间）: 15:01
 *@author（作者）: Liuhe
 **/
public class MyViewGroup extends ViewGroup {
    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        //获取宽度
        int width = getWidth();
        //定义常量
        int low =0;
        //定义行间距
        int diswith =38;
        //循环查询子布局
        for (int j = 0; j < getChildCount(); j++) {
            View childAt = getChildAt(j);
            //获取宽高
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredWidth = childAt.getMeasuredWidth();
            //判断
            if (diswith+measuredWidth>width){
                low++;
                diswith=18;
            }
            childAt.layout(diswith,low*measuredHeight,diswith+width,measuredHeight*(low+1));
            diswith+=measuredWidth;
        }

    }
}
