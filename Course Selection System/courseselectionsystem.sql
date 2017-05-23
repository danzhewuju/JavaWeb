/*
Navicat MySQL Data Transfer

Source Server         : connection
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : courseselectionsystem

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-05-23 15:54:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classrooms
-- ----------------------------
DROP TABLE IF EXISTS `classrooms`;
CREATE TABLE `classrooms` (
  `Rno` int(11) NOT NULL AUTO_INCREMENT,
  `Rname` varchar(45) NOT NULL,
  PRIMARY KEY (`Rno`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classrooms
-- ----------------------------
INSERT INTO `classrooms` VALUES ('12', '一教101');
INSERT INTO `classrooms` VALUES ('13', '一教102');
INSERT INTO `classrooms` VALUES ('14', '一教103');
INSERT INTO `classrooms` VALUES ('15', '一教104');
INSERT INTO `classrooms` VALUES ('16', '一教107');
INSERT INTO `classrooms` VALUES ('17', '一教106');
INSERT INTO `classrooms` VALUES ('18', ' 一教322');
INSERT INTO `classrooms` VALUES ('20', '一教310');
INSERT INTO `classrooms` VALUES ('21', '一教320');
INSERT INTO `classrooms` VALUES ('23', '  计算机510');
INSERT INTO `classrooms` VALUES ('24', '一教200');

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `Cno` int(11) NOT NULL AUTO_INCREMENT,
  `Cname` varchar(45) NOT NULL,
  `Ctime` varchar(45) NOT NULL,
  `Rno` int(11) NOT NULL,
  `Cmax` int(11) DEFAULT '30',
  PRIMARY KEY (`Cno`),
  KEY `CRRno_idx` (`Rno`),
  CONSTRAINT `CRRno` FOREIGN KEY (`Rno`) REFERENCES `classrooms` (`Rno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES ('3', '数学', 'FRI-9:00~12:00', '16', '30');
INSERT INTO `courses` VALUES ('9', 'JAVA', 'MON-9:00~12:00', '17', '28');
INSERT INTO `courses` VALUES ('10', '英语', 'FRI-13:00~16:00', '15', '28');
INSERT INTO `courses` VALUES ('11', '操作系统', 'MON-13:00~16:00', '13', '29');
INSERT INTO `courses` VALUES ('12', '计算机网络', 'MON-18:00~21:00', '14', '30');
INSERT INTO `courses` VALUES ('13', '数据结构', 'TUE-9:00~12:00', '15', '25');
INSERT INTO `courses` VALUES ('14', '计算机组成', 'WED-13:00~16:00', '21', '30');
INSERT INTO `courses` VALUES ('15', 'javaweb', 'WED-13:00~16:00', '20', '30');
INSERT INTO `courses` VALUES ('16', '微机原理', 'FRI-9:00~12:00', '23', '30');
INSERT INTO `courses` VALUES ('17', '会计', 'FRI-18:00~21:00', '13', '28');
INSERT INTO `courses` VALUES ('18', '犯罪心理学', 'MON-13:00~16:00', '16', '30');
INSERT INTO `courses` VALUES ('19', '变态心理学', 'TUE-9:00~12:00', '20', '30');

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation` (
  `Sno` int(11) NOT NULL,
  `Cno` int(11) NOT NULL,
  `Tno` int(11) NOT NULL,
  `Eva` varchar(45) DEFAULT NULL,
  `Score` int(11) DEFAULT NULL,
  `Flag` int(11) DEFAULT '0',
  PRIMARY KEY (`Sno`,`Cno`,`Tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluation
-- ----------------------------
INSERT INTO `evaluation` VALUES ('3', '9', '1', 'good', '4', '0');
INSERT INTO `evaluation` VALUES ('3', '10', '1', 'good', '3', '0');
INSERT INTO `evaluation` VALUES ('3', '10', '2', 'good ', '5', '1');
INSERT INTO `evaluation` VALUES ('3', '11', '1', 'very good', '5', '0');
INSERT INTO `evaluation` VALUES ('3', '13', '2', 'good', '3', '1');
INSERT INTO `evaluation` VALUES ('3', '17', '1', 'good ', '5', '1');

-- ----------------------------
-- Table structure for managers
-- ----------------------------
DROP TABLE IF EXISTS `managers`;
CREATE TABLE `managers` (
  `Mno` int(11) NOT NULL AUTO_INCREMENT,
  `Mcode` varchar(45) NOT NULL,
  `Mname` varchar(45) NOT NULL,
  `Mlimits` int(11) DEFAULT '1',
  PRIMARY KEY (`Mno`)
) ENGINE=InnoDB AUTO_INCREMENT=10029 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of managers
-- ----------------------------
INSERT INTO `managers` VALUES ('10028', '123456', '余豪', '1');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Sno` int(11) NOT NULL,
  `Tno` int(11) NOT NULL,
  `Flag` int(11) NOT NULL DEFAULT '1',
  `Msn` text,
  `Backmsn` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `mssno_idx` (`Sno`),
  KEY `mttno_idx` (`Tno`),
  CONSTRAINT `mssno` FOREIGN KEY (`Sno`) REFERENCES `students` (`Sno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mttno` FOREIGN KEY (`Tno`) REFERENCES `teachers` (`Tno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '3', '1', '3', 'i need help', '看书');
INSERT INTO `message` VALUES ('2', '3', '1', '3', '什么事servlet', '看书');
INSERT INTO `message` VALUES ('3', '3', '1', '3', '不太懂', '看书');
INSERT INTO `message` VALUES ('4', '3', '1', '3', '这里我不懂', '看书');
INSERT INTO `message` VALUES ('5', '3', '2', '1', '数据结构，我还不懂', null);
INSERT INTO `message` VALUES ('6', '3', '1', '3', '这是为什么？', '明天来找我');

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `Sno` int(11) NOT NULL AUTO_INCREMENT,
  `Scode` varchar(45) NOT NULL,
  `Sname` varchar(45) NOT NULL,
  `Sex` varchar(45) NOT NULL,
  `Stel` varchar(45) NOT NULL,
  `Sclass` varchar(45) NOT NULL,
  PRIMARY KEY (`Sno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('3', '123456', '张三', 'male', '15901867519', '管理学院');
INSERT INTO `students` VALUES ('4', '123456', '古川雨', 'male', '12345678901', '环境学院');
INSERT INTO `students` VALUES ('5', '123456', '李四', 'male', '13856792346', '环境学院');

-- ----------------------------
-- Table structure for s_courses
-- ----------------------------
DROP TABLE IF EXISTS `s_courses`;
CREATE TABLE `s_courses` (
  `Sno` int(11) NOT NULL,
  `Cno` int(11) NOT NULL,
  `Cgrade` int(11) DEFAULT '-1',
  `Rno` int(11) DEFAULT NULL,
  PRIMARY KEY (`Sno`,`Cno`),
  KEY `scno_idx` (`Cno`),
  KEY `srno_idx` (`Rno`),
  CONSTRAINT `scno` FOREIGN KEY (`Cno`) REFERENCES `courses` (`Cno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `srno` FOREIGN KEY (`Rno`) REFERENCES `classrooms` (`Rno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ssno` FOREIGN KEY (`Sno`) REFERENCES `students` (`Sno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_courses
-- ----------------------------
INSERT INTO `s_courses` VALUES ('3', '9', '98', '17');
INSERT INTO `s_courses` VALUES ('3', '10', '-1', '15');
INSERT INTO `s_courses` VALUES ('3', '11', '89', '13');
INSERT INTO `s_courses` VALUES ('3', '13', '-1', '15');
INSERT INTO `s_courses` VALUES ('3', '17', '60', '13');
INSERT INTO `s_courses` VALUES ('4', '9', '100', '17');
INSERT INTO `s_courses` VALUES ('4', '10', '-1', '15');
INSERT INTO `s_courses` VALUES ('4', '11', '78', '13');
INSERT INTO `s_courses` VALUES ('4', '13', '-1', '15');
INSERT INTO `s_courses` VALUES ('4', '17', '89', '13');
INSERT INTO `s_courses` VALUES ('5', '9', '78', '17');
INSERT INTO `s_courses` VALUES ('5', '10', '-1', '15');
INSERT INTO `s_courses` VALUES ('5', '13', '-1', '15');

-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers` (
  `Tno` int(11) NOT NULL AUTO_INCREMENT,
  `Tcode` varchar(45) NOT NULL,
  `Tname` varchar(45) NOT NULL,
  `Tsex` varchar(45) NOT NULL,
  `Ttel` varchar(45) NOT NULL,
  PRIMARY KEY (`Tno`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES ('1', '123456', '余豪', 'male', '15901867519');
INSERT INTO `teachers` VALUES ('2', '123456', '马建', 'male', '12309874561');
INSERT INTO `teachers` VALUES ('3', '123456', '张鑫乐', 'female', '12309872345');
INSERT INTO `teachers` VALUES ('4', '123456', '张伟', 'male', '15678920384');
INSERT INTO `teachers` VALUES ('1000', '123456', '李白', 'male', '15901867519');

-- ----------------------------
-- Table structure for t_courses
-- ----------------------------
DROP TABLE IF EXISTS `t_courses`;
CREATE TABLE `t_courses` (
  `Tno` int(11) NOT NULL,
  `Cno` int(11) NOT NULL,
  PRIMARY KEY (`Tno`,`Cno`),
  KEY `TCCCon_idx` (`Cno`),
  CONSTRAINT `TCCCon` FOREIGN KEY (`Cno`) REFERENCES `courses` (`Cno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `TCTTon` FOREIGN KEY (`Tno`) REFERENCES `teachers` (`Tno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_courses
-- ----------------------------
INSERT INTO `t_courses` VALUES ('4', '3');
INSERT INTO `t_courses` VALUES ('1', '9');
INSERT INTO `t_courses` VALUES ('2', '10');
INSERT INTO `t_courses` VALUES ('1', '11');
INSERT INTO `t_courses` VALUES ('3', '12');
INSERT INTO `t_courses` VALUES ('2', '13');
INSERT INTO `t_courses` VALUES ('3', '17');
INSERT INTO `t_courses` VALUES ('4', '18');
INSERT INTO `t_courses` VALUES ('1000', '19');
