package com.tistory.black_jin0427.myandroidarchitecture.view.detail;

import com.tistory.black_jin0427.myandroidarchitecture.BaseContract;
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.room.UserDao;

public interface DetailContract {

    interface View extends BaseContract.View {

        void setText(String text);
    }

    interface Presenter extends BaseContract.Presenter<View> {

        @Override
        void setView(DetailContract.View view);

        @Override
        void releaseView();

        // UserDao 값을 추가 인자로 보내줍니다.
        void clickEvent(UserDao userDao, User user);
    }
}
