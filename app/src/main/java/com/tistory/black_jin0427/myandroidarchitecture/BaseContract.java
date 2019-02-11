package com.tistory.black_jin0427.myandroidarchitecture;

public class BaseContract {

    public interface Presenter<T> {

        void setView(T view);

        void releaseView();
    }

    public interface  View {

    }
}
