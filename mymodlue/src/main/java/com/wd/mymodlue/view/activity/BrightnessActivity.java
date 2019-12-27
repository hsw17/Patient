package com.wd.mymodlue.view.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

import androidx.core.app.ActivityCompat;
import butterknife.BindView;
import butterknife.ButterKnife;

public class BrightnessActivity extends BaseActivity<Persenter> implements IViewContract.IView {

    @BindView(R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R2.id.head_text_name)
    TextView headTextName;
    @BindView(R2.id.relay_layout)
    RelativeLayout relayLayout;
    @BindView(R2.id.screen_seekbar)
    SeekBar screenSeekbar;
    private static String[] PERMISSIONS_STORAGE = {
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE};    //请求状态码
    private static int REQUEST_PERMISSION_CODE = 2;

    @Override
    protected int bindLayout() {
        return R.layout.activity_brightness;
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

        //        设置屏幕亮度
        screenSeekbar.setMax(255);
        int normal = Settings.System.getInt(getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS, 255);
        screenSeekbar.setProgress(normal);
        screenSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            //当Seekbar在滑动的时候，亮度也随着变化
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //如果当前平台版本大于23平台
                    if (!Settings.System.canWrite(BrightnessActivity.this)) {
                        //如果没有修改系统的权限这请求修改系统的权限
                        Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                        intent.setData(Uri.parse("package:" + getPackageName()));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivityForResult(intent, 0);
                    } else {
                        //有了权限，你要做什么呢？具体的动作

                        int tmpInt = progress;
                        // 当进度小于80时，设置成80，防止太黑看不见的后果。
                        if (tmpInt < 80) {
                            tmpInt = 80;
                        }

                        // 根据当前进度改变亮度
                        Settings.System.putInt(getContentResolver(),
                                Settings.System.SCREEN_BRIGHTNESS, progress);
                        tmpInt = Settings.System.getInt(getContentResolver(),
                                Settings.System.SCREEN_BRIGHTNESS, -1);
                        WindowManager.LayoutParams wl = getWindow().getAttributes();

                        float tmpFloat = (float) tmpInt / 255;
                        if (tmpFloat > 0 && tmpFloat <= 1) {
                            wl.screenBrightness = tmpFloat;
                        }
                        getWindow().setAttributes(wl);
                    }

                }
            }
        });
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
