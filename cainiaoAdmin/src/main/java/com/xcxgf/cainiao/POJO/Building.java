package com.xcxgf.cainiao.POJO;

public class Building {
    private int id;
    private String buildingNumber;
    private String buildingName;
    private String roomArea;
    private String hardwareSituation;
    private String rent;
    private String additionalConditions;
    private int state;

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

    public String getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(String roomArea) {
        this.roomArea = roomArea;
    }

    public String getHardwareSituation() {
        return hardwareSituation;
    }

    public void setHardwareSituation(String hardwareSituation) {
        this.hardwareSituation = hardwareSituation;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getAdditionalConditions() {
        return additionalConditions;
    }

    public void setAdditionalConditions(String additionalConditions) {
        this.additionalConditions = additionalConditions;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
