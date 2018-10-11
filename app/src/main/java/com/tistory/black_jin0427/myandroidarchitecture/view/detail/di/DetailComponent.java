package com.tistory.black_jin0427.myandroidarchitecture.view.detail.di;

import com.tistory.black_jin0427.myandroidarchitecture.utils.PerActivity;
import com.tistory.black_jin0427.myandroidarchitecture.view.detail.DetailActivity;

import dagger.Component;

@PerActivity
@Component(modules = DetailModule.class)
public interface DetailComponent {

    void injectDetail(DetailActivity activity);
}
