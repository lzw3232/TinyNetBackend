package edu.tju.scs.TinyNetBackend.controller;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.service.Elec_airconditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Elec_airconditionController {


    @Autowired
    protected Elec_airconditionService elec_airconditionService;


    @RequestMapping(value = "/tinyNet/device/elec_aircondition/add",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport add(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = elec_airconditionService.add(data.getJSONObject("elec_aircondition"),data.getString("token"));
        return result;
    }


    @RequestMapping(value = "/tinyNet/device/elec_aircondition/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = elec_airconditionService.update(data.getJSONObject("elec_aircondition"),data.getString("token"));
        return result;
    }


    @RequestMapping(value = "/tinyNet/device/elec_aircondition/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = elec_airconditionService.select(data.getString("token"),data.getInteger("id"));
        return result;
    }


    @RequestMapping(value = "/tinyNet/device/elec_aircondition/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = elec_airconditionService.delete(data.getString("token"),data.getInteger("id"));
        return result;
    }


    @RequestMapping(value = "/tinyNet/device/elec_aircondition/list",method = RequestMethod.POST)
    @ResponseBody
    @JsonProperty("ErrorReport")
    public ErrorReport list(@RequestBody(required=false) JSONObject data){
        ErrorReport result =  elec_airconditionService.list(data.getString("token"),data.getInteger("pi"),data.getInteger("ps"),data.getString("val"));
        return result;
    }

}
