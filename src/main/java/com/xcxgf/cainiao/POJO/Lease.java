package com.xcxgf.cainiao.POJO;

/**
 * 租赁信息的实体类
 */
public class Lease {
    private int id; // id标识
    private String owner; // 业主
    private String roomNumber; // 办公室房号
    private String buildingName; // 所属办公楼名称
    private String depositOnContracts; // 合同保证金
    private String leaseTerm; // 租期
    private String startingLeasePeriod; // 起租期
    private String terminationPeriod; // 终止期
    private String unitRentOne; // 首期租金单价
    private String leasePeriodOne; // 首期租期周期
    private String totalAmountOne; // 首期租期应付总额
    private String propertyFeeOne; // 首期租期应付物业费
    private String energySharingOne; // 首期能耗公摊
    private String totalRentOne; // 首期租费合计
    private String unitRentTwo; // 第2期租金单价
    private String leasePeriodTwo; // 第2期租期周期
    private String totalAmountTwo; // 第2期租期应付总额
    private String propertyFeeTwo; // 第2期租期应付物业费
    private String energySharingTwo; // 第2期能耗公摊
    private String totalRentTwo; // 第2期租费合计
    private String unitRentThree; // 第3期租金单价
    private String leasePeriodThree; // 第3期租期周期
    private String totalAmountThree; // 第3期租期应付总额
    private String propertyFeeThree; // 第3期租期应付物业费
    private String energySharingThree; // 第3期能耗公摊
    private String totalRentThree; // 第3期租费合计
    private String unitRentFour; // 第4期租金单价
    private String leasePeriodFour; // 第4期租期周期
    private String totalAmountFour; // 第4期租期应付总额
    private String propertyFeeFour; // 第4期租期应付物业费
    private String energySharingFour; // 第4期能耗公摊
    private String totalRentFour; // 第4期租费合计
    private String unitRentFive; // 第5期租金单价
    private String leasePeriodFive; // 第5期租期周期
    private String totalAmountFive; // 第5期租期应付总额
    private String propertyFeeFive; // 第5期租期应付物业费
    private String energySharingFive; // 第5期能耗公摊
    private String totalRentFive; // 第5期租费合计
    private String unitRentSix; // 第6期租金单价
    private String leasePeriodSix; // 第6期租期周期
    private String totalAmountSix; // 第6期租期应付总额
    private String propertyFeeSix; // 第6期租期应付物业费
    private String energySharingSix; // 第6期能耗公摊
    private String totalRentSix; // 第6期租费合计
    private String isPayBond; // 保证金是否支付
    private String isPayFirstRent; // 首年租金是否支付
    private String isPaySecondRent; // 第二年租金是否支付
    private String rentalUnits; // 出租单元数
    private String annualTurnoverInterval; // 年成交额区间
    private String dailyQuantityInterval; // 日均单量区间
    private String register; // 注册
    private String rentNumber; // 租期期数标识，仅用于前后端交互，不存入数据库
    private int state; // 记录标识，1为可用，-1不可用

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getDepositOnContracts() {
        return depositOnContracts;
    }

    public void setDepositOnContracts(String depositOnContracts) {
        this.depositOnContracts = depositOnContracts;
    }

    public String getLeaseTerm() {
        return leaseTerm;
    }

    public void setLeaseTerm(String leaseTerm) {
        this.leaseTerm = leaseTerm;
    }

    public String getStartingLeasePeriod() {
        return startingLeasePeriod;
    }

    public void setStartingLeasePeriod(String startingLeasePeriod) {
        this.startingLeasePeriod = startingLeasePeriod;
    }

    public String getTerminationPeriod() {
        return terminationPeriod;
    }

    public void setTerminationPeriod(String terminationPeriod) {
        this.terminationPeriod = terminationPeriod;
    }

    public String getUnitRentOne() {
        return unitRentOne;
    }

    public void setUnitRentOne(String unitRentOne) {
        this.unitRentOne = unitRentOne;
    }

    public String getLeasePeriodOne() {
        return leasePeriodOne;
    }

