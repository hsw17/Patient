package com.wd.mymodlue.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;
import com.wd.mymodlue.R;
import com.wd.mymodlue.R2;
import com.wd.mymodlue.modle.bean.UserConsumptionRecordListBean;
import com.wd.mymodlue.modle.bean.UserWalletBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.adapter.WalletAdapter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WalletActivity extends BaseActivity<Persenter> implements IViewContract.IView {

    @BindView(R2.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R2.id.head_text_name)
    TextView headTextName;
    @BindView(R2.id.wall_text_price)
    TextView wallTextPrice;
    @BindView(R2.id.wall_button_left)
    Button wallButtonLeft;
    @BindView(R2.id.wall_button_right)
    Button wallButtonRight;
    @BindView(R2.id.wall_list_view)
    RecyclerView wallListView;
    private Map<String, Object> map;
    private Map<String, Object> oap;

    @Override
    protected int bindLayout() {
        return R.layout.activity_wallet;
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
        map.put("userId", id);
        map.put("sessionId", sessionId);
        oap = new HashMap<>();
        oap.put("page", 1);
        oap.put("count", 10);
//        请求数据
        presenter.doUserWallet(map);
        presenter.doRecordList(map,oap);
//        标题功能
        headTextName.setText("我的钱包");
        headDetailsBack.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                Intent intent=new Intent(WalletActivity.this,My_ModuleMainActivity.class);
                startActivity(intent);
                finish();
                finish();
            }

            @Override
            protected void onFastClick() {

            }
        });
    }
    @Override
    public void onSuccess(Object obj) {
        UserWalletBean userWalletBean= (UserWalletBean) obj;
        if ("0000".equals(userWalletBean.status)) {
            int result = userWalletBean.result;
            wallTextPrice.setText(result+"");
        }else {
            ToastUtils.show(userWalletBean.message);
        }
    }

    @Override
    public void onSuccessOne(Object one) {
        UserConsumptionRecordListBean userConsumptionRecordListBean= (UserConsumptionRecordListBean) one;
        if ("0000".equals(userConsumptionRecordListBean.status)) {
            List<UserConsumptionRecordListBean.ResultBean> result = userConsumptionRecordListBean.result;
            WalletAdapter walletAdapter=new WalletAdapter(result);
            wallListView.setLayoutManager(new LinearLayoutManager(this));
            wallListView.setAdapter(walletAdapter);
        }else{
            ToastUtils.show(userConsumptionRecordListBean.message);
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
