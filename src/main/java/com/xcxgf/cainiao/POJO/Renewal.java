package com.xcxgf.cainiao.POJO;

public class Renewal {
    private int id;
    private int contractId;
    private String continueStartTime;
    private String continueEndTime;
    private int continuePeriod;
    private float totalCost;
    private String insertTime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContinueStartTime() {
        return continueStartTime;
    }

    public void setContinueStartTime(String continueStartTime) {
        this.continueStartTime = continueStartTime;
    }

    public String getContinueEndTime() {
        return continueEndTime;
    }

    public void setContinueEndTime(String continueEndTime) {
        this.continueEndTime = continueEndTime;
    }

    public int getContinuePeriod() {
        return continuePeriod;
    }

    public void setContinuePeriod(int continuePeriod) {
        this.continuePeriod = continuePeriod;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }


    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }
}
