package com.xcxgf.cainiao.POJO;

/**
 * 园区企业的实体类
 */
public class Enterprise {
    private int Id; // id标识
    private String enterpriseName; // 公司名称
    private String enterprisePerson; // 联系人
    private String contactNumber; // 联系电话
    private int state; // 记录状态，1为可用，-1为不可用

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
