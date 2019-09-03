package com.xcxgf.cainiao.POJO;

public class Building {
    private int id; // id标识
    private String buildingNumber; // 办公楼楼号
    private String buildingName; // 办公楼名称
    private int state; // 记录状态，1为可用，-1为不可用

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
