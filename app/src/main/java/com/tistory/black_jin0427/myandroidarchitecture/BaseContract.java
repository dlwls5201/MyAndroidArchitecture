package com.tistory.black_jin0427.myandroidarchitecture;

public class BaseContract {

    //View 와 Presenter 는 1:1로 연결되기 때문에 뷰의 연결과 해제를 위한 함수를 정해줍니다.
    public interface Presenter<T> {

        void setView(T view);

        void releaseView();
    }

    //View 의 공용 함수가 필요한 경우 정해줍니다.
    public interface View {

    }
}
