package com.wd.he_home.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.wd.he_home.R;
import com.wd.he_home.bean.ConditionDetailsBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @describe(描述)：ConditionDetailsActivity 病状详情展示列表
 * @data（日期）: 2019/12/16
 * @time（时间）: 19:47
 * @author（作者）: Liuhe
 **/
public class ConditionDetailsActivity extends BaseActivity<HomePresenter> implements HomeContract.HomeView {


    private Intent intent;
    private String id;
    private ConditionDetailsBean.ResultBean result;
    private TextView diseaseName, diseasePathology, diseaseSymptom, diseaseBenefitTaboo, diseaseWesternMedicineTreatment, diseaseChineseMedicineTreatment;
    private String name;

    @Override
    protected int bindLayout() {
        return R.layout.activity_condition_details;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        super.initView();
        diseaseName = findViewById(R.id.disease_name);
        diseasePathology = findViewById(R.id.disease_pathology);
        diseaseSymptom = findViewById(R.id.disease_symptom);
        diseaseBenefitTaboo = findViewById(R.id.disease_benefitTaboo);
        diseaseWesternMedicineTreatment = findViewById(R.id.disease_westernMedicineTreatment);
        diseaseChineseMedicineTreatment = findViewById(R.id.disease_chineseMedicineTreatment);
    }

    @Override
    protected void initData() {
        super.initData();
        intent = getIntent();
        id = intent.getStringExtra("id_one");
        name = intent.getStringExtra("name");
        diseaseName.setText(name);
        presenter.HomePresenterBingZhuangXiangQing(id);


    }

    @Override
    public void HomeViewSuccess(Object obj) {
        if (obj instanceof ConditionDetailsBean) {
            ConditionDetailsBean conditionDetailsBean = (ConditionDetailsBean) obj;
            result = conditionDetailsBean.getResult();
            diseasePathology.setText(result.getPathology());
            diseaseSymptom.setText(result.getSymptom());
            diseaseBenefitTaboo.setText(result.getBenefitTaboo());
            diseaseChineseMedicineTreatment.setText(result.getChineseMedicineTreatment());
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
