package edu.tju.scs.TinyNetBackend.controller;


import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.service.Screw_electricitychillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Screw_electricitychillerController {

    @Autowired
    protected Screw_electricitychillerService screw_electricitychillerService;



    @RequestMapping(value = "/tinyNet/device/screw_electricitychiller/add",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport add(@RequestBody(required=false) JSONObject data)
    {
        System.out.println(data);
        ErrorReport result = screw_electricitychillerService.add(data.getJSONObject("screw_electricitychiller"),data.getString("token"));
        return result;
    }

    @RequestMapping(value = "/tinyNet/device/screw_electricitychiller/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = screw_electricitychillerService.update(data.getJSONObject("screw_electricitychiller"),data.getString("token"));
        return result;
    }

    @RequestMapping(value = "/tinyNet/device/screw_electricitychiller/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = screw_electricitychillerService.select(data.getString("token"),data.getInteger("id"));
        return result;
    }


    @RequestMapping(value = "/tinyNet/device/screw_electricitychiller/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = screw_electricitychillerService.delete(data.getString("token"),data.getInteger("id"));
        return result;
    }


    @RequestMapping(value = "/tinyNet/device/screw_electricitychiller/list",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport list(@RequestBody(required=false) JSONObject data){
        ErrorReport result =  screw_electricitychillerService.list(data.getString("token"),data.getInteger("pi"),data.getInteger("ps"),data.getString("val"));
        return result;
    }




}
