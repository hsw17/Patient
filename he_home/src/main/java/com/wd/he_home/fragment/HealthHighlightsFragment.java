package com.wd.he_home.fragment;

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

/**
 * @describe(描述)：HealthHighlightsFragment 健康要闻
 * @data（日期）: 2019/12/14
 * @time（时间）: 10:55
 * @author（作者）: Liuhe
 **/
public class HealthHighlightsFragment extends BaseFragment<HomePresenter> implements HomeContract.HomeView {

    private RecyclerView zixunRecycler;
    @Override
    protected int bindLayout() {
        return R.layout.healthhighlights_layout;
    }



    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        fpresenter.HomePresenterZiXunLieBiao("1", "2", "5");
    }

    @Override
    protected void initView() {
        super.initView();
        zixunRecycler = getActivity().findViewById(R.id.jiankang_recycler);
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
    public void HomeViewError(String e) {

    }
}
