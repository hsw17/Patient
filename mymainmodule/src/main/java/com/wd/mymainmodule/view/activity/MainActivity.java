package com.wd.mymainmodule.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.Logger;
import com.bwie.mvplibrary.utils.NetUtil;
import com.bwie.mvplibrary.utils.PwdAndEmail;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.wd.mymainmodule.R;
import com.wd.mymainmodule.modle.bean.LoginBean;
import com.wd.mymainmodule.persenter.Persenter;
import com.wd.mymainmodule.rsacoder.RsaCoder;
import com.wd.mymainmodule.view.contract.IViewContract;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<Persenter> implements IViewContract.IView {

    @BindView(R.id.login_edit_email)
    EditText loginEditEmail;
    @BindView(R.id.login_image_false)
    ImageView loginImageFalse;
    @BindView(R.id.login_image_true)
    ImageView loginImageTrue;
    @BindView(R.id.login_edit_pwd)
    EditText loginEditPwd;

    @BindView(R.id.login_button_login)
    TextView loginButtonLogin;
    @BindView(R.id.relate_view)
    RelativeLayout relateView;
    @BindView(R.id.login_button_updateuserpwd)
    TextView loginButtonUpdateuserpwd;
    @BindView(R.id.login_button_register)
    LinearLayout loginButtonRegister;
    @BindView(R.id.login_button_wx)
    ImageView loginButtonWx;
    @BindView(R.id.login_image_hine)
    ToggleButton loginImageHine;
    private SPUtils login;
    private SPUtils email;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
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

        //        sp
        login = new SPUtils(this, "login");
        email = new SPUtils(this, "email");
        String email1 = (String) email.getSharedPreference("email", null);
        String pwd = (String) email.getSharedPreference("pwd", null);
        if (email1!=null){
            //        设置默认
            loginEditEmail.setText(email1);
            loginEditPwd.setText(pwd);
        }
//        注册
        loginButtonRegister.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
//                隐式跳转
                Intent intent = new Intent("com.hl.RegisterActivity");
                startActivity(intent);
            }

            @Override
            protected void onFastClick() {

            }
        });
//        登录
        loginButtonLogin.setOnClickListener(new CustomClickListener() {

            private String s;

            @Override
            protected void onSingleClick() {
//                获取输入框邮箱和密码
                String email = loginEditEmail.getText().toString().trim();
                String pwd = loginEditPwd.getText().toString().trim();
                if (email.equals("")) {
                    Toast.makeText(MainActivity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
//                进行正则判断
                PwdAndEmail pwdAndEmail = new PwdAndEmail();
//                邮箱判断
                boolean email1 = pwdAndEmail.isEmail(email);

                if (pwd.equals("")) {
                    Toast.makeText(MainActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email1 == false) {
                    Toast.makeText(MainActivity.this, "邮箱格式不正确", Toast.LENGTH_SHORT).show();
                    return;
                }
//                判断网络
                boolean networkAvailable = NetUtil.isNetworkAvailable(context());
                if (networkAvailable) {
                    try {
                        s = RsaCoder.encryptByPublicKey(pwd);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    presenter.doLogin(email, s);
                } else {
                    ToastUtils.show("无网络");
                }
            }

            @Override
            protected void onFastClick() {

            }
        });
//        密码显示隐藏设置
        initPwd();
//        忘记密码
        loginButtonUpdateuserpwd.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent=new Intent("com.hl.ResetUserPwdActivity");
                startActivity(intent);
            }

            @Override
            protected void onFastClick() {

            }
        });
    }

    private void initPwd() {
//        默认为隐藏
        loginEditPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        loginImageHine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //显示密码
                    loginEditPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    loginImageFalse.setVisibility(View.GONE);
                    loginImageTrue.setVisibility(View.VISIBLE);
                    loginImageHine.setBackgroundResource(R.mipmap.login_icon_show_password);
                } else {
                    //选中时隐藏密码
                    loginEditPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    loginImageFalse.setVisibility(View.VISIBLE);
                    loginImageTrue.setVisibility(View.GONE);
                    loginImageHine.setBackgroundResource(R.mipmap.login_icon_hide_password_n);
                }
                //每次显示或者关闭时，密码显示编辑的线不统一在最后，下面是为了统一
                //设置选择
                loginEditPwd.setSelection(loginEditPwd.length());
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    public void onSuccess(Object obj) {
//        登录
        LoginBean loginBean = (LoginBean) obj;
        Logger.e("login", loginBean.message);
        if ("0000".equals(loginBean.status)) {
            ToastUtils.show(loginBean.message);
//            存储
            login.SharedPreferenceput("loginBean", loginBean);
            String email = loginEditEmail.getText().toString();
            String pwd = loginEditPwd.getText().toString();
            this.email.SharedPreferenceput("email",email);
            this.email.SharedPreferenceput("pwd",pwd);
//             跳转路径
            finish();
        } else {
            ToastUtils.show(loginBean.message);

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
