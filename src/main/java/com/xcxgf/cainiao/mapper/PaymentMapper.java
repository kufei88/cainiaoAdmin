package com.xcxgf.cainiao.mapper;


import com.xcxgf.cainiao.POJO.Hydropower;
import com.xcxgf.cainiao.POJO.HydropowerCost;
import com.xcxgf.cainiao.POJO.PaymentInfo;
import org.apache.ibatis.annotations.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PaymentMapper {
    //查询水电费数据
    @Select("select * from paymentInfo where Time LIKE CONCAT(#{Time},'%')")
    public List<PaymentInfo> getHydropowerCost(@Param("Time")String Time);
    //添加数据
    @Insert("insert into paymentInfo( WaterNumber, ElectricityNumber,EnterpriseNumber,roomNumber,startTime,endTime,establishTime) " +
            "values(#{WaterNumber}, #{ElectricityNumber}, #{EnterpriseNumber},#{roomNumber},#{startTime},#{endTime},#{establishTime})")
    public int insertPaymentInfo(
            @Param("WaterNumber")float WaterNumber,
            @Param("ElectricityNumber")float ElectricityNumber,
            @Param("EnterpriseNumber")String EnterpriseNumber,
            @Param("roomNumber")String roomNumber,
            @Param("startTime") String startTime,
            @Param("endTime") String endTime,
            @Param("establishTime") String establishTime);
    //更新数据
    @Update("update paymentInfo set " +
            "WaterNumber = #{WaterNumber},ElectricityNumber = #{ElectricityNumber}, " +
            "updateTime = #{updateTime} " +
            " where id = #{id}")
    public int updatePaymentInfo(
            @Param("id")int id,
            @Param("WaterNumber")float WaterNumber,
            @Param("ElectricityNumber")float ElectricityNumber,
            @Param("updateTime")String updateTime);
    //删除指定数据
    @Delete("delete from paymentInfo where id = #{id}")
    public int deletePaymentInfo(@Param("id")int id);
    //删除所有数据
    @Delete("delete from paymentInfo")
    public int deletePaymentInfoAll();

    //查询水/电价格数据
    @Select("select * from hydropower")
    public List<Hydropower> getHydropowerPaymentList();

    //更新水/电价格数据
    @Update("update hydropower set Water = #{Water},Electricity = #{Electricity} where id = 1")
    public int updateHydropowerPaymentInfo(@Param("Water")float Water,@Param("Electricity")float Electricity);

    //查询所有年份
    @Select("SELECT DISTINCT YEAR(startTime) FROM paymentInfo WHERE startTime order by YEAR(startTime) asc")
    public List<Long> getYearsList();

    //查询年份水费数据
    @Select("select SUM(waterCost) from paymentInfo WHERE startTime GROUP BY YEAR(startTime) order by YEAR(startTime) asc")
    public List<Float> getYearsWaterCostList();

    //查询年份电费数据
    @Select("select  SUM(electricityCost) from paymentInfo WHERE startTime GROUP BY YEAR(startTime) order by YEAR(startTime) asc")
    public List<Float> getYearsElectricityCostList();

    //查询本年月份
    @Select("SELECT DISTINCT MONTH(startTime) FROM paymentInfo WHERE startTime LIKE CONCAT(#{startTime},'%') order by MONTH(startTime) asc")
    public List<Long> getMonthList(@Param("startTime")String Time);

    //查询本年月份水费数据
    @Select("select  SUM(waterCost) from paymentInfo WHERE startTime LIKE CONCAT(#{startTime},'%') GROUP BY MONTH(startTime) order by MONTH(startTime) asc")
    public List<Float> getMonthWaterCostList(@Param("startTime")String Time);

    //查询本年月份电费数据
    @Select("select SUM(electricityCost) from paymentInfo WHERE startTime LIKE CONCAT(#{startTime},'%') GROUP BY MONTH(startTime) order by MONTH(startTime) asc")
    public List<Float> getMonthElectricityCostList(@Param("startTime")String Time);

    //查询本年季度
    @Select("SELECT DISTINCT QUARTER(startTime) FROM paymentInfo WHERE startTime LIKE CONCAT(#{startTime},'%') order by QUARTER(startTime) asc")
    public List<Long> getQuarterList(@Param("startTime")String Time);

    //查询本年季度水费数据
    @Select("select SUM(waterCost) from paymentInfo where YEAR(startTime) LIKE CONCAT(#{startTime},'%') GROUP BY QUARTER(startTime) order by QUARTER(startTime) asc")
    public List<Float> getQuarterWaterCostList(@Param("startTime")String Time);

    //查询本年季度电费数据
    @Select("select SUM(electricityCost) from paymentInfo where YEAR(startTime) LIKE CONCAT(#{startTime},'%') GROUP BY QUARTER(startTime) order by QUARTER(startTime) asc")
    public List<Float> getQuarterElectricityCostList(@Param("startTime")String Time);


    /**
     * 查询满足条件的可用记录
     *
     * @param establishTime 查询条件
     * @param limit  需要返回的记录的起始位置和终止位置
     * @return 类型的集合，满足条件的可用记录
     */
    @Select("select  * from paymentinfo where establishTime like CONCAT(#{establishTime},'%') ${limit};")
    public List<PaymentInfo> getPaymentList(@Param("establishTime")String establishTime, String limit);

    @Select("select  count(*) from paymentinfo where establishTime like CONCAT(#{establishTime},'%');")
    public int getCount(@Param("establishTime")String establishTime);


    //插入水电读数后的水电费 更新
    @Update("UPDATE paymentinfo SET " +
            "waterCost = (select waterCost from (select (WaterNumber * water) as waterCost from paymentinfo,hydropower WHERE paymentinfo.id = #{id}) as t)," +
            "electricityCost =(select electricityCost from (select (ElectricityNumber * electricity) as electricityCost from paymentinfo,hydropower WHERE paymentinfo.id = #{id}) as t)" +
            "WHERE id = #{id}")
    public int insertCost(@Param("id")int id);

    //查id
    @Select("select id from paymentinfo WHERE EnterpriseNumber = #{EnterpriseNumber} and roomNumber = #{roomNumber} and startTime = #{startTime} and  endTime = #{endTime}" )
    public HydropowerCost selectPaymentInfoId(@Param("EnterpriseNumber")String enterprise,@Param("roomNumber")String room,
                                              @Param("startTime") String startTime,
                                              @Param("endTime") String endTime);


}
