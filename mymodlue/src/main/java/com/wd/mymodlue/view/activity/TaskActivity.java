package com.wd.mymodlue.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bwie.mvplibrary.base.BaseActivity;
import com.wd.mymodlue.R;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

public class TaskActivity extends BaseActivity<Persenter> implements IViewContract.IView {

    @Override
    protected int bindLayout() {
        return R.layout.activity_task;
    }

    @Override
    protected Persenter setPresenter() {
        return new Persenter();
    }

    @Override
    public void onSuccess(Object obj) {

    }

    @Override
    public void onSuccessOne(Object one) {

    }

    @Override
    public void onSuccessTwo(Object two) {

    }

    @Override
    public void onSuccessThree(Object three) {

    }

    @Override
    public void onSuccessFour(Object four) {

    }

    @Override
    public void onFail(String str) {

    }
}
