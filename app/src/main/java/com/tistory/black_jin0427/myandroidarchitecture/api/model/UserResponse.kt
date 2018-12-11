package com.tistory.black_jin0427.myandroidarchitecture.api.model

import com.google.gson.annotations.SerializedName

data class UserResponse (
    @SerializedName("results")
    val userList: List<User>? = null
)
