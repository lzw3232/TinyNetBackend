package edu.tju.scs.TinyNetBackend.controller;


import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.Annotaion.JWTAuth;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.service.Gas_steamService;
import edu.tju.scs.TinyNetBackend.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Gas_steamController {


    @Autowired
    protected Gas_steamService gas_steamService;

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/gas_steam/add",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport add(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = gas_steamService.add(data.getJSONObject("gas_steam"),data.getString("token"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/gas_steam/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = gas_steamService.update(data.getJSONObject("gas_steam"),data.getString("token"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/gas_steam/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = gas_steamService.select(data.getString("token"),data.getInteger("id"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/gas_steam/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result =gas_steamService.delete(data.getString("token"),data.getInteger("id"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/gas_steam/list",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport list(@RequestBody(required=false) JSONObject data){
        ErrorReport result =  gas_steamService.list(data.getString("token"),data.getInteger("pi"),data.getInteger("ps"),data.getString("val"));
        return result;
    }

}
