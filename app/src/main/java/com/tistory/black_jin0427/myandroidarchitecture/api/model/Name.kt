package com.tistory.black_jin0427.myandroidarchitecture.api.model

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class Name  (

    @SerializedName("title")
    var title: String?,

    @SerializedName("first")
    var first: String?,

    @SerializedName("last")
    var last: String?

): Serializable
