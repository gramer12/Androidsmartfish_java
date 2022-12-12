package com.example.myapplication;

import android.graphics.drawable.Drawable;

public class UserInfo1 {
    private String date;
    private String time;
    private String temper;
    private String ph;
    private String light;
    private String Fishbowl;

    public UserInfo1(String date, String time, String temper, String ph, String light, String fishbowl) {
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