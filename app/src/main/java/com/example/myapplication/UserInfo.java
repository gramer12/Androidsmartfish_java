package com.example.myapplication;

import android.graphics.drawable.Drawable;

public class UserInfo {
    private String name;
    private String age;
    private Drawable profile;
    private String about;

    public UserInfo(){}
    public UserInfo(String name, String age, Drawable profile, String about) {
        this.name = name;
        this.age = age;
        this.profile = profile;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Drawable getProfile() {
        return profile;
    }

    public void setProfile(Drawable profile) {
        this.profile = profile;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}