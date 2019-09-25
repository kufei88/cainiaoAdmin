package com.xcxgf.cainiao.POJO;


/**
 * 合同登记实体类
 */
public class LeaseContract {
    private String owner; // 业主
    private String roomNumber; // 房号
    private String buildingName; // 所属楼栋名称
    private String depositOnContracts; // 合同保证金
    private String rentPeriod; // 租期
    private String startRentTime; // 起租期
    private String endRentTime; // 终止期
    private String noPayPeriod; // 未缴费租期
    private String totalRent; // 租金总计
    private String firstRent; // 首期租金
    private String insertTime; // 添加时间
    private String updateTime; // 修改时间


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public String getDepositOnContracts() {
        return depositOnContracts;
    }

    public void setDepositOnContracts(String depositOnContracts) {
        this.depositOnContracts = depositOnContracts;
    }

    public String getRentPeriod() {
        return rentPeriod;
    }

    public void setRentPeriod(String rentPeriod) {
        this.rentPeriod = rentPeriod;
    }

    public String getStartRentTime() {
        return startRentTime;
    }

    public void setStartRentTime(String startRentTime) {
        this.startRentTime = startRentTime;
    }

    public String getEndRentTime() {
        return endRentTime;
    }

    public void setEndRentTime(String endRentTime) {
        this.endRentTime = endRentTime;
    }

    public String getNoPayPeriod() {
        return noPayPeriod;
    }

    public void setNoPayPeriod(String noPayPeriod) {
        this.noPayPeriod = noPayPeriod;
    }

    public String getTotalRent() {
        return totalRent;
    }

    public void setTotalRent(String totalRent) {
        this.totalRent = totalRent;
    }

    public String getFirstRent() {
        return firstRent;
    }

    public void setFirstRent(String firstRent) {
        this.firstRent = firstRent;
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
