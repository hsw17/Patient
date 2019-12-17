package com.wd.he_home.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.wd.he_home.R;
import com.wd.he_home.bean.DrugDetailsBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @describe(描述)：DrugDetailsActivity 药品详情
 * @data（日期）: 2019/12/16
 * @time（时间）: 20:33
 * @author（作者）: Liuhe
 **/
public class DrugDetailsActivity extends BaseActivity<HomePresenter> implements HomeContract.HomeView {



    private DrugDetailsBean.ResultBean result;
    private String id;
    private String name;
private TextView drugsName, drugsComponent,drugsTaboo,drugsEffect,drugsUsage,drugsShape;
    @Override
    protected int bindLayout() {
        return R.layout.activity_drug_details;
    }

    @Override
    protected void initView() {
        super.initView();
        drugsName = findViewById(R.id.drugs_name);
        drugsComponent = findViewById(R.id.drugs_component);
        drugsTaboo = findViewById(R.id.drugs_taboo);
        drugsEffect = findViewById(R.id.drugs_effect);
        drugsUsage = findViewById(R.id.drugs_usage);
        drugsShape = findViewById(R.id.drugs_shape);
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("name");
        drugsName.setText(name);
        presenter.HomePresenterYaoPinXiangQing(id);
    }

    @Override
    public void HomeViewSuccess(Object obj) {
        if (obj instanceof DrugDetailsBean){
            DrugDetailsBean drugDetailsBean = (DrugDetailsBean) obj;
            result = drugDetailsBean.getResult();
            drugsComponent.setText(result.getComponent());
            drugsTaboo.setText(result.getTaboo());
            drugsEffect.setText(result.getEffect());
            drugsShape.setText(result.getShape());
            drugsUsage.setText(result.getUsage());

        }

    }

    @Override
    public void HomeViewError(String e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
