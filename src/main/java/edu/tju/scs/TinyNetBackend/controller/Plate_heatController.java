package edu.tju.scs.TinyNetBackend.controller;


import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.Annotaion.JWTAuth;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.service.Plate_heatService;
import edu.tju.scs.TinyNetBackend.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Plate_heatController {


    @Autowired
    protected Plate_heatService plate_heatService;

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/plate_heat/add",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport add(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = plate_heatService.add(data.getJSONObject("heat_storage"),data.getString("token"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/plate_heat/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = plate_heatService.update(data.getJSONObject("heat_storage"),data.getString("token"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/plate_heat/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = plate_heatService.select(data.getString("token"),data.getInteger("id"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/plate_heat/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = plate_heatService.delete(data.getString("token"),data.getInteger("id"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/plate_heat/list",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport list(@RequestBody(required=false) JSONObject data){
        ErrorReport result =  plate_heatService.list(data.getString("token"),data.getInteger("pi"),data.getInteger("ps"),data.getString("val"));
        return result;
    }

}
