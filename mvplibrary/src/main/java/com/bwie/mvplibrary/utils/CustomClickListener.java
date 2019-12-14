package com.bwie.mvplibrary.utils;

import android.view.View;

/**
 * date:2019/12/5
 * author:贺少伟(盗)
 * function:
 */
public abstract class CustomClickListener implements View.OnClickListener{
    private long mLastClickTime;
    private long timeInterval = 1000L;

    public CustomClickListener() {

    }

    public CustomClickListener(long interval) {
        this.timeInterval = interval;
    }

    @Override
    public void onClick(View v) {
        long nowTime = System.currentTimeMillis();
        if (nowTime - mLastClickTime > timeInterval) {
            // 单次点击事件
            onSingleClick();
            mLastClickTime = nowTime;
        } else {
            // 快速点击事件
            onFastClick();
        }
    }

    protected abstract void onSingleClick();
    protected abstract void onFastClick();
}
