package edu.tju.scs.TinyNetBackend.controller;


import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.Annotaion.JWTAuth;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.service.Residual_heatService;
import edu.tju.scs.TinyNetBackend.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Residual_heatController {


    @Autowired
    protected Residual_heatService residual_heatService;

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/residual_heat/add",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport add(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = residual_heatService.add(data.getJSONObject("residual_heat"),data.getString("token"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/residual_heat/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = residual_heatService.update(data.getJSONObject("residual_heat"),data.getString("token"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/residual_heat/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = residual_heatService.select(data.getString("token"),data.getInteger("id"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/residual_heat/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = residual_heatService.delete(data.getString("token"),data.getInteger("id"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/residual_heat/list",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport list(@RequestBody(required=false) JSONObject data){
        ErrorReport result =  residual_heatService.list(data.getString("token"),data.getInteger("pi"),data.getInteger("ps"),data.getString("val"));
        return result;
    }

}
