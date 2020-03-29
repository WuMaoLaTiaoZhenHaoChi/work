/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.29-log : Database - pdjh
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pdjh` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pdjh`;

/*Table structure for table `business` */

DROP TABLE IF EXISTS `business`;

CREATE TABLE `business` (
  `business_id` int(11) NOT NULL AUTO_INCREMENT,
  `business_num` varchar(20) NOT NULL COMMENT '业务编号',
  `business_name` varchar(50) NOT NULL COMMENT '业务名称',
  `business_type` varchar(20) DEFAULT NULL COMMENT '业务类型',
  `business_description` varchar(255) DEFAULT NULL COMMENT '业务描述',
  `business_grade` varchar(20) DEFAULT NULL COMMENT '业务评分',
  KEY `business_id` (`business_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `business` */

/*Table structure for table `customer_info` */

DROP TABLE IF EXISTS `customer_info`;

CREATE TABLE `customer_info` (
  `customer_id` int(20) NOT NULL AUTO_INCREMENT,
  `customer_num` varchar(20) NOT NULL COMMENT '客户编号',
  `customer_name` varchar(20) DEFAULT NULL COMMENT '客户姓名',
  `customer_level` varchar(20) DEFAULT NULL COMMENT '客户等级',
  PRIMARY KEY (`customer_num`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer_info` */

/*Table structure for table `employee_info` */

DROP TABLE IF EXISTS `employee_info`;

CREATE TABLE `employee_info` (
  `employee_id` int(20) NOT NULL AUTO_INCREMENT,
  `employee_num` varchar(20) NOT NULL COMMENT '员工编号',
  `employee_name` varchar(20) DEFAULT NULL COMMENT '员工姓名',
  `employee_dept` varchar(20) DEFAULT NULL COMMENT '员工部门',
  PRIMARY KEY (`employee_num`),
  KEY `employee_id` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee_info` */

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(20) NOT NULL COMMENT '订单编号',
  `order_describe` varchar(255) DEFAULT NULL COMMENT '订单描述',
  `order_creat_time` varchar(50) DEFAULT NULL COMMENT '订单创建时间',
  `order_end_time` varchar(50) DEFAULT NULL COMMENT '订单结束时间',
  `order_grade` varchar(20) DEFAULT NULL COMMENT '客户评价',
  `order_remark` varchar(255) DEFAULT NULL COMMENT '客户评价被抓住',
  `customer_num` varchar(20) DEFAULT NULL COMMENT '客户编号',
  `employee_num` varchar(20) DEFAULT NULL COMMENT '员工编号',
  PRIMARY KEY (`order_num`),
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(50) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `user_type` varchar(5) DEFAULT NULL COMMENT '用户权限',
  PRIMARY KEY (`user_num`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

insert  into `user_info`(`user_id`,`user_num`,`user_name`,`user_pwd`,`user_type`) values (1,'001','用户01','000','0'),(2,'101','银行工作人员01','111','1'),(3,'202','管理员01','222','2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
