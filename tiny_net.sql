/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100414
 Source Host           : localhost:3306
 Source Schema         : tiny_net

 Target Server Type    : MySQL
 Target Server Version : 100414
 File Encoding         : 65001

 Date: 28/05/2021 17:48:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for abschille
-- ----------------------------
DROP TABLE IF EXISTS `abschille`;
CREATE TABLE `abschille`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedHeatPower` double NOT NULL,
  `ratedCoolPower` double NOT NULL,
  `copHeat` double NOT NULL,
  `copCool` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of abschille
-- ----------------------------
INSERT INTO `abschille` VALUES (1, '1', 0, 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for all_type
-- ----------------------------
DROP TABLE IF EXISTS `all_type`;
CREATE TABLE `all_type`  (
  `table_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `detail` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`table_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of all_type
-- ----------------------------
INSERT INTO `all_type` VALUES ('battery', 'name(型号名称,string)|eddy(额定电压(V),double)|xhcfdxl(循环充放电效率(%),double)|zdcdsl(最大充电速率,double)|zdcddl(最大充电电流(A),double)|zdfdsl(最大放电速率,double)|dcrl(电池容量(Ah),double)|life(寿命（年）,double)|qsmfd(全寿命放电量(kWh),double)|clgs(串联个数,int)|factory(制造商,string)|type(类型,int)|capacity1(个数1,int)|capacity2(个数2,int)|capacity3(个数3,int)|capacity4(个数4,int)|cjcb1(初建成本1（元）,double)|cjcb2(初建成本2（元）,double)|cjcb3(初建成本3（元）,double)|cjcb4(初建成本4（元）,double)|gxcb1(更新成本1（元）,double)|gxcb2(更新成本2（元）,double)|gxcb3(更新成本3（元）,double)|gxcb4(更新成本4（元）,double)|yxwhcb1(运行维护成本1（元/年）,double)|yxwhcb2(运行维护成本2（元/年）,double)|yxwhcb3(运行维护成本3（元/年）,double)|yxwhcb4(运行维护成本4（元/年）,double)');

-- ----------------------------
-- Table structure for battery
-- ----------------------------
DROP TABLE IF EXISTS `battery`;
CREATE TABLE `battery`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedVoltage` double NOT NULL,
  `roundTridEfficiency` double NOT NULL,
  `maximumChargeRate` double NOT NULL,
  `maximumChargeCurrent` double NOT NULL,
  `constRate` double NOT NULL,
  `maximumCapacity` double NOT NULL,
  `floatLife` double NOT NULL,
  `lifeTimeThroughput` double NOT NULL,
  `dAtype` int NOT NULL,
  `numberofBattery` int NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of battery
