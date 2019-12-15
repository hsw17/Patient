package com.wd.mymodlue.view.activity;



import com.bwie.mvplibrary.base.BaseActivity;
import com.wd.mymodlue.R;
import com.wd.mymodlue.persenter.Persenter;
import com.wd.mymodlue.view.contract.IViewContract;

public class MainActivity extends BaseActivity<Persenter> implements IViewContract.IView {


    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
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
