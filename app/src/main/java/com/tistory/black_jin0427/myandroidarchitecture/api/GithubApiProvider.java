package com.tistory.black_jin0427.myandroidarchitecture.api;

import android.support.annotation.NonNull;

import com.tistory.black_jin0427.myandroidarchitecture.constant.Constant;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class GithubApiProvider {

    public static GithubApi provideGithubApi() {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(provideOkHttpClient(provideLoggingInterceptor()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubApi.class);
    }

    private static OkHttpClient provideOkHttpClient(@NonNull HttpLoggingInterceptor interceptor) {
        OkHttpClient.Builder b = new OkHttpClient.Builder();
        b.addInterceptor(interceptor);
        return b.build();
    }

    private static HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }
}
