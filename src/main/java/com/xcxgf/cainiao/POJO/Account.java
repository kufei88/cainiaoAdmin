package com.xcxgf.cainiao.POJO;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private String companyName;
    private String contact;
    private String contactNumber;
    private String dormitoryNum;
    private String contractSigning;
    private String startDate;
    private String endDate;
    private String leasePeriod;
    private String remark;
    private List<SelectDatas> selectdatas;
    public int getId(){ return id; }
    public void setId(int id){this.id=id;}
    public String getCompanyName(){ return companyName; }
    public void setCompanyName(String companyName){ this.companyName=companyName; }
    public String getContact(){return contact;}
    public void setContact(String contact){this.contact=contact;}
    public String getContactNumber(){return contactNumber;}
    public void setContactNumber(String contactNumber){this.contactNumber=contactNumber;}
    public String getDormitoryNum(){return dormitoryNum;}
    public void setDormitoryNum(String venueNumber){this.dormitoryNum=venueNumber;}
    public String getContractSigning(){return contractSigning;}
    public void setContractSigning(String contractSigning){this.contractSigning=contractSigning;}
    public String getStartDate(){return startDate;}
    public void setStartDate(String startDate){this.startDate=startDate;}
    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public String getLeasePeriod(){return leasePeriod;}
    public void setLeasePeriod(String leasePeriod){this.leasePeriod=leasePeriod;}
    public String getRemark(){return remark;}
    public void setRemark(String remark){this.remark=remark;}

    public List<SelectDatas> getSelectdatas() {
        return selectdatas;
    }

    public void setSelectdatas(List<SelectDatas> selectdatas) {
        this.selectdatas = selectdatas;
    }
}
