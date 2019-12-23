package com.wd.mymodlue.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.google.android.material.tabs.TabLayout;
import com.wd.mymainmodule.R2;
import com.wd.mymodlue.R;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(com.wd.mymodlue.R2.id.tab_layout)
    TabLayout tabLayout;
    @BindView(com.wd.mymodlue.R2.id.view_pager)
    ViewPager viewPager;

    @Override
    protected int bindLayout() {
        return R.layout.activity_collect;
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
                Intent intent = new Intent(CollectActivity.this, My_ModuleMainActivity.class);
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
