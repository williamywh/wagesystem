/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : wagesystem

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 03/05/2018 20:46:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for allowance
-- ----------------------------
DROP TABLE IF EXISTS `allowance`;
CREATE TABLE `allowance`  (
  `al_id` int(12) NOT NULL AUTO_INCREMENT,
  `ot_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `day` date DEFAULT NULL,
  `subsidy` decimal(5, 0) DEFAULT NULL,
  PRIMARY KEY (`al_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for check_allow
-- ----------------------------
DROP TABLE IF EXISTS `check_allow`;
CREATE TABLE `check_allow`  (
  `ca_id` int(12) NOT NULL AUTO_INCREMENT,
  `cs_id` int(12) DEFAULT NULL,
  `al_id` int(12) DEFAULT NULL,
  PRIMARY KEY (`ca_id`) USING BTREE,
  INDEX `cs_id`(`cs_id`) USING BTREE,
  INDEX `al_id`(`al_id`) USING BTREE,
  CONSTRAINT `check_allow_ibfk_1` FOREIGN KEY (`cs_id`) REFERENCES `wagesystem`.`checkstat` (`cs_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `check_allow_ibfk_2` FOREIGN KEY (`al_id`) REFERENCES `wagesystem`.`allowance` (`al_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for checkstat
-- ----------------------------
DROP TABLE IF EXISTS `checkstat`;
CREATE TABLE `checkstat`  (
  `cs_id` int(12) NOT NULL AUTO_INCREMENT,
  `e_id` int(12) DEFAULT NULL,
  `ot_days` decimal(5, 0) DEFAULT NULL,
  `absent_days` decimal(5, 0) DEFAULT NULL,
  `leave_days` decimal(5, 0) DEFAULT NULL,
  `year` decimal(5, 0) DEFAULT NULL,
  `month` decimal(5, 0) DEFAULT NULL,
  `work_days` decimal(5, 0) DEFAULT NULL,
  PRIMARY KEY (`cs_id`) USING BTREE,
  INDEX `e_id`(`e_id`) USING BTREE,
  CONSTRAINT `checkstat_ibfk_1` FOREIGN KEY (`e_id`) REFERENCES `wagesystem`.`employee` (`e_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for emp_jobc
-- ----------------------------
DROP TABLE IF EXISTS `emp_jobc`;
CREATE TABLE `emp_jobc`  (
  `ej_id` int(12) NOT NULL AUTO_INCREMENT,
  `e_id` int(12) DEFAULT NULL,
  `j_id` int(12) DEFAULT NULL,
  PRIMARY KEY (`ej_id`) USING BTREE,
  INDEX `e_id`(`e_id`) USING BTREE,
  INDEX `j_id`(`j_id`) USING BTREE,
  CONSTRAINT `emp_jobc_ibfk_1` FOREIGN KEY (`e_id`) REFERENCES `wagesystem`.`employee` (`e_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `emp_jobc_ibfk_2` FOREIGN KEY (`j_id`) REFERENCES `wagesystem`.`jobcategories` (`j_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp_jobc
-- ----------------------------
INSERT INTO `emp_jobc` VALUES (1, 116, 6);
INSERT INTO `emp_jobc` VALUES (2, 117, 7);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `e_id` int(12) NOT NULL AUTO_INCREMENT,
  `e_name` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tel` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `note` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `datetime` date DEFAULT NULL,
  PRIMARY KEY (`e_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 118 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '张三', '男', '13416254892', '广州天河北', '1111', '1', '2018-04-02');
INSERT INTO `employee` VALUES (2, '李四', '男', '13416298530', '广州天河岗顶', '1111', '1', '2018-04-24');
INSERT INTO `employee` VALUES (3, 'adfsa', '男', '15987561540', '广州', '1111', '1', '2018-04-20');
INSERT INTO `employee` VALUES (4, 'evinho', '男', '13416142525', '华南农业大学', 'admin', 'test', '2018-04-16');
INSERT INTO `employee` VALUES (5, 'asf', '女', '15975365482', '广州', '111111', '1', '2018-04-11');
INSERT INTO `employee` VALUES (6, 'adf', '男', '15975325846', '广州', '111111', '2', '2018-04-11');
INSERT INTO `employee` VALUES (7, 'hyf', '男', '15956659685', '上海', '111111', '1', '2018-04-24');
INSERT INTO `employee` VALUES (8, 'yin', '女', '15486325486', '云南', '111111', '2', '2018-04-03');
INSERT INTO `employee` VALUES (9, 'wen', '男', '15478563284', '湖南', '011215', '2', '2018-04-09');
INSERT INTO `employee` VALUES (10, 'hui', '男', '15987654823', '湛江', '159852', '发的发的', '2018-04-06');
INSERT INTO `employee` VALUES (11, '赵燕', '女', '15975365842', '广州', '1111', '1', '2018-04-03');
INSERT INTO `employee` VALUES (12, '王五', '女', '13648954621', '海南', 'asdf', '手动阀', '2018-04-29');
INSERT INTO `employee` VALUES (112, '赵燕f', '男', '15975326485', '东莞', '111111', 'Test', '2018-04-30');
INSERT INTO `employee` VALUES (115, '赵燕g', '男', '15975326485', '东莞', '111111', 'Test', '2018-04-30');
INSERT INTO `employee` VALUES (116, '赵红', '女', '13459632485', '华工', '111111', '', '2018-04-19');
INSERT INTO `employee` VALUES (117, '王五', '男', '15985632458', '华山', '111111', '', '2018-05-16');

-- ----------------------------
-- Table structure for jobcategories
-- ----------------------------
DROP TABLE IF EXISTS `jobcategories`;
CREATE TABLE `jobcategories`  (
  `j_id` int(12) NOT NULL AUTO_INCREMENT,
  `title` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `dept` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `base_wage` int(10) DEFAULT NULL,
  `classn` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`j_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jobcategories
-- ----------------------------
INSERT INTO `jobcategories` VALUES (1, '默认', '技术部', 6000, '高级技师');
INSERT INTO `jobcategories` VALUES (2, '默认', '技术部', 5500, '普通技师');
INSERT INTO `jobcategories` VALUES (3, '默认', '人资部', 4000, 'HR');
INSERT INTO `jobcategories` VALUES (4, '默认', '研发部', 10000, '研发部长');
INSERT INTO `jobcategories` VALUES (5, '默認', '財務部', 50000, '财务部长');
INSERT INTO `jobcategories` VALUES (6, '助理', '人资部', 4000, '普通员工');
INSERT INTO `jobcategories` VALUES (7, '普通员工', '人资部', 3500, '普通员工');

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `e_id` int(12) NOT NULL,
  `cs_id` int(12) DEFAULT NULL,
  `sum` decimal(10, 0) DEFAULT NULL COMMENT '工资',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `e_id`(`e_id`) USING BTREE,
  INDEX `cs_id`(`cs_id`) USING BTREE,
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`e_id`) REFERENCES `wagesystem`.`employee` (`e_id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `salary_ibfk_2` FOREIGN KEY (`cs_id`) REFERENCES `wagesystem`.`checkstat` (`cs_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
