/*
Navicat MySQL Data Transfer

Source Server         : test.db
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : cainiaomessag_db

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-08-08 19:14:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for buildinginfo
-- ----------------------------
DROP TABLE IF EXISTS `buildinginfo`;
CREATE TABLE `buildinginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buildingNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '办公楼房号',
  `buildingName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '办公楼名称',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '记录是否有效',
  PRIMARY KEY (`id`),
  KEY `buildingNumber` (`buildingNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of enterpriseinfo
-- ----------------------------
INSERT INTO `enterpriseinfo` VALUES ('1', '1号公司', 'npc1', '123456', '1');
INSERT INTO `enterpriseinfo` VALUES ('2', '2号公司', 'npc2', '654321', '1');
INSERT INTO `enterpriseinfo` VALUES ('3', '3号公司', 'npc3', '147852', '1');

-- ----------------------------
-- Table structure for roominfo
-- ----------------------------
DROP TABLE IF EXISTS `roominfo`;
CREATE TABLE `roominfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomNumber` varchar(255) DEFAULT NULL COMMENT '房间号',
  `buildingNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '办公楼号',
  `rentArea` varchar(255) DEFAULT NULL COMMENT '计租面积',
  `builtUpArea` varchar(255) DEFAULT NULL COMMENT '建筑面积',
  `owner` varchar(255) DEFAULT NULL COMMENT '业主',
  `state` varchar(255) DEFAULT '1' COMMENT '记录状态',
  PRIMARY KEY (`id`),
  KEY `buildingNumber` (`buildingNumber`),
  CONSTRAINT `roominfo_ibfk_1` FOREIGN KEY (`buildingNumber`) REFERENCES `buildinginfo` (`buildingnumber`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of roominfo
-- ----------------------------
INSERT INTO `roominfo` VALUES ('1', '101', '1', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('2', '102', '1', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('3', '201', '1', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('4', '202', '1', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('5', '101', '2', '60', '90', null, '1');
INSERT INTO `roominfo` VALUES ('6', '102', '2', '60', '90', null, '1');
INSERT INTO `roominfo` VALUES ('7', '201', '3', '75', '100', null, '1');
INSERT INTO `roominfo` VALUES ('8', '202', '3', '75', '100', null, '1');
INSERT INTO `roominfo` VALUES ('9', '103', '1', '50', '80', null, '1');
INSERT INTO `roominfo` VALUES ('10', '104', '1', '50', '80', null, '1');
