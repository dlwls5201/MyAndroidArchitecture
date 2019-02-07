package com.tistory.black_jin0427.myandroidarchitecture.view.main;

import com.tistory.black_jin0427.myandroidarchitecture.BasePresenter;
import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public interface MainContract {

    interface View {

        void showProgress();

        void hideProgress();

        void showToast(String message);

        // 아이템을 어댑터에 연결해 줍니다.
        void setItems(ArrayList<User> items);

        // 단일 아이템에 변경되었음을 알려줍니다.
        void updateView(User user);

    }

    interface Presenter extends BasePresenter<MainContract.View> {

        @Override
        void setView(View view);

        @Override
        void releaseView();

        // API 통신을 통해 데이터를 받아옵니다.
        void loadData();

        // RxEventBus 를 연결하여 Like 값을 동기화 해줍니다.
        void setRxEvent();
    }
}
