package com.wd.mymodlue.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PatientsCircleActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R2.id.fanhui)
    ImageView fanhui;

    @Override
    protected int bindLayout() {
        return R.layout.activity_patients_circle;
    }

    @Override
    protected Persenter setPresenter() {
        return new Persenter();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);


//        返回
        fanhui.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent = new Intent(PatientsCircleActivity.this,My_ModuleMainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            protected void onFastClick() {

            }
        });
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
