package edu.tju.scs.TinyNetBackend.service;

//import edu.tju.scs.TinyNetBackend.common.FileHelper;
import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.model.po.User;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class LoginService  {

    @Autowired
    protected UserMapper userMapper;


    public ErrorReport login(String username,String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(userMapper.selectByPrimaryKey(username)!=null)
        {
            User user = userMapper.selectByPrimaryKey(username);
            if(passwordEncoder.matches(password, user.getPassword()))
            {
                String token=TokenUtil.getToken(username);
                ResponseData response =new ResponseData();
                response.addData("token",token);
                return new ErrorReport(0, "success", response);
            }
        }
        return new ErrorReport(1, "no such username or password error");

    }

    public String isLogin(HttpServletRequest request){
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String name = TokenUtil.getAudience(token);
        boolean x = TokenUtil.parseToken(token);
        if (name!=null&&x){
            return name;
        }else {
            return null;
        }
    }

//    public ErrorReport logout(HttpServletRequest request) {
//        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
//        String name = TokenUtil.getAudience(token);
//        boolean x = TokenUtil.parseToken(token);
//        if (name!=null&&x) {
//            return new ErrorReport(0, "success");
//        }
//        else{
//            return new ErrorReport(1, "error");
//        }
//    }

}
