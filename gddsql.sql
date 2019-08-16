/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : cainiaomessag_db

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2019-08-16 16:38:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `buildinginfo`
-- ----------------------------
DROP TABLE IF EXISTS `buildinginfo`;
CREATE TABLE `buildinginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buildingNumber` varchar(20) DEFAULT NULL,
  `buildingName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buildinginfo
-- ----------------------------
INSERT INTO `buildinginfo` VALUES ('1', '1', '创新楼');

-- ----------------------------
-- Table structure for `dormitory`
-- ----------------------------
DROP TABLE IF EXISTS `dormitory`;
CREATE TABLE `dormitory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dormitoryName` varchar(255) DEFAULT NULL,
  `money` varchar(50) DEFAULT NULL,
  `isfull` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormitory
-- ----------------------------
INSERT INTO `dormitory` VALUES ('1', '1号楼', '1000', '0');
INSERT INTO `dormitory` VALUES ('2', '2号楼', '2000', '0');
INSERT INTO `dormitory` VALUES ('3', '3号楼', '1500', '0');
INSERT INTO `dormitory` VALUES ('4', '4号楼', '1600', '0');

-- ----------------------------
-- Table structure for `dormitorymanage`
-- ----------------------------
DROP TABLE IF EXISTS `dormitorymanage`;
CREATE TABLE `dormitorymanage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `contactNumber` varchar(255) DEFAULT NULL,
  `dormitoryNum` varchar(50) DEFAULT NULL,
  `contractSigning` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `leasePeriod` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `isdelete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_bn` (`dormitoryNum`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dormitorymanage
-- ----------------------------
INSERT INTO `dormitorymanage` VALUES ('5', '6', '6', '6', '1号楼', '0000-00-00 00:00:00', '2', '2000', '0');
INSERT INTO `dormitorymanage` VALUES ('6', '7', '7', '7', '1', '2019-08-16 10:37:57', '8', null, '1');
INSERT INTO `dormitorymanage` VALUES ('7', 'gw', 'gff', '123', '1号楼', '2019-08-16 10:37:59', '12', null, '1');
INSERT INTO `dormitorymanage` VALUES ('8', 'e', 'qwe', '12333', '2号楼', '2019-08-15 10:03:51', '6', '12000', '0');
INSERT INTO `dormitorymanage` VALUES ('9', '12', '12', '12', '1号楼', '2019-08-16 10:32:33', '7', '2000', '0');
INSERT INTO `dormitorymanage` VALUES ('10', '11', '22', '33', '4号楼', '2019-08-16 10:33:18', '2', '3200', '0');
INSERT INTO `dormitorymanage` VALUES ('11', 'qqq', '123', '144', '1号楼', '2019-08-16 10:35:39', '8', '8000', '0');
