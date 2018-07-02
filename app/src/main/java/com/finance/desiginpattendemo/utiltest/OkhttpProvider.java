package com.finance.desiginpattendemo.utiltest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Jackie on 2018/7/2.
 */
public abstract class OkhttpProvider {

    private static OkHttpClient instance = null;

    public static OkHttpClient getOkHttpInstance() {
        if (instance == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

            instance = new OkHttpClient()
                    .newBuilder()
                    .addInterceptor(interceptor)
                    .build();
        }
        return instance;
    }


}
