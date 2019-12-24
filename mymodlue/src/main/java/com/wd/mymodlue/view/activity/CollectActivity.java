package com.wd.mymodlue.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.google.android.material.tabs.TabLayout;
import com.wd.mymainmodule.R2;
import com.wd.mymodlue.R;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.adapter.FragAdapter;
import com.wd.mymodlue.view.contract.IViewContract;
import com.wd.mymodlue.view.fragment.CircleFragment;
import com.wd.mymodlue.view.fragment.ConsultFragment;
import com.wd.mymodlue.view.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
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
    List<Fragment> list=new ArrayList<>();
    List<String> slist=new ArrayList<>();
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

        list.add(new ConsultFragment());
        list.add(new VideoFragment());
        list.add(new CircleFragment());
        slist.add("健康咨询");
        slist.add("健康视频");
        slist.add("病友圈");
        for (int i = 0; i < slist.size(); i++) {
            String title = slist.get(i);
            TabLayout.Tab tab = tabLayout.newTab();
            if (tab != null) {
                tab.setText(title);
                tabLayout.addTab(tab);
            }
        }
        tabLayout.setupWithViewPager(viewPager);
        FragAdapter fragAdapter = new FragAdapter(getSupportFragmentManager(), list, slist);
        fragAdapter.notifyDataSetChanged();
        viewPager.setAdapter(fragAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                View customView = tab.getCustomView();

                if (null!=customView&& customView instanceof TextView){
                    ((TextView)customView).setTextSize(26);
                    ((TextView)customView).setTextColor(Color.BLUE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (null!=customView&& customView instanceof TextView){
                    ((TextView)customView).setTextColor(Color.BLUE);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

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
