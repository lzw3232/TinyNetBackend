package edu.tju.scs.TinyNetBackend.controller;


import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.service.Hydro_turbineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hydro_turbineController {


    @Autowired
    protected Hydro_turbineService hydro_turbineService;


    @RequestMapping(value = "/tinyNet/device/hydro_turbine/add",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport add(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = hydro_turbineService.add(data.getJSONObject("hydro_turbine"),data.getString("token"));
        return result;
    }


    @RequestMapping(value = "/tinyNet/device/hydro_turbine/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = hydro_turbineService.update(data.getJSONObject("hydro_turbine"),data.getString("token"));
        return result;
    }


    @RequestMapping(value = "/tinyNet/device/hydro_turbine/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = hydro_turbineService.select(data.getString("token"),data.getInteger("id"));
        return result;
    }


    @RequestMapping(value = "/tinyNet/device/hydro_turbine/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = hydro_turbineService.delete(data.getString("token"),data.getInteger("id"));
        return result;
    }


    @RequestMapping(value = "/tinyNet/device/hydro_turbine/list",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport list(@RequestBody(required=false) JSONObject data){
        ErrorReport result =  hydro_turbineService.list(data.getString("token"),data.getInteger("pi"),data.getInteger("ps"),data.getString("val"));
        return result;
    }

}
