package com.xcxgf.cainiao.POJO;


import java.sql.Timestamp;

public class Hydropower {
    private int id;
    private String Water;
    private String Electricity;
    private Long Time;
    public Long getTime() {
        return Time;
    }

    public void setTime(Long time) {
        Time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWater() {
        return Water;
    }

    public void setWater(String water) {
        Water = water;
    }

    public String getElectricity() {
        return Electricity;
    }

    public void setElectricity(String electricity) {
        Electricity = electricity;
    }


}

