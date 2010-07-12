/*
Navicat MySQL Data Transfer

Source Server         : jee
Source Server Version : 50137
Source Host           : localhost:3306
Source Database       : dropdb

Target Server Type    : MYSQL
Target Server Version : 50137
File Encoding         : 65001

Date: 2009-10-18 23:30:12
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `archived`
-- ----------------------------
DROP TABLE IF EXISTS `archived`;
CREATE TABLE `archived` (
  `Tid` int(11) NOT NULL,
  `CDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `EDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Title` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Description` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `Attachment` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `CreatorId` int(11) NOT NULL,
  `ParentTaskId` int(11) NOT NULL,
  `status` varchar(15) CHARACTER SET latin1 NOT NULL DEFAULT '''Finished''',
  `parallel` int(11) DEFAULT NULL,
  `rootTaskId` int(11) NOT NULL,
  PRIMARY KEY (`Tid`),
  KEY `Tid` (`Tid`),
  KEY `Creator` (`CreatorId`) USING BTREE,
  KEY `ParentTask` (`ParentTaskId`) USING BTREE,
  KEY `FK99B337E23B6C24B5` (`CreatorId`),
  KEY `FK99B337E24B220864` (`rootTaskId`),
  KEY `FK99B337E2E0F49A2C` (`ParentTaskId`),
  CONSTRAINT `archived_ibfk_1` FOREIGN KEY (`CreatorId`) REFERENCES `employee` (`EId`),
  CONSTRAINT `archived_ibfk_2` FOREIGN KEY (`ParentTaskId`) REFERENCES `archived` (`Tid`),
  CONSTRAINT `FK99B337E23B6C24B5` FOREIGN KEY (`CreatorId`) REFERENCES `employee` (`EId`),
  CONSTRAINT `FK99B337E24B220864` FOREIGN KEY (`rootTaskId`) REFERENCES `archived` (`Tid`),
  CONSTRAINT `FK99B337E2E0F49A2C` FOREIGN KEY (`ParentTaskId`) REFERENCES `archived` (`Tid`),
  CONSTRAINT `FK_archived_3` FOREIGN KEY (`rootTaskId`) REFERENCES `archived` (`Tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of archived
-- ----------------------------

-- ----------------------------
-- Table structure for `archived_doneby`
-- ----------------------------
DROP TABLE IF EXISTS `archived_doneby`;
CREATE TABLE `archived_doneby` (
  `Tid` int(11) NOT NULL,
  `Eid` int(11) NOT NULL,
  PRIMARY KEY (`Tid`,`Eid`),
  KEY `Tid` (`Tid`),
  KEY `Eid` (`Eid`),
  KEY `FKEBEDA566A4F0431` (`Tid`),
  KEY `FKEBEDA5617BE7AAE` (`Eid`),
  CONSTRAINT `archived_doneby_ibfk_1` FOREIGN KEY (`Tid`) REFERENCES `archived` (`Tid`),
  CONSTRAINT `archived_doneby_ibfk_2` FOREIGN KEY (`Eid`) REFERENCES `employee` (`EId`),
  CONSTRAINT `FKEBEDA5617BE7AAE` FOREIGN KEY (`Eid`) REFERENCES `employee` (`EId`),
  CONSTRAINT `FKEBEDA566A4F0431` FOREIGN KEY (`Tid`) REFERENCES `archived` (`Tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of archived_doneby
-- ----------------------------

-- ----------------------------
-- Table structure for `div_worker`
-- ----------------------------
DROP TABLE IF EXISTS `div_worker`;
CREATE TABLE `div_worker` (
  `DivId` int(11) NOT NULL,
  `Eid` int(11) NOT NULL,
  PRIMARY KEY (`DivId`,`Eid`),
  KEY `DivId` (`DivId`),
  KEY `Eid` (`Eid`),
  KEY `FK915EB6ECEA430312` (`DivId`),
  KEY `FK915EB6EC17BE7AAE` (`Eid`),
  CONSTRAINT `div_worker_ibfk_1` FOREIGN KEY (`DivId`) REFERENCES `divisions` (`DivId`),
  CONSTRAINT `div_worker_ibfk_2` FOREIGN KEY (`Eid`) REFERENCES `employee` (`EId`),
  CONSTRAINT `FK915EB6EC17BE7AAE` FOREIGN KEY (`Eid`) REFERENCES `employee` (`EId`),
  CONSTRAINT `FK915EB6ECEA430312` FOREIGN KEY (`DivId`) REFERENCES `divisions` (`DivId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of div_worker
-- ----------------------------
INSERT INTO `div_worker` VALUES ('1', '10');
INSERT INTO `div_worker` VALUES ('1', '11');
INSERT INTO `div_worker` VALUES ('1', '12');
INSERT INTO `div_worker` VALUES ('1', '13');
INSERT INTO `div_worker` VALUES ('1', '14');
INSERT INTO `div_worker` VALUES ('1', '15');
INSERT INTO `div_worker` VALUES ('1', '16');
INSERT INTO `div_worker` VALUES ('1', '17');
INSERT INTO `div_worker` VALUES ('1', '18');
INSERT INTO `div_worker` VALUES ('2', '20');
INSERT INTO `div_worker` VALUES ('2', '21');
INSERT INTO `div_worker` VALUES ('2', '22');
INSERT INTO `div_worker` VALUES ('2', '23');
INSERT INTO `div_worker` VALUES ('2', '24');
INSERT INTO `div_worker` VALUES ('2', '25');
INSERT INTO `div_worker` VALUES ('2', '26');
INSERT INTO `div_worker` VALUES ('2', '27');
INSERT INTO `div_worker` VALUES ('2', '28');
INSERT INTO `div_worker` VALUES ('3', '30');
INSERT INTO `div_worker` VALUES ('3', '31');
INSERT INTO `div_worker` VALUES ('3', '32');
INSERT INTO `div_worker` VALUES ('3', '33');
INSERT INTO `div_worker` VALUES ('3', '34');
INSERT INTO `div_worker` VALUES ('3', '35');
INSERT INTO `div_worker` VALUES ('3', '36');
INSERT INTO `div_worker` VALUES ('3', '37');
INSERT INTO `div_worker` VALUES ('3', '38');
INSERT INTO `div_worker` VALUES ('4', '40');
INSERT INTO `div_worker` VALUES ('4', '41');
INSERT INTO `div_worker` VALUES ('4', '42');
INSERT INTO `div_worker` VALUES ('4', '43');
INSERT INTO `div_worker` VALUES ('4', '44');
INSERT INTO `div_worker` VALUES ('4', '45');
INSERT INTO `div_worker` VALUES ('4', '46');
INSERT INTO `div_worker` VALUES ('4', '47');
INSERT INTO `div_worker` VALUES ('4', '48');
INSERT INTO `div_worker` VALUES ('5', '1');
INSERT INTO `div_worker` VALUES ('5', '2');
INSERT INTO `div_worker` VALUES ('5', '3');
INSERT INTO `div_worker` VALUES ('5', '4');
INSERT INTO `div_worker` VALUES ('5', '5');

-- ----------------------------
-- Table structure for `divisions`
-- ----------------------------
DROP TABLE IF EXISTS `divisions`;
CREATE TABLE `divisions` (
  `DivId` int(11) NOT NULL,
  `ManagerId` int(11) NOT NULL,
  `Name` varchar(255) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`DivId`),
  KEY `ManagerId` (`ManagerId`),
  KEY `DivId` (`DivId`),
  KEY `FKA1E8E566FB80D7F6` (`ManagerId`),
  CONSTRAINT `divisions_ibfk_1` FOREIGN KEY (`ManagerId`) REFERENCES `employee` (`EId`),
  CONSTRAINT `FKA1E8E566FB80D7F6` FOREIGN KEY (`ManagerId`) REFERENCES `employee` (`EId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of divisions
-- ----------------------------
INSERT INTO `divisions` VALUES ('1', '10', 'Karish');
INSERT INTO `divisions` VALUES ('2', '20', 'Tamar');
INSERT INTO `divisions` VALUES ('3', '30', 'Raam');
INSERT INTO `divisions` VALUES ('4', '40', 'Shezaf');
INSERT INTO `divisions` VALUES ('5', '1', 'Minhala');

-- ----------------------------
-- Table structure for `done_by`
-- ----------------------------
DROP TABLE IF EXISTS `done_by`;
CREATE TABLE `done_by` (
  `Tid` int(11) NOT NULL,
  `Eid` int(11) NOT NULL,
  `Changed` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Tid`,`Eid`),
  KEY `Tid` (`Tid`),
  KEY `Eid` (`Eid`),
  KEY `FK6D968634CC59C85D` (`Tid`),
  KEY `FK6D96863417BE7AAE` (`Eid`),
  CONSTRAINT `Empid` FOREIGN KEY (`Eid`) REFERENCES `employee` (`EId`),
  CONSTRAINT `FK6D96863417BE7AAE` FOREIGN KEY (`Eid`) REFERENCES `employee` (`EId`),
  CONSTRAINT `FK6D968634CC59C85D` FOREIGN KEY (`Tid`) REFERENCES `tasks` (`Tid`),
  CONSTRAINT `Taskid` FOREIGN KEY (`Tid`) REFERENCES `tasks` (`Tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of done_by
-- ----------------------------
INSERT INTO `done_by` VALUES ('1', '1', '0');
INSERT INTO `done_by` VALUES ('2', '2', '0');
INSERT INTO `done_by` VALUES ('3', '2', '0');
INSERT INTO `done_by` VALUES ('4', '2', '0');
INSERT INTO `done_by` VALUES ('5', '2', '0');
INSERT INTO `done_by` VALUES ('6', '2', '0');
INSERT INTO `done_by` VALUES ('7', '2', '0');
INSERT INTO `done_by` VALUES ('8', '2', '0');
INSERT INTO `done_by` VALUES ('9', '2', '0');
INSERT INTO `done_by` VALUES ('10', '12', '0');
INSERT INTO `done_by` VALUES ('11', '21', '0');
INSERT INTO `done_by` VALUES ('12', '22', '0');
INSERT INTO `done_by` VALUES ('13', '31', '0');
INSERT INTO `done_by` VALUES ('14', '32', '0');
INSERT INTO `done_by` VALUES ('15', '41', '0');
INSERT INTO `done_by` VALUES ('16', '42', '0');
INSERT INTO `done_by` VALUES ('17', '1', '0');
INSERT INTO `done_by` VALUES ('18', '2', '0');
INSERT INTO `done_by` VALUES ('19', '3', '0');
INSERT INTO `done_by` VALUES ('21', '10', '0');
INSERT INTO `done_by` VALUES ('22', '20', '0');
INSERT INTO `done_by` VALUES ('23', '30', '0');
INSERT INTO `done_by` VALUES ('24', '40', '0');
INSERT INTO `done_by` VALUES ('25', '11', '0');
INSERT INTO `done_by` VALUES ('26', '12', '0');
INSERT INTO `done_by` VALUES ('27', '21', '0');
INSERT INTO `done_by` VALUES ('28', '22', '0');
INSERT INTO `done_by` VALUES ('29', '31', '0');
INSERT INTO `done_by` VALUES ('30', '32', '0');
INSERT INTO `done_by` VALUES ('31', '41', '0');
INSERT INTO `done_by` VALUES ('32', '42', '0');
INSERT INTO `done_by` VALUES ('172', '2', '0');
INSERT INTO `done_by` VALUES ('183', '3', '0');
INSERT INTO `done_by` VALUES ('194', '4', '0');
INSERT INTO `done_by` VALUES ('195', '5', '0');
INSERT INTO `done_by` VALUES ('211', '11', '0');
INSERT INTO `done_by` VALUES ('212', '12', '0');
INSERT INTO `done_by` VALUES ('221', '21', '0');
INSERT INTO `done_by` VALUES ('222', '22', '0');
INSERT INTO `done_by` VALUES ('231', '31', '0');
INSERT INTO `done_by` VALUES ('232', '32', '0');
INSERT INTO `done_by` VALUES ('241', '41', '0');
INSERT INTO `done_by` VALUES ('242', '42', '0');
INSERT INTO `done_by` VALUES ('251', '13', '0');
INSERT INTO `done_by` VALUES ('252', '14', '0');
INSERT INTO `done_by` VALUES ('253', '15', '0');
INSERT INTO `done_by` VALUES ('261', '16', '0');
INSERT INTO `done_by` VALUES ('262', '17', '0');
INSERT INTO `done_by` VALUES ('263', '18', '0');
INSERT INTO `done_by` VALUES ('271', '23', '0');
INSERT INTO `done_by` VALUES ('272', '24', '0');
INSERT INTO `done_by` VALUES ('273', '25', '0');
INSERT INTO `done_by` VALUES ('281', '26', '0');
INSERT INTO `done_by` VALUES ('282', '27', '0');
INSERT INTO `done_by` VALUES ('283', '28', '0');
INSERT INTO `done_by` VALUES ('291', '33', '0');
INSERT INTO `done_by` VALUES ('292', '34', '0');
INSERT INTO `done_by` VALUES ('293', '35', '0');
INSERT INTO `done_by` VALUES ('301', '36', '0');
INSERT INTO `done_by` VALUES ('302', '37', '0');
INSERT INTO `done_by` VALUES ('303', '38', '0');
INSERT INTO `done_by` VALUES ('311', '43', '0');
INSERT INTO `done_by` VALUES ('312', '44', '0');
INSERT INTO `done_by` VALUES ('313', '45', '0');
INSERT INTO `done_by` VALUES ('321', '46', '0');
INSERT INTO `done_by` VALUES ('322', '47', '0');
INSERT INTO `done_by` VALUES ('323', '48', '0');
INSERT INTO `done_by` VALUES ('1810', '10', '0');
INSERT INTO `done_by` VALUES ('1820', '20', '0');
INSERT INTO `done_by` VALUES ('1830', '30', '0');
INSERT INTO `done_by` VALUES ('1840', '40', '0');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `EId` int(11) NOT NULL,
  `UserName` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Name` varchar(255) CHARACTER SET latin1 NOT NULL,
  `JobDesc` varchar(255) CHARACTER SET latin1 NOT NULL,
  `LName` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `Bdate` date DEFAULT NULL,
  `Address` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `Email` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `PhoneNum` int(11) DEFAULT NULL,
  `Auth` varchar(15) CHARACTER SET latin1 NOT NULL DEFAULT 'Employee',
  `Password` int(11) DEFAULT '0',
  PRIMARY KEY (`EId`),
  KEY `Eid` (`EId`),
  KEY `UserName` (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'gm', 'Grand Manager', 'Grand Manager', '', null, '', '', null, 'admin', '123');
INSERT INTO `employee` VALUES ('2', 'manager', 'Manager', 'Manager', '', null, '', '', null, 'admin', '123');
INSERT INTO `employee` VALUES ('3', 'rasar', 'Rasar', 'Rasar', '', null, '', '', null, 'admin', '123');
INSERT INTO `employee` VALUES ('4', 'afsenai', 'Afsenai', 'Mahsan', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('5', 'sapar', 'Sapar', 'Sapar', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('10', 'mm1', 'MM1', 'Memem-Karish', '', null, '', '', null, 'admin', '123');
INSERT INTO `employee` VALUES ('11', 'karish_m1', 'Karish-Mapaz-1', 'Mapaz-Karish', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('12', 'karish_m2', 'Karish-Mapaz-2', 'Mapaz-Karish', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('13', 'karish_h1', 'Karish-Hayal-1-Shel-1', 'Hayal-Karish', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('14', 'karish_h2', 'Karish-Hayal-2-Shel-1', 'Hayal-Karish', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('15', 'karish_h3', 'Karish-Hayal-3-Shel-1', 'Hayal-Karish', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('16', 'karish_h4', 'Karish-Hayal-4-Shel-2', 'Hayal-Karish', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('17', 'karish_h5', 'Karish-Hayal-5-Shel-2', 'Hayal-Karish', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('18', 'karish_h6', 'Karish-Hayal-6-Shel-2', 'Hayal-Karish', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('20', 'mm2', 'MM2', 'Memem-Tamar', '', null, '', '', null, 'admin', '123');
INSERT INTO `employee` VALUES ('21', 'tamar_m1', 'Tamar-Mapaz-1', 'Mapaz-Tamar', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('22', 'tamar_m2', 'Tamar-Mapaz-2', 'Mapaz-Tamar', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('23', 'tamar_h1', 'Tamar-Hayal-1-Shel-1', 'Hayal-Tamar', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('24', 'tamar_h2', 'Tamar-Hayal-2-Shel-1', 'Hayal-Tamar', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('25', 'tamar_h3', 'Tamar-Hayal-3-Shel-1', 'Hayal-Tamar', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('26', 'tamar_h4', 'Tamar-Hayal-4-Shel-2', 'Hayal-Tamar', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('27', 'tamar_h5', 'Tamar-Hayal-5-Shel-2', 'Hayal-Tamar', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('28', 'tamar_h6', 'Tamar-Hayal-6-Shel-2', 'Hayal-Tamar', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('30', 'mm3', 'MM3', 'Memem-Raam', '', null, '', '', null, 'admin', '123');
INSERT INTO `employee` VALUES ('31', 'raam_m1', 'Raam-Mapaz-1', 'Mapaz-Raam', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('32', 'raam_m2', 'Raam-Mapaz-2', 'Mapaz-Raam', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('33', 'raam_h1', 'Raam-Hayal-1-Shel-1', 'Hayal-Raam', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('34', 'raam_h2', 'Raam-Hayal-2-Shel-1', 'Hayal-Raam', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('35', 'raam_h3', 'Raam-Hayal-3-Shel-1', 'Hayal-Raam', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('36', 'raam_h4', 'Raam-Hayal-4-Shel-2', 'Hayal-Raam', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('37', 'raam_h5', 'Raam-Hayal-5-Shel-2', 'Hayal-Raam', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('38', 'raam_h6', 'Raam-Hayal-6-Shel-2', 'Hayal-Raam', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('40', 'mm4', 'MM4', 'Memem-Shezaf', '', null, '', '', null, 'admin', '123');
INSERT INTO `employee` VALUES ('41', 'shezaf_m1', 'Shezaf-Mapaz-1', 'Mapaz-Shezaf', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('42', 'shezaf_m2', 'Shezaf-Mapaz-2', 'Mapaz-Shezaf', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('43', 'shezaf_h1', 'Shezaf-Hayal-1-Shel-1', 'Hayal-Shezaf', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('44', 'shezaf_h2', 'Shezaf-Hayal-2-Shel-1', 'Hayal-Shezaf', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('45', 'shezaf_h3', 'Shezaf-Hayal-3-Shel-1', 'Hayal-Shezaf', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('46', 'shezaf_h4', 'Shezaf-Hayal-4-Shel-2', 'Hayal-Shezaf', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('47', 'shezaf_h5', 'Shezaf-Hayal-5-Shel-2', 'Hayal-Shezaf', '', null, '', '', null, 'Employee', '123');
INSERT INTO `employee` VALUES ('48', 'shezaf_h6', 'Shezaf-Hayal-6-Shel-2', 'Hayal-Shezaf', '', null, '', '', null, 'Employee', '123');

-- ----------------------------
-- Table structure for `late`
-- ----------------------------
DROP TABLE IF EXISTS `late`;
CREATE TABLE `late` (
  `Eid` int(11) NOT NULL,
  `Counter` int(11) NOT NULL,
  PRIMARY KEY (`Eid`),
  KEY `Eid` (`Eid`),
  CONSTRAINT `late_ibfk_1` FOREIGN KEY (`Eid`) REFERENCES `employee` (`EId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of late
-- ----------------------------

-- ----------------------------
-- Table structure for `on_time`
-- ----------------------------
DROP TABLE IF EXISTS `on_time`;
CREATE TABLE `on_time` (
  `Eid` int(11) NOT NULL,
  `Counter` int(11) NOT NULL,
  PRIMARY KEY (`Eid`),
  KEY `Eid` (`Eid`),
  CONSTRAINT `on_time_ibfk_1` FOREIGN KEY (`Eid`) REFERENCES `employee` (`EId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of on_time
-- ----------------------------

-- ----------------------------
-- Table structure for `tasks`
-- ----------------------------
DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks` (
  `Tid` int(11) NOT NULL AUTO_INCREMENT,
  `CDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `EDate` datetime DEFAULT NULL,
  `FinishedDate` datetime DEFAULT NULL,
  `Title` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Description` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `Attachment` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `Status` varchar(15) CHARACTER SET latin1 NOT NULL DEFAULT 'On Going',
  `Flagged` tinyint(4) NOT NULL DEFAULT '0',
  `Delegated` tinyint(4) NOT NULL DEFAULT '0',
  `CreatorId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Tid`),
  KEY `Tid` (`Tid`),
  KEY `FK_tasks_1` (`CreatorId`) USING BTREE,
  KEY `FK6907B8E3B6C24B5` (`CreatorId`),
  CONSTRAINT `FK6907B8E3B6C24B5` FOREIGN KEY (`CreatorId`) REFERENCES `employee` (`EId`),
  CONSTRAINT `FK_tasks_1` FOREIGN KEY (`CreatorId`) REFERENCES `employee` (`EId`)
) ENGINE=InnoDB AUTO_INCREMENT=1843 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tasks
-- ----------------------------
INSERT INTO `tasks` VALUES ('1', '2009-08-30 19:10:42', null, null, 'GM to himself', 'TODO myself GM', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('2', '2009-08-30 19:10:42', null, null, 'Manager to himself', 'TODO myself M', 'Somthing', 'Active', '0', '0', '2');
INSERT INTO `tasks` VALUES ('3', '2009-08-30 19:10:42', null, null, 'Rasar to himself', 'TODO myself Rasar', null, 'Active', '1', '0', '2');
INSERT INTO `tasks` VALUES ('4', '2009-08-30 19:10:42', null, null, 'Afsenai to himself', 'TODO myself Afsenai', null, 'Active', '0', '0', '2');
INSERT INTO `tasks` VALUES ('5', '2009-08-30 21:01:23', null, null, 'MM1 to himself', 'TODO myself 1', '', 'Active', '0', '0', '2');
INSERT INTO `tasks` VALUES ('6', '2009-08-30 19:10:42', null, null, 'MM2 to himself', 'TODO myself 2', '', 'Active', '0', '0', '2');
INSERT INTO `tasks` VALUES ('7', '2009-08-30 19:10:42', null, null, 'MM3 to himself', 'TODO myself 3', '', 'Active', '0', '0', '2');
INSERT INTO `tasks` VALUES ('8', '2009-08-30 19:10:42', null, null, 'MM4 to himself', 'TODO myself 4', null, '', '0', '0', '2');
INSERT INTO `tasks` VALUES ('9', '2009-08-30 21:01:23', null, null, 'Mapatz to himself', 'TODO myself Mapatz1.1', '', 'Active', '0', '0', '2');
INSERT INTO `tasks` VALUES ('10', '2009-08-30 19:10:42', null, null, 'Mapatz to himself', 'TODO myself Mapatz1.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('11', '2009-08-30 19:10:42', null, null, 'Mapatz to himself', 'TODO myself Mapatz2.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('12', '2009-08-30 19:10:42', null, null, 'Mapatz to himself', 'TODO myself Mapatz2.2', null, '', '0', '0', null);
INSERT INTO `tasks` VALUES ('13', '2009-08-30 21:01:23', null, null, 'Mapatz to himself', 'TODO myself Mapatz3.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('14', '2009-08-30 19:10:42', null, null, 'Mapatz to himself', 'TODO myself Mapatz3.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('15', '2009-08-30 19:10:42', null, null, 'Mapatz to himself', 'TODO myself Mapatz4.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('16', '2009-08-30 19:10:42', null, null, 'Mapatz to himself', 'TODO myself Mapatz4.2', null, '', '0', '0', null);
INSERT INTO `tasks` VALUES ('17', '2009-08-30 19:10:42', null, null, 'GM to delegate', 'GM to delegate', '', 'Active', '0', '1', null);
INSERT INTO `tasks` VALUES ('18', '2009-08-30 19:10:42', null, null, 'Manager to delegate', 'to delegate from M', 'Somthing', 'Active', '0', '1', '2');
INSERT INTO `tasks` VALUES ('19', '2009-08-30 19:10:42', null, null, 'Rasar to delegate', 'to delegate from Rasar', null, 'Active', '0', '1', null);
INSERT INTO `tasks` VALUES ('21', '2009-08-30 21:01:23', null, null, 'MM1 to delegate', 'to delegate 1', '', 'Active', '0', '1', null);
INSERT INTO `tasks` VALUES ('22', '2009-08-30 19:10:42', null, null, 'MM2 to delegate', 'to delegate 2', '', 'Active', '0', '1', null);
INSERT INTO `tasks` VALUES ('23', '2009-08-30 19:10:42', null, null, 'MM3 to delegate', 'to delegate 3', '', 'Active', '0', '1', null);
INSERT INTO `tasks` VALUES ('24', '2009-08-30 19:10:42', null, null, 'MM4 to delegate', 'to delegate 4', null, '', '0', '1', null);
INSERT INTO `tasks` VALUES ('25', '2009-08-30 21:01:23', null, null, 'Mapatz to delegate', 'to delegate from Mapatz1.1', '', 'Active', '0', '1', null);
INSERT INTO `tasks` VALUES ('26', '2009-08-30 19:10:42', null, null, 'Mapatz to delegate', 'to delegate from Mapatz1.2', '', 'Active', '0', '1', null);
INSERT INTO `tasks` VALUES ('27', '2009-08-30 19:10:42', null, null, 'Mapatz to delegate', 'to delegate from Mapatz2.1', '', 'Active', '0', '1', null);
INSERT INTO `tasks` VALUES ('28', '2009-08-30 19:10:42', null, null, 'Mapatz to delegate', 'to delegate from Mapatz2.2', null, '', '0', '1', null);
INSERT INTO `tasks` VALUES ('29', '2009-08-30 21:01:23', null, null, 'Mapatz to delegate', 'to delegate from Mapatz3.1', '', 'Active', '0', '1', null);
INSERT INTO `tasks` VALUES ('30', '2009-08-30 19:10:42', null, null, 'Mapatz to delegate', 'to delegate from Mapatz3.2', '', 'Active', '0', '1', null);
INSERT INTO `tasks` VALUES ('31', '2009-08-30 19:10:42', null, null, 'Mapatz to delegate', 'to delegate from Mapatz4.1', '', 'Active', '0', '1', null);
INSERT INTO `tasks` VALUES ('32', '2009-08-30 19:10:42', null, null, 'Mapatz to delegate', 'to delegate from Mapatz4.2', null, '', '0', '1', null);
INSERT INTO `tasks` VALUES ('172', '2009-08-30 19:10:42', null, null, 'Delegated from GM', 'Delegated from GM', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('183', '2009-08-30 19:10:42', null, null, 'Delegated from M', 'Delegated from M', '', 'Active', '0', '0', '2');
INSERT INTO `tasks` VALUES ('194', '2009-08-30 19:10:42', null, null, 'Delegated from Rasar', 'Delegated from Rasar', null, 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('195', '2009-08-30 19:10:42', null, null, 'Delegated from Rasar', 'Delegated from Rasar', null, 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('211', '2009-08-30 21:01:23', null, null, 'Delegated from MM1', 'Delegated from MM1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('212', '2009-08-30 21:01:23', null, null, 'Delegated from MM1', 'Delegated from MM1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('221', '2009-08-30 21:01:23', null, null, 'Delegated from MM2', 'Delegated from MM2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('222', '2009-08-30 21:01:23', null, null, 'Delegated from MM2', 'Delegated from MM2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('231', '2009-08-30 21:01:23', null, null, 'Delegated from MM3', 'Delegated from MM3', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('232', '2009-08-30 21:01:23', null, null, 'Delegated from MM3', 'Delegated from MM3', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('241', '2009-08-30 21:01:23', null, null, 'Delegated from MM4', 'Delegated from MM4', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('242', '2009-08-30 21:01:23', null, null, 'Delegated from MM4', 'Delegated from MM4', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('251', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz1.1', 'Delegated from Mapatz1.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('252', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz1.1', 'Delegated from Mapatz1.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('253', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz1.1', 'Delegated from Mapatz1.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('261', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz1.2', 'Delegated from Mapatz1.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('262', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz1.2', 'Delegated from Mapatz1.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('263', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz1.2', 'Delegated from Mapatz1.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('271', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz2.1', 'Delegated from Mapatz2.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('272', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz2.1', 'Delegated from Mapatz2.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('273', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz2.1', 'Delegated from Mapatz2.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('281', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz2.2', 'Delegated from Mapatz2.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('282', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz2.2', 'Delegated from Mapatz2.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('283', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz2.2', 'Delegated from Mapatz2.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('291', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz3.1', 'Delegated from Mapatz3.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('292', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz3.1', 'Delegated from Mapatz3.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('293', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz3.1', 'Delegated from Mapatz3.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('301', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz3.2', 'Delegated from Mapatz3.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('302', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz3.2', 'Delegated from Mapatz3.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('303', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz3.2', 'Delegated from Mapatz3.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('311', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz4.1', 'Delegated from Mapatz4.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('312', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz4.1', 'Delegated from Mapatz4.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('313', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz4.1', 'Delegated from Mapatz4.1', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('321', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz4.2', 'Delegated from Mapatz4.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('322', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz4.2', 'Delegated from Mapatz4.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('323', '2009-08-30 21:01:23', null, null, 'Delegated from Mapatz4.2', 'Delegated from Mapatz4.2', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('1810', '2009-08-30 19:10:42', null, null, 'Delegated from M', 'Delegated from M', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('1820', '2009-08-30 19:10:42', null, null, 'Delegated from M', 'Delegated from M', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('1830', '2009-08-30 19:10:42', null, null, 'Delegated from M', 'Delegated from M', '', 'Active', '0', '0', null);
INSERT INTO `tasks` VALUES ('1840', '2009-08-30 19:10:42', null, null, 'Delegated from M', 'Delegated from M', '', 'Active', '0', '0', null);

-- ----------------------------
-- Table structure for `tasks_c`
-- ----------------------------
DROP TABLE IF EXISTS `tasks_c`;
CREATE TABLE `tasks_c` (
  `Tid` int(11) NOT NULL,
  `ParentTaskId` int(11) NOT NULL,
  `RootTaskId` int(11) NOT NULL,
  `Parallel` int(11) DEFAULT NULL,
  PRIMARY KEY (`Tid`) USING BTREE,
  KEY `Tid` (`Tid`),
  KEY `Parent` (`ParentTaskId`) USING BTREE,
  KEY `FKA45FDBF2AD2CCC90` (`RootTaskId`),
  KEY `FKA45FDBF242FF5E58` (`ParentTaskId`),
  CONSTRAINT `FKA45FDBF242FF5E58` FOREIGN KEY (`ParentTaskId`) REFERENCES `tasks` (`Tid`),
  CONSTRAINT `FKA45FDBF2AD2CCC90` FOREIGN KEY (`RootTaskId`) REFERENCES `tasks` (`Tid`),
  CONSTRAINT `FK_tasks_c_3` FOREIGN KEY (`RootTaskId`) REFERENCES `tasks` (`Tid`),
  CONSTRAINT `tasks_c_ibfk_1` FOREIGN KEY (`Tid`) REFERENCES `tasks` (`Tid`),
  CONSTRAINT `tasks_c_ibfk_3` FOREIGN KEY (`ParentTaskId`) REFERENCES `tasks` (`Tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tasks_c
-- ----------------------------
INSERT INTO `tasks_c` VALUES ('172', '17', '1', null);
INSERT INTO `tasks_c` VALUES ('183', '18', '2', null);
INSERT INTO `tasks_c` VALUES ('194', '19', '3', null);
INSERT INTO `tasks_c` VALUES ('195', '19', '3', null);
INSERT INTO `tasks_c` VALUES ('211', '21', '10', null);
INSERT INTO `tasks_c` VALUES ('212', '21', '10', null);
INSERT INTO `tasks_c` VALUES ('221', '22', '20', null);
INSERT INTO `tasks_c` VALUES ('222', '22', '20', null);
INSERT INTO `tasks_c` VALUES ('231', '23', '30', null);
INSERT INTO `tasks_c` VALUES ('232', '23', '30', null);
INSERT INTO `tasks_c` VALUES ('241', '24', '40', null);
INSERT INTO `tasks_c` VALUES ('242', '24', '40', null);
INSERT INTO `tasks_c` VALUES ('251', '25', '11', null);
INSERT INTO `tasks_c` VALUES ('252', '25', '11', null);
INSERT INTO `tasks_c` VALUES ('253', '25', '11', null);
INSERT INTO `tasks_c` VALUES ('261', '26', '12', null);
INSERT INTO `tasks_c` VALUES ('262', '26', '12', null);
INSERT INTO `tasks_c` VALUES ('263', '26', '12', null);
INSERT INTO `tasks_c` VALUES ('271', '27', '21', null);
INSERT INTO `tasks_c` VALUES ('272', '27', '21', null);
INSERT INTO `tasks_c` VALUES ('273', '27', '21', null);
INSERT INTO `tasks_c` VALUES ('281', '28', '22', null);
INSERT INTO `tasks_c` VALUES ('282', '28', '22', null);
INSERT INTO `tasks_c` VALUES ('283', '28', '22', null);
INSERT INTO `tasks_c` VALUES ('291', '29', '31', null);
INSERT INTO `tasks_c` VALUES ('292', '29', '31', null);
INSERT INTO `tasks_c` VALUES ('293', '29', '31', null);
INSERT INTO `tasks_c` VALUES ('301', '30', '32', null);
INSERT INTO `tasks_c` VALUES ('302', '30', '32', null);
INSERT INTO `tasks_c` VALUES ('303', '30', '32', null);
INSERT INTO `tasks_c` VALUES ('311', '31', '41', null);
INSERT INTO `tasks_c` VALUES ('312', '31', '41', null);
INSERT INTO `tasks_c` VALUES ('313', '31', '41', null);
INSERT INTO `tasks_c` VALUES ('321', '32', '42', null);
INSERT INTO `tasks_c` VALUES ('322', '32', '42', null);
INSERT INTO `tasks_c` VALUES ('323', '32', '42', null);
INSERT INTO `tasks_c` VALUES ('1810', '18', '2', null);
INSERT INTO `tasks_c` VALUES ('1820', '18', '2', null);
INSERT INTO `tasks_c` VALUES ('1830', '18', '2', null);
INSERT INTO `tasks_c` VALUES ('1840', '18', '2', null);

-- ----------------------------
-- Table structure for `updates`
-- ----------------------------
DROP TABLE IF EXISTS `updates`;
CREATE TABLE `updates` (
  `Tid` int(11) NOT NULL,
  `Updates` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `ChangeTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `Memo` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Tid`),
  KEY `Tid` (`Tid`),
  CONSTRAINT `updates_ibfk_1` FOREIGN KEY (`Tid`) REFERENCES `tasks` (`Tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of updates
-- ----------------------------

-- ----------------------------
-- Table structure for `works_for`
-- ----------------------------
DROP TABLE IF EXISTS `works_for`;
CREATE TABLE `works_for` (
  `ManagerId` int(11) NOT NULL,
  `Eid` int(11) NOT NULL,
  PRIMARY KEY (`ManagerId`,`Eid`),
  KEY `ManagerId` (`ManagerId`),
  KEY `Eid` (`Eid`),
  KEY `FK4210468C17BE7AAE` (`Eid`),
  KEY `FK4210468CFB80D7F6` (`ManagerId`),
  CONSTRAINT `FK4210468C17BE7AAE` FOREIGN KEY (`Eid`) REFERENCES `employee` (`EId`),
  CONSTRAINT `FK4210468CFB80D7F6` FOREIGN KEY (`ManagerId`) REFERENCES `employee` (`EId`),
  CONSTRAINT `works_for_ibfk_1` FOREIGN KEY (`ManagerId`) REFERENCES `employee` (`EId`),
  CONSTRAINT `works_for_ibfk_2` FOREIGN KEY (`Eid`) REFERENCES `employee` (`EId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of works_for
-- ----------------------------
INSERT INTO `works_for` VALUES ('1', '2');
INSERT INTO `works_for` VALUES ('2', '3');
INSERT INTO `works_for` VALUES ('2', '10');
INSERT INTO `works_for` VALUES ('2', '20');
INSERT INTO `works_for` VALUES ('2', '30');
INSERT INTO `works_for` VALUES ('2', '40');
INSERT INTO `works_for` VALUES ('3', '4');
INSERT INTO `works_for` VALUES ('3', '5');
INSERT INTO `works_for` VALUES ('10', '11');
INSERT INTO `works_for` VALUES ('10', '12');
INSERT INTO `works_for` VALUES ('11', '13');
INSERT INTO `works_for` VALUES ('11', '14');
INSERT INTO `works_for` VALUES ('11', '15');
INSERT INTO `works_for` VALUES ('12', '16');
INSERT INTO `works_for` VALUES ('12', '17');
INSERT INTO `works_for` VALUES ('12', '18');
INSERT INTO `works_for` VALUES ('20', '21');
INSERT INTO `works_for` VALUES ('20', '22');
INSERT INTO `works_for` VALUES ('21', '23');
INSERT INTO `works_for` VALUES ('21', '24');
INSERT INTO `works_for` VALUES ('21', '25');
INSERT INTO `works_for` VALUES ('22', '26');
INSERT INTO `works_for` VALUES ('22', '27');
INSERT INTO `works_for` VALUES ('22', '28');
INSERT INTO `works_for` VALUES ('30', '31');
INSERT INTO `works_for` VALUES ('30', '32');
INSERT INTO `works_for` VALUES ('31', '33');
INSERT INTO `works_for` VALUES ('31', '34');
INSERT INTO `works_for` VALUES ('31', '35');
INSERT INTO `works_for` VALUES ('32', '36');
INSERT INTO `works_for` VALUES ('32', '37');
INSERT INTO `works_for` VALUES ('32', '38');
INSERT INTO `works_for` VALUES ('40', '41');
INSERT INTO `works_for` VALUES ('40', '42');
INSERT INTO `works_for` VALUES ('41', '43');
INSERT INTO `works_for` VALUES ('41', '44');
INSERT INTO `works_for` VALUES ('41', '45');
INSERT INTO `works_for` VALUES ('42', '46');
INSERT INTO `works_for` VALUES ('42', '47');
INSERT INTO `works_for` VALUES ('42', '48');
