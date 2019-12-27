package com.wd.he_home.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.mvplibrary.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.common.eventbus.EventBus;
import com.wd.he_home.MyAdapter;
import com.wd.he_home.R;
import com.wd.he_home.adapter.CommonDrugsAdapter;
import com.wd.he_home.adapter.ConsultationAdapter;
import com.wd.he_home.adapter.DateList_Adapter;
import com.wd.he_home.bean.DoctorlistBean;
import com.wd.he_home.bean.EnquirySectionBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.fragment.Info_Fragment;
import com.wd.he_home.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;



public class ConsultationActivity extends BaseActivity<HomePresenter> implements HomeContract.HomeView {
    private static final String TAG = "SickFrag";
    private TabLayout tablayout;
    private ViewPager view_pager;
    private String departmentId;
    int page2 = 1;
    private List<Integer> list_id = new ArrayList<>();
    private EnquirySectionBean enquirySectionBean;
    private List<EnquirySectionBean.ResultBean> result = new ArrayList<>();
    private List<String> list;
    private DateList_Adapter dateList_adapter;
    @Override
    protected int bindLayout() {
        return R.layout.activity_consultation;
    }
    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        super.initView();
        tablayout = findViewById(R.id.tablayout);
        view_pager = findViewById(R.id.vp);
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.HomePresenterChaXunKeShi();
       // presenter.HomePresenterYiShengLieBiao(departmentId, "1", "0", page2, "4");
    }

    @Override
    public void HomeViewSuccess(Object obj) {
        if (obj instanceof EnquirySectionBean) {
            //设置线性管理器
            enquirySectionBean = (EnquirySectionBean) obj;
            result = enquirySectionBean.getResult();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < result.size(); i++) {
                list.add(result.get(i).getDepartmentName());
            }
            tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            tablayout.setupWithViewPager(view_pager);
            dateList_adapter = new DateList_Adapter(getSupportFragmentManager(), list);
            view_pager.setAdapter(dateList_adapter);
        }
    }

    @Override
    public void HomeViewError(String e) {
    }
}
