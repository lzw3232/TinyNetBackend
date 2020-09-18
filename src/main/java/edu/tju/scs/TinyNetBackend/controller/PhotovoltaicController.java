package edu.tju.scs.TinyNetBackend.controller;


import edu.tju.scs.TinyNetBackend.common.Annotaion.JWTAuth;
import edu.tju.scs.TinyNetBackend.model.po.Photovoltaic;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseObjectData;
import edu.tju.scs.TinyNetBackend.mapper.PhotovoltaicMapper;
import edu.tju.scs.TinyNetBackend.service.GeneratorService;
import edu.tju.scs.TinyNetBackend.service.JWTService;
import edu.tju.scs.TinyNetBackend.service.LoginService;
import edu.tju.scs.TinyNetBackend.service.PhotovoltaicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PhotovoltaicController {

    @Autowired
    protected PhotovoltaicService photovoltaicService;

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/photovoltaic/add",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport add(@RequestBody Photovoltaic photovoltaic,HttpServletRequest request)
    {
        ErrorReport result = photovoltaicService.add(request,photovoltaic);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/photovoltaic/update",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport update(@RequestBody Photovoltaic photovoltaic,HttpServletRequest request)
    {
        ErrorReport result = photovoltaicService.update(request,photovoltaic);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/photovoltaic/select",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport select(int id,HttpServletRequest request)
    {
        ErrorReport result = photovoltaicService.select(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/photovoltaic/delete",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport delete(int id,HttpServletRequest request)
    {
        ErrorReport result = photovoltaicService.delete(request,id);
        return result;
    }

    @JWTAuth(value = {JWTService.ADMIN_ROLE, JWTService.USER_ROLE})
    @RequestMapping(value = "/tinyNet/device/photovoltaic/list",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport list(HttpServletRequest request){


        ErrorReport result =  photovoltaicService.list(request);

        return result;

    }
}
