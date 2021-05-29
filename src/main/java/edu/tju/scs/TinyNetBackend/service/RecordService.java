package edu.tju.scs.TinyNetBackend.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.FileHelper;
import edu.tju.scs.TinyNetBackend.common.RecordList;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.*;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseObjectData;
import edu.tju.scs.TinyNetBackend.model.po.*;
import edu.tju.scs.TinyNetBackend.model.ours.*;
import edu.tju.scs.TinyNetBackend.model.po.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

import java.lang.reflect.*;

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    protected AbschilleMapper abschilleMapper;
    @Autowired
    private BatteryMapper batteryMapper;
    @Autowired
    protected Centrifugal_electricitychillerMapper centrifugal_electricitychillerMapper;
    @Autowired
    protected Cool_storageMapper cool_storageMapper;
    @Autowired
    protected DieselMapper dieselMapper;
    @Autowired
    protected Elec_airconditionMapper elec_airconditionMapper;
    @Autowired
    protected Elec_boilerMapper elec_boilerMapper;
    @Autowired
    protected ElectricitychillerMapper electricitychillerMapper;
    @Autowired
    protected Gas_abschilleMapper gas_abschilleMapper;
    @Autowired
    protected Gas_boilerMapper gas_boilerMapper;
    @Autowired
    protected Gas_steam_boilerMapper gas_steam_boilerMapper;
    @Autowired
    protected Gas_turbineMapper gas_turbineMapper;
    @Autowired
    protected Heat_exchangerMapper heat_exchangerMapper;
    @Autowired
    protected Heat_storageMapper heat_storageMapper;
    @Autowired
    protected Hydro_turbineMapper hydro_turbineMapper;
    @Autowired
    protected Internal_gas_turbineMapper internal_gas_turbineMapper;
    @Autowired
    protected Nuclear_powerMapper nuclear_powerMapper;
    @Autowired
    protected PhotovoltaicMapper photovoltaicMapper;
    @Autowired
    protected PumpMapper pumpMapper;
    @Autowired
    protected Screw_electricitychillerMapper screw_electricitychillerMapper;
    @Autowired
    protected Waste_heat_boilerMapper waste_heat_boilerMapper;
    @Autowired
    protected Wind_turbineMapper wind_turbineMapper;

    private boolean check(int id,String owner)
    {
        if(recordMapper.selectByPrimaryKey(id)==null||!owner.equals(recordMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }

    public ErrorReport add(String token, JSONObject data)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        Record record =new Record();
        record.setOwner(username);
        System.out.println(data);
        record.setName(data.getString("name"));
        record.setState(0);
        JSONObject devices = data.getJSONObject("deviceData");
        try{
            devices = getDevices(devices,username);
        }
        catch (Exception e){
            System.out.println(e);
        }
        data.put("deviceData",devices);

        RecordList.add1(record,data,username);
        String new_token=TokenUtil.getToken(username);

        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(String token,JSONObject record)
    {

        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        return new ErrorReport(0,"success");
    }

    public ErrorReport delete(String token,int id)
    {

        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist");
        recordMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success");
    }


    public ErrorReport select(String token,int id)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist");
        RecordList.update();
        Record record=recordMapper.selectByPrimaryKey(id);
        if(record!=null)
            return new ErrorReport(0,"success",new ResponseObjectData(record));
        else
            return new ErrorReport(11,"id not found");

    }

    public ErrorReport list(String token,int pi, int ps,String val)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);

        List<Record> recordlist;

        if(val==""){
            recordlist = recordMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = recordMapper.countB();
            response.addData("total",total);
        }
        else{
            recordlist = recordMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = recordMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("data",recordlist);

        return new ErrorReport(0,"success",response);
    }



    public ErrorReport action(String token,JSONObject data)//HttpServletRequest request,
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        System.out.println(data);
        return new ErrorReport(0,"success");
//        RecordWithBLOBs record=recordMapper.selectByPrimaryKey(recordname);
//        if(RecordList.check(record)){
//            Thread thread = new Thread(){
//                public void run() {
//                    RecordList.add(record);
//                }};
//            thread.start();
//            // 获取子线程的返回值：主线程等待法
//            while (!RecordList.check(record)){
//                try {
//                    Thread.sleep(1000);
//                }catch (InterruptedException e) {
//                    System.out.println("Thread interrupted.");
//                }
//            }
//            return new ErrorReport(0,"success",response);
//        }
//        else{
//            return new ErrorReport(1,"This project is Running",response);
//        }


