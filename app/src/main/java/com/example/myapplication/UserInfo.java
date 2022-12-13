package com.example.myapplication;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("date")
    private String date;
    @SerializedName("time")
    private String time;
    @SerializedName("data")
    private String data;

//    @SerializedName("sensorName")
//    private String sensorName;

    public UserInfo(String date, String time, String data) {
        this.date = date;
        this.time = time;
        this.data = data;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



}