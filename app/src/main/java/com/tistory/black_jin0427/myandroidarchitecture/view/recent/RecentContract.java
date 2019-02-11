package com.tistory.black_jin0427.myandroidarchitecture.view.recent;

import com.tistory.black_jin0427.myandroidarchitecture.BaseContract;
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.room.UserDao;

import java.util.ArrayList;

public interface RecentContract {

    interface View extends BaseContract.View {

        void showProgress();

        void hideProgress();

        // Room 으로 부터 받은 데이터를 어댑터를 통해 보여줍니다.
        void setItems(ArrayList<User> items);
    }

    interface Presenter extends BaseContract.Presenter<View> {

        @Override
        void setView(View view);

        @Override
        void releaseView();

        // Room 으로 부터 데이터를 받아 옵니다.
        void loadData(UserDao userDao);

        // Room 데이터베이스에서 user 데이터 1개를 삭제합니다.
        void deleteData(UserDao userDao, User user);

        // Room 데이터를 전부 삭제 합니다.
        void clearAll(UserDao userDao);
    }
}
