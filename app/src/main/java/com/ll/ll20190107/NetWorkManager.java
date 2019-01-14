package com.ll.ll20190107;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkManager {
    private static NetWorkManager mInstance;
    private Retrofit retrofit;
    private static final String BASE_URL="http://172.17.8.100/small/";
    private NetWorkManager(){
        init();
    }
    public static NetWorkManager getmInstance(){
        if (mInstance==null){
            mInstance=new NetWorkManager();
        }
        return mInstance;
    }
    private void init(){
        //初始化okhttp
        HttpLoggingInterceptor logging=new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client=new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        retrofit=new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    //把接口的注解翻译为OKhttp请求
    public <T> T create(final Class<T> service){
        return retrofit.create(service);
    }

}
