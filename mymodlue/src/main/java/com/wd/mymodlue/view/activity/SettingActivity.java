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
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.mymodlue.R;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SettingActivity extends BaseActivity<Persenter> implements IViewContract.IView {

    @BindView(R.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R.id.head_text_name)
    TextView headTextName;
    @BindView(R.id.relay_layout)
    RelativeLayout relayLayout;
    @BindView(R.id.setting_image_view)
    SimpleDraweeView settingImageView;
    @BindView(R.id.setting_text_name)
    TextView settingTextName;
    @BindView(R.id.setting_image_name)
    LinearLayout settingImageName;
    @BindView(R.id.setting_image_pwd)
    LinearLayout settingImagePwd;
    @BindView(R.id.setting_text_clear)
    TextView settingTextClear;
    @BindView(R.id.setting_image_clear)
    RelativeLayout settingImageClear;
    @BindView(R.id.setting_image_ping_lian)
    RelativeLayout settingImagePingLian;
    @BindView(R.id.setting_image_new_app)
    RelativeLayout settingImageNewApp;
    @BindView(R.id.setting_image_ping_help)
    RelativeLayout settingImagePingHelp;
    @BindView(R.id.setting_image_my)
    RelativeLayout settingImageMy;
    @BindView(R.id.setting_image_new_invite)
    RelativeLayout settingImageNewInvite;
    @BindView(R.id.setting_image_login)
    RelativeLayout settingImageLogin;
    @BindView(R.id.setting_image_layout)
    RelativeLayout settingImageLayout;

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
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        settingTextClear.postInvalidate();
                    }
                }).start();
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