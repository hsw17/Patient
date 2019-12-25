package com.wd.mymodlue.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.wd.mymainmodule.R2;
import com.wd.mymodlue.R;
import com.wd.mymodlue.modle.bean.VideoCollectBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @BindView(R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(com.wd.mymodlue.R2.id.record_linear_layout)
    LinearLayout recordLinearLayout;
    RecyclerView recordLinearView;
    private SPUtils login;

    @Override
    protected int bindLayout() {
        return R.layout.activity_video;
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
        recordLinearView=findViewById(R.id.record_linear_view);
        ToastUtils.init(this);
//        获取存储内容
        login = new SPUtils(this, "login");
        int id = (int) login.getSharedPreference("id", 0);
        String sessionId = (String) login.getSharedPreference("sessionId", "");
        Map<String, Object> map = new HashMap<>();
        map.put("userId", id);
        map.put("sessionId", sessionId);
        Map<String, Object> oap = new HashMap<>();
        oap.put("page", 1);
        oap.put("count", 10);
        presenter.onVideoCollectionList(map,oap);
        headDetailsBack.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent = new Intent(VideoActivity.this, My_ModuleMainActivity.class);
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
        VideoCollectBean videoCollectBean= (VideoCollectBean) obj;
        if ("0000".equals(videoCollectBean.status)) {
            List<VideoCollectBean.ResultBean> result = videoCollectBean.result;
            if (result.size()==0) {
                recordLinearLayout.setVisibility(View.VISIBLE);
                return;
            }else{

            }

        }else{
            ToastUtils.show(videoCollectBean.message);
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
