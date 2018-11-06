package com.tistory.black_jin0427.myandroidarchitecture.di.component;

import com.tistory.black_jin0427.myandroidarchitecture.di.module.ApplicationModule;
import com.tistory.black_jin0427.myandroidarchitecture.di.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface NetComponent {

    Retrofit retrofit();
}
