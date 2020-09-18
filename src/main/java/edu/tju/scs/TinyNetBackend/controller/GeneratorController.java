package edu.tju.scs.TinyNetBackend.controller;


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
    public ErrorReport add(@RequestBody Generator generator,HttpServletRequest request)
    {
        ErrorReport result = generatorService.add(request,generator);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/generator/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody Generator generator,HttpServletRequest request)
    {
        ErrorReport result = generatorService.update(request,generator);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/generator/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(int id,HttpServletRequest request)
    {
        ErrorReport result = generatorService.select(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/generator/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(int id,HttpServletRequest request)
    {
        ErrorReport result = generatorService.delete(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/generator/list",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport list(HttpServletRequest request){


        ErrorReport result =  generatorService.list(request);

        return result;

    }

}
