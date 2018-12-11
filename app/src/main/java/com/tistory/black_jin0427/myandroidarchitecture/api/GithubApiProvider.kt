package com.tistory.black_jin0427.myandroidarchitecture.api

import com.tistory.black_jin0427.myandroidarchitecture.constant.BASE_URL
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class GithubApiProvider {

    fun getGithubApi(): GithubApi {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(GithubApi::class.java)
    }

}

