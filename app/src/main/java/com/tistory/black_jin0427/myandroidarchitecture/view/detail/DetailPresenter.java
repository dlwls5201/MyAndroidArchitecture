package com.tistory.black_jin0427.myandroidarchitecture.view.detail;

import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.rxEventBus.RxEvent;

import javax.inject.Inject;

public class DetailPresenter implements DetailContract.Presenter {

    DetailContract.View view;

    @Override
    public void setView(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void releaseView() {

    }

    @Override
    public void clickEvent(User user) {
        // Like 클릭시 발생하는 비즈니스 로직입니다.
        // User 객체의 LikeCnt 값을 늘려 줍니다.
        user.likeCnt++;

        // view 상태에 변화를 줍니다.
        view.setText(user.getLikeCnt());

        // RxEventBus 를 호출하여 MainActivity 에 변화가 생겼음을 알려줍니다.
        RxEvent.getInstance().sendEvent(user);
    }
}
