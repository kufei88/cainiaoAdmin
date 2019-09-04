package com.xcxgf.cainiao.POJO;

public class PaymentInfo {
    private int id;
    private String WaterNumber;
    private String ElectricityNumber;
    private String EnterpriseNumber;
    public String getEnterpriseNumber() {
        return EnterpriseNumber;
    }

    public void setEnterpriseNumber(String enterpriseNumber) {
        EnterpriseNumber = enterpriseNumber;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getWaterNumber() {
        return WaterNumber;
    }
    public void setWaterNumber(String waterNumber) {
        WaterNumber = waterNumber;
    }
    public String getElectricityNumber() {
        return ElectricityNumber;
    }
    public void setElectricityNumber(String electricityNumber) {
        ElectricityNumber = electricityNumber;
    }
}
