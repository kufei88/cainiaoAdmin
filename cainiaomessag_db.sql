/*
Navicat MySQL Data Transfer

Source Server         : test.db
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : cainiaomessag_db

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-09-02 08:11:04
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
  KEY `buildingName` (`buildingName`),
  KEY `buildingNumber` (`buildingNumber`,`buildingName`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of buildinginfo
-- ----------------------------
INSERT INTO `buildinginfo` VALUES ('1', '1', '2号楼', '1');
INSERT INTO `buildinginfo` VALUES ('2', '2', '2号楼', '1');
INSERT INTO `buildinginfo` VALUES ('3', '3', '3号楼', '1');
INSERT INTO `buildinginfo` VALUES ('4', '4', '4号楼', '1');
INSERT INTO `buildinginfo` VALUES ('5', '5', '5号楼', '1');
INSERT INTO `buildinginfo` VALUES ('6', '6', '6号楼', '1');
INSERT INTO `buildinginfo` VALUES ('7', '7', '7号楼', '1');
INSERT INTO `buildinginfo` VALUES ('8', '8', '8号楼', '1');
INSERT INTO `buildinginfo` VALUES ('9', '9', '9号楼', '1');
INSERT INTO `buildinginfo` VALUES ('10', '10', '10号楼', '1');
INSERT INTO `buildinginfo` VALUES ('11', '11', '11号楼', '1');
INSERT INTO `buildinginfo` VALUES ('12', '12', '12号楼', '1');
INSERT INTO `buildinginfo` VALUES ('13', '13', '13号楼', '1');
INSERT INTO `buildinginfo` VALUES ('14', '14', '14号楼', '1');
INSERT INTO `buildinginfo` VALUES ('15', '15', '15号楼', '1');
INSERT INTO `buildinginfo` VALUES ('16', '16', '16号楼', '1');
INSERT INTO `buildinginfo` VALUES ('17', '17', '17号楼', '1');
INSERT INTO `buildinginfo` VALUES ('18', '18', '18号楼', '1');
INSERT INTO `buildinginfo` VALUES ('19', '19', '19号楼', '1');
INSERT INTO `buildinginfo` VALUES ('20', '20', '20号楼', '1');
INSERT INTO `buildinginfo` VALUES ('21', '21', '21号楼', '1');
INSERT INTO `buildinginfo` VALUES ('22', '22', '22号楼', '1');
INSERT INTO `buildinginfo` VALUES ('23', '23', '23号楼', '1');
INSERT INTO `buildinginfo` VALUES ('24', '24', '24号楼', '1');
INSERT INTO `buildinginfo` VALUES ('25', '25', '25号楼', '1');
INSERT INTO `buildinginfo` VALUES ('26', '26', '26号楼', '1');
INSERT INTO `buildinginfo` VALUES ('27', '27', '27号楼', '1');

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
INSERT INTO `enterpriseinfo` VALUES ('1', '1号公司', 'npc1', '', '1');
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
INSERT INTO `enterpriseinfo` VALUES ('19', '2', '1', '1', '1');

-- ----------------------------
-- Table structure for leaseinfo
-- ----------------------------
DROP TABLE IF EXISTS `leaseinfo`;
CREATE TABLE `leaseinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `owner` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '业主',
  `roomNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '房号',
  `buildingName` varchar(255) DEFAULT NULL COMMENT '所属办公楼',
  `depositOnContracts` varchar(255) DEFAULT NULL COMMENT '合同保证金',
  `leaseTerm` varchar(255) DEFAULT NULL COMMENT '租期',
  `startingLeasePeriod` date DEFAULT NULL COMMENT '起租期',
  `terminationPeriod` date DEFAULT NULL COMMENT '终止期',
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
  `isPayBond` varchar(255) DEFAULT '1' COMMENT '保证金是否支付',
  `isPayFirstRent` varchar(255) DEFAULT '1' COMMENT '首年租金是否支付',
  `isPaySecondRent` varchar(255) DEFAULT '1' COMMENT '第二年租金是否支付',
  `rentalUnits` varchar(255) DEFAULT NULL COMMENT '出租单元数',
  `annualTurnoverInterval` varchar(255) DEFAULT NULL COMMENT '年成交额区间',
  `dailyQuantityInterval` varchar(255) DEFAULT NULL COMMENT '日均单量区间',
  `register` varchar(255) DEFAULT NULL COMMENT '注册',
  `state` int(255) DEFAULT '1' COMMENT '记录状态',
  PRIMARY KEY (`id`),
  KEY `buildingName` (`buildingName`),
  CONSTRAINT `leaseinfo_ibfk_2` FOREIGN KEY (`buildingName`) REFERENCES `buildinginfo` (`buildingname`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='租赁信息表';

-- ----------------------------
-- Records of leaseinfo
-- ----------------------------
INSERT INTO `leaseinfo` VALUES ('1', '小米', '101', '2号楼', '45', '1', '2019-08-23', '2019-08-30', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '是', '是', '是', '1', '1', '1', '1', '1');
INSERT INTO `leaseinfo` VALUES ('2', '小红', '102', '2号楼', '2', '2', '2019-08-24', '2019-08-30', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '是', '是', '否', '2', '2', '2', '2', '1');
INSERT INTO `leaseinfo` VALUES ('3', '1111', '101', '2号楼', '1200', '12', '2019-08-23', '2019-08-31', '500', '2', '60000', '120', '1200', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '是', '否', '是', '1', '10', '10', '1', '1');
INSERT INTO `leaseinfo` VALUES ('4', '黄霞', '201', '2号楼', '1500', '12', '2019-08-21', '2019-08-24', '125', '12', '112500', '900', '500', '45875', '120', '5', '45000', '375', '500', '45875', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '是', '否', '否', '1', '1', '1', '1', '1');
INSERT INTO `leaseinfo` VALUES ('5', '关晓红', '201', '2号楼', '1200', '5', '2019-08-23', '2019-08-30', '100', '5', '25000', '250', '1250', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '是', '否', '是', '1', '1', '1', '1', '1');
INSERT INTO `leaseinfo` VALUES ('6', '小米', '202', '2号楼', '4', '1', '2019-08-23', '2019-08-30', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '否', '否', '否', '1', '1', '1', '1', '1');
INSERT INTO `leaseinfo` VALUES ('7', '小红', '303', '2号楼', '2', '2', '2019-08-24', '2019-08-30', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '否', '是', '是', '2', '2', '2', '2', '1');
INSERT INTO `leaseinfo` VALUES ('8', '1111', '302', '2号楼', '1200', '12', '2019-08-23', '2019-08-31', '500', '2', '60000', '120', '1200', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '是', '是', '是', '1', '10', '10', '1', '1');
INSERT INTO `leaseinfo` VALUES ('9', '黄霞', '301', '2号楼', '1500', '12', '2019-08-21', '2019-08-24', '125', '12', '112500', '900', '500', '45875', '120', '5', '45000', '375', '500', '45875', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '是', '是', '是', '1', '1', '1', '1', '1');
INSERT INTO `leaseinfo` VALUES ('10', '关晓红', '103', '2号楼', '1200', '5', '2019-08-23', '2019-08-30', '100', '5', '25000', '250', '1250', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '是', '是', '是', '1', '1', '1', '1', '1');
INSERT INTO `leaseinfo` VALUES ('12', '洛克李', '304', '2号楼', '500', '12', '2019-08-24', '2019-08-30', '120', '5', '30000', '250', '500', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '是', '否', '否', '0', '1000-2000', '500-650', '1', '1');
INSERT INTO `leaseinfo` VALUES ('13', '九尾', '102', '2号楼', '1000', '1', '2019-08-24', '2019-08-31', '50', '1', '3000', '60', '1000', '4060', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '是', '是', '否', '0', '1000', '500', '1', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='办公室信息表';

-- ----------------------------
-- Records of roominfo
-- ----------------------------
INSERT INTO `roominfo` VALUES ('1', '101', '2号楼', '50', '80', '小米', '1');
INSERT INTO `roominfo` VALUES ('2', '102', '2号楼', '50', '80', '小红', '1');
INSERT INTO `roominfo` VALUES ('3', '201', '2号楼', '50', '80', '关晓红', '1');
INSERT INTO `roominfo` VALUES ('4', '202', '2号楼', '50', '80', '小米', '1');
INSERT INTO `roominfo` VALUES ('5', '101', '2号楼', '60', '90', '小米', '1');
INSERT INTO `roominfo` VALUES ('6', '102', '2号楼', '60', '90', '九尾', '1');
INSERT INTO `roominfo` VALUES ('7', '201', '2号楼', '75', '100', '黄霞', '1');
INSERT INTO `roominfo` VALUES ('8', '202', '2号楼', '75', '100', null, '1');
INSERT INTO `roominfo` VALUES ('9', '103', '2号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('10', '104', '3号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('11', '103', '3号楼', '75', '100', null, '1');
INSERT INTO `roominfo` VALUES ('12', '111', '3号楼', '75', '80', null, '1');
INSERT INTO `roominfo` VALUES ('13', '301', '2号楼', '50', '80', '黄霞', '1');
INSERT INTO `roominfo` VALUES ('14', '302', '2号楼', '50', '80', '1111', '1');
INSERT INTO `roominfo` VALUES ('15', '303', '2号楼', '50', '80', '小红', '1');
INSERT INTO `roominfo` VALUES ('16', '304', '2号楼', '50', '80', '洛克李', '1');
INSERT INTO `roominfo` VALUES ('17', '301', '2号楼', '60', '90', null, '1');
INSERT INTO `roominfo` VALUES ('18', '302', '2号楼', '60', '90', null, '1');
INSERT INTO `roominfo` VALUES ('19', '303', '2号楼', '75', '100', null, '1');
INSERT INTO `roominfo` VALUES ('20', '304', '2号楼', '75', '100', null, '1');
INSERT INTO `roominfo` VALUES ('21', '305', '2号楼', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('22', '306', '2号楼', '213', '124', null, '1');
INSERT INTO `roominfo` VALUES ('23', '103', '2号楼', '131', '131', '关晓红', '1');
INSERT INTO `roominfo` VALUES ('24', '105', '5号楼', '50', '50', null, '1');
INSERT INTO `roominfo` VALUES ('25', '112', '11号楼', '12', '23', null, '1');
INSERT INTO `roominfo` VALUES ('26', '101', '8号楼', '50', '100', null, '1');
INSERT INTO `roominfo` VALUES ('27', '101', '27号楼', '50', '80', null, '1');

-- ----------------------------
-- Table structure for settinginfo
-- ----------------------------
DROP TABLE IF EXISTS `settinginfo`;
CREATE TABLE `settinginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manageExpense` varchar(255) DEFAULT NULL,
  `state` int(255) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统设置信息表';

-- ----------------------------
-- Records of settinginfo
-- ----------------------------
INSERT INTO `settinginfo` VALUES ('1', '1', '1');