    public void setLeasePeriodOne(String leasePeriodOne) {
        this.leasePeriodOne = leasePeriodOne;
    }

    public String getTotalAmountOne() {
        return totalAmountOne;
    }

    public void setTotalAmountOne(String totalAmountOne) {
        this.totalAmountOne = totalAmountOne;
    }

    public String getPropertyFeeOne() {
        return propertyFeeOne;
    }

    public void setPropertyFeeOne(String propertyFeeOne) {
        this.propertyFeeOne = propertyFeeOne;
    }

    public String getEnergySharingOne() {
        return energySharingOne;
    }

    public void setEnergySharingOne(String energySharingOne) {
        this.energySharingOne = energySharingOne;
    }

    public String getTotalRentOne() {
        return totalRentOne;
    }

    public void setTotalRentOne(String totalRentOne) {
        this.totalRentOne = totalRentOne;
    }

    public String getUnitRentTwo() {
        return unitRentTwo;
    }

    public void setUnitRentTwo(String unitRentTwo) {
        this.unitRentTwo = unitRentTwo;
    }

    public String getLeasePeriodTwo() {
        return leasePeriodTwo;
    }

    public void setLeasePeriodTwo(String leasePeriodTwo) {
        this.leasePeriodTwo = leasePeriodTwo;
    }

    public String getTotalAmountTwo() {
        return totalAmountTwo;
    }

    public void setTotalAmountTwo(String totalAmountTwo) {
        this.totalAmountTwo = totalAmountTwo;
    }

    public String getPropertyFeeTwo() {
        return propertyFeeTwo;
    }

    public void setPropertyFeeTwo(String propertyFeeTwo) {
        this.propertyFeeTwo = propertyFeeTwo;
    }

    public String getEnergySharingTwo() {
        return energySharingTwo;
    }

    public void setEnergySharingTwo(String energySharingTwo) {
        this.energySharingTwo = energySharingTwo;
    }

    public String getTotalRentTwo() {
        return totalRentTwo;
    }

    public void setTotalRentTwo(String totalRentTwo) {
        this.totalRentTwo = totalRentTwo;
    }

    public String getUnitRentThree() {
        return unitRentThree;
    }

    public void setUnitRentThree(String unitRentThree) {
        this.unitRentThree = unitRentThree;
    }

    public String getLeasePeriodThree() {
        return leasePeriodThree;
    }

    public void setLeasePeriodThree(String leasePeriodThree) {
        this.leasePeriodThree = leasePeriodThree;
    }

    public String getTotalAmountThree() {
        return totalAmountThree;
    }

    public void setTotalAmountThree(String totalAmountThree) {
        this.totalAmountThree = totalAmountThree;
    }

    public String getPropertyFeeThree() {
        return propertyFeeThree;
    }

    public void setPropertyFeeThree(String propertyFeeThree) {
        this.propertyFeeThree = propertyFeeThree;
    }

    public String getEnergySharingThree() {
        return energySharingThree;
    }

    public void setEnergySharingThree(String energySharingThree) {
        this.energySharingThree = energySharingThree;
    }

    public String getTotalRentThree() {
        return totalRentThree;
    }

    public void setTotalRentThree(String totalRentThree) {
        this.totalRentThree = totalRentThree;
    }

    public String getUnitRentFour() {
        return unitRentFour;
    }

    public void setUnitRentFour(String unitRentFour) {
        this.unitRentFour = unitRentFour;
    }

    public String getLeasePeriodFour() {
        return leasePeriodFour;
    }

    public void setLeasePeriodFour(String leasePeriodFour) {
        this.leasePeriodFour = leasePeriodFour;
    }

    public String getTotalAmountFour() {
        return totalAmountFour;
    }

    public void setTotalAmountFour(String totalAmountFour) {
        this.totalAmountFour = totalAmountFour;
    }

    public String getPropertyFeeFour() {
        return propertyFeeFour;
    }

    public void setPropertyFeeFour(String propertyFeeFour) {
        this.propertyFeeFour = propertyFeeFour;
    }

