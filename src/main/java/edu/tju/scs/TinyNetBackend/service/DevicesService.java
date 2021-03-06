//package edu.tju.scs.TinyNetBackend.service;
//
//import com.alibaba.fastjson.JSONObject;
//import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
//import edu.tju.scs.TinyNetBackend.mapper.BatteryMapper;
//import edu.tju.scs.TinyNetBackend.mapper.CentrifugalMapper;
//import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
//import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
//import edu.tju.scs.TinyNetBackend.model.po.Battery;
//import edu.tju.scs.TinyNetBackend.model.po.Centrifugal;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.annotations.Mapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.hash.HashMapper;
//import org.springframework.stereotype.Service;
//
//import java.lang.reflect.Array;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//@Slf4j
//@Service
//public class DevicesService {
//
//    @Autowired
//    protected BatteryMapper batteryMapper;
//    protected CentrifugalMapper centrifugalMapper;
//
//    private Map<String,Object> devices_mapper = new HashMap<>(){
//        {
//            put("battery", batteryMapper);
//            put("centrifugal", centrifugalMapper);
//        }
//    };
//
//    private boolean check(int id,String owner)
//    {
//        if(batteryMapper.selectByPrimaryKey(id)==null||!owner.equals(batteryMapper.selectByPrimaryKey(id).getOwner()))
//            return false;
//        return true;
//    }
//
//    private Object getObject(String device_name,JSONObject device){
//        switch (device_name){
//            case "battery":
//                Battery battery = JSONObject.toJavaObject(device,Battery.class);
//                return battery;
//            case "centrifugal":
//                Centrifugal centrifugal = JSONObject.toJavaObject(device,Centrifugal.class);
//                return centrifugal;
//        }
//
//    }
//
//
//    public ErrorReport add(JSONObject device, String token, String devicename)
//    {
//        if(!TokenUtil.parseToken(token))
//            return new ErrorReport(2,"please login");
//        String username = TokenUtil.getAudience(token);
//        device.put("owner",username);
//        device.remove("id");
//        Object device2 = getObject(devicename,device);
//        devices_mapper.get(devicename).insert(device2);
//        String new_token=TokenUtil.getToken(username);
//        ResponseData response =new ResponseData();
//        response.addData("token",new_token);
//        return new ErrorReport(0,"success",response);
//    }
//
//    public ErrorReport update(JSONObject battery, String token)
//    {
//        if(!TokenUtil.parseToken(token))
//            return new ErrorReport(2,"please login");
//        String username = TokenUtil.getAudience(token);
//        String new_token=TokenUtil.getToken(username);
//        ResponseData response =new ResponseData();
//        response.addData("token",new_token);
//        Battery battery1 = JSONObject.toJavaObject(battery,Battery.class);
//        if(!username.equals(battery1.getOwner()))
//            return new ErrorReport(31,"id no exist",response);
//        if(!check(battery1.getId(),battery1.getOwner()))
//            return new ErrorReport(31,"id no exist",response);
//        batteryMapper.updateByPrimaryKey(battery1);
//        return new ErrorReport(0,"success",response);
//    }
//
//    public ErrorReport select(String token,int id)
//    {
//        if(!TokenUtil.parseToken(token))
//            return new ErrorReport(2,"please login");
//        String username = TokenUtil.getAudience(token);
//        String new_token=TokenUtil.getToken(username);
//
//        ResponseData response =new ResponseData();
//        response.addData("token",new_token);
//
//        if(!check(id,username)){
//            return new ErrorReport(31,"id no exist",response);
//        }
//
//        Battery battery =batteryMapper.selectByPrimaryKey(id);
//
//        if(battery!=null){
//            response.addData("data",battery);
//            return new ErrorReport(0,"success",response);
//        }
//        else{
//            return new ErrorReport(11,"id not found",response);
//        }
//    }
//
//    public ErrorReport delete(String token,int id)
//    {
//        if(!TokenUtil.parseToken(token))
//            return new ErrorReport(2,"please login");
//        System.out.println("delete");
//        String username = TokenUtil.getAudience(token);
//        String new_token=TokenUtil.getToken(username);
//
//        ResponseData response =new ResponseData();
//        response.addData("token",new_token);
//        if(!check(id,username)){
//            return new ErrorReport(31,"id no exist",response);
//        }
//        batteryMapper.deleteByPrimaryKey(id);
//        return new ErrorReport(0,"success",response);
//    }
//
//    public ErrorReport list(String token,int pi, int ps,String val)
//    {
//        if(!TokenUtil.parseToken(token))
//            return new ErrorReport(2,"please login");
//        String username = TokenUtil.getAudience(token);
//        String new_token=TokenUtil.getToken(username);
//        ResponseData response =new ResponseData();
//        response.addData("token",new_token);
//        List<Battery> batterylist;
//        if(val==""){
//            batterylist =batteryMapper.selectByOwner(username,(pi-1)*ps,ps);
//            int total = batteryMapper.countB();
//            response.addData("total",total);
//        }
//        else{
//            batterylist =batteryMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
//            int total = batteryMapper.countB1(val);
//            response.addData("total",total);
//        }
//        response.addData("list",batterylist);
//
//        return new ErrorReport(0,"success",response);
//
//    }
//    public ErrorReport lzw()
//    {
//        return new ErrorReport(0,"success");
//    }
//
//}
