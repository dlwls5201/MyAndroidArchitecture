package com.tistory.black_jin0427.myandroidarchitecture.api.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

//테이블 이를을 설정합니다.
//데이터베이스에 저장할 데이터의 형식을 정합니다.
@Entity(tableName = "userTable")
public class User implements Serializable {

    // Entity 클래스의 field 가 object 인 경우 @Embeded 를 설정해 줍니다.
    @Embedded
    @SerializedName("gender") public String gender;

    @Embedded
    @SerializedName("name") public Name name;

    @Embedded
    @SerializedName("location") public Location location;

    @Embedded
    @SerializedName("login") public Login login;

    @Embedded
    @SerializedName("picture") public Picture picture;

    // email 값을 Primary Key 롤 설정하였습니다.
    // Primary Key 는 @NonNull 을 필수로 설정해 주어야 합니다.
    @SerializedName("email")
    @PrimaryKey
    @NonNull
    public String email;

    @SerializedName("phone") public String phone;

    @SerializedName("cell") public String cell;

    public int likeCnt = 0;

    public String getFullName() { return name.title + "." + name.first + " " + name.last; }

    public String getLikeCnt() { return "Like : " + likeCnt; }

    @Override
    public String toString() {
        return getFullName();
    }
}
