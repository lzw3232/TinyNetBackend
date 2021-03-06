package edu.tju.scs.TinyNetBackend.common.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tju.scs.TinyNetBackend.common.Annotaion.JWTAuth;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.common.utils.RedisUtil;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.mapper.UserMapper;
import edu.tju.scs.TinyNetBackend.model.po.User;
import edu.tju.scs.TinyNetBackend.service.JWTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;


@Slf4j
public class JWTAuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    JWTService jwtService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("the current handler is {}", handler.toString());
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if(!method.isAnnotationPresent(JWTAuth.class)){
            return true;
        } else {
            String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
            User user = userMapper.selectByPrimaryKey(TokenUtil.getAudience(token));
            if(TokenUtil.parseToken(token)){
                // 请重新登录
                writeMsg(response,new ErrorReport(10,"there is no login information about you"));
                return false;
            }
            JWTAuth jwtAuth = method.getAnnotation(JWTAuth.class);
            String[] authorization = jwtAuth.value();

            if(authorization.length > 0){

                for(int i = 0;i < authorization.length;i++){
                    if((JWTService.ADMIN_ROLE.equals(authorization[i]) && user.getType() == 1) ||
                            (JWTService.USER_ROLE.equals(authorization[i]) && user.getType() == 0)){
                        redisUtil.updateExpire(TokenUtil.getAudience(token));
                        return true;
                    }
                }

            }

            writeMsg(response,new ErrorReport(10,"the authorization is not correct"));
            return false;
        }
    }


    public void writeMsg(HttpServletResponse response, ErrorReport errorReport){
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writeValueAsString(errorReport);
            writer.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null) {
                writer.close();
            }
        }
    }
}
