package com.wd.he_home.fragment.jiankangzixun;

import android.os.Bundle;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwie.mvplibrary.base.BaseFragment;
import com.wd.he_home.R;
import com.wd.he_home.adapter.NewslistAdapter;
import com.wd.he_home.bean.NewslistBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.presenter.HomePresenter;

import java.util.List;

import butterknife.ButterKnife;

/**
 *@describe(描述)：Healthbeauty_Fragment  养生美容
 *@data（日期）: 2019/12/14
 *@time（时间）: 10:56
 *@author（作者）: Liuhe
 **/
public class Healthbeauty_Fragment extends BaseFragment<HomePresenter> implements HomeContract.HomeView {
    private RecyclerView zixunRecycler;
    @Override
    protected int bindLayout() {
        return R.layout.healthbeauty_layout;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }
    @Override
    protected void initData() {
        super.initData();

    }
    @Override
    protected void initView() {
        super.initView();
        zixunRecycler = getActivity().findViewById(R.id.yangsheng_recycler);
        fpresenter.HomePresenterZiXunLieBiao("4", "2", "5");
    }
    @Override
    public void HomeViewSuccess(Object obj) {
        if (obj instanceof NewslistBean) {
            //查询列表
            NewslistBean newslistBean = (NewslistBean) obj;
            List<NewslistBean.ResultBean> result = newslistBean.getResult();
            //设置布局
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context());
            zixunRecycler.setLayoutManager(linearLayoutManager);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            NewslistAdapter newslistAdapter = new NewslistAdapter(result, context());
            zixunRecycler.setAdapter(newslistAdapter);
            zixunRecycler.addItemDecoration(new DividerItemDecoration(context(), DividerItemDecoration.VERTICAL));
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(getActivity());
    }
    @Override
    public void HomeViewError(String e) {

    }
}
