package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Renewal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RenewalMapper {
    @Select("select * from renewals where dormitoryMid=#{dormitoryMid} order by endDate desc")
    public List<Renewal> getRenewalList(int dormitoryMid);
    @Select("select count(*) from renewals where dormitoryMid=#{dormitoryMid}  ")
    public int getCount(int dormitoryMid);

    @Insert("insert into renewals (dormitoryMid,startDate,endDate,leasePeriod,remark) " +
            "values(#{dormitoryMid}," +
            "#{startDate}," +
            "#{endDate}," +
            "#{leasePeriod}," +
            "#{remark})")
    public int insertRenewals(Renewal entityReneweal);
}
