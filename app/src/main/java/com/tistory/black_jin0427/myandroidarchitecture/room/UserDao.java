package com.tistory.black_jin0427.myandroidarchitecture.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tistory.black_jin0427.myandroidarchitecture.api.model.User;

import java.util.List;

import io.reactivex.Flowable;

// 데이터 접근 객체를 생성합니다.
@Dao
public interface UserDao {

    // 데이터베이스에 저장소를 추가합니다.
    // 이미 저장된 항목이 있을 경우 데이터를 덮어씁니다.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(User user);

    //해당 데이터를 삭제합니다.
    @Delete
    void delete(User user);

    // 저장되어 있는 저장소 목록을 반환합니다.
    // Flowable 형태의 자료를 반환하므로, 데이터베이스가 변경되면 알림을 받아 새로운 자료를 가져옵니다.
    // 따라서 항상 최신 자료를 유지합니다.
    @Query("SELECT * FROM userTable")
    Flowable<List<User>> getUser();

    // repositories 테이블의 모든 데이터를 삭제합니다.
    @Query("DELETE FROM userTable")
    void clearAll();
}
