package com.tistory.black_jin0427.myandroidarchitecture.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;

// 데이터베이스에서 사용하는 엔티티와 버전을 지정합니다.
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    // 데이터베이스와 연결할 데이터 접근 객체를 정의합니다.
    public abstract UserDao getUserDao();
}
