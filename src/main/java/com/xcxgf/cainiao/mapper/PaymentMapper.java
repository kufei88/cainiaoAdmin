package com.xcxgf.cainiao.mapper;


import com.xcxgf.cainiao.POJO.PaymentInfo;
import com.xcxgf.cainiao.POJO.SystemInfo;
import org.apache.ibatis.annotations.*;


import java.util.List;


public interface PaymentMapper {

    //新增 
    @Insert("insert into systeminfo(waterUnitPrice,electricityUnitPrice,leaseUnitPrice) values(#{waterUnitPrice},#{electricityUnitPrice},#{leaseUnitPrice})")
    public int insertHydropowerPaymentData(SystemInfo systemInfo);
    //查询水电单价数据
    @Select("select * from paymentinfo where Time LIKE CONCAT(#{Time},'%')")
    public List<PaymentInfo> getHydropowerCost(@Param("Time")String Time);
    //添加数据
    @Insert("insert into paymentinfo( waterNumber, electricityNumber,owner,buildingName,roomNumber,startTime,endTime,establishTime) " +
            "values(#{WaterNumber}, #{ElectricityNumber}, #{owner},#{buildingName},#{roomNumber},#{startTime},#{endTime},#{establishTime})")
    public int insertPaymentInfo(PaymentInfo paymentInfo);
    //更新数据
    @Update("update paymentinfo set " +
            "WaterNumber = #{WaterNumber},ElectricityNumber = #{ElectricityNumber}, " +
            "updateTime = #{updateTime} " +
            " where id = #{id}")
    public int updatePaymentInfo(PaymentInfo paymentInfo);
    //删除指定数据
    @Delete("delete from paymentinfo where id = #{id}")
    public int deletePaymentInfo(@Param("id")int id);
    //删除所有数据
    @Delete("delete from paymentinfo")
    public int deletePaymentInfoAll();

    //查询后台设置数据
    @Select("select * from systeminfo")
    public List<SystemInfo> getHydropowerPaymentList();

    //更新后台设置数据
    @Update("update systeminfo set waterUnitPrice = #{waterUnitPrice},electricityUnitPrice = #{electricityUnitPrice},leaseUnitPrice=#{leaseUnitPrice} where id = 1")
    public int updateHydropowerPaymentInfo(SystemInfo systemInfo);

    //查询所有年份
    @Select("SELECT DISTINCT YEAR(startTime) FROM paymentinfo WHERE startTime order by YEAR(startTime) asc")
    public List<Long> getYearsList();

    //查询年份水费数据
    @Select("select SUM(waterCost) from paymentinfo WHERE startTime GROUP BY YEAR(startTime) order by YEAR(startTime) asc")
    public List<Float> getYearsWaterCostList();

    //查询年份电费数据
    @Select("select  SUM(electricityCost) from paymentinfo WHERE startTime GROUP BY YEAR(startTime) order by YEAR(startTime) asc")
    public List<Float> getYearsElectricityCostList();

    //查询本年月份
    @Select("SELECT DISTINCT MONTH(startTime) FROM paymentinfo WHERE startTime LIKE CONCAT(#{startTime},'%') order by MONTH(startTime) asc")
    public List<Long> getMonthList(@Param("startTime")String Time);

    //查询本年月份水费数据
    @Select("select  SUM(waterCost) from paymentinfo WHERE startTime LIKE CONCAT(#{startTime},'%') GROUP BY MONTH(startTime) order by MONTH(startTime) asc")
    public List<Float> getMonthWaterCostList(@Param("startTime")String Time);

    //查询本年月份电费数据
    @Select("select SUM(electricityCost) from paymentinfo WHERE startTime LIKE CONCAT(#{startTime},'%') GROUP BY MONTH(startTime) order by MONTH(startTime) asc")
    public List<Float> getMonthElectricityCostList(@Param("startTime")String Time);

    //查询本年季度
    @Select("SELECT DISTINCT QUARTER(startTime) FROM paymentinfo WHERE startTime LIKE CONCAT(#{startTime},'%') order by QUARTER(startTime) asc")
    public List<Long> getQuarterList(@Param("startTime")String Time);

    //查询本年季度水费数据
    @Select("select SUM(waterCost) from paymentinfo where YEAR(startTime) LIKE CONCAT(#{startTime},'%') GROUP BY QUARTER(startTime) order by QUARTER(startTime) asc")
    public List<Float> getQuarterWaterCostList(@Param("startTime")String Time);

    //查询本年季度电费数据
    @Select("select SUM(electricityCost) from paymentinfo where YEAR(startTime) LIKE CONCAT(#{startTime},'%') GROUP BY QUARTER(startTime) order by QUARTER(startTime) asc")
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
            "waterCost = (select waterCost from (select (WaterNumber * waterUnitPrice) as waterCost from paymentinfo,systeminfo WHERE paymentinfo.id = #{id}) as t)," +
            "electricityCost =(select electricityCost from (select (ElectricityNumber * electricityUnitPrice) as electricityCost from paymentinfo,systeminfo WHERE paymentinfo.id = #{id}) as t)" +
            "WHERE id = #{id}")
    public int insertCost(PaymentInfo paymentInfo);

    //查id
    @Select("select id from paymentinfo WHERE owner = #{owner} and buildingName = #{buildingName} and roomNumber = #{roomNumber} and startTime = #{startTime} and  endTime = #{endTime}" )
    public PaymentInfo selectPaymentInfoId(PaymentInfo paymentInfo);

    //插入查询是否有重复
    @Select("select count(*) from paymentinfo WHERE owner = #{owner} and roomNumber = #{roomNumber} and startTime = #{startTime} and  endTime = #{endTime}")
    public int repeatData(PaymentInfo paymentInfo);

    //查询所有楼栋
    @Select("select DISTINCT buildingName from roominfo")
    public List<String> getBuildingList();

    //查询所属楼栋的未使用的房号
    @Select("select DISTINCT roomNumber from roominfo where buildingName = #{buildingName} and owner != '空闲'")
    public List<Long> getBuildingRoomList(@Param("buildingName")String buildingName);

    //查询水电表已存在的房号
    @Select("select roomNumber from paymentinfo where buildingName = #{buildingName}")
    public List<Long> getPaymentinfoRoomList(@Param("buildingName")String buildingName);

    //查询企业
    @Select("select owner from roominfo where buildingName = #{buildingName} and roomNumber= #{roomNumber}")
    public String getEnterpriseNumber(@Param("buildingName")String buildingName,@Param("roomNumber")String roomNumber);



}
