package com.wd.he_home.fragment;

import com.bwie.mvplibrary.base.BaseFragment;
import com.wd.he_home.R;
import com.wd.he_home.comtract.HomeContract;
import com.wd.he_home.presenter.HomePresenter;

/**
 * date:2020/1/9
 * author:贺少伟(盗)
 * function:
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.HomeView{
    @Override
    protected int bindLayout() {
        return R.layout.item_home;
    }

    @Override
    protected HomePresenter setPresenter() {
        return null;
    }

    @Override
    public void HomeViewSuccess(Object obj) {

    }

    @Override
    public void HomeViewError(String e) {

    }
}
