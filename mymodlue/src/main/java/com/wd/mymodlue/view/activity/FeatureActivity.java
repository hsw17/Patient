package com.wd.mymodlue.view.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
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

public class FeatureActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R2.id.fanhui)
    ImageView fanhui;
    @BindView(R2.id.btn_finish_sign)
    Button btnFinishSign;
    @BindView(R2.id.image_height)
    ImageView imageHeight;
    @BindView(R2.id.text_progress)
    TextView textProgress;
    @BindView(R2.id.sign_seekbar)
    SeekBar signSeekbar;
    @BindView(R2.id.image_weight)
    ImageView imageWeight;
    @BindView(R2.id.text2_progress)
    TextView text2Progress;
    @BindView(R2.id.we_seekbar)
    SeekBar weSeekbar;
    @BindView(R2.id.age_weight)
    ImageView ageWeight;
    @BindView(R2.id.text3_progress)
    TextView text3Progress;
    @BindView(R2.id.age_seekbar)
    SeekBar ageSeekbar;
    private int height;
    private int weight;
    private int age;
    private SPUtils login;

    @Override
    protected int bindLayout() {
        return R.layout.activity_feature;
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
        Map<String, Object> oap = new HashMap<>();
        oap.put("age", age);
        oap.put("height", height);
        oap.put("weight", weight);

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
        btnFinishSign.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {

                presenter.onPerfectUserInfo(map,oap);
            }

            @Override
            protected void onFastClick() {

            }
        });
        signSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textProgress.setText(50+progress+"cm");
                int position = signSeekbar.getProgress()-200;
                int x = seekBar.getWidth();
                int seekbarWidth = signSeekbar.getWidth();
                float width = (position*x)/200+seekbarWidth; //seekbar当前位置的宽度
                textProgress.setX(width);
                // Toast.makeText(SignActivity.this, "" + progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //  Toast.makeText(SignActivity.this, "开始：" + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                height = seekBar.getProgress();
//                EventBus.getDefault().postSticky(new SeekBarBean(50 + height + "", 18 + age + "", 30 + weight + ""));
            }
        });

        ageSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                text3Progress.setText(18+progress+"");
                int position = ageSeekbar.getProgress()-102;
                int x = seekBar.getWidth();
                int seekbarWidth = ageSeekbar.getWidth();
                float width = (position*x)/102+seekbarWidth; //seekbar当前位置的宽度
                text3Progress.setX(width);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                age = seekBar.getProgress();
//                EventBus.getDefault().postSticky(new SeekBarBean(50 + height + "", 18 + age + "", 30 + weight + ""));
            }
        });

        weSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                text2Progress.setText(30+progress+"kg");
                int position = weSeekbar.getProgress()-120;
                int x = seekBar.getWidth();
                int seekbarWidth = weSeekbar.getWidth();
                float width = (position*x)/120+seekbarWidth; //seekbar当前位置的宽度
                text2Progress.setX(width);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                weight = seekBar.getProgress();
//                EventBus.getDefault().postSticky(new SeekBarBean(50 + height + "", 18 + age + "", 30 + weight + ""));
            }
        });

    }
    @Override
    public void onSuccess(Object obj) {
        UserBean userBean = (UserBean) obj;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
            login.SharedPreferenceput("age", age);
            login.SharedPreferenceput("height", height);
            login.SharedPreferenceput("weight", weight);
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
