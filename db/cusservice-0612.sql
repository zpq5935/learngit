/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : cusservice

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-06-12 12:36:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for css
-- ----------------------------
DROP TABLE IF EXISTS `css`;
CREATE TABLE `css` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Account` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Qq` char(20) DEFAULT NULL,
  `Email` char(30) DEFAULT NULL,
  `Mobile` char(11) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `isDeleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Account` (`Account`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of css
-- ----------------------------
INSERT INTO `css` VALUES ('1', 'css01', '123456', '227743334296', '2277487796@qq.com', '13570459811', '客服小章', '\0');
INSERT INTO `css` VALUES ('2', 'cusService2', '123456', 'cusService2_qq', '客服2_emial', '13570459822', '客服小2', '\0');
INSERT INTO `css` VALUES ('3', 'cusService3', '123456', 'cusService3_qq', '客服3_emial', '13570459833', '客服3', '\0');
INSERT INTO `css` VALUES ('4', 'cusService4', '123456', 'cusService4_qq', '客服4_emial', '13570459844', '客服4', '\0');
INSERT INTO `css` VALUES ('5', 'cusService5', '123456', 'cusService5_qq', '客服5_emial', '13570459855', '客服5', '\0');
INSERT INTO `css` VALUES ('6', 'cusService6', '123456', 'cusService6_qq', '客服6_emial', '13570459866', '客服6', '\0');
INSERT INTO `css` VALUES ('7', 'cusService7', '123456', 'cusService7_qq', '客服7_emial', '13570459877', '客服7', '\0');
INSERT INTO `css` VALUES ('8', 'cusService8', '123456', 'cusService8_qq', '客服8_emial', '13570459888', '客服8', '\0');
INSERT INTO `css` VALUES ('9', 'cusService9', '123456', 'cusService9_qq', '客服9_emial', '13570459899', '客服9', '\0');
INSERT INTO `css` VALUES ('10', 'cusService10', '123456', 'cusService10_qq', '客服10_emial', '16319151010', '客服10', '\0');
INSERT INTO `css` VALUES ('11', 'cusService11', '123456', 'cusService11_qq', '客服11_emial', '16319151111', '客服11', '\0');
INSERT INTO `css` VALUES ('12', 'cusService12', '123456', 'cusService12_qq', '客服12_emial', '16319151212', '客服12', '\0');
INSERT INTO `css` VALUES ('13', 'cusService13', '123456', 'cusService13_qq', '客服13_emial', '16319151313', '客服13', '');
INSERT INTO `css` VALUES ('14', 'cusService14', '123456', 'cusService14_qq', '客服14_emial', '16319151414', '客服14', '\0');
INSERT INTO `css` VALUES ('15', 'cusService15', '123456', 'cusService15_qq', '客服15_emial', '16319151515', '客服15', '\0');
INSERT INTO `css` VALUES ('16', 'cusService16', '123456', 'cusService16_qq', '客服16_emial', '16319151616', '客服16', '\0');
INSERT INTO `css` VALUES ('17', 'cusService17', '123456', 'cusService17_qq', '客服17_emial', '16319151717', '客服17', '\0');
INSERT INTO `css` VALUES ('18', 'cusService18', '123456', 'cusService18_qq', '客服18_emial', '16319151818', '客服18', '\0');
INSERT INTO `css` VALUES ('19', 'cusService19', '123456', 'cusService19_qq', '客服19_emial', '16319151919', '客服19', '\0');
INSERT INTO `css` VALUES ('20', '服务小李', '123456', null, null, '2347814', '25678', '\0');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `Qq` char(20) DEFAULT NULL,
  `Email` char(30) DEFAULT NULL,
  `Mobile` char(11) NOT NULL,
  `Nickname` varchar(20) NOT NULL,
  `oneLevel_address` varchar(20) NOT NULL,
  `detailed_address` varchar(256) NOT NULL,
  `isDeleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('15', 'customer01', '123456', '23416897814', 'customer15emial@163.com', '18669451313', '我是客户哦', '江西省', '煌固镇', '\0');
INSERT INTO `customer` VALUES ('19', 'customer19', '123456', 'customer19_qq', 'customer19emial', '18669451717', '客户-傻明', '江苏省', '19区19街19号', '\0');
INSERT INTO `customer` VALUES ('20', 'customer20', '123456', 'customer20_qq', 'customer20emial', '18669451717', '客户-李四', '广西壮族自治区', '20区20街20号', '\0');
INSERT INTO `customer` VALUES ('24', 'customer24', '123456', 'customer24_qq', 'customer24emial', '18669452121', '客户24', '广西壮族自治区', '24区24街24号', '\0');
INSERT INTO `customer` VALUES ('28', 'customer28', '123456', 'customer28_qq', 'customer28emial', '18669452525', '客户28', '广西壮族自治区', '28区28街28号', '\0');
INSERT INTO `customer` VALUES ('30', 'customer_hongkang', '123456', 'customer30_qq', 'customer30emial', '18669452929', '客户30', '香港', '30区30街30号', '\0');
INSERT INTO `customer` VALUES ('31', 'customer31', '123456', 'customer31_qq', 'customer31emial', '18669452929', '客户31', '江苏省', '31区31街31号', '\0');
INSERT INTO `customer` VALUES ('32', 'customer32', '123456', 'customer32_qq', 'customer32emial', '18669452929', '客户32', '广西壮族自治区', '32区32街32号', '\0');
INSERT INTO `customer` VALUES ('38', 'zzzzz', '3333', '', '', '666666666', 'zzzzzzzzz', '安徽省', 'zzzzzzz', '\0');
INSERT INTO `customer` VALUES ('39', '333333333333', '33333333333', '33333333333333', '', '12356892648', '我是33333333', '澳门', '欧陆居于', '\0');

-- ----------------------------
-- Table structure for mainman
-- ----------------------------
DROP TABLE IF EXISTS `mainman`;
CREATE TABLE `mainman` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Account` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Qq` char(20) DEFAULT NULL,
  `Email` char(30) DEFAULT NULL,
  `Mobile` char(11) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `isDeleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Account` (`Account`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mainman
-- ----------------------------
INSERT INTO `mainman` VALUES ('1', 'mm01', '123456', '99637841', '99637841@qq.com', '364125734', '维修路人甲', '\0');
INSERT INTO `mainman` VALUES ('2', 'mainMan1', '123456', 'mainMan1_qq', '维修1_emial', '13287459811', '维修小明', '\0');
INSERT INTO `mainman` VALUES ('3', 'mainMan2', '123456', 'mainMan2_qq', '维修2_emial', '13287459822', '维修奎', '\0');
INSERT INTO `mainman` VALUES ('4', 'mainMan3', '123456', 'mainMan3_qq', '维修3_emial', '13287459833', '维修祥', '\0');
INSERT INTO `mainman` VALUES ('5', 'mainMan4', '123456', 'mainMan4_qq', '维修4_emial', '13287459844', '维修杨', '\0');
INSERT INTO `mainman` VALUES ('6', 'mainMan5', '123456', 'mainMan5_qq', '维修5_emial', '13287459855', '维修方', '\0');
INSERT INTO `mainman` VALUES ('7', 'mainMan6', '123456', 'mainMan6_qq', '维修6_emial', '13287459866', '维修博', '\0');
INSERT INTO `mainman` VALUES ('8', 'mainMan7', '123456', 'mainMan7_qq', '维修7_emial', '13287459877', '维修人员7', '\0');
INSERT INTO `mainman` VALUES ('9', 'mainMan8', '123456', 'mainMan8_qq', '维修8_emial', '13287459888', '维修人员8', '\0');
INSERT INTO `mainman` VALUES ('10', 'mainMan9', '123456', 'mainMan9_qq', '维修9_emial', '13287459899', '维修人员9', '\0');
INSERT INTO `mainman` VALUES ('11', 'mainMan10', '123456', 'mainMan10_qq', '维修10_emial', '18657151010', '维修人员10', '\0');
INSERT INTO `mainman` VALUES ('12', 'mainMan11', '123456', 'mainMan11_qq', '维修11_emial', '18657151111', '维修人员11', '\0');
INSERT INTO `mainman` VALUES ('13', 'mainMan12', '123456', 'mainMan12_qq', '维修12_emial', '18657151212', '维修人员12', '\0');
INSERT INTO `mainman` VALUES ('14', 'mainMan13', '123456', 'mainMan13_qq', '维修13_emial', '18657151313', '维修人员13', '\0');
INSERT INTO `mainman` VALUES ('15', 'mainMan14', '123456', 'mainMan14_qq', '维修14_emial', '18657151414', '维修人员14', '\0');
INSERT INTO `mainman` VALUES ('16', 'mainMan15', '123456', 'mainMan15_qq', '维修15_emial', '18657151515', '维修人员15', '\0');
INSERT INTO `mainman` VALUES ('17', 'mainMan16', '123456', 'mainMan16_qq', '维修16_emial', '18657151616', '维修人员16', '\0');
INSERT INTO `mainman` VALUES ('18', 'mainMan17', '123456', 'mainMan17_qq', '维修17_emial', '18657151717', '维修人员17', '\0');
INSERT INTO `mainman` VALUES ('19', 'mainMan18', '123456', 'mainMan18_qq', '维修18_emial', '18657151818', '维修人员18', '\0');
INSERT INTO `mainman` VALUES ('20', 'mainMan19', '123456', 'mainMan19_qq', '维修19_emial', '18657151919', '维修人员19', '\0');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Account` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Qq` char(20) DEFAULT NULL,
  `Email` char(30) DEFAULT NULL,
  `Mobile` char(11) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `isDeleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Account` (`Account`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'zpq', '123456', '22774877895', '22448781554@qq.com', '15389451248', '王者章', '\0');
INSERT INTO `manager` VALUES ('3', 'root', '123456', '4568945', 'adas45@adas.cop', '56994512', 'Boss章', '\0');
INSERT INTO `manager` VALUES ('5', 'sa', '123456', 'sa_qq', 'sa2email@qq.com', '15632457156', '萨萨', '\0');
INSERT INTO `manager` VALUES ('6', 'admin', '123456', '562315555547', 'admin_email@163.com', '56848712496', '偶是admin', '\0');

-- ----------------------------
-- Table structure for myorder
-- ----------------------------
DROP TABLE IF EXISTS `myorder`;
CREATE TABLE `myorder` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `ProID` int(11) DEFAULT NULL,
  `CusID` int(11) DEFAULT NULL,
  `Amount` int(11) NOT NULL,
  `Datetime` datetime NOT NULL,
  `CssID` int(11) DEFAULT NULL,
  `Remark` text,
  `isDeleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`Id`),
  KEY `ProID` (`ProID`),
  KEY `CusID` (`CusID`),
  KEY `CssID` (`CssID`),
  CONSTRAINT `myorder_ibfk_1` FOREIGN KEY (`ProID`) REFERENCES `product` (`id`),
  CONSTRAINT `myorder_ibfk_2` FOREIGN KEY (`CusID`) REFERENCES `customer` (`id`),
  CONSTRAINT `myorder_ibfk_3` FOREIGN KEY (`CssID`) REFERENCES `css` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of myorder
