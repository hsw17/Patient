package com.wd.mymainmodule.view.activity;


import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.wd.mymainmodule.R;
import com.wd.mymainmodule.modle.bean.UserBean;
import com.wd.mymainmodule.persenter.Persenter;
import com.wd.mymainmodule.rsacoder.RsaCoder;
import com.wd.mymainmodule.view.contract.IViewContract;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResetPwdActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R.id.head_text_name)
    TextView headTextName;
    @BindView(R.id.login_edit_pwd)
    EditText loginEditPwd;
    @BindView(R.id.login_image_hine)
    ToggleButton loginImageHine;
    @BindView(R.id.login_edit_pwdl)
    EditText loginEditPwdl;
    @BindView(R.id.login_image_hinel)
    ToggleButton loginImageHinel;
    @BindView(R.id.relate_view)
    RelativeLayout relateView;
    @BindView(R.id.reset_edit_next)
    Button resetEditNext;
    private SPUtils email;
    private String email1;

    @Override
    protected int bindLayout() {
        return R.layout.activity_reset_pwd;
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
//        获取邮箱
        email = new SPUtils(this, "email");
        email1 = (String) email.getSharedPreference("email", null);
//      点击事件
        resetEditNext.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                String pwd = loginEditPwd.getText().toString();
                String pwdl = loginEditPwdl.getText().toString();
                if (pwd.equals("")&&pwdl.equals("")) {
                    ToastUtils.show("密码不能为空");
                    return;
                }
                if (!pwdl.equals(pwd)){
                    ToastUtils.show("密码不一致");
                    return;
                }
                try {
                    String s = RsaCoder.encryptByPublicKey(pwdl);
                    Map<String,Object> map=new HashMap<>();
                    map.put("email",email1);
                    map.put("pwd1",s);
                    map.put("pwd2",s);
                    presenter.doUserPwd(map);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            protected void onFastClick() {

            }
        });
        //        返回
        headDetailsBack.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                finish();
            }

            @Override
            protected void onFastClick() {

            }
        });
        headTextName.setText("设置新密码");
//        默认为隐藏
        loginEditPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        loginImageHine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //显示密码
                    loginEditPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    loginImageHine.setBackgroundResource(R.mipmap.login_icon_show_password);
                } else {
                    //选中时隐藏密码
                    loginEditPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    loginImageHine.setBackgroundResource(R.mipmap.login_icon_hide_password_n);
                }
                //每次显示或者关闭时，密码显示编辑的线不统一在最后，下面是为了统一
                //设置选择
                loginEditPwd.setSelection(loginEditPwd.length());
            }
        });
        //        默认为隐藏
        loginEditPwdl.setTransformationMethod(PasswordTransformationMethod.getInstance());
        loginImageHinel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //显示密码
                    loginEditPwdl.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                    loginImageHinel.setBackgroundResource(R.mipmap.login_icon_show_password);
                } else {
                    //选中时隐藏密码
                    loginEditPwdl.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    loginImageHinel.setBackgroundResource(R.mipmap.login_icon_hide_password_n);
                }
                //每次显示或者关闭时，密码显示编辑的线不统一在最后，下面是为了统一
                //设置选择
                loginEditPwdl.setSelection(loginEditPwdl.length());
            }
        });
    }
    @Override
    public void onSuccess(Object obj) {
        UserBean userBean= (UserBean) obj;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
            String pwdl = loginEditPwdl.getText().toString();
            email.SharedPreferenceput("pwd",pwdl);
            Intent intent=new Intent(this,MainActivity.class);
            sendBroadcast(intent);
//            finish();
        }else{
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
