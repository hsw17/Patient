package com.wd.he_home.fragment.changjian;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwie.mvplibrary.base.BaseFragment;
import com.wd.he_home.R;
import com.wd.he_home.adapter.CommonDrugsAdapter;
import com.wd.he_home.adapter.CommonSymptomsAdapter;
import com.wd.he_home.bean.DrugClassificationBean;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.presenter.HomePresenter;

import java.util.List;

/**
 * author: [Liu He]  //常见药品
 * data: 2019/12/16.
 * function：
 */
public class CommonDrugsFragment extends BaseFragment<HomePresenter> implements HomeContract.HomeView {
    private RecyclerView commond_recycler;
    @Override
    protected int bindLayout() {
        return R.layout.commondrugs_fragment;
    }

    @Override
    protected HomePresenter setPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        commond_recycler = getActivity().findViewById(R.id.commond_recycler);
        fpresenter.HomePresenterYaoPinFenLei();
    }

    @Override
    public void HomeViewSuccess(Object obj) {
        DrugClassificationBean drugClassificationBean = (DrugClassificationBean) obj;
        List<DrugClassificationBean.ResultBean> result = drugClassificationBean.getResult();
        //这是线程管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context());
        commond_recycler.setLayoutManager(linearLayoutManager);
        CommonDrugsAdapter commonDrugsAdapter = new CommonDrugsAdapter(context(), result);
        commond_recycler.setAdapter(commonDrugsAdapter);
    }

    @Override
    public void HomeViewError(String e) {

    }
}
