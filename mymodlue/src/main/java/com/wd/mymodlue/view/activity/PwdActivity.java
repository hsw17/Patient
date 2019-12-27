package com.wd.mymodlue.view.activity;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.rsacoder.RsaCoder;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PwdActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R2.id.edit_old_password)
    EditText editOldPassword;
    @BindView(R2.id.edit_new_password)
    EditText editNewPassword;
    @BindView(R2.id.edit_again_new_password)
    EditText editAgainNewPassword;
    @BindView(R2.id.but_affirm)
    Button butAffirm;
    private Map<String, Object> map;

    @Override
    protected int bindLayout() {
        return R.layout.activity_pwd;
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
        SPUtils login = new SPUtils(this, "login");
        int id = (int) login.getSharedPreference("id", 0);
        String sessionId = (String) login.getSharedPreference("sessionId", "");
        map = new HashMap<>();
        map.put("userId", id);
        map.put("sessionId", sessionId);

        butAffirm.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {

//                获取旧密码密码
                String oldpwd = editOldPassword.getText().toString();


//                新密码
                String newpwd = editNewPassword.getText().toString();
                String Againpwd = editAgainNewPassword.getText().toString();
                if (newpwd.equals("")&&Againpwd.equals("")&&oldpwd.equals("")) {
                    ToastUtils.show("密码不能为空");
                    return;
                }
                if (!newpwd.equals(Againpwd)){
                    ToastUtils.show("密码不一致");
                    return;
                }
                try {
                    String s = RsaCoder.encryptByPublicKey(Againpwd);
                    String s1 = RsaCoder.encryptByPublicKey(oldpwd);
                    Map<String,String> oap=new HashMap<>();

                    oap.put("oldPwd",s1);
                    oap.put("newPwd",s);
                    presenter.onUpdateUserPwd(map,oap);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void onFastClick() {

            }
        });
//      返回
        headDetailsBack.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                finish();
            }

            @Override
            protected void onFastClick() {

            }
        });
    }

    @Override
    public void onSuccess(Object obj) {
        UserBean userBean= (UserBean) obj;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
            finish();
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
