/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.16-log : Database - yamp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yamp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `yamp`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) DEFAULT NULL COMMENT '账号',
  `phone` bigint(25) NOT NULL,
  `password` varchar(25) NOT NULL COMMENT '密码',
  `userRole` varchar(25) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`username`,`phone`,`password`,`userRole`) values (1,'admin',110,'123456','超级管理员');

/*Table structure for table `bill` */

DROP TABLE IF EXISTS `bill`;

CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_code` varchar(30) DEFAULT NULL COMMENT '订单编号',
  `transaction` double DEFAULT NULL COMMENT '交易金额',
  `player` varchar(30) DEFAULT NULL COMMENT '交易者',
  `player_time` varchar(30) DEFAULT NULL COMMENT '交易时间',
  `goods_ids` varchar(5000) DEFAULT NULL COMMENT '购买商品id 集合 或者采购商品id 集合',
  `line_order_status` int(11) DEFAULT NULL COMMENT '0待处理1已处理',
  `status` int(11) DEFAULT NULL COMMENT '0  删除  1 买商品账单 2 采购商品账单',
  `creater` varchar(30) DEFAULT NULL COMMENT '创建者',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `into_or_out_status` int(11) DEFAULT NULL COMMENT '0进货 1售货',
  `address` varchar(200) DEFAULT NULL COMMENT '送货地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `bill` */

insert  into `bill`(`id`,`order_code`,`transaction`,`player`,`player_time`,`goods_ids`,`line_order_status`,`status`,`creater`,`create_time`,`into_or_out_status`,`address`) values (21,'CO7043742475405152',1000,'admin','','[{\"boxBidPrice\":\"50\",\"boxCount\":\"10\",\"boxPrice\":\"60\",\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":\"5\",\"branchCount\":\"100\",\"branchPrice\":\"6\",\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO5544082104340287\",\"id\":6,\"imgUrl\":\"2018-07-10/07dc3322-71ec-496b-b81d-ff79e1d9d6f2.jpg\",\"name\":\"巧乐兹\",\"note\":\"不错的选择！！\",\"status\":1,\"typeId\":10,\"typeTitle\":\"巧乐兹\",\"updateTime\":\"\",\"updater\":\"\",\"angName\":\"蒙牛代理商\"}]',1,1,'admin','2018-07-10',0,''),(22,'CO0021536635930100',270,'admin','','[{\"boxBidPrice\":50,\"boxCount\":\"2\",\"boxPrice\":60,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":5,\"branchCount\":\"20\",\"branchPrice\":6,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO5544082104340287\",\"id\":6,\"imgUrl\":\"2018-07-10/07dc3322-71ec-496b-b81d-ff79e1d9d6f2.jpg\",\"name\":\"巧乐兹\",\"note\":\"不错的选择！！\",\"status\":1,\"typeId\":10,\"typeTitle\":\"巧乐兹\",\"updateTime\":\"\",\"updater\":\"\"},{\"boxBidPrice\":50,\"boxCount\":\"1\",\"boxPrice\":75,\"braId\":4,\"braName\":\"蒙牛\",\"branchBidPrice\":2,\"branchCount\":\"1\",\"branchPrice\":3,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO8873327013029820\",\"id\":7,\"imgUrl\":\"2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg\",\"name\":\"小布丁\",\"note\":\"每一口都是爱的味道\",\"status\":1,\"typeId\":16,\"typeTitle\":\"小布丁\",\"updateTime\":\"\",\"updater\":\"\"}]',1,1,'admin','2018-07-10',1,'河北省石家庄市雨花区'),(23,'CO4218116920381434',2000,'admin',NULL,'[{\"boxBidPrice\":\"50\",\"boxCount\":\"20\",\"boxPrice\":\"75\",\"braId\":4,\"braName\":\"蒙牛\",\"branchBidPrice\":\"2\",\"branchCount\":\"500\",\"branchPrice\":\"3\",\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO8873327013029820\",\"id\":7,\"imgUrl\":\"2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg\",\"name\":\"小布丁\",\"note\":\"每一口都是爱的味道\",\"status\":1,\"typeId\":16,\"typeTitle\":\"小布丁\",\"updateTime\":\"\",\"updater\":\"\",\"angName\":\"蒙牛代理商\"}]',1,1,'admin','2018-07-10',0,NULL),(24,'CO9233254869594938',120,'admin',NULL,'[{\"boxBidPrice\":50,\"boxCount\":\"1\",\"boxPrice\":75,\"braId\":4,\"braName\":\"蒙牛\",\"branchBidPrice\":2,\"branchCount\":\"25\",\"branchPrice\":3,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO8873327013029820\",\"id\":7,\"imgUrl\":\"2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg\",\"name\":\"小布丁\",\"note\":\"每一口都是爱的味道\",\"status\":1,\"typeId\":16,\"typeTitle\":\"小布丁\",\"updateTime\":\"\",\"updater\":\"\"}]',1,1,'admin','2018-07-10',1,'河北省石家庄市'),(25,'CO1250812344702811',2000,'admin',NULL,'[{\"boxBidPrice\":\"50\",\"boxCount\":\"20\",\"boxPrice\":\"75\",\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":\"2\",\"branchCount\":\"500\",\"branchPrice\":\"3\",\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO4326026890640740\",\"id\":8,\"imgUrl\":\"2018-07-10/258e789f-2c41-45b4-99d1-823411b5a53e.jpg\",\"name\":\"雪莲\",\"note\":\"雪的味道我知道\",\"status\":1,\"typeId\":11,\"typeTitle\":\"雪莲\",\"updateTime\":\"\",\"updater\":\"\",\"angName\":\"蒙牛代理商\"}]',1,1,'admin','2018-07-10',0,NULL),(26,'CO3941119746578379',2000,'admin',NULL,'[{\"boxBidPrice\":\"50\",\"boxCount\":\"20\",\"boxPrice\":\"75\",\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":\"2\",\"branchCount\":\"500\",\"branchPrice\":\"3\",\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO0158439415898655\",\"id\":9,\"imgUrl\":\"\",\"name\":\"方糕\",\"note\":\"不错的选择！！\",\"status\":1,\"typeId\":12,\"typeTitle\":\"方糕\",\"updateTime\":\"\",\"updater\":\"\",\"angName\":\"伊利代理商\"}]',1,1,'admin','2018-07-10',0,NULL),(27,'CO1595019752822519',240,'admin',NULL,'[{\"boxBidPrice\":50,\"boxCount\":\"2\",\"boxPrice\":75,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":2,\"branchCount\":\"50\",\"branchPrice\":3,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO4326026890640740\",\"id\":8,\"imgUrl\":\"2018-07-10/258e789f-2c41-45b4-99d1-823411b5a53e.jpg\",\"name\":\"雪莲\",\"note\":\"雪的味道我知道\",\"status\":1,\"typeId\":11,\"typeTitle\":\"雪莲\",\"updateTime\":\"\",\"updater\":\"\"}]',1,1,'admin','2018-07-10',1,'河北省保定'),(28,'CO3156692066181177',120,'admin',NULL,'[{\"boxBidPrice\":50,\"boxCount\":\"1\",\"boxPrice\":75,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":2,\"branchCount\":\"25\",\"branchPrice\":3,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO0158439415898655\",\"id\":9,\"imgUrl\":\"2018-07-11/6f71a6a1-d422-40a1-b52f-2528073a4a4e.jpg\",\"name\":\"方糕\",\"note\":\"不错的选择！！\",\"status\":1,\"typeId\":12,\"typeTitle\":\"方糕\",\"updateTime\":\"2018-07-11\",\"updater\":\"admin\"}]',1,1,'admin','2018-07-11',1,'河北省石家庄市'),(29,'CO2816151488675237',748.8000000000001,'admin2',NULL,'[{\"boxBidPrice\":50,\"boxCount\":\"12\",\"boxPrice\":75,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":2,\"branchCount\":\"12\",\"branchPrice\":3,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO0158439415898655\",\"id\":9,\"imgUrl\":\"2018-07-11/6f71a6a1-d422-40a1-b52f-2528073a4a4e.jpg\",\"name\":\"方糕\",\"note\":\"不错的选择！！\",\"status\":1,\"typeId\":12,\"typeTitle\":\"方糕\",\"updateTime\":\"2018-07-11\",\"updater\":\"admin\"}]',1,1,'admin2','2018-07-11',1,''),(30,'CO3884701711481746',222,'admin2',NULL,'[{\"boxBidPrice\":50,\"boxCount\":\"1\",\"boxPrice\":75,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":2,\"branchCount\":\"1\",\"branchPrice\":3,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO4326026890640740\",\"id\":8,\"imgUrl\":\"2018-07-10/258e789f-2c41-45b4-99d1-823411b5a53e.jpg\",\"name\":\"雪莲\",\"note\":\"雪的味道我知道\",\"status\":1,\"typeId\":11,\"typeTitle\":\"雪莲\",\"updateTime\":\"\",\"updater\":\"\"},{\"boxBidPrice\":50,\"boxCount\":\"1\",\"boxPrice\":75,\"braId\":4,\"braName\":\"蒙牛\",\"branchBidPrice\":2,\"branchCount\":\"1\",\"branchPrice\":3,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO8873327013029820\",\"id\":7,\"imgUrl\":\"2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg\",\"name\":\"小布丁\",\"note\":\"每一口都是爱的味道\",\"status\":1,\"typeId\":16,\"typeTitle\":\"小布丁\",\"updateTime\":\"\",\"updater\":\"\"},{\"boxBidPrice\":50,\"boxCount\":\"1\",\"boxPrice\":60,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":5,\"branchCount\":\"1\",\"branchPrice\":6,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO5544082104340287\",\"id\":6,\"imgUrl\":\"2018-07-10/07dc3322-71ec-496b-b81d-ff79e1d9d6f2.jpg\",\"name\":\"巧乐兹\",\"note\":\"不错的选择！！\",\"status\":1,\"typeId\":10,\"typeTitle\":\"巧乐兹\",\"updateTime\":\"\",\"updater\":\"\"}]',1,1,'admin2','2018-07-11',1,''),(31,'AO1967085633438909',75,'admin',NULL,'[{\"boxBidPrice\":50.0,\"boxCount\":1,\"boxPrice\":75.0,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":2.0,\"branchCount\":0,\"branchPrice\":3.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO0158439415898655\",\"id\":9,\"imgUrl\":\"2018-07-11/6f71a6a1-d422-40a1-b52f-2528073a4a4e.jpg\",\"name\":\"方糕\",\"note\":\"不错的选择！！\",\"status\":1,\"typeId\":12,\"typeTitle\":\"方糕\",\"updateTime\":\"2018-07-11\",\"updater\":\"admin\"}]',0,1,'admin','2018-07-11',1,'河北省石家庄市长安区建研院'),(32,'AO1537774551266567',525,'admin66',NULL,'[{\"boxBidPrice\":50.0,\"boxCount\":6,\"boxPrice\":75.0,\"braId\":4,\"braName\":\"蒙牛\",\"branchBidPrice\":2.0,\"branchCount\":0,\"branchPrice\":3.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO8873327013029820\",\"id\":7,\"imgUrl\":\"2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg\",\"name\":\"小布丁\",\"note\":\"每一口都是爱的味道\",\"status\":1,\"typeId\":16,\"typeTitle\":\"小布丁\"},{\"boxBidPrice\":50.0,\"boxCount\":1,\"boxPrice\":75.0,\"braId\":4,\"braName\":\"蒙牛\",\"branchBidPrice\":2.0,\"branchCount\":0,\"branchPrice\":3.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO8873327013029820\",\"id\":7,\"imgUrl\":\"2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg\",\"name\":\"小布丁\",\"note\":\"每一口都是爱的味道\",\"status\":1,\"typeId\":16,\"typeTitle\":\"小布丁\"}]',0,1,'admin66','2018-07-11',1,'This is  Addressed'),(33,'AO9527905795672683',95,'admin',NULL,'[{\"boxBidPrice\":50.0,\"boxCount\":1,\"boxPrice\":75.0,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":2.0,\"branchCount\":0,\"branchPrice\":3.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO0158439415898655\",\"id\":9,\"imgUrl\":\"2018-07-11/6f71a6a1-d422-40a1-b52f-2528073a4a4e.jpg\",\"name\":\"方糕\",\"note\":\"不错的选择！！\",\"status\":1,\"typeId\":12,\"typeTitle\":\"方糕\",\"updateTime\":\"2018-07-11\",\"updater\":\"admin\"},{\"boxBidPrice\":0.0,\"boxCount\":1,\"boxPrice\":10.0,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":0.0,\"branchCount\":0,\"branchPrice\":8.0,\"createTime\":\"2018-07-11\",\"creater\":\"admin\",\"eachBoxNum\":1,\"goodsCode\":\"GO8881245452377146\",\"id\":17,\"imgUrl\":\"2018-07-11/6fea1187-9552-4ecb-8932-3ecf7cdc3103.jpg\",\"name\":\"老冰柜111\",\"note\":\"老师好\",\"status\":1,\"typeId\":2,\"typeTitle\":\"小神童\"},{\"boxBidPrice\":0.0,\"boxCount\":1,\"boxPrice\":10.0,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":0.0,\"branchCount\":0,\"branchPrice\":8.0,\"createTime\":\"2018-07-11\",\"creater\":\"admin\",\"eachBoxNum\":1,\"goodsCode\":\"GO8881245452377146\",\"id\":17,\"imgUrl\":\"2018-07-11/6fea1187-9552-4ecb-8932-3ecf7cdc3103.jpg\",\"name\":\"老冰柜111\",\"note\":\"老师好\",\"status\":1,\"typeId\":2,\"typeTitle\":\"小神童\"}]',0,1,'admin','2018-07-11',1,'河北省石家庄市长安区建研院'),(34,'AO7902790217049227',12,'admin',NULL,'[{\"boxBidPrice\":0.0,\"boxCount\":1,\"boxPrice\":12.0,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":0.0,\"branchCount\":0,\"branchPrice\":12.0,\"createTime\":\"2018-07-11\",\"creater\":\"admin\",\"eachBoxNum\":12,\"goodsCode\":\"GO3526874823391147\",\"id\":18,\"imgUrl\":\"2018-07-11/e5138234-04c3-4a35-ab48-36df83589b02.jpeg\",\"name\":\"西天天\",\"note\":\"不错的\",\"status\":1,\"typeId\":11,\"typeTitle\":\"雪莲\"}]',0,1,'admin','2018-07-11',1,'河北省石家庄市长安区建研院'),(35,'AO2114167535313073',75,'admin',NULL,'[{\"boxBidPrice\":50.0,\"boxCount\":1,\"boxPrice\":75.0,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":2.0,\"branchCount\":0,\"branchPrice\":3.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":1,\"goodsCode\":\"GO0158439415898655\",\"id\":9,\"imgUrl\":\"2018-07-11/6f71a6a1-d422-40a1-b52f-2528073a4a4e.jpg\",\"name\":\"方糕\",\"note\":\"不错的选择！！\",\"status\":1,\"typeId\":12,\"typeTitle\":\"方糕\",\"updateTime\":\"2018-07-11\",\"updater\":\"admin\"}]',0,1,'admin','2018-07-11',1,'河北省石家庄市长安区建研院');

/*Table structure for table `bra_agn_typ` */

DROP TABLE IF EXISTS `bra_agn_typ`;

CREATE TABLE `bra_agn_typ` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '名称',
  `status` int(11) DEFAULT NULL COMMENT '状态 0 删除 1品牌 2 代理商',
  `pid` int(11) DEFAULT NULL COMMENT '父id 默认0',
  `creater` varchar(30) DEFAULT NULL COMMENT '创建者',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(30) DEFAULT NULL COMMENT '更新者',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `bra_agn_typ` */

insert  into `bra_agn_typ`(`id`,`name`,`status`,`pid`,`creater`,`create_time`,`updater`,`update_time`) values (1,'伊利',1,NULL,'admin','2018-07-09',NULL,NULL),(2,'小神童',3,NULL,'admin','2018-07-09',NULL,NULL),(3,'伊利代理商',2,NULL,'admin','2018-07-09',NULL,NULL),(4,'蒙牛',1,NULL,'admin','2018-07-09',NULL,NULL),(5,'绿色心情',3,NULL,'admin','2018-07-09',NULL,NULL),(6,'苦咖啡',3,NULL,'admin','2018-07-09',NULL,NULL),(7,'老冰棍',3,NULL,'admin','2018-07-09',NULL,NULL),(8,'蒙牛代理商',2,NULL,'admin','2018-07-10',NULL,NULL),(9,'哈根达斯代理商',2,NULL,'admin','2018-07-10',NULL,NULL),(10,'巧乐兹',3,NULL,'admin','2018-07-10',NULL,NULL),(11,'雪莲',3,NULL,'admin','2018-07-10',NULL,NULL),(12,'方糕',3,NULL,'admin','2018-07-10',NULL,NULL),(13,'冰工厂',3,NULL,'admin','2018-07-10',NULL,NULL),(14,'冰力十足',3,NULL,'admin','2018-07-10',NULL,NULL),(15,'棒棒冰',3,NULL,'admin','2018-07-10',NULL,NULL),(16,'小布丁',3,NULL,'admin','2018-07-10',NULL,NULL),(17,'HenDaS',0,NULL,'admin','2018-07-11','admin','2018-07-11');

/*Table structure for table `catelog` */

DROP TABLE IF EXISTS `catelog`;

CREATE TABLE `catelog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '分类名',
  `number` int(11) DEFAULT '0' COMMENT '该分类下的商品数量',
  `status` tinyint(10) DEFAULT '0' COMMENT '分类状态，0正常，1暂用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `catelog` */

