package com.xcxgf.cainiao.POJO;

/**
 * 园区各楼栋房间的实体类
 */
public class Room {
    private String buildingName; // 所属办公楼
    private String roomNumber; // 房间号
    private String owner; // 业主
    private String rentArea; // 计租面积
    private String buildingArea; // 建筑面积
    private String roomType; // 房间类型
    private String insertTime; // 添加时间
    private String updateTime; // 修改时间

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRentArea() {
        return rentArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }

    public String getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(String buildingArea) {
        this.buildingArea = buildingArea;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
