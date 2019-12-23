package com.wd.mymodlue.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.wd.mymainmodule.R2;
import com.wd.mymodlue.R;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecordActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(com.wd.mymodlue.R2.id.record_linear_layout)
    LinearLayout recordLinearLayout;
    @BindView(com.wd.mymodlue.R2.id.record_button_add)
    Button recordButtonAdd;

    @Override
    protected int bindLayout() {
        return R.layout.activity_record;
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
        headDetailsBack.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent=new Intent(RecordActivity.this,My_ModuleMainActivity.class);
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
