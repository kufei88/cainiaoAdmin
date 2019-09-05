package com.xcxgf.cainiao.POJO;

import java.util.List;

/**
 * 请求返回数据的封装类，主要封装查询的记录集合，以及记录总条数
 */
public class DataReturn {
    private int dataCount; // 查询到的记录总条数
    private List<Building> buildingList; // 办公楼记录集合
    private List<Room> roomList; // 办公室记录集合
    private List<Enterprise> enterpriseList; // 园区企业记录集合
    private List<Lease> leaseList; // 租赁信息记录集合


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
