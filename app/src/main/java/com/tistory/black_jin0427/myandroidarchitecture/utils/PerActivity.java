package com.tistory.black_jin0427.myandroidarchitecture.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
    //Activity Life Cycle 에서만 사용할 수 있는 Scope
}
