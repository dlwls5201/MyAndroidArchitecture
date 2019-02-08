package com.tistory.black_jin0427.myandroidarchitecture.room;

import android.arch.persistence.room.Room;
import android.content.Context;


/**
 *  Dagger 사용을 사용함으로서 필요성이 없어짐
 */
// 싱글톤 패턴을 사용하여 데이터베이스 객체를 제공합니다.
public class UserDatabaseProvider {

   /* private volatile static UserDatabase INSTANCE = null;

    private UserDatabaseProvider() {}

    public static UserDatabase getInstance(Context context) {

        if(INSTANCE == null) {
          synchronized (UserDatabase.class) {
            INSTANCE = Room.databaseBuilder(
                    context,
                    UserDatabase.class,
                    "black_jin.db")
                    .build();
          }
        }

        return INSTANCE;
    }*/
}
