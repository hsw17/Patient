package com.bwie.mvplibrary.base;

import android.content.Context;

import com.bwie.mvplibrary.app.App;

import java.lang.ref.WeakReference;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public abstract class BasePresenter<V extends IBaseView> {

    private WeakReference<V> vWeakReference;

    public BasePresenter(){
       initModel();
    }

    protected abstract void initModel();

    public void attachView(V mainView){
       vWeakReference = new WeakReference<> ( mainView );
    }

    public void detachView(){
        if (vWeakReference!=null){
            vWeakReference.clear ();
            vWeakReference = null;
        }
    }

    /**
     * 判断view是否挂载
     * <p>
     * 防止出现 presenter 层 view 调用空指针
     * 每次调用业务请求的时候都要先调用方法检查是否与 View 绑定
     * 只有返回ture才进行回调
     */

   protected boolean isViewAttached(){
      if (vWeakReference == null|| vWeakReference.get ()==null){
         return false;
      }

      return true;
   }

   protected V getView(){
       return vWeakReference.get ();
   }


   protected Context context(){
     if (isViewAttached ()&&getView ().context ()!=null){
        return getView ().context ();
     }
     return App.getsContent ();
   }

}
