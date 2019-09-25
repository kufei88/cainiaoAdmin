package com.xcxgf.cainiao.POJO;

/**
 * 租赁缴费的实体类
 */
public class LeaseCost {

    private String owner; // 业主
    private String roomNumber; // 房间号
    private String buildingName; // 所属楼栋名称
    private String unitPrice; // 租金单价
    private String period; // 租期周期
    private String rentCost; // 租期应付总额
    private String propertyFee; // 租期应付物业费
    private String energySharing; // 能耗公摊
    private String totalCost; // 租费合计
    private String isChangeOwner; // 变更业主
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

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getRentCost() {
        return rentCost;
    }

    public void setRentCost(String rentCost) {
        this.rentCost = rentCost;
    }

    public String getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(String propertyFee) {
        this.propertyFee = propertyFee;
    }

    public String getEnergySharing() {
        return energySharing;
    }

    public void setEnergySharing(String energySharing) {
        this.energySharing = energySharing;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getIsChangeOwner() {
        return isChangeOwner;
    }

    public void setIsChangeOwner(String isChangeOwner) {
        this.isChangeOwner = isChangeOwner;
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
