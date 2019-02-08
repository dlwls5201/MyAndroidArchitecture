package com.tistory.black_jin0427.myandroidarchitecture.di;

import com.tistory.black_jin0427.myandroidarchitecture.di.ui.DetailModule;
import com.tistory.black_jin0427.myandroidarchitecture.di.ui.MainModule;
import com.tistory.black_jin0427.myandroidarchitecture.di.ui.RecentModule;
import com.tistory.black_jin0427.myandroidarchitecture.view.detail.DetailActivity;
import com.tistory.black_jin0427.myandroidarchitecture.view.main.MainActivity;
import com.tistory.black_jin0427.myandroidarchitecture.view.recent.RecentActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 *  객체 그래프에 추가할 엑티비티는 해당 엑티비티를 반환하는 함수에
 *  @ContributesAndroidInjector 어노테이션을 추가하여 선언합니다.
 */
@Module
abstract class ActivityBinder {

    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {DetailModule.class})
    abstract DetailActivity bindDetailActivity();

    @ContributesAndroidInjector(modules = {RecentModule.class})
    abstract RecentActivity bindRecentActivity();
}
