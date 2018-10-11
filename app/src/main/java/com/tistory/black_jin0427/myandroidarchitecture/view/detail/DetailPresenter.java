package com.tistory.black_jin0427.myandroidarchitecture.view.detail;

import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.rxEventBus.RxEvent;

import javax.inject.Inject;

public class DetailPresenter implements DetailContract.Presenter {

    DetailContract.View view;

    @Inject
    DetailPresenter(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void clickEvent(User user) {
        user.likeCnt++;
        view.setText(user.getLikeCnt());

        RxEvent.getInstance().sendEvent(user);
    }
}
