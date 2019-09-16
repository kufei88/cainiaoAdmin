package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Renewal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RenewalMapper {
    @Select("select * from dormitorycontinueinfo where contractId=#{dormitoryMid} order by continueEndTime desc")
    public List<Renewal> getRenewalList(int dormitoryMid);

    @Select("select count(*) from dormitorycontinueinfo where contractId=#{dormitoryMid}  ")
    public int getCount(int dormitoryMid);

    @Insert("insert into dormitorycontinueinfo (contractId," +
            "continueStartTime," +
            "continueEndTime," +
            "continuePeriod," +
            "totalCost," +
            "insertTime) " +
            "values(#{contractId}," +
            "#{continueStartTime}," +
            "#{continueEndTime}," +
            "#{continuePeriod}," +
            "#{totalCost}," +
            "#{insertTime})")
    public int insertRenewals(Renewal entityReneweal);

    @Delete("delete from renewals where dormitoryMid=#{dormitoryMid}")
    public int deleteRenewal(int dormitoryMid);
}
