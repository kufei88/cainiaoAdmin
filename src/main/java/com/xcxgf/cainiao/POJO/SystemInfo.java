package com.xcxgf.cainiao.POJO;

public class SystemInfo {
    private int id;
    private Float waterUnitPrice;//水单价
    private Float electricityUnitPrice;//电单价
    private Float leaseUnitPrice;//管理单价

    public Float getWaterUnitPrice() {
        return waterUnitPrice;
    }

    public void setWaterUnitPrice(Float waterUnitPrice) {
        this.waterUnitPrice = waterUnitPrice;
    }

    public Float getElectricityUnitPrice() {
        return electricityUnitPrice;
    }

    public void setElectricityUnitPrice(Float electricityUnitPrice) {
        this.electricityUnitPrice = electricityUnitPrice;
    }



    public Float getLeaseUnitPrice() {
        return leaseUnitPrice;
    }

    public void setLeaseUnitPrice(Float leaseUnitPrice) {
        this.leaseUnitPrice = leaseUnitPrice;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
