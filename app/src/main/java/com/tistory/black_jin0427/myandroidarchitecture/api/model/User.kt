package com.tistory.black_jin0427.myandroidarchitecture.api.model

import com.google.gson.annotations.SerializedName

import java.io.Serializable

data class User (

    @SerializedName("gender")
    var gender: String?,

    @SerializedName("name")
    var name: Name?,

    @SerializedName("location")
    var location: Location?,

    @SerializedName("email")
    var email: String?,

    @SerializedName("login")
    var login: Login?,

    @SerializedName("phone")
    var phone: String?,

    @SerializedName("cell")
    var cell: String?,

    @SerializedName("picture")
    var picture: Picture?,

    var likeCnt: Int = 0

): Serializable {

    val fullName: String
        get() = name?.title + "." + name?.first + " " + name?.last

}

