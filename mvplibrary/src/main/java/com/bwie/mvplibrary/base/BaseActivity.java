package com.bwie.mvplibrary.base;

import android.content.Context;
import android.os.Bundle;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    protected P presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( bindLayout () );

        presenter = setPresenter ();
        if (presenter!=null){
            presenter.attachView ( this );
        }
        initView ();
        initData ();
    }


    protected abstract int bindLayout();
    protected abstract P setPresenter();

    protected void initView(){}
    protected void initData(){}

   public boolean hasNetWork(){
        return false;
   }

   public void isNetWork(){
       Toast.makeText ( this, "无网络连接...", Toast.LENGTH_SHORT ).show ();
   }

    @Override
    protected void onDestroy() {
        super.onDestroy ();

    }

    @Override
    public Context context() {
        return this;
    }
}
