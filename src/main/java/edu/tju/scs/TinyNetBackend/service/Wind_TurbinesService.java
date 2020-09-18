package edu.tju.scs.TinyNetBackend.service;


import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Wind_TurbinesMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseObjectData;
import edu.tju.scs.TinyNetBackend.model.po.Wind_Turbines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class Wind_TurbinesService {

    @Autowired
    protected Wind_TurbinesMapper wind_turbinesMapper;

    private boolean check(int id,String owner)
    {
        Wind_Turbines wind_turbines = wind_turbinesMapper.selectByPrimaryKey(id);
        if(wind_turbines==null||!owner.equals(wind_turbines.getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(HttpServletRequest request, Wind_Turbines wind_turbines)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",token);
        wind_turbines.setOwner(username);

        wind_turbinesMapper.insert(wind_turbines);

        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(HttpServletRequest request,Wind_Turbines wind_turbines)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",token);
        if(!username.equals(wind_turbines.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(wind_turbines.getId(),wind_turbines.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        wind_turbinesMapper.updateByPrimaryKey(wind_turbines);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport select(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist",response);
        Wind_Turbines wind_turbines =wind_turbinesMapper.selectByPrimaryKey(id);
        if(wind_turbines!=null) {
            response.addData("wind_turbines",wind_turbines);
            return new ErrorReport(0, "success", response);
        }
        else
            return new ErrorReport(11,"id not found",response);
    }

    public ErrorReport delete(HttpServletRequest request,int id)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",token);
        if(!check(id,username))
            return new ErrorReport(31,"id no exist",response);
        wind_turbinesMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport list(HttpServletRequest request)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",token);

        List<Wind_Turbines> wind_turbineslist =wind_turbinesMapper.selectByOwner(username);
        response.addData("wind_turbineslist",wind_turbineslist);

        return new ErrorReport(0,"success",response);

    }
}
