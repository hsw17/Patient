package com.wd.mymodlue.view.activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.DataCleanManager;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SettingActivity extends BaseActivity<Persenter> implements IViewContract.IView {

    @BindView(R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R2.id.head_text_name)
    TextView headTextName;
    @BindView(R2.id.relay_layout)
    RelativeLayout relayLayout;
    @BindView(R2.id.setting_image_view)
    SimpleDraweeView settingImageView;
    @BindView(R2.id.setting_text_name)
    TextView settingTextName;
    @BindView(R2.id.setting_image_name)
    LinearLayout settingImageName;
    @BindView(R2.id.setting_image_pwd)
    RelativeLayout settingImagePwd;
    @BindView(R2.id.setting_text_clear)
    TextView settingTextClear;
    @BindView(R2.id.setting_image_clear)
    RelativeLayout settingImageClear;
    @BindView(R2.id.setting_image_ping_lian)
    RelativeLayout settingImagePingLian;
    @BindView(R2.id.setting_image_new_app)
    RelativeLayout settingImageNewApp;
    @BindView(R2.id.setting_image_ping_help)
    RelativeLayout settingImagePingHelp;
    @BindView(R2.id.setting_image_my)
    RelativeLayout settingImageMy;
    @BindView(R2.id.setting_image_new_invite)
    RelativeLayout settingImageNewInvite;
    @BindView(R2.id.setting_image_login)
    RelativeLayout settingImageLogin;
    @BindView(R2.id.setting_image_layout)
    RelativeLayout settingImageLayout;
    private int id;
    private String sessionId;
    private SPUtils login;
    private String nickName;
    private String headPic;
    @Override
    protected int bindLayout() {
        return R.layout.activity_setting;

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
        login = new SPUtils(this, "login");
        id = (int) login.getSharedPreference("id", 0);
        sessionId = (String) login.getSharedPreference("sessionId", "");
        nickName = (String) login.getSharedPreference("nickName", "");
        headPic = (String) login.getSharedPreference("headPic", "");
          if (id!=0){
            settingImageView.setImageURI(headPic);
            settingTextName.setText(nickName);
         }
//          返回
        headDetailsBack.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent=new Intent(SettingActivity.this,My_ModuleMainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            protected void onFastClick() {

            }
        });
        //        个人信息
        settingImageLayout.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent=new Intent("com.hl.MessageActivity");
                startActivity(intent);
            }

            @Override
            protected void onFastClick() {

            }
        });
//        邀请好友
        settingImageNewInvite.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent = new Intent("com.hl.INviteActivity");
                startActivity(intent);
            }

            @Override
            protected void onFastClick() {

            }
        });
//        清除缓存
        settingImageClear.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                //                清除缓存
                DataCleanManager.clearAllCache(SettingActivity.this);
                //        获取缓冲数量
                try {
//            获取文件大小
                    String totalCacheSize = DataCleanManager.getTotalCacheSize(SettingActivity.this);
                    settingTextClear.setText(totalCacheSize);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void onFastClick() {

            }
        });
//        获取缓冲数量
        try {
//            获取文件大小
            String totalCacheSize = DataCleanManager.getTotalCacheSize(this);
            settingTextClear.setText(totalCacheSize);

        } catch (Exception e) {
            e.printStackTrace();
        }
//        设置屏幕亮度
        settingImagePingLian.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent = new Intent("com.hl.BrightnessActivity");
                startActivity(intent);
            }

            @Override
            protected void onFastClick() {

            }
        });
//        修改密码
        settingImagePwd.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent=new Intent("com.hl.PwdActivity");
                startActivity(intent);
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