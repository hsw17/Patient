package com.wd.mymainmodule.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.PwdAndEmail;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.wd.mymainmodule.R;
import com.wd.mymainmodule.modle.bean.UserBean;
import com.wd.mymainmodule.persenter.Persenter;
import com.wd.mymainmodule.view.contract.IViewContract;
import com.wd.mymainmodule.view.zview.HeadBackView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResetUserPwdActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R.id.reset_edit_email)
    EditText resetEditEmail;
    @BindView(R.id.reset_text_code)
    TextView resetTextCode;
    @BindView(R.id.reset_edit_code)
    EditText resetEditCode;
    @BindView(R.id.relate_view)
    RelativeLayout relateView;
    @BindView(R.id.reset_edit_next)
    Button resetEditNext;
    @BindView(R.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R.id.head_text_name)
    TextView headTextName;
    private SPUtils email;

    @Override
    protected int bindLayout() {
        return R.layout.activity_reset_user_pwd;
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
        String email1 = (String) email.getSharedPreference("email", null);
        if (email1!=null){
            //        设置默认
            resetEditEmail.setText(email1);

        }
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
        headTextName.setText("忘记密码");
        //      发送验证码
        resetTextCode.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                String email = resetEditEmail.getText().toString();
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

    }

    @Override
    public void onSuccess(Object obj) {

    }

    @Override
    public void onSuccessOne(Object one) {
        UserBean userBean= (UserBean) one;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
            resetEditNext.setOnClickListener(new CustomClickListener() {
                @Override
                protected void onSingleClick() {
//                判断验证码
                    if ("0000".equals(userBean.status)) {
                        String s = resetEditCode.getText().toString();
                        if (!s.equals("")){
                            String emai = resetEditEmail.getText().toString();
                            Intent intent=new Intent("com.hl.ResetPwdActivity");
                            startActivity(intent);
                            email.SharedPreferenceput("email",emai);
                        }else {
                            ToastUtils.show("请输入验证码");
                        }
                    }else{
                        ToastUtils.show("验证码输入失败");
                    }
                }

                @Override
                protected void onFastClick() {

                }
            });
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
