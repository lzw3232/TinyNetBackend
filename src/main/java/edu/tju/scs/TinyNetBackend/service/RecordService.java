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

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private BatteryMapper batteryMapper;
    @Autowired
    private GeneratorMapper generatorMapper;

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
        record.setName(data.getString("name"));
        record.setState(0);
        JSONObject devices = data.getJSONObject("deviceData");
        devices = getDevices(devices,username);
        data.put("deviceData",devices);

        RecordList.add1(record,data,username);
        String new_token=TokenUtil.getToken(username);
        return new ErrorReport(0,"success");
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

    private JSONObject getDevices(JSONObject data,String owner){
        Iterator<String> it = data.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            switch (key){
                case "battery":
                    Battery battery;
                    if(data.getJSONObject(key).getInteger("id")!=null){
                        battery= batteryMapper.selectByPrimaryKey(data.getJSONObject(key).getInteger("id"));
                    }
                    else{
                        battery = batteryMapper.selectByOwner(owner,0,10).get(0);
                    }
                    Battery_ours battery_ours = new Battery_ours(battery);
                    data.getJSONObject(key).put("string1",battery_ours.toString1());
                    data.getJSONObject(key).put("string2",battery_ours.toString2());
                    break;

                case "generator":
                    Generator generator;
                    if(data.getJSONObject(key).getInteger("id")!=null){
                        generator= generatorMapper.selectByPrimaryKey(data.getJSONObject(key).getInteger("id"));
                    }
                    else{
                        generator = generatorMapper.selectByOwner(owner,0,10).get(0);
                    }
                    Generator_ours generator_ours = new Generator_ours(generator);
                    data.getJSONObject(key).put("string1",generator_ours.toString1());
                    data.getJSONObject(key).put("string2",generator_ours.toString2());
                    break;
            }
        }

        return data;
    }
}
