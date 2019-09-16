package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Building;
import com.xcxgf.cainiao.POJO.Lease;
import com.xcxgf.cainiao.POJO.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 对数据库中leaseinfo表（租赁信息管理表）的增删改查操作
 */
public interface LeaseMapper {
    /**
     * 查询满足条件的可用记录
     *
     * @param search 查询条件
     * @param limit  需要返回的记录的起始位置和返回的
     * @return Lease类型的集合，满足查询条件的可用记录
     */
    @Select("select * " +
            "from leaseinfo " +
            "${search} " +
            "ORDER BY buildingName,roomNumber " +
            "${limit}")
    public List<Lease> getSearchList(String search, String limit);

    /**
     * 查询满足查询条件的可用记录的记录条数
     *
     * @param search 查询条件
     * @return int类型，满足查询条件的可用记录的条数
     */
    @Select("SELECT count(*) " +
            "FROM leaseinfo " +
            "${search}")
    public int getSearchCount(String search);

    /**
     * 查询所有可用记录
     *
     * @return Lease类型的集合，所有可用记录
     */
    @Select("select * " +
            "from leaseinfo " +
            "ORDER BY CAST(buildingName AS DECIMAL),roomNumber")
    public List<Lease> getLeaseList();

    /**
     * 删除记录
     *
     * @param lease 需要被删除的记录对象
     * @return int类型，删除操作影响的记录条数，0为删除失败，否则删除成功
     */
    @Delete("DELETE FROM leaseinfo " +
            "WHERE buildingName =#{buildingName} " +
            "and roomNumber=#{roomNumber}")
    public int deleteLeaseInfo(Lease lease);

    /**
     * 更新记录（更新表中某条记录的所有字段）
     *
     * @param lease 需要被更新的记录对象
     * @return int类型，更新操作影响的记录条数，0为更新失败，否则更新成功
     */
    @Update("UPDATE leaseinfo SET depositOnContracts=#{depositOnContracts},rentPeriod=#{rentPeriod},startRentTime=#{startRentTime},endRentTime=#{endRentTime}," +
            "unitPrice1=#{unitPrice1},period1=#{period1},rentCost1=#{rentCost1},propertyFee1=#{propertyFee1},energySharing1=#{energySharing1},totalCost1=#{totalCost1}," +
            "unitPrice2=#{unitPrice2},period2=#{period2},rentCost2=#{rentCost2},propertyFee2=#{propertyFee2},energySharing2=#{energySharing2},totalCost1=#{totalCost2}," +
            "unitPrice3=#{unitPrice3},period3=#{period3},rentCost3=#{rentCost3},propertyFee3=#{propertyFee3},energySharing3=#{energySharing3},totalCost3=#{totalCost3}," +
            "unitPrice4=#{unitPrice4},period4=#{period4},rentCost4=#{rentCost4},propertyFee4=#{propertyFee4},energySharing4=#{energySharing4},totalCost4=#{totalCost4}," +
            "unitPrice5=#{unitPrice5},period5=#{period5},rentCost5=#{rentCost5},propertyFee5=#{propertyFee5},energySharing5=#{energySharing5},totalCost5=#{totalCost5}," +
            "unitPrice6=#{unitPrice6},period6=#{period6},rentCost6=#{rentCost6},propertyFee6=#{propertyFee6},energySharing6=#{energySharing6},totalCost6=#{totalCost6}," +
            "isPayBond=#{isPayBond},isPayFirst=#{isPayFirst},isPaySecond=#{isPaySecond},rentCount=#{rentCount},yearTurnoverRange=#{yearTurnoverRange},dayAverageRange=#{dayAverageRange},register=#{register},updateTime=#{updateTime} " +
            "WHERE buildingName =#{buildingName} and roomNumber=#{roomNumber}")
    public int updateLeaseInfo(Lease lease);

