package com.tistory.black_jin0427.myandroidarchitecture.di.component;

import com.tistory.black_jin0427.myandroidarchitecture.di.module.MainModule;
import com.tistory.black_jin0427.myandroidarchitecture.utils.CustomScope;
import com.tistory.black_jin0427.myandroidarchitecture.view.main.MainActivity;

import dagger.Component;

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity activity);
}
