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
import com.dueeeke.videoplayer.player.IjkVideoView;
import com.wd.mymainmodule.R2;
import com.wd.mymodlue.R;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.modle.bean.VideoBuyBean;
import com.wd.mymodlue.modle.bean.VideoCollectBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.adapter.VideoAdapter;
import com.wd.mymodlue.view.adapter.VideoBuyAdapter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
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
    private IjkVideoView ijkView;
    private VideoAdapter videoAdapter;
    private Map<String, Object> map;
    private Map<String, Object> oap;
    private VideoBuyAdapter videoAdapter1;

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
        map = new HashMap<>();
        map.put("userId", id);
        map.put("sessionId", sessionId);
        oap = new HashMap<>();
        oap.put("page", 1);
        oap.put("count", 10);
        presenter.onVideoBuyList(map, oap);
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
        VideoBuyBean videoBuyBean= (VideoBuyBean) obj;
        if ("0000".equals(videoBuyBean.status)) {
            List<VideoBuyBean.ResultBean> result = videoBuyBean.result;
            if (result.size()==0) {
                recordLinearLayout.setVisibility(View.VISIBLE);
                recordLinearView.setVisibility(View.GONE);
                return;
            }else{
                videoAdapter1 = new VideoBuyAdapter(result);
                recordLinearView.setLayoutManager(new LinearLayoutManager(this));
                recordLinearView.setAdapter(videoAdapter1);
                videoAdapter1.setAreaView(new VideoBuyAdapter.AreaView() {
                    @Override
                    public void onCurress(int id) {
                        presenter.ondeleteVideoBuy(map,id);

                    }

                    @Override
                    public void onCurre(IjkVideoView IjkView) {

                    }
                });

            }

        }else{
            ToastUtils.show(videoBuyBean.message);
        }
    }

    @Override
    public void onSuccessOne(Object one) {
        UserBean userBean= (UserBean) one;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
            presenter.onVideoBuyList(map, oap);
            videoAdapter1.notifyDataSetChanged();
        }else{
            ToastUtils.show(userBean.message);
        }
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
