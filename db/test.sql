/*
Navicat MySQL Data Transfer

Source Server         : testlocal
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-12-08 15:25:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='市级信息';

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '石家庄', '河北');
INSERT INTO `city` VALUES ('2', '邯郸', '河北');

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `countryname` varchar(255) DEFAULT NULL COMMENT '名称',
  `countrycode` varchar(255) DEFAULT NULL COMMENT '代码',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8 COMMENT='国家信息';

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', 'Angola', 'AO');
INSERT INTO `country` VALUES ('2', 'Afghanistan', 'AF');
INSERT INTO `country` VALUES ('3', 'Albania', 'AL');
INSERT INTO `country` VALUES ('4', 'Algeria', 'DZ');
INSERT INTO `country` VALUES ('5', 'Andorra', 'AD');
INSERT INTO `country` VALUES ('6', 'Anguilla', 'AI');
INSERT INTO `country` VALUES ('7', 'Antigua and Barbuda', 'AG');
INSERT INTO `country` VALUES ('8', 'Argentina', 'AR');
INSERT INTO `country` VALUES ('9', 'Armenia', 'AM');
INSERT INTO `country` VALUES ('10', 'Australia', 'AU');
INSERT INTO `country` VALUES ('11', 'Austria', 'AT');
INSERT INTO `country` VALUES ('12', 'Azerbaijan', 'AZ');
INSERT INTO `country` VALUES ('13', 'Bahamas', 'BS');
INSERT INTO `country` VALUES ('14', 'Bahrain', 'BH');
INSERT INTO `country` VALUES ('15', 'Bangladesh', 'BD');
INSERT INTO `country` VALUES ('16', 'Barbados', 'BB');
INSERT INTO `country` VALUES ('17', 'Belarus', 'BY');
INSERT INTO `country` VALUES ('18', 'Belgium', 'BE');
INSERT INTO `country` VALUES ('19', 'Belize', 'BZ');
INSERT INTO `country` VALUES ('20', 'Benin', 'BJ');
INSERT INTO `country` VALUES ('21', 'Bermuda Is.', 'BM');
INSERT INTO `country` VALUES ('22', 'Bolivia', 'BO');
INSERT INTO `country` VALUES ('23', 'Botswana', 'BW');
INSERT INTO `country` VALUES ('24', 'Brazil', 'BR');
INSERT INTO `country` VALUES ('25', 'Brunei', 'BN');
INSERT INTO `country` VALUES ('26', 'Bulgaria', 'BG');
INSERT INTO `country` VALUES ('27', 'Burkina-faso', 'BF');
INSERT INTO `country` VALUES ('28', 'Burma', 'MM');
INSERT INTO `country` VALUES ('29', 'Burundi', 'BI');
INSERT INTO `country` VALUES ('30', 'Cameroon', 'CM');
INSERT INTO `country` VALUES ('31', 'Canada', 'CA');
INSERT INTO `country` VALUES ('32', 'Central African Republic', 'CF');
INSERT INTO `country` VALUES ('33', 'Chad', 'TD');
INSERT INTO `country` VALUES ('34', 'Chile', 'CL');
INSERT INTO `country` VALUES ('35', 'China', 'CN');
INSERT INTO `country` VALUES ('36', 'Colombia', 'CO');
INSERT INTO `country` VALUES ('37', 'Congo', 'CG');
INSERT INTO `country` VALUES ('38', 'Cook Is.', 'CK');
INSERT INTO `country` VALUES ('39', 'Costa Rica', 'CR');
INSERT INTO `country` VALUES ('40', 'Cuba', 'CU');
INSERT INTO `country` VALUES ('41', 'Cyprus', 'CY');
INSERT INTO `country` VALUES ('42', 'Czech Republic', 'CZ');
INSERT INTO `country` VALUES ('43', 'Denmark', 'DK');
INSERT INTO `country` VALUES ('44', 'Djibouti', 'DJ');
INSERT INTO `country` VALUES ('45', 'Dominica Rep.', 'DO');
INSERT INTO `country` VALUES ('46', 'Ecuador', 'EC');
INSERT INTO `country` VALUES ('47', 'Egypt', 'EG');
INSERT INTO `country` VALUES ('48', 'EI Salvador', 'SV');
INSERT INTO `country` VALUES ('49', 'Estonia', 'EE');
INSERT INTO `country` VALUES ('50', 'Ethiopia', 'ET');
INSERT INTO `country` VALUES ('51', 'Fiji', 'FJ');
INSERT INTO `country` VALUES ('52', 'Finland', 'FI');
INSERT INTO `country` VALUES ('53', 'France', 'FR');
INSERT INTO `country` VALUES ('54', 'French Guiana', 'GF');
INSERT INTO `country` VALUES ('55', 'Gabon', 'GA');
INSERT INTO `country` VALUES ('56', 'Gambia', 'GM');
INSERT INTO `country` VALUES ('57', 'Georgia', 'GE');
INSERT INTO `country` VALUES ('58', 'Germany', 'DE');
INSERT INTO `country` VALUES ('59', 'Ghana', 'GH');
INSERT INTO `country` VALUES ('60', 'Gibraltar', 'GI');
INSERT INTO `country` VALUES ('61', 'Greece', 'GR');
INSERT INTO `country` VALUES ('62', 'Grenada', 'GD');
INSERT INTO `country` VALUES ('63', 'Guam', 'GU');
INSERT INTO `country` VALUES ('64', 'Guatemala', 'GT');
INSERT INTO `country` VALUES ('65', 'Guinea', 'GN');
INSERT INTO `country` VALUES ('66', 'Guyana', 'GY');
INSERT INTO `country` VALUES ('67', 'Haiti', 'HT');
INSERT INTO `country` VALUES ('68', 'Honduras', 'HN');
INSERT INTO `country` VALUES ('69', 'Hongkong', 'HK');
INSERT INTO `country` VALUES ('70', 'Hungary', 'HU');
INSERT INTO `country` VALUES ('71', 'Iceland', 'IS');
INSERT INTO `country` VALUES ('72', 'India', 'IN');
INSERT INTO `country` VALUES ('73', 'Indonesia', 'ID');
INSERT INTO `country` VALUES ('74', 'Iran', 'IR');
INSERT INTO `country` VALUES ('75', 'Iraq', 'IQ');
INSERT INTO `country` VALUES ('76', 'Ireland', 'IE');
INSERT INTO `country` VALUES ('77', 'Israel', 'IL');
INSERT INTO `country` VALUES ('78', 'Italy', 'IT');
INSERT INTO `country` VALUES ('79', 'Jamaica', 'JM');
INSERT INTO `country` VALUES ('80', 'Japan', 'JP');
INSERT INTO `country` VALUES ('81', 'Jordan', 'JO');
INSERT INTO `country` VALUES ('82', 'Kampuchea (Cambodia )', 'KH');
INSERT INTO `country` VALUES ('83', 'Kazakstan', 'KZ');
INSERT INTO `country` VALUES ('84', 'Kenya', 'KE');
INSERT INTO `country` VALUES ('85', 'Korea', 'KR');
INSERT INTO `country` VALUES ('86', 'Kuwait', 'KW');
INSERT INTO `country` VALUES ('87', 'Kyrgyzstan', 'KG');
INSERT INTO `country` VALUES ('88', 'Laos', 'LA');
INSERT INTO `country` VALUES ('89', 'Latvia', 'LV');
INSERT INTO `country` VALUES ('90', 'Lebanon', 'LB');
INSERT INTO `country` VALUES ('91', 'Lesotho', 'LS');
INSERT INTO `country` VALUES ('92', 'Liberia', 'LR');
INSERT INTO `country` VALUES ('93', 'Libya', 'LY');
INSERT INTO `country` VALUES ('94', 'Liechtenstein', 'LI');
INSERT INTO `country` VALUES ('95', 'Lithuania', 'LT');
INSERT INTO `country` VALUES ('96', 'Luxembourg', 'LU');
INSERT INTO `country` VALUES ('97', 'Macao', 'MO');
INSERT INTO `country` VALUES ('98', 'Madagascar', 'MG');
INSERT INTO `country` VALUES ('99', 'Malawi', 'MW');
INSERT INTO `country` VALUES ('100', 'Malaysia', 'MY');
INSERT INTO `country` VALUES ('101', 'Maldives', 'MV');
INSERT INTO `country` VALUES ('102', 'Mali', 'ML');
INSERT INTO `country` VALUES ('103', 'Malta', 'MT');
INSERT INTO `country` VALUES ('104', 'Mauritius', 'MU');
INSERT INTO `country` VALUES ('105', 'Mexico', 'MX');
INSERT INTO `country` VALUES ('106', 'Moldova, Republic of', 'MD');
INSERT INTO `country` VALUES ('107', 'Monaco', 'MC');
INSERT INTO `country` VALUES ('108', 'Mongolia', 'MN');
INSERT INTO `country` VALUES ('109', 'Montserrat Is', 'MS');
INSERT INTO `country` VALUES ('110', 'Morocco', 'MA');
INSERT INTO `country` VALUES ('111', 'Mozambique', 'MZ');
INSERT INTO `country` VALUES ('112', 'Namibia', 'NA');
INSERT INTO `country` VALUES ('113', 'Nauru', 'NR');
INSERT INTO `country` VALUES ('114', 'Nepal', 'NP');
INSERT INTO `country` VALUES ('115', 'Netherlands', 'NL');
INSERT INTO `country` VALUES ('116', 'New Zealand', 'NZ');
INSERT INTO `country` VALUES ('117', 'Nicaragua', 'NI');
INSERT INTO `country` VALUES ('118', 'Niger', 'NE');
INSERT INTO `country` VALUES ('119', 'Nigeria', 'NG');
INSERT INTO `country` VALUES ('120', 'North Korea', 'KP');
INSERT INTO `country` VALUES ('121', 'Norway', 'NO');
INSERT INTO `country` VALUES ('122', 'Oman', 'OM');
INSERT INTO `country` VALUES ('123', 'Pakistan', 'PK');
INSERT INTO `country` VALUES ('124', 'Panama', 'PA');
INSERT INTO `country` VALUES ('125', 'Papua New Cuinea', 'PG');
INSERT INTO `country` VALUES ('126', 'Paraguay', 'PY');
INSERT INTO `country` VALUES ('127', 'Peru', 'PE');
INSERT INTO `country` VALUES ('128', 'Philippines', 'PH');
INSERT INTO `country` VALUES ('129', 'Poland', 'PL');
INSERT INTO `country` VALUES ('130', 'French Polynesia', 'PF');
INSERT INTO `country` VALUES ('131', 'Portugal', 'PT');
INSERT INTO `country` VALUES ('132', 'Puerto Rico', 'PR');
INSERT INTO `country` VALUES ('133', 'Qatar', 'QA');
INSERT INTO `country` VALUES ('134', 'Romania', 'RO');
INSERT INTO `country` VALUES ('135', 'Russia', 'RU');
INSERT INTO `country` VALUES ('136', 'Saint Lueia', 'LC');
INSERT INTO `country` VALUES ('137', 'Saint Vincent', 'VC');
INSERT INTO `country` VALUES ('138', 'San Marino', 'SM');
INSERT INTO `country` VALUES ('139', 'Sao Tome and Principe', 'ST');
INSERT INTO `country` VALUES ('140', 'Saudi Arabia', 'SA');
INSERT INTO `country` VALUES ('141', 'Senegal', 'SN');
INSERT INTO `country` VALUES ('142', 'Seychelles', 'SC');
INSERT INTO `country` VALUES ('143', 'Sierra Leone', 'SL');
INSERT INTO `country` VALUES ('144', 'Singapore', 'SG');
INSERT INTO `country` VALUES ('145', 'Slovakia', 'SK');
INSERT INTO `country` VALUES ('146', 'Slovenia', 'SI');
INSERT INTO `country` VALUES ('147', 'Solomon Is', 'SB');
INSERT INTO `country` VALUES ('148', 'Somali', 'SO');
INSERT INTO `country` VALUES ('149', 'South Africa', 'ZA');
INSERT INTO `country` VALUES ('150', 'Spain', 'ES');
INSERT INTO `country` VALUES ('151', 'Sri Lanka', 'LK');
INSERT INTO `country` VALUES ('152', 'St.Lucia', 'LC');
INSERT INTO `country` VALUES ('153', 'St.Vincent', 'VC');
INSERT INTO `country` VALUES ('154', 'Sudan', 'SD');
INSERT INTO `country` VALUES ('155', 'Suriname', 'SR');
INSERT INTO `country` VALUES ('156', 'Swaziland', 'SZ');
INSERT INTO `country` VALUES ('157', 'Sweden', 'SE');
INSERT INTO `country` VALUES ('158', 'Switzerland', 'CH');
INSERT INTO `country` VALUES ('159', 'Syria', 'SY');
INSERT INTO `country` VALUES ('160', 'Taiwan', 'TW');
INSERT INTO `country` VALUES ('161', 'Tajikstan', 'TJ');
INSERT INTO `country` VALUES ('162', 'Tanzania', 'TZ');
INSERT INTO `country` VALUES ('163', 'Thailand', 'TH');
INSERT INTO `country` VALUES ('164', 'Togo', 'TG');
INSERT INTO `country` VALUES ('165', 'Tonga', 'TO');
INSERT INTO `country` VALUES ('166', 'Trinidad and Tobago', 'TT');
INSERT INTO `country` VALUES ('167', 'Tunisia', 'TN');
INSERT INTO `country` VALUES ('168', 'Turkey', 'TR');
INSERT INTO `country` VALUES ('169', 'Turkmenistan', 'TM');
INSERT INTO `country` VALUES ('170', 'Uganda', 'UG');
INSERT INTO `country` VALUES ('171', 'Ukraine', 'UA');
INSERT INTO `country` VALUES ('172', 'United Arab Emirates', 'AE');
INSERT INTO `country` VALUES ('173', 'United Kiongdom', 'GB');
INSERT INTO `country` VALUES ('174', 'United States of America', 'US');
INSERT INTO `country` VALUES ('175', 'Uruguay', 'UY');
INSERT INTO `country` VALUES ('176', 'Uzbekistan', 'UZ');
INSERT INTO `country` VALUES ('177', 'Venezuela', 'VE');
INSERT INTO `country` VALUES ('178', 'Vietnam', 'VN');
INSERT INTO `country` VALUES ('179', 'Yemen', 'YE');
INSERT INTO `country` VALUES ('180', 'Yugoslavia', 'YU');
INSERT INTO `country` VALUES ('181', 'Zimbabwe', 'ZW');
INSERT INTO `country` VALUES ('182', 'Zaire', 'ZR');
INSERT INTO `country` VALUES ('183', 'Zambia', 'ZM');

-- ----------------------------
-- Table structure for t1
-- ----------------------------
DROP TABLE IF EXISTS `t1`;
CREATE TABLE `t1` (
  `userid` int(11) DEFAULT NULL,
  `atime` datetime DEFAULT NULL,
  KEY `idx_userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t1
-- ----------------------------
INSERT INTO `t1` VALUES ('1', '2018-11-11 21:26:23');
INSERT INTO `t1` VALUES ('2', '2018-11-10 21:26:39');
INSERT INTO `t1` VALUES ('3', '2018-11-12 21:26:57');
INSERT INTO `t1` VALUES ('5', '2018-11-09 21:27:07');
INSERT INTO `t1` VALUES ('1', '2018-11-10 21:26:23');
INSERT INTO `t1` VALUES ('2', '2018-11-09 21:26:39');
INSERT INTO `t1` VALUES ('3', '2018-11-11 21:26:57');
INSERT INTO `t1` VALUES ('5', '2018-11-08 21:27:07');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` varchar(50) NOT NULL,
  `customer_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '10002');
INSERT INTO `t_order` VALUES ('2', '10002');
INSERT INTO `t_order` VALUES ('3', '10002');
INSERT INTO `t_order` VALUES ('4', '10002');
INSERT INTO `t_order` VALUES ('5', '10005');
INSERT INTO `t_order` VALUES ('6', '10002');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
`id` bigint(20) NOT NULL,
`username` varchar(100) DEFAULT NULL,
`password` varchar(50) DEFAULT NULL,
`delete_status` tinyint(1) DEFAULT '0' COMMENT '0 默认 1删除',
`createBy` varchar(50) DEFAULT NULL,
`createTime` datetime DEFAULT NULL,
`updateTime` datetime DEFAULT NULL,
`updateBy` varchar(50) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('10001', 'mark', '123', 0, null, null, null, null);
INSERT INTO `t_user` VALUES ('10002', 'limingyu', '456', 0, null, null, null, null);
INSERT INTO `t_user` VALUES ('10003', 'test1', '789', 0, null, null, null, null);
INSERT INTO `t_user` VALUES ('10004', 'test2', 'test2', 0, null, null, null, null);
INSERT INTO `t_user` VALUES ('10005', 'test3', 'test3', 0, null, null, null, null);
INSERT INTO `t_user` VALUES ('10006', 'test4', 'test4', 0, null, null, null, null);
INSERT INTO `t_user` VALUES ('10007', 'test5', 'test5', 0, null, null, null, null);
INSERT INTO `t_user` VALUES ('10008', 'test8', 'test8', 0, null, null, null, null);
INSERT INTO `t_user` VALUES ('10009', 'fest9', 'fast9', 0, null, null, null, null);
INSERT INTO `t_user` VALUES ('10010', 'mark2', 'mark', 0, null, null, null, null);


-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `usertype` varchar(2) DEFAULT NULL COMMENT '用户类型',
  `enabled` int(2) DEFAULT NULL COMMENT '是否可用',
  `realname` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `qq` varchar(14) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'test1', '12345678', '1', null, null, null, null, null);
INSERT INTO `user_info` VALUES ('2', 'test2', 'aaaa', '2', null, null, null, null, null);
INSERT INTO `user_info` VALUES ('3', 'test3', 'bbbb', '1', null, null, null, null, null);
INSERT INTO `user_info` VALUES ('4', 'test4', 'cccc', '2', null, null, null, null, null);
INSERT INTO `user_info` VALUES ('5', 'test5', 'dddd', '1', null, null, null, null, null);


create table category
(
    cat_id               bigint not null auto_increment comment '分类id',
    name                 char(50) comment '分类名称',
    parent_cid           bigint comment '父分类id',
    cat_level            int comment '层级',
    show_status          tinyint comment '是否显示[0-不显示，1显示]',
    sort                 int comment '排序',
    icon                 char(255) comment '图标地址',
    product_unit         char(50) comment '计量单位',
    product_count        int comment '商品数量',
    primary key (cat_id)
);

INSERT INTO `category` VALUES (1, '图书、音像、电子书刊', 0, 1, 1, 2, NULL, NULL, 0);
INSERT INTO `category` VALUES (2, '手机', 0, 1, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (3, '家用电器', 0, 1, 1, 4, NULL, NULL, 0);
INSERT INTO `category` VALUES (4, '数码', 0, 1, 1, 3, NULL, NULL, 0);
INSERT INTO `category` VALUES (5, '家居家装', 0, 1, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (6, '电脑办公', 0, 1, 1, 5, NULL, NULL, 0);
INSERT INTO `category` VALUES (7, '厨具', 0, 1, 1, 6, NULL, NULL, 0);
INSERT INTO `category` VALUES (27, '人文社科', 1, 2, 1, 2, NULL, NULL, 0);
INSERT INTO `category` VALUES (28, '经管励志', 1, 2, 1, 1, NULL, NULL, 0);
INSERT INTO `category` VALUES (29, '生活', 1, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (30, '科技', 1, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (31, '教育', 1, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (32, '港台图书', 1, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (33, '其他', 1, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (34, '手机通讯', 2, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (35, '运营商', 2, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (36, '手机配件', 2, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (37, '大 家 电', 3, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (38, '厨卫大电', 3, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (39, '厨房小电', 3, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (40, '生活电器', 3, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (41, '个护健康', 3, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (42, '五金家装', 3, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (43, '摄影摄像', 4, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (44, '数码配件', 4, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (45, '智能设备', 4, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (46, '影音娱乐', 4, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (47, '电子教育', 4, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (48, '虚拟商品', 4, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (49, '家纺', 5, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (50, '灯具', 5, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (51, '生活日用', 5, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (52, '家装软饰', 5, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (53, '宠物生活', 5, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (54, '电脑整机', 6, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (55, '电脑配件', 6, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (56, '外设产品', 6, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (57, '游戏设备', 6, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (58, '网络产品', 6, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (67, '酒店用品', 7, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (68, '茶具/咖啡具', 7, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (69, '清洁用品', 8, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (70, '面部护肤', 8, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (71, '身体护理', 8, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (72, '口腔护理', 8, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (73, '女性护理', 8, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (74, '洗发护发', 8, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (75, '香水彩妆', 8, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (76, '女装', 9, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (77, '男装', 9, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (78, '内衣', 9, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (79, '洗衣服务', 9, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (80, '服饰配件', 9, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (81, '钟表', 10, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (82, '流行男鞋', 11, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (83, '时尚女鞋', 11, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (84, '奶粉', 12, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (85, '营养辅食', 12, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (86, '尿裤湿巾', 12, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (87, '喂养用品', 12, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (88, '洗护用品', 12, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (95, '精品男包', 13, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (96, '功能箱包', 13, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (97, '礼品', 13, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (98, '奢侈品', 13, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (99, '婚庆', 13, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (100, '进口食品', 14, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (101, '地方特产', 14, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (102, '休闲食品', 14, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (103, '粮油调味', 14, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (104, '饮料冲调', 14, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (105, '食品礼券', 14, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (106, '茗茶', 14, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (107, '时尚饰品', 15, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (108, '黄金', 15, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (109, 'K金饰品', 15, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (110, '金银投资', 15, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (111, '银饰', 15, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (112, '钻石', 15, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (113, '翡翠玉石', 15, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (114, '水晶玛瑙', 15, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (115, '彩宝', 15, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (116, '铂金', 15, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (117, '木手串/把件', 15, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (118, '珍珠', 15, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (119, '维修保养', 16, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (120, '车载电器', 16, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (121, '美容清洗', 16, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (122, '汽车装饰', 16, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (123, '安全自驾', 16, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (124, '汽车服务', 16, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (125, '赛事改装', 16, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (126, '运动鞋包', 17, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (127, '运动服饰', 17, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (128, '骑行运动', 17, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (129, '垂钓用品', 17, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (130, '游泳用品', 17, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (131, '户外鞋服', 17, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (132, '户外装备', 17, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (133, '健身训练', 17, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (134, '体育用品', 17, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (135, '适用年龄', 18, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (136, '遥控/电动', 18, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (137, '毛绒布艺', 18, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (149, '酒店', 19, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (150, '旅行', 19, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (151, '充值', 19, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (152, '游戏', 19, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (153, '票务', 19, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (154, '产地直供', 20, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (155, '水果', 20, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (156, '猪牛羊肉', 20, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (157, '海鲜水产', 20, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (158, '禽肉蛋品', 20, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (159, '冷冻食品', 20, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (160, '熟食腊味', 20, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (161, '饮品甜品', 20, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (162, '蔬菜', 20, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (163, '全新整车', 21, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (164, '二手车', 21, 2, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (165, '电子书', 22, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (166, '网络原创', 22, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (167, '数字杂志', 22, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (168, '多媒体图书', 22, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (169, '音乐', 23, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (170, '影视', 23, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (171, '教育音像', 23, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (172, '少儿', 24, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (173, '商务投资', 24, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (174, '英语学习与考试', 24, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (175, '文学', 24, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (176, '传记', 24, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (177, '励志', 24, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (178, '小说', 25, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (179, '文学', 25, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (180, '青春文学', 25, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (181, '传记', 25, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (182, '艺术', 25, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (183, '少儿', 26, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (184, '0-2岁', 26, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (195, '文化', 27, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (196, '社会科学', 27, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (197, '经济', 28, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (198, '金融与投资', 28, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (199, '管理', 28, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (200, '励志与成功', 28, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (201, '生活', 29, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (202, '健身与保健', 29, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (211, '计算机与互联网', 30, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (212, '电子通信', 30, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (213, '中小学教辅', 31, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (214, '教育与考试', 31, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (215, '外语学习', 31, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (216, '大中专教材', 31, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (217, '字典词典', 31, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (218, '艺术/设计/收藏', 32, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (219, '经济管理', 32, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (220, '文化/学术', 32, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (221, '少儿', 32, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (222, '工具书', 33, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (223, '杂志/期刊', 33, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (224, '套装书', 33, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (225, '手机', 34, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (226, '对讲机', 34, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (227, '合约机', 35, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (228, '选号中心', 35, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (229, '装宽带', 35, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (230, '办套餐', 35, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (231, '移动电源', 36, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (232, '电池/移动电源', 36, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (233, '蓝牙耳机', 36, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (249, '手机支架', 36, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (250, '平板电视', 37, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (266, '热水器', 38, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (267, '消毒柜', 38, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (268, '洗碗机', 38, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (308, '剃须刀', 41, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (309, '剃/脱毛器', 41, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (310, '口腔护理', 41, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (311, '电吹风', 41, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (312, '美容器', 41, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (313, '理发器', 41, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (314, '卷/直发器', 41, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (315, '按摩椅', 41, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (327, '浴霸/排气扇', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (328, '灯具', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (329, 'LED灯', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (330, '洁身器', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (331, '水槽', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (332, '龙头', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (333, '淋浴花洒', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (334, '厨卫五金', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (335, '家具五金', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (336, '门铃', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (337, '电气开关', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (338, '插座', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (339, '电工电料', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (340, '监控安防', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (341, '电线/线缆', 42, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (342, '数码相机', 43, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (343, '单电/微单相机', 43, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (344, '单反相机', 43, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (345, '摄像机', 43, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (346, '拍立得', 43, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (347, '运动相机', 43, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (348, '镜头', 43, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (349, '户外器材', 43, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (360, '机身附件', 44, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (361, '镜头附件', 44, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (362, '电池/充电器', 44, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (363, '移动电源', 44, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (364, '数码支架', 44, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (365, '智能手环', 45, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (366, '智能手表', 45, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (367, '智能眼镜', 45, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (368, '运动跟踪器', 45, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (369, '健康监测', 45, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (370, '智能配饰', 45, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (371, '智能家居', 45, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (372, '体感车', 45, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (373, '其他配件', 45, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (374, '智能机器人', 45, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (375, '无人机', 45, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (376, 'MP3/MP4', 46, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (377, '智能设备', 46, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (378, '耳机/耳麦', 46, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (379, '便携/无线音箱', 46, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (380, '音箱/音响', 46, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (381, '高清播放器', 46, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (382, '收音机', 46, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (383, 'MP3/MP4配件', 46, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (384, '麦克风', 46, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (385, '专业音频', 46, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (386, '苹果配件', 46, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (387, '学生平板', 47, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (388, '点读机/笔', 47, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (389, '早教益智', 47, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (390, '录音笔', 47, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (391, '电纸书', 47, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (392, '电子词典', 47, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (393, '复读机', 47, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (394, '延保服务', 48, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (395, '杀毒软件', 48, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (396, '积分商品', 48, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (397, '桌布/罩件', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (398, '地毯地垫', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (399, '沙发垫套/椅垫', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (400, '床品套件', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (401, '被子', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (402, '枕芯', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (403, '床单被罩', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (404, '毯子', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (405, '床垫/床褥', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (406, '蚊帐', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (407, '抱枕靠垫', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (408, '毛巾浴巾', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (409, '电热毯', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (410, '窗帘/窗纱', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (411, '布艺软饰', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (412, '凉席', 49, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (413, '台灯', 50, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (414, '节能灯', 50, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (415, '装饰灯', 50, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (416, '落地灯', 50, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (417, '应急灯/手电', 50, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (418, 'LED灯', 50, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (419, '吸顶灯', 50, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (420, '五金电器', 50, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (421, '筒灯射灯', 50, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (422, '吊灯', 50, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (423, '氛围照明', 50, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (424, '保暖防护', 51, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (425, '收纳用品', 51, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (426, '雨伞雨具', 51, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (427, '浴室用品', 51, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (428, '缝纫/针织用品', 51, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (429, '洗晒/熨烫', 51, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (430, '净化除味', 51, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (431, '相框/照片墙', 52, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (432, '装饰字画', 52, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (433, '节庆饰品', 52, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (434, '手工/十字绣', 52, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (435, '装饰摆件', 52, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (436, '帘艺隔断', 52, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (437, '墙贴/装饰贴', 52, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (438, '钟饰', 52, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (439, '花瓶花艺', 52, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (440, '香薰蜡烛', 52, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (441, '创意家居', 52, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (442, '宠物主粮', 53, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (443, '宠物零食', 53, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (444, '医疗保健', 53, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (445, '家居日用', 53, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (446, '宠物玩具', 53, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (447, '出行装备', 53, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (448, '洗护美容', 53, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (449, '笔记本', 54, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (450, '超极本', 54, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (451, '游戏本', 54, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (465, '电源', 55, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (466, '显示器', 55, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (467, '刻录机/光驱', 55, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (468, '散热器', 55, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (469, '声卡/扩展卡', 55, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (470, '装机配件', 55, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (471, '组装电脑', 55, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (472, '移动硬盘', 56, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (473, 'U盘', 56, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (474, '鼠标', 56, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (475, '键盘', 56, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (486, '电脑清洁', 56, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (487, '网络仪表仪器', 56, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (488, '游戏机', 57, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (489, '游戏耳机', 57, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (490, '手柄/方向盘', 57, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (491, '游戏软件', 57, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (492, '游戏周边', 57, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (493, '路由器', 58, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (494, '网卡', 58, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (495, '交换机', 58, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (496, '网络存储', 58, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (497, '4G/3G上网', 58, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (498, '网络盒子', 58, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (499, '网络配件', 58, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (500, '投影机', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (501, '投影配件', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (502, '多功能一体机', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (503, '打印机', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (504, '传真设备', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (505, '验钞/点钞机', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (506, '扫描设备', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (507, '复合机', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (508, '碎纸机', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (509, '考勤机', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (510, '收款/POS机', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (511, '会议音频视频', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (512, '保险柜', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (513, '装订/封装机', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (514, '安防监控', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (515, '办公家具', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (516, '白板', 59, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (517, '硒鼓/墨粉', 60, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (518, '墨盒', 60, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (519, '色带', 60, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (520, '纸类', 60, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (521, '办公文具', 60, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (522, '学生文具', 60, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (523, '财会用品', 60, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (524, '文件管理', 60, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (525, '本册/便签', 60, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (526, '计算器', 60, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (527, '笔类', 60, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (528, '画具画材', 60, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (529, '刻录碟片/附件', 60, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (530, '上门安装', 61, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (531, '延保服务', 61, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (532, '维修保养', 61, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (533, '电脑软件', 61, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (534, '京东服务', 61, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (535, '炒锅', 62, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (536, '煎锅', 62, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (537, '压力锅', 62, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (538, '蒸锅', 62, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (539, '汤锅', 62, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (540, '奶锅', 62, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (541, '锅具套装', 62, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (542, '煲类', 62, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (543, '水壶', 62, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (544, '火锅', 62, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (545, '菜刀', 63, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (546, '剪刀', 63, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (547, '刀具套装', 63, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (548, '砧板', 63, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (549, '瓜果刀/刨', 63, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (550, '多功能刀', 63, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (551, '保鲜盒', 64, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (552, '烘焙/烧烤', 64, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (553, '饭盒/提锅', 64, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (554, '储物/置物架', 64, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (555, '厨房DIY/小工具', 64, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (556, '塑料杯', 65, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (557, '运动水壶', 65, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (558, '玻璃杯', 65, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (559, '陶瓷/马克杯', 65, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (560, '保温杯', 65, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (561, '保温壶', 65, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (562, '酒杯/酒具', 65, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (563, '杯具套装', 65, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (564, '餐具套装', 66, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (565, '碗/碟/盘', 66, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (566, '筷勺/刀叉', 66, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (567, '一次性用品', 66, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (568, '果盘/果篮', 66, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (569, '自助餐炉', 67, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (570, '酒店餐具', 67, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (571, '酒店水具', 67, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (572, '整套茶具', 68, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (573, '茶杯', 68, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (574, '茶壶', 68, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (575, '茶盘茶托', 68, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (576, '茶叶罐', 68, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (577, '茶具配件', 68, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (578, '茶宠摆件', 68, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (579, '咖啡具', 68, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (580, '其他', 68, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (581, '纸品湿巾', 69, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (582, '衣物清洁', 69, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (583, '清洁工具', 69, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (584, '驱虫用品', 69, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (585, '家庭清洁', 69, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (586, '皮具护理', 69, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (587, '一次性用品', 69, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (588, '洁面', 70, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (589, '乳液面霜', 70, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (590, '面膜', 70, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (591, '剃须', 70, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (613, '磨砂/浴盐', 71, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (614, '手工/香皂', 71, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (615, '洗发', 71, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (616, '护发', 71, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (617, '染发', 71, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (618, '磨砂膏', 71, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (619, '香皂', 71, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (620, '牙膏/牙粉', 72, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (621, '牙刷/牙线', 72, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (627, '脱毛膏', 73, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (628, '其他', 73, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (629, '洗发', 74, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (638, '底妆', 75, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (639, '腮红', 75, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (656, '连衣裙', 76, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (657, '半身裙', 76, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (658, '牛仔裤', 76, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (692, '毛呢大衣', 77, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (710, '羊毛衫', 77, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (726, '休闲棉袜', 78, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (727, '大码内衣', 78, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (732, '情趣内衣', 78, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (733, '服装洗护', 79, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (734, '太阳镜', 80, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (749, '礼帽', 80, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (750, '真皮手套', 80, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (751, '毛线手套', 80, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (773, '钟表配件', 81, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (774, '商务休闲鞋', 82, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (775, '正装鞋', 82, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (776, '休闲鞋', 82, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (777, '凉鞋/沙滩鞋', 82, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (797, '帆布鞋', 83, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (798, '雨鞋/雨靴', 83, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (799, '妈妈鞋', 83, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (800, '鞋配件', 83, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (801, '特色鞋', 83, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (802, '鱼嘴鞋', 83, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (803, '布鞋/绣花鞋', 83, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (810, '孕妈奶粉', 84, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (811, '益生菌/初乳', 85, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (812, '米粉/菜粉', 85, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (813, '果泥/果汁', 85, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (814, 'DHA', 85, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (821, '婴儿湿巾', 86, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (822, '成人尿裤', 86, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (823, '奶瓶奶嘴', 87, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (824, '吸奶器', 87, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (825, '暖奶消毒', 87, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (836, '理发器', 88, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (837, '洗澡用具', 88, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (838, '婴儿口腔清洁', 88, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (859, '爬行垫', 90, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (860, '妈咪包/背婴带', 91, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (861, '产后塑身', 91, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (862, '文胸/内裤', 91, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (863, '防辐射服', 91, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (877, '儿童配饰', 92, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (878, '礼服/演出服', 92, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (879, '运动鞋', 92, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (880, '皮鞋/帆布鞋', 92, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (881, '靴子', 92, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (882, '凉鞋', 92, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (883, '功能鞋', 92, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (884, '户外/运动服', 92, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (885, '提篮式', 93, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (886, '安全座椅', 93, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (887, '增高垫', 93, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (888, '钱包', 94, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (897, '男士手包', 95, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (898, '卡包名片夹', 95, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (899, '商务公文包', 95, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (900, '双肩包', 95, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (901, '单肩/斜挎包', 95, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (902, '钥匙包', 95, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (903, '电脑包', 96, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (904, '拉杆箱', 96, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (915, '礼品文具', 97, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (927, '古董文玩', 97, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (928, '箱包', 98, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (929, '钱包', 98, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (937, '高档化妆品', 98, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (938, '婚嫁首饰', 99, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (939, '婚纱摄影', 99, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (940, '婚纱礼服', 99, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (941, '婚庆服务', 99, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (942, '婚庆礼品/用品', 99, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (943, '婚宴', 99, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (944, '饼干蛋糕', 100, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (945, '糖果/巧克力', 100, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (946, '休闲零食', 100, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (951, '新疆', 101, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (952, '北京', 101, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (953, '山西', 101, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (959, '东北', 101, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (960, '休闲零食', 102, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (961, '坚果炒货', 102, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (962, '肉干肉脯', 102, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (963, '蜜饯果干', 102, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (964, '糖果/巧克力', 102, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (965, '饼干蛋糕', 102, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (966, '无糖食品', 102, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (967, '米面杂粮', 103, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (968, '食用油', 103, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (969, '调味品', 103, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (970, '南北干货', 103, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (971, '方便食品', 103, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (972, '有机食品', 103, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (973, '饮用水', 104, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (974, '饮料', 104, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (975, '牛奶乳品', 104, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (976, '咖啡/奶茶', 104, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (977, '冲饮谷物', 104, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (978, '蜂蜜/柚子茶', 104, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (979, '成人奶粉', 104, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (980, '月饼', 105, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (981, '大闸蟹', 105, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (982, '粽子', 105, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (983, '卡券', 105, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (984, '铁观音', 106, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (985, '普洱', 106, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (986, '龙井', 106, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (987, '绿茶', 106, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (988, '红茶', 106, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (989, '乌龙茶', 106, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (990, '花草茶', 106, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (991, '花果茶', 106, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (992, '养生茶', 106, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (993, '黑茶', 106, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (994, '白茶', 106, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (995, '其它茶', 106, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (996, '项链', 107, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (997, '手链/脚链', 107, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (998, '戒指', 107, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (999, '耳饰', 107, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1000, '毛衣链', 107, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1001, '发饰/发卡', 107, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1002, '胸针', 107, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1003, '饰品配件', 107, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1004, '婚庆饰品', 107, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1005, '黄金吊坠', 108, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1006, '黄金项链', 108, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1007, '黄金转运珠', 108, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1008, '黄金手镯/手链/脚链', 108, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1009, '黄金耳饰', 108, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1010, '黄金戒指', 108, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1011, 'K金吊坠', 109, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1012, 'K金项链', 109, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1013, 'K金手镯/手链/脚链', 109, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1014, 'K金戒指', 109, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1015, 'K金耳饰', 109, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1016, '投资金', 110, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1017, '投资银', 110, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1018, '投资收藏', 110, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1019, '银吊坠/项链', 111, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1020, '银手镯/手链/脚链', 111, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1021, '银戒指', 111, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1022, '银耳饰', 111, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1023, '足银手镯', 111, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1024, '宝宝银饰', 111, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1025, '裸钻', 112, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1026, '钻戒', 112, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1027, '钻石项链/吊坠', 112, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1028, '钻石耳饰', 112, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1029, '钻石手镯/手链', 112, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1030, '项链/吊坠', 113, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1031, '手镯/手串', 113, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1032, '戒指', 113, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1033, '耳饰', 113, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1034, '挂件/摆件/把件', 113, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1035, '玉石孤品', 113, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1036, '项链/吊坠', 114, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1037, '耳饰', 114, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1038, '手镯/手链/脚链', 114, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1039, '戒指', 114, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1040, '头饰/胸针', 114, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1041, '摆件/挂件', 114, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1042, '琥珀/蜜蜡', 115, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1043, '碧玺', 115, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1044, '红宝石/蓝宝石', 115, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1045, '坦桑石', 115, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1046, '珊瑚', 115, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1047, '祖母绿', 115, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1048, '葡萄石', 115, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1049, '其他天然宝石', 115, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1050, '项链/吊坠', 115, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1051, '耳饰', 115, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1052, '手镯/手链', 115, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1053, '戒指', 115, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1054, '铂金项链/吊坠', 116, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1055, '铂金手镯/手链/脚链', 116, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1056, '铂金戒指', 116, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1057, '铂金耳饰', 116, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1058, '小叶紫檀', 117, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1059, '黄花梨', 117, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1060, '沉香木', 117, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1061, '金丝楠', 117, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1062, '菩提', 117, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1063, '其他', 117, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1064, '橄榄核/核桃', 117, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1065, '檀香', 117, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1066, '珍珠项链', 118, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1067, '珍珠吊坠', 118, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1068, '珍珠耳饰', 118, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1069, '珍珠手链', 118, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1070, '珍珠戒指', 118, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1071, '珍珠胸针', 118, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1072, '机油', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1073, '正时皮带', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1074, '添加剂', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1075, '汽车喇叭', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1076, '防冻液', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1077, '汽车玻璃', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1078, '滤清器', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1079, '火花塞', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1080, '减震器', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1081, '柴机油/辅助油', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1082, '雨刷', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1083, '车灯', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1084, '后视镜', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1085, '轮胎', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1086, '轮毂', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1087, '刹车片/盘', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1088, '维修配件', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1089, '蓄电池', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1090, '底盘装甲/护板', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1091, '贴膜', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1092, '汽修工具', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1093, '改装配件', 119, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1094, '导航仪', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1095, '安全预警仪', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1096, '行车记录仪', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1097, '倒车雷达', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1098, '蓝牙设备', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1099, '车载影音', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1100, '净化器', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1101, '电源', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1102, '智能驾驶', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1103, '车载电台', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1104, '车载电器配件', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1105, '吸尘器', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1106, '智能车机', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1107, '冰箱', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1108, '汽车音响', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1109, '车载生活电器', 120, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1110, '车蜡', 121, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1111, '补漆笔', 121, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1112, '玻璃水', 121, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1127, '香水', 122, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1128, '空气净化', 122, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1129, '挂件摆件', 122, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1130, '功能小件', 122, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1142, '自驾野营', 123, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1143, '摩托车装备', 123, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1144, '清洗美容', 124, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1145, '功能升级', 124, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1146, '保养维修', 124, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1154, '制动系统', 125, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1155, '悬挂系统', 125, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1164, '板鞋', 126, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1165, '帆布鞋', 126, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1166, '足球鞋', 126, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1179, '乒羽网服', 127, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1180, '健身服', 127, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1181, '运动背心', 127, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1189, '骑行装备', 128, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1190, '平衡车', 128, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1191, '鱼竿鱼线', 129, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1192, '浮漂鱼饵', 129, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1193, '钓鱼桌椅', 129, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1194, '钓鱼配件', 129, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1195, '钓箱鱼包', 129, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1196, '其它', 129, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1197, '泳镜', 130, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1198, '泳帽', 130, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1199, '游泳包防水包', 130, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1200, '女士泳衣', 130, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1201, '男士泳衣', 130, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1202, '比基尼', 130, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1217, '徒步鞋', 131, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1218, '越野跑鞋', 131, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1219, '休闲鞋', 131, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1238, '滑雪装备', 132, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1239, '极限户外', 132, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1240, '冲浪潜水', 132, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1241, '综合训练器', 133, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1242, '其他大型器械', 133, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1243, '哑铃', 133, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1244, '仰卧板/收腹机', 133, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1259, '高尔夫', 134, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1266, '1-3岁', 135, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1267, '3-6岁', 135, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1268, '6-14岁', 135, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1269, '14岁以上', 135, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1270, '遥控车', 136, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1271, '遥控飞机', 136, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1272, '遥控船', 136, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1273, '机器人', 136, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1274, '轨道/助力', 136, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1275, '毛绒/布艺', 137, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1276, '靠垫/抱枕', 137, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1277, '芭比娃娃', 138, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1278, '卡通娃娃', 138, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1279, '智能娃娃', 138, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1280, '仿真模型', 139, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1281, '拼插模型', 139, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1282, '收藏爱好', 139, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1283, '炫舞毯', 140, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1284, '爬行垫/毯', 140, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1285, '户外玩具', 140, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1286, '戏水玩具', 140, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1287, '电影周边', 141, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1288, '卡通周边', 141, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1289, '网游周边', 141, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1290, '摇铃/床铃', 142, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1291, '健身架', 142, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1292, '早教启智', 142, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1293, '拖拉玩具', 142, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1294, '积木', 143, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1295, '拼图', 143, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1296, '磁力棒', 143, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1297, '立体拼插', 143, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1298, '手工彩泥', 144, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1299, '绘画工具', 144, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1300, '情景玩具', 144, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1301, '减压玩具', 145, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1302, '创意玩具', 145, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1303, '钢琴', 146, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1304, '电子琴/电钢琴', 146, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1305, '吉他/尤克里里', 146, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1323, '新时时彩', 147, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1324, '国内机票', 148, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1325, '国内酒店', 149, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1326, '酒店团购', 149, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1346, '华东', 154, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1347, '华南', 154, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1348, '西南', 154, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1349, '苹果', 155, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1350, '橙子', 155, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1351, '奇异果/猕猴桃', 155, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1369, '羊肉', 156, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1370, '猪肉', 156, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1371, '内脏类', 156, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1372, '鱼类', 157, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1373, '虾类', 157, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1374, '蟹类', 157, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1375, '贝类', 157, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1376, '海参', 157, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1377, '海产干货', 157, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1383, '其他禽类', 158, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1384, '水饺/馄饨', 159, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1385, '汤圆/元宵', 159, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1386, '面点', 159, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1387, '火锅丸串', 159, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1388, '速冻半成品', 159, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1389, '奶酪黄油', 159, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1390, '熟食', 160, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1391, '腊肠/腊肉', 160, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1392, '火腿', 160, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1393, '糕点', 160, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1394, '礼品卡券', 160, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1395, '冷藏果蔬汁', 161, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1396, '冰激凌', 161, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1397, '其他', 161, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1398, '叶菜类', 162, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1399, '茄果瓜类', 162, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1400, '根茎类', 162, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1401, '鲜菌菇', 162, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1402, '葱姜蒜椒', 162, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1403, '半加工蔬菜', 162, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1404, '微型车', 163, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1405, '小型车', 163, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1406, '紧凑型车', 163, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1407, '中型车', 163, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1408, '中大型车', 163, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1409, '豪华车', 163, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1410, 'MPV', 163, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1411, 'SUV', 163, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1412, '跑车', 163, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1413, '微型车（二手）', 164, 3, 1, 0, NULL, NULL, 0);
INSERT INTO `category` VALUES (1423, '面包车（二手）', 164, 3, 1, 0, NULL, NULL, 0);