insert  into `catelog`(`id`,`name`,`number`,`status`) values (1,'闲置数码',14,1),(2,'校园代步',4,1),(3,'电器日用',6,1),(4,'图书教材',7,1),(5,'美妆衣物',11,1),(6,'运动棋牌',5,1),(7,'票券小物',5,1);

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户，外键',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品，外键',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `create_at` varchar(250) DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

/*Data for the table `comments` */

insert  into `comments`(`id`,`user_id`,`goods_id`,`content`,`create_at`) values (120,8,97,'厉害厉害~','2020-02-27 04:36:10'),(121,3,77,'1212','2020-02-27 12:02:27'),(122,6,90,'111','2020-02-27 11:37:45'),(123,23,103,'喜欢排球','2020-02-27 10:05:36'),(124,23,20,'不知道用了多久了','2020-02-27 01:11:46'),(125,23,110,'自己看过，很不错的一本书 。','2020-02-2701:12:21'),(126,23,107,'HHH','2020-02-27 02:49:59'),(127,26,5,'很好的','2020-02-27 03:55:34'),(128,26,2,'很好的车子','2020-02-27 04:16:06'),(129,27,114,'我捡到的，速度联系我vvvv','2020-02-27 04:07:18'),(130,30,79,'这个手机可能是我丢的','2020-02-28 08:55:15'),(131,32,78,'这个计算器可能是我丢的','2020-02-28 11:36:13'),(132,28,78,'这个计算器可能是我丢的','2020-02-28 11:45:47');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(30) DEFAULT NULL COMMENT '电话',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `creater` varchar(30) DEFAULT NULL COMMENT '创建者',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(30) DEFAULT NULL COMMENT '更新者',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  `status` int(11) DEFAULT NULL COMMENT '状态0 删除 1个人 2商家',
  `login_id` varchar(20) DEFAULT NULL COMMENT '登录名',
  `login_password` varchar(300) DEFAULT NULL COMMENT '登录密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`id`,`name`,`phone`,`address`,`creater`,`create_time`,`updater`,`update_time`,`status`,`login_id`,`login_password`) values (1,'何胜美','15833655291','河北省石家庄市长安区建研院',NULL,NULL,'admin','2018-07-11',1,'admin','e10adc3949ba59abbe56e057f20f883e'),(21,'王琦','18965632546','河北石家庄裕华区珠峰大街','admin','2018-07-10',NULL,NULL,2,'admin2','e10adc3949ba59abbe56e057f20f883e'),(22,'郑子琦','18656425641','河北省桥西区','admin','2018-07-10',NULL,NULL,1,'admin3','e10adc3949ba59abbe56e057f20f883e'),(23,'王志','15642546976','河北省衡水市桃城区','admin','2018-07-10',NULL,NULL,2,'admin4','e10adc3949ba59abbe56e057f20f883e'),(24,'王超','15684697531','河北省邢台市宁晋县','admin','2018-07-10',NULL,NULL,1,'admin5','e10adc3949ba59abbe56e057f20f883e'),(25,'王凯','15684975637','河北省衡水市景县','admin','2018-07-10',NULL,NULL,1,'admin6','e10adc3949ba59abbe56e057f20f883e'),(26,'李凯','13189456321','北京市海淀区108号','admin','2018-07-10',NULL,NULL,2,'admin7','e10adc3949ba59abbe56e057f20f883e'),(27,'李东','13265475234','天津市西青区100号','admin','2018-07-10',NULL,NULL,1,'admin8','e10adc3949ba59abbe56e057f20f883e'),(28,'赵雷','15396542345','河北省承德市市区','admin','2018-07-10',NULL,NULL,2,'admin9','e10adc3949ba59abbe56e057f20f883e'),(29,'赵凯','15364231567','河北省石家庄市长安区','admin','2018-07-10','admin','2018-07-11',0,'admin10','e10adc3949ba59abbe56e057f20f883e'),(30,'张鹏','15634261436','河北省石家庄市桥西区','admin','2018-07-10','admin','2018-07-11',0,'admin11','e10adc3949ba59abbe56e057f20f883e'),(31,'无二','15833655292','河北省石家庄2','admin','2018-07-11','admin','2018-07-11',1,'admin12','e10adc3949ba59abbe56e057f20f883e'),(32,'CZWxKkdeHOWJ','15833655291','This is  Addressed',NULL,NULL,NULL,NULL,1,'admin66','e10adc3949ba59abbe56e057f20f883e'),(33,'9q8hgJjZ2PU4','15631163878','Beijing',NULL,NULL,NULL,NULL,1,'aa','c20ad4d76fe97759aa27a0c99bff6710');

