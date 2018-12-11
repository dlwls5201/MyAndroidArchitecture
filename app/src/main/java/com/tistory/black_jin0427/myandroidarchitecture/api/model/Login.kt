package com.tistory.black_jin0427.myandroidarchitecture.api.model

import com.google.gson.annotations.SerializedName

import java.io.Serializable

data class Login(

    @SerializedName("username")
    var username: String?,

    @SerializedName("password")
    var password: String?,

    @SerializedName("salt")
    var salt: String?,

    @SerializedName("md5")
    var md5: String?,

    @SerializedName("sha1")
    var sha1: String?,

    @SerializedName("sha256")
    var sha256: String?

) : Serializable
