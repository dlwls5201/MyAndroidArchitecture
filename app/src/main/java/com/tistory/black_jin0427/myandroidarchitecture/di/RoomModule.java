package com.tistory.black_jin0427.myandroidarchitecture.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.tistory.black_jin0427.myandroidarchitecture.room.UserDao;
import com.tistory.black_jin0427.myandroidarchitecture.room.UserDatabase;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class RoomModule {

    @Provides
    @Singleton
    UserDao provideUserDao(UserDatabase db) {
        return db.getUserDao();
    }

    //  데이터베이스를 관리하는 객체인 UserDatabase 를 제공합니다.
    // "appContext" 라는 이름으로 구분되는 Context 객체를 필요로 합니다.
    @Provides
    @Singleton
    UserDatabase provideUserDatabase(@Named("appContext") Context context) {
        return Room.databaseBuilder(context, UserDatabase.class,
                "black_jin.db")
                .build();
    }
}
