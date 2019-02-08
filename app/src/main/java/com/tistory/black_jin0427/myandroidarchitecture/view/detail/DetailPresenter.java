package com.tistory.black_jin0427.myandroidarchitecture.view.detail;

import android.util.Log;

import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.room.UserDao;
import com.tistory.black_jin0427.myandroidarchitecture.rxEventBus.RxEvent;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class DetailPresenter implements DetailContract.Presenter {

    DetailContract.View view;

    private CompositeDisposable disposable;

    public DetailPresenter() {
        disposable = new CompositeDisposable();
    }

    @Override
    public void setView(DetailContract.View view) {
        this.view = view;
    }

    @Override
    public void releaseView() {
        disposable.clear();
    }

    @Override
    public void clickEvent(UserDao userDao, User user) {
        user.likeCnt++;
        view.setText(user.getLikeCnt());

        RxEvent.getInstance().sendEvent(user);

        // 유저 정보를 동기화 해줍니다.
        disposable.add(
                Observable.just(user)
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                item -> {
                                    Log.d("MyTag","item : " + item + " 업데이트");
                                    userDao.update(item);
                                },
                                error -> {
                                    Log.d("MyTag","업데이트 onError");
                                },
                                () -> {
                                    Log.d("MyTag","업데이트 onCompleted");
                                }
                        )
        );
    }
}
