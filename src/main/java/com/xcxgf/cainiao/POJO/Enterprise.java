package com.xcxgf.cainiao.POJO;

/**
 * 园区企业的实体类
 *
 * @author zyz
 */
public class Enterprise {
    /**
     * 公司名称
     */
    private String enterpriseName;
    /**
     * 联系人
     */
    private String enterprisePerson;
    /**
     * 联系电话
     */
    private String contactNumber;
    /**
     * 添加时间
     */
    private String insertTime;
    /**
     * 修改时间
     */
    private String updateTime;
    /**
     * 企业登记状态，未注册，已注册，已入驻
     */
    private String state;
    /**
     * 备注信息
     */
    private String other;

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

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
