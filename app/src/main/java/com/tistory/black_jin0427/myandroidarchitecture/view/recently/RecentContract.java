package com.tistory.black_jin0427.myandroidarchitecture.view.recently;

import com.tistory.black_jin0427.myandroidarchitecture.BasePresenter;

public interface RecentContract {

    interface View {

        void showProgress();

        void hideProgress();

        void showToast(String message);

    }

    interface Presenter extends BasePresenter<RecentContract.View> {

        @Override
        void setView(View view);

        @Override
        void releaseView();
    }
}
