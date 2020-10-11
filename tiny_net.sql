-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1
-- 生成日期： 2020-10-11 16:44:39
-- 服务器版本： 10.4.14-MariaDB
-- PHP 版本： 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `tiny_net`
--

-- --------------------------------------------------------

--
-- 表的结构 `all_type`
--

CREATE TABLE `all_type` (
  `table_name` varchar(200) NOT NULL,
  `detail` varchar(3000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `all_type`
--

INSERT INTO `all_type` (`table_name`, `detail`) VALUES
('battery', 'name(型号名称,string)|eddy(额定电压(V),double)|xhcfdxl(循环充放电效率(%),double)|zdcdsl(最大充电速率,double)|zdcddl(最大充电电流(A),double)|zdfdsl(最大放电速率,double)|dcrl(电池容量(Ah),double)|life(寿命（年）,double)|qsmfd(全寿命放电量(kWh),double)|clgs(串联个数,int)|factory(制造商,string)|type(类型,int)|capacity1(个数1,int)|capacity2(个数2,int)|capacity3(个数3,int)|capacity4(个数4,int)|cjcb1(初建成本1（元）,double)|cjcb2(初建成本2（元）,double)|cjcb3(初建成本3（元）,double)|cjcb4(初建成本4（元）,double)|gxcb1(更新成本1（元）,double)|gxcb2(更新成本2（元）,double)|gxcb3(更新成本3（元）,double)|gxcb4(更新成本4（元）,double)|yxwhcb1(运行维护成本1（元/年）,double)|yxwhcb2(运行维护成本2（元/年）,double)|yxwhcb3(运行维护成本3（元/年）,double)|yxwhcb4(运行维护成本4（元/年）,double)');

-- --------------------------------------------------------

--
-- 表的结构 `battery`
--

CREATE TABLE `battery` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `eddy` double NOT NULL,
  `xhcfdxl` double NOT NULL,
  `zdcdsl` double NOT NULL,
  `zdcddl` double NOT NULL,
  `zdfdsl` double NOT NULL,
  `dcrl` double NOT NULL,
  `life` double NOT NULL,
  `qsmfd` double NOT NULL,
  `clgs` int(11) NOT NULL,
  `factory` varchar(100) NOT NULL,
  `type` int(11) NOT NULL,
  `capacity1` int(11) NOT NULL,
  `capacity2` int(11) NOT NULL,
  `capacity3` int(11) NOT NULL,
  `capacity4` int(11) NOT NULL,
  `cjcb1` double NOT NULL,
  `cjcb2` double NOT NULL,
  `cjcb3` double NOT NULL,
  `cjcb4` double NOT NULL,
  `gxcb1` double NOT NULL,
  `gxcb2` double NOT NULL,
  `gxcb3` double NOT NULL,
  `gxcb4` double NOT NULL,
  `yxwhcb1` double NOT NULL,
  `yxwhcb2` double NOT NULL,
  `yxwhcb3` double NOT NULL,
  `yxwhcb4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `battery`
--

INSERT INTO `battery` (`id`, `name`, `eddy`, `xhcfdxl`, `zdcdsl`, `zdcddl`, `zdfdsl`, `dcrl`, `life`, `qsmfd`, `clgs`, `factory`, `type`, `capacity1`, `capacity2`, `capacity3`, `capacity4`, `cjcb1`, `cjcb2`, `cjcb3`, `cjcb4`, `gxcb1`, `gxcb2`, `gxcb3`, `gxcb4`, `yxwhcb1`, `yxwhcb2`, `yxwhcb3`, `yxwhcb4`, `owner`) VALUES
(3, '3', 0, 2, 0, 2, 0, 2, 0, 2, 0, '1', 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(4, '4', 0, 2, 0, 2, 0, 2, 0, 2, 0, '4', 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(5, '5', 0, 1, 0, 1, 0, 1, 0, 1, 0, '5', 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(6, 'lzw', 0, 0, 0, 0, 0, 0, 0, 0, 0, 'lzw', 0, 5, 1, 100, 10000, 34, 1, 10000, 1000000, 2, 1, 10000, 1000000, 1, 1, 10000, 1000000, 'lzw'),
(7, '6', 0, 32, 0, 32, 0, 32, 0, 32, 0, '6', 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(8, '7', 0, 0, 0, 0, 0, 0, 0, 0, 0, '7', 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(9, '8', 0, 0, 0, 0, 0, 0, 0, 0, 0, '8', 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(21, '电池2号', 1, 1.1, 1.1, 1.1, 1.1, 200, 10, 1.1, 1, '电池制造2厂', 1, 0, 1, 100, 10000, 0, 200, 20000, 2000000, 0, 160, 16000, 1600000, 0, 0, 0, 0, 'lzw'),
(22, '2', 0, 0, 0, 0, 0, 0, 0, 0, 0, '2', 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(23, 'lzw3232', 0, 0, 0, 0, 0, 0, 0, 0, 0, '32', 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(24, '333', 0, 0, 0, 0, 0, 0, 0, 0, 0, '333', 1, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(25, '666', 0, 0, 0, 0, 0, 0, 0, 0, 0, '666', 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(27, 'lpf', 1, 1, 1, 1, 2, 3, 4, 5, 6, 'lpf', 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(28, '222', 0, 0, 0, 0, 0, 0, 0, 0, 0, '222', 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `centrifugal`
--

CREATE TABLE `centrifugal` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `power` double NOT NULL,
  `costRate` double NOT NULL,
  `loadRate` double NOT NULL,
  `life` double NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `number1` double NOT NULL,
  `number2` double NOT NULL,
  `number3` double NOT NULL,
  `number4` double NOT NULL,
  `newCost1` double NOT NULL,
  `newCost2` double NOT NULL,
  `newCost3` double NOT NULL,
  `newCost4` double NOT NULL,
  `updateCost1` double NOT NULL,
  `updateCost2` double NOT NULL,
  `updateCost3` double NOT NULL,
  `updateCost4` double NOT NULL,
  `runCost1` double NOT NULL,
  `runCost2` double NOT NULL,
  `runCost3` double NOT NULL,
  `runCost4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `centrifugal`
--

INSERT INTO `centrifugal` (`id`, `name`, `power`, `costRate`, `loadRate`, `life`, `manufacturer`, `number1`, `number2`, `number3`, `number4`, `newCost1`, `newCost2`, `newCost3`, `newCost4`, `updateCost1`, `updateCost2`, `updateCost3`, `updateCost4`, `runCost1`, `runCost2`, `runCost3`, `runCost4`, `owner`) VALUES
(1, '1', 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `direct_fired_lithium_bromide`
--

CREATE TABLE `direct_fired_lithium_bromide` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `heatingEnergyEfficiencyRatio` double NOT NULL,
  `refrigerationEnergyEfficiencyRatio` double NOT NULL,
  `ratedHeatingPower` double NOT NULL,
  `ratedCoolingPower` double NOT NULL,
  `life` double NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `numberOfUnits1` int(11) NOT NULL,
  `numberOfUnits2` int(11) NOT NULL,
  `numberOfUnits3` int(11) NOT NULL,
  `numberOfUnits4` int(11) NOT NULL,
  `initialConstructionCost1` double NOT NULL,
  `initialConstructionCost2` double NOT NULL,
  `initialConstructionCost3` double NOT NULL,
  `initialConstructionCost4` double NOT NULL,
  `updateCost1` double NOT NULL,
  `updateCost2` double NOT NULL,
  `updateCost3` double NOT NULL,
  `updateCost4` double NOT NULL,
  `operationAndMaintenanceCosts1` double NOT NULL,
  `operationAndMaintenanceCosts2` double NOT NULL,
  `operationAndMaintenanceCosts3` double NOT NULL,
  `operationAndMaintenanceCosts4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `direct_fired_lithium_bromide`
--

INSERT INTO `direct_fired_lithium_bromide` (`id`, `name`, `heatingEnergyEfficiencyRatio`, `refrigerationEnergyEfficiencyRatio`, `ratedHeatingPower`, `ratedCoolingPower`, `life`, `manufacturer`, `numberOfUnits1`, `numberOfUnits2`, `numberOfUnits3`, `numberOfUnits4`, `initialConstructionCost1`, `initialConstructionCost2`, `initialConstructionCost3`, `initialConstructionCost4`, `updateCost1`, `updateCost2`, `updateCost3`, `updateCost4`, `operationAndMaintenanceCosts1`, `operationAndMaintenanceCosts2`, `operationAndMaintenanceCosts3`, `operationAndMaintenanceCosts4`, `owner`) VALUES
(1, '1', 0, 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `electric_boiler`
--

CREATE TABLE `electric_boiler` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `life` double NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `electricalRating` double NOT NULL,
  `heatingRatio` double NOT NULL,
  `capacity1` int(11) NOT NULL,
  `capacity2` int(11) NOT NULL,
  `capacity3` int(11) NOT NULL,
  `capacity4` int(11) NOT NULL,
  `initialCost1` double NOT NULL,
  `initialCost2` double NOT NULL,
  `initialCost3` double NOT NULL,
  `initialCost4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintenanceCost1` double NOT NULL,
  `maintenanceCost2` double NOT NULL,
  `maintenanceCost3` double NOT NULL,
  `maintenanceCost4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `electric_boiler`
--

INSERT INTO `electric_boiler` (`id`, `name`, `life`, `manufacturer`, `electricalRating`, `heatingRatio`, `capacity1`, `capacity2`, `capacity3`, `capacity4`, `initialCost1`, `initialCost2`, `initialCost3`, `initialCost4`, `replacementCost1`, `replacementCost2`, `replacementCost3`, `replacementCost4`, `maintenanceCost1`, `maintenanceCost2`, `maintenanceCost3`, `maintenanceCost4`, `owner`) VALUES
(1, '1', 0, '1', 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `gas_boiler`
--

CREATE TABLE `gas_boiler` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `ratedPower` double NOT NULL,
  `eff` double NOT NULL,
  `lifetime` double NOT NULL,
  `factory` varchar(255) NOT NULL,
  `number1` int(11) NOT NULL,
  `number2` int(11) NOT NULL,
  `number3` int(11) NOT NULL,
  `number4` int(11) NOT NULL,
  `fBuildCost1` double NOT NULL,
  `fBuildCost2` double NOT NULL,
  `fBuildCost3` double NOT NULL,
  `fBuildCost4` double NOT NULL,
  `rBuildCost1` double NOT NULL,
  `rBuildCost2` double NOT NULL,
  `rBuildCost3` double NOT NULL,
  `rBuildCost4` double NOT NULL,
  `operCost1` double NOT NULL,
  `operCost2` double NOT NULL,
  `operCost3` double NOT NULL,
  `operCost4` double NOT NULL,
  `owner` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `gas_boiler`
--

INSERT INTO `gas_boiler` (`id`, `name`, `ratedPower`, `eff`, `lifetime`, `factory`, `number1`, `number2`, `number3`, `number4`, `fBuildCost1`, `fBuildCost2`, `fBuildCost3`, `fBuildCost4`, `rBuildCost1`, `rBuildCost2`, `rBuildCost3`, `rBuildCost4`, `operCost1`, `operCost2`, `operCost3`, `operCost4`, `owner`) VALUES
(2, '', 0, 0, 0, '一一亿元', 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 0, 0, 0, 'lzw'),
(3, '1', 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `gas_engine`
--

CREATE TABLE `gas_engine` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `ratedPower` double NOT NULL,
  `mLoadRate` double NOT NULL,
  `coWaterPowerRatio` double NOT NULL,
  `gasEleRatio` double NOT NULL,
  `lifetime` double NOT NULL,
  `number1` int(11) NOT NULL,
  `number2` int(11) NOT NULL,
  `number3` int(11) NOT NULL,
  `number4` int(11) NOT NULL,
  `fBuildCost1` double NOT NULL,
  `fBuildCost2` double NOT NULL,
  `fBuildCost3` double NOT NULL,
  `fBuildCost4` double NOT NULL,
  `rBuildCost1` double NOT NULL,
  `rBuildCost2` double NOT NULL,
  `rBuildCost3` double NOT NULL,
  `rBuildCost4` double NOT NULL,
  `operCost1` double NOT NULL,
  `operCost2` double NOT NULL,
  `operCost3` double NOT NULL,
  `operCost4` double NOT NULL,
  `outPower` varchar(255) NOT NULL,
  `fuelUse` varchar(255) NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `gas_engine`
--

INSERT INTO `gas_engine` (`id`, `name`, `ratedPower`, `mLoadRate`, `coWaterPowerRatio`, `gasEleRatio`, `lifetime`, `number1`, `number2`, `number3`, `number4`, `fBuildCost1`, `fBuildCost2`, `fBuildCost3`, `fBuildCost4`, `rBuildCost1`, `rBuildCost2`, `rBuildCost3`, `rBuildCost4`, `operCost1`, `operCost2`, `operCost3`, `operCost4`, `outPower`, `fuelUse`, `owner`) VALUES
(1, '1', 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '10', '20', 'lzw'),
(2, '2', 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '2,', '3,', 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `gas_steam`
--

CREATE TABLE `gas_steam` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `ratedPower` double NOT NULL,
  `eff` double NOT NULL,
  `lifetime` double NOT NULL,
  `factory` varchar(255) NOT NULL,
  `number1` int(11) NOT NULL,
  `number2` int(11) NOT NULL,
  `number3` int(11) NOT NULL,
  `number4` int(11) NOT NULL,
  `fBuildCost1` double NOT NULL,
  `fBuildCost2` double NOT NULL,
  `fBuildCost3` double NOT NULL,
  `fBuildCost4` double NOT NULL,
  `rBuildCost1` double NOT NULL,
  `rBuildCost2` double NOT NULL,
  `rBuildCost3` double NOT NULL,
  `rBuildCost4` double NOT NULL,
  `operCost1` double NOT NULL,
  `operCost2` double NOT NULL,
  `operCost3` double NOT NULL,
  `operCost4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `gas_steam`
--

INSERT INTO `gas_steam` (`id`, `name`, `ratedPower`, `eff`, `lifetime`, `factory`, `number1`, `number2`, `number3`, `number4`, `fBuildCost1`, `fBuildCost2`, `fBuildCost3`, `fBuildCost4`, `rBuildCost1`, `rBuildCost2`, `rBuildCost3`, `rBuildCost4`, `operCost1`, `operCost2`, `operCost3`, `operCost4`, `owner`) VALUES
(1, '1', 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `gas_turbine`
--

CREATE TABLE `gas_turbine` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `ratedPower` double NOT NULL,
  `mLoadRate` double NOT NULL,
  `gasTurbineEff` double NOT NULL,
  `gasCogRatio` double NOT NULL,
  `lifetime` double NOT NULL,
  `number1` int(11) NOT NULL,
  `number2` int(11) NOT NULL,
  `number3` int(11) NOT NULL,
  `number4` int(11) NOT NULL,
  `fBuildCost1` double NOT NULL,
  `fBuildCost2` double NOT NULL,
  `fBuildCost3` double NOT NULL,
  `fBuildCost4` double NOT NULL,
  `rBuildCost1` double NOT NULL,
  `rBuildCost2` double NOT NULL,
  `rBuildCost3` double NOT NULL,
  `rBuildCost4` double NOT NULL,
  `operCost1` double NOT NULL,
  `operCost2` double NOT NULL,
  `operCost3` double NOT NULL,
  `operCost4` double NOT NULL,
  `outPower` varchar(255) NOT NULL,
  `fuelUse` varchar(255) NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `gas_turbine`
--

INSERT INTO `gas_turbine` (`id`, `name`, `ratedPower`, `mLoadRate`, `gasTurbineEff`, `gasCogRatio`, `lifetime`, `number1`, `number2`, `number3`, `number4`, `fBuildCost1`, `fBuildCost2`, `fBuildCost3`, `fBuildCost4`, `rBuildCost1`, `rBuildCost2`, `rBuildCost3`, `rBuildCost4`, `operCost1`, `operCost2`, `operCost3`, `operCost4`, `outPower`, `fuelUse`, `owner`) VALUES
(3, '11', 0, 20, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '10', '10', 'lzw'),
(4, '2', 1, 1, 1, 1, 1, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '10', '10', 'lzw'),
(5, '1', 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '10', '20', 'lzw'),
(6, '1', 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, '1,', '1,', 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `generator`
--

CREATE TABLE `generator` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `edgl` double NOT NULL,
  `zdfzl` double NOT NULL,
  `zxyysj` double NOT NULL,
  `life` double NOT NULL,
  `factory` varchar(100) DEFAULT NULL,
  `co2` double NOT NULL,
  `co` double NOT NULL,
  `wrsdqhhw` double NOT NULL,
  `klw` double NOT NULL,
  `so2` double NOT NULL,
  `dyhw` double NOT NULL,
  `type` varchar(20) NOT NULL,
  `glqxNum` int(11) NOT NULL DEFAULT 3,
  `scgl1` double NOT NULL,
  `scgl2` double NOT NULL,
  `scgl3` double NOT NULL,
  `rlxh1` double NOT NULL,
  `rlxh2` double NOT NULL,
  `rlxh3` double NOT NULL,
  `capacity1` int(11) NOT NULL,
  `capacity2` int(11) NOT NULL,
  `capacity3` int(11) NOT NULL,
  `capacity4` int(11) NOT NULL,
  `cjcb1` double NOT NULL,
  `cjcb2` double NOT NULL,
  `cjcb3` double NOT NULL,
  `cjcb4` double NOT NULL,
  `gxcb1` double NOT NULL,
  `gxcb2` double NOT NULL,
  `gxcb3` double NOT NULL,
  `gxcb4` double NOT NULL,
  `yxwhcb1` double NOT NULL,
  `yxwhcb2` double NOT NULL,
  `yxwhcb3` double NOT NULL,
  `yxwhcb4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `generator`
--

INSERT INTO `generator` (`id`, `name`, `edgl`, `zdfzl`, `zxyysj`, `life`, `factory`, `co2`, `co`, `wrsdqhhw`, `klw`, `so2`, `dyhw`, `type`, `glqxNum`, `scgl1`, `scgl2`, `scgl3`, `rlxh1`, `rlxh2`, `rlxh3`, `capacity1`, `capacity2`, `capacity3`, `capacity4`, `cjcb1`, `cjcb2`, `cjcb3`, `cjcb4`, `gxcb1`, `gxcb2`, `gxcb3`, `gxcb4`, `yxwhcb1`, `yxwhcb2`, `yxwhcb3`, `yxwhcb4`, `owner`) VALUES
(1, '1', 0, 1, 0, 0, '1', 1, 0, 1, 1, 0, 1, '0', 0, 10, 10, 10, 20, 20, 20, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(2, '2', 0, 0, 0, 0, '2', 0, 0, 0, 0, 0, 0, '1', 0, 10, 10, 10, 20, 20, 20, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(5, '3', 0, 0, 0, 0, '3', 0, 0, 0, 0, 0, 0, '0', 0, 10, 10, 10, 20, 20, 20, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `heat_pump`
--

CREATE TABLE `heat_pump` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `thermalRatio` double NOT NULL,
  `refrigerationRatio` double NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `ratedThermoElectricPower` double NOT NULL,
  `ratedRefrigeratingElectricPower` double NOT NULL,
  `life` double NOT NULL,
  `heatingConsumptionCoefficient` double NOT NULL,
  `refrigerationConsumptionCoefficient` double NOT NULL,
  `capacity1` int(11) NOT NULL,
  `capacity2` int(11) NOT NULL,
  `capacity3` int(11) NOT NULL,
  `capacity4` int(11) NOT NULL,
  `initialCost1` double NOT NULL,
  `initialCost2` double NOT NULL,
  `initialCost3` double NOT NULL,
  `initialCost4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintenanceCost1` double NOT NULL,
  `maintenanceCost2` double NOT NULL,
  `maintenanceCost3` double NOT NULL,
  `maintenanceCost4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `heat_pump`
--

INSERT INTO `heat_pump` (`id`, `name`, `thermalRatio`, `refrigerationRatio`, `manufacturer`, `ratedThermoElectricPower`, `ratedRefrigeratingElectricPower`, `life`, `heatingConsumptionCoefficient`, `refrigerationConsumptionCoefficient`, `capacity1`, `capacity2`, `capacity3`, `capacity4`, `initialCost1`, `initialCost2`, `initialCost3`, `initialCost4`, `replacementCost1`, `replacementCost2`, `replacementCost3`, `replacementCost4`, `maintenanceCost1`, `maintenanceCost2`, `maintenanceCost3`, `maintenanceCost4`, `owner`) VALUES
(1, '1', 0, 0, '1', 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `heat_storage`
--

CREATE TABLE `heat_storage` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `heatStorageEfficiency` double NOT NULL,
  `heatReleaseEfficiency` double NOT NULL,
  `maximumHeatStorageRate` double NOT NULL,
  `maximumHeatReleaseRate` double NOT NULL,
  `selfLossRate` double NOT NULL,
  `life` double NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `capacity1` double(11,0) NOT NULL,
  `capacity2` double(11,0) NOT NULL,
  `capacity3` double(11,0) NOT NULL,
  `capacity4` double(11,0) NOT NULL,
  `initialConstructionCost1` double NOT NULL,
  `initialConstructionCost2` double NOT NULL,
  `initialConstructionCost3` double NOT NULL,
  `initialConstructionCost4` double NOT NULL,
  `updateCost1` double NOT NULL,
  `updateCost2` double NOT NULL,
  `updateCost3` double NOT NULL,
  `updateCost4` double NOT NULL,
  `operationAndMaintenanceCosts1` double NOT NULL,
  `operationAndMaintenanceCosts2` double NOT NULL,
  `operationAndMaintenanceCosts3` double NOT NULL,
  `operationAndMaintenanceCosts4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `heat_storage`
--

INSERT INTO `heat_storage` (`id`, `name`, `heatStorageEfficiency`, `heatReleaseEfficiency`, `maximumHeatStorageRate`, `maximumHeatReleaseRate`, `selfLossRate`, `life`, `manufacturer`, `capacity1`, `capacity2`, `capacity3`, `capacity4`, `initialConstructionCost1`, `initialConstructionCost2`, `initialConstructionCost3`, `initialConstructionCost4`, `updateCost1`, `updateCost2`, `updateCost3`, `updateCost4`, `operationAndMaintenanceCosts1`, `operationAndMaintenanceCosts2`, `operationAndMaintenanceCosts3`, `operationAndMaintenanceCosts4`, `owner`) VALUES
(1, '1', 0, 0, 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(2, '2', 0, 0, 0, 0, 0, 0, '2', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `host`
--

CREATE TABLE `host` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `iceRatio` double NOT NULL,
  `refrigerationRatio` double NOT NULL,
  `life` double NOT NULL,
  `ratedIceElectricPower` double NOT NULL,
  `ratedRefrigeratingElectricPower` double NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `iceConsumptionCoefficient` double NOT NULL,
  `refrigerationConsumptionCoefficient` double NOT NULL,
  `capacity1` double NOT NULL,
  `capacity2` double NOT NULL,
  `capacity3` double NOT NULL,
  `capacity4` double NOT NULL,
  `initialCost1` double NOT NULL,
  `initialCost2` double NOT NULL,
  `initialCost3` double NOT NULL,
  `initialCost4` double NOT NULL,
  `replacementCost1` double NOT NULL,
  `replacementCost2` double NOT NULL,
  `replacementCost3` double NOT NULL,
  `replacementCost4` double NOT NULL,
  `maintenanceCost1` double NOT NULL,
  `maintenanceCost2` double NOT NULL,
  `maintenanceCost3` double NOT NULL,
  `maintenanceCost4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `host`
--

INSERT INTO `host` (`id`, `name`, `iceRatio`, `refrigerationRatio`, `life`, `ratedIceElectricPower`, `ratedRefrigeratingElectricPower`, `manufacturer`, `iceConsumptionCoefficient`, `refrigerationConsumptionCoefficient`, `capacity1`, `capacity2`, `capacity3`, `capacity4`, `initialCost1`, `initialCost2`, `initialCost3`, `initialCost4`, `replacementCost1`, `replacementCost2`, `replacementCost3`, `replacementCost4`, `maintenanceCost1`, `maintenanceCost2`, `maintenanceCost3`, `maintenanceCost4`, `owner`) VALUES
(1, '1', 0, 0, 0, 0, 0, '1', 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `ice_storage`
--

CREATE TABLE `ice_storage` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `iceStorageEfficiency` double NOT NULL,
  `iceReleaseEfficiency` double NOT NULL,
  `maximumIceStorageRate` double NOT NULL,
  `maximumIceReleaseRate` double NOT NULL,
  `selfLossRate` double NOT NULL,
  `life` double NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `capacity1` double(11,0) NOT NULL,
  `capacity2` double(11,0) NOT NULL,
  `capacity3` double(11,0) NOT NULL,
  `capacity4` double(11,0) NOT NULL,
  `initialConstructionCost1` double NOT NULL,
  `initialConstructionCost2` double NOT NULL,
  `initialConstructionCost3` double NOT NULL,
  `initialConstructionCost4` double NOT NULL,
  `updateCost1` double NOT NULL,
  `updateCost2` double NOT NULL,
  `updateCost3` double NOT NULL,
  `updateCost4` double NOT NULL,
  `operationAndMaintenanceCosts1` double NOT NULL,
  `operationAndMaintenanceCosts2` double NOT NULL,
  `operationAndMaintenanceCosts3` double NOT NULL,
  `operationAndMaintenanceCosts4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `ice_storage`
--

INSERT INTO `ice_storage` (`id`, `name`, `iceStorageEfficiency`, `iceReleaseEfficiency`, `maximumIceStorageRate`, `maximumIceReleaseRate`, `selfLossRate`, `life`, `manufacturer`, `capacity1`, `capacity2`, `capacity3`, `capacity4`, `initialConstructionCost1`, `initialConstructionCost2`, `initialConstructionCost3`, `initialConstructionCost4`, `updateCost1`, `updateCost2`, `updateCost3`, `updateCost4`, `operationAndMaintenanceCosts1`, `operationAndMaintenanceCosts2`, `operationAndMaintenanceCosts3`, `operationAndMaintenanceCosts4`, `owner`) VALUES
(1, '1', 0, 0, 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(2, '1', 0, 2, 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `lithium_bromide`
--

CREATE TABLE `lithium_bromide` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `heatingEnergyEfficiencyRatio` double NOT NULL,
  `refrigerationEnergyEfficiencyRatio` double NOT NULL,
  `ratedHeatingFlueGasPower` double NOT NULL,
  `ratedCoolingFlueGasPower` double NOT NULL,
  `life` double NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `numberOfUnits1` int(11) NOT NULL,
  `numberOfUnits2` int(11) NOT NULL,
  `numberOfUnits3` int(11) NOT NULL,
  `numberOfUnits4` int(11) NOT NULL,
  `initialConstructionCost1` double NOT NULL,
  `initialConstructionCost2` double NOT NULL,
  `initialConstructionCost3` double NOT NULL,
  `initialConstructionCost4` double NOT NULL,
  `updateCost1` double NOT NULL,
  `updateCost2` double NOT NULL,
  `updateCost3` double NOT NULL,
  `updateCost4` double NOT NULL,
  `operationAndMaintenanceCosts1` double NOT NULL,
  `operationAndMaintenanceCosts2` double NOT NULL,
  `operationAndMaintenanceCosts3` double NOT NULL,
  `operationAndMaintenanceCosts4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `lithium_bromide`
--

INSERT INTO `lithium_bromide` (`id`, `name`, `heatingEnergyEfficiencyRatio`, `refrigerationEnergyEfficiencyRatio`, `ratedHeatingFlueGasPower`, `ratedCoolingFlueGasPower`, `life`, `manufacturer`, `numberOfUnits1`, `numberOfUnits2`, `numberOfUnits3`, `numberOfUnits4`, `initialConstructionCost1`, `initialConstructionCost2`, `initialConstructionCost3`, `initialConstructionCost4`, `updateCost1`, `updateCost2`, `updateCost3`, `updateCost4`, `operationAndMaintenanceCosts1`, `operationAndMaintenanceCosts2`, `operationAndMaintenanceCosts3`, `operationAndMaintenanceCosts4`, `owner`) VALUES
(1, '1', 0, 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `nuclear`
--

CREATE TABLE `nuclear` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `lifetime` double NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `frequencyModulationCoefficient` double NOT NULL,
  `minimuLoadRate` double NOT NULL,
  `upperLimitOfNuclearPowerGeneration` double NOT NULL,
  `quantityOfNuclearFuel` double NOT NULL,
  `nuclearFuelPrices` double NOT NULL,
  `nuclearPowerFuelReplacementTime` double NOT NULL,
  `capacity1` int(11) NOT NULL,
  `capacity2` int(11) NOT NULL,
  `capacity3` int(11) NOT NULL,
  `capacity4` int(11) NOT NULL,
  `fBuildCost1` double NOT NULL,
  `fBuildCost2` double NOT NULL,
  `fBuildCost3` double NOT NULL,
  `fBuildCost4` double NOT NULL,
  `rBuildCost1` double NOT NULL,
  `rBuildCost2` double NOT NULL,
  `rBuildCost3` double NOT NULL,
  `rBuildCost4` double NOT NULL,
  `operCost1` double NOT NULL,
  `operCost2` double NOT NULL,
  `operCost3` double NOT NULL,
  `operCost4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `nuclear`
--

INSERT INTO `nuclear` (`id`, `name`, `lifetime`, `manufacturer`, `frequencyModulationCoefficient`, `minimuLoadRate`, `upperLimitOfNuclearPowerGeneration`, `quantityOfNuclearFuel`, `nuclearFuelPrices`, `nuclearPowerFuelReplacementTime`, `capacity1`, `capacity2`, `capacity3`, `capacity4`, `fBuildCost1`, `fBuildCost2`, `fBuildCost3`, `fBuildCost4`, `rBuildCost1`, `rBuildCost2`, `rBuildCost3`, `rBuildCost4`, `operCost1`, `operCost2`, `operCost3`, `operCost4`, `owner`) VALUES
(1, '1', 0, '1', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `photovoltaic`
--

CREATE TABLE `photovoltaic` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `edrl` double NOT NULL,
  `jeys` double NOT NULL,
  `gfzltynxsl` double NOT NULL,
  `gffdxl` double NOT NULL,
  `noctWd` double NOT NULL,
  `wdxs` double NOT NULL,
  `noctGz` double NOT NULL,
  `gfbbzwd` double NOT NULL,
  `life` double NOT NULL,
  `stcWd` double NOT NULL,
  `factory` varchar(100) NOT NULL,
  `type` double NOT NULL,
  `capacity1` int(11) NOT NULL,
  `capacity2` int(11) NOT NULL,
  `capacity3` int(11) NOT NULL,
  `capacity4` int(11) NOT NULL,
  `cjcb1` double NOT NULL,
  `cjcb2` double NOT NULL,
  `cjcb3` double NOT NULL,
  `cjcb4` double NOT NULL,
  `gxcb1` double NOT NULL,
  `gxcb2` double NOT NULL,
  `gxcb3` double NOT NULL,
  `gxcb4` double NOT NULL,
  `yxwhcb1` double NOT NULL,
  `yxwhcb2` double NOT NULL,
  `yxwhcb3` double NOT NULL,
  `yxwhcb4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `photovoltaic`
--

INSERT INTO `photovoltaic` (`id`, `name`, `edrl`, `jeys`, `gfzltynxsl`, `gffdxl`, `noctWd`, `wdxs`, `noctGz`, `gfbbzwd`, `life`, `stcWd`, `factory`, `type`, `capacity1`, `capacity2`, `capacity3`, `capacity4`, `cjcb1`, `cjcb2`, `cjcb3`, `cjcb4`, `gxcb1`, `gxcb2`, `gxcb3`, `gxcb4`, `yxwhcb1`, `yxwhcb2`, `yxwhcb3`, `yxwhcb4`, `owner`) VALUES
(1, '1', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '1', 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(2, '2', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '2', 1, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(4, '3', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, '3', 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `plate_heat`
--

CREATE TABLE `plate_heat` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `heatTransferEff` double NOT NULL,
  `ratedJacketWaterPower` double NOT NULL,
  `lifetime` double NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `number1` int(11) NOT NULL,
  `number2` int(11) NOT NULL,
  `number3` int(11) NOT NULL,
  `number4` int(11) NOT NULL,
  `fBuildCost1` double NOT NULL,
  `fBuildCost2` double NOT NULL,
  `fBuildCost3` double NOT NULL,
  `fBuildCost4` double NOT NULL,
  `rBuildCost1` double NOT NULL,
  `rBuildCost2` double NOT NULL,
  `rBuildCost3` double NOT NULL,
  `rBuildCost4` double NOT NULL,
  `operCost1` double NOT NULL,
  `operCost2` double NOT NULL,
  `operCost3` double NOT NULL,
  `operCost4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `plate_heat`
--

INSERT INTO `plate_heat` (`id`, `name`, `heatTransferEff`, `ratedJacketWaterPower`, `lifetime`, `manufacturer`, `number1`, `number2`, `number3`, `number4`, `fBuildCost1`, `fBuildCost2`, `fBuildCost3`, `fBuildCost4`, `rBuildCost1`, `rBuildCost2`, `rBuildCost3`, `rBuildCost4`, `operCost1`, `operCost2`, `operCost3`, `operCost4`, `owner`) VALUES
(1, '1', 0, 0, 0, '1', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `record`
--

CREATE TABLE `record` (
  `name` varchar(100) NOT NULL,
  `state` int(11) NOT NULL,
  `owner` varchar(20) NOT NULL,
  `input` mediumtext NOT NULL,
  `output` mediumtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- 表的结构 `residual_heat`
--

CREATE TABLE `residual_heat` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `eff` double NOT NULL,
  `ratedPower` double NOT NULL,
  `lifetime` double NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `number1` int(11) NOT NULL,
  `number2` int(11) NOT NULL,
  `number3` int(11) NOT NULL,
  `number4` int(11) NOT NULL,
  `fBuildCost1` double NOT NULL,
  `fBuildCost2` double NOT NULL,
  `fBuildCost3` double NOT NULL,
  `fBuildCost4` double NOT NULL,
  `rBuildCost1` double NOT NULL,
  `rBuildCost2` double NOT NULL,
  `rBuildCost3` double NOT NULL,
  `rBuildCost4` double NOT NULL,
  `operCost1` double NOT NULL,
  `operCost2` double NOT NULL,
  `operCost3` double NOT NULL,
  `operCost4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `residual_heat`
--

INSERT INTO `residual_heat` (`id`, `name`, `eff`, `ratedPower`, `lifetime`, `manufacturer`, `number1`, `number2`, `number3`, `number4`, `fBuildCost1`, `fBuildCost2`, `fBuildCost3`, `fBuildCost4`, `rBuildCost1`, `rBuildCost2`, `rBuildCost3`, `rBuildCost4`, `operCost1`, `operCost2`, `operCost3`, `operCost4`, `owner`) VALUES
(1, '1', 0, 0, 0, '1', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `screw`
--

CREATE TABLE `screw` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `power` double NOT NULL,
  `costRate` double NOT NULL,
  `loadRate` double NOT NULL,
  `life` double NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `number1` double NOT NULL,
  `number2` double NOT NULL,
  `number3` double NOT NULL,
  `number4` double NOT NULL,
  `newCost1` double NOT NULL,
  `newCost2` double NOT NULL,
  `newCost3` double NOT NULL,
  `newCost4` double NOT NULL,
  `updateCost1` double NOT NULL,
  `updateCost2` double NOT NULL,
  `updateCost3` double NOT NULL,
  `updateCost4` double NOT NULL,
  `runCost1` double NOT NULL,
  `runCost2` double NOT NULL,
  `runCost3` double NOT NULL,
  `runCost4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `screw`
--

INSERT INTO `screw` (`id`, `name`, `power`, `costRate`, `loadRate`, `life`, `manufacturer`, `number1`, `number2`, `number3`, `number4`, `newCost1`, `newCost2`, `newCost3`, `newCost4`, `updateCost1`, `updateCost2`, `updateCost3`, `updateCost4`, `runCost1`, `runCost2`, `runCost3`, `runCost4`, `owner`) VALUES
(1, '1', 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `scroll`
--

CREATE TABLE `scroll` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `power` double NOT NULL,
  `costRate` double NOT NULL,
  `loadRate` double NOT NULL,
  `life` double NOT NULL,
  `manufacturer` varchar(100) NOT NULL,
  `number1` double NOT NULL,
  `number2` double NOT NULL,
  `number3` double NOT NULL,
  `number4` double NOT NULL,
  `newCost1` double NOT NULL,
  `newCost2` double NOT NULL,
  `newCost3` double NOT NULL,
  `newCost4` double NOT NULL,
  `updateCost1` double NOT NULL,
  `updateCost2` double NOT NULL,
  `updateCost3` double NOT NULL,
  `updateCost4` double NOT NULL,
  `runCost1` double NOT NULL,
  `runCost2` double NOT NULL,
  `runCost3` double NOT NULL,
  `runCost4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `scroll`
--

INSERT INTO `scroll` (`id`, `name`, `power`, `costRate`, `loadRate`, `life`, `manufacturer`, `number1`, `number2`, `number3`, `number4`, `newCost1`, `newCost2`, `newCost3`, `newCost4`, `updateCost1`, `updateCost2`, `updateCost3`, `updateCost4`, `runCost1`, `runCost2`, `runCost3`, `runCost4`, `owner`) VALUES
(1, '1', 0, 0, 0, 0, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `turbine`
--

CREATE TABLE `turbine` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `edst` double NOT NULL,
  `edgl` double NOT NULL,
  `sljxl` double NOT NULL,
  `fdjxl` double NOT NULL,
  `life` double NOT NULL,
  `factory` varchar(100) NOT NULL,
  `capacity1` int(11) NOT NULL,
  `capacity2` int(11) NOT NULL,
  `capacity3` int(11) NOT NULL,
  `capacity4` int(11) NOT NULL,
  `cjcb1` double NOT NULL,
  `cjcb2` double NOT NULL,
  `cjcb3` double NOT NULL,
  `cjcb4` double NOT NULL,
  `gxcb1` double NOT NULL,
  `gxcb2` double NOT NULL,
  `gxcb3` double NOT NULL,
  `gxcb4` double NOT NULL,
  `yxwhcb1` double NOT NULL,
  `yxwhcb2` double NOT NULL,
  `yxwhcb3` double NOT NULL,
  `yxwhcb4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `turbine`
--

INSERT INTO `turbine` (`id`, `name`, `edst`, `edgl`, `sljxl`, `fdjxl`, `life`, `factory`, `capacity1`, `capacity2`, `capacity3`, `capacity4`, `cjcb1`, `cjcb2`, `cjcb3`, `cjcb4`, `gxcb1`, `gxcb2`, `gxcb3`, `gxcb4`, `yxwhcb1`, `yxwhcb2`, `yxwhcb3`, `yxwhcb4`, `owner`) VALUES
(1, '1', 1, 1, 1, 1, 1, '1', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(2, '2', 0, 0, 0, 0, 0, '2', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(5, '3', 0, 0, 0, 0, 0, '3', 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(200) NOT NULL,
  `type` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`username`, `password`, `type`) VALUES
('1', '$2a$10$Hk0Qq9OzH3ZlTcf60pKvBuSX5M4FX4cztuh6VzfN54zjOj8PhZqbS', 0),
('2', '$2a$10$KmbjY9H.b6lzuM59MKKRR.aALkm4mEJmAKIq0fcl6tWoXUoZr0fkq', 0),
('3', '$2a$10$E/Zf9phySR1X/FrVxNSruOjEalxLIt1dggWznklhU.t4.m9oJ0cSC', 0),
('4', '$2a$10$B54VZXAwmF7UjA5z7Hskc.kkEPfQrgeJ2QlJbvu6B6Sq/FB7ZQo82', 0),
('admin', '$2a$10$PWlQ47z1DU81oikNIclDUOnwhW0BJwwlNc.RUEXgn48RtlSsU.IQ6', 0),
('admin1', '$2a$10$ryGSx54Kxd5cdDnkXH4zH.uhpFiEiaNW8yUxmYgiYWCrQtE6dv.RK', 0),
('lee', '$2a$10$9uI5SrQJBJrLQUXBCtmPveSNOTNiQh5pWGbPboC5eAcOCa0m8Cu8q', 0),
('leee1', '$2a$10$8XeWeABGz.7Zip.WiDT3..5kOA6GhurbczlJ67fv/YpEGuDcPWbvu', 0),
('leee2', '$2a$10$sRvQkeIZ6.YnL2coZ1HLEOscMgqa5Uqgz1ftqSdM9NZw5/9n5oFsK', 0),
('lzw', '$2a$10$pzLmd/fIZjzHBXFCDRyKW.HcWOdRoUVVtWn2pFnRAvSukRU1XMkc.', 0),
('shiro', '123456', 0),
('test', '$2a$10$K2n5vansoEGaICBWRMUbV.r2dd8wglil/fxgfbiBWQ1lg2icF18ia', 1),
('tinynet1', '$2a$10$h5CJYJEnmAHfgb1OdDH7k.acNF9FOCg2qwLQ3rderqA7y2pK6R/5S', 0);

-- --------------------------------------------------------

--
-- 表的结构 `wind_turbines`
--

CREATE TABLE `wind_turbines` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `edgl` double NOT NULL,
  `fjlggd` double NOT NULL,
  `life` double NOT NULL,
  `factory` varchar(100) NOT NULL,
  `type` int(11) NOT NULL,
  `glqxNum` int(11) NOT NULL DEFAULT 20,
  `fs1` double NOT NULL,
  `fs2` double NOT NULL,
  `fs3` double NOT NULL,
  `fs4` double NOT NULL,
  `fs5` double NOT NULL,
  `fs6` double NOT NULL,
  `fs7` double NOT NULL,
  `fs8` double NOT NULL,
  `fs9` double NOT NULL,
  `fs10` double NOT NULL,
  `fs11` double NOT NULL,
  `fs12` double NOT NULL,
  `fs13` double NOT NULL,
  `fs14` double NOT NULL,
  `fs15` double NOT NULL,
  `fs16` double NOT NULL,
  `fs17` double NOT NULL,
  `fs18` double NOT NULL,
  `fs19` double NOT NULL,
  `fs20` double NOT NULL,
  `gl1` double NOT NULL,
  `gl2` double NOT NULL,
  `gl3` double NOT NULL,
  `gl4` double NOT NULL,
  `gl5` double NOT NULL,
  `gl6` double NOT NULL,
  `gl7` double NOT NULL,
  `gl8` double NOT NULL,
  `gl9` double NOT NULL,
  `gl10` double NOT NULL,
  `gl11` double NOT NULL,
  `gl12` double NOT NULL,
  `gl13` double NOT NULL,
  `gl14` double NOT NULL,
  `gl15` double NOT NULL,
  `gl16` double NOT NULL,
  `gl17` double NOT NULL,
  `gl18` double NOT NULL,
  `gl19` double NOT NULL,
  `gl20` double NOT NULL,
  `capacity1` int(11) NOT NULL,
  `capacity2` int(11) NOT NULL,
  `capacity3` int(11) NOT NULL,
  `capacity4` double NOT NULL,
  `cjcb1` double NOT NULL,
  `cjcb2` double NOT NULL,
  `cjcb3` double NOT NULL,
  `cjcb4` double NOT NULL,
  `gxcb1` double NOT NULL,
  `gxcb2` double NOT NULL,
  `gxcb3` double NOT NULL,
  `gxcb4` double NOT NULL,
  `yxwhcb1` double NOT NULL,
  `yxwhcb2` double NOT NULL,
  `yxwhcb3` double NOT NULL,
  `yxwhcb4` double NOT NULL,
  `owner` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `wind_turbines`
--

INSERT INTO `wind_turbines` (`id`, `name`, `edgl`, `fjlggd`, `life`, `factory`, `type`, `glqxNum`, `fs1`, `fs2`, `fs3`, `fs4`, `fs5`, `fs6`, `fs7`, `fs8`, `fs9`, `fs10`, `fs11`, `fs12`, `fs13`, `fs14`, `fs15`, `fs16`, `fs17`, `fs18`, `fs19`, `fs20`, `gl1`, `gl2`, `gl3`, `gl4`, `gl5`, `gl6`, `gl7`, `gl8`, `gl9`, `gl10`, `gl11`, `gl12`, `gl13`, `gl14`, `gl15`, `gl16`, `gl17`, `gl18`, `gl19`, `gl20`, `capacity1`, `capacity2`, `capacity3`, `capacity4`, `cjcb1`, `cjcb2`, `cjcb3`, `cjcb4`, `gxcb1`, `gxcb2`, `gxcb3`, `gxcb4`, `yxwhcb1`, `yxwhcb2`, `yxwhcb3`, `yxwhcb4`, `owner`) VALUES
(1, '1', 0, 0, 0, '1', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(2, '2', 0, 0, 0, '1', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw'),
(5, '3', 0, 0, 0, '3', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 100, 10000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 0, 1, 10000, 1000000, 'lzw');

--
-- 转储表的索引
--

--
-- 表的索引 `all_type`
--
ALTER TABLE `all_type`
  ADD PRIMARY KEY (`table_name`) USING BTREE;

--
-- 表的索引 `battery`
--
ALTER TABLE `battery`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `centrifugal`
--
ALTER TABLE `centrifugal`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `direct_fired_lithium_bromide`
--
ALTER TABLE `direct_fired_lithium_bromide`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `electric_boiler`
--
ALTER TABLE `electric_boiler`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `gas_boiler`
--
ALTER TABLE `gas_boiler`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `gas_engine`
--
ALTER TABLE `gas_engine`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `gas_steam`
--
ALTER TABLE `gas_steam`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `gas_turbine`
--
ALTER TABLE `gas_turbine`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `generator`
--
ALTER TABLE `generator`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `heat_pump`
--
ALTER TABLE `heat_pump`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `heat_storage`
--
ALTER TABLE `heat_storage`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `host`
--
ALTER TABLE `host`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `ice_storage`
--
ALTER TABLE `ice_storage`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `lithium_bromide`
--
ALTER TABLE `lithium_bromide`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `nuclear`
--
ALTER TABLE `nuclear`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `photovoltaic`
--
ALTER TABLE `photovoltaic`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `plate_heat`
--
ALTER TABLE `plate_heat`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `record`
--
ALTER TABLE `record`
  ADD PRIMARY KEY (`name`) USING BTREE;

--
-- 表的索引 `residual_heat`
--
ALTER TABLE `residual_heat`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `screw`
--
ALTER TABLE `screw`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `scroll`
--
ALTER TABLE `scroll`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `turbine`
--
ALTER TABLE `turbine`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`) USING BTREE;

--
-- 表的索引 `wind_turbines`
--
ALTER TABLE `wind_turbines`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `battery`
--
ALTER TABLE `battery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- 使用表AUTO_INCREMENT `centrifugal`
--
ALTER TABLE `centrifugal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `direct_fired_lithium_bromide`
--
ALTER TABLE `direct_fired_lithium_bromide`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `electric_boiler`
--
ALTER TABLE `electric_boiler`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `gas_boiler`
--
ALTER TABLE `gas_boiler`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- 使用表AUTO_INCREMENT `gas_engine`
--
ALTER TABLE `gas_engine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `gas_steam`
--
ALTER TABLE `gas_steam`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `gas_turbine`
--
ALTER TABLE `gas_turbine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- 使用表AUTO_INCREMENT `generator`
--
ALTER TABLE `generator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- 使用表AUTO_INCREMENT `heat_pump`
--
ALTER TABLE `heat_pump`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `heat_storage`
--
ALTER TABLE `heat_storage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `host`
--
ALTER TABLE `host`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `ice_storage`
--
ALTER TABLE `ice_storage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `lithium_bromide`
--
ALTER TABLE `lithium_bromide`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `nuclear`
--
ALTER TABLE `nuclear`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `photovoltaic`
--
ALTER TABLE `photovoltaic`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- 使用表AUTO_INCREMENT `plate_heat`
--
ALTER TABLE `plate_heat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `residual_heat`
--
ALTER TABLE `residual_heat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `screw`
--
ALTER TABLE `screw`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `scroll`
--
ALTER TABLE `scroll`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `turbine`
--
ALTER TABLE `turbine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- 使用表AUTO_INCREMENT `wind_turbines`
--
ALTER TABLE `wind_turbines`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
