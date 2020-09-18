package edu.tju.scs.TinyNetBackend.service;


//import edu.tju.scs.TinyNetBackend.common.FileHelper;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.UserMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {

    @Autowired
    protected UserMapper userMapper;

    public ErrorReport reg(String username, String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        password = passwordEncoder.encode(password);
        if (userMapper.selectByPrimaryKey(username)==null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setType(0);
            userMapper.insert(user);
            //FileHelper.createUser(username);
            return new ErrorReport(0, "success");
        } else {
            return new ErrorReport(3, "Already registered");
        }
    }

    private boolean check(String id,String name)
    {
        User user = userMapper.selectByPrimaryKey(id);
        if(user==null||!name.equals(user.getUsername()))
            return false;
        return true;
    }

    public ErrorReport update(HttpServletRequest request,String username, String olepassword, String newpassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        olepassword = passwordEncoder.encode(olepassword);

        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String name = TokenUtil.getAudience(token);

        if ( userMapper.selectByPrimaryKey(username)!=null&& check(name,username)) {// && check(name,username)

            User user = userMapper.selectByPrimaryKey(username);
            if(passwordEncoder.matches(olepassword, user.getPassword()))
            {
                newpassword = passwordEncoder.encode(newpassword);
                user.setPassword(newpassword);
                userMapper.updateByPrimaryKey(user);
                return new ErrorReport(0, "success");
            }
            else {
                return new ErrorReport(2, "password error");
            }

        }
        else {
            return new ErrorReport(5, "no such user");
        }
    }


    private boolean checkAdmin(HttpServletRequest request)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String name = TokenUtil.getAudience(token);
        if(userMapper.selectByPrimaryKey(name)!=null&&userMapper.selectByPrimaryKey(name).getType()==1)
        {
            return  true;
        }
        return false;
    }

    public ErrorReport adminmodify(HttpServletRequest request,String username, String passowrd)
    {
        if(checkAdmin(request))
        {
            if(userMapper.selectByPrimaryKey(username)!=null)
            {
                User user = new User();
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                passowrd = passwordEncoder.encode(passowrd);
                user.setPassword(passowrd);
                user.setUsername(username);
                return new ErrorReport(0, "success");
            }
            else{
                return new ErrorReport(5, "no such user");
            }
        }
        else{
            return new ErrorReport(6, "not admin");
        }
    }

}
