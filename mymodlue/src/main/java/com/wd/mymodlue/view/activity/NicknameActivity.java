package com.wd.mymodlue.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

public class NicknameActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R2.id.fanhui)
    ImageView fanhui;
    @BindView(R2.id.name_button_finish)
    Button nameButtonFinish;
    @BindView(R2.id.name_edit_text)
    EditText nameEditText;
    @BindView(R2.id.name_imag_delete)
    ImageView nameImagDelete;
    @BindView(R2.id.my_information_Avatar_a)
    RelativeLayout myInformationAvatarA;
    @BindView(R2.id.name_button_call_of)
    TextView nameButtonCallOf;
    @BindView(R2.id.name_button_affrim)
    TextView nameButtonAffrim;
    @BindView(R2.id.name_visit_gone)
    LinearLayout nameVisitGone;
    private SPUtils login;
    private String s;

    @Override
    protected int bindLayout() {
        return R.layout.activity_nickname;
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
//        修改昵称
        nameButtonFinish.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {

                nameVisitGone.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onFastClick() {

            }
        });
//        取消
        nameButtonCallOf.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
               nameVisitGone.setVisibility(View.GONE);
            }

            @Override
            protected void onFastClick() {

            }
        });
//        确认
        nameButtonAffrim.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                s = nameEditText.getText().toString();
                if (s.equals(null)) {
                    ToastUtils.show("不能为空");
                    return;
                }
                presenter.onModifyNickName(map, s);

            }

            @Override
            protected void onFastClick() {

            }
        });
//        删除
        nameImagDelete.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                nameEditText.setText("");
            }

            @Override
            protected void onFastClick() {

            }
        });
//        销毁
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
    }

    @Override
    public void onSuccess(Object obj) {
        UserBean userBean = (UserBean) obj;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
            login.SharedPreferenceput("nickName",s);
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
