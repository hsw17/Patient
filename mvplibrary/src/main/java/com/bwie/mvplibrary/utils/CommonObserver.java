package com.bwie.mvplibrary.utils;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public abstract class CommonObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }
}
