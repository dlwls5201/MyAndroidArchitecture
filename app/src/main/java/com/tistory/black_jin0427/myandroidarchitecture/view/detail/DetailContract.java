package com.tistory.black_jin0427.myandroidarchitecture.view.detail;

import com.tistory.black_jin0427.myandroidarchitecture.BasePresenter;
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.room.UserDao;

public interface DetailContract {

    interface View {

        void setText(String text);
    }

    interface Presenter extends BasePresenter<DetailContract.View> {

        @Override
        void setView(DetailContract.View view);

        @Override
        void releaseView();

        // UserDao 값을 추가 인자로 보내줍니다.
        void clickEvent(UserDao userDao, User user);
    }
}
