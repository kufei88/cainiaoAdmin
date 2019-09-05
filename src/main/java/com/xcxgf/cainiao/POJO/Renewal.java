package com.xcxgf.cainiao.POJO;

public class Renewal {
    private int id;
    private int dormitoryMid;
    private String startDate;
    private String endDate;
    private String leasePeriod;
    private String remark;
    public int getId(){ return id; }
    public void setId(int id){this.id=id;}
    public int getDormitoryMid(){return dormitoryMid;}
    public void setDormitoryMid(int dormitoryMid){this.dormitoryMid=dormitoryMid;}
    public String getStartDate(){return startDate;}
    public void setStartDate(String startDate){this.startDate=startDate;}
    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public String getLeasePeriod(){return leasePeriod;}
    public void setLeasePeriod(String leasePeriod){this.leasePeriod=leasePeriod;}
    public String getRemark(){return remark;}
    public void setRemark(String remark){this.remark=remark;}
}
