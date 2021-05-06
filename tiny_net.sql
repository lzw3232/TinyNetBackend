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

 Date: 06/05/2021 23:37:19
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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hydro_turbine
-- ----------------------------
DROP TABLE IF EXISTS `hydro_turbine`;
CREATE TABLE `hydro_turbine`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `netWaterhead` double NOT NULL,
  `ratedPower` double NOT NULL,
  `HTefficiency` double NOT NULL,
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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

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
  `internalgasConsumption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

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
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `DAtype` double NOT NULL,
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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
-- Table structure for screw_electricitychiller
-- ----------------------------
DROP TABLE IF EXISTS `screw_electricitychiller`;
CREATE TABLE `screw_electricitychiller`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ratedPower` double NOT NULL,
  `powerFactor` double NOT NULL,
  `COP` double NOT NULL,
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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `owner` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
