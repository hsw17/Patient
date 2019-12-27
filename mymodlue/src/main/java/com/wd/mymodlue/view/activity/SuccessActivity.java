package com.wd.mymodlue.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.wd.mymodlue.R;
import com.wd.mymodlue.modle.bean.GIfListBean;
import com.wd.mymodlue.modle.bean.UserBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.adapter.GifListAdapter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SuccessActivity extends BaseActivity<Persenter> implements IViewContract.IView {

    private TextView head_text_name;
    private RelativeLayout relay_layout;
    private RecyclerView recyc_list_view;
    private Button button_finish;
    private int idl;
    private SPUtils login;
    private Map<String, Object> map;
    private Map<String, Object> oap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        initView();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_success;
    }

    @Override
    protected Persenter setPresenter() {
        return new Persenter();
    }

    @Override
    protected void initData() {
        super.initData();
        presenter.onGiftList();
        ToastUtils.init(this);
//        获取存储内容
        login = new SPUtils(this, "login");
        int id = (int) login.getSharedPreference("id", 0);
        String sessionId = (String) login.getSharedPreference("sessionId", "");
        map = new HashMap<>();
        map.put("userId", id);
        map.put("sessionId", sessionId);
        oap = new HashMap<>();

        Intent intent = getIntent();
        idl = intent.getIntExtra("idl", 0);

        button_finish.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent1=new Intent("com.hl.CompileActivity");
                startActivity(intent1);
                finish();
            }

            @Override
            protected void onFastClick() {

            }
        });
    }

    @Override
    public void onSuccess(Object obj) {
        GIfListBean gIfListBean= (GIfListBean) obj;
        if ("0000".equals(gIfListBean.status)) {
            List<GIfListBean.ResultBean> result = gIfListBean.result;
            GifListAdapter gifListAdapter=new GifListAdapter(result);
            recyc_list_view.setLayoutManager(new LinearLayoutManager(this));
            recyc_list_view.setAdapter(gifListAdapter);
            gifListAdapter.setAreaView(new GifListAdapter.AreaView() {
                @Override
                public void onCurress(int id) {
                    oap.put("inquiryRecordId", idl);
                    oap.put("giftId", id);
                    presenter.onHandselGift(map,oap);
                }

                @Override
                public void onCurre(int id) {

                }
            });
        }else{

        }
    }

    @Override
    public void onSuccessOne(Object one) {
        UserBean userBean= (UserBean) one;
        if ("0000".equals(userBean.status)) {
            ToastUtils.show(userBean.message);
        }else {
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

    public void initView() {
        head_text_name = (TextView) findViewById(R.id.head_text_name);
        relay_layout = (RelativeLayout) findViewById(R.id.relay_layout);
        recyc_list_view = (RecyclerView) findViewById(R.id.recyc_list_view);
        button_finish = (Button) findViewById(R.id.button_finish);
    }

}
