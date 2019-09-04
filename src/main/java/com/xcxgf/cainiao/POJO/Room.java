package com.xcxgf.cainiao.POJO;

/**
 * 办公室的实体类
 */
public class Room {
    private int id; // id标识
    private String roomNumber; // 办公室房间号
    private String buildingName; // 所属办公楼
    private String rentArea; // 计租面积
    private String builtUpArea; // 建筑面积
    private String owner; // 业主
    private int state; // 记录状态，1为可用，-1为不可用

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
