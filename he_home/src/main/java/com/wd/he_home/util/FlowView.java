package com.wd.he_home.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 *@describe(描述)：FlowView  刘贺
 *@data（日期）: 2019/12/17
 *@time（时间）: 20:22
 *@author（作者）: Liuhe
 **/
public class FlowView extends ViewGroup {

    public FlowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int top = 10;
        for (int i = 0; i <getChildCount() ; i++) {
            View view = getChildAt(i);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            view.layout(0,top,measuredWidth,top+measuredHeight);
            top +=measuredHeight;
        }
    }
}
