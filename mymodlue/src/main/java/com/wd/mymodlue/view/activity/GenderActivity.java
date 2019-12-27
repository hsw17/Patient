package com.wd.mymodlue.view.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;

import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GenderActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    int sex;
    @BindView(R2.id.fanhui)
    ImageView fanhui;
    @BindView(R2.id.name_button_finish)
    Button nameButtonFinish;
    @BindView(R2.id.boy01)
    CheckBox boy01;
    @BindView(R2.id.boy_check01)
    ImageView boyCheck01;
    @BindView(R2.id.gilr01)
    CheckBox gilr01;
    @BindView(R2.id.boy_check02)
    ImageView boyCheck02;
    private SPUtils login;


    @Override
    protected int bindLayout() {
        return R.layout.activity_gender;
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
        ToastUtils.init(this);
//        获取存储内容
        login = new SPUtils(this, "login");
        int id = (int) login.getSharedPreference("id", 0);
        String sessionId = (String) login.getSharedPreference("sessionId", "");
        Map<String, Object> map = new HashMap<>();
        map.put("userId", id);
        map.put("sessionId", sessionId);
        boy01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    sex=1;
                    boyCheck01.setVisibility(View.VISIBLE);
                    boyCheck02.setVisibility(View.GONE);
                }else {
                    boyCheck01.setVisibility(View.GONE);
                }
            }
        });
        gilr01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    sex=2;
                    boyCheck02.setVisibility(View.VISIBLE);
                    boyCheck01.setVisibility(View.GONE);
                }else {
                    boyCheck02.setVisibility(View.GONE);
                }
            }
        });

//        返回
        fanhui.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent=new Intent("com.hl.MessageActivity");
                startActivity(intent);
                finish();

            }

            @Override
            protected void onFastClick() {

            }
        });
//        进行选择
        nameButtonFinish.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                if (sex==0) {
                    ToastUtils.show("请选择性别");
                    return;
                }
                presenter.onUpdateUserSex(map,sex);
            }

            @Override
            protected void onFastClick() {

            }
        });
    }

    @Override
    public void onSuccess(Object obj) {
        UserBean userBean = (UserBean) obj;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
            login.SharedPreferenceput("sex", sex);
            Intent intent=new Intent("com.hl.MessageActivity");
            startActivity(intent);
            finish();
        } else {
            ToastUtils.show(userBean.message);

        }
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
