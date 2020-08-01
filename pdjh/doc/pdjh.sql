/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云（123.206.64.22 work）
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 123.206.64.22:3306
 Source Schema         : pdjh

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 01/08/2020 10:19:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for business
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business`  (
  `business_id` int(11) NOT NULL AUTO_INCREMENT,
  `business_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务编号',
  `business_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务名称',
  `business_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务类型',
  `business_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务描述',
  `business_grade` float NULL DEFAULT NULL COMMENT '业务评分',
  PRIMARY KEY (`business_num`) USING BTREE,
  INDEX `business_id`(`business_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of business
-- ----------------------------

-- ----------------------------
-- Table structure for customer_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info`  (
  `customer_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户编号',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `customer_level` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '客户等级',
  `user_pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户密码',
  `user_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户类型',
  PRIMARY KEY (`user_num`) USING BTREE,
  INDEX `customer_id`(`customer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_info
-- ----------------------------
INSERT INTO `customer_info` VALUES (44, '13571798690', '关羽', '1', NULL, NULL);
INSERT INTO `customer_info` VALUES (42, '15091173920', '典韦', '2', NULL, NULL);
INSERT INTO `customer_info` VALUES (43, '18391508871', '蔡文姬', '2', NULL, NULL);

-- ----------------------------
-- Table structure for employee_info
-- ----------------------------
DROP TABLE IF EXISTS `employee_info`;
CREATE TABLE `employee_info`  (
  `employee_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工编号',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `employee_dept` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工部门',
  `employee_grade` float NULL DEFAULT NULL COMMENT '员工评分',
  `user_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型1，员工',
  `user_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工密码',
  PRIMARY KEY (`user_num`) USING BTREE,
  INDEX `employee_id`(`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee_info
-- ----------------------------
INSERT INTO `employee_info` VALUES (13, '20200002', '李薇', NULL, NULL, NULL, NULL);
INSERT INTO `employee_info` VALUES (14, '20200003', '王丽', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
  `order_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单描述',
  `order_creat_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单创建时间',
  `order_end_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单结束时间',
  `order_flag` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未受理' COMMENT '订单状态（0：已预约，1：已受理，2：已结束）',
  `order_grade` float NULL DEFAULT 5 COMMENT '客户评分',
  `order_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户评价备注',
  `customer_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户编号',
  `employee_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工编号',
  `business_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务类型',
  `customer_level` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '客户等级',
  PRIMARY KEY (`order_num`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 121 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (112, '1357179869020200529204530', '123', '2020-05-29 20:45:30', '2020-05-29 20:46:09', '已评价', 4, '13571798690', '13571798690', '20200002', '资产业务', '1');
INSERT INTO `order_info` VALUES (101, '1509117392020200511145615', '', '2020-05-11 14:56:15', NULL, '已关闭', 5, NULL, '15091173920', NULL, '资产业务', NULL);
INSERT INTO `order_info` VALUES (102, '1509117392020200511145825', '', '2020-05-11 14:58:25', '2020-05-11 15:00:44', '已评价', 5, NULL, '15091173920', '20200002', '资产业务', NULL);
INSERT INTO `order_info` VALUES (103, '1509117392020200511150012', '', '2020-05-11 15:00:12', '2020-05-11 15:00:48', '已评价', 2, NULL, '15091173920', '20200002', '资产业务', NULL);
INSERT INTO `order_info` VALUES (104, '1509117392020200511150221', '', '2020-05-11 15:02:21', NULL, '已关闭', 5, NULL, '15091173920', NULL, '资产业务', NULL);
INSERT INTO `order_info` VALUES (105, '1509117392020200511150830', '', '2020-05-11 15:08:30', NULL, '已关闭', 5, NULL, '15091173920', NULL, '资产业务', NULL);
INSERT INTO `order_info` VALUES (106, '1509117392020200511150835', '', '2020-05-11 15:08:35', NULL, '已关闭', 5, NULL, '15091173920', NULL, '资产业务', NULL);
INSERT INTO `order_info` VALUES (109, '1509117392020200529160000', '取款100万', '2020-05-29 15:59:59', '2020-05-29 16:11:11', '已评价', 3, NULL, '15091173920', '20200002', '资产业务', NULL);
INSERT INTO `order_info` VALUES (113, '1509117392020200530090911', '贷款100万', '2020-05-30 09:09:11', '2020-05-30 09:11:30', '已评价', 5, '服务优秀', '15091173920', '20200002', '负债业务', '2');
INSERT INTO `order_info` VALUES (114, '1509117392020200530233822', '取款1万\n', '2020-05-30 23:38:22', '2020-05-30 23:41:06', '已评价', 3, '差评', '15091173920', '20200002', '资产业务', '2');
INSERT INTO `order_info` VALUES (115, '1509117392020200531092458', '贷款1万', '2020-05-31 09:24:58', NULL, '已关闭', 5, NULL, '15091173920', NULL, '负债业务', '2');
INSERT INTO `order_info` VALUES (116, '1509117392020200531092542', '贷款1万', '2020-05-31 09:25:42', NULL, '已关闭', 5, NULL, '15091173920', NULL, '负债业务', '2');
INSERT INTO `order_info` VALUES (117, '1509117392020200531103527', '', '2020-05-31 10:35:27', '2020-05-31 10:37:02', '已结束', 5, NULL, '15091173920', '20200002', '资产业务', '2');
INSERT INTO `order_info` VALUES (118, '1509117392020200531103804', '取款', '2020-05-31 10:38:04', NULL, '已关闭', 5, NULL, '15091173920', '20200002', '资产业务', '2');
INSERT INTO `order_info` VALUES (119, '1509117392020200531104458', '取款', '2020-05-31 10:44:58', NULL, '已关闭', 5, NULL, '15091173920', '20200002', '资产业务', '2');
INSERT INTO `order_info` VALUES (107, '1839150887120200511160542', '', '2020-05-11 16:05:42', NULL, '已关闭', 5, NULL, '18391508871', NULL, '资产业务', '2');
INSERT INTO `order_info` VALUES (108, '1839150887120200511160544', '', '2020-05-11 16:05:44', NULL, '已关闭', 5, NULL, '18391508871', NULL, '资产业务', '2');
INSERT INTO `order_info` VALUES (110, '1839150887120200529162939', '贷款2万\n\n', '2020-05-29 16:29:39', NULL, '已关闭', 5, NULL, '18391508871', NULL, '资产业务', '2');
INSERT INTO `order_info` VALUES (111, '1839150887120200529162947', '贷款2万\n\n', '2020-05-29 16:29:47', '2020-05-29 16:30:12', '已结束', 3, NULL, '18391508871', '20200002', '负债业务', '2');
INSERT INTO `order_info` VALUES (120, '1839150887120200531104652', '贷款', '2020-05-31 10:46:52', NULL, '已关闭', 5, NULL, '18391508871', '20200003', '负债业务', '2');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `user_type` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户权限（0：客户，1：银行员工，2：管理员）',
  `customer_level` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '客户等级等级',
  PRIMARY KEY (`user_num`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 80 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (79, '13571798690', '关羽', '13571798690', '0', '1');
INSERT INTO `user_info` VALUES (74, '15091173920', '典韦', '15091173920', '0', '2');
INSERT INTO `user_info` VALUES (77, '18391508871', '蔡文姬', '18391508871', '0', '2');
INSERT INTO `user_info` VALUES (3, '201', '管理员01', '12345', '2', '1');
INSERT INTO `user_info` VALUES (75, '20200001', 'Administrator', '20200001', '2', '1');
INSERT INTO `user_info` VALUES (76, '20200002', '李薇', '20200002', '1', '1');
INSERT INTO `user_info` VALUES (78, '20200003', '王丽', '20200003', '1', '1');

SET FOREIGN_KEY_CHECKS = 1;
