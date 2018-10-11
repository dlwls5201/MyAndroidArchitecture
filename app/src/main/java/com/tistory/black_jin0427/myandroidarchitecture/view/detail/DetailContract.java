package com.tistory.black_jin0427.myandroidarchitecture.view.detail;

import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;

public interface DetailContract {

    interface View {

        void setText(String text);
    }

    interface Presenter {

        void clickEvent(User user);
    }
}