    public String getEnergySharingFour() {
        return energySharingFour;
    }

    public void setEnergySharingFour(String energySharingFour) {
        this.energySharingFour = energySharingFour;
    }

    public String getTotalRentFour() {
        return totalRentFour;
    }

    public void setTotalRentFour(String totalRentFour) {
        this.totalRentFour = totalRentFour;
    }

    public String getUnitRentFive() {
        return unitRentFive;
    }

    public void setUnitRentFive(String unitRentFive) {
        this.unitRentFive = unitRentFive;
    }

    public String getLeasePeriodFive() {
        return leasePeriodFive;
    }

    public void setLeasePeriodFive(String leasePeriodFive) {
        this.leasePeriodFive = leasePeriodFive;
    }

    public String getTotalAmountFive() {
        return totalAmountFive;
    }

    public void setTotalAmountFive(String totalAmountFive) {
        this.totalAmountFive = totalAmountFive;
    }

    public String getPropertyFeeFive() {
        return propertyFeeFive;
    }

    public void setPropertyFeeFive(String propertyFeeFive) {
        this.propertyFeeFive = propertyFeeFive;
    }

    public String getEnergySharingFive() {
        return energySharingFive;
    }

    public void setEnergySharingFive(String energySharingFive) {
        this.energySharingFive = energySharingFive;
    }

    public String getTotalRentFive() {
        return totalRentFive;
    }

    public void setTotalRentFive(String totalRentFive) {
        this.totalRentFive = totalRentFive;
    }

    public String getUnitRentSix() {
        return unitRentSix;
    }

    public void setUnitRentSix(String unitRentSix) {
        this.unitRentSix = unitRentSix;
    }

    public String getLeasePeriodSix() {
        return leasePeriodSix;
    }

    public void setLeasePeriodSix(String leasePeriodSix) {
        this.leasePeriodSix = leasePeriodSix;
    }

    public String getTotalAmountSix() {
        return totalAmountSix;
    }

    public void setTotalAmountSix(String totalAmountSix) {
        this.totalAmountSix = totalAmountSix;
    }

    public String getPropertyFeeSix() {
        return propertyFeeSix;
    }

    public void setPropertyFeeSix(String propertyFeeSix) {
        this.propertyFeeSix = propertyFeeSix;
    }

    public String getEnergySharingSix() {
        return energySharingSix;
    }

    public void setEnergySharingSix(String energySharingSix) {
        this.energySharingSix = energySharingSix;
    }

    public String getTotalRentSix() {
        return totalRentSix;
    }

    public void setTotalRentSix(String totalRentSix) {
        this.totalRentSix = totalRentSix;
    }

    public String getIsPayBond() {
        return isPayBond;
    }

    public void setIsPayBond(String isPayBond) {
        this.isPayBond = isPayBond;
    }

    public String getIsPayFirstRent() {
        return isPayFirstRent;
    }

    public void setIsPayFirstRent(String isPayFirstRent) {
        this.isPayFirstRent = isPayFirstRent;
    }

    public String getIsPaySecondRent() {
        return isPaySecondRent;
    }

    public void setIsPaySecondRent(String isPaySecondRent) {
        this.isPaySecondRent = isPaySecondRent;
    }

    public String getRentalUnits() {
        return rentalUnits;
    }

    public void setRentalUnits(String rentalUnits) {
        this.rentalUnits = rentalUnits;
    }

    public String getAnnualTurnoverInterval() {
        return annualTurnoverInterval;
    }

    public void setAnnualTurnoverInterval(String annualTurnoverInterval) {
        this.annualTurnoverInterval = annualTurnoverInterval;
    }

    public String getDailyQuantityInterval() {
        return dailyQuantityInterval;
    }

    public void setDailyQuantityInterval(String dailyQuantityInterval) {
        this.dailyQuantityInterval = dailyQuantityInterval;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getRentNumber() {
        return rentNumber;
    }

    public void setRentNumber(String rentNumber) {
        this.rentNumber = rentNumber;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