/*Table structure for table `focus` */

DROP TABLE IF EXISTS `focus`;

CREATE TABLE `focus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL COMMENT '外键 商品id',
  `user_id` int(11) DEFAULT NULL COMMENT '外键 用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `focus` */

insert  into `focus`(`id`,`goods_id`,`user_id`) values (1,77,5),(4,94,4),(5,94,4),(6,94,4),(8,90,9),(9,90,22),(18,5,23),(19,85,23),(20,17,26),(21,5,10),(22,3,27),(23,5,27),(25,79,30),(27,78,32);

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品主键',
  `catelog_id` int(11) DEFAULT NULL COMMENT '商品分类，外键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户外键',
  `name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `price` varchar(50) DEFAULT NULL COMMENT '出售价格',
  `real_price` varchar(50) DEFAULT NULL COMMENT '真实价格',
  `start_time` varchar(25) DEFAULT NULL COMMENT '发布时间',
  `polish_time` varchar(30) DEFAULT NULL COMMENT '擦亮时间，按该时间进行查询，精确到时分秒',
  `end_time` varchar(25) DEFAULT NULL COMMENT '下架时间',
  `describle` text COMMENT '详细信息',
  `status` int(11) DEFAULT '1' COMMENT '状态 上架1 下架0',
  PRIMARY KEY (`id`),
  KEY `catelog_id` (`catelog_id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`catelog_id`,`user_id`,`name`,`price`,`real_price`,`start_time`,`polish_time`,`end_time`,`describle`,`status`) values (3,3,1,'图书馆捡到鼠标一个','图书馆','图书馆3楼大厅','2020-01-21','2020-02-21','2020-03-21','图书馆捡到鼠标一个',1),(16,6,2,'篮球场捡到耐克运动书包','篮球场','篮球场','2020-01-21','2020-02-21','2020-03-21','篮球场捡到运动包',1),(17,4,2,'一餐食堂捡到小说','一餐3楼','一餐3楼','2020-01-21','2020-02-21','2020-03-21','一餐三楼 米线前捡到的',1),(18,4,2,'C教室捡到公务员考试资料','C教306','C教306','2020-01-21','2020-02-21','2020-03-21','C教 捡到公务员的复习资料。联系我。',1),(78,1,3,'一餐食堂捡到计算器。','一餐','一餐2楼','2020-01-21','2020-02-21','2020-03-21','在食堂餐桌上拾取。',1),(79,1,3,'操场捡到HTC','枫雨操场','枫雨操场','2020-01-21','2020-02-21','2020-03-21','枫雨操场捡到手机 失主请联系！！！！',1),(93,5,10,'图书馆捡到帽子','图书馆','图书馆3楼大厅','2020-01-21','2020-02-21','2020-03-21','帽子 失主请联系',1),(108,5,23,'B教捡到太阳镜','B教321','B教321','2020-01-21','2020-02-21','2020-03-21','B教 321 捡到太阳镜 丢失的同学请联系',1),(117,1,28,'捡到手机','操场','西操场','2020-02-29','2020-02-29','2020-03-10','捡的',1);

/*Table structure for table `image` */

DROP TABLE IF EXISTS `image`;

CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片主键',
  `goods_id` int(11) NOT NULL COMMENT '商品外键',
  `img_url` text NOT NULL COMMENT '图片链接',
  PRIMARY KEY (`id`),
  KEY `goods_id` (`goods_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;

/*Data for the table `image` */

insert  into `image`(`id`,`goods_id`,`img_url`) values (1,1,'nopic1.png'),(2,2,'nopic2.png'),(3,3,'nopic3.png'),(4,4,'nopic4.png'),(5,5,'nopic5.png'),(6,6,'nopic6.png'),(7,7,'nopic7.png'),(8,8,'nopic8.png'),(9,9,'nopic9.png'),(11,11,'nopic11.png'),(12,12,'nopic12.png'),(13,13,'nopic13.png'),(16,16,'nopic16.png'),(17,17,'nopic17.png'),(18,18,'nopic18.png'),(20,20,'nopic20.png'),(21,77,'4f320b75-427a-484e-b725-a2f5d066af6f.jpg'),(78,78,'599629aa-9440-435c-8185-42e34a862470.jpg'),(79,79,'266abea1-a202-47f2-b5c4-095e96c10473.jpg'),(80,80,'4d472617-d430-4540-a510-f7606861dde0.jpg'),(81,81,'e62acc43-8122-421a-940b-a68e6aeadd30.jpg'),(82,82,'67a5f2ee-a09a-488d-9e7a-87ac6d8ab9c4.jpg'),(83,83,'110456d4-cc20-4fe2-b0a6-217b023d7dd6.jpg'),(84,84,'499afa59-53bc-4d23-99ef-5d0f9d60de69.jpg'),(85,85,'23f242e3-6dbf-4d46-a1b2-a620918908d9.jpg'),(86,86,'ae1097a5-736d-4850-9552-b5901ad6d84b.jpg'),(87,87,'95daa308-8011-4e0c-b5bd-8cd151830c32.jpg'),(88,88,'5c212d57-d8a4-4cc0-8853-dba957fba3d5.jpg'),(89,89,'ec5369f6-7c87-43db-98aa-112efa91c8c6.JPG'),(90,90,'fd680315-9ac8-4268-803e-7da7b492e8b0.JPG'),(91,91,'455e9ee5-92a7-4c7c-aa94-55f4373a16ee.JPG'),(92,92,'33434fa2-8bf3-4fbc-b1d9-d1e67202e2f2.jpg'),(93,93,'dc4f9591-bd1a-4eac-b1ea-be6412296fb6.png'),(94,94,'7eb89aaa-56c0-4283-893f-bd5718301d80.jpg'),(95,95,'6664b320-87d4-4d37-b14f-fc5dba41f529.PNG'),(96,96,'451c3aa2-529d-449d-b69f-b8771af1d806.jpg'),(97,97,'ee6e735c-6479-40bb-b45f-69888c42862e.jpg'),(98,98,'2f92136b-af5b-45f4-902d-7bb1d0ad0809.png'),(99,99,'022fe88a-5328-4b42-8333-10b782d39373.png'),(100,100,'a1f11b39-490b-42ef-a8e1-44285c4a80d4.png'),(101,101,'0f022547-b2cb-45fe-ab86-fb8b6d70adbc.jpg'),(102,102,''),(103,103,'b0933eb3-1ccb-43e1-80a4-1d50902916db.jpg'),(104,104,''),(105,105,'504d47df-32b0-4195-b63c-10d1562896cc.jpg'),(106,106,'a634ca2b-70cc-404d-95cb-fc4166fe6706.jpg'),(107,107,'1ba8f318-fbf3-42f6-b8d9-0baa7e678cec.jpg'),(108,108,'afd57674-338c-414f-98ae-78e0d25b12f8.jpg'),(109,109,'330a9a46-6434-4d04-a72b-a91a14035229.jpg'),(110,110,'0583cb1e-6acd-46da-bebc-4a9f1d6c3ac7.jpg'),(111,111,'ce18c0f4-dc10-454e-9791-e1992164a384.jpg'),(112,112,'854dff80-d049-4381-ae40-d1d23cd0e88b.jpg'),(113,113,'ec782f3f-78f5-481d-99de-067968974291.jpg'),(114,114,'b5c42ee8-3319-4f9a-89f3-43e3559a0e23.jpg'),(115,115,'8b67bfff-1d19-4515-9162-d79253e81193.jpg'),(116,116,'901dfde3-aee9-481f-a4d9-14178be80633.jpg'),(117,115,'0cc98e07-f121-4d91-8048-bdb104ec7e0e.jpg'),(118,116,'013844c9-b6aa-4a6d-a99a-d1e42ddd10d0.jpg'),(119,117,'3617b242-e506-4ed5-95cb-94421db90f66.jpg');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统信息主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户，外键',
  `context` text COMMENT '信息内容',
  `create_at` varchar(25) DEFAULT NULL COMMENT '推送信息时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态，0未读，1已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`id`,`user_id`,`context`,`create_at`,`status`) values (1,1,'今天音乐厅有活动','2020-02-25 04:36:10',0),(2,3,'明问下，明天有创业指导会嘛','2020-02-25 04:36:10',0),(3,11,'17栋楼下有捡到水卡的嘛?','2020-02-25 05:36:10',0),(4,21,'今天篮球场有活动','2020-02-25 10:49:55',1),(5,12,'问下同学们 知道什么时候开始春招嘛','2020-02-25 10:50:17',1),(6,2,'急急急!丢失手机 捡到请联系111111','2020-02-25 10:50:29',0),(7,2,'今天食堂有活动','2020-02-25 10:50:40',0),(8,2,'门口超市有促销','2020-02-2510:50:54',0),(9,3,'今天谁在1餐捡到饭卡了请联系11111','2020-02-25 17:10:40',NULL),(10,6,'没同学在操场捡到一个运动包嘛','2020-02-25 17:52:31',0),(11,6,'有没有在A402捡到考研资料的 私聊','2020-02-2518:02:24',0),(12,8,'大家好！！','2020-02-25 18:05:31',0),(13,8,'啦啦啦啦','2020-02-25 18:05:40',0),(14,8,'学校什么时候有晚会','2020-02-25 18:06:04',0),(15,23,'有同学在食堂捡到一串钥匙嘛 联系方式1310000','2020-02-25 17:15:37',0),(16,23,'捡到一个饭卡','2020-02-25 23:25:55',0),(17,23,'哈哈','2020-02-25 23:29:49',0),(18,26,'我捡到一部老年手机，有的联系我，QQ2118119173','2020-02-25 15:55:08',0),(19,30,'今天在A教丢失一部手机 捡到的同学请联系','2020-02-28 20:57:18',0),(20,32,'留言！！！','2020-02-28 23:37:35',0),(21,28,'l留言！！！','2020-02-28 23:48:07',0);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单表id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `goods_id` int(11) NOT NULL COMMENT '商品id',
  `order_num` bigint(25) DEFAULT NULL COMMENT '订单编号',
  `order_price` varchar(50) DEFAULT NULL COMMENT '订单价格',
  `order_state` int(11) DEFAULT '1' COMMENT '订单状态 1待发货 2待收货 3已完成',
  `order_information` varchar(50) DEFAULT NULL,
  `order_date` varchar(50) DEFAULT NULL COMMENT '下单时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

/*Table structure for table `purse` */

DROP TABLE IF EXISTS `purse`;

CREATE TABLE `purse` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '钱包id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `balance` float(11,0) unsigned zerofill DEFAULT '00000000000' COMMENT '总钱数',
  `recharge` float(11,0) DEFAULT NULL COMMENT '充值钱数',
  `withdrawals` float(11,0) DEFAULT NULL COMMENT '提现钱数',
  `state` int(11) DEFAULT NULL COMMENT '状态 0未审核   已审核（1不通过 2通过）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `purse` */

insert  into `purse`(`id`,`user_id`,`balance`,`recharge`,`withdrawals`,`state`) values (1,1,NULL,NULL,NULL,2),(2,2,00000002798,NULL,NULL,NULL),(3,3,NULL,NULL,NULL,2),(4,4,00000007745,NULL,NULL,NULL),(5,5,00000000052,NULL,NULL,NULL),(6,11,00000001005,NULL,NULL,NULL),(13,18,00000000000,NULL,NULL,NULL),(14,19,00000000000,NULL,NULL,NULL),(15,20,00000000000,NULL,NULL,NULL),(16,21,00000001000,NULL,NULL,2),(17,22,00000000500,NULL,NULL,2),(18,23,00000001131,NULL,NULL,NULL),(19,24,00000000000,NULL,NULL,NULL),(20,25,00000000000,NULL,NULL,NULL),(21,26,00000999480,NULL,NULL,2);

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论回复主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户，外键',
  `atuser_id` int(11) DEFAULT NULL,
  `commet_id` int(11) DEFAULT NULL COMMENT '评论，外键',
  `content` text COMMENT '回复内容',
  `create_at` varchar(25) DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reply` */

/*Table structure for table `shopping_car` */

DROP TABLE IF EXISTS `shopping_car`;

CREATE TABLE `shopping_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` varchar(200) DEFAULT NULL COMMENT '用户主键',
  `goods_id` varchar(500) DEFAULT NULL COMMENT '商品id',
  `discount` double DEFAULT NULL COMMENT '折扣',
  `goods_name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `status` int(11) DEFAULT NULL COMMENT '状态0删除 1正常',
  `branch_total` int(11) DEFAULT NULL COMMENT '支总数量',
  `transaction` double DEFAULT NULL COMMENT '交易金额',
  `goods_url` varchar(200) DEFAULT NULL COMMENT '商品照片',
  `goods_branch_price` double DEFAULT NULL COMMENT '商品支单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `shopping_car` */

insert  into `shopping_car`(`id`,`customer_id`,`goods_id`,`discount`,`goods_name`,`status`,`branch_total`,`transaction`,`goods_url`,`goods_branch_price`) values (20,'admin','{\"boxBidPrice\":50.0,\"boxCount\":7,\"boxPrice\":75.0,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":2.0,\"branchCount\":463,\"branchPrice\":3.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO0158439415898655\",\"id\":9,\"imgUrl\":\"2018-07-11/6f71a6a1-d422-40a1-b52f-2528073a4a4e.jpg\",\"name\":\"方糕\",\"note\":\"不错的选择！！\",\"status\":1,\"typeId\":12,\"typeTitle\":\"方糕\",\"updateTime\":\"2018-07-11\",\"updater\":\"admin\"}',0,'方糕',0,1,75,'2018-07-11/6f71a6a1-d422-40a1-b52f-2528073a4a4e.jpg',75),(21,'admin66','{\"boxBidPrice\":50.0,\"boxCount\":16,\"boxPrice\":75.0,\"braId\":4,\"braName\":\"蒙牛\",\"branchBidPrice\":2.0,\"branchCount\":472,\"branchPrice\":3.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO8873327013029820\",\"id\":7,\"imgUrl\":\"2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg\",\"name\":\"小布丁\",\"note\":\"每一口都是爱的味道\",\"status\":1,\"typeId\":16,\"typeTitle\":\"小布丁\"}',0,'小布丁',0,6,75,'2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg',75),(22,'admin66','{\"boxBidPrice\":50.0,\"boxCount\":16,\"boxPrice\":75.0,\"braId\":4,\"braName\":\"蒙牛\",\"branchBidPrice\":2.0,\"branchCount\":472,\"branchPrice\":3.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO8873327013029820\",\"id\":7,\"imgUrl\":\"2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg\",\"name\":\"小布丁\",\"note\":\"每一口都是爱的味道\",\"status\":1,\"typeId\":16,\"typeTitle\":\"小布丁\"}',0,'小布丁',0,6,225,'2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg',75),(23,'admin66','{\"boxBidPrice\":50.0,\"boxCount\":16,\"boxPrice\":75.0,\"braId\":4,\"braName\":\"蒙牛\",\"branchBidPrice\":2.0,\"branchCount\":472,\"branchPrice\":3.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO8873327013029820\",\"id\":7,\"imgUrl\":\"2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg\",\"name\":\"小布丁\",\"note\":\"每一口都是爱的味道\",\"status\":1,\"typeId\":16,\"typeTitle\":\"小布丁\"}',0,'小布丁',0,1,75,'2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg',75),(24,'admin66','{\"boxBidPrice\":50.0,\"boxCount\":17,\"boxPrice\":75.0,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":2.0,\"branchCount\":449,\"branchPrice\":3.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO4326026890640740\",\"id\":8,\"imgUrl\":\"2018-07-10/258e789f-2c41-45b4-99d1-823411b5a53e.jpg\",\"name\":\"雪莲\",\"note\":\"雪的味道我知道\",\"status\":1,\"typeId\":11,\"typeTitle\":\"雪莲\"}',0,'雪莲',1,1,75,'2018-07-10/258e789f-2c41-45b4-99d1-823411b5a53e.jpg',75),(25,'admin66','{\"boxBidPrice\":50.0,\"boxCount\":9,\"boxPrice\":75.0,\"braId\":4,\"braName\":\"蒙牛\",\"branchBidPrice\":2.0,\"branchCount\":472,\"branchPrice\":3.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO8873327013029820\",\"id\":7,\"imgUrl\":\"2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg\",\"name\":\"小布丁\",\"note\":\"每一口都是爱的味道\",\"status\":1,\"typeId\":16,\"typeTitle\":\"小布丁\"}',0,'小布丁',1,1,75,'2018-07-10/bada6a88-ba9b-4122-b811-d534b177e568.jpg',75),(26,'admin','{\"boxBidPrice\":50.0,\"boxCount\":6,\"boxPrice\":75.0,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":2.0,\"branchCount\":463,\"branchPrice\":3.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":0,\"goodsCode\":\"GO0158439415898655\",\"id\":9,\"imgUrl\":\"2018-07-11/6f71a6a1-d422-40a1-b52f-2528073a4a4e.jpg\",\"name\":\"方糕\",\"note\":\"不错的选择！！\",\"status\":1,\"typeId\":12,\"typeTitle\":\"方糕\",\"updateTime\":\"2018-07-11\",\"updater\":\"admin\"}',0,'方糕',0,1,75,'2018-07-11/6f71a6a1-d422-40a1-b52f-2528073a4a4e.jpg',75),(27,'admin','{\"boxBidPrice\":0.0,\"boxCount\":1,\"boxPrice\":10.0,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":0.0,\"branchCount\":10,\"branchPrice\":8.0,\"createTime\":\"2018-07-11\",\"creater\":\"admin\",\"eachBoxNum\":1,\"goodsCode\":\"GO8881245452377146\",\"id\":17,\"imgUrl\":\"2018-07-11/6fea1187-9552-4ecb-8932-3ecf7cdc3103.jpg\",\"name\":\"老冰柜111\",\"note\":\"老师好\",\"status\":1,\"typeId\":2,\"typeTitle\":\"小神童\"}',0,'老冰柜111',0,1,10,'2018-07-11/6fea1187-9552-4ecb-8932-3ecf7cdc3103.jpg',10),(28,'admin','{\"boxBidPrice\":0.0,\"boxCount\":1,\"boxPrice\":10.0,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":0.0,\"branchCount\":10,\"branchPrice\":8.0,\"createTime\":\"2018-07-11\",\"creater\":\"admin\",\"eachBoxNum\":1,\"goodsCode\":\"GO8881245452377146\",\"id\":17,\"imgUrl\":\"2018-07-11/6fea1187-9552-4ecb-8932-3ecf7cdc3103.jpg\",\"name\":\"老冰柜111\",\"note\":\"老师好\",\"status\":1,\"typeId\":2,\"typeTitle\":\"小神童\"}',0,'老冰柜111',0,1,10,'2018-07-11/6fea1187-9552-4ecb-8932-3ecf7cdc3103.jpg',10),(29,'admin','{\"boxBidPrice\":0.0,\"boxCount\":121,\"boxPrice\":12.0,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":0.0,\"branchCount\":12,\"branchPrice\":12.0,\"createTime\":\"2018-07-11\",\"creater\":\"admin\",\"eachBoxNum\":12,\"goodsCode\":\"GO3526874823391147\",\"id\":18,\"imgUrl\":\"2018-07-11/e5138234-04c3-4a35-ab48-36df83589b02.jpeg\",\"name\":\"西天天\",\"note\":\"不错的\",\"status\":1,\"typeId\":11,\"typeTitle\":\"雪莲\"}',0,'西天天',0,1,12,'2018-07-11/e5138234-04c3-4a35-ab48-36df83589b02.jpeg',12),(30,'admin','{\"boxBidPrice\":50.0,\"boxCount\":5,\"boxPrice\":75.0,\"braId\":1,\"braName\":\"伊利\",\"branchBidPrice\":2.0,\"branchCount\":463,\"branchPrice\":3.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":1,\"goodsCode\":\"GO0158439415898655\",\"id\":9,\"imgUrl\":\"2018-07-11/6f71a6a1-d422-40a1-b52f-2528073a4a4e.jpg\",\"name\":\"方糕\",\"note\":\"不错的选择！！\",\"status\":1,\"typeId\":12,\"typeTitle\":\"方糕\",\"updateTime\":\"2018-07-11\",\"updater\":\"admin\"}',0,'方糕',0,1,75,'2018-07-11/6f71a6a1-d422-40a1-b52f-2528073a4a4e.jpg',75),(31,'admin','{\"boxBidPrice\":0.0,\"boxCount\":1,\"boxPrice\":10.0,\"braId\":4,\"braName\":\"蒙牛\",\"branchBidPrice\":0.0,\"branchCount\":10,\"branchPrice\":1.0,\"createTime\":\"2018-07-10\",\"creater\":\"admin\",\"eachBoxNum\":1,\"goodsCode\":\"GO8640571214741185\",\"id\":10,\"imgUrl\":\"2018-07-11/efb39689-b09b-4bb5-ac10-80923e13b8cd.jpg\",\"name\":\"冰工厂\",\"note\":\"不错的选择！！\",\"status\":1,\"typeId\":13,\"typeTitle\":\"冰工厂\",\"updateTime\":\"2018-07-11\",\"updater\":\"admin\"}',0,'冰工厂',1,1,10,'2018-07-11/efb39689-b09b-4bb5-ac10-80923e13b8cd.jpg',10);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '真实姓名',
  `login_password` varchar(300) DEFAULT NULL COMMENT '密码',
  `phone` varchar(30) DEFAULT NULL COMMENT '电话',
  `status` int(11) DEFAULT NULL COMMENT '状态 0 删除 1、老板 2销售员 3送货员  老板不能删除',
  `creater` varchar(30) DEFAULT NULL COMMENT '创建者',
  `create_time` varchar(30) DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(30) DEFAULT NULL COMMENT '更新者',
  `update_time` varchar(30) DEFAULT NULL COMMENT '更新时间',
  `login_id` varchar(20) DEFAULT NULL COMMENT '登录名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`name`,`login_password`,`phone`,`status`,`creater`,`create_time`,`updater`,`update_time`,`login_id`) values (1,'admin','21232f297a57a5a743894a0e4a801fc3','15833655291',1,'admin','2018-07-10','admin','2018-07-11','admin'),(16,'张政','e10adc3949ba59abbe56e057f20f883e',NULL,2,'admin','2018-07-10',NULL,NULL,'admin2'),(17,'章琦','e10adc3949ba59abbe56e057f20f883e',NULL,3,'admin','2018-07-10',NULL,NULL,'admin3'),(18,'张无','21232f297a57a5a743894a0e4a801fc3',NULL,0,'admin','2018-07-11','admin','2018-07-11','zdpBuillder'),(19,'zdo','e10adc3949ba59abbe56e057f20f883e',NULL,0,'admin','2018-07-11','admin','2018-07-11','admin4');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` char(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '登录使用的手机号',
  `username` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户名',
  `password` char(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '密码',
  `QQ` varchar(12) CHARACTER SET utf8 DEFAULT NULL COMMENT '即时通讯',
  `create_at` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建时间',
  `goods_num` int(11) DEFAULT '0' COMMENT '发布过的物品数量',
  `power` int(10) unsigned zerofill DEFAULT '0000000100' COMMENT '信用分，普通用户默认为100',
  `last_login` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '最近一次登陆时间',
  `status` tinyint(4) DEFAULT '0' COMMENT '账号是否冻结，默认0未冻结',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`phone`,`username`,`password`,`QQ`,`create_at`,`goods_num`,`power`,`last_login`,`status`) values (1,'17862821996','lduldj','C4CA4238A0B923820DCC509A6F75849B','421330323','2020-02-25 02:20',2,0000000100,NULL,1),(2,'15552201622','hly','C4CA4238A0B923820DCC509A6F75849B','782697347','2020-02-25 02:18',2,0000000100,NULL,1),(3,'15880330000','靓仔','C4CA4238A0B923820DCC509A6F75849B','1256972301','2020-02-25 02:19',2,0000000100,NULL,1),(4,'15880331111','user1','C4CA4238A0B923820DCC509A6F75849B','554625458','2020-02-25 02:22',2,0000000100,'',1),(5,'15880332222','user2','C4CA4238A0B923820DCC509A6F75849B','1025656543','2020-02-25 02:34',1,0000000100,NULL,1),(6,'15880333333','秦新敏','C4CA4238A0B923820DCC509A6F75849B','356456456','2020-02-25 02:23',1,0000000100,NULL,1),(7,'15880334444','user4','C4CA4238A0B923820DCC509A6F75849B','245534351','2020-02-25 02:34',3,0000000100,NULL,1),(8,'15880335555','user5','C4CA4238A0B923820DCC509A6F75849B','3145654664','2020-02-25 02:39',1,0000000100,NULL,1),(9,'15880336666','user6','C4CA4238A0B923820DCC509A6F75849B','554625458','2020-02-25 02:15',2,0000000100,NULL,1),(10,'15880337777','user7','C4CA4238A0B923820DCC509A6F75849B','95785588','2020-02-25 02:15',5,0000000100,NULL,1),(11,'15859512853','parent','E10ADC3949BA59ABBE56E057F20F883E','','2020-02-25 02:10',1,0000000100,NULL,1),(12,'15880338888','15880338888','C4CA4238A0B923820DCC509A6F75849B','2564645456','2020-02-25 02:20',1,0000000100,NULL,1),(13,'15880330001','15880330001','C4CA4238A0B923820DCC509A6F75849B',NULL,'2020-02-25 02:17',2,0000000100,NULL,1),(14,'15880330002','15880330002','C4CA4238A0B923820DCC509A6F75849B',NULL,'2020-02-23 02:16',0,0000000100,NULL,1),(15,'15880330003','fdas','D41D8CD98F00B204E9800998ECF8427E',NULL,'2020-02-25 02:15',0,0000000100,NULL,1),(16,'12345654654','1','C4CA4238A0B923820DCC509A6F75849B',NULL,'2020-02-25 02:14',0,0000000100,NULL,1),(17,'15880335556','66','657DDF7370B0D5EFF54A335127A66282',NULL,'2020-02-25 02:11',0,0000000100,NULL,1),(18,'15555555555','58','5B1B68A9ABF4D2CD155C81A9225FD158',NULL,'2020-02-25 02:10',0,0000000100,NULL,1),(19,'15353535355','1','C4CA4238A0B923820DCC509A6F75849B',NULL,'2020-02-25 02:13',0,0000000100,NULL,1),(20,'15880330005','123','C4CA4238A0B923820DCC509A6F75849B','156454654','2020-02-25 02:13',0,0000000100,NULL,1),(21,'15880336667','1545654','C4CA4238A0B923820DCC509A6F75849B',NULL,'2020-02-25 02:14',0,0000000100,NULL,1),(22,'17862821556','gmd','4E167A9B62FA9E9E06877D256890B760',NULL,'2020-02-25 02:15',1,0000000100,NULL,1),(23,'17853593223','小丽','202CB962AC59075B964B07152D234B70','357598890','2020-02-25 02:15',7,0000000100,NULL,1),(24,'17862821818','sik','96E79218965EB72C92A549DD5A330112',NULL,'2020-02-25 02:14',0,0000000100,NULL,1),(25,'18380665444','test','202CB962AC59075B964B07152D234B70',NULL,'2020-02-23 02:15',0,0000000100,NULL,1),(27,'18380664444','测试123','202CB962AC59075B964B07152D234B70','2118119173','2020-02-23 16:00',1,0000000100,NULL,1),(28,'13123456789','测试222','202CB962AC59075B964B07152D234B70',NULL,'2020-02-22 14:52',2,0000000100,NULL,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
