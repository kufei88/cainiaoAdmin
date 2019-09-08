package com.xcxgf.cainiao.POJO;

import java.util.Date;

public class PaymentInfo {
    private int id;
    private StringBuffer startTime;

    public StringBuffer getStartTime() {
        return startTime;
    }

    public void setStartTime(StringBuffer startTime) {
        this.startTime = startTime;
    }

    public StringBuffer getEndTime() {
        return endTime;
    }

    public void setEndTime(StringBuffer endTime) {
        this.endTime = endTime;
    }

    private StringBuffer endTime;

    public float getWaterNumber() {
        return WaterNumber;
    }

    public void setWaterNumber(float waterNumber) {
        WaterNumber = waterNumber;
    }

    public float getElectricityNumber() {
        return ElectricityNumber;
    }

    public void setElectricityNumber(float electricityNumber) {
        ElectricityNumber = electricityNumber;
    }

    private float WaterNumber;
    private float ElectricityNumber;
    private String EnterpriseNumber;
    private String RoomNumber;
    public String getRoomNumber() {
        return RoomNumber;
    }
    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }
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

}
