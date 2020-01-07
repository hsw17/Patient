package com.wd.he_bing.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;
import com.bwie.mvplibrary.base.BaseActivity;
import com.wd.he_bing.R;
import com.wd.he_bing.adapter.CDepartmentlistAdapter;
import com.wd.he_bing.adapter.CListAdapter;
import com.wd.he_bing.bean.CDepartmentlistBean;
import com.wd.he_bing.bean.CListBean;
import com.wd.he_bing.bean.LoginBean;
import com.wd.he_bing.contract.CHomeContract;
import com.wd.he_bing.presenter.CHomePresenter;

import java.util.List;

public class MainActivity extends BaseActivity<CHomePresenter> implements CHomeContract.CHomeView {

    private RecyclerView c_main_recycler, c_main_recycler_one;
    private NestedScrollView main_nestedScrollView;
    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected CHomePresenter setPresenter() {
        return new CHomePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        //设置在activity启动的时候输入法默认是不开启的
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        main_nestedScrollView = findViewById(R.id.main_nestedScrollView);
        main_nestedScrollView.setSmoothScrollingEnabled(false);
        c_main_recycler = findViewById(R.id.c_main_recycler);
        c_main_recycler_one = findViewById(R.id.c_main_recycler_one);
        //查询列表
        presenter.CHomePresenterKeShiLieBiao();
        presenter.CHomePresenterBingYouQuanLieBiao("7", "1", "30");
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
                public void OnClick(String id, String position) {
                    presenter.CHomePresenterBingYouQuanLieBiao(id, "1", "30");
                    cDepartmentlistAdapter.setmPosition(id);
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
                    Intent intent = new Intent(MainActivity.this, CPatientCircleDetailsActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            });
        }else if (obj instanceof LoginBean){
            LoginBean loginBean = (LoginBean) obj;
            LoginBean.ResultBean result = loginBean.getResult();
            SharedPreferences login = getSharedPreferences("login", MODE_PRIVATE);
            SharedPreferences.Editor edit = login.edit();
            edit.putString("zhang",result.getId());
            edit.putString("mi",result.getSessionId());
            edit.commit();
        }
    }
    @Override
    public void CHomeViewError(String e) {

    }
}
