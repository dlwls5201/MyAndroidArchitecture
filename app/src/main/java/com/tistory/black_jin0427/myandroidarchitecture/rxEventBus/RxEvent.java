package com.tistory.black_jin0427.myandroidarchitecture.rxEventBus;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

//https://blog.fobid.me/2
public class RxEvent {

    private static RxEvent instance;
    private PublishSubject<Object> mSubject;

    private RxEvent() {
        mSubject = PublishSubject.create();
    }

    public static RxEvent getInstance() {
        if(instance == null) instance = new RxEvent();
        return instance;
    }

    public void sendEvent(Object object) { mSubject.onNext(object); }

    public Observable<Object> getObservable() { return mSubject; }

}
