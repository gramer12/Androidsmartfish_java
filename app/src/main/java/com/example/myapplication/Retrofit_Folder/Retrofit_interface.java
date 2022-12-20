package com.example.myapplication.Retrofit_Folder;

import com.example.myapplication.Data_Folder.AlldataList;
import com.example.myapplication.Data_Folder.DataList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Retrofit_interface {
    //    @GET("posts/{UserID}")
//    Call<data_model> test_api_get(
//            @Path("UserID") String userid);
    //deviceAPI/deviceGet
    @GET("deviceAPI/deviceGet")
            Call<List<AlldataList>> getAllPhotos();

    @GET("api/data/{sensorName}")
    Call<List<DataList>> getSensorData(
            @Path("sensorName") String sensorName);
}
