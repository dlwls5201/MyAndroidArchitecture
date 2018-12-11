package com.tistory.black_jin0427.myandroidarchitecture.api.model

import com.google.gson.annotations.SerializedName

import java.io.Serializable

data class Picture (

    @SerializedName("large")
    var large: String?,

    @SerializedName("medium")
    var medium: String?,

    @SerializedName("thumbnail")
    var thumbnail: String?

) : Serializable
