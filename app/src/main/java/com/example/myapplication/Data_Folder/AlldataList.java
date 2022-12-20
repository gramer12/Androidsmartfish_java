package com.example.myapplication.Data_Folder;

import com.google.gson.annotations.SerializedName;

public class AlldataList {
    @SerializedName("date")
    private String date;
    @SerializedName("time")
    private String time;
    @SerializedName("temper")
    private String temper;
    @SerializedName("ph")
    private String ph;
    @SerializedName("light")
    private String light;
    @SerializedName("Fishbowl")
    private String Fishbowl;

    public AlldataList(String date, String time, String temper, String ph, String light, String fishbowl) {
        this.date = date;
        this.time = time;
        this.temper = temper;
        this.ph = ph;
        this.light = light;
        this.Fishbowl = fishbowl;
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

    public String getTemper() {
        return temper;
    }

    public void setTemper(String temper) {
        this.temper = temper;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getFishbowl() {
        return Fishbowl;
    }

    public void setFishbowl(String fishbowl) {
        Fishbowl = fishbowl;
    }
}