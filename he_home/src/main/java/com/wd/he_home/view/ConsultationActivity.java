package com.wd.he_home.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bwie.mvplibrary.base.BaseActivity;
import com.wd.he_home.R;
import com.wd.he_home.adapter.CommonDrugsAdapter;
import com.wd.he_home.adapter.ConsultationAdapter;
import com.wd.he_home.bean.EnquirySectionBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.presenter.HomePresenter;

import java.util.List;

public class ConsultationActivity extends BaseActivity<HomePresenter> implements HomeContract.HomeView {


    private RecyclerView consul_recycler;

    @Override
    protected int bindLayout() {
        return R.layout.activity_consultation;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.HomePresenterChaXunKeShi();
    }

    @Override
    protected void initView() {
        super.initView();
        consul_recycler = findViewById(R.id.consul_recycler);
    }

    @Override
    public void HomeViewSuccess(Object obj) {
        if (obj instanceof EnquirySectionBean) {
            //设置线性管理器
            EnquirySectionBean enquirySectionBean = (EnquirySectionBean) obj;
            List<EnquirySectionBean.ResultBean> result = enquirySectionBean.getResult();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            consul_recycler.setLayoutManager(linearLayoutManager);
            //设置适配器
            ConsultationAdapter consultationAdapter = new ConsultationAdapter(context(), result);
            consul_recycler.setAdapter(consultationAdapter);
        }
    }

    @Override
    public void HomeViewError(String e) {

    }
}
