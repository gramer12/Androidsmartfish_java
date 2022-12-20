package com.example.myapplication.Data_Folder;

public class LogList {
   private String time;
   private  String logData;

    public LogList(String time, String logData) {
        this.time = time;
        this.logData = logData;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLogData() {
        return logData;
    }

    public void setLogData(String logData) {
        this.logData = logData;
    }
}