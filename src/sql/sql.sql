/*
SQLyog Enterprise Trial - MySQL GUI v7.11 
MySQL - 5.5.60 : Database - prison_appointment
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`prison_appointment` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `prison_appointment`;

/*Table structure for table `tb_admin` */

DROP TABLE IF EXISTS `tb_admin`;

CREATE TABLE `tb_admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `mail` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_admin` */

insert  into `tb_admin`(`id`,`mail`,`NAME`,`pwd`) values (1,'123456@qq.com','管1','123456'),(2,'234567@qq.com','管2','234567'),(3,'345678@qq.com','管3','345678');

/*Table structure for table `tb_appointment` */

DROP TABLE IF EXISTS `tb_appointment`;

CREATE TABLE `tb_appointment` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `mail` varchar(20) NOT NULL COMMENT '会见人姓名',
  `prison_id` int(10) NOT NULL,
  `description` varchar(100) NOT NULL,
  `meet_time` varchar(100) DEFAULT NULL,
  `meet_pos` varchar(200) NOT NULL,
  `meet_record` varchar(1000) DEFAULT NULL,
  `state` int(1) NOT NULL DEFAULT '0',
  `memo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `prison_id` (`prison_id`),
  CONSTRAINT `tb_appointment_ibfk_1` FOREIGN KEY (`prison_id`) REFERENCES `tb_prison` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `tb_appointment` */

insert  into `tb_appointment`(`id`,`mail`,`prison_id`,`description`,`meet_time`,`meet_pos`,`meet_record`,`state`,`memo`) values (23,'123456789@qq.com',1,'定期问候','2018-05-23 12:00:00','a4',NULL,2,NULL),(24,'456@qq.com',3,'日常探望亲属',NULL,'',NULL,1,NULL),(25,'995200228@qq.com',5,'定期看望','2018-05-29 16:00:00','a1',NULL,2,NULL),(26,'995200228@qq.com',4,'日常探亲',NULL,'',NULL,1,NULL),(27,'7789456@qq.com',6,'定期探望','2018-05-24 09:00:00','a1','情况良好',3,NULL),(28,'1231@qq.com',4,'///定期探望','2018-05-24 13:00:00','a3','nijuniuhihu',3,NULL);

/*Table structure for table `tb_police` */

DROP TABLE IF EXISTS `tb_police`;

CREATE TABLE `tb_police` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `mail` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `police_rank` int(2) DEFAULT NULL COMMENT '1-20级别',
  `police_start_dt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pwd` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tb_police` */

insert  into `tb_police`(`id`,`mail`,`NAME`,`police_rank`,`police_start_dt`,`pwd`) values (1,'111111111@qq.com','狱警1',1,'2018-05-17 03:39:34','111'),(2,'222222222@qq.com','狱警2',2,'2018-05-23 03:39:52','222'),(3,'333333333@qq.com','狱警3',3,'2018-05-22 03:39:54','333'),(4,'444444444@qq.com','狱警4',2,'2018-05-04 03:39:56','444'),(5,'555555555@qq.com','狱警5 ',2,'2018-05-28 03:39:58','555');

/*Table structure for table `tb_pos` */

DROP TABLE IF EXISTS `tb_pos`;

CREATE TABLE `tb_pos` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pos` varchar(30) NOT NULL,
  `status` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tb_pos` */

insert  into `tb_pos`(`id`,`pos`,`status`) values (1,'a1',0),(2,'a2',0),(3,'a3',0),(4,'a4',0);

/*Table structure for table `tb_prison` */

DROP TABLE IF EXISTS `tb_prison`;

CREATE TABLE `tb_prison` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL,
  `crime_reason` varchar(1000) NOT NULL,
  `crime_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入狱时间',
  `crime_room` varchar(100) NOT NULL,
  `crime_spend` varchar(10) NOT NULL COMMENT '刑长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `tb_prison` */

insert  into `tb_prison`(`id`,`NAME`,`crime_reason`,`crime_time`,`crime_room`,`crime_spend`) values (1,'罪犯1','抢劫','2018-05-19 15:21:35','1-101',''),(2,'罪犯2','抢劫','2018-05-19 15:22:02','1-102',''),(3,'罪犯3','盗窃','2018-05-19 15:22:29','1-103',''),(4,'罪犯4','盗窃','2018-05-19 15:22:47','1-104',''),(5,'罪犯5','犯法','2018-05-19 15:23:16','1-105',''),(6,'罪犯6','犯法','2018-05-19 15:23:31','1-106',''),(7,'罪犯7','反社会','2018-05-19 15:24:11','1-107','');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `mail` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `idcard` varchar(30) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`mail`,`NAME`,`idcard`,`pwd`) values (1,'123456789@qq.com','张三','360124199701010000','123'),(2,'995200228@qq.com','饶梦钰','360124196201010084','jmumm845'),(11,'456@qq.com','李四','360120198201052222','456'),(12,'7789456@qq.com','张六','22213546','zdj'),(13,'1231@qq.com','张琪','23129846','456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
