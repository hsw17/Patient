package com.wd.mymodlue.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.mvplibrary.base.BaseActivity;
import com.bwie.mvplibrary.utils.CustomClickListener;
import com.bwie.mvplibrary.utils.SPUtils;
import com.bwie.mvplibrary.utils.ToastUtils;

import com.wd.mymodlue.R;
import com.wd.mymodlue.modle.bean.UserCommentListBean;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.adapter.SuggestAdapter;
import com.wd.mymodlue.view.adapter.WalletAdapter;
import com.wd.mymodlue.view.contract.IViewContract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SuggestActivity extends BaseActivity<Persenter> implements IViewContract.IView {

    @BindView(R.id.head_details_back)
    ImageView headDetailsBack;
    @BindView(R.id.head_text_name)
    TextView headTextName;

    @BindView(R.id.record_linear_layout)
    LinearLayout recordLinearLayout;
    @BindView(R.id.suggest_list_view)
    RecyclerView suggestListView;
    private Map<String, Object> map;
    private Map<String, Object> oap;


    @Override
    protected int bindLayout() {
        return R.layout.activity_suggest;
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
        oap = new HashMap<>();
        oap.put("page", 1);
        oap.put("count", 10);
        headDetailsBack.setOnClickListener(new CustomClickListener() {
            @Override
            protected void onSingleClick() {
                finish();
            }

            @Override
            protected void onFastClick() {

            }
        });
        presenter.doCommentList(map,oap);

    }

    @Override
    public void onSuccess(Object obj) {
        UserCommentListBean userCommentListBean= (UserCommentListBean) obj;
        if ("0000".equals(userCommentListBean.status)) {
            ToastUtils.show(userCommentListBean.message);
            List<UserCommentListBean.ResultBean> result = userCommentListBean.result;
            if (result.size()==0){
                recordLinearLayout.setVisibility(View.VISIBLE);
            }else {
                recordLinearLayout.setVisibility(View.GONE);
                SuggestAdapter suggestAdapter=new SuggestAdapter(result);
                suggestListView.setLayoutManager(new LinearLayoutManager(this));
                suggestListView.setAdapter(suggestAdapter);
            }

        }else{
            ToastUtils.show(userCommentListBean.message);
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
