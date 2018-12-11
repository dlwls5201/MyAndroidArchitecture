package com.tistory.black_jin0427.myandroidarchitecture.di

import com.tistory.black_jin0427.myandroidarchitecture.api.GithubApi
import com.tistory.black_jin0427.myandroidarchitecture.constant.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {

    //GithubAPi
    single {

        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(GithubApi::class.java)

    }

    // OkHttpClient
    single {

        // 네트뭐크 통신에 사용할 클라이언트 객체를 생성합니다.
        // 이 클라이언트를 통해 오고 가는 네트워크 요청/응답을 로그로 표시하도록 합니다.
        OkHttpClient.Builder().addInterceptor(get() as HttpLoggingInterceptor).build()

    }

    // HttpLoggingInterceptor
    single {

        // 네트워크 요청/응답을 로그에 표시하는 Interceptor 객체를 생성합니다.
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    }

}