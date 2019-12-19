package com.wd.mymainmodule.view.activity;

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
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.PwdAndEmail;
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

public class RegisterActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R.id.register_edit_email)
    EditText registerEditEmail;
    @BindView(R.id.register_edit_code)
    EditText registerEditCode;
    @BindView(R.id.register_edit_false)
    ImageView registerEditFalse;
    @BindView(R.id.register_edit_true)
    ImageView registerEditTrue;
    @BindView(R.id.register_edit_pwd)
    EditText registerEditPwd;
    @BindView(R.id.register_edit_hine)
    ToggleButton registerEditHine;
    @BindView(R.id.register_edit_false1)
    ImageView registerEditFalse1;
    @BindView(R.id.register_edit_true1)
    ImageView registerEditTrue1;
    @BindView(R.id.register_edit_pwdl)
    EditText registerEditPwdl;
    @BindView(R.id.register_edit_hine1)
    ToggleButton registerEditHine1;
    @BindView(R.id.register_edit_invitationCode)
    EditText registerEditInvitationCode;
    @BindView(R.id.register_edit_xuan)
    TextView registerEditXuan;
    @BindView(R.id.register_edit_register)
    Button registerEditRegister;
    @BindView(R.id.relate_view)
    RelativeLayout relateView;
    @BindView(R.id.register_button_code)
    Button registerButtonCode;
    private SPUtils login;
    private String password;

    @Override
    protected int bindLayout() {
        return R.layout.activity_register;
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
        login = new SPUtils(this, "email");
//      发送验证码
        registerButtonCode.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                String email = registerEditEmail.getText().toString();
                if (email.equals("")){
                    ToastUtils.show("请输入验证码");
                    return;
                }
                PwdAndEmail pwdAndEmail = new PwdAndEmail();
//                邮箱判断
                boolean email1 = pwdAndEmail.isEmail(email);
                if (email1 == false) {
                    ToastUtils.show("邮箱格式错误");
                    return;
                }
                presenter.doEmailCode(email);
            }

            @Override
            protected void onFastClick() {

            }
        });

        registerEditRegister.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                String email = registerEditEmail.getText().toString().trim();
                String code = registerEditCode.getText().toString().trim();
                String pwd = registerEditPwd.getText().toString().trim();
                String pwdl = registerEditPwdl.getText().toString().trim();
                String InvitationCode = registerEditInvitationCode.getText().toString().trim();
                if (email.equals("")) {
                    ToastUtils.show("邮箱不能为空");
                    return;
                }
                PwdAndEmail pwdAndEmail = new PwdAndEmail();
//                邮箱判断
                boolean email1 = pwdAndEmail.isEmail(email);
                if (email1 == false) {
                    ToastUtils.show("邮箱格式错误");
                    return;
                }

                if (code.equals("")) {
                    ToastUtils.show("验证码不能为空");
                    return;
                }
                if (pwd.equals("")) {
                    ToastUtils.show("密码不能为空");
                    return;
                }
                if (!pwdl.equals(pwd)){
                    ToastUtils.show("密码不一致");
                    return;
                }
                if (pwdl.equals("")) {
                    ToastUtils.show("确认密码不能为空");
                    return;
                }

                try {
                    password = RsaCoder.encryptByPublicKey(pwdl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Map<String,Object> map=new HashMap<>();
                map.put("email",email);
                map.put("code",code);
                map.put("pwd1",password);
                map.put("pwd2",password);
                if (InvitationCode==""){
                    map.put("invitationCode",null);
                }else{
                    map.put("invitationCode",InvitationCode);
                }
                presenter.doRegister(map);
            }

            @Override
            protected void onFastClick() {

            }
        });
        registerEditXuan.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {

            }

            @Override
            protected void onFastClick() {

            }
        });
        initRegula();
    }


    private void initRegula() {
//        默认为隐藏
        registerEditPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        registerEditHine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //显示密码
                    registerEditPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    registerEditFalse.setVisibility(View.GONE);
                    registerEditTrue.setVisibility(View.VISIBLE);
                    registerEditHine.setBackgroundResource(R.mipmap.login_icon_show_password);
                } else {
                    //选中时隐藏密码
                    registerEditPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    registerEditFalse.setVisibility(View.VISIBLE);
                    registerEditTrue.setVisibility(View.GONE);
                    registerEditHine.setBackgroundResource(R.mipmap.login_icon_hide_password_n);
                }
                //每次显示或者关闭时，密码显示编辑的线不统一在最后，下面是为了统一
                //设置选择
                registerEditPwd.setSelection(registerEditPwd.length());
            }
        });
        //        默认为隐藏
        registerEditPwdl.setTransformationMethod(PasswordTransformationMethod.getInstance());
        registerEditHine1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //显示密码
                    registerEditPwdl.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    registerEditFalse1.setVisibility(View.GONE);
                    registerEditTrue1.setVisibility(View.VISIBLE);
                    registerEditHine1.setBackgroundResource(R.mipmap.login_icon_show_password);
                } else {
                    //选中时隐藏密码
                    registerEditPwdl.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    registerEditFalse1.setVisibility(View.VISIBLE);
                    registerEditTrue1.setVisibility(View.GONE);
                    registerEditHine1.setBackgroundResource(R.mipmap.login_icon_hide_password_n);
                }
                //每次显示或者关闭时，密码显示编辑的线不统一在最后，下面是为了统一
                //设置选择
                registerEditPwdl.setSelection(registerEditPwdl.length());
            }
        });

    }




    @Override
    public void onSuccess(Object obj) {
        UserBean userBean= (UserBean) obj;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
            String email = registerEditEmail.getText().toString().trim();
            String pwd = registerEditPwdl.getText().toString().trim();
            login.SharedPreferenceput("email",email);
            login.SharedPreferenceput("pwd",pwd);
            finish();
        }else{
            ToastUtils.show(userBean.message);
        }

    }

    @Override
    public void onSuccessOne(Object one) {
        UserBean userBean= (UserBean) one;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
        }else{
            ToastUtils.show(userBean.message);
        }
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
