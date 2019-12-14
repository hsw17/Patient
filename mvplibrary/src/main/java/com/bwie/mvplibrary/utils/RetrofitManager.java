package com.bwie.mvplibrary.utils;


import com.bwie.mvplibrary.app.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/11/5
 * @Description:
 */
public class RetrofitManager {

    private static final String BASE_URL = Constant.BASE_URL;
    private final Retrofit retrofit;

    private static final class SingleHolder{
       private static final RetrofitManager _INSTANCE = new RetrofitManager (BASE_URL);
    }

    public static RetrofitManager getInstance(){
        return SingleHolder._INSTANCE;
    }

    private OkHttpClient buildOkhttpClint(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor interceptor = loggingInterceptor.setLevel ( HttpLoggingInterceptor.Level.BODY );

       return new OkHttpClient.Builder ().addInterceptor ( interceptor )
                   .connectTimeout ( 10, TimeUnit.SECONDS )
                   .readTimeout ( 10, TimeUnit.SECONDS )
                   .writeTimeout ( 10, TimeUnit.SECONDS )
                   .build ();
    }

    private RetrofitManager(String url){
        retrofit = new Retrofit.Builder ()
                .baseUrl ( url )
                .addConverterFactory ( GsonConverterFactory.create () )
                .addCallAdapterFactory ( RxJava2CallAdapterFactory.create () )
                .client ( buildOkhttpClint () )
                .build ();
    }

    public <T> T create(final Class<T> service){
        return retrofit.create ( service );
    }


}
