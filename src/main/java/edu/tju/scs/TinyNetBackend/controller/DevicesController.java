//package edu.tju.scs.TinyNetBackend.controller;
//
//
//import com.alibaba.fastjson.JSONObject;
//import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
//import edu.tju.scs.TinyNetBackend.service.DevicesService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class DevicesController {
//
//    @Autowired
//    protected DevicesService deviceService;
//
//
//
//    @RequestMapping(value = "/tinyNet/device/{device}/add",method = RequestMethod.POST)
//    @ResponseBody
//    public ErrorReport add(@RequestBody(required=false) JSONObject data,@PathVariable String device)
//    {
//        System.out.println(data);
//        ErrorReport result = deviceService.add(data.getJSONObject(device),data.getString("token"),String device);
//        return result;
//    }
//
//    @RequestMapping(value = "/tinyNet/device/{device}/update",method = RequestMethod.POST)
//    @ResponseBody
//    public ErrorReport update(@RequestBody(required=false) JSONObject data,@PathVariable String device)
//    {
//        ErrorReport result = deviceService.update(data.getJSONObject(device),data.getString("token"),String device);
//        return result;
//    }
//
//    @RequestMapping(value = "/tinyNet/device/{device}/select",method = RequestMethod.POST)
//    @ResponseBody
//    public ErrorReport select(@RequestBody(required=false) JSONObject data,@PathVariable String device)
//    {
//        ErrorReport result = deviceService.select(data.getString("token"),data.getInteger("id"),String device);
//        return result;
//    }
//
//
//    @RequestMapping(value = "/tinyNet/device/{device}/delete",method = RequestMethod.POST)
//    @ResponseBody
//    public ErrorReport delete(@RequestBody(required=false) JSONObject data,@PathVariable String device)
//    {
//        ErrorReport result = deviceService.delete(data.getString("token"),data.getInteger("id"),String device);
//        return result;
//    }
//
//    @RequestMapping(value = "/tinyNet/device/{device}/list",method = RequestMethod.POST)
//    @ResponseBody
//    public ErrorReport list(@RequestBody(required=false) JSONObject data,@PathVariable String device){
//        ErrorReport result =  deviceService.list(data.getString("token"),data.getInteger("pi"),data.getInteger("ps"),data.getString("val"),String device);
//        return result;
//    }
//
//
//
//
//
//}