    /**
     * 插入记录（插入一条完整记录）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Insert("INSERT INTO leaseinfo(buildingName,roomNumber,owner,depositOnContracts,leaseTerm,startingLeasePeriod,terminationPeriod," +
            "unitPriceOne,periodOne,rentCostOne,propertyFeeOne,energySharingOne,totalCostOne," +
            "unitPriceTwo,periodTwo,rentCostTwo,propertyFeeTwo,energySharingTwo,totalCostTwo," +
            "unitPriceThree,periodThree,rentCostThree,propertyFeeThree,energySharingThree,totalCostThree," +
            "unitPriceFour,periodFour,rentCostFour,propertyFeeFour,energySharingFour,totalCostFour," +
            "unitPriceFive,periodFive,rentCostFive,propertyFeeFive,energySharingFive,totalCostFive," +
            "unitPriceSix,periodSix,rentCostSix,propertyFeeSix,energySharingSix,totalCostSix," +
            "isPayBond,isPayFirstRent,isPaySecondRent,rentalUnits,annualTurnoverInterval,dailyQuantityInterval,register) " +
            "VALUES(#{buildingName},#{roomNumber},#{owner},#{depositOnContracts},#{leaseTerm},#{startingLeasePeriod},#{terminationPeriod}," +
            "#{unitPriceOne},#{periodOne},#{rentCostOne},#{propertyFeeOne},#{energySharingOne},#{totalCostOne}," +
            "#{unitPriceTwo},#{periodTwo},#{rentCostTwo},#{propertyFeeTwo},#{energySharingTwo},#{totalCostTwo}," +
            "#{unitPriceThree},#{periodThree},#{rentCostThree},#{propertyFeeThree},#{energySharingThree},#{totalCostThree}," +
            "#{unitPriceFour},#{periodFour},#{rentCostFour},#{propertyFeeFour},#{energySharingFour},#{totalCostFour}," +
            "#{unitPriceFive},#{periodFive},#{rentCostFive},#{propertyFeeFive},#{energySharingFive},#{totalCostFive}," +
            "#{unitPriceSix},#{periodSix},#{rentCostSix},#{propertyFeeSix},#{energySharingSix},#{totalCostSix}," +
            "#{isPayBond},#{isPayFirstRent},#{isPaySecondRent},#{rentalUnits},#{annualTurnoverInterval},#{dailyQuantityInterval},#{register})")
    public int insertLeaseInfo(Lease lease);

    /**
     * 插入记录（首期租赁）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Insert("INSERT INTO leaseinfo(buildingName,roomNumber,owner,depositOnContracts,rentPeriod,startRentTime,endRentTime," +
            "unitPrice1,period1,rentCost1,propertyFee1,energySharing1,totalCost1," +
            "isPayBond,isPayFirst,isPaySecond,rentCount,yearTurnoverRange,dayAverageRange,register,insertTime) " +
            "VALUES(#{buildingName},#{roomNumber},#{owner},#{depositOnContracts},#{rentPeriod},#{startRentTime},#{endRentTime}," +
            "#{unitPrice1},#{period1},#{rentCost1},#{propertyFee1},#{energySharing1},#{totalCost1}," +
            "#{isPayBond},#{isPayFirst},#{isPaySecond},#{rentCount},#{yearTurnoverRange},#{dayAverageRange},#{register},#{insertTime})")
    public int insertLeaseInfoFirst(Lease lease);

    /**
     * 插入记录（第2期租赁）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Update("UPDATE leaseinfo SET unitPrice2=#{unitPrice1}," +
            "period2=#{period1}," +
            "rentCost2=#{rentCost1}," +
            "propertyFee2=#{propertyFee1}," +
            "energySharing2=#{energySharing1}," +
            "totalCost2=#{totalCost1} " +
            "WHERE buildingName =#{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertLeaseInfoContinueTwo(Lease lease);

    /**
     * 插入记录（第3期租赁）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Update("UPDATE leaseinfo SET unitPrice3=#{unitPrice1}," +
            "period3=#{period1}," +
            "rentCost3=#{rentCost1}," +
            "propertyFee3=#{propertyFee1}," +
            "energySharing3=#{energySharing1}," +
            "totalCost3=#{totalCost1} " +
            "WHERE buildingName =#{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertLeaseInfoContinueThree(Lease lease);

    /**
     * 插入记录（第4期租赁）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Update("UPDATE leaseinfo SET unitPrice4=#{unitPrice1}," +
            "period4=#{period1}," +
            "rentCost4=#{rentCost1}," +
            "propertyFee4=#{propertyFee1}," +
            "energySharing4=#{energySharing1}," +
            "totalCost4=#{totalCost1}" +
            " WHERE buildingName =#{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertLeaseInfoContinueFour(Lease lease);

    /**
     * 插入记录（第5期租赁）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Update("UPDATE leaseinfo SET unitPriceTwo=#{unitPrice1}," +
            "period5=#{period1}," +
            "rentCost5=#{rentCost1}," +
            "propertyFee5=#{propertyFee1}," +
            "energySharing5=#{energySharing1}," +
            "totalCost5=#{totalCost1}" +
            " WHERE buildingName =#{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertLeaseInfoContinueFive(Lease lease);

    /**
     * 插入记录（第6期租赁）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Update("UPDATE leaseinfo SET unitPrice6=#{unitPrice1}," +
            "period6=#{period1}," +
            "rentCost6=#{rentCost1}," +
            "propertyFee6=#{propertyFee1}," +
            "energySharing6=#{energySharing1}," +
            "totalCost6=#{totalCost1}" +
            " WHERE buildingName =#{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertLeaseInfoContinueSix(Lease lease);

    /**
     * 查询是否存在重复记录（执行插入记录操作时）
     *
     * @param lease 需要查询是否存在的记录对象
     * @return int类型，满足查询条件的记录条数，为0时不存在重复记录，否则存在重复记录
     */
    @Select("select count(*) " +
            "from leaseinfo " +
            "where buildingName = #{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertSearchSame(Lease lease);

    /**
     * 查询所有办公楼
     *
     * @return
     */
    @Select("select * " +
            "from buildinginfo " +
            "where buildingType = '办公'")
    public List<Building> getBuildingList();

    /**
     * 查找所有办公房间租赁状态为空闲的记录
     *
     * @return Room类型的集合，所有房间租赁状态为空闲的记录
     */
    @Select("select * " +
            "from roominfo " +
            "where owner = '空闲' " +
            "and buildingName in (select buildingName from buildinginfo where buildingType='办公') " +
            "ORDER BY buildingName,roomNumber")
    public List<Room> getEmptyRoomList();

    /**
     * 查找所有办公房间租赁状态不为空闲的记录
     *
     * @return Room类型的集合，所有房间租赁状态不为空闲的记录
     */
    @Select("select * " +
            "from roominfo " +
            "where owner != '空闲' " +
            "and buildingName in (select buildingName from buildinginfo where buildingType='办公')" +
            "ORDER BY buildingName,roomNumber")
    public List<Room> getContinueRoomList();

    /**
     * 查询管理单价
     *
     * @return Setting类型的集合，所有可用的记录
     */
    @Select("select leaseUnitPrice " +
            "from systeminfo")
    public String getSettingList();
}
