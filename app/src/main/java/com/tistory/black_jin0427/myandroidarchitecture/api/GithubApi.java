package com.tistory.black_jin0427.myandroidarchitecture.api;

import com.tistory.black_jin0427.myandroidarchitecture.api.model.UserResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GithubApi {

    @GET
    Observable<UserResponse> getUserList(@Url String url);
}
