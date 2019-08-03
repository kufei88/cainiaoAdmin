/*
Navicat MySQL Data Transfer

Source Server         : test.db
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : cainiaomessag_db

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-08-03 15:01:27
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
  `roomArea` varchar(255) DEFAULT NULL COMMENT '房间面积',
  `hardwareSituation` varchar(255) DEFAULT NULL COMMENT '硬件情况',
  `rent` varchar(255) DEFAULT NULL COMMENT '租金',
  `additionalConditions` varchar(255) DEFAULT NULL COMMENT '附加条件',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '记录是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of buildinginfo
-- ----------------------------
INSERT INTO `buildinginfo` VALUES ('1', '1-103', '创新楼', '22', '基础设施完全', '1.8', '无', '1');
INSERT INTO `buildinginfo` VALUES ('2', '1-102', '实验楼', '25', '基础设施完全', '2.5', '无', '1');
INSERT INTO `buildinginfo` VALUES ('3', '2-101', '教学楼', '30', '基础设施完全', '3', '无', '1');
INSERT INTO `buildinginfo` VALUES ('4', '2-234', '测试楼', '24', '基础设施完善', '5', '无', '1');
INSERT INTO `buildinginfo` VALUES ('5', '1-212', '测试楼2', '88', '啥都没有', '12', '无', '1');
INSERT INTO `buildinginfo` VALUES ('6', '2-215', '学士苑', '38', '基础设施完善', '10', '押一付三', '1');
INSERT INTO `buildinginfo` VALUES ('7', '3-524', '龙川北苑', '56', '基础设施完善', '10', '无', '1');
INSERT INTO `buildinginfo` VALUES ('8', '5-124', '鹿田南苑', '44', '无', '10.3', '无', '1');
INSERT INTO `buildinginfo` VALUES ('9', '11-323', '明月楼', '45', '标配', '8.6', '无', '1');
INSERT INTO `buildinginfo` VALUES ('10', '1', '2', '3', '4', '5', '6', '1');
INSERT INTO `buildinginfo` VALUES ('11', '2', '2', '2', '2', '2', '2', '1');
INSERT INTO `buildinginfo` VALUES ('12', '1-103', '创新楼', '22', '基础设施完全', '1.8', '无', '1');
INSERT INTO `buildinginfo` VALUES ('13', '1-102', '实验楼', '25', '基础设施完全', '2.5', '无', '1');
INSERT INTO `buildinginfo` VALUES ('14', '2-101', '教学楼', '30', '基础设施完全', '3', '无', '1');
INSERT INTO `buildinginfo` VALUES ('15', '2-234', '测试楼', '24', '基础设施完善', '5', '无', '1');
INSERT INTO `buildinginfo` VALUES ('16', '1-212', '测试楼2', '88', '啥都没有', '12', '无', '1');
INSERT INTO `buildinginfo` VALUES ('17', '2-215', '学士苑', '38', '基础设施完善', '10', '押一付三', '1');
