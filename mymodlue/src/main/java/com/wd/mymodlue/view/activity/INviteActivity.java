package com.wd.mymodlue.view.activity;

import android.os.Bundle;
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
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.mymodlue.R;
import com.wd.mymodlue.modle.bean.HealthTestBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class INviteActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R.id.head_text_name)
    TextView headTextName;
    @BindView(R.id.relay_layout)
    RelativeLayout relayLayout;
    @BindView(R.id.invite_edit_code)
    EditText inviteEditCode;
    @BindView(R.id.invite_button_code)
    LinearLayout inviteButtonCode;
    @BindView(R.id.invite_simpl_view)
    SimpleDraweeView inviteSimplView;
    @BindView(R.id.invite_button_friend)
    Button inviteButtonFriend;
    private Map<String, Object> map;

    @Override
    protected int bindLayout() {
        return R.layout.activity_invite;
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
        map.put("userId", 434);
        map.put("sessionId", "1576494766784434");
        presenter.doUserInvitation(map);
        inviteButtonFriend.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                
            }

            @Override
            protected void onFastClick() {

            }
        });
    }
    @Override
    public void onSuccess(Object obj) {
        HealthTestBean healthTestBean= (HealthTestBean) obj;
        if ("0000".equals(healthTestBean.result)) {
            String status = healthTestBean.status;
            inviteEditCode.setText(status);
        }else{
            inviteEditCode.setText("");
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
