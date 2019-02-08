package com.tistory.black_jin0427.myandroidarchitecture.di.ui;

import com.tistory.black_jin0427.myandroidarchitecture.adapter.MainAdapter;
import com.tistory.black_jin0427.myandroidarchitecture.api.GithubApi;
import com.tistory.black_jin0427.myandroidarchitecture.room.UserDao;
import com.tistory.black_jin0427.myandroidarchitecture.view.main.MainActivity;
import com.tistory.black_jin0427.myandroidarchitecture.view.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    MainAdapter provideMainAdapter(MainActivity activity) {
        MainAdapter adapter = new MainAdapter();
        adapter.setClickListener(activity);
        return adapter;
    }

    @Provides
    MainPresenter provideMainPresenter(MainActivity activity, UserDao userDao, GithubApi api) {
        MainPresenter presenter = new MainPresenter(userDao, api);
        presenter.setView(activity);
        return presenter;
    }
}
