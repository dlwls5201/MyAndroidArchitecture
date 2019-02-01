package com.tistory.black_jin0427.myandroidarchitecture;

public interface BasePresenter<T> {

    void setView(T view);

    void releaseView();

}
