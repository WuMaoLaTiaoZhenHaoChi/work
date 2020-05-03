/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.29-log : Database - sjkxx
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sjkxx` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sjkxx`;

/*Table structure for table `practice_subject` */

DROP TABLE IF EXISTS `practice_subject`;

CREATE TABLE `practice_subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_num` varchar(50) NOT NULL COMMENT '课程编号',
  `subject_name` varchar(50) DEFAULT NULL COMMENT '课程名称',
  `subject_type` varchar(20) DEFAULT NULL COMMENT '课程类别',
  `subject_check` varchar(5) DEFAULT '0' COMMENT '是否审核0：未审核 1：已审核',
  `subject_main` varchar(255) DEFAULT NULL COMMENT '课程简介',
  `subject_people_max` int(5) DEFAULT NULL COMMENT '课程人数',
  `subject_start_time` varchar(50) DEFAULT NULL COMMENT '课程开课日期',
  `subject_require` varchar(255) DEFAULT NULL COMMENT '课程要求',
  `subject_score` float DEFAULT NULL COMMENT '课程评分',
  `teacher_num` varchar(50) DEFAULT NULL COMMENT '教师编号',
  `input_time` varchar(50) DEFAULT NULL COMMENT '录入时间',
  PRIMARY KEY (`subject_num`),
  KEY `subject_id` (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `practice_subject` */

insert  into `practice_subject`(`subject_id`,`subject_num`,`subject_name`,`subject_type`,`subject_check`,`subject_main`,`subject_people_max`,`subject_start_time`,`subject_require`,`subject_score`,`teacher_num`,`input_time`) values (11,'11102','课程02','专业技能考核类','0','公益服务类课程02',1,'2020-03-16','',NULL,'101',NULL),(10,'123345','公益服务类课程03','公益服务类','0','公益服务类课程02',11,'2020-03-11','',NULL,'101',NULL),(12,'kecheng04','课程04','专业技能考核类','0','课程04',20,'2020-03-26','课程04',NULL,'102',NULL),(13,'kecheng05','课程05','专业见习类','0','课程05',22,'2020-03-25','课程05',NULL,'102',NULL);

/*Table structure for table `student_info` */

DROP TABLE IF EXISTS `student_info`;

CREATE TABLE `student_info` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `user_num` varchar(50) NOT NULL COMMENT '学生编号',
  `user_name` varchar(20) DEFAULT NULL COMMENT '学生姓名',
  `student_specialty_num` varchar(50) DEFAULT NULL COMMENT '所属院系编号',
  PRIMARY KEY (`user_num`),
  KEY `student_id` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `student_info` */

insert  into `student_info`(`student_id`,`user_num`,`user_name`,`student_specialty_num`) values (1,'000',NULL,'110');

/*Table structure for table `student_subject` */

DROP TABLE IF EXISTS `student_subject`;

CREATE TABLE `student_subject` (
  `student_subject_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生课程对应id',
  `student_subject_num` varchar(50) NOT NULL COMMENT '学生课程对应编号',
  `student_num` varchar(50) DEFAULT NULL COMMENT '学生编号',
  `subject_num` varchar(50) DEFAULT NULL COMMENT '课程编号',
  `subject_end` varchar(5) DEFAULT NULL COMMENT '课程是否修完',
  `subject_grade` float DEFAULT NULL COMMENT '课程成绩',
  `subject_work` varchar(50) DEFAULT NULL COMMENT '课程作业（路径）',
  `subject_score` float DEFAULT NULL COMMENT '课程评分',
  `subject_remark` varchar(50) DEFAULT NULL COMMENT '课程评价',
  PRIMARY KEY (`student_subject_num`),
  KEY `student_subject_id` (`student_subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student_subject` */

/*Table structure for table `teacher_info` */

DROP TABLE IF EXISTS `teacher_info`;

CREATE TABLE `teacher_info` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(50) NOT NULL COMMENT '教师编号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '教师姓名',
  `teacher_phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `teacher_rank` varchar(50) DEFAULT NULL COMMENT '教师职称',
  `teacher_position` varchar(50) DEFAULT NULL COMMENT '教师职务',
  `teacher_professional` varchar(50) DEFAULT NULL COMMENT '教师专业',
  `teacher_specialty_num` varchar(50) DEFAULT NULL COMMENT '所属院系编号',
  PRIMARY KEY (`user_num`),
  KEY `teacher_id` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `teacher_info` */

insert  into `teacher_info`(`teacher_id`,`user_num`,`user_name`,`teacher_phone`,`teacher_rank`,`teacher_position`,`teacher_professional`,`teacher_specialty_num`) values (2,'102',NULL,'12345678','教授','副主任','计算机','001'),(1,'111',NULL,'12345678','教授','副主任','计算机','001');

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(50) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `user_type` varchar(5) DEFAULT NULL COMMENT '用户',
  PRIMARY KEY (`user_num`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

insert  into `user_info`(`user_id`,`user_num`,`user_name`,`user_pwd`,`user_type`) values (1,'001','学生01','001','0'),(2,'101','教师01','101','1'),(4,'102','教师02','102','1'),(3,'201','管理员01','201','2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