-- ----------------------------
INSERT INTO `myorder` VALUES ('7', '20', '15', '10000', '2019-04-03 10:35:07', '19', '当前位置：订单管理 > 修改订单', '\0');
INSERT INTO `myorder` VALUES ('8', '21', '15', '44', '2018-07-21 10:35:07', '7', '日期：2019-05-21 10:35:07客户', '\0');
INSERT INTO `myorder` VALUES ('9', '20', '38', '268', '2019-01-21 10:35:07', '10', null, '\0');
INSERT INTO `myorder` VALUES ('10', '23', '15', '100', '2017-12-21 10:35:07', '7', '客户要求：产品统一包装。。。。。。', '\0');
INSERT INTO `myorder` VALUES ('11', '20', '15', '66', '2019-02-21 10:35:07', '10', '日期：2019-05-21 10:35:07客户', '\0');
INSERT INTO `myorder` VALUES ('12', '22', '32', '402', '2018-09-21 10:35:07', '1', '', '\0');
INSERT INTO `myorder` VALUES ('13', '26', '15', '12345', '2018-07-22 15:22:17', '2', '我是客服2，添加订单ADC型充电站，数量12345', '\0');
INSERT INTO `myorder` VALUES ('14', '23', '15', '2', '2017-06-22 15:25:31', '2', '', '\0');
INSERT INTO `myorder` VALUES ('15', '27', '20', '100', '2015-01-25 08:24:53', null, '', '\0');
INSERT INTO `myorder` VALUES ('16', '21', '19', '234', '2019-05-25 16:06:35', '1', '', '\0');
INSERT INTO `myorder` VALUES ('17', '27', '19', '12', '2019-05-25 16:07:04', '1', '他家烟贼多，给他多弄几台抽烟烟机', '\0');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Prodname` varchar(11) NOT NULL,
  `Para1` varchar(20) DEFAULT NULL,
  `Para2` varchar(20) DEFAULT NULL,
  `Para3` varchar(20) DEFAULT NULL,
  `Para4` varchar(20) DEFAULT NULL,
  `isDeleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Prodname` (`Prodname`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('20', 'SSS+型电水壶', '1', '100W/s', '220V', '1.2kg', '\0');
INSERT INTO `product` VALUES ('21', 'B型电冰箱', '2888', '1.7kWh/24h', '220V', '62kg', '\0');
INSERT INTO `product` VALUES ('22', 'B型空调', '3845', '1740W/s', '220V', '10.8kg', '\0');
INSERT INTO `product` VALUES ('23', 'C型电水壶', '89', '1800W/s', '220V', '1.3kg', '\0');
INSERT INTO `product` VALUES ('25', 'C型空调', '4956', '1850W/s', '220V', '11.9kg', '\0');
INSERT INTO `product` VALUES ('26', 'ABC型充电站', '100', '1000W/s', '220V', '55kg', '\0');
INSERT INTO `product` VALUES ('27', '抽油烟机', '45645', '456w', '220V', '66kg', '\0');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `cusID` int(11) DEFAULT NULL,
  `CssID` int(11) DEFAULT NULL,
  `Datetime` datetime DEFAULT NULL,
  `mmID` int(11) DEFAULT NULL,
  `AppRemark` text,
  `OrderID` int(11) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `MmAgree` bit(1) DEFAULT NULL,
  `CusAgree` bit(1) DEFAULT NULL,
  `MaiDateSt` datetime DEFAULT NULL,
  `MaiDateEd` datetime DEFAULT NULL,
  `Status` char(1) NOT NULL,
  `cusEva` text,
  PRIMARY KEY (`ID`),
  KEY `CssID` (`CssID`),
  KEY `cusID` (`cusID`),
  KEY `mmID` (`mmID`),
  KEY `OrderID` (`OrderID`),
  CONSTRAINT `record_ibfk_1` FOREIGN KEY (`CssID`) REFERENCES `css` (`id`),
  CONSTRAINT `record_ibfk_2` FOREIGN KEY (`cusID`) REFERENCES `customer` (`id`),
  CONSTRAINT `record_ibfk_3` FOREIGN KEY (`mmID`) REFERENCES `mainman` (`id`),
  CONSTRAINT `record_ibfk_4` FOREIGN KEY (`OrderID`) REFERENCES `myorder` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('2', '15', '2', '2019-03-01 13:01:39', '1', '', '14', '2019-05-24 09:34:43', '', '', '2019-06-04 00:15:45', null, 'D', null);
INSERT INTO `record` VALUES ('3', '15', '2', '2019-01-01 14:45:37', '1', '我们公司的那些个电水壶有3个差点没反应，还有2个爆炸了，你们说怎么回事吧？？？？', '7', '2019-05-24 09:32:01', '', '', '2019-05-24 12:10:51', '2019-05-24 12:13:30', 'E', '非常感谢维修大哥路人甲的帮助');
INSERT INTO `record` VALUES ('10', '38', '1', '2019-05-23 22:36:16', '1', '起来也更为明朗。约在隶书阶段的后期，“夏”字得到了很大程度的简化：上面繁体的“页”被写成了图①中隶书“夏”字所示的形状，两边的“手”被省略掉了，下面的“脚”变成了“夂”。由此演变为楷书中的“夏”字。在字义上，“夏”字的本义为“雄武的中国人”（这里的“', '9', '2019-05-23 23:59:01', '', null, null, null, 'C', null);
INSERT INTO `record` VALUES ('11', '15', '2', '2019-04-01 09:43:19', '1', '', '13', '2019-05-24 09:44:08', '', '', '2019-05-24 12:15:02', '2019-05-24 12:15:09', 'E', '啊大大说的');
INSERT INTO `record` VALUES ('12', '15', '2', '2019-05-24 09:43:27', '1', '', '14', '2019-05-24 09:49:59', '', '', '2019-05-24 20:29:03', '2019-05-30 15:08:02', 'E', '大佬很帅');
INSERT INTO `record` VALUES ('13', '15', '2', '2019-01-01 09:50:36', '1', '', '13', '2019-05-24 09:54:04', '', '', '2019-05-25 08:34:17', '2019-06-04 00:14:58', 'E', null);
INSERT INTO `record` VALUES ('14', '15', '2', '2019-05-24 09:50:39', '1', '', '10', '2019-05-24 09:51:01', '', '', '2019-05-25 08:48:48', '2019-06-04 00:15:07', 'E', null);
INSERT INTO `record` VALUES ('15', '15', '2', '2019-05-24 11:35:30', null, '', '10', '2019-05-24 11:41:27', null, null, null, null, 'B', null);
INSERT INTO `record` VALUES ('16', '15', '2', '2019-05-24 11:35:34', '1', '', '7', '2019-05-24 11:39:24', '', null, null, null, 'C', null);
INSERT INTO `record` VALUES ('17', '15', '2', '2019-05-24 11:35:38', '1', '', '13', '2019-05-24 11:38:21', '', null, null, null, 'C', null);
INSERT INTO `record` VALUES ('18', '15', '2', '2019-05-24 11:41:58', '1', '', '7', '2019-05-24 11:42:24', '', '', '2019-05-25 08:52:01', '2019-06-04 00:15:27', 'E', null);
INSERT INTO `record` VALUES ('19', '19', null, '2019-05-25 16:08:38', null, '我家的烟太多了，抽油烟机24小时工作都还是没解决，还把机器搞坏了，你们快点派个人过来看看，快点啊！！！', '17', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('20', '15', '1', '2019-05-29 15:58:20', null, '大声大声道', '14', '2019-05-30 15:06:59', null, null, null, null, 'B', null);
INSERT INTO `record` VALUES ('21', '15', null, '2019-05-30 00:53:39', null, '啊啊啊啊啊啊啊啊啊啊啊啊啊', '11', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('22', '15', '1', '2019-05-30 00:54:21', null, '3333333333333333', '7', '2019-06-04 21:21:15', null, null, null, null, 'B', null);
INSERT INTO `record` VALUES ('23', '15', null, '2019-05-30 01:10:45', null, '前用户：我是客户哦 【客户】', '11', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('24', '15', null, '2019-05-30 01:18:13', null, '', '11', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('25', '15', null, '2019-05-30 01:19:59', null, '', '7', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('26', '15', null, '2019-05-30 08:22:19', null, '', '13', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('27', '15', null, '2019-05-30 08:23:49', null, '机子坏了2台，速来', '13', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('28', '15', null, '2019-05-30 08:28:24', null, '', '11', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('29', '15', null, '2019-05-30 08:29:16', null, '', '14', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('42', '15', null, '2019-05-30 09:43:12', null, '', '10', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('43', '15', null, '2019-05-30 09:43:46', null, '', '7', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('44', '15', null, '2019-05-30 09:45:05', null, '', '11', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('45', '15', null, '2019-05-30 09:52:00', null, '', '7', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('46', '15', null, '2019-06-03 23:33:33', null, '我们厂商的那几台机器坏了速来修理下', '14', null, null, null, null, null, 'A', null);
INSERT INTO `record` VALUES ('47', '15', null, '2019-06-04 21:20:01', null, '我们的ABC型充电站出错了，快点来！！！', '13', null, null, null, null, null, 'A', null);

-- ----------------------------
-- Procedure structure for bathInserCustomerData
-- ----------------------------
DROP PROCEDURE IF EXISTS `bathInserCustomerData`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `bathInserCustomerData`()
begin
	DECLARE NUM INT DEFAULT 0;
	DECLARE mobile_str char(11);
	set NUM=1;
	while NUM<30 do

		if(NUM>9) then 
			set mobile_str = CONCAT(1866945,NUM,NUM);
		ELSE	 
			set mobile_str = CONCAT(186694598,NUM,NUM);
		end if;

		insert into customer(account,PASSWORD,qq,email,mobile,nickname,oneLevel_address,detailed_address) 
		values(CONCAT('customer',NUM),'123456',CONCAT('customer',NUM,'_qq'),CONCAT('customer',NUM,'emial'),mobile_str,CONCAT('客户',NUM),'重庆市',concat(NUM,'区',NUM,'街',NUM,'号'));
		insert into customer(account,PASSWORD,qq,email,mobile,nickname,oneLevel_address,detailed_address) 
		values(CONCAT('customer',NUM+1),'123456',CONCAT('customer',NUM+1,'_qq'),CONCAT('customer',NUM+1,'emial'),mobile_str,CONCAT('老板',NUM+1),'重庆市',concat(NUM+1,'区',NUM+1,'街',NUM+1,'号'));
		insert into customer(account,PASSWORD,qq,email,mobile,nickname,oneLevel_address,detailed_address) 
		values(CONCAT('customer',NUM+2),'123456',CONCAT('customer',NUM+2,'_qq'),CONCAT('customer',NUM+2,'emial'),mobile_str,CONCAT('甲方',NUM+2),'江苏省',concat(NUM+2,'区',NUM+2,'街',NUM+2,'号'));
		insert into customer(account,PASSWORD,qq,email,mobile,nickname,oneLevel_address,detailed_address) 
		values(CONCAT('customer',NUM+3),'123456',CONCAT('customer',NUM+3,'_qq'),CONCAT('customer',NUM+3,'emial'),mobile_str,CONCAT('Boss',NUM+3),'广西壮族自治区',concat(NUM+3,'区',NUM+3,'街',NUM+3,'号'));

		set NUM=NUM+4;
	end while;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for bathInsertCusserviceData
-- ----------------------------
DROP PROCEDURE IF EXISTS `bathInsertCusserviceData`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `bathInsertCusserviceData`()
begin
	DECLARE NUM INT DEFAULT 0;
	DECLARE mobile_str char(11);
	set NUM=1;
	while NUM<20 do

		if(NUM>9) then 
			set mobile_str = CONCAT(1631915,NUM,NUM);
		ELSE	 
			set mobile_str = CONCAT(135704598,NUM,NUM);
		end if;

		insert into css(account,PASSWORD,qq,email,mobile,nickname) 
		values(CONCAT('cusService',NUM),'123456',CONCAT('cusService',NUM,'_qq'),CONCAT('客服',NUM,'_emial'),mobile_str,CONCAT('客服',NUM));
		set NUM=NUM+1;
	end while;


end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for bathInsertOrderData
-- ----------------------------
DROP PROCEDURE IF EXISTS `bathInsertOrderData`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `bathInsertOrderData`()
begin
	DECLARE NUM INT DEFAULT 0;

	DECLARE type_str char(1);
	
	set NUM=1;
	while NUM<4 do
--  产品ID，客户ID，数量，日期，客服ID，备注
		insert into myorder(proid,cusid,amount,datetime,cssid,remark) 
		values(20+NUM,15,100,DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%S'),1+NUM*2,'客户要求：产品统一包装。。。。。。' );
		insert into myorder(proid,cusid,amount,datetime,cssid,remark) 
		values(23-NUM,15,22*NUM,DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%S'),1+NUM*3,CONCAT('日期：',DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%S'),'客户'));
		insert into myorder(proid,cusid,amount,datetime,cssid,remark) 
		values(22,29+NUM,134*NUM,DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%S'),1,'' );

		set NUM=NUM+1;
	end while;


end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for bathInsertProductData
-- ----------------------------
DROP PROCEDURE IF EXISTS `bathInsertProductData`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `bathInsertProductData`()
begin
	DECLARE NUM INT DEFAULT 0;
	DECLARE type_str char(1);
	set NUM=1;
	while NUM<4 do

		if((NUM%3)=1) then 
			set type_str = 'A';
		ELSEif((NUM%3)=2) then
			set type_str = 'B';
		else 
			set type_str = 'C';
		end if;
-- 价格，功率，额定电压，重量
		insert into product(prodname,para1,para2,para3,para4) 
		values( CONCAT(type_str,"型电水壶") , concat('8',NUM+6) , concat('1',NUM+5,'00W/s') ,'220V' ,CONCAT('1.',NUM,'kg'));
		insert into product(prodname,para1,para2,para3,para4) 
		values( CONCAT(type_str,"型电冰箱") , concat(NUM,'88',NUM+6) , concat(NUM-1,'.',NUM+5,'kWh/24h') ,'220V' ,CONCAT('6',NUM,'kg'));
		insert into product(prodname,para1,para2,para3,para4) 
		values( CONCAT(type_str,"型空调") , concat(NUM+1,NUM+6,NUM+2,NUM+3) , concat('1',NUM+5,NUM+2,'0W/s') ,'220V' ,CONCAT(NUM+8,'.',NUM+6,'kg'));

		set NUM=NUM+1;
	end while;


end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for bathInsertMainmanData
-- ----------------------------
DROP FUNCTION IF EXISTS `bathInsertMainmanData`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `bathInsertMainmanData`() RETURNS int(11)
begin
	DECLARE NUM INT DEFAULT 0;
	DECLARE mobile_str char(11);
	set NUM=1;
	while NUM<20 do

		if(NUM>9) then 
			set mobile_str = CONCAT(1865715,NUM,NUM);
		ELSE	 
			set mobile_str = CONCAT(132874598,NUM,NUM);
		end if;

		insert into mainman(account,PASSWORD,qq,email,mobile,nickname) 
		values(CONCAT('mainMan',NUM),'123456',CONCAT('mainMan',NUM,'_qq'),CONCAT('维修',NUM,'_emial'),mobile_str,CONCAT('维修人员',NUM));
		set NUM=NUM+1;
	end while;

return 0;
end
;;
DELIMITER ;
