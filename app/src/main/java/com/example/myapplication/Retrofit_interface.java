package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Retrofit_interface {
    //    @GET("posts/{UserID}")
//    Call<data_model> test_api_get(
//            @Path("UserID") String userid);
    @GET("api/hello")
            Call<List<UserInfo1>> getAllPhotos();
}
