package com.xcxgf.cainiao.POJO;

public class PaymentInfo {
    private int id;//id
    private String BuildingName;//楼栋名
    private String RoomNumber;//房号
    private String owner;//公司
    private float WaterNumber;//水表读数
    private float ElectricityNumber;//电表读数
    private float WaterNumberPrevious;//上期水表读数
    private float ElectricityNumberPrevious;//上期电表读数
    private float WaterDifference;//水差值
    private float ElectricityDifference;//电差值
    private float waterCost;//水费
    private float electricityCost;//电费
    private float total;//总金额
    private String startTime; //开始时间
    private String endTime;//结束时间
    private String establishTime;//创建时间
    private String updateTime;//更新时间

    public float getWaterNumberPrevious() {
        return WaterNumberPrevious;
    }

    public void setWaterNumberPrevious(float waterNumberPrevious) {
        WaterNumberPrevious = waterNumberPrevious;
    }

    public float getElectricityNumberPrevious() {
        return ElectricityNumberPrevious;
    }

    public void setElectricityNumberPrevious(float electricityNumberPrevious) {
        ElectricityNumberPrevious = electricityNumberPrevious;
    }

    public float getWaterDifference() {
        return WaterDifference;
    }

    public void setWaterDifference(float waterDifference) {
        WaterDifference = waterDifference;
    }

    public float getElectricityDifference() {
        return ElectricityDifference;
    }

    public void setElectricityDifference(float electricityDifference) {
        ElectricityDifference = electricityDifference;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }


    public String getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(String establishTime) {
        this.establishTime = establishTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public float getWaterCost() {
        return waterCost;
    }

    public void setWaterCost(float waterCost) {
        this.waterCost = waterCost;
    }

    public float getElectricityCost() {
        return electricityCost;
    }

    public void setElectricityCost(float electricityCost) {
        this.electricityCost = electricityCost;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBuildingName() {
        return BuildingName;
    }

    public void setBuildingName(String buildingName) {
        BuildingName = buildingName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

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

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
