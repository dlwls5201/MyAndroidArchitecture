package com.tistory.black_jin0427.myandroidarchitecture.di;

import android.app.Application;

import com.tistory.black_jin0427.myandroidarchitecture.MyApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

// AppComponent 를 선언하면서 컴포넌트로 묶어둘 모듈을 추가합니다.
// 대거의 안드로이드 지원 모듈인 AndroidSupportInjectionModule 을 함께 추가합니다.
// AppComponent 는 AndroidInjector 인터페이스를 상속하도록 하며,
// 애플이케이션을 상속한 클래스인 MyApplication 을 타입 인자로 넣어줍니다.
//
// 대거의 안드로이드 특화 기능에 대해 더 자세한 내용이 궁금하신 분은 공식 홈페이지에서 확인해주세요
// https://google.github.io/dagger/android.html
@Singleton
@Component(modules = {
        AppModule.class, ApiModule.class, RoomModule.class,

        AndroidSupportInjectionModule.class,
        ActivityBinder.class
})
interface AppComponent extends AndroidInjector<MyApplication> {

    // AppComponent 를 생성할 때 사용할 빌더 클래스를 정의합니다.
    @Component.Builder
    interface Builder {

        // @BindsInstance 어노테이션으로 객체 그래프에 추가할 객체를 선언합니다.
        // 객체 그래프에 추가할 객체를 인자로 받고, 빌더 클래스를 반환하는 함수 형태로 선언합니다.
        @BindsInstance
        Builder application(Application app);

        // 빌더 클래스는 컴포넌트를 반환하는 build() 함수를 반드시 포함해야 합니다.
        AppComponent build();
    }
}
