package com.tistory.black_jin0427.myandroidarchitecture.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Picture implements Serializable {

    @SerializedName("large") public String large;

    @SerializedName("medium") public String medium;

    @SerializedName("thumbnail") public String thumbnail;
}
