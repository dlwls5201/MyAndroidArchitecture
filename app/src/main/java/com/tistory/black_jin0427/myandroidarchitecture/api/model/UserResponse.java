package com.tistory.black_jin0427.myandroidarchitecture.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by me on 8/1/17.
 */

public class UserResponse {

    @SerializedName("results") public List<User> userList;

}
