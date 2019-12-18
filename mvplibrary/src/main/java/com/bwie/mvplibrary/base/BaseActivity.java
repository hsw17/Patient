package com.bwie.mvplibrary.base;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.os.StrictMode;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


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
        //跳转相机动态权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
    }

    /**
     * 检查是否有对应权限
     *
     * @param activity 上下文
     * @param permission 要检查的权限
     * @return  结果标识
     */
    public int verifyPermissions(Activity activity, java.lang.String permission) {
        int Permission = ActivityCompat.checkSelfPermission(activity,permission);
        if (Permission == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(activity, "已经同意权限", Toast.LENGTH_SHORT).show();
            return 1;
        }else{
            Toast.makeText(activity, "没有同意权限", Toast.LENGTH_SHORT).show();
            return 0;
        }
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
