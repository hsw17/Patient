package com.wd.he_bing.view;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bwie.mvplibrary.base.BaseActivity;

import com.wd.he_bing.R;
import com.wd.he_bing.adapter.CDepartmentlistAdapter;
import com.wd.he_bing.adapter.CListAdapter;
import com.wd.he_bing.bean.CDepartmentlistBean;
import com.wd.he_bing.bean.CListBean;
import com.wd.he_bing.contract.CHomeContract;
import com.wd.he_bing.presenter.CHomePresenter;

import java.util.List;
@Route(path = "/he_bing/activity")
public class MainBingActivity extends BaseActivity<CHomePresenter> implements CHomeContract.CHomeView {

    private RecyclerView c_main_recycler, c_main_recycler_one;
    private NestedScrollView main_nestedScrollView;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main_bing;
    }

    @Override
    protected CHomePresenter setPresenter() {
        return new CHomePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        main_nestedScrollView = findViewById(R.id.main_nestedScrollView);
        main_nestedScrollView.setSmoothScrollingEnabled(false);
        c_main_recycler = findViewById(R.id.c_main_recycler);
        c_main_recycler_one = findViewById(R.id.c_main_recycler_one);
        //查询列表
        presenter.CHomePresenterKeShiLieBiao();
        presenter.CHomePresenterBingYouQuanLieBiao("1","1","30");
    }
    @Override
    public void CHomeViewSuccess(Object obj) {
        if (obj instanceof CDepartmentlistBean) {
            //设置线性布局
            CDepartmentlistBean cDepartmentlistBean = (CDepartmentlistBean) obj;
            List<CDepartmentlistBean.ResultBean> result = cDepartmentlistBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            c_main_recycler.setLayoutManager(linearLayoutManager);
            //设置适配器
            CDepartmentlistAdapter cDepartmentlistAdapter = new CDepartmentlistAdapter(context(), result);
            c_main_recycler.setAdapter(cDepartmentlistAdapter);
            cDepartmentlistAdapter.getOnClick(new CDepartmentlistAdapter.setOnClick() {
                @Override
                public void OnClick(String id ,String position) {
                    presenter.CHomePresenterBingYouQuanLieBiao("1","1","50");
                    cDepartmentlistAdapter.notifyDataSetChanged();
                }
            });

        } else if (obj instanceof CListBean) {
            //查询病友圈列表
            //设置线性布局
            CListBean cListBean = (CListBean) obj;
            List<CListBean.ResultBean> result = cListBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context());
            c_main_recycler_one.setLayoutManager(linearLayoutManager);
            //设置适配器
            CListAdapter cListAdapter = new CListAdapter(context(), result);
            c_main_recycler_one.setAdapter(cListAdapter);
            //跳转病友圈详情
            cListAdapter.getCLick(new CListAdapter.CListClick() {
                @Override
                public void setClistClick(String id) {
                    Intent intent = new Intent(MainBingActivity.this, CPatientCircleDetailsActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            });

        }

    }

    @Override
    public void CHomeViewError(String e) {

    }
}
