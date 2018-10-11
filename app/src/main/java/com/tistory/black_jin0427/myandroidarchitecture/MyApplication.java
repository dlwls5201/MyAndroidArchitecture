package com.tistory.black_jin0427.myandroidarchitecture;

import android.app.Application;

import com.tistory.black_jin0427.myandroidarchitecture.constant.Constant;
import com.tistory.black_jin0427.myandroidarchitecture.di.component.DaggerNetComponent;
import com.tistory.black_jin0427.myandroidarchitecture.di.component.NetComponent;
import com.tistory.black_jin0427.myandroidarchitecture.di.module.ApplicationModule;
import com.tistory.black_jin0427.myandroidarchitecture.di.module.NetModule;


public class MyApplication extends Application {

    private NetComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        initNetComponent();
    }

    private void initNetComponent() {

        component = DaggerNetComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule(Constant.BASE_URL))
                .build();
    }

    public NetComponent getNetComponent() {
        return component;
    }
}
