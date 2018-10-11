package com.tistory.black_jin0427.myandroidarchitecture.view.main;

import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public interface MainContract {

    interface View {

        void showProgress();

        void hideProgress();

        void showToast(String message);

        void setItems(ArrayList<User> items);

        void updateView(User user);

    }

    interface Presenter {

        void loadData(CompositeDisposable disposable);

        void setRxEvent(CompositeDisposable disposable);
    }
}
