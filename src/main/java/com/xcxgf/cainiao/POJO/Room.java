package com.xcxgf.cainiao.POJO;

public class Room {
    private int id;
    /**
     * roomNumber 房间号
     */
    private String roomNumber;
    /**
     * 办公楼名称
     */
    private String buildingName;
    /**
     * 计租面积
     */
    private String rentArea;
    /**
     * 建筑面积
     */
    private String builtUpArea;
    /**
     * 业主
     */
    private String owner;
    /**
     * 记录状态
     */
    private int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRentArea() {
        return rentArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }

    public String getBuiltUpArea() {
        return builtUpArea;
    }

    public void setBuiltUpArea(String builtUpArea) {
        this.builtUpArea = builtUpArea;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
