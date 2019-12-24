package com.wd.mymodlue.view.fragment;

import com.bwie.mvplibrary.base.BaseFragment;
import com.wd.mymodlue.R;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

/**
 * date:2019/12/24
 * author:贺少伟(盗)
 * function:
 */
public class VideoFragment extends BaseFragment<Persenter> implements IViewContract.IView {
    @Override
    protected int bindLayout() {
        return R.layout.item_fragment_video;
    }

    @Override
    protected Persenter setPresenter() {
        return new Persenter();
    }

    @Override
    public void onSuccess(Object obj) {

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
