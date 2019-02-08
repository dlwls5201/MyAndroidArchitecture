package com.tistory.black_jin0427.myandroidarchitecture.view.main;

import com.tistory.black_jin0427.myandroidarchitecture.BasePresenter;
import com.tistory.black_jin0427.myandroidarchitecture.api.GithubApi;
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.room.UserDao;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public interface MainContract {

    interface View {

        void showProgress();

        void hideProgress();

        void setItems(ArrayList<User> items);

        void updateView(User user);

    }

    interface Presenter extends BasePresenter<MainContract.View> {

        @Override
        void setView(View view);

        @Override
        void releaseView();

        void loadData();

        void setRxEvent();

        void addUser(User user);
    }
}
