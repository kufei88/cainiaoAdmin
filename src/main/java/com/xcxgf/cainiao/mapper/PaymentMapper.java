package com.xcxgf.cainiao.mapper;


import com.xcxgf.cainiao.POJO.Hydropower;
import com.xcxgf.cainiao.POJO.PaymentInfo;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PaymentMapper {
    //查询所有数据
    @Select("select * from paymentInfo where Time LIKE CONCAT(#{Time},'%')")
    public List<PaymentInfo> getPaymentList(@Param("Time")String Time);
    //添加数据
    @Insert("insert into paymentInfo( WaterNumber, ElectricityNumber,EnterpriseNumber) values(#{WaterNumber}, #{ElectricityNumber}, #{EnterpriseNumber})")
    public int insertPaymentInfo(@Param("WaterNumber")String WaterNumber,@Param("ElectricityNumber")String ElectricityNumber,@Param("EnterpriseNumber")String EnterpriseNumber);
    //更新数据
    @Update("update paymentInfo set WaterNumber = #{WaterNumber},ElectricityNumber = #{ElectricityNumber}, EnterpriseNumber = #{EnterpriseNumber} where id = #{id}")
    public int updatePaymentInfo(@Param("id")int id,@Param("WaterNumber")String WaterNumber,@Param("ElectricityNumber")String ElectricityNumber,@Param("EnterpriseNumber")String EnterpriseNumber);
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
    @Select("SELECT DISTINCT YEAR(Time) FROM paymentinfo WHERE Time order by YEAR(Time) asc")
    public List<Long> getYearsList();

    //查询年份水费数据
    @Select("select sum(WaterNumber) as WaterNumber from paymentinfo WHERE Time GROUP BY YEAR(Time) order by YEAR(Time) asc")
    public List<Long> getYearsWaterCostList();

    //查询年份电费数据
    @Select("select sum( ElectricityNumber) as ElectricityNumber from paymentinfo WHERE Time GROUP BY YEAR(Time) order by YEAR(Time) asc")
    public List<Long> getYearsElectricityCostList();

    //查询本年月份
    @Select("SELECT DISTINCT MONTH(Time) FROM paymentinfo WHERE Time LIKE CONCAT(#{Time},'%') order by MONTH(Time) asc")
    public List<Long> getMonthList(@Param("Time")String Time);

    //查询本年月份水费数据
    @Select("select sum(WaterNumber) as WaterNumber from paymentinfo WHERE Time LIKE CONCAT(#{Time},'%') GROUP BY MONTH(Time) order by MONTH(Time) asc")
    public List<Long> getMonthWaterCostList(@Param("Time")String Time);

    //查询本年月份电费数据
    @Select("select sum( ElectricityNumber) as ElectricityNumber from paymentinfo WHERE Time LIKE CONCAT(#{Time},'%') GROUP BY MONTH(Time) order by MONTH(Time) asc")
    public List<Long> getMonthElectricityCostList(@Param("Time")String Time);

    //查询本年季度
    @Select("SELECT DISTINCT QUARTER(time) FROM paymentinfo WHERE Time LIKE CONCAT(#{Time},'%') order by QUARTER(time) asc")
    public List<Long> getQuarterList(@Param("Time")String Time);

    //查询本年季度水费数据
    @Select("SELECT sum(WaterNumber) as WaterNumber from paymentinfo where YEAR(time) LIKE CONCAT(#{Time},'%') GROUP BY QUARTER(time) order by QUARTER(Time) asc")
    public List<Long> getQuarterWaterCostList(@Param("Time")String Time);

    //查询本年季度电费数据
    @Select("SELECT sum( ElectricityNumber) as ElectricityNumber from paymentinfo where YEAR(time) LIKE CONCAT(#{Time},'%') GROUP BY QUARTER(time) order by QUARTER(Time) asc")
    public List<Long> getQuarterElectricityCostList(@Param("Time")String Time);

}
