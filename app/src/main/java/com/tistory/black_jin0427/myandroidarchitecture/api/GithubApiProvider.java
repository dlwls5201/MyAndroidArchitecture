package com.tistory.black_jin0427.myandroidarchitecture.api;

import com.tistory.black_jin0427.myandroidarchitecture.constant.Constant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class GithubApiProvider {

    public static GithubApi provideGithubApi() {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(GithubApi.class);
    }
}
