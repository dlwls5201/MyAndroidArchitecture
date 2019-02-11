package com.tistory.black_jin0427.myandroidarchitecture.view.main;

import com.tistory.black_jin0427.myandroidarchitecture.BaseContract;
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;

import java.util.ArrayList;

public interface MainContract {

    interface View extends BaseContract.View {

        void showProgress();

        void hideProgress();

        void setItems(ArrayList<User> items);

        void updateView(User user);

    }

    interface Presenter extends BaseContract.Presenter<View> {

        @Override
        void setView(View view);

        @Override
        void releaseView();

        void loadData();

        void setRxEvent();

        void addUser(User user);
    }
}
