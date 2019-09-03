package com.xcxgf.cainiao.mapper;

import com.xcxgf.cainiao.POJO.Lease;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LeaseMapper {
    @Select("select * from leaseInfo where state != -1 ${search} ORDER BY CAST(buildingName AS DECIMAL),roomNumber ${limit}")
    public List<Lease> getSearchList(String search, String limit);

    @Select("SELECT count(*) FROM leaseInfo WHERE state !=-1 ${search}")
    public int getSearchCount(String search);


    @Select("select * from leaseInfo where state !=-1")
    public List<Lease> getLeaseList();

    @Update("UPDATE leaseInfo SET state=-1 WHERE id =#{id}")
    public int deleteLeaseInfo(Lease lease);

    @Update("UPDATE leaseInfo SET roomNumber=#{roomNumber},owner=#{owner},depositOnContracts=#{depositOnContracts},leaseTerm=#{leaseTerm},startingLeasePeriod=#{startingLeasePeriod},terminationPeriod=#{terminationPeriod},"+
            "unitRentOne=#{unitRentOne},leasePeriodOne=#{leasePeriodOne},totalAmountOne=#{totalAmountOne},propertyFeeOne=#{propertyFeeOne},energySharingOne=#{energySharingOne},totalRentOne=#{totalRentOne},"+
            "unitRentTwo=#{unitRentTwo},leasePeriodTwo=#{leasePeriodTwo},totalAmountTwo=#{totalAmountTwo},propertyFeeTwo=#{propertyFeeTwo},energySharingTwo=#{energySharingTwo},totalRentOne=#{totalRentTwo},"+
            "unitRentThree=#{unitRentThree},leasePeriodThree=#{leasePeriodThree},totalAmountThree=#{totalAmountThree},propertyFeeThree=#{propertyFeeThree},energySharingThree=#{energySharingThree},totalRentThree=#{totalRentThree},"+
            "unitRentFour=#{unitRentFour},leasePeriodFour=#{leasePeriodFour},totalAmountFour=#{totalAmountFour},propertyFeeFour=#{propertyFeeFour},energySharingFour=#{energySharingFour},totalRentFour=#{totalRentFour},"+
            "unitRentFive=#{unitRentFive},leasePeriodFive=#{leasePeriodFive},totalAmountFive=#{totalAmountFive},propertyFeeFive=#{propertyFeeFive},energySharingFive=#{energySharingFive},totalRentFive=#{totalRentFive},"+
            "unitRentSix=#{unitRentSix},leasePeriodSix=#{leasePeriodSix},totalAmountSix=#{totalAmountSix},propertyFeeSix=#{propertyFeeSix},energySharingSix=#{energySharingSix},totalRentSix=#{totalRentSix},"+
            "isPayBond=#{isPayBond},isPayFirstRent=#{isPayFirstRent},isPaySecondRent=#{isPaySecondRent},rentalUnits=#{rentalUnits},annualTurnoverInterval=#{annualTurnoverInterval},dailyQuantityInterval=#{dailyQuantityInterval},register=#{register}"+
            " WHERE id =#{id}")
    public int updateLeaseInfo(Lease lease);

    @Insert("INSERT INTO leaseInfo(buildingName,roomNumber,owner,depositOnContracts,leaseTerm,startingLeasePeriod,terminationPeriod,"+
            "unitRentOne,leasePeriodOne,totalAmountOne,propertyFeeOne,energySharingOne,totalRentOne,"+
            "unitRentTwo,leasePeriodTwo,totalAmountTwo,propertyFeeTwo,energySharingTwo,totalRentTwo,"+
            "unitRentThree,leasePeriodThree,totalAmountThree,propertyFeeThree,energySharingThree,totalRentThree,"+
            "unitRentFour,leasePeriodFour,totalAmountFour,propertyFeeFour,energySharingFour,totalRentFour,"+
            "unitRentFive,leasePeriodFive,totalAmountFive,propertyFeeFive,energySharingFive,totalRentFive,"+
            "unitRentSix,leasePeriodSix,totalAmountSix,propertyFeeSix,energySharingSix,totalRentSix,"+
            "isPayBond,isPayFirstRent,isPaySecondRent,rentalUnits,annualTurnoverInterval,dailyQuantityInterval,register) " +
            "VALUES(#{buildingName},#{roomNumber},#{owner},#{depositOnContracts},#{leaseTerm},#{startingLeasePeriod},#{terminationPeriod},"+
            "#{unitRentOne},#{leasePeriodOne},#{totalAmountOne},#{propertyFeeOne},#{energySharingOne},#{totalRentOne},"+
            "#{unitRentTwo},#{leasePeriodTwo},#{totalAmountTwo},#{propertyFeeTwo},#{energySharingTwo},#{totalRentTwo},"+
            "#{unitRentThree},#{leasePeriodThree},#{totalAmountThree},#{propertyFeeThree},#{energySharingThree},#{totalRentThree},"+
            "#{unitRentFour},#{leasePeriodFour},#{totalAmountFour},#{propertyFeeFour},#{energySharingFour},#{totalRentFour},"+
            "#{unitRentFive},#{leasePeriodFive},#{totalAmountFive},#{propertyFeeFive},#{energySharingFive},#{totalRentFive},"+
            "#{unitRentSix},#{leasePeriodSix},#{totalAmountSix},#{propertyFeeSix},#{energySharingSix},#{totalRentSix},"+
            "#{isPayBond},#{isPayFirstRent},#{isPaySecondRent},#{rentalUnits},#{annualTurnoverInterval},#{dailyQuantityInterval},#{register})")
    public int insertLeaseInfo(Lease lease);

    @Select("select count(*) from leaseInfo " +
            "where state != -1 " +
            "and buildingName = #{buildingName} " +
            "and roomNumber = #{roomNumber}")
    public int insertSearchSame(Lease lease);

}
