package com.tistory.black_jin0427.myandroidarchitecture.view.recently;


import android.util.Log;

import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;
import com.tistory.black_jin0427.myandroidarchitecture.room.UserDao;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class RecentPresenter implements RecentContract.Presenter {

    private RecentContract.View view;

    private CompositeDisposable disposable;

    RecentPresenter() {
        this.disposable = new CompositeDisposable();
    }

    @Override
    public void setView(RecentContract.View view) {
        this.view = view;
    }

    @Override
    public void releaseView() {
        disposable.clear();
    }

    @Override
    public void loadData(UserDao userDao) {
        disposable.add(
                userDao.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(__ -> {
                    view.showProgress();
                })
                .doOnTerminate(() -> {
                    //동작 안됨
                })
                .doOnComplete(() -> {
                    //동작 안됨
                 })
                .subscribe(users -> {
                    view.setItems((ArrayList<User>)users);
                    view.hideProgress();
                }, error -> {
                    Log.e("MyTag", error.getMessage());
                })
        );

    }

    @Override
    public void deleteData(UserDao userDao, User user) {

        disposable.add(
                Observable.just(user)
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                item -> {
                                    Log.d("MyTag","item : " + item + " 삭제");
                                    userDao.delete(item);
                                },
                                error -> {
                                    Log.d("MyTag","onError");
                                },
                                () -> {
                                    Log.d("MyTag","onCompleted");
                                }
                        )
        );
    }

    @Override
    public void clearAll(UserDao userDao) {
        disposable.add(
                Observable.just("clear ALl")
                        .subscribeOn(Schedulers.io())
                        .subscribe(
                                item -> {
                                    Log.d("MyTag", item);
                                    userDao.clearAll();
                                },
                                error -> {
                                    Log.d("MyTag","onError");
                                },
                                () -> {
                                    Log.d("MyTag","onCompleted");
                                }
                        )
        );

    }
}
