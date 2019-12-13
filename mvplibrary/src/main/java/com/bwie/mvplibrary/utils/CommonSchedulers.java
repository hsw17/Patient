package com.bwie.mvplibrary.utils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public class CommonSchedulers {
    public static <T>ObservableTransformer<T,T> io2main(){
        return new ObservableTransformer<T, T> () {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn ( Schedulers.io () )
                        .observeOn ( AndroidSchedulers.mainThread () );
            }
        };
    }
}
