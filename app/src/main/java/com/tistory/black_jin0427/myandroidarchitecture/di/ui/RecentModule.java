package com.tistory.black_jin0427.myandroidarchitecture.di.ui;

import com.tistory.black_jin0427.myandroidarchitecture.adapter.MainAdapter;
import com.tistory.black_jin0427.myandroidarchitecture.room.UserDao;
import com.tistory.black_jin0427.myandroidarchitecture.view.recent.RecentActivity;
import com.tistory.black_jin0427.myandroidarchitecture.view.recent.RecentPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class RecentModule {

    @Provides
    MainAdapter provideMainAdapter() {
        return new MainAdapter();
    }

    @Provides
    RecentPresenter provideRecentPresenter(RecentActivity activity, UserDao userDao) {
        RecentPresenter presenter = new RecentPresenter(userDao);
        presenter.setView(activity);
        return presenter;
    }
}
