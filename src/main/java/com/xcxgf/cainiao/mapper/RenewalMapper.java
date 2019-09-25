package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Account;
import com.xcxgf.cainiao.POJO.Renewal;
import com.xcxgf.cainiao.POJO.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RenewalMapper {
    @Select("select * from dormitorycontinueinfo where contractId=#{contractId} order by continueEndTime desc,insertTime desc")
    public List<Renewal> getRenewalList(String contractId);

    @Select("select count(*) from dormitorycontinueinfo where contractId=#{dormitoryMid}  ")
    public int getCount(int dormitoryMid);

    @Insert("insert into dormitorycontinueinfo (owner," +
            "contractId," +
            "contractType," +
            "continueStartTime," +
            "continueEndTime," +
            "continuePeriod," +
            "totalCost," +
            "insertTime) " +
            "values(#{owner}," +
            "#{contractId}," +
            "#{contractType}," +
            "#{continueStartTime}," +
            "#{continueEndTime}," +
            "#{continuePeriod}," +
            "#{totalCost}," +
            "#{insertTime})")
    public int insertRenewals(Renewal entityReneweal);

    @Update("update roominfo set owner=#{owner} where buildingName=#{buildingName} and roomNumber=#{roomNumber}")
    public int updateRoom(Room room);
}
