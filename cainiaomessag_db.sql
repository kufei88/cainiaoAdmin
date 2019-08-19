/*
Navicat MySQL Data Transfer

Source Server         : test.db
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : cainiaomessag_db

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-08-19 20:23:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for buildinginfo
-- ----------------------------
DROP TABLE IF EXISTS `buildinginfo`;
CREATE TABLE `buildinginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buildingNumber` varchar(255) DEFAULT NULL COMMENT '办公楼楼号',
  `buildingName` varchar(255) DEFAULT NULL COMMENT '办公楼名称',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '1' COMMENT '记录状态',
  PRIMARY KEY (`id`),
  KEY `buildingName` (`buildingName`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of buildinginfo
-- ----------------------------
INSERT INTO `buildinginfo` VALUES ('1', '1', '1号楼', '1');
INSERT INTO `buildinginfo` VALUES ('2', '2', '2号楼', '1');
INSERT INTO `buildinginfo` VALUES ('3', '3', '3号楼', '1');
INSERT INTO `buildinginfo` VALUES ('4', '4', '4号楼', '1');
INSERT INTO `buildinginfo` VALUES ('5', '5', '5号楼', '1');
INSERT INTO `buildinginfo` VALUES ('6', '6', '6号楼', '1');
INSERT INTO `buildinginfo` VALUES ('7', '7', '7号楼', '1');
INSERT INTO `buildinginfo` VALUES ('8', '8', '8号楼', '1');

-- ----------------------------
-- Table structure for enterpriseinfo
-- ----------------------------
DROP TABLE IF EXISTS `enterpriseinfo`;
CREATE TABLE `enterpriseinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enterpriseName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '企业名称',
  `enterprisePerson` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '企业联系人',
  `enterpriseTelphone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '企业电话',
  `state` int(11) DEFAULT '1' COMMENT '记录状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='园区企业信息表';

-- ----------------------------
-- Records of enterpriseinfo
-- ----------------------------
INSERT INTO `enterpriseinfo` VALUES ('1', '1号公司', 'npc1', '123456', '1');
INSERT INTO `enterpriseinfo` VALUES ('2', '2号公司', 'npc2', '654321', '1');
INSERT INTO `enterpriseinfo` VALUES ('3', '3号公司', 'npc3', '147852', '1');
INSERT INTO `enterpriseinfo` VALUES ('4', '1', '222', '222', '1');
INSERT INTO `enterpriseinfo` VALUES ('5', '5', '5', '5', '1');
INSERT INTO `enterpriseinfo` VALUES ('6', '6', '6', '6', '1');
INSERT INTO `enterpriseinfo` VALUES ('7', '7', '7', '7', '1');
INSERT INTO `enterpriseinfo` VALUES ('8', '8', '8', '8', '1');
INSERT INTO `enterpriseinfo` VALUES ('9', '9', '9', '9', '1');
INSERT INTO `enterpriseinfo` VALUES ('10', '10', '10', '10', '1');
INSERT INTO `enterpriseinfo` VALUES ('11', '11', '11', '11', '1');
INSERT INTO `enterpriseinfo` VALUES ('12', '12', '12', '12', '1');
INSERT INTO `enterpriseinfo` VALUES ('13', '13', '13', '13', '1');
INSERT INTO `enterpriseinfo` VALUES ('14', '14', '14', '14', '1');
INSERT INTO `enterpriseinfo` VALUES ('15', '15', '15', '15', '1');
INSERT INTO `enterpriseinfo` VALUES ('16', '161', '162', '163', '1');
INSERT INTO `enterpriseinfo` VALUES ('17', '171', '172', '173', '1');
INSERT INTO `enterpriseinfo` VALUES ('18', '181', '182', '183', '1');
INSERT INTO `enterpriseinfo` VALUES ('19', '2', '1', '1', '-1');

-- ----------------------------
-- Table structure for leaseinfo
-- ----------------------------
DROP TABLE IF EXISTS `leaseinfo`;
CREATE TABLE `leaseinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '房号',
  `owner` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '业主',
  `depositOnContracts` varchar(255) DEFAULT NULL COMMENT '合同保证金',
  `leaseTerm` varchar(255) DEFAULT NULL COMMENT '租期',
  `startingLeasePeriod` varchar(255) DEFAULT NULL COMMENT '起租期',
  `terminationPeriod` varchar(255) DEFAULT NULL COMMENT '终止期',
  `unitRentOne` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '首期租金单价',
  `leasePeriodOne` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '首期租期周期',
  `totalAmountOne` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '首期租期应付总额（=周期*单价*面积）',
  `propertyFeeOne` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '首期租期应付物业费（周期*管理费单价*面积）',
  `energySharingOne` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '首期能耗公摊',
  `totalRentOne` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '首期租费合计(租金+物业费+能耗公摊)',
  `unitRentTwo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第2期租金单价',
  `leasePeriodTwo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第2期租期周期',
  `totalAmountTwo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第2期租期应付总额（=周期*单价*面积）',
  `propertyFeeTwo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第2期租期应付物业费（周期*管理费单价*面积）',
  `energySharingTwo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第2期能耗公摊',
  `totalRentTwo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第2期租费合计(租金+物业费+能耗公摊)',
  `unitRentThree` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第3期租金单价',
  `leasePeriodThree` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第3期租期周期',
  `totalAmountThree` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第3期租期应付总额（=周期*单价*面积）',
  `propertyFeeThree` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第3期租期应付物业费（周期*管理费单价*面积）',
  `energySharingThree` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第3期能耗公摊',
  `totalRentThree` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第3期租费合计(租金+物业费+能耗公摊)',
  `unitRentFour` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第4期租金单价',
  `leasePeriodFour` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第4期租期周期',
  `totalAmountFour` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第4期租期应付总额（=周期*单价*面积）',
  `propertyFeeFour` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第4期租期应付物业费（周期*管理费单价*面积）',
  `energySharingFour` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第4期能耗公摊',
  `totalRentFour` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第4期租费合计(租金+物业费+能耗公摊)',
  `unitRentFive` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第5期租金单价',
  `leasePeriodFive` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第5期租期周期',
  `totalAmountFive` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第5期租期应付总额（=周期*单价*面积）',
  `propertyFeeFive` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第5期租期应付物业费（周期*管理费单价*面积）',
  `energySharingFive` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第5期能耗公摊',
  `totalRentFive` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第5期租费合计(租金+物业费+能耗公摊)',
  `unitRentSix` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第6期租金单价',
  `leasePeriodSix` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第6期租期周期',
  `totalAmountSix` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第6期租期应付总额（=周期*单价*面积）',
  `propertyFeeSix` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第6期租期应付物业费（周期*管理费单价*面积）',
  `energySharingSix` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第6期能耗公摊',
  `totalRentSix` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '第6期租费合计(租金+物业费+能耗公摊)',
  `isPayBond` int(255) DEFAULT '1' COMMENT '保证金是否支付',
  `isPayFirstRent` int(255) DEFAULT '1' COMMENT '首年租金是否支付',
  `isPaySecondRent` int(255) DEFAULT '1' COMMENT '第二年租金是否支付',
  `rentalUnits` varchar(255) DEFAULT NULL COMMENT '出租单元数',
  `annualTurnoverInterval` varchar(255) DEFAULT NULL COMMENT '年成交额区间',
  `dailyQuantityInterval` varchar(255) DEFAULT NULL COMMENT '日均单量区间',
  `
register` varchar(255) DEFAULT NULL COMMENT '注册',
  `state` int(255) DEFAULT '1' COMMENT '记录状态',
  PRIMARY KEY (`id`),
  KEY `roomNumber` (`roomNumber`),
  CONSTRAINT `leaseinfo_ibfk_1` FOREIGN KEY (`roomNumber`) REFERENCES `roominfo` (`roomnumber`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='租赁信息表';

-- ----------------------------
-- Records of leaseinfo
-- ----------------------------

-- ----------------------------
-- Table structure for roominfo
-- ----------------------------
DROP TABLE IF EXISTS `roominfo`;
CREATE TABLE `roominfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomNumber` varchar(255) DEFAULT NULL COMMENT '房间号',
  `buildingName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '办公楼名称',
  `rentArea` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '计租面积',
  `builtUpArea` varchar(255) DEFAULT NULL COMMENT '建筑面积',
  `owner` varchar(255) DEFAULT NULL COMMENT '业主',
  `state` varchar(255) DEFAULT '1' COMMENT '记录状态',
  PRIMARY KEY (`id`),
  KEY `buildingName` (`buildingName`),
  KEY `roomNumber` (`roomNumber`),
  CONSTRAINT `roominfo_ibfk_1` FOREIGN KEY (`buildingName`) REFERENCES `buildinginfo` (`buildingname`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='办公室信息表';

-- ----------------------------
-- Records of roominfo
-- ----------------------------
INSERT INTO `roominfo` VALUES ('1', '101', '1号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('2', '102', '1号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('3', '201', '1号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('4', '202', '1号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('5', '101', '2号楼', '60', '90', null, '1');
INSERT INTO `roominfo` VALUES ('6', '102', '2号楼', '60', '90', null, '1');
INSERT INTO `roominfo` VALUES ('7', '201', '2号楼', '75', '100', null, '1');
INSERT INTO `roominfo` VALUES ('8', '202', '2号楼', '75', '100', null, '1');
INSERT INTO `roominfo` VALUES ('9', '103', '2号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('10', '104', '3号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('11', '103', '3号楼', '75', '100', null, '1');
INSERT INTO `roominfo` VALUES ('12', '111', '3号楼', '75', '80', null, '1');
INSERT INTO `roominfo` VALUES ('13', '301', '1号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('14', '302', '1号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('15', '303', '1号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('16', '304', '1号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('17', '301', '2号楼', '60', '90', null, '1');
INSERT INTO `roominfo` VALUES ('18', '302', '2号楼', '60', '90', null, '1');
INSERT INTO `roominfo` VALUES ('19', '303', '2号楼', '75', '100', null, '1');
INSERT INTO `roominfo` VALUES ('20', '304', '2号楼', '75', '100', null, '1');
INSERT INTO `roominfo` VALUES ('21', '305', '2号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('22', '306', '2号楼', '213', '124', null, '1');
INSERT INTO `roominfo` VALUES ('23', '103', '1号楼', '131', '131', null, '1');

-- ----------------------------
-- Table structure for settinginfo
-- ----------------------------
DROP TABLE IF EXISTS `settinginfo`;
CREATE TABLE `settinginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rentUnitPrice` varchar(255) DEFAULT NULL COMMENT '租金单价',
  `manageExpense` varchar(255) DEFAULT NULL,
  `state` int(255) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统设置信息表';

-- ----------------------------
-- Records of settinginfo
-- ----------------------------
INSERT INTO `settinginfo` VALUES ('1', '12', '25', '1');
