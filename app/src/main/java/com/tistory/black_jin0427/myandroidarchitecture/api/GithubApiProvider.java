package com.tistory.black_jin0427.myandroidarchitecture.api;

import android.support.annotation.NonNull;

import com.tistory.black_jin0427.myandroidarchitecture.constant.Constant;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *  Dagger 사용을 사용함으로서 필요성이 없어짐
 */
public final class GithubApiProvider {

    /*public static GithubApi provideGithubApi() {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                // OkHttpClient 객체를 필요로 합니다.
                .client(provideOkHttpClient(provideLoggingInterceptor()))
                // CallAdapter.Factory 객체를 필요로 합니다.
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                // Converter.Factory 객체를 필요로 합니다.
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
    }*/
}
