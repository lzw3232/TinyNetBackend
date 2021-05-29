package edu.tju.scs.TinyNetBackend.common;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import edu.tju.scs.TinyNetBackend.mapper.*;
import edu.tju.scs.TinyNetBackend.model.po.*;
import edu.tju.scs.TinyNetBackend.model.po.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.*;

import java.io.*;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class FileHelper {
    @Autowired
    protected BatteryMapper batteryMapper;

    private static String Dir = "F:";

    //创建目录并拷贝目标程序到文件夹下
    public void newRecord(Record record) {
        String path = Dir + File.separator + record.getOwner() + File.separator + record.getName();
        try {

            //copyDir("F:\\exe",path);
            copyFolder("F:" + File.separator + "exe", path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setIO(Record record, JSONObject data) {
        System.out.println(data);
        String username = record.getOwner();
        String recordname = record.getName();
        String path = "F:" + File.separator + username + File.separator + recordname + File.separator + "exe" + File.separator + "IO";
        //String input = getInput(record,data);

        (new File(path)).mkdir();
        (new File(path + File.separator + "IN0")).mkdir();
        (new File(path + File.separator + "OUT0")).mkdir();

        String pathIO = "F:" + File.separator + username + File.separator + recordname + File.separator + "exe" + File.separator + "IO" + File.separator + "IN0";

        String pa;
//      AbschilleParameter.xml  Abschille
        pa = pathIO + File.separator + "AbschilleParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("abschille"), pa, "AbschilleParameter");

//      BatteryParameter.xml  Battery
        pa = pathIO + File.separator + "BatteryParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("battery"), pa, "BatteryParameter");

//      CentrifugalElectricitychillerParameter.xml  CentrifugalElectricitychiller
        pa = pathIO + File.separator + "CentrifugalElectricitychillerParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("centrifugal_electricitychiller"), pa, "CentrifugalElectricitychillerParameter");

//      Coolload.xml Coolload  页面冷负荷导入，未实现，先模拟
        {
            JSONObject Coolload = new JSONObject(true);
            for (int i = 1; i < 25; i++) {
                Coolload.put("vCoolLoad"+i, data.getJSONObject("deviceData").getJSONArray("cool").getJSONObject(i-1).getString("vCoolLoad"));
            }
            pa = pathIO + File.separator + "Coolload.xml";
            createXml(Coolload, pa, "Coolload");
        }

//      CoolstorageParameter.xml  Coolstorage
        pa = pathIO + File.separator + "CoolstorageParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("cool_storage"), pa, "CoolstorageParameter");

//      DieselParameter.xml  Diesel
        {
            JSONObject DieselParameter = new JSONObject(true);
            DieselParameter = data.getJSONObject("deviceData").getJSONObject("diesel");
            if (DieselParameter != null)
                DieselParameter.getJSONObject("id").put("fuelPrice", data.getJSONObject("formData").getJSONObject("economy").getString("fuelPrice"));
            pa = pathIO + File.separator + "DieselParameter.xml";
            createXml(DieselParameter, pa, "DieselParameter");
        }

//      DieselPowerCurve.xml    DieselPowerCurve
        {
            pa = pathIO + File.separator + "DieselPowerCurve.xml";
            JSONObject DieselPowerCurve = new JSONObject(true);
            JSONObject fDieselPower = new JSONObject(true);
            JSONObject fuelConsumption = new JSONObject(true);
            if (data.getJSONObject("deviceData").getJSONObject("diesel") != null) {
                String[] s = data.getJSONObject("deviceData").getJSONObject("diesel").getString("fDieselPower").split(",");
                for (int i = 0; i < s.length; i++) {
                    fDieselPower.put("fDieselPower" + (i + 1), s[i]);
                }
                s = data.getJSONObject("deviceData").getJSONObject("diesel").getString("fuelConsumption").split(",");
                for (int i = 0; i < s.length; i++) {
                    fuelConsumption.put("fuelConsumption" + (i + 1), s[i]);
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    fDieselPower.put("fDieselPower" + (i + 1), "0");
                }
                for (int i = 0; i < 3; i++) {
                    fuelConsumption.put("fuelConsumption" + (i + 1), "0");
                }
            }
            DieselPowerCurve.put("fDieselPower", fDieselPower);
            DieselPowerCurve.put("fuelConsumption", fuelConsumption);
            createXml(DieselPowerCurve, pa, "fDieselPower");
        }

//      ElecairconditionParameter.xml  Elecaircondition
        pa = pathIO + File.separator + "ElecairconditionParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("elecaircondition"), pa, "ElecairconditionParameter");

//      ElecboilerParameter.xml  Elecboiler
        pa = pathIO + File.separator + "ElecboilerParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("elec_boiler"), pa, "ElecboilerParameter");

//      ElectricitychillerParameter.xml  Electricitychiller
        pa = pathIO + File.separator + "ElectricitychillerParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("electricitychiller"), pa, "ElectricitychillerParameter");

//      evaluate.xml  evaluate  //优化设计和评估两种运行方式 未实现
        {
            JSONObject evaluate = new JSONObject(true);
            evaluate.put("typeofWT", data.getJSONObject("deviceData").getJSONObject("wind_turbine") == null ? "0" : "1");
            evaluate.put("numofWT", data.getJSONObject("deviceData").getJSONObject("wind_turbine") == null ? "0" : "1");
            evaluate.put("typeofPV", data.getJSONObject("deviceData").getJSONObject("photovoltaic") == null ? "0" : "1");
            evaluate.put("capacityofPV", data.getJSONObject("deviceData").getJSONObject("photovoltaic") == null ? "0" : "1");
            evaluate.put("typeofHTG", data.getJSONObject("deviceData").getJSONObject("hydro_turbine") == null ? "0" : "1");
            evaluate.put("numofHTG", data.getJSONObject("deviceData").getJSONObject("hydro_turbine") == null ? "0" : "1");
            evaluate.put("typeofDiesel", data.getJSONObject("deviceData").getJSONObject("diesel") == null ? "0" : "1");
            evaluate.put("numofDiesel", data.getJSONObject("deviceData").getJSONObject("diesel") == null ? "0" : "1");
            evaluate.put("typeofBattery", data.getJSONObject("deviceData").getJSONObject("battery") == null ? "0" : "1");
            evaluate.put("numofBattery", data.getJSONObject("deviceData").getJSONObject("battery") == null ? "0" : "1");
            evaluate.put("numofElecboiler", data.getJSONObject("deviceData").getJSONObject("elec_boiler") == null ? "0" : "1");
            evaluate.put("numofGasboiler", data.getJSONObject("deviceData").getJSONObject("gas_boiler") == null ? "0" : "1");
            evaluate.put("numofPump", data.getJSONObject("deviceData").getJSONObject("elec_boiler") == null ? "0" : "1");
            evaluate.put("numofElectricitychiller", data.getJSONObject("deviceData").getJSONObject("gas_boiler") == null ? "0" : "1");
            evaluate.put("numofAbschille", data.getJSONObject("deviceData").getJSONObject("abschille") == null ? "0" : "1");
            evaluate.put("numofElecaircondition", data.getJSONObject("deviceData").getJSONObject("elecaircondition") == null ? "0" : "1");
            evaluate.put("numofGasturebine", data.getJSONObject("deviceData").getJSONObject("gas_turbine") == null ? "0" : "1");
            evaluate.put("numofHeatstorage", data.getJSONObject("deviceData").getJSONObject("heat_storage") == null ? "0" : "1");
            evaluate.put("numofCoolstorage", data.getJSONObject("deviceData").getJSONObject("cool_storage") == null ? "0" : "1");
            evaluate.put("numofWasteheatboiler", data.getJSONObject("deviceData").getJSONObject("waste_heat_boiler") == null ? "0" : "1");
            evaluate.put("numofCentrifugalElectricitychiller", data.getJSONObject("deviceData").getJSONObject("centrifugal_electricitychiller") == null ? "0" : "1");
            evaluate.put("numofScrewElectricitychiller", data.getJSONObject("deviceData").getJSONObject("screw_electricitychiller") == null ? "0" : "1");
            evaluate.put("numofInternalGasturebine", data.getJSONObject("deviceData").getJSONObject("internal_gas_turbine") == null ? "0" : "1");
            evaluate.put("numofHeatexchanger", data.getJSONObject("deviceData").getJSONObject("heat_exchanger") == null ? "0" : "1");
            evaluate.put("numofSteamboiler", data.getJSONObject("deviceData").getJSONObject("gas_steam_boiler") == null ? "0" : "1");
            evaluate.put("numofGasabschille", data.getJSONObject("deviceData").getJSONObject("gas_abschille") == null ? "0" : "1");
            evaluate.put("numofNuclearPower", data.getJSONObject("deviceData").getJSONObject("nuclear_power") == null ? "0" : "1");

            evaluate.put("isDesign", data.getJSONObject("deviceData").getJSONObject("IsDesign") == null ? "0" : "1");
            pa = pathIO + File.separator + "evaluate.xml";
            createXml(evaluate, pa, "evaluate");
        }

//      GAParameter.xml  GA  变流器没写
        {
            JSONObject GA = new JSONObject(true);
            GA = data.getJSONObject("deviceData").getJSONObject("num");
            GA.put("capacityofConverterMinimum", "0"); //变流器已删除 设为0
            GA.put("capacityofConverterMaximum", "0");

            GA.put("typesofBattery", data.getJSONObject("deviceData").getJSONObject("battery") == null ? "0" : "1");
            GA.put("typesofDiesel", data.getJSONObject("deviceData").getJSONObject("diesel") == null ? "0" : "1");
            GA.put("typesofPV", data.getJSONObject("deviceData").getJSONObject("photovoltaic") == null ? "0" : "1");
            GA.put("typesofwindTurbine", data.getJSONObject("deviceData").getJSONObject("wind_turbine") == null ? "0" : "1");
            GA.put("typesofhydroTurbine", data.getJSONObject("deviceData").getJSONObject("hydro_turbine") == null ? "0" : "1");

            GA.put("isOnGrid", data.getString("radioValue") == "A" ? "0" : "1");
            GA.put("intStrategy", data.getJSONObject("formData").getJSONObject("system").getString("intStrategy"));
            GA.put("isLoadonDCside", "1"); //不确定为啥 未完成
            GA.put("range0Maximum", data.getJSONObject("formData").getJSONObject("constraint").getString("range0Maximum"));
            GA.put("range1Minimum", data.getJSONObject("formData").getJSONObject("constraint").getString("range1Minimum"));

            GA.put("numofNuclearPower", "1");

            pa = pathIO + File.separator + "GAParameter.xml";
            createXml(GA, pa, "GAParameter");
        }

//      GasAbschilleParameter.xml  GasAbschille
        pa = pathIO + File.separator + "GasAbschilleParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("gas_abschille"), pa, "GasAbschilleParameter");

//      GasboilerParameter.xml  Gasboiler
        pa = pathIO + File.separator + "GasboilerParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("gas_boiler"), pa, "GasboilerParameter");

//      GasPowerCurve.xml  GasPowerCurve
        {
            pa = pathIO + File.separator + "GasPowerCurve.xml";
            JSONObject GasPowerCurve = new JSONObject(true);
            JSONObject fGasPower = new JSONObject(true);
            JSONObject gasConsumption = new JSONObject(true);
            if (data.getJSONObject("deviceData").getJSONObject("gas_turbine") != null) {
                String[] s = data.getJSONObject("deviceData").getJSONObject("gas_turbine").getString("fGasPower").split(",");
                for (int i = 0; i < s.length; i++) {
                    fGasPower.put("fGasPower" + (i + 1), s[i]);
                }
                s = data.getJSONObject("deviceData").getJSONObject("gas_turbine").getString("gasConsumption").split(",");
                for (int i = 0; i < s.length; i++) {
                    gasConsumption.put("gasConsumption" + (i + 1), s[i]);
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    fGasPower.put("fGasPower" + (i + 1), "0");
                }
                for (int i = 0; i < 3; i++) {
                    gasConsumption.put("gasConsumption" + (i + 1), "0");
                }
            }
            GasPowerCurve.put("fGasPower", fGasPower);
            GasPowerCurve.put("gasConsumption", gasConsumption);
            createXml(GasPowerCurve, pa, "fGasPower");
        }


//      GasSteamboilerParameter.xml  GasSteamboiler
        pa = pathIO + File.separator + "GasSteamboilerParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("gas_steam_boiler"), pa, "GasSteamboilerParameter");

//      GasturbineParameter.xml  Gasturbine
        pa = pathIO + File.separator + "GasturbineParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("gas_turbine"), pa, "GasturbineParameter");

//      GrowthFactor.xml  GrowthFactor
        pa = pathIO + File.separator + "GrowthFactor.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("GrowthFactor"), pa, "GrowthFactor");

//      HeatexchangerParameter.xml  Heatexchanger
        pa = pathIO + File.separator + "HeatexchangerParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("heat_exchanger"), pa, "HeatexchangerParameter");

//      Heatload.xml Heatload  页面热水负荷导入，未实现，先模拟
        {
            JSONObject Heatload = new JSONObject(true);
            for (int i = 1; i < 25; i++) {
                Heatload.put("vHeatWaterLoad"+i, data.getJSONObject("deviceData").getJSONArray("heat").getJSONObject(i-1).getString("vHeatWaterLoad"));
            }
            pa = pathIO + File.separator + "Heatload.xml";
            createXml(Heatload, pa, "Heatload");
        }

//      HeatstorageParameter.xml  Heatstorage
        pa = pathIO + File.separator + "HeatstorageParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("heat_storage"), pa, "HeatstorageParameter");

//      HydroTurbineParameter.xml  HydroTurbine
        pa = pathIO + File.separator + "HydroTurbineParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("hydro_turbine"), pa, "HydroTurbineParameter");

//      InternalGasturbineParameter.xml  InternalGasturbine
        pa = pathIO + File.separator + "InternalGasturbineParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("internal_gas_turbine"), pa, "InternalGasturbineParameter");

//      InternalGasturbinePowerCurve.xml  InternalGasturbinePowerCurve
        {
            pa = pathIO + File.separator + "InternalGasturbinePowerCurve.xml";
            JSONObject InternalGasturbinePowerCurve = new JSONObject(true);
            JSONObject fInternalGasPower = new JSONObject(true);
            JSONObject internalgasConsumption = new JSONObject(true);
            if (data.getJSONObject("deviceData").getJSONObject("internal_gas_turbine") != null) {
                String[] s = data.getJSONObject("deviceData").getJSONObject("internal_gas_turbine").getString("fInternalGasPower").split(",");
                for (int i = 0; i < s.length; i++) {
                    fInternalGasPower.put("fInternalGasPower" + (i + 1), s[i]);
                }
                s = data.getJSONObject("deviceData").getJSONObject("internal_gas_turbine").getString("internalgasConsumption").split(",");
                for (int i = 0; i < s.length; i++) {
                    internalgasConsumption.put("internalgasConsumption" + (i + 1), s[i]);
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    fInternalGasPower.put("fInternalGasPower" + (i + 1), "0");
                }
                for (int i = 0; i < 3; i++) {
                    internalgasConsumption.put("internalgasConsumption" + (i + 1), "0");
                }
            }
            InternalGasturbinePowerCurve.put("fInternalGasPower", fInternalGasPower);
            InternalGasturbinePowerCurve.put("internalgasConsumption", internalgasConsumption);
            createXml(InternalGasturbinePowerCurve, pa, "fInternalGasPower");
        }

//      MunicipalSteamParameter.xml  MunicipalSteam
        pa = pathIO + File.separator + "MunicipalSteamParameter.xml";
        createXml(data.getJSONObject("formData").getJSONObject("system").getJSONObject("steam"), pa, "MunicipalSteamParameter");

//      NuclearPowerParameter.xml  NuclearPower
        pa = pathIO + File.separator + "NuclearPowerParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("nuclear_power"), pa, "NuclearPowerParameter");

//      PhotovoltaicParameter.xml  Photovoltaic
        pa = pathIO + File.separator + "PhotovoltaicParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("photovoltaic"), pa, "PhotovoltaicParameter");

//      PowerPriload.xml PowerPriload  页面电负荷导入，未实现，先模拟
        {
            JSONObject PowerPriload = new JSONObject(true);
            System.out.println(data.getJSONObject("deviceData").getJSONArray("elec"));
            for (int i = 1; i < 25; i++) {
                PowerPriload.put("vPrimaryLoad"+i, data.getJSONObject("deviceData").getJSONArray("elec").getJSONObject(i-1).getString("vPrimaryLoad"));
            }
            pa = pathIO + File.separator + "PowerPriload.xml";
            createXml(PowerPriload, pa, "PowerPriload");
        }

//      PumpParameter.xml  Pump
        pa = pathIO + File.separator + "PumpParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("pump"), pa, "PumpParameter");


//      PurchasePrice_Grid.xml  PurchasePrice_Grid 界面 电网 未完成
        {
            JSONObject PurchasePrice_Grid = new JSONObject(true);
            for (int i = 0; i < 24; i++) {
                PurchasePrice_Grid.put("purchasePriceGrid" + i, data.getJSONObject("deviceData").getJSONObject("elec_net").getJSONArray("elec_pr").getJSONObject(i).getString("purchasePriceGrid"));
            }
            pa = pathIO + File.separator + "PurchasePrice_Grid.xml";
            createXml(PurchasePrice_Grid, pa, "PurchasePrice_Grid");
        }

//      ScrewElectricitychillerParameter.xml  ScrewElectricitychiller
        pa = pathIO + File.separator + "ScrewElectricitychillerParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("screw_electricitychiller"), pa, "ScrewElectricitychillerParameter");

//      SellingPrice_Grid.xml  SellingPrice_Grid 界面 电网 未完成
        {
            JSONObject SellingPrice_Grid = new JSONObject(true);
            for (int i = 0; i < 24; i++) {
                SellingPrice_Grid.put("sellingPriceGrid" + i, data.getJSONObject("deviceData").getJSONObject("elec_net").getJSONArray("elec_pr").getJSONObject(i).getString("sellingPriceGrid"));
            }
            pa = pathIO + File.separator + "SellingPrice_Grid.xml";
            createXml(SellingPrice_Grid, pa, "SellingPrice_Grid");
        }

//      SolarRadiation.SolarRadiation Coolload  页面冷负荷导入，未实现，先模拟
        {
            JSONObject SolarRadiation = new JSONObject(true);
            for (int i = 1; i < 8761; i++) {
                SolarRadiation.put("vPVSource" + i, "800");
            }
            pa = pathIO + File.separator + "SolarRadiation.xml";
            createXml(SolarRadiation, pa, "SolarRadiation");
        }

//      SourceParameter.xml  SourceParameter
        pa = pathIO + File.separator + "SourceParameter.xml";
        createXml(data.getJSONObject("formData").getJSONObject("constraint").getJSONObject("SourceParameter"), pa, "SourceParameter");


//      SystemParameter.xml  SystemParameter  未实现
        {
            JSONObject SystemParameter = new JSONObject(true);
            SystemParameter.put("penaltyforCapacityShortage", "0"); //这参数软件那边隐藏了

            Iterator<String> it = data.getJSONObject("formData").getJSONObject("emission").keySet().iterator(); //6个emission
            while (it.hasNext()) {
                String key = it.next();
                SystemParameter.put(key, data.getJSONObject("formData").getJSONObject("emission").getString(key));
            }

            SystemParameter.put("factorLossCap", "0"); //这参数软件那边隐藏了

            //网购电量折算 在电网的界面
            for (int i = 0; i < 6; i++) {
                SystemParameter.put("vGridEmissionFactor" + i, data.getJSONObject("deviceData").getJSONObject("elec_net").getJSONObject("vGridEmissionFactor").getString("vGridEmissionFactor" + i));
            }

            it = data.getJSONObject("formData").getJSONObject("system").getJSONObject("system").keySet().iterator();
            while (it.hasNext()) {
                String key = it.next();
                SystemParameter.put(key, data.getJSONObject("formData").getJSONObject("system").getJSONObject("system").getString(key));
            }

            it = data.getJSONObject("formData").getJSONObject("economy").getJSONObject("system").keySet().iterator();
            while (it.hasNext()) {
                String key = it.next();
                SystemParameter.put(key, data.getJSONObject("formData").getJSONObject("economy").getJSONObject("system").getString(key));
            }

            pa = pathIO + File.separator + "SystemParameter.xml";
            createXml(SystemParameter, pa, "SystemParameter");
        }


//      Steamload.xml Steamload  页面蒸汽负荷导入，未实现，先模拟
        {
            JSONObject Steamload = new JSONObject(true);
            for (int i = 1; i < 25; i++) {
                Steamload.put("vSteamLoad"+i, data.getJSONObject("deviceData").getJSONArray("steam").getJSONObject(i-1).getString("vSteamLoad"));
            }
            pa = pathIO + File.separator + "Steamload.xml";
            createXml(Steamload, pa, "Steamload");
        }

//      WasteheatboilerParameter.xml  Wasteheatboiler
        pa = pathIO + File.separator + "WasteheatboilerParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("waste_heat_boiler"), pa, "WasteheatboilerParameter");

//      WaterFlow.xml WaterFlow  页面水资源导入，未实现，先模拟
        {
            JSONObject WaterFlow = new JSONObject(true);
            for (int i = 1; i < 8761; i++) {
                WaterFlow.put("vWaterFlow" + i, "800");
            }
            pa = pathIO + File.separator + "WaterFlow.xml";
            createXml(WaterFlow, pa, "WaterFlow");
        }

//      windSpeed.xml windSpeed  页面风资源导入，未实现，先模拟
        {
            JSONObject windSpeed = new JSONObject(true);
            for (int i = 1; i < 8761; i++) {
                windSpeed.put("vWindSpeed" + i, "800");
            }
            pa = pathIO + File.separator + "windSpeed.xml";
            createXml(windSpeed, pa, "windSpeed");
        }

//      WindTurbineParameter.xml  WindTurbine
        pa = pathIO + File.separator + "WindTurbineParameter.xml";
        createXml(data.getJSONObject("deviceData").getJSONObject("wind_turbine"), pa, "WindTurbineParameter");

//      WTPowerCurve.xml  WTPowerCurve
        {
            pa = pathIO + File.separator + "WTPowerCurve.xml";
            JSONObject WTPowerCurve = new JSONObject(true);
            JSONObject fWindSpeed = new JSONObject(true);
            JSONObject fPower = new JSONObject(true);
            if (data.getJSONObject("deviceData").getJSONObject("wind_turbine") != null) {
                String[] s = data.getJSONObject("deviceData").getJSONObject("wind_turbine").getString("fWindSpeed").split(",");
                for (int i = 0; i < s.length; i++) {
                    fWindSpeed.put("fWindSpeed" + (i + 1), s[i]);
                }
                s = data.getJSONObject("deviceData").getJSONObject("wind_turbine").getString("fPower").split(",");
                for (int i = 0; i < s.length; i++) {
                    fPower.put("fPower" + (i + 1), s[i]);
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    fWindSpeed.put("fWindSpeed" + (i + 1), "0");
                }
                for (int i = 0; i < 3; i++) {
                    fPower.put("fPower" + (i + 1), "0");
                }
            }
            WTPowerCurve.put("fWindSpeed", fWindSpeed);
            WTPowerCurve.put("fPower", fPower);
            createXml(WTPowerCurve, pa, "fWindSpeed");
        }


    }

    public void createXml(JSONObject data, String path, String name) {
        if (data == null) {
            try {
                File file = new File(path);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("");
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("生成" + name + ".xml失败");
            }
            return;
        }
        if (data.getJSONObject("id") != null)
            data = data.getJSONObject("id");
        try {
            // 创建解析器工厂
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            Document document = db.newDocument();
            // 不显示standalone="no"
            document.setXmlStandalone(true);
            Element bookstore = document.createElement(name);
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                Object o = entry.getValue();
                if (o instanceof String) {
                    Element node = document.createElement(entry.getKey());
                    // 不显示内容 name.setNodeValue("不好使");
                    node.setTextContent(entry.getValue().toString());
                    bookstore.appendChild(node);
                } else {
                    Element node = document.createElement(entry.getKey());
                    node_insert(document, node, data.getJSONObject(entry.getKey()));
                    bookstore.appendChild(node);
                }
            }
            // 将bookstore节点（已包含book）添加到dom树中
            document.appendChild(bookstore);

            // 创建TransformerFactory对象
            TransformerFactory tff = TransformerFactory.newInstance();
            // 创建 Transformer对象
            Transformer tf = tff.newTransformer();

            // 输出内容是否使用换行
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            // 创建xml文件并写入内容
            tf.transform(new DOMSource(document), new StreamResult(new File(path)));
//            System.out.println("生成"+name+".xml成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成" + name + ".xml失败");
        }
    }

    public void node_insert(Document document, Element node, JSONObject data) {
        if (data == null) return;
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            Object o = entry.getValue();
            if (o instanceof String) {
                Element child = document.createElement(entry.getKey());
                // 不显示内容 name.setNodeValue("不好使");
                child.setTextContent(entry.getValue().toString());
                node.appendChild(child);
            } else {
                Element child = document.createElement(entry.getKey());
                node_insert(document, child, data.getJSONObject(entry.getKey()));
                node.appendChild(child);
            }
        }
    }

    public String readFile(String path) {
        String ret = "";
        try {

            File tempfile = new File(path);
            FileInputStream in = new FileInputStream(tempfile);
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                ret = ret + scanner.nextLine() + '\n';
            }
            in.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;

    }

    public boolean checkFinish(String username, String recordname) {
        String path = "F:" + File.separator + username + File.separator + recordname + File.separator + "exe" + File.separator + "IO" + File.separator + "OUT0";
        String[] filePath = null;
        try {

            File file = new File(path);
            filePath = file.list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (filePath.length > 0)
            return true;
        else
            return false;
    }


    public void createUser(String username) {
        String newPath = "/" + username;
        try {
            if (!(new File(newPath)).exists()) {
                (new File(newPath)).mkdir();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getExe(String username, String recordname) {
//        String a="F:"+File.separator+username+File.separator+recordname+File.separator+"exe"+File.separator+"DesignElectricPower_Test.exe";
//        System.out.println(a);
        return "F:" + File.separator + username + File.separator + recordname + File.separator + "exe" + File.separator + "DesignElectricPower_Test.exe";
    }

    public static String getDir(String username, String recordname) {
        return "F:" + File.separator + username + File.separator + recordname;
    }


    public static void copyFolder(String oldPath, String newPath) {

        try {
            (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹
            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }

                if (temp.isFile()) {
                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + "/" +
                            (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {//如果是子文件夹
                    copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
                }
            }
        } catch (Exception e) {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();

        }
    }


//    public static void copyDir(String sourcePath, String newPath) throws IOException {
//        File file = new File(sourcePath);
//        String[] filePath = file.list();
//
//        if (!(new File(newPath)).exists()) {
//            (new File(newPath)).mkdir();
//        }
//        System.out.println("sasa");
//        for (int i = 0; i < filePath.length; i++) {
//            if ((new File(sourcePath + file.separator + filePath[i])).isDirectory()) {
//                if(filePath[i].equals("IO"))
//                    continue;
//
//                copyDir(sourcePath  + file.separator  + filePath[i], newPath  + file.separator + filePath[i]);
//            }
//
//            if (new File(sourcePath  + file.separator + filePath[i]).isFile()) {
//                copyFile(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
//            }
//
//        }
//    }


    public static void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);
        ;

        byte[] buffer = new byte[2097152];
        int readByte = 0;
        while ((readByte = in.read(buffer)) != -1) {
            out.write(buffer, 0, readByte);
        }

        in.close();
        out.close();
    }

    public static void getIO(Record record) {
        String username = record.getOwner();
        String recordname = record.getName();
        String path = "F:\\6.12\\bin\\IO\\IN0";
        List<String> files = new ArrayList<String>();
        File file = new File(path);
        File[] tempList = file.listFiles();
        String input = "";
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                files.add(tempList[i].toString());
                StringBuilder result = new StringBuilder();
                File file1 = new File(tempList[i].toString());
                if (file1.exists()) {
                    //System.out.println(tempList[i].toString().split("\\\\")[tempList[i].toString().split("\\\\").length-1]);
                    input += "|" + tempList[i].toString().split("\\\\")[tempList[i].toString().split("\\\\").length - 1] + ":";
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tempList[i].toString()), "gbk"));
                        String s = null;
                        while ((s = br.readLine()) != null) {
                            result.append(s + "\n");
                        }
                        br.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                input += result;
            }
        }

        input = input.substring(1, input.length() - 1);
        try {
            FileOutputStream out = new FileOutputStream("F:" + File.separator + username + File.separator + recordname + File.separator + "1.txt");
            out.write(input.getBytes());
            out.close();
        } catch (Exception e) {

        }


    }


}
