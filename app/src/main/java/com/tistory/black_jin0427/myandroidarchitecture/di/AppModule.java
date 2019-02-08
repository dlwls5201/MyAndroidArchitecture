package com.tistory.black_jin0427.myandroidarchitecture.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

    // 애플리케이션의 컨텍스트를 제공합니다.
    // 다른 컨텍스트와의 혼동을 방지하기 위해 "appContext"라는 이름으로 구분합니다.
    @Provides
    @Named("appContext")
    @Singleton
    Context provideContext(Application application) {
        return application.getApplicationContext();
    }
}
