package edu.tju.scs.TinyNetBackend.controller;


import edu.tju.scs.TinyNetBackend.common.Annotaion.JWTAuth;
import edu.tju.scs.TinyNetBackend.model.po.Wind_Turbines;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseObjectData;
import edu.tju.scs.TinyNetBackend.mapper.Wind_TurbinesMapper;
import edu.tju.scs.TinyNetBackend.service.JWTService;
import edu.tju.scs.TinyNetBackend.service.LoginService;
import edu.tju.scs.TinyNetBackend.service.Wind_TurbinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class Wind_TurbinesController {

    @Autowired
    protected Wind_TurbinesService wind_turbinesService;

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/wind_turbines/add",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport add(@RequestBody Wind_Turbines wind_turbines,HttpServletRequest request)
    {
        ErrorReport result = wind_turbinesService.add(request,wind_turbines);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/wind_turbines/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody Wind_Turbines wind_turbines,HttpServletRequest request)
    {
        ErrorReport result = wind_turbinesService.update(request,wind_turbines);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/wind_turbines/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(int id,HttpServletRequest request)
    {
        ErrorReport result = wind_turbinesService.select(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/wind_turbines/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(int id,HttpServletRequest request)
    {
        ErrorReport result = wind_turbinesService.delete(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/wind_turbines/list",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport list(HttpServletRequest request){


        ErrorReport result =  wind_turbinesService.list(request);

        return result;

    }
}
