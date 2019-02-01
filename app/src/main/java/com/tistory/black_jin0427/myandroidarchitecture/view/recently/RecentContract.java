package com.tistory.black_jin0427.myandroidarchitecture.view.recently;

import com.tistory.black_jin0427.myandroidarchitecture.BasePresenter;
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.room.UserDao;

import java.util.ArrayList;

public interface RecentContract {

    interface View {

        void showProgress();

        void hideProgress();

        void setItems(ArrayList<User> items);
    }

    interface Presenter extends BasePresenter<RecentContract.View> {

        @Override
        void setView(View view);

        @Override
        void releaseView();

        void loadData(UserDao userDao);

        void deleteData(UserDao userDao, User user);

        void clearAll(UserDao userDao);
    }
}
