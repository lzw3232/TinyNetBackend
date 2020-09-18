package edu.tju.scs.TinyNetBackend.controller;


import edu.tju.scs.TinyNetBackend.common.Annotaion.JWTAuth;
import edu.tju.scs.TinyNetBackend.model.po.Turbine;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseObjectData;
import edu.tju.scs.TinyNetBackend.mapper.TurbineMapper;
import edu.tju.scs.TinyNetBackend.service.JWTService;
import edu.tju.scs.TinyNetBackend.service.LoginService;
import edu.tju.scs.TinyNetBackend.service.TurbineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TurbineContorller {

    @Autowired
    protected TurbineService turbineService;

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/turbine/add",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport add(@RequestBody Turbine turbine,HttpServletRequest request)
    {
        ErrorReport result = turbineService.add(request,turbine);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/turbine/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody Turbine turbine,HttpServletRequest request)
    {
        ErrorReport result = turbineService.update(request,turbine);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/turbine/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(int id,HttpServletRequest request)
    {
        ErrorReport result = turbineService.select(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/turbine/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(int id,HttpServletRequest request)
    {
        ErrorReport result = turbineService.delete(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/turbine/list",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport list(HttpServletRequest request){


        ErrorReport result =  turbineService.list(request);

        return result;

    }

}
