/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : bysj

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-03-23 14:32:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ssm_calendar
-- ----------------------------
DROP TABLE IF EXISTS `ssm_calendar`;
CREATE TABLE `ssm_calendar` (
  `calendar_id` varchar(45) NOT NULL,
  `calendar_time` date DEFAULT NULL,
  `calendar_body` varchar(255) DEFAULT NULL,
  `userID` varchar(45) NOT NULL,
  PRIMARY KEY (`calendar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_calendar
-- ----------------------------
INSERT INTO `ssm_calendar` VALUES ('381bc8a1-1937-11e8-8eba-c85b71234222', '2018-03-01', '打酱油test    3-8', '1');
INSERT INTO `ssm_calendar` VALUES ('5a77d977-2981-11e8-b02d-c85b76f243c4', '2018-03-21', '加班', '6a1c141a-22ac-11e8-85f7-c85b76f243c4');
INSERT INTO `ssm_calendar` VALUES ('5c866b5c-2108-11e8-a01b-c85b76f243c4', '2018-03-04', '打打打打酱油', '1');

-- ----------------------------
-- Table structure for ssm_file
-- ----------------------------
DROP TABLE IF EXISTS `ssm_file`;
CREATE TABLE `ssm_file` (
  `file_id` varchar(255) NOT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  `push_time` date DEFAULT NULL,
  `file_size` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_file
-- ----------------------------
INSERT INTO `ssm_file` VALUES ('46a2863a-c012-4e02-a947-dae4227686bfzxc.txt', 'zxc.txt', '1', '2018-03-08', '0KB');
INSERT INTO `ssm_file` VALUES ('79c066e4-d0c5-4e5a-815a-d088cff535d6互亿无线-安全防护方案.pdf', '互亿无线-安全防护方案.pdf', '1', '2018-03-17', '348KB');
INSERT INTO `ssm_file` VALUES ('bbba343c-04e6-42c9-956e-2833879600dc互亿无线-短信验证码通知-使用指南.pdf', '互亿无线-短信验证码通知-使用指南.pdf', '1', '2018-03-17', '771KB');

-- ----------------------------
-- Table structure for ssm_log
-- ----------------------------
DROP TABLE IF EXISTS `ssm_log`;
CREATE TABLE `ssm_log` (
  `log_id` varchar(45) NOT NULL,
  `log_userID` varchar(45) DEFAULT NULL,
  `log_happen_time` date DEFAULT NULL,
  `log_title` varchar(45) DEFAULT NULL,
  `log_body` varchar(255) DEFAULT NULL,
  `log_set_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_log
-- ----------------------------
INSERT INTO `ssm_log` VALUES ('057e219a-20e7-11e8-a01b-c85b76f243c4', '1', '2018-03-06', '测试日志', '测试日志Body\n', '2018-03-06 10:35:17');
INSERT INTO `ssm_log` VALUES ('381bc8a1-1937-11e8-8eba-c85b761223c2', '1', '2018-03-06', '修改BUGs', '修改了email,main的功能bugs', '2018-03-06 10:10:32');
INSERT INTO `ssm_log` VALUES ('51a18147-2981-11e8-b02d-c85b76f243c4', '6a1c141a-22ac-11e8-85f7-c85b76f243c4', '2018-03-06', 'test用户的日志', 'test用户日志内容', '2018-03-17 09:19:31');

-- ----------------------------
-- Table structure for ssm_meeting
-- ----------------------------
DROP TABLE IF EXISTS `ssm_meeting`;
CREATE TABLE `ssm_meeting` (
  `meet_id` varchar(45) NOT NULL,
  `meet_title` varchar(45) DEFAULT NULL,
  `meet_body` varchar(255) DEFAULT NULL,
  `meet_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `meet_send_userID` varchar(45) DEFAULT NULL,
  `meet_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`meet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_meeting
-- ----------------------------
INSERT INTO `ssm_meeting` VALUES ('1aa02c32-2042-11e8-a01b-c85b76f243c4', '星期三上午十点早会通知', '十点开会明确本月工作目标', '2018-03-08 18:16:53', '1', 'A');
INSERT INTO `ssm_meeting` VALUES ('ae87895e-2980-11e8-b02d-c85b76f243c4', '今天上午九点开会', '开会内容提示部分', '2018-03-17 09:14:57', '1', 'A');

-- ----------------------------
-- Table structure for ssm_notice
-- ----------------------------
DROP TABLE IF EXISTS `ssm_notice`;
CREATE TABLE `ssm_notice` (
  `notice_id` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `notice_title` varchar(45) DEFAULT NULL,
  `notice_body` varchar(255) DEFAULT NULL,
  `notice_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_notice
-- ----------------------------
INSERT INTO `ssm_notice` VALUES ('381bc8a1-1937-11e8-8eba-c85b76f243c4', '1', '吴鹏发的测试公告', '鹏发的公告   内容内容内容内容内容内容', '2018-03-08 17:09:29');
INSERT INTO `ssm_notice` VALUES ('93a69fc3-2980-11e8-b02d-c85b76f243c4', '1', '3-17测试公告', '3-17公告测试 内容部分', '2018-03-17 09:14:12');

-- ----------------------------
-- Table structure for ssm_user_email
-- ----------------------------
DROP TABLE IF EXISTS `ssm_user_email`;
CREATE TABLE `ssm_user_email` (
  `email_id` varchar(45) NOT NULL,
  `from_user_id` varchar(45) NOT NULL,
  `to_user_id` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `body` varchar(45) DEFAULT NULL,
  `email_type` varchar(10) DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_user_email
-- ----------------------------
INSERT INTO `ssm_user_email` VALUES ('2ef73aba-299a-11e8-b02d-c85b76f243c4', '6a1c141a-22ac-11e8-85f7-c85b76f243c4', '1', '66666', 'asdasda', 'B', '2018-03-17 12:17:30');
INSERT INTO `ssm_user_email` VALUES ('687aeb66-2981-11e8-b02d-c85b76f243c4', '6a1c141a-22ac-11e8-85f7-c85b76f243c4', '1', 'test用户发送的群发测试邮件', 'test用户发送的群发测试邮件内容', 'A', '2018-03-17 09:20:09');
INSERT INTO `ssm_user_email` VALUES ('ac2323c7-233a-11e8-85f7-c85b76f243c4', '6a1c141a-22ac-11e8-85f7-c85b76f243c4', '1', '群发测试', '群发测试 body', 'A', '2018-03-09 09:39:04');
INSERT INTO `ssm_user_email` VALUES ('da7b4a78-2980-11e8-b02d-c85b76f243c4', '1', '6a1c141a-22ac-11e8-85f7-c85b76f243c4', '吴鹏群发测试邮件', '吴鹏群发测试邮件', 'A', '2018-03-17 09:16:11');

-- ----------------------------
-- Table structure for ssm_user_login
-- ----------------------------
DROP TABLE IF EXISTS `ssm_user_login`;
CREATE TABLE `ssm_user_login` (
  `user_id` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `user_role` varchar(45) NOT NULL,
  `nick_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ssm_user_login
-- ----------------------------
INSERT INTO `ssm_user_login` VALUES ('1', 'admin', 'pass1234', 'admin', '吴鹏管理员账号', '1419914659@qq.com', '13666666668', 'M');
INSERT INTO `ssm_user_login` VALUES ('6a1c141a-22ac-11e8-85f7-c85b76f243c4', 'test', 'pass1234', 'worker', '吴鹏测试账号', '1419914659@qq.com', '13666666666', 'M');
