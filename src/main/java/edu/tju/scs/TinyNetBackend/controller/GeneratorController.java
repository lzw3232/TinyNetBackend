package edu.tju.scs.TinyNetBackend.controller;


import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.Annotaion.JWTAuth;
import edu.tju.scs.TinyNetBackend.model.po.Generator;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.mapper.GeneratorMapper;
import edu.tju.scs.TinyNetBackend.service.GeneratorService;
import edu.tju.scs.TinyNetBackend.service.JWTService;
import edu.tju.scs.TinyNetBackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GeneratorController {


    @Autowired
    protected GeneratorService generatorService;

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/generator/add",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport add(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = generatorService.add(data.getJSONObject("generator"),data.getString("token"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/generator/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = generatorService.update(data.getJSONObject("generator"),data.getString("token"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/generator/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = generatorService.select(data.getString("token"),data.getInteger("id"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/generator/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(@RequestBody(required=false) JSONObject data)
    {
        ErrorReport result = generatorService.delete(data.getString("token"),data.getInteger("id"));
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/generator/list",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport list(@RequestBody(required=false) JSONObject data){
        ErrorReport result =  generatorService.list(data.getString("token"),data.getInteger("pi"),data.getInteger("ps"),data.getString("val"));
        return result;
    }

}
