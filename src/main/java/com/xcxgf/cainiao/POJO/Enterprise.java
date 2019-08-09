package com.xcxgf.cainiao.POJO;

public class Enterprise {
    private int Id;
    private String enterpriseName;
    private String enterprisePerson;
    private String enterpriseTelphone;
    private int state;

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

    public String getEnterpriseTelphone() {
        return enterpriseTelphone;
    }

    public void setEnterpriseTelphone(String enterpriseTelphone) {
        this.enterpriseTelphone = enterpriseTelphone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
