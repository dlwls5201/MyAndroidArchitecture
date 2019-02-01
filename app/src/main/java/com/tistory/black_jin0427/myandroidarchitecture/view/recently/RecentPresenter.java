package com.tistory.black_jin0427.myandroidarchitecture.view.recently;

public class RecentPresenter implements RecentContract.Presenter {

    RecentContract.View view;

    @Override
    public void setView(RecentContract.View view) {
        this.view = view;
    }

    @Override
    public void releaseView() {

    }
}
