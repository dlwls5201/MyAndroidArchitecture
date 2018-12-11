package com.tistory.black_jin0427.myandroidarchitecture.di

import com.tistory.black_jin0427.myandroidarchitecture.api.GithubApiProvider
import org.koin.dsl.module.module

val apiModule = module {

    single { GithubApiProvider() }
}