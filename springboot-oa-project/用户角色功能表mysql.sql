/*
Navicat MySQL Data Transfer

Source Server         : 微信小餐馆
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2018-08-01 20:55:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `ID` varchar(50) NOT NULL,
  `DICT_TYPE` varchar(100) DEFAULT NULL,
  `DICT_CODE` varchar(100) DEFAULT NULL,
  `DICT_VALUE` varchar(255) DEFAULT NULL,
  `DICT_STATUS` varchar(1) DEFAULT NULL,
  `DICT_CREATEUSER` varchar(255) DEFAULT NULL,
  `DICT_CODE_PID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------

-- ----------------------------
-- Table structure for sys_function
-- ----------------------------
DROP TABLE IF EXISTS `sys_function`;
CREATE TABLE `sys_function` (
  `ID` varchar(50) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `FUNC_URL` varchar(300) DEFAULT NULL,
  `FUNC_DESC` varchar(5) DEFAULT NULL,
  `FUNC_TYPE` varchar(2) DEFAULT NULL,
  `CREATETIME` date DEFAULT NULL,
  `PID` varchar(50) DEFAULT NULL,
  `IS_PARENT` varchar(2) DEFAULT NULL,
  `OPEN` varchar(2) DEFAULT NULL,
  `CLASSFIELD` varchar(100) DEFAULT NULL,
  `SITE_ID` varchar(2) DEFAULT NULL,
  `isleaf` varchar(2) DEFAULT NULL,
  `PID_NAME` varchar(100) DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_function
-- ----------------------------
INSERT INTO `sys_function` VALUES ('039ec3e6-857c-444b-bfbc-324378feaec4', '取消', 'role_cancel', '2', '4', '2018-03-22', 'bc74183a-e3f1-44da-9ae0-082181900059', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('052451f3-7e95-4642-9599-5a57709b6ead', '系统管理', '#', '2', '2', '2018-03-20', '32321-ffcc-dcbd-32ff2', '1', '0', 'fa fa-user', '1', '0', '确权系统菜单');
INSERT INTO `sys_function` VALUES ('07fc8924-61b0-4aef-9d88-2685b2840028', '添加职位', '/job/addJob?flag=1', '2', '3', '2018-03-21', '9d17d3ab-1fb4-4743-acda-81687ad137d1', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('1', '菜单管理', '无', '1', '0', '2018-03-11', '', '1', '0', null, null, '0', null);
INSERT INTO `sys_function` VALUES ('303959b1-624d-4fd0-81d8-3a83b9b2f1b4', '数据导入', '#', '6', '2', '2018-03-24', '32321-ffcc-dcbd-32ff2', '1', '0', 'fa fa-upload', '1', '0', '确权系统菜单');
INSERT INTO `sys_function` VALUES ('32321-ffcc-dcbd-32ff2', '确权系统菜单', '/', '1', '0', '2018-03-18', '1', '1', '0', '', '1', '0', '菜单管理');
INSERT INTO `sys_function` VALUES ('32ef314e-1f92-4bcc-a9f0-7adbe10a81f0', '删除', 'role_delete', '2', '4', '2018-03-22', '620a490e-e0ed-4df0-adae-431aebde6ad0', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('3a33a279-2873-4112-a56c-15de8ca34444', '发包方信息管理', '#', '3', '2', '2018-03-20', '32321-ffcc-dcbd-32ff2', '1', '0', 'fa fa-home', '1', '0', '确权系统菜单');
INSERT INTO `sys_function` VALUES ('40d83d31-6b3f-48f5-9c89-eda532d28d42', '保存', 'menu_add', '1', '4', '2018-03-22', 'bc74183a-e3f1-44da-9ae0-082181900059', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('46df3654-25b4-4ee8-ac97-848b58bcb849', '员工查询', '/employee/selectEmployee', '1', '3', '2018-03-21', '755be5c5-adcd-4299-8716-96b754a1d887', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('516c9f81-8a7a-4f34-8a6e-2e92314eec37', '修改', 'user_update', '2', '4', '2018-03-22', 'ebf173d4-16e4-4784-a1ee-acbe7ecb980b', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('59e1a0eb-3c56-4cdb-9f5a-3630d5daf81b', '删除', 'user_delete', '3', '4', '2018-03-22', 'ebf173d4-16e4-4784-a1ee-acbe7ecb980b', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('5cf182ed-4c77-45fa-b46f-23dd716e6913', '添加员工', '/employee/addEmployee?flag=1', '2', '3', '2018-03-21', '755be5c5-adcd-4299-8716-96b754a1d887', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('620a490e-e0ed-4df0-adae-431aebde6ad0', '角色管理', '/views/system/roleManage.jsp', '2', '3', '2018-03-20', '052451f3-7e95-4642-9599-5a57709b6ead', '1', '0', null, '1', '0', '系统管理');
INSERT INTO `sys_function` VALUES ('6564e732-492c-43b6-ad03-6a29bcc9288e', '首页', '#', '1', '0', '2018-04-10', 'a7f3cf9a-16b3-4b3e-b484-c5c0db53bffd', '1', '0', '1', '2', '0', '');
INSERT INTO `sys_function` VALUES ('6bcb1eb7-5d54-4819-ab2c-a27025487c74', '消息处理', '/views/message/message.jsp', '1', '3', '2018-03-24', '865d754f-1d33-4a63-989b-603bdf3b21e7', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('6e957edc-2b6d-4f67-959c-962bf3203d9c', '修改', 'role_update', '3', '4', '2018-03-22', '620a490e-e0ed-4df0-adae-431aebde6ad0', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('755be5c5-adcd-4299-8716-96b754a1d887', '员工管理', '#', '5', '2', '2018-03-21', '32321-ffcc-dcbd-32ff2', '1', '0', 'fa fa-users', '1', '0', '');
INSERT INTO `sys_function` VALUES ('7810ef01-b89d-4e27-8358-a633f4be84e9', '用户授权', 'user_authorize', '4', '4', '2018-03-22', 'ebf173d4-16e4-4784-a1ee-acbe7ecb980b', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('865d754f-1d33-4a63-989b-603bdf3b21e7', '消息管理', '#', '7', '2', '2018-03-24', '32321-ffcc-dcbd-32ff2', '1', '0', 'fa fa-wechat', '1', '0', '确权系统菜单');
INSERT INTO `sys_function` VALUES ('91c88839-6b7b-4193-bff6-eb79f0d5171b', '数据汇交预约', '/views/sjhj/sjhj.jsp', '1', '3', '2018-03-24', '303959b1-624d-4fd0-81d8-3a83b9b2f1b4', '1', '0', null, '1', '0', '数据导入');
INSERT INTO `sys_function` VALUES ('9d17d3ab-1fb4-4743-acda-81687ad137d1', '职位管理', '#', '4', '2', '2018-03-21', '32321-ffcc-dcbd-32ff2', '1', '0', 'fa fa-ra', '1', '0', '确权系统菜单');
INSERT INTO `sys_function` VALUES ('a178033b-964a-4779-b8fa-679458ced98c', '承包地块查询', '/views/dkxx/newdkxx.jsp', '1', '3', '2018-04-06', 'dad3d21d-d784-45f9-a83d-c006d9aa9c9f', '1', '0', null, '1', '0', '承包地块管理');
INSERT INTO `sys_function` VALUES ('a2e2fff3-aa40-47ea-b00e-ac10c989c5f9', '新建', 'user_add', '1', '4', '2018-03-22', 'ebf173d4-16e4-4784-a1ee-acbe7ecb980b', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('a7f3cf9a-16b3-4b3e-b484-c5c0db53bffd', '县级系统', null, '2', '0', '2018-04-10', '1', '1', '0', null, '2', '0', '');
INSERT INTO `sys_function` VALUES ('bb688b71-731a-4de0-ba7a-8a7f71cd61c8', '添加发包方信息', 'fbf/addFbf?flag=1', '2', '3', '2018-03-21', '3a33a279-2873-4112-a56c-15de8ca34444', '1', '0', null, '1', '0', '发包方信息管理');
INSERT INTO `sys_function` VALUES ('bc74183a-e3f1-44da-9ae0-082181900059', '菜单管理', '/views/system/menu.jsp', '3', '3', '2018-03-20', '052451f3-7e95-4642-9599-5a57709b6ead', '1', '0', null, '1', '0', '系统管理');
INSERT INTO `sys_function` VALUES ('d192e643-5a31-4b79-91e6-0ec6c4c6bdaa', '职位查询', '/job/selectJob', '1', '3', '2018-03-21', '9d17d3ab-1fb4-4743-acda-81687ad137d1', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('dad3d21d-d784-45f9-a83d-c006d9aa9c9f', '承包地块管理', '#', '8', '2', '2018-04-06', '32321-ffcc-dcbd-32ff2', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('e5640184-f4cf-4416-9b1d-e82479cd9ca6', '新建', 'role_add', '1', '4', '2018-03-22', '620a490e-e0ed-4df0-adae-431aebde6ad0', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('ea1c105a-6483-4b05-8d71-ecc5d421d4a1', '角色授权', 'role_authorize', '4', '4', '2018-03-22', '620a490e-e0ed-4df0-adae-431aebde6ad0', '1', '0', null, '1', '0', '');
INSERT INTO `sys_function` VALUES ('eb36ebf6-4f79-4dbb-ac34-531a1d829d78', '主页', '#', '1', '2', '2018-03-19', '32321-ffcc-dcbd-32ff2', '1', '0', 'fa fa-home', '1', '0', '确权系统菜单');
INSERT INTO `sys_function` VALUES ('ebf173d4-16e4-4784-a1ee-acbe7ecb980b', '用户管理', '/views/system/userControl.jsp', '1', '3', '2018-03-20', '052451f3-7e95-4642-9599-5a57709b6ead', '1', '0', null, '1', '0', '系统管理');
INSERT INTO `sys_function` VALUES ('fea8bb8a-2be1-4091-9ffe-79b1729d9713', '发包方信息查询', '/fbf/selectFbf', '1', '3', '2018-03-21', '3a33a279-2873-4112-a56c-15de8ca34444', '1', '0', null, '1', '0', '');

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `ID` varchar(50) NOT NULL,
  `ORG_NAME` varchar(100) DEFAULT NULL,
  `ORG_TEL` varchar(50) DEFAULT NULL,
  `ORG_ADDRESS` varchar(255) DEFAULT NULL,
  `ORG_CODE` varchar(100) DEFAULT NULL,
  `ORG_STATUS` varchar(1) DEFAULT NULL,
  `ORG_BZ` varchar(255) DEFAULT NULL,
  `ORG_CREATEUSER` varchar(100) DEFAULT NULL,
  `CREATETIME` date DEFAULT NULL,
  `ORG_REGION_ID` varchar(50) DEFAULT NULL,
  `PID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_org
-- ----------------------------

-- ----------------------------
-- Table structure for sys_org_user_r
-- ----------------------------
DROP TABLE IF EXISTS `sys_org_user_r`;
CREATE TABLE `sys_org_user_r` (
  `ID` varchar(50) NOT NULL,
  `ORG_ID` varchar(50) DEFAULT NULL,
  `USER_ID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_org_user_r
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ID` varchar(50) NOT NULL,
  `ROLE_NAME` varchar(255) NOT NULL,
  `ROLE_CODE` varchar(255) DEFAULT NULL,
  `CREATETIME` date DEFAULT NULL,
  `CREATEUSER` varchar(255) DEFAULT NULL,
  `SITE_ID` varchar(2) DEFAULT NULL,
  `ROLE_BZ` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('2530e505-c513-4520-ab29-5572b627ed9b', '县级超级管理员', 'xjcjgly', '2018-04-10', '唐僧', '2', 'sd');
INSERT INTO `sys_role` VALUES ('7fde2175-3697-4158-8a17-4853fd9f1629', '普通管理员', '103', '2018-03-18', '唐僧', '1', '大幅度');
INSERT INTO `sys_role` VALUES ('d51c2cef-2feq-6532-8f44-c978457a6f0b', '超级管理员', '104', '2018-03-21', 'lsf', '1', null);
INSERT INTO `sys_role` VALUES ('e2a648b4-bd8d-4c7d-8829-91ff2adeac67', '测试外网角342', '2222222', '2018-03-18', '唐僧', '3', '1121');

-- ----------------------------
-- Table structure for sys_role_func_r
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_func_r`;
CREATE TABLE `sys_role_func_r` (
  `ID` varchar(50) NOT NULL,
  `ROLE_ID` varchar(50) NOT NULL,
  `FUNC_ID` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_func_r
-- ----------------------------
INSERT INTO `sys_role_func_r` VALUES ('034fc75b-972e-4419-96ab-fa45e212ba06', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '516c9f81-8a7a-4f34-8a6e-2e92314eec37');
INSERT INTO `sys_role_func_r` VALUES ('0568c135-e925-4f3c-9513-0dc00ad2f81e', '7fde2175-3697-4158-8a17-4853fd9f1629', 'd192e643-5a31-4b79-91e6-0ec6c4c6bdaa');
INSERT INTO `sys_role_func_r` VALUES ('0ae3c114-f545-4477-80ef-28ab63239f07', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '9d17d3ab-1fb4-4743-acda-81687ad137d1');
INSERT INTO `sys_role_func_r` VALUES ('1107b8a8-7aef-4fdc-959e-d3896b78cf6c', '7fde2175-3697-4158-8a17-4853fd9f1629', '052451f3-7e95-4642-9599-5a57709b6ead');
INSERT INTO `sys_role_func_r` VALUES ('11d18676-9843-4637-88e9-4586ddbdbf6b', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '6e957edc-2b6d-4f67-959c-962bf3203d9c');
INSERT INTO `sys_role_func_r` VALUES ('142bf175-2661-46b0-8003-fda58c2e7e90', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '07fc8924-61b0-4aef-9d88-2685b2840028');
INSERT INTO `sys_role_func_r` VALUES ('16049a7c-fa82-4d0e-a33c-862f5d2478b9', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', 'ebf173d4-16e4-4784-a1ee-acbe7ecb980b');
INSERT INTO `sys_role_func_r` VALUES ('1664b64c-b2ad-453e-92df-a14b0a5c02b9', '2530e505-c513-4520-ab29-5572b627ed9b', 'a7f3cf9a-16b3-4b3e-b484-c5c0db53bffd');
INSERT INTO `sys_role_func_r` VALUES ('1b4099af-9791-4e3c-8df1-48b9b2d67eca', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', 'a2e2fff3-aa40-47ea-b00e-ac10c989c5f9');
INSERT INTO `sys_role_func_r` VALUES ('1dbd1e3e-9677-46f4-9d72-75d77ccebdcf', '7fde2175-3697-4158-8a17-4853fd9f1629', '91c88839-6b7b-4193-bff6-eb79f0d5171b');
INSERT INTO `sys_role_func_r` VALUES ('237f406a-b27e-47bb-86d8-4c2c1da2df88', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', 'a178033b-964a-4779-b8fa-679458ced98c');
INSERT INTO `sys_role_func_r` VALUES ('25162cea-3465-4040-97c2-c62c00ec8f31', '2530e505-c513-4520-ab29-5572b627ed9b', '6564e732-492c-43b6-ad03-6a29bcc9288e');
INSERT INTO `sys_role_func_r` VALUES ('27d0c215-b3ef-4b7c-9dba-6c65771aa755', '7fde2175-3697-4158-8a17-4853fd9f1629', '620a490e-e0ed-4df0-adae-431aebde6ad0');
INSERT INTO `sys_role_func_r` VALUES ('2910a370-7e08-4c1b-80e1-5a1b4111057e', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', 'bb688b71-731a-4de0-ba7a-8a7f71cd61c8');
INSERT INTO `sys_role_func_r` VALUES ('3197f6e5-96e8-48f9-a76d-d164f69e282f', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '865d754f-1d33-4a63-989b-603bdf3b21e7');
INSERT INTO `sys_role_func_r` VALUES ('56c6d550-5c47-4df3-b627-3f912cd581e8', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '052451f3-7e95-4642-9599-5a57709b6ead');
INSERT INTO `sys_role_func_r` VALUES ('5ae12d52-e157-4779-9728-da96c14ac675', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '7810ef01-b89d-4e27-8358-a633f4be84e9');
INSERT INTO `sys_role_func_r` VALUES ('5c478324-90c1-417e-ba62-ba5a8176b2d8', '7fde2175-3697-4158-8a17-4853fd9f1629', '07fc8924-61b0-4aef-9d88-2685b2840028');
INSERT INTO `sys_role_func_r` VALUES ('5c9c3798-0c07-4647-8d13-440cd95b7fc9', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '755be5c5-adcd-4299-8716-96b754a1d887');
INSERT INTO `sys_role_func_r` VALUES ('7fed490c-5ff9-4dce-b5f6-f16c0ca0ff53', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '303959b1-624d-4fd0-81d8-3a83b9b2f1b4');
INSERT INTO `sys_role_func_r` VALUES ('81adfaa4-1416-4d67-816f-51b6eb620630', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '3a33a279-2873-4112-a56c-15de8ca34444');
INSERT INTO `sys_role_func_r` VALUES ('84cb8cdd-b518-4795-a772-740c9d6b5f88', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', 'e5640184-f4cf-4416-9b1d-e82479cd9ca6');
INSERT INTO `sys_role_func_r` VALUES ('8a80aff1-c1d3-4e9b-a622-4d366c559104', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', 'ea1c105a-6483-4b05-8d71-ecc5d421d4a1');
INSERT INTO `sys_role_func_r` VALUES ('8e24dd23-1f8a-4c9e-b302-d0c3acafb45c', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', 'eb36ebf6-4f79-4dbb-ac34-531a1d829d78');
INSERT INTO `sys_role_func_r` VALUES ('8e6de454-0429-433c-a0f8-74a560d99696', '7fde2175-3697-4158-8a17-4853fd9f1629', 'a178033b-964a-4779-b8fa-679458ced98c');
INSERT INTO `sys_role_func_r` VALUES ('9098ca29-d188-4479-9a9c-5e624df42fb7', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '91c88839-6b7b-4193-bff6-eb79f0d5171b');
INSERT INTO `sys_role_func_r` VALUES ('94b63f9e-5c68-45dd-ab14-0e8281dd4370', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '32ef314e-1f92-4bcc-a9f0-7adbe10a81f0');
INSERT INTO `sys_role_func_r` VALUES ('984d05e0-4e46-44c5-98e4-f684d22f3d97', '7fde2175-3697-4158-8a17-4853fd9f1629', 'a2e2fff3-aa40-47ea-b00e-ac10c989c5f9');
INSERT INTO `sys_role_func_r` VALUES ('9dc65212-8101-46db-a8d0-7c3b39fc2a61', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', 'd192e643-5a31-4b79-91e6-0ec6c4c6bdaa');
INSERT INTO `sys_role_func_r` VALUES ('9de6c8bf-4ae1-4b8c-97f5-b32373ca10c6', '7fde2175-3697-4158-8a17-4853fd9f1629', 'dad3d21d-d784-45f9-a83d-c006d9aa9c9f');
INSERT INTO `sys_role_func_r` VALUES ('9e434a4c-d9af-498e-ba0a-60be0f469dcb', '7fde2175-3697-4158-8a17-4853fd9f1629', '6e957edc-2b6d-4f67-959c-962bf3203d9c');
INSERT INTO `sys_role_func_r` VALUES ('a489c00b-338c-4e6d-a206-f78b33f4b75c', '7fde2175-3697-4158-8a17-4853fd9f1629', 'ebf173d4-16e4-4784-a1ee-acbe7ecb980b');
INSERT INTO `sys_role_func_r` VALUES ('a69135ed-b891-4dd4-b562-1ada44987ef1', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '32321-ffcc-dcbd-32ff2');
INSERT INTO `sys_role_func_r` VALUES ('a86626c4-370e-4b80-8bdb-4b247393b973', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', 'fea8bb8a-2be1-4091-9ffe-79b1729d9713');
INSERT INTO `sys_role_func_r` VALUES ('b1556bd2-b804-4a2b-a965-c65e678e12b9', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '40d83d31-6b3f-48f5-9c89-eda532d28d42');
INSERT INTO `sys_role_func_r` VALUES ('b1c2a6a6-eac9-4908-ab96-f84d5154f395', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '59e1a0eb-3c56-4cdb-9f5a-3630d5daf81b');
INSERT INTO `sys_role_func_r` VALUES ('b4616478-e5c5-4f13-826c-70526723d564', '7fde2175-3697-4158-8a17-4853fd9f1629', 'bc74183a-e3f1-44da-9ae0-082181900059');
INSERT INTO `sys_role_func_r` VALUES ('b6fde49e-d657-4f9b-9db7-7d35c01be03c', '7fde2175-3697-4158-8a17-4853fd9f1629', 'eb36ebf6-4f79-4dbb-ac34-531a1d829d78');
INSERT INTO `sys_role_func_r` VALUES ('b85aa238-f946-479d-9970-e84cea9d05dc', '7fde2175-3697-4158-8a17-4853fd9f1629', '865d754f-1d33-4a63-989b-603bdf3b21e7');
INSERT INTO `sys_role_func_r` VALUES ('bb710a50-f6cf-4010-83b3-d44b84486369', '7fde2175-3697-4158-8a17-4853fd9f1629', '6bcb1eb7-5d54-4819-ab2c-a27025487c74');
INSERT INTO `sys_role_func_r` VALUES ('cee3509e-59e0-44c0-98dc-c2c10ef1d2be', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', 'dad3d21d-d784-45f9-a83d-c006d9aa9c9f');
INSERT INTO `sys_role_func_r` VALUES ('d668f500-451a-4876-a03c-3b822fc12bde', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '5cf182ed-4c77-45fa-b46f-23dd716e6913');
INSERT INTO `sys_role_func_r` VALUES ('db355c42-82cb-4743-b696-778aed55aea8', '7fde2175-3697-4158-8a17-4853fd9f1629', 'e5640184-f4cf-4416-9b1d-e82479cd9ca6');
INSERT INTO `sys_role_func_r` VALUES ('dd82b0e3-fe8f-4da9-93d9-d53423015fe1', '7fde2175-3697-4158-8a17-4853fd9f1629', '9d17d3ab-1fb4-4743-acda-81687ad137d1');
INSERT INTO `sys_role_func_r` VALUES ('ed210841-e689-44a7-903e-74c5506ccbab', '7fde2175-3697-4158-8a17-4853fd9f1629', '303959b1-624d-4fd0-81d8-3a83b9b2f1b4');
INSERT INTO `sys_role_func_r` VALUES ('fb59e775-8f05-4927-860d-e7399d22fdef', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '46df3654-25b4-4ee8-ac97-848b58bcb849');
INSERT INTO `sys_role_func_r` VALUES ('fd427470-3121-4112-9be9-87ba330aa13f', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '6bcb1eb7-5d54-4819-ab2c-a27025487c74');
INSERT INTO `sys_role_func_r` VALUES ('fe10c261-6c18-438e-842d-6155bbacd307', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', '620a490e-e0ed-4df0-adae-431aebde6ad0');
INSERT INTO `sys_role_func_r` VALUES ('fea24431-789d-4701-8180-1e7c407c1fea', 'd51c2cef-2feq-6532-8f44-c978457a6f0b', 'bc74183a-e3f1-44da-9ae0-082181900059');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` varchar(50) NOT NULL DEFAULT '',
  `USER_NAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `USER_TYPE` varchar(10) DEFAULT NULL,
  `CREATEUSER` varchar(100) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `CREATETIME` date DEFAULT NULL,
  `TEL` varchar(20) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `NICK_NAME` varchar(255) DEFAULT NULL,
  `xzdw_id` varchar(20) DEFAULT NULL,
  `xzdw_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_NAME` (`USER_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1c6fffee-3819-42c5-bd17-5e44077ad4c8', 'zs', '7d3016987f88fd29b7c66a7b6f3473ef', '1', '唐僧', '1', '2018-03-27', '1', '1', '张三', '370000', '');
INSERT INTO `sys_user` VALUES ('730fd6b1-1941-434d-8393-61994034cb3b', 'xj', 'e3dad23f8077ac71a220dbeb2e54cccb', '1', '唐僧', '平罗县', '2018-04-10', '1111111111', '1', '平罗县', '100000', null);
INSERT INTO `sys_user` VALUES ('76f9d7ac-e689-49be-9392-112da32ac3d7', 'lsf', 'a0423401eb4e4b34458892e0a4750521', '1', '唐僧', '北京海淀', '2018-03-17', '1111', '1', '孙悟空', '230800', '');
INSERT INTO `sys_user` VALUES ('7d0a4b0e-66ed-4a4c-8775-601bb823c240', 'ls', '125399f88c818fe0eb0682695d2cda74', '1', '唐僧', '11', '2018-03-27', '1', '1', '李四', '', '');
INSERT INTO `sys_user` VALUES ('824ac9f6-add4-4741-973e-b4af032b443f', 'lsf123', '2de3526c0044092cc4890a5e70c09757', '1', '唐僧', '111', '2018-04-06', '1111111', '1', '11111', '370200', null);
INSERT INTO `sys_user` VALUES ('d51c2cef-2e0f-4326-8f44-c978457a6f0b', 'admin', '5e74ee72a39011411beaeb797d44893a', '1', 'admin', '北京', '2018-03-13', '1111111111', '1', '唐僧', '230100', '');
INSERT INTO `sys_user` VALUES ('e35eaf63-695f-49c7-b55e-369c73c6b0fd', 'ww', 'd318782314a88b2e3a6e9213729b5fdc', '1', '唐僧', '1', '2018-03-27', '1', '1', '王五', '', '');

-- ----------------------------
-- Table structure for sys_user_role_r
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_r`;
CREATE TABLE `sys_user_role_r` (
  `ID` varchar(50) NOT NULL,
  `USER_ID` varchar(50) NOT NULL,
  `ROLE_ID` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role_r
-- ----------------------------
INSERT INTO `sys_user_role_r` VALUES ('08ecce6f-1a91-4a1b-a0e9-0a7d7a5e2a80', '7d0a4b0e-66ed-4a4c-8775-601bb823c240', '7fde2175-3697-4158-8a17-4853fd9f1629');
INSERT INTO `sys_user_role_r` VALUES ('21394726-59bd-481c-888e-cf1a6ffb9ad6', 'e35eaf63-695f-49c7-b55e-369c73c6b0fd', '7fde2175-3697-4158-8a17-4853fd9f1629');
INSERT INTO `sys_user_role_r` VALUES ('9210d9d5-91ee-485b-bc88-048b9f87cf2b', '730fd6b1-1941-434d-8393-61994034cb3b', '2530e505-c513-4520-ab29-5572b627ed9b');
INSERT INTO `sys_user_role_r` VALUES ('adf8195b-8774-45ff-8a96-9880f794d184', '1c6fffee-3819-42c5-bd17-5e44077ad4c8', '7fde2175-3697-4158-8a17-4853fd9f1629');
INSERT INTO `sys_user_role_r` VALUES ('c1bdbf03-e51d-46cc-b454-b2b714f265fc', '76f9d7ac-e689-49be-9392-112da32ac3d7', '7fde2175-3697-4158-8a17-4853fd9f1629');
INSERT INTO `sys_user_role_r` VALUES ('f5000ca5-b23a-41b2-94d3-ed7428661670', 'd51c2cef-2e0f-4326-8f44-c978457a6f0b', 'd51c2cef-2feq-6532-8f44-c978457a6f0b');
