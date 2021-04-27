package edu.tju.scs.TinyNetBackend.controller;


import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BatteryController {

    @Autowired
    protected BatteryService batteryService;



    @RequestMapping(value = "/tinyNet/device/battery/add",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport add(@RequestBody(required=false) JSONObject data)
    {
        System.out.println(data);
        ErrorReport result = batteryService.add(data.getJSONObject("battery"),data.getString("token"));
        return result;
    }

    @RequestMapping(value = "/tinyNet/device/battery/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = batteryService.update(data.getJSONObject("battery"),data.getString("token"));
        return result;
    }

    @RequestMapping(value = "/tinyNet/device/battery/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = batteryService.select(data.getString("token"),data.getInteger("id"));
        return result;
    }


    @RequestMapping(value = "/tinyNet/device/battery/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = batteryService.delete(data.getString("token"),data.getInteger("id"));
        return result;
    }

    @RequestMapping(value = "/tinyNet/device/battery/list",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport list(@RequestBody(required=false) JSONObject data){
        ErrorReport result =  batteryService.list(data.getString("token"),data.getInteger("pi"),data.getInteger("ps"),data.getString("val"));
        return result;
    }


    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    @ResponseBody
    public String lzw(@RequestBody(required=false) JSONObject data, @PathVariable String username){
//        ErrorReport result =  batteryService.lzw(username);
        return username;
    }



}
