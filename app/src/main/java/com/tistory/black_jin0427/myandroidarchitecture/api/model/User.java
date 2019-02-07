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

    // 적어도 한개의 PrimaryKey 가 존재해야 합니다.
    //@PrimaryKey(autoGenerate = true)
    //public int primaryKey;

    // Entity 클래스가 field 를 object 를 갖는 경우 @Embeded 를 사용합니다.
    @Embedded
    @SerializedName("gender") public String gender;

    @Embedded
    @SerializedName("name") public Name name;

    @Embedded
    @SerializedName("location") public Location location;

    @SerializedName("email")
    @PrimaryKey

    @NonNull    //You must annotate primary keys with @NonNull.
    public String email;

    @Embedded
    @SerializedName("login") public Login login;

    @SerializedName("phone") public String phone;

    @SerializedName("cell") public String cell;

    @Embedded
    @SerializedName("picture") public Picture picture;

    public int likeCnt = 0;

    public String getFullName() { return name.title + "." + name.first + " " + name.last; }

    public String getLikeCnt() { return "Like : " + likeCnt; }

    @Override
    public String toString() {
        return getFullName();
    }
}
