/*
Navicat MySQL Data Transfer

Source Server         : test.db
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : cainiaomessag_db

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-09-08 15:38:59
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
INSERT INTO `buildinginfo` VALUES ('28', '28', '28号楼', '1');
INSERT INTO `buildinginfo` VALUES ('30', '33', '33号楼', '1');
INSERT INTO `buildinginfo` VALUES ('31', '34', '34号楼', '1');

-- ----------------------------
-- Table structure for dormitory
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dormitoryName` varchar(255) DEFAULT NULL,
  `money` varchar(50) DEFAULT NULL,
  `isfull` tinyint(4) DEFAULT '0',
  `isdelete` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormitory
-- ----------------------------
INSERT INTO `dormitory` VALUES ('1', '1号楼', '1000', '0', '0');
INSERT INTO `dormitory` VALUES ('2', '2号楼', '2000', '0', '0');
INSERT INTO `dormitory` VALUES ('3', '3号楼', '1500', '0', '0');
INSERT INTO `dormitory` VALUES ('4', '4号楼', '1600', '0', '0');
INSERT INTO `dormitory` VALUES ('5', '5号楼', '1000', '0', '0');
INSERT INTO `dormitory` VALUES ('6', '6号楼', '1000', '0', '0');
INSERT INTO `dormitory` VALUES ('7', 'ss', '1200', '0', '0');
INSERT INTO `dormitory` VALUES ('8', 'L1', '111', '0', '0');
INSERT INTO `dormitory` VALUES ('9', '9号楼', '1000', '0', '0');
INSERT INTO `dormitory` VALUES ('10', 'qq', '100', '0', '0');
INSERT INTO `dormitory` VALUES ('11', '11号楼', '1000', '0', '0');

-- ----------------------------
-- Table structure for dormitorymanage
-- ----------------------------
DROP TABLE IF EXISTS `dormitorymanage`;
CREATE TABLE `dormitorymanage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `contactNumber` varchar(255) DEFAULT NULL,
  `dormitoryNum` varchar(50) DEFAULT NULL,
  `contractSigning` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `leasePeriod` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `isdelete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_bn` (`dormitoryNum`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormitorymanage
-- ----------------------------
INSERT INTO `dormitorymanage` VALUES ('5', '6', '6', '6', '1号楼', '2019-09-07 08:45:43', '2019-11-05', null, '2', '2000', '1');
INSERT INTO `dormitorymanage` VALUES ('6', '7', '10', '7', '1号楼', '2019-09-03 20:15:14', '2019-09-02', '2019-09-02', '8', '8000', '0');
INSERT INTO `dormitorymanage` VALUES ('7', 'gw', '111111111', '123', '1号楼', '2019-09-03 20:15:16', '2019-09-02', '2019-09-02', '12', '12000', '0');
INSERT INTO `dormitorymanage` VALUES ('8', 'qw', '787', '12333', '2号楼', '2019-09-03 20:15:15', '2019-09-02', '2019-09-02', '6', '12000', '0');
INSERT INTO `dormitorymanage` VALUES ('9', '12', '12', '12', '1号楼', '2019-09-03 10:17:41', '2019-09-02', '2019-09-02', '7', '7000', '0');
INSERT INTO `dormitorymanage` VALUES ('10', '11', '21', '33', '4号楼', '2019-09-02 15:18:17', '2019-09-02', '2019-09-02', '2', '3200', '0');
INSERT INTO `dormitorymanage` VALUES ('11', 'qqq', '123', '144', '1号楼', '2019-09-02 15:18:17', '2019-09-02', '2019-09-02', '8', '8000', '0');
INSERT INTO `dormitorymanage` VALUES ('12', 'q', '222', '111111111', '1号楼', '2019-09-03 20:15:17', '2019-09-02', '2019-09-02', '1', '1000', '0');
INSERT INTO `dormitorymanage` VALUES ('13', '123', '123123', '123123123123', '1号楼', '2019-09-03 20:15:18', '2019-09-02', '2019-09-02', '1', '1000', '0');
INSERT INTO `dormitorymanage` VALUES ('14', '123', '11111', '111111', '3号楼', '2019-09-03 20:15:19', '2019-09-02', '2019-09-02', '1', '1500', '0');
INSERT INTO `dormitorymanage` VALUES ('15', '333', '333', '333', '1号楼', '2019-09-03 20:15:23', '2019-09-02', '2019-11-02', '2', '2000', '0');
INSERT INTO `dormitorymanage` VALUES ('16', '55', '5555', '565656', '1号楼', '2019-09-07 08:46:17', '2019-09-02', '2020-01-02', '4', '2000', '1');
INSERT INTO `dormitorymanage` VALUES ('17', '5566', '66677', '7788', '2号楼', '2019-09-07 18:26:25', '2019-09-02', '2019-12-02', '3', '4000', '1');
INSERT INTO `dormitorymanage` VALUES ('18', '9', '9999', '999999', '3号楼', '2019-09-03 10:17:37', '2019-09-02', '2020-02-02', '5', '5000', '0');
INSERT INTO `dormitorymanage` VALUES ('19', 'c', 'c', '66666', '1号楼', '2019-09-02 15:21:48', '2019-09-26', '2020-01-25', '4', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('20', '1', '2', '3', '1号楼', '2019-09-02 15:41:51', '2019-09-26', '2020-01-25', '4', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('21', 'r', 'r', 'r', '1号楼', '2019-09-07 18:27:15', '2019-09-19', '2019-11-18', '2', '2000', '1');
INSERT INTO `dormitorymanage` VALUES ('22', '4', '4', '4', '1号楼', '2019-09-02 15:45:57', '2019-09-28', '2020-01-27', '4', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('23', '蛙蛙 ', '蛙蛙', '23123123121', '1号楼', '2019-09-04 21:02:09', '2019-09-06', '2019-11-06', '2', '4000', '1');
INSERT INTO `dormitorymanage` VALUES ('24', '211', '认日', '2232313', '1号楼', '2019-09-04 21:02:17', '2019-09-06', '2019-11-06', '2', '4000', '1');
INSERT INTO `dormitorymanage` VALUES ('25', '123123', '呃呃呃', '1123123123', '1号楼', '2019-09-04 21:02:13', '2019-09-05', '2019-11-05', '2', '4000', '1');
INSERT INTO `dormitorymanage` VALUES ('26', '蛙蛙', '蛙蛙', '2131', '1号楼', '2019-09-04 21:02:14', '2019-09-06', '2019-11-06', '2', '4000', '1');
INSERT INTO `dormitorymanage` VALUES ('27', '请问请问', '蛙蛙', '31231231', '1号楼', '2019-09-04 21:02:15', '2019-09-06', '2019-11-06', '2', '4000', '1');
INSERT INTO `dormitorymanage` VALUES ('28', '121', '22222', '3333333', '1号楼', '2019-09-04 21:02:58', '2019-09-06', '2019-11-06', '2', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('29', '地方', '阿萨大', '23123123', '1号楼', '2019-09-04 21:05:51', '2019-09-06', '2019-11-06', '2', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('30', '请问请问', '23123', '12312321312', '1号楼', '2019-09-04 21:06:27', '2019-09-06', '2019-11-06', '2', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('31', '请问倒打灯', 'w\'w\'w', '65432231', '1号楼', '2019-09-04 21:08:21', '2019-09-06', '2019-11-06', '2', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('32', '委屈', '231232312', '23123123123', '1号楼', '2019-09-04 21:16:47', '2019-09-06', '2019-11-06', '2', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('33', '蛙蛙', '蛙蛙', '123123', '1号楼', '2019-09-04 21:23:17', '2019-09-05', '2019-11-05', '2', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('34', '我去饿', '123123', '123123123', '1号楼', '2019-09-04 21:34:27', '2019-09-06', '2019-11-06', '2', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('35', '2313', '问问去', '1231231', '1号楼', '2019-09-04 21:35:40', '2019-09-06', '2019-11-06', '2', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('36', '请问请问', '23123', '123213', '1号楼', '2019-09-05 14:18:05', '2019-09-06', '2019-11-06', '2', '4000', '1');
INSERT INTO `dormitorymanage` VALUES ('37', '123', '蛙蛙', '111111', '1号楼', '2019-09-05 17:10:13', '2019-09-06', '2019-11-06', '2', null, '0');
INSERT INTO `dormitorymanage` VALUES ('38', '12312', '王哇哇', '111111', '1号楼', '2019-09-05 17:11:52', '2019-09-06', '2019-11-06', '2', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('39', '123', '钱钱钱', '2312', '1号楼', '2019-09-05 18:50:49', '2019-09-06', '2019-11-06', '2', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('40', '2131', 'qweqw', '2222', '11号楼', '2019-09-07 09:23:51', '2019-09-07', '2019-11-07', '2', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('44', 'xx', 'ddd', '13233662', '11号楼', '2019-09-07 12:55:43', '2019-09-07', '2019-11-07', '2', '4000', '0');
INSERT INTO `dormitorymanage` VALUES ('45', 'xs', 'www', '114455667', '11号楼', '2019-09-07 12:55:43', '2019-09-07', '2019-11-07', '2', '2000', '0');
INSERT INTO `dormitorymanage` VALUES ('46', 'www', 'gxxxx', '-1430928128', '11号楼', '2019-09-07 19:10:53', '2019-09-07', '2019-11-07', '2', '2000', '0');
INSERT INTO `dormitorymanage` VALUES ('47', 'rrrr', 'rrrrr', '-572589576', '1号楼', '2019-09-07 18:44:32', '2019-09-19', '2019-11-19', '2', '2000', '0');
INSERT INTO `dormitorymanage` VALUES ('48', 'rfff', 'ffff', '1111111', '5号楼', '2019-09-07 19:16:47', '2019-09-20', '2019-11-20', '2', '4000', '1');
INSERT INTO `dormitorymanage` VALUES ('49', '22222', '2224344545', '-572589576', '6号楼', '2019-09-08 12:36:41', '2019-09-21', '2019-11-21', '2', '6000', '0');
INSERT INTO `dormitorymanage` VALUES ('50', 'oo', 'ppp', '6677889', '11号楼', '2019-09-08 12:36:17', '2019-09-13', '2019-11-13', '2', '2000', '0');
INSERT INTO `dormitorymanage` VALUES ('51', 'gg', 'hhhhh', '-1199928350', '11号楼', '2019-09-08 12:37:37', '2019-09-09', '2019-11-09', '2', '2000', '0');
INSERT INTO `dormitorymanage` VALUES ('52', 'qwe', 'sss', '1312246677990', '9号楼', '2019-09-08 12:40:45', '2019-09-14', '2019-11-14', '2', '2000', '0');

-- ----------------------------
-- Table structure for dorms
-- ----------------------------
DROP TABLE IF EXISTS `dorms`;
CREATE TABLE `dorms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `htId` varchar(50) DEFAULT '0' COMMENT '合同编号',
  `domitoryId` int(11) DEFAULT NULL COMMENT '寝室编号',
  `dromNum` varchar(11) DEFAULT NULL COMMENT '宿舍编号',
  `isfull` tinyint(4) unsigned zerofill DEFAULT '0000',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dorms
-- ----------------------------
INSERT INTO `dorms` VALUES ('1', '我去饿', '1', '101', '0001');
INSERT INTO `dorms` VALUES ('2', '我去饿', '1', '102', '0001');
INSERT INTO `dorms` VALUES ('3', '请问请问', '1', '103', '0001');
INSERT INTO `dorms` VALUES ('4', '0', '2', '101', '0000');
INSERT INTO `dorms` VALUES ('5', '0', '2', '102', '0000');
INSERT INTO `dorms` VALUES ('6', '0', '2', '103', '0000');
INSERT INTO `dorms` VALUES ('7', '9', '3', '101', '0001');
INSERT INTO `dorms` VALUES ('8', '9', '3', '102', '0001');
INSERT INTO `dorms` VALUES ('9', '0', '4', '101', '0000');
INSERT INTO `dorms` VALUES ('10', '0', '4', '102', '0000');
INSERT INTO `dorms` VALUES ('11', '请问请问', '1', '104', '0001');
INSERT INTO `dorms` VALUES ('12', '12312', '1', '105', '0001');
INSERT INTO `dorms` VALUES ('13', '12312', '1', '201', '0001');
INSERT INTO `dorms` VALUES ('14', '123', '1', '202', '0001');
INSERT INTO `dorms` VALUES ('15', '123', '1', '203', '0001');
INSERT INTO `dorms` VALUES ('16', '0', '1', '204', '0000');
INSERT INTO `dorms` VALUES ('17', '0', '1', '205', '0000');
INSERT INTO `dorms` VALUES ('18', '22222', '1', '301', '0001');
INSERT INTO `dorms` VALUES ('19', '22222', '5', '101', '0001');
INSERT INTO `dorms` VALUES ('20', '22222', '6', '101', '0001');
INSERT INTO `dorms` VALUES ('21', '0', '7', '101', '0000');
INSERT INTO `dorms` VALUES ('22', '0', '8', '101', '0000');
INSERT INTO `dorms` VALUES ('23', 'qwe', '9', '101', '0001');
INSERT INTO `dorms` VALUES ('24', '0', '10', '101', '0000');
INSERT INTO `dorms` VALUES ('25', '0', '10', '102', '0000');
INSERT INTO `dorms` VALUES ('26', '2131', '11', '101', '0001');
INSERT INTO `dorms` VALUES ('27', '2131', '11', '102', '0001');
INSERT INTO `dorms` VALUES ('28', 'gg', '11', '103', '0001');
INSERT INTO `dorms` VALUES ('29', 'oo', '11', '201', '0001');
INSERT INTO `dorms` VALUES ('30', 'www', '11', '202', '0001');
INSERT INTO `dorms` VALUES ('31', 'xs', '11', '203', '0001');
INSERT INTO `dorms` VALUES ('32', 'xx', '11', '301', '0001');
INSERT INTO `dorms` VALUES ('33', 'xx', '11', '302', '0001');
INSERT INTO `dorms` VALUES ('34', '0', '11', '303', '0000');

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
INSERT INTO `enterpriseinfo` VALUES ('1', '1号公司', 'npc1', '17857075856', '1');
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
-- Table structure for hydropower
-- ----------------------------
DROP TABLE IF EXISTS `hydropower`;
CREATE TABLE `hydropower` (
  `id` int(11) NOT NULL,
  `water` float(12,2) unsigned zerofill DEFAULT NULL,
  `electricity` float(12,2) unsigned zerofill DEFAULT NULL,
  `establishTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of hydropower
-- ----------------------------
INSERT INTO `hydropower` VALUES ('1', '000000001.20', '000000001.50', '2019-08-01 00:00:00', '2019-09-07 00:00:00');

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
  `isPayBond` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '否' COMMENT '保证金是否支付',
  `isPayFirstRent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '否' COMMENT '首年租金是否支付',
  `isPaySecondRent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '否' COMMENT '第二年租金是否支付',
  `rentalUnits` varchar(255) DEFAULT NULL COMMENT '出租单元数',
  `annualTurnoverInterval` varchar(255) DEFAULT NULL COMMENT '年成交额区间',
  `dailyQuantityInterval` varchar(255) DEFAULT NULL COMMENT '日均单量区间',
  `register` varchar(255) DEFAULT NULL COMMENT '注册',
  `state` int(255) DEFAULT '1' COMMENT '记录状态',
  PRIMARY KEY (`id`),
  KEY `buildingName` (`buildingName`),
  CONSTRAINT `leaseinfo_ibfk_2` FOREIGN KEY (`buildingName`) REFERENCES `buildinginfo` (`buildingname`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='租赁信息表';

-- ----------------------------
-- Records of leaseinfo
-- ----------------------------
INSERT INTO `leaseinfo` VALUES ('1', '1', '102', '1号楼', '1', '1', '2019-09-03', '2019-10-02', '1', '1', '50', '50', '1', '101', '1', '1', '50', '50', '1', null, '2', '2', '200', '100', '2', '302', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '是', '是', '是', '1', '1', '1', '1', '1');
INSERT INTO `leaseinfo` VALUES ('2', '2', '101', '2号楼', '15000', '6', '2019-09-03', '2020-03-02', '50', '3', '9000', '180', '500', '9680', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '是', '是', '是', '1', '1', '1', '1', '1');
INSERT INTO `leaseinfo` VALUES ('3', '张三', '103', '3号楼', '3000', '36', '2019-09-08', '2022-09-07', '10', '12', '9000', '1800', '200', '11000', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '是', '是', '是', '1', '2', '2', '2', '1');

-- ----------------------------
-- Table structure for paymentinfo
-- ----------------------------
DROP TABLE IF EXISTS `paymentinfo`;
CREATE TABLE `paymentinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `WaterNumber` float(15,2) DEFAULT NULL,
  `ElectricityNumber` float(15,2) DEFAULT NULL,
  `EnterpriseNumber` varchar(255) DEFAULT NULL,
  `roomNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `establishTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `waterCost` float(15,2) DEFAULT NULL,
  `electricityCost` float(15,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=920 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of paymentinfo
-- ----------------------------
INSERT INTO `paymentinfo` VALUES ('888', '10.00', '133.00', '钉钉', '205', '2019-08-07 00:00:00', '2019-09-08 00:00:00', '2019-09-06 00:00:00', '2019-09-29 00:00:00', '12.00', '199.50');
INSERT INTO `paymentinfo` VALUES ('889', '20.00', '20.00', '钉钉', '206', '2019-08-07 00:00:00', null, '2019-08-06 00:00:00', '2019-09-29 00:00:00', '24.00', '30.00');
INSERT INTO `paymentinfo` VALUES ('890', '30.00', '30.00', '钉钉', '207', '2019-08-07 00:00:00', null, '2019-09-06 00:00:00', '2019-09-29 00:00:00', '36.00', '45.00');
INSERT INTO `paymentinfo` VALUES ('891', '30.00', '30.00', '钉钉', '207', '2019-08-07 00:00:00', null, '2019-07-31 00:00:00', '2019-08-31 00:00:00', '36.00', '45.00');
INSERT INTO `paymentinfo` VALUES ('893', '30.00', '30.00', '钉钉', '205', '2019-08-07 00:00:00', null, '2017-07-31 00:00:00', '2019-08-31 00:00:00', '36.00', '45.00');
INSERT INTO `paymentinfo` VALUES ('894', '30.00', '30.00', '钉钉', '205', '2019-08-07 00:00:00', null, '2018-09-06 00:00:00', '2018-08-31 00:00:00', '36.00', '45.00');
INSERT INTO `paymentinfo` VALUES ('895', '10.00', '10.00', '钉钉', '205', '2019-08-07 00:00:00', null, '2016-12-31 00:00:00', '2019-02-27 00:00:00', '12.00', '15.00');
INSERT INTO `paymentinfo` VALUES ('897', '10.00', '10.00', '工坊1', '101', '2019-09-08 00:00:00', null, '2019-09-07 00:00:00', '2019-10-07 00:00:00', '12.00', '15.00');
INSERT INTO `paymentinfo` VALUES ('898', '15.00', '15.00', '工坊2', '102', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '18.00', '22.50');
INSERT INTO `paymentinfo` VALUES ('899', '16.00', '16.00', '工坊3', '103', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '19.20', '24.00');
INSERT INTO `paymentinfo` VALUES ('900', '17.00', '17.00', '工坊4', '104', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '20.40', '25.50');
INSERT INTO `paymentinfo` VALUES ('901', '19.00', '19.00', '工坊6', '106', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '22.80', '28.50');
INSERT INTO `paymentinfo` VALUES ('902', '18.00', '18.00', '工坊5', '105', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '21.60', '27.00');
INSERT INTO `paymentinfo` VALUES ('903', '20.00', '20.00', '工坊7', '107', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '24.00', '30.00');
INSERT INTO `paymentinfo` VALUES ('904', '21.00', '21.00', '工坊8', '108', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '25.20', '31.50');
INSERT INTO `paymentinfo` VALUES ('905', '22.00', '22.00', '工坊9', '109', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '26.40', '33.00');
INSERT INTO `paymentinfo` VALUES ('906', '23.00', '23.00', '工坊10', '110', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '27.60', '34.50');
INSERT INTO `paymentinfo` VALUES ('907', '24.00', '24.00', '工坊11', '111', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '28.80', '36.00');
INSERT INTO `paymentinfo` VALUES ('908', '25.00', '25.00', '工坊12', '112', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '30.00', '37.50');
INSERT INTO `paymentinfo` VALUES ('909', '20.00', '20.00', '工坊18', '118', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '24.00', '30.00');
INSERT INTO `paymentinfo` VALUES ('910', '18.00', '18.00', '工坊16', '116', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '21.60', '27.00');
INSERT INTO `paymentinfo` VALUES ('911', '19.00', '19.00', '工坊17', '117', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '22.80', '28.50');
INSERT INTO `paymentinfo` VALUES ('912', '16.00', '16.00', '工坊14', '114', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '19.20', '24.00');
INSERT INTO `paymentinfo` VALUES ('913', '15.00', '15.00', '工坊13', '113', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '18.00', '22.50');
INSERT INTO `paymentinfo` VALUES ('914', '17.00', '17.00', '工坊15', '115', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '20.40', '25.50');
INSERT INTO `paymentinfo` VALUES ('915', '21.00', '21.00', '工坊19', '119', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '25.20', '31.50');
INSERT INTO `paymentinfo` VALUES ('916', '22.00', '22.00', '工坊20', '120', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '26.40', '33.00');
INSERT INTO `paymentinfo` VALUES ('917', '23.00', '23.00', '工坊21', '121', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '27.60', '34.50');
INSERT INTO `paymentinfo` VALUES ('918', '24.00', '24.00', '工坊22', '122', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '28.80', '36.00');
INSERT INTO `paymentinfo` VALUES ('919', '25.00', '25.00', '工坊23', '123', '2019-09-08 00:00:00', null, '2019-09-08 00:00:00', '2019-10-08 00:00:00', '30.00', '37.50');

-- ----------------------------
-- Table structure for renewals
-- ----------------------------
DROP TABLE IF EXISTS `renewals`;
CREATE TABLE `renewals` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dormitoryMid` int(11) DEFAULT NULL COMMENT '合同编号',
  `leasePeriod` varchar(50) DEFAULT NULL COMMENT '续租租期',
  `remark` varchar(50) DEFAULT NULL COMMENT '续租租金',
  `startDate` varchar(50) DEFAULT NULL COMMENT '续租起始日期',
  `endDate` varchar(50) DEFAULT NULL COMMENT '续租结束日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of renewals
-- ----------------------------
INSERT INTO `renewals` VALUES ('1', '18', '2', '2000', '2020-01-25', '2020-03-25');
INSERT INTO `renewals` VALUES ('2', '18', '2', '2000', '2020-02-02', '2020-04-02');
INSERT INTO `renewals` VALUES ('3', '18', '2', '2000', '2020-02-02', '2020-04-02');
INSERT INTO `renewals` VALUES ('4', '18', '2', '2000', '2020-02-02', '2020-04-02');
INSERT INTO `renewals` VALUES ('5', '18', '2', '2000', '2020-02-02', '2020-04-02');
INSERT INTO `renewals` VALUES ('6', '18', '2', '2000', '2020-02-02', '2020-04-02');
INSERT INTO `renewals` VALUES ('7', '18', '2', '2000', '2020-03-25', '2020-05-25');
INSERT INTO `renewals` VALUES ('8', '21', '2', '2000', '2019-11-18', '2020-01-18');
INSERT INTO `renewals` VALUES ('9', '21', '2', '2000', '2020-01-18', '2020-03-18');
INSERT INTO `renewals` VALUES ('10', '6', '2', '2000', '2019-09-02', '2019-11-02');
INSERT INTO `renewals` VALUES ('11', '7', '3', '3000', '2019-09-02', '2019-12-02');
INSERT INTO `renewals` VALUES ('12', '13', '2', '2000', '2019-09-02', '2019-11-02');
INSERT INTO `renewals` VALUES ('13', '13', '3', '3000', '2019-11-02', '2020-02-02');
INSERT INTO `renewals` VALUES ('14', '12', '2', '2000', '2019-09-02', '2019-11-02');
INSERT INTO `renewals` VALUES ('15', '6', '2', '2000', '2019-11-02', '2020-01-02');
INSERT INTO `renewals` VALUES ('16', '7', '2', '2000', '2019-12-02', '2020-02-02');
INSERT INTO `renewals` VALUES ('17', '7', '2', '2000', '2020-02-02', '2020-04-02');

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
  `owner` varchar(255) DEFAULT '空闲' COMMENT '业主',
  `state` varchar(255) DEFAULT '1' COMMENT '记录状态',
  PRIMARY KEY (`id`),
  KEY `buildingName` (`buildingName`),
  KEY `roomNumber` (`roomNumber`),
  CONSTRAINT `roominfo_ibfk_1` FOREIGN KEY (`buildingName`) REFERENCES `buildinginfo` (`buildingname`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='办公室信息表';

-- ----------------------------
-- Records of roominfo
-- ----------------------------
INSERT INTO `roominfo` VALUES ('1', '102', '1号楼', '50', '80', '1', '1');
INSERT INTO `roominfo` VALUES ('2', '203', '2号楼', '50', '80', '空闲', '1');
INSERT INTO `roominfo` VALUES ('3', '201', '2号楼', '50', '80', '空闲', '1');
INSERT INTO `roominfo` VALUES ('4', '202', '2号楼', '50', '80', '空闲', '1');
INSERT INTO `roominfo` VALUES ('5', '101', '2号楼', '60', '90', '2', '1');
INSERT INTO `roominfo` VALUES ('6', '102', '2号楼', '60', '90', '空闲', '1');
INSERT INTO `roominfo` VALUES ('7', '204', '2号楼', '75', '100', '空闲', '1');
INSERT INTO `roominfo` VALUES ('8', '205', '2号楼', '75', '100', '空闲', '1');
INSERT INTO `roominfo` VALUES ('9', '103', '2号楼', '50', '80', '空闲', '1');
INSERT INTO `roominfo` VALUES ('10', '104', '3号楼', '50', '80', '空闲', '1');
INSERT INTO `roominfo` VALUES ('11', '103', '3号楼', '75', '100', '张三', '1');
INSERT INTO `roominfo` VALUES ('12', '111', '3号楼', '75', '80', '空闲', '1');
INSERT INTO `roominfo` VALUES ('13', '301', '2号楼', '50', '80', '空闲', '1');
INSERT INTO `roominfo` VALUES ('14', '302', '2号楼', '50', '80', '空闲', '1');
INSERT INTO `roominfo` VALUES ('15', '303', '2号楼', '50', '80', '空闲', '1');
INSERT INTO `roominfo` VALUES ('16', '304', '2号楼', '50', '80', '空闲', '1');
INSERT INTO `roominfo` VALUES ('17', '401', '2号楼', '60', '90', '空闲', '1');
INSERT INTO `roominfo` VALUES ('18', '402', '2号楼', '60', '90', '空闲', '1');
INSERT INTO `roominfo` VALUES ('19', '403', '2号楼', '75', '100', '空闲', '1');
INSERT INTO `roominfo` VALUES ('20', '404', '2号楼', '75', '100', '空闲', '1');
INSERT INTO `roominfo` VALUES ('21', '405', '2号楼', '50', '80', '空闲', '1');
INSERT INTO `roominfo` VALUES ('22', '406', '2号楼', '213', '124', '空闲', '1');
INSERT INTO `roominfo` VALUES ('23', '407', '2号楼', '131', '131', '空闲', '1');
INSERT INTO `roominfo` VALUES ('24', '105', '5号楼', '50', '50', '空闲', '1');
INSERT INTO `roominfo` VALUES ('25', '112', '11号楼', '12', '23', '空闲', '1');
INSERT INTO `roominfo` VALUES ('26', '101', '8号楼', '50', '100', '空闲', '1');
INSERT INTO `roominfo` VALUES ('27', '101', '27号楼', '50', '80', '空闲', '1');

-- ----------------------------
-- Table structure for settinginfo
-- ----------------------------
DROP TABLE IF EXISTS `settinginfo`;
CREATE TABLE `settinginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manageExpense` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '管理单价',
  `state` int(255) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统设置信息表';

-- ----------------------------
-- Records of settinginfo
-- ----------------------------
INSERT INTO `settinginfo` VALUES ('1', '2', '1');
