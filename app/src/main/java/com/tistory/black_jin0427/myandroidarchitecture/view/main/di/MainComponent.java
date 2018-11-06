package com.tistory.black_jin0427.myandroidarchitecture.view.main.di;

import com.tistory.black_jin0427.myandroidarchitecture.di.component.NetComponent;
import com.tistory.black_jin0427.myandroidarchitecture.view.main.di.MainModule;
import com.tistory.black_jin0427.myandroidarchitecture.utils.PerActivity;
import com.tistory.black_jin0427.myandroidarchitecture.view.main.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = NetComponent.class, modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity activity);
}
