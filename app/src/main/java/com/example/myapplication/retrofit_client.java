package com.example.myapplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit_client {

    //    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
private static final String BASE_URL = "http://61.103.243.89:8080/";
//    private static final String BASE_URL = "http://61.103.243.190:3000/";
//    private static final String BASE_URL = "http://192.168.1.106:3000/";


    private static Retrofit retrofit;
    // BaseUrl등록

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    // Json을 변환해줄 Gson변환기 등록
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public static Retrofit_interface getApiService() {
        return getInstance().create(Retrofit_interface.class);
    }


    private static Retrofit getInstance() {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
