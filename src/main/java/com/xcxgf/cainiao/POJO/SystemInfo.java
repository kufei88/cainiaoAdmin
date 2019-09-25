package com.xcxgf.cainiao.POJO;

public class SystemInfo {
    private int id;
    private float waterUnitPrice;//水单价
    private float electricityUnitPrice;//电单价
    private float leaseUnitPrice;//管理单价
    private float energySharingPrice;//能耗公摊单价
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWaterUnitPrice() {
        return waterUnitPrice;
    }

    public void setWaterUnitPrice(float waterUnitPrice) {
        this.waterUnitPrice = waterUnitPrice;
    }

    public float getElectricityUnitPrice() {
        return electricityUnitPrice;
    }

    public void setElectricityUnitPrice(float electricityUnitPrice) {
        this.electricityUnitPrice = electricityUnitPrice;
    }

    public float getLeaseUnitPrice() {
        return leaseUnitPrice;
    }

    public void setLeaseUnitPrice(float leaseUnitPrice) {
        this.leaseUnitPrice = leaseUnitPrice;
    }

    public float getEnergySharingPrice() {
        return energySharingPrice;
    }

    public void setEnergySharingPrice(float energySharingPrice) {
        this.energySharingPrice = energySharingPrice;
    }


}
