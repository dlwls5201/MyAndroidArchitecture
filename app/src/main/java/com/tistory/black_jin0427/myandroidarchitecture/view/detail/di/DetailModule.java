package com.tistory.black_jin0427.myandroidarchitecture.view.detail.di;

import com.tistory.black_jin0427.myandroidarchitecture.utils.PerActivity;
import com.tistory.black_jin0427.myandroidarchitecture.view.detail.DetailContract;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {

    private final DetailContract.View view;

    public DetailModule(DetailContract.View view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    DetailContract.View provideDetailContractView() {
        return view;
    }
}
