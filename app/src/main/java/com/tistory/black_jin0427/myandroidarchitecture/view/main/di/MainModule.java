package com.tistory.black_jin0427.myandroidarchitecture.view.main.di;
import com.tistory.black_jin0427.myandroidarchitecture.utils.PerActivity;
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
    @PerActivity
    MainContract.View provideMainContractView() {
        return view;
    }

}
