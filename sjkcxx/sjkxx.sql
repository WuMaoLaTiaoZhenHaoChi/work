/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云（123.206.64.22 work）
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 123.206.64.22:3306
 Source Schema         : sjkxx

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 01/08/2020 10:19:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for practice_subject
-- ----------------------------
DROP TABLE IF EXISTS `practice_subject`;
CREATE TABLE `practice_subject`  (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程编号',
  `subject_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `subject_department` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系',
  `subject_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程类别',
  `subject_check` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未审核' COMMENT '是否审核0：未审核 1：已审核',
  `subject_main` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程简介',
  `subject_people_now` int(20) NULL DEFAULT 0 COMMENT '课程人数',
  `subject_people_max` int(20) NULL DEFAULT NULL COMMENT '课程最大人数',
  `subject_start_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程开始时间',
  `subject_end_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程结束时间',
  `subject_require` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程要求',
  `subject_score` float NULL DEFAULT NULL COMMENT '课程评分',
  `teacher_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师编号',
  `teacher_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师姓名',
  `input_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '录入时间',
  `sort_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `site` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '场地',
  `equipment` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所需器材',
  PRIMARY KEY (`subject_num`, `subject_name`, `teacher_num`, `teacher_name`) USING BTREE,
  INDEX `subject_id`(`subject_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of practice_subject
-- ----------------------------
INSERT INTO `practice_subject` VALUES (53, 'DX001001', 'JAVA', '电子与信息工程学院', '专业技能考核类', '已通过', '123', 1, 1, '2020-05-30', '2020-05-30', '1\n2\n3', NULL, 'DX001', '张宇', NULL, NULL, 'A304', '123');
INSERT INTO `practice_subject` VALUES (54, 'DX001002', 'C++', '电子与信息工程学院', '专业见习类', '已通过', '123', 1, 2, '2020-05-31', '2020-05-31', '1.\n2.\n3.', NULL, 'DX001', '张宇', NULL, NULL, 'A304', '123');
INSERT INTO `practice_subject` VALUES (55, 'DX001003', 'PHP', '电子与信息工程学院', '专业见习类', '已通过', '123', 2, 2, '2020-05-31', '2020-06-02', '1.2.3.', NULL, 'DX001', '张宇', NULL, NULL, 'A501', '123');
INSERT INTO `practice_subject` VALUES (56, 'DX002001', '电子商务', '电子与信息工程学院', '专业见习类', '已通过', '123', 0, 3, '2020-05-30', '2020-06-03', '1\n2\n3\n', NULL, 'DX002', '唐家风', NULL, NULL, 'B533', '123');
INSERT INTO `practice_subject` VALUES (57, 'ST001001', '数学建模', '数学与统计系', '专业技能考核类', '已通过', '123', 1, 4, '2020-05-31', '2020-06-05', 'yaoqiu', NULL, 'ST001', 'KK', NULL, NULL, 'B403', '器材');

-- ----------------------------
-- Table structure for student_info
-- ----------------------------
DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info`  (
  `student_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `user_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生编号',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `student_class` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `user_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `user_specialty` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_class` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_num`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_info
-- ----------------------------
INSERT INTO `student_info` VALUES (42, '2016021001', '张三', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `student_info` VALUES (43, '2016021002', '李四', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `student_info` VALUES (44, '2016021003', '王刚', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `student_info` VALUES (45, '2016021004', '刘山', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `student_info` VALUES (46, '2016021005', '尔康', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `student_info` VALUES (47, '2016021006', '杨姐', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `student_info` VALUES (48, '2016021007', '灰灰', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `student_info` VALUES (49, '2016021008', '白白', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for student_subject
-- ----------------------------
DROP TABLE IF EXISTS `student_subject`;
CREATE TABLE `student_subject`  (
  `student_subject_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生课程对应id',
  `student_subject_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生课程对应编号',
  `teacher_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师编号',
  `teacher_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `student_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生编号',
  `student_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `subject_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程编号',
  `subject_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `subject_static` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '未修完' COMMENT '课程是否修完',
  `subject_grade` float NULL DEFAULT NULL COMMENT '课程成绩',
  `subject_work` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程作业（路径）',
  `subject_score` float NULL DEFAULT NULL COMMENT '课程评分',
  `subject_remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程评价',
  `sign_date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签到时间',
  `sign_time` int(11) NULL DEFAULT NULL COMMENT '签到次数',
  `sign_time_count` int(11) NULL DEFAULT NULL COMMENT '需要签到次数',
  PRIMARY KEY (`student_subject_num`) USING BTREE,
  INDEX `student_subject_id`(`student_subject_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_subject
-- ----------------------------
INSERT INTO `student_subject` VALUES (62, 'DX0010012016021001', 'DX001', '张宇', '2016021001', '张三', 'DX001001', 'JAVA', '已结束，已评价', 90, 'DX0010012016021001.xlsx', 5, '3423', '20200530', 1, 1);
INSERT INTO `student_subject` VALUES (65, 'DX0010022016021002', 'DX001', '张宇', '2016021002', '李四', 'DX001002', 'C++', '已提交实践报告', NULL, 'DX0010022016021002.rtf', NULL, NULL, '20200531', 1, 1);
INSERT INTO `student_subject` VALUES (64, 'DX0010032016021001', 'DX001', '张宇', '2016021001', '张三', 'DX001003', 'PHP', '已提交实践报告', NULL, 'DX0010032016021001.xlsx', NULL, NULL, '20200531', 1, 3);
INSERT INTO `student_subject` VALUES (63, 'DX0010032016021002', 'DX001', '张宇', '2016021002', '李四', 'DX001003', 'PHP', '未修完', NULL, NULL, NULL, NULL, '20200531', 1, 3);
INSERT INTO `student_subject` VALUES (66, 'ST0010012016021004', 'ST001', 'KK', '2016021004', '刘山', 'ST001001', '数学建模', '已提交实践报告', NULL, 'ST0010012016021004.xlsx', NULL, NULL, '20200531', 1, 6);

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info`  (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师编号',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `teacher_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `teacher_rank` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师职称',
  `teacher_position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师职务',
  `teacher_professional` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师专业',
  `user_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `user_specialty` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_class` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_num`) USING BTREE,
  INDEX `teacher_id`(`teacher_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_info
-- ----------------------------
INSERT INTO `teacher_info` VALUES (29, 'DX001', '张宇', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `teacher_info` VALUES (30, 'DX002', '唐家风', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `teacher_info` VALUES (31, 'ST001', 'KK', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编号',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_type` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `user_specialty` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '院系',
  `user_class` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  PRIMARY KEY (`user_num`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (3, '201', '管理员01', '201', '2', '电信学院', '');
INSERT INTO `user_info` VALUES (83, '2016021001', '张三', '2016021001', '0', '电信学院', '计算机1班');
INSERT INTO `user_info` VALUES (84, '2016021002', '李四', '2016021002', '0', '电信学院', '计算机1班');
INSERT INTO `user_info` VALUES (85, '2016021003', '王刚', '2016021003', '0', '电信学院', '计算机1班');
INSERT INTO `user_info` VALUES (86, '2016021004', '刘山', '2016021004', '0', '电信学院', '计算机1班');
INSERT INTO `user_info` VALUES (87, '2016021005', '尔康', '2016021005', '0', '电信学院', '计算机1班');
INSERT INTO `user_info` VALUES (88, '2016021006', '杨姐', '2016021006', '0', '电信学院', '计算机1班');
INSERT INTO `user_info` VALUES (92, '2016021007', '灰灰', '2016021007', '0', '电信学院', '计算机1班');
INSERT INTO `user_info` VALUES (93, '2016021008', '白白', '2016021008', '0', '电信学院', '计算机1班');
INSERT INTO `user_info` VALUES (89, 'DX001', '张宇', 'DX001', '1', '电信学院', '');
INSERT INTO `user_info` VALUES (90, 'DX002', '唐家风', 'DX002', '1', '电信学院', '');
INSERT INTO `user_info` VALUES (91, 'ST001', 'KK', 'ST001', '1', '数统', '');

SET FOREIGN_KEY_CHECKS = 1;
