package com.tistory.black_jin0427.myandroidarchitecture;

import com.tistory.black_jin0427.myandroidarchitecture.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

// DaggerApplication 을 상속합니다.
public class MyApplication extends DaggerApplication {

    // DaggerAppComponent 의 인스턴스를 반환합니다.
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
