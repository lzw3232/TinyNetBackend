package edu.tju.scs.TinyNetBackend.controller;


import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.service.DieselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DieselController {

    @Autowired
    protected DieselService dieselService;



    @RequestMapping(value = "/tinyNet/device/diesel/add",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport add(@RequestBody(required=false) JSONObject data)
    {
        System.out.println(data);
        ErrorReport result = dieselService.add(data.getJSONObject("diesel"),data.getString("token"));
        return result;
    }

    @RequestMapping(value = "/tinyNet/device/diesel/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = dieselService.update(data.getJSONObject("diesel"),data.getString("token"));
        return result;
    }

    @RequestMapping(value = "/tinyNet/device/diesel/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = dieselService.select(data.getString("token"),data.getInteger("id"));
        return result;
    }


    @RequestMapping(value = "/tinyNet/device/diesel/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = dieselService.delete(data.getString("token"),data.getInteger("id"));
        return result;
    }


    @RequestMapping(value = "/tinyNet/device/diesel/list",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport list(@RequestBody(required=false) JSONObject data){
        ErrorReport result =  dieselService.list(data.getString("token"),data.getInteger("pi"),data.getInteger("ps"),data.getString("val"));
        return result;
    }




}
