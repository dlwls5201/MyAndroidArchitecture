package com.tistory.black_jin0427.myandroidarchitecture.api.model

import com.google.gson.annotations.SerializedName

import java.io.Serializable

data class Location(

    @SerializedName("street")
    var street: String?,

    @SerializedName("city")
    var city: String?,

    @SerializedName("state")
    var state: String?,

    @SerializedName("postcode")
    var postcode: String?

) : Serializable
