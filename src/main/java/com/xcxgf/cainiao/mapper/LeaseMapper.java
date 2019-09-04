package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Lease;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 对数据库中leaseInfo表（租赁信息管理表）的增删改查操作
 */
public interface LeaseMapper {
    /**
     * 查询满足条件的可用记录
     *
     * @param search 查询条件
     * @param limit  需要返回的记录的起始位置和终止位置
     * @return Lease类型的集合，满足查询条件的可用记录
     */
    @Select("select * from leaseInfo where state != -1 ${search} ORDER BY CAST(buildingName AS DECIMAL),roomNumber ${limit}")
    public List<Lease> getSearchList(String search, String limit);

    /**
     * 查询满足查询条件的可用记录的记录条数
     *
     * @param search 查询条件
     * @return int类型，满足查询条件的可用记录的条数
     */
    @Select("SELECT count(*) FROM leaseInfo WHERE state !=-1 ${search}")
    public int getSearchCount(String search);

    /**
     * 查询所有可用记录
     *
     * @return Lease类型的集合，所有可用记录
     */
    @Select("select * from leaseInfo where state !=-1 ORDER BY CAST(buildingName AS DECIMAL),roomNumber")
    public List<Lease> getLeaseList();

    /**
     * 删除记录
     *
     * @param lease 需要被删除的记录对象
     * @return int类型，删除操作影响的记录条数，0为删除失败，否则删除成功
     */
    @Delete("DELETE FROM leaseInfo WHERE id =#{id}")
    public int deleteLeaseInfo(Lease lease);

    /**
     * 更新记录（更新表中某条记录的所有字段）
     *
     * @param lease 需要被更新的记录对象
     * @return int类型，更新操作影响的记录条数，0为更新失败，否则更新成功
     */
    @Update("UPDATE leaseInfo SET roomNumber=#{roomNumber},owner=#{owner},depositOnContracts=#{depositOnContracts},leaseTerm=#{leaseTerm},startingLeasePeriod=#{startingLeasePeriod},terminationPeriod=#{terminationPeriod}," +
            "unitRentOne=#{unitRentOne},leasePeriodOne=#{leasePeriodOne},totalAmountOne=#{totalAmountOne},propertyFeeOne=#{propertyFeeOne},energySharingOne=#{energySharingOne},totalRentOne=#{totalRentOne}," +
            "unitRentTwo=#{unitRentTwo},leasePeriodTwo=#{leasePeriodTwo},totalAmountTwo=#{totalAmountTwo},propertyFeeTwo=#{propertyFeeTwo},energySharingTwo=#{energySharingTwo},totalRentOne=#{totalRentTwo}," +
            "unitRentThree=#{unitRentThree},leasePeriodThree=#{leasePeriodThree},totalAmountThree=#{totalAmountThree},propertyFeeThree=#{propertyFeeThree},energySharingThree=#{energySharingThree},totalRentThree=#{totalRentThree}," +
            "unitRentFour=#{unitRentFour},leasePeriodFour=#{leasePeriodFour},totalAmountFour=#{totalAmountFour},propertyFeeFour=#{propertyFeeFour},energySharingFour=#{energySharingFour},totalRentFour=#{totalRentFour}," +
            "unitRentFive=#{unitRentFive},leasePeriodFive=#{leasePeriodFive},totalAmountFive=#{totalAmountFive},propertyFeeFive=#{propertyFeeFive},energySharingFive=#{energySharingFive},totalRentFive=#{totalRentFive}," +
            "unitRentSix=#{unitRentSix},leasePeriodSix=#{leasePeriodSix},totalAmountSix=#{totalAmountSix},propertyFeeSix=#{propertyFeeSix},energySharingSix=#{energySharingSix},totalRentSix=#{totalRentSix}," +
            "isPayBond=#{isPayBond},isPayFirstRent=#{isPayFirstRent},isPaySecondRent=#{isPaySecondRent},rentalUnits=#{rentalUnits},annualTurnoverInterval=#{annualTurnoverInterval},dailyQuantityInterval=#{dailyQuantityInterval},register=#{register}" +
            " WHERE id =#{id}")
    public int updateLeaseInfo(Lease lease);

