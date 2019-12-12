package com.bwie.mvplibrary.base;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.mvplibrary.app.App;

import androidx.fragment.app.Fragment;
;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {

    protected P fpresenter;



    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
         //绑定布局
        View view = inflater.inflate ( bindLayout (),container,false );

        return view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated ( savedInstanceState );
        fpresenter = setPresenter ();
        if (fpresenter!=null){
            fpresenter.attachView ( this );
        }
        initView ();
        initData ();
    }

    protected abstract int bindLayout();
    protected abstract P setPresenter();
    protected void initView(){}
    protected void initData(){}

    @Override
    public void onDestroyView() {
        super.onDestroyView ();
        //解绑butterKnife

    }

    @Override
    public void onDestroy() {
        super.onDestroy ();
        if (fpresenter!=null){
            fpresenter.detachView ();
        }
    }

    public boolean hasNetwork() {
        return false;
    }

    //无网提醒
    public void showNoNetTip() {
        Toast.makeText(context(), "无网，请检查网络", Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getContext ()==null ? App.getsContent ():getContext ();
    }


}
