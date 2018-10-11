package com.tistory.black_jin0427.myandroidarchitecture.di.module;

import com.tistory.black_jin0427.myandroidarchitecture.utils.CustomScope;
import com.tistory.black_jin0427.myandroidarchitecture.view.main.MainContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private final MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    @CustomScope
    MainContract.View provideMainContractView() {
        return view;
    }

}
