package com.xcxgf.cainiao.POJO;

/**
 * 园区企业的实体类
 */
public class Enterprise {
    private String enterpriseName; // 公司名称
    private String enterprisePerson; // 联系人
    private String contactNumber; // 联系电话
    private String insertTime; // 添加时间
    private String updateTime; // 修改时间
    private String state; // 企业登记状态，未注册，已注册，已入驻

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterprisePerson() {
        return enterprisePerson;
    }

    public void setEnterprisePerson(String enterprisePerson) {
        this.enterprisePerson = enterprisePerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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
