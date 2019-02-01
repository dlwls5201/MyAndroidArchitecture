package com.tistory.black_jin0427.myandroidarchitecture.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Location implements Serializable {

    @SerializedName("street") public String street;

    @SerializedName("city") public String city;

    @SerializedName("state") public String state;

    @SerializedName("postcode") public String postcode;

}
