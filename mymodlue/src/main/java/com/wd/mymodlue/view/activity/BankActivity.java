package com.wd.mymodlue.view.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;

import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BankActivity extends BaseActivity<Persenter> implements IViewContract.IView {

    private static final int REQUEST_CODE_CAMERA = 102;
    private static final int REQUEST_CODE_DRIVING_LICENSE = 103;
    private static final int REQUEST_CODE_VEHICLE_LICENSE = 104;
    int beforeTextLength = 0;
    int onTextLength = 0;
    @BindView(R2.id.img_back)
    ImageView imgBack;
    @BindView(R2.id.img_id_card_front)
    ImageView imgIdCardFront;
    @BindView(R2.id.img_camera_bank_card)
    ImageView imgCameraBankCard;
    @BindView(R2.id.linear_bank_card)
    LinearLayout linearBankCard;
    @BindView(R2.id.btn_next_bank_card)
    Button btnNextBankCard;
    @BindView(R2.id.btn_finish_bank_card)
    Button btnFinishBankCard;
    @BindView(R2.id.img_cuowu_front)
    ImageView imgCuowuFront;
    private SPUtils login;
    @Override
    protected int bindLayout() {
        return R.layout.activity_bank;
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

    }
    @Override
    public void onSuccess(Object obj) {

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
