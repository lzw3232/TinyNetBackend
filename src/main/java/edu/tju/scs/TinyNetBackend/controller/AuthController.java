package edu.tju.scs.TinyNetBackend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.model.po.User;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.service.JWTService;
import edu.tju.scs.TinyNetBackend.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class AuthController {
    @Autowired
    protected LoginService loginService;

//    @RequestMapping(value = "/",method = RequestMethod.POST)
//    @ResponseBody
//    public ErrorReport index(HttpServletRequest request){
//
//        String msg;
//        String name = loginService.isLogin(request);
//        if(name!=null) {
//            msg = "hello " + name;
//        } else {
//            msg = "not log in";
//        }
//
//        return new ErrorReport(100, "index page: " + msg);
//    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport doLogin(@RequestBody(required=false) JSONObject data){
        return loginService.login(data.getString("username"),data.getString("password"));
    }

    @RequestMapping(value = "/auth",method = RequestMethod.POST)
    @ResponseBody
    public ErrorReport check(@RequestBody(required=false) JSONObject data){
        return loginService.check(data.getString("token"));
    }

//    @RequestMapping(value = "/logout",method = RequestMethod.POST)
//    @ResponseBody
//    public ErrorReport doLogout(HttpServletRequest request){
//        return loginService.logout(request);
//    }

}