    /**
     * 插入记录（插入一条完整记录）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Insert("INSERT INTO leaseInfo(buildingName,roomNumber,owner,depositOnContracts,leaseTerm,startingLeasePeriod,terminationPeriod," +
            "unitRentOne,leasePeriodOne,totalAmountOne,propertyFeeOne,energySharingOne,totalRentOne," +
            "unitRentTwo,leasePeriodTwo,totalAmountTwo,propertyFeeTwo,energySharingTwo,totalRentTwo," +
            "unitRentThree,leasePeriodThree,totalAmountThree,propertyFeeThree,energySharingThree,totalRentThree," +
            "unitRentFour,leasePeriodFour,totalAmountFour,propertyFeeFour,energySharingFour,totalRentFour," +
            "unitRentFive,leasePeriodFive,totalAmountFive,propertyFeeFive,energySharingFive,totalRentFive," +
            "unitRentSix,leasePeriodSix,totalAmountSix,propertyFeeSix,energySharingSix,totalRentSix," +
            "isPayBond,isPayFirstRent,isPaySecondRent,rentalUnits,annualTurnoverInterval,dailyQuantityInterval,register) " +
            "VALUES(#{buildingName},#{roomNumber},#{owner},#{depositOnContracts},#{leaseTerm},#{startingLeasePeriod},#{terminationPeriod}," +
            "#{unitRentOne},#{leasePeriodOne},#{totalAmountOne},#{propertyFeeOne},#{energySharingOne},#{totalRentOne}," +
            "#{unitRentTwo},#{leasePeriodTwo},#{totalAmountTwo},#{propertyFeeTwo},#{energySharingTwo},#{totalRentTwo}," +
            "#{unitRentThree},#{leasePeriodThree},#{totalAmountThree},#{propertyFeeThree},#{energySharingThree},#{totalRentThree}," +
            "#{unitRentFour},#{leasePeriodFour},#{totalAmountFour},#{propertyFeeFour},#{energySharingFour},#{totalRentFour}," +
            "#{unitRentFive},#{leasePeriodFive},#{totalAmountFive},#{propertyFeeFive},#{energySharingFive},#{totalRentFive}," +
            "#{unitRentSix},#{leasePeriodSix},#{totalAmountSix},#{propertyFeeSix},#{energySharingSix},#{totalRentSix}," +
            "#{isPayBond},#{isPayFirstRent},#{isPaySecondRent},#{rentalUnits},#{annualTurnoverInterval},#{dailyQuantityInterval},#{register})")
    public int insertLeaseInfo(Lease lease);

    /**
     * 插入记录（首期租赁）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Insert("INSERT INTO leaseInfo(buildingName,roomNumber,owner,depositOnContracts,leaseTerm,startingLeasePeriod,terminationPeriod," +
            "unitRentOne,leasePeriodOne,totalAmountOne,propertyFeeOne,energySharingOne,totalRentOne," +
            "isPayBond,isPayFirstRent,isPaySecondRent,rentalUnits,annualTurnoverInterval,dailyQuantityInterval,register) " +
            "VALUES(#{buildingName},#{roomNumber},#{owner},#{depositOnContracts},#{leaseTerm},#{startingLeasePeriod},#{terminationPeriod}," +
            "#{unitRentOne},#{leasePeriodOne},#{totalAmountOne},#{propertyFeeOne},#{energySharingOne},#{totalRentOne}," +
            "#{isPayBond},#{isPayFirstRent},#{isPaySecondRent},#{rentalUnits},#{annualTurnoverInterval},#{dailyQuantityInterval},#{register})")
    public int insertLeaseInfoFirst(Lease lease);

    /**
     * 插入记录（第2期租赁）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Update("UPDATE leaseInfo SET unitRentTwo=#{unitRentOne}," +
            "leasePeriodTwo=#{leasePeriodOne}," +
            "totalAmountTwo=#{totalAmountOne}," +
            "propertyFeeTwo=#{propertyFeeOne}," +
            "energySharingTwo=#{energySharingOne}," +
            "totalRentTwo=#{totalRentOne}" +
            " WHERE state!=-1 " +
            "and buildingName =#{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertLeaseInfoContinueTwo(Lease lease);
    /**
     * 插入记录（第3期租赁）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Update("UPDATE leaseInfo SET unitRentThree=#{unitRentOne}," +
            "leasePeriodThree=#{leasePeriodOne}," +
            "totalAmountThree=#{totalAmountOne}," +
            "propertyFeeThree=#{propertyFeeOne}," +
            "energySharingThree=#{energySharingOne}," +
            "totalRentThree=#{totalRentOne}" +
            " WHERE state!=-1 " +
            "and buildingName =#{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertLeaseInfoContinueThree(Lease lease);
    /**
     * 插入记录（第4期租赁）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Update("UPDATE leaseInfo SET unitRentFour=#{unitRentOne}," +
            "leasePeriodFour=#{leasePeriodOne}," +
            "totalAmountFour=#{totalAmountOne}," +
            "propertyFeeFour=#{propertyFeeOne}," +
            "energySharingFour=#{energySharingOne}," +
            "totalRentFour=#{totalRentOne}" +
            " WHERE state!=-1 " +
            "and buildingName =#{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertLeaseInfoContinueFour(Lease lease);
    /**
     * 插入记录（第5期租赁）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Update("UPDATE leaseInfo SET unitRentTwo=#{unitRentOne}," +
            "leasePeriodFive=#{leasePeriodOne}," +
            "totalAmountFive=#{totalAmountOne}," +
            "propertyFeeFive=#{propertyFeeOne}," +
            "energySharingFive=#{energySharingOne}," +
            "totalRentFive=#{totalRentOne}" +
            " WHERE state!=-1 " +
            "and buildingName =#{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertLeaseInfoContinueFive(Lease lease);
    /**
     * 插入记录（第6期租赁）
     *
     * @param lease 需要被插入的记录对象
     * @return int类型，插入操作影响到的记录条数，0为插入失败，否则插入成功
     */
    @Update("UPDATE leaseInfo SET unitRentSix=#{unitRentOne}," +
            "leasePeriodSix=#{leasePeriodOne}," +
            "totalAmountSix=#{totalAmountOne}," +
            "propertyFeeSix=#{propertyFeeOne}," +
            "energySharingSix=#{energySharingOne}," +
            "totalRentSix=#{totalRentOne}" +
            " WHERE state!=-1 " +
            "and buildingName =#{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertLeaseInfoContinueSix(Lease lease);
    /**
     * 查询是否存在重复记录（执行插入记录操作时）
     *
     * @param lease 需要查询是否存在的记录对象
     * @return int类型，满足查询条件的记录条数，为0时不存在重复记录，否则存在重复记录
     */
    @Select("select count(*) from leaseInfo " +
            "where state != -1 " +
            "and buildingName = #{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertSearchSame(Lease lease);

}