-- ----------------------------
INSERT INTO `battery` VALUES (3, '3', 0, 2, 0, 2, 0, 2, 0, 2, 0, 1, '0', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `battery` VALUES (4, '4', 0, 2, 0, 2, 0, 2, 0, 2, 0, 4, '0', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `battery` VALUES (5, '5', 0, 1, 0, 1, 0, 1, 0, 1, 0, 5, '0', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `battery` VALUES (6, 'lzw', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '0', 5, 1, 100, 10000, 34, 1, 10000, 1000000, 2, 1, 10000, 1000000, 1, 1, 10000, 1000000, 'lzw');
INSERT INTO `battery` VALUES (7, '6', 0, 32, 0, 32, 0, 32, 0, 32, 0, 6, '0', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `battery` VALUES (8, '7', 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, '0', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `battery` VALUES (9, '8', 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, '0', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `battery` VALUES (21, '电池2号', 1, 1.1, 1.1, 1.1, 1.1, 200, 10, 1.1, 1, 0, '1', 0, 1, 100, 10000, 0, 200, 20000, 2000000, 0, 160, 16000, 1600000, 0, 0, 0, 0, 'lzw');
INSERT INTO `battery` VALUES (22, '2', 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, '0', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `battery` VALUES (23, 'lzw3232', 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, '0', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `battery` VALUES (24, '333', 0, 0, 0, 0, 0, 0, 0, 0, 0, 333, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `battery` VALUES (25, '666', 0, 0, 0, 0, 0, 0, 0, 0, 0, 666, '0', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `battery` VALUES (27, 'lpf', 1, 1, 1, 1, 2, 3, 4, 5, 6, 0, '0', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `battery` VALUES (28, '222', 0, 0, 0, 0, 0, 0, 0, 0, 0, 222, '0', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for centrifugal_electricitychiller
-- ----------------------------
DROP TABLE IF EXISTS `centrifugal_electricitychiller`;
CREATE TABLE `centrifugal_electricitychiller`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedPower` double NOT NULL,
  `powerFactor` double NOT NULL,
  `cop` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` double NOT NULL,
  `numberOrCapacity2` double NOT NULL,
  `numberOrCapacity3` double NOT NULL,
  `numberOrCapacity4` double NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of centrifugal_electricitychiller
-- ----------------------------
INSERT INTO `centrifugal_electricitychiller` VALUES (1, '1', 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for cool_storage
-- ----------------------------
DROP TABLE IF EXISTS `cool_storage`;
CREATE TABLE `cool_storage`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `efficiencycharge` double NOT NULL,
  `efficiencydischarge` double NOT NULL,
  `maxchargerate` double NOT NULL,
  `maxdischargerate` double NOT NULL,
  `decay` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` double(11, 0) NOT NULL,
  `numberOrCapacity2` double(11, 0) NOT NULL,
  `numberOrCapacity3` double(11, 0) NOT NULL,
  `numberOrCapacity4` double(11, 0) NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cool_storage
-- ----------------------------
INSERT INTO `cool_storage` VALUES (1, '1', 0, 0, 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `cool_storage` VALUES (2, '1', 0, 2, 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for diesel
-- ----------------------------
DROP TABLE IF EXISTS `diesel`;
CREATE TABLE `diesel`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedCapacity` double NOT NULL,
  `minimumLoadRate` double NOT NULL,
  `minimumRunningTime` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `percentofCO2` double NOT NULL,
  `percentofCO` double NOT NULL,
  `percentofUnburned` double NOT NULL,
  `percentofMatter` double NOT NULL,
  `percentofNO` double NOT NULL,
  `percentofSO2` double NOT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fuelPrice` int NOT NULL DEFAULT 3,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `fDieselPower` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fuelConsumption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diesel
-- ----------------------------
INSERT INTO `diesel` VALUES (7, '1', 0, 0, 0, 0, '1', 0, 0, 0, 0, 0, 0, '0', 3, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '1,2,3,', '2,3,4,', 'lzw');

-- ----------------------------
-- Table structure for elec_aircondition
-- ----------------------------
DROP TABLE IF EXISTS `elec_aircondition`;
CREATE TABLE `elec_aircondition`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedIcePower` double NOT NULL,
  `rateCoolPower` double NOT NULL,
  `icePowerFactor` double NOT NULL,
  `coolPowerFactor` double NOT NULL,
  `copIce` double NOT NULL,
  `copCool` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` double NOT NULL,
  `numberOrCapacity2` double NOT NULL,
  `numberOrCapacity3` double NOT NULL,
  `numberOrCapacity4` double NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of elec_aircondition
-- ----------------------------
INSERT INTO `elec_aircondition` VALUES (1, '1', 0, 0, 0, 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for elec_boiler
-- ----------------------------
DROP TABLE IF EXISTS `elec_boiler`;
CREATE TABLE `elec_boiler`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedPower` double NOT NULL,
  `cop` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of elec_boiler
-- ----------------------------
INSERT INTO `elec_boiler` VALUES (1, '1', 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for electricitychiller
-- ----------------------------
DROP TABLE IF EXISTS `electricitychiller`;
CREATE TABLE `electricitychiller`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedPower` double NOT NULL,
  `cop` double NOT NULL,
  `powerFactor` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` double NOT NULL,
  `numberOrCapacity2` double NOT NULL,
  `numberOrCapacity3` double NOT NULL,
  `numberOrCapacity4` double NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of electricitychiller
-- ----------------------------
INSERT INTO `electricitychiller` VALUES (1, '1', 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for gas_abschille
-- ----------------------------
DROP TABLE IF EXISTS `gas_abschille`;
CREATE TABLE `gas_abschille`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedHeatPower` double NOT NULL,
  `ratedCoolPower` double NOT NULL,
  `copHeat` double NOT NULL,
  `copCool` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gas_abschille
-- ----------------------------
INSERT INTO `gas_abschille` VALUES (1, '1', 0, 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for gas_boiler
-- ----------------------------
DROP TABLE IF EXISTS `gas_boiler`;
CREATE TABLE `gas_boiler`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedPower` double NOT NULL,
  `efficiency` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of gas_boiler
-- ----------------------------
INSERT INTO `gas_boiler` VALUES (2, '', 0, 0, 0, '一一亿元', 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 0, 0, 0, 'lzw');
INSERT INTO `gas_boiler` VALUES (3, '1', 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for gas_steam_boiler
-- ----------------------------
DROP TABLE IF EXISTS `gas_steam_boiler`;
CREATE TABLE `gas_steam_boiler`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedPower` double NOT NULL,
  `efficiency` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of gas_steam_boiler
-- ----------------------------
INSERT INTO `gas_steam_boiler` VALUES (1, '1', 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for gas_turbine
-- ----------------------------
DROP TABLE IF EXISTS `gas_turbine`;
CREATE TABLE `gas_turbine`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedCapacity` double NOT NULL,
  `minimumLoadRate` double NOT NULL,
  `efficiency` double NOT NULL,
  `smoke` double NOT NULL,
  `lifeTime` double NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `fGasPower` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gasConsumption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of gas_turbine
-- ----------------------------
INSERT INTO `gas_turbine` VALUES (3, '11', 0, 20, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '10', '10', 'lzw');
INSERT INTO `gas_turbine` VALUES (4, '2', 1, 1, 1, 1, 1, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '10', '10', 'lzw');
INSERT INTO `gas_turbine` VALUES (5, '1', 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '10', '20', 'lzw');
INSERT INTO `gas_turbine` VALUES (6, '1', 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '1,', '1,', 'lzw');
INSERT INTO `gas_turbine` VALUES (7, '6', 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '2,', '4,', 'lzw');

-- ----------------------------
-- Table structure for heat_exchanger
-- ----------------------------
DROP TABLE IF EXISTS `heat_exchanger`;
CREATE TABLE `heat_exchanger`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedPower` double NOT NULL,
  `efficiency` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of heat_exchanger
-- ----------------------------
INSERT INTO `heat_exchanger` VALUES (1, '1', 0, 0, 0, '1', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'lzw');

-- ----------------------------
-- Table structure for heat_storage
-- ----------------------------
DROP TABLE IF EXISTS `heat_storage`;
CREATE TABLE `heat_storage`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `efficiencycharge` double NOT NULL,
  `efficiencydischarge` double NOT NULL,
  `maxchargerate` double NOT NULL,
  `maxdischargerate` double NOT NULL,
  `decay` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` double(11, 0) NOT NULL,
  `numberOrCapacity2` double(11, 0) NOT NULL,
  `numberOrCapacity3` double(11, 0) NOT NULL,
  `numberOrCapacity4` double(11, 0) NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of heat_storage
-- ----------------------------
INSERT INTO `heat_storage` VALUES (1, '1', 0, 0, 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `heat_storage` VALUES (2, '2', 0, 0, 0, 0, 0, 0, '2', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for hydro_turbine
-- ----------------------------
DROP TABLE IF EXISTS `hydro_turbine`;
CREATE TABLE `hydro_turbine`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `netWaterhead` double NOT NULL,
  `ratedPower` double NOT NULL,
  `hTefficiency` double NOT NULL,
  `generatorefficiency` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of hydro_turbine
-- ----------------------------
INSERT INTO `hydro_turbine` VALUES (1, '1', 1, 1, 1, 1, 1, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `hydro_turbine` VALUES (2, '2', 0, 0, 0, 0, 0, '2', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `hydro_turbine` VALUES (5, '3', 0, 0, 0, 0, 0, '3', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for internal_gas_turbine
-- ----------------------------
DROP TABLE IF EXISTS `internal_gas_turbine`;
CREATE TABLE `internal_gas_turbine`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedCapacity` double NOT NULL,
  `minimumLoadRate` double NOT NULL,
  `water` double NOT NULL,
  `smoke` double NOT NULL,
  `lifeTime` double NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `fInternalGasPower` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `InternalgasConsumption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of internal_gas_turbine
-- ----------------------------
INSERT INTO `internal_gas_turbine` VALUES (1, '1', 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '10', '20', 'lzw');
INSERT INTO `internal_gas_turbine` VALUES (2, '2', 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '2,', '3,', 'lzw');

-- ----------------------------
-- Table structure for nuclear_power
-- ----------------------------
DROP TABLE IF EXISTS `nuclear_power`;
CREATE TABLE `nuclear_power`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `minimulLoadRate` double NOT NULL,
  `generationMaxrate` double NOT NULL,
  `fmFactor` double NOT NULL,
  `nuclearFuelPrice` double NOT NULL,
  `nuclearFuelNumber` double NOT NULL,
  `nuclearFuelRep` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nuclear_power
-- ----------------------------
INSERT INTO `nuclear_power` VALUES (1, '1', 0, 0, 0, 0, 0, 0, 0, '1', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'lzw');

-- ----------------------------
-- Table structure for photovoltaic
-- ----------------------------
DROP TABLE IF EXISTS `photovoltaic`;
CREATE TABLE `photovoltaic`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `deratingFactor` double NOT NULL,
  `decayFactor` double NOT NULL,
  `efficiency` double NOT NULL,
  `temperatureCoefficient` double NOT NULL,
  `nominalOperatingCellTemperature` double NOT NULL,
  `absorptivity` double NOT NULL,
  `batteryTemperInStc` double NOT NULL,
  `noctEnvirTemper` double NOT NULL,
  `noctRadiation` double NOT NULL,
  `dAtype` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of photovoltaic
-- ----------------------------
INSERT INTO `photovoltaic` VALUES (1, '1', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `photovoltaic` VALUES (2, '2', 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, '2', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');
INSERT INTO `photovoltaic` VALUES (4, '3', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '3', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for pump
-- ----------------------------
DROP TABLE IF EXISTS `pump`;
CREATE TABLE `pump`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `copHeat` double NOT NULL,
  `copCool` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedHeatPower` double NOT NULL,
  `ratedCoolPower` double NOT NULL,
  `lifeTime` double NOT NULL,
  `heatPowerFactor` double NOT NULL,
  `coolPowerFactor` double NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pump
-- ----------------------------
INSERT INTO `pump` VALUES (1, '1', 0, 0, '1', 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` int NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `input` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `output` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of record
-- ----------------------------

-- ----------------------------
-- Table structure for screw_electricitychiller
-- ----------------------------
DROP TABLE IF EXISTS `screw_electricitychiller`;
CREATE TABLE `screw_electricitychiller`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedPower` double NOT NULL,
  `powerFactor` double NOT NULL,
  `cop` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` double NOT NULL,
  `numberOrCapacity2` double NOT NULL,
  `numberOrCapacity3` double NOT NULL,
  `numberOrCapacity4` double NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of screw_electricitychiller
-- ----------------------------
INSERT INTO `screw_electricitychiller` VALUES (1, '1', 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int NULL DEFAULT 0,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '$2a$10$Hk0Qq9OzH3ZlTcf60pKvBuSX5M4FX4cztuh6VzfN54zjOj8PhZqbS', 0);
INSERT INTO `user` VALUES ('2', '$2a$10$KmbjY9H.b6lzuM59MKKRR.aALkm4mEJmAKIq0fcl6tWoXUoZr0fkq', 0);
INSERT INTO `user` VALUES ('3', '$2a$10$E/Zf9phySR1X/FrVxNSruOjEalxLIt1dggWznklhU.t4.m9oJ0cSC', 0);
INSERT INTO `user` VALUES ('4', '$2a$10$B54VZXAwmF7UjA5z7Hskc.kkEPfQrgeJ2QlJbvu6B6Sq/FB7ZQo82', 0);
INSERT INTO `user` VALUES ('admin', '$2a$10$PWlQ47z1DU81oikNIclDUOnwhW0BJwwlNc.RUEXgn48RtlSsU.IQ6', 0);
INSERT INTO `user` VALUES ('admin1', '$2a$10$ryGSx54Kxd5cdDnkXH4zH.uhpFiEiaNW8yUxmYgiYWCrQtE6dv.RK', 0);
INSERT INTO `user` VALUES ('lee', '$2a$10$9uI5SrQJBJrLQUXBCtmPveSNOTNiQh5pWGbPboC5eAcOCa0m8Cu8q', 0);
INSERT INTO `user` VALUES ('leee1', '$2a$10$8XeWeABGz.7Zip.WiDT3..5kOA6GhurbczlJ67fv/YpEGuDcPWbvu', 0);
INSERT INTO `user` VALUES ('leee2', '$2a$10$sRvQkeIZ6.YnL2coZ1HLEOscMgqa5Uqgz1ftqSdM9NZw5/9n5oFsK', 0);
INSERT INTO `user` VALUES ('lzw', '$2a$10$pzLmd/fIZjzHBXFCDRyKW.HcWOdRoUVVtWn2pFnRAvSukRU1XMkc.', 0);
INSERT INTO `user` VALUES ('shiro', '123456', 0);
INSERT INTO `user` VALUES ('test', '$2a$10$K2n5vansoEGaICBWRMUbV.r2dd8wglil/fxgfbiBWQ1lg2icF18ia', 1);
INSERT INTO `user` VALUES ('tinynet1', '$2a$10$h5CJYJEnmAHfgb1OdDH7k.acNF9FOCg2qwLQ3rderqA7y2pK6R/5S', 0);

-- ----------------------------
-- Table structure for waste_heat_boiler
-- ----------------------------
DROP TABLE IF EXISTS `waste_heat_boiler`;
CREATE TABLE `waste_heat_boiler`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `efficiency` double NOT NULL,
  `ratedPower` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of waste_heat_boiler
-- ----------------------------
INSERT INTO `waste_heat_boiler` VALUES (1, '1', 0, 0, 0, '1', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'lzw');

-- ----------------------------
-- Table structure for wind_turbine
-- ----------------------------
DROP TABLE IF EXISTS `wind_turbine`;
CREATE TABLE `wind_turbine`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedPower` double NOT NULL,
  `hubHeight` double NOT NULL,
  `lifeTime` double NOT NULL,
  `manufacturer` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dAtype` int NOT NULL,
  `decayFactor` double NOT NULL DEFAULT 20,
  `numberOrCapacity1` int NOT NULL,
  `numberOrCapacity2` int NOT NULL,
  `numberOrCapacity3` int NOT NULL,
  `numberOrCapacity4` int NOT NULL,
  `capitalCurve1` double NOT NULL,
  `capitalCurve2` double NOT NULL,
  `capitalCurve3` double NOT NULL,
  `capitalCurve4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintainCost1` double NOT NULL,
  `maintainCost2` double NOT NULL,
  `maintainCost3` double NOT NULL,
  `maintainCost4` double NOT NULL,
  `fWindSpeed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fPower` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of wind_turbine
-- ----------------------------
INSERT INTO `wind_turbine` VALUES (1, '1', 0, 0, 0, '1', 1, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '1,2,3,', '1,2,3,', 'lzw');
INSERT INTO `wind_turbine` VALUES (2, '2', 0, 0, 0, '1', 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '1,2,3,', '1,2,3,', 'lzw');
INSERT INTO `wind_turbine` VALUES (5, '3', 0, 0, 0, '3', 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '1,2,3,', '1,2,3,', 'lzw');

SET FOREIGN_KEY_CHECKS = 1;
