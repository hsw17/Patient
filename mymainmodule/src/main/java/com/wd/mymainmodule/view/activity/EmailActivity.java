package com.wd.mymainmodule.view.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
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
@Route(path = "/mymainmodule/emailctivity")
public class EmailActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    private TextView head_text_name;
    private EditText head_edit_text;
    private Button button_finish;
    private SPUtils login;
    private int id;
    private String sessionId;
    private String email;

    @Override
    protected int bindLayout() {
        return R.layout.activity_email;
    }

    @Override
    protected Persenter setPresenter() {
        return new Persenter();
    }

    @Override
    protected void initView() {
        super.initView();
        head_text_name=findViewById(R.id.head_text_name);
        head_edit_text=findViewById(R.id.head_edit_text);
        button_finish=findViewById(R.id.button_finish);
        ToastUtils.init(this);
        //        获取存储内容
        login = new SPUtils(this, "login");
        id = (int) login.getSharedPreference("id", 0);
        sessionId = (String) login.getSharedPreference("sessionId", "");
        button_finish.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                email = head_edit_text.getText().toString();
                //                邮箱判断
                PwdAndEmail pwdAndEmail = new PwdAndEmail();
                boolean email1 = pwdAndEmail.isEmail(email);
                if (email1 == false) {
                    ToastUtils.show("邮箱格式错误");
                    return;
                }
                Map<String,Object> oap=new HashMap<>();
                oap.put("id",id);
                oap.put("sessionId",sessionId);
                presenter.doEmail(oap,email);
            }

            @Override
            protected void onFastClick() {

            }
        });
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    public void onSuccess(Object obj) {
        UserBean userBean= (UserBean) obj;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
            login.SharedPreferenceput("email",email);
            ARouter.getInstance().build("/mymodlue/emactivity").navigation();
        }else {
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