//        if(!username.equals(record.getOwner()))
//            return  new ErrorReport(31,"id no exist");
//        if(RecordList.check(record))
//        {
//            if(RecordList.checkNum())
//            {
//                RecordList.add(record);
//                record.setState(1);
//                recordMapper.updateByPrimaryKey(record);
//                return new ErrorReport(0,"success");
//            }
//
//            else
//                return new ErrorReport(22,"Quantitative restriction");
//        }
//        else
//            return new ErrorReport(21,"another record for this user already running");

    }

    public ErrorReport getRes(String token,int id)//HttpServletRequest request,
    {
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Record record=recordMapper.selectByPrimaryKey(id);
        JSONObject res = RecordList.getRes(record);
        response.addData("data",res.getString("data"));
        return new ErrorReport(Integer.parseInt(res.getString("errno")),res.getString("errmsg"),response);

    }

    public ErrorReport getOutput(String token,int id)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);

        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        if(!check(id,username)){
            return new ErrorReport(31,"id no exist",response);
        }
        Record record=recordMapper.selectByPrimaryKey(id);
        if(record.getOutput().length()<=10){
            String output = RecordList.getOutput(record);
            if(output.length()>=10){
                record.setOutput(output);
                recordMapper.updateByPrimaryKey(record);
                response.addData("output", JSON.parseObject(output));
            }
        }
        else{
            response.addData("output",JSON.parseObject(record.getOutput()));
        }
        return new ErrorReport(0,"success",response);
    }

    private JSONObject getDevices(JSONObject data,String owner) throws Exception{
        Iterator<String> it = data.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            Field[] fields;
            JSONObject s;
            switch (key) {
                case "abschille":
                    Abschille abschille;
                    abschille =  abschilleMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","溴化锂空调");
                    fields = abschille.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(abschille).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "battery":
                    Battery battery = batteryMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","电池");
                    fields = battery.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(battery).toString());
                    }
                    s.put("currentSOC",data.getJSONObject(key).getString("currentSOC"));
                    s.put("maximumSOC",data.getJSONObject(key).getString("maximumSOC"));
                    s.put("minimumSOC",data.getJSONObject(key).getString("minimumSOC"));
                    s.put("convEfficiency",data.getJSONObject(key).getString("convEfficiency"));
                    s.put("invEfficiency",data.getJSONObject(key).getString("invEfficiency"));
                    data.getJSONObject(key).put("id", s);
                    break;
                case "centrifugal_electricitychiller":
                    Centrifugal_electricitychiller centrifugal_electricitychiller = centrifugal_electricitychillerMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","电池冷机");
                    fields = centrifugal_electricitychiller.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(centrifugal_electricitychiller).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "cool_storage":
                    Cool_storage cool_storage = cool_storageMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","蓄冰装置");
                    fields = cool_storage.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(cool_storage).toString());
                    }
                    s.put("currentSOC",data.getJSONObject(key).getString("currentSOC"));
                    s.put("maximumSOC",data.getJSONObject(key).getString("maximumSOC"));
                    s.put("minimumSOC",data.getJSONObject(key).getString("minimumSOC"));
                    data.getJSONObject(key).put("id", s);
                    break;
                case "diesel":
                    Diesel diesel = dieselMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","柴油机");
                    fields = diesel.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name" || f.getName() == "type")
                            continue;
                        if (f.getName() == "fDieselPower" || f.getName() == "fuelConsumption") {
                            data.getJSONObject(key).put(f.getName(),f.get(diesel).toString());
                            continue;
                        }
                        s.put(f.getName(),f.get(diesel).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "elecaircondition":
                    Elec_aircondition elecaircondition = elec_airconditionMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","双工况制冷机");
                    fields = elecaircondition.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(elecaircondition).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "elec_boiler":
                    Elec_boiler elec_boiler = elec_boilerMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","电锅炉");
                    fields = elec_boiler.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(elec_boiler).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "electricitychiller":
                    Electricitychiller electricitychiller = electricitychillerMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","涡旋式电制冷机");
                    fields = electricitychiller.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(electricitychiller).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "gas_abschille":
                    Gas_abschille gas_abschille = gas_abschilleMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","直燃型溴化锂空调");
                    fields = gas_abschille.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(gas_abschille).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "gas_boiler":
                    Gas_boiler gas_boiler = gas_boilerMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","燃气锅炉");
                    fields = gas_boiler.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(gas_boiler).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "gas_steam_boiler":
                    Gas_steam_boiler gas_steam_boiler = gas_steam_boilerMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","燃气蒸汽锅炉");
                    fields = gas_steam_boiler.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(gas_steam_boiler).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "gas_turbine":
                    Gas_turbine gas_turbine = gas_turbineMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","燃气轮机");
                    fields = gas_turbine.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        if (f.getName() == "fGasPower" || f.getName() == "gasConsumption") {
                            data.getJSONObject(key).put(f.getName(), f.get(gas_turbine).toString());
                            continue;
                        }
                        s.put(f.getName(),f.get(gas_turbine).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "heat_exchanger":
                    Heat_exchanger heat_exchanger = heat_exchangerMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","板式换热器");
                    fields = heat_exchanger.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(heat_exchanger).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "heat_storage":
                    Heat_storage heat_storage = heat_storageMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","蓄热装置");
                    fields = heat_storage.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(heat_storage).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "hydro_turbine":
                    Hydro_turbine hydro_turbine = hydro_turbineMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","水轮机");
                    fields = hydro_turbine.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(hydro_turbine).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "internal_gas_turbine":
                    Internal_gas_turbine internal_gas_turbine = internal_gas_turbineMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","燃气内燃机");
                    fields = internal_gas_turbine.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        if (f.getName() == "fInternalGasPower" || f.getName() == "internalgasConsumption") {
                            data.getJSONObject(key).put(f.getName(), f.get(internal_gas_turbine).toString());
                            continue;
                        }
                        s.put(f.getName(),f.get(internal_gas_turbine).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "nuclear_power":
                    Nuclear_power nuclear_power = nuclear_powerMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","核电机组");
                    fields = nuclear_power.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(nuclear_power).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "photovoltaic":
                    Photovoltaic photovoltaic = photovoltaicMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","光伏");
                    fields = photovoltaic.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(photovoltaic).toString());
                    }
                    s.put("slope",data.getJSONObject(key).getString("slope"));
                    s.put("azimuth",data.getJSONObject(key).getString("azimuth"));
                    s.put("groundReflectance",data.getJSONObject(key).getString("groundReflectance"));
                    s.put("transmissivity",data.getJSONObject(key).getString("transmissivity"));
                    data.getJSONObject(key).put("id", s);
                    break;
                case "pump":
                    Pump pump = pumpMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","热泵");
                    fields = pump.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(pump).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "screw_electricitychiller":
                    Screw_electricitychiller screw_electricitychiller = screw_electricitychillerMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","螺杆式电制冷机");
                    fields = screw_electricitychiller.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(screw_electricitychiller).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "waste_heat_boiler":
                    Waste_heat_boiler waste_heat_boiler = waste_heat_boilerMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","余热锅炉");
                    fields = waste_heat_boiler.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        s.put(f.getName(),f.get(waste_heat_boiler).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
                case "wind_turbine":
                    Wind_turbine wind_turbine = wind_turbineMapper.selectByOwner(owner, 0, 10).get(0);
                    s = new JSONObject(true);
                    s.put("name","风机");
                    fields = wind_turbine.getClass().getDeclaredFields();
                    for (int i = 0; i < fields.length; i++) {
                        Field f = fields[i];
                        f.setAccessible(true);
                        if (f.getName() == "id" || f.getName() == "owner" || f.getName() == "name") continue;
                        if (f.getName() == "fPower" || f.getName() == "fWindSpeed") {
                            data.getJSONObject(key).put(f.getName(), f.get(wind_turbine).toString());
                            continue;
                        }
                        s.put(f.getName(),f.get(wind_turbine).toString());
                    }
                    data.getJSONObject(key).put("id", s);
                    break;
            }
        }
        System.out.println(data);

        return data;
    }
}
