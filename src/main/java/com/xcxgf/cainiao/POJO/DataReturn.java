package com.xcxgf.cainiao.POJO;

import java.util.List;

public class DataReturn {
    private int dataCount;
    private List<Building> buildingList;
    private List<Room> roomList;
    private List<Enterprise> enterpriseList;
    private List<Lease> leaseList;


    public List<Building> getBuildingList() {
        return buildingList;
    }

    public void setBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(List<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public List<Lease> getLeaseList() {
        return leaseList;
    }

    public void setLeaseList(List<Lease> leaseList) {
        this.leaseList = leaseList;
    }
}
