package edu.tju.scs.TinyNetBackend.service;


import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.TurbineMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseObjectData;
import edu.tju.scs.TinyNetBackend.model.po.RecordWithBLOBs;
import edu.tju.scs.TinyNetBackend.model.po.Turbine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class TurbineService {

    @Autowired
    protected TurbineMapper turbineMapper;

    private boolean check(int id,String owner)
    {
        Turbine turbine = turbineMapper.selectByPrimaryKey(id);
        if(turbine==null||!owner.equals(turbine.getOwner()))
            return false;
        return true;
    }

    public ErrorReport add(HttpServletRequest request,Turbine turbine)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",token);
        turbine.setOwner(username);

        turbineMapper.insert(turbine);

        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(HttpServletRequest request,Turbine turbine)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",token);
        if(!username.equals(turbine.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(turbine.getId(),turbine.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        turbineMapper.updateByPrimaryKey(turbine);
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
        Turbine turbine =turbineMapper.selectByPrimaryKey(id);
        if(turbine!=null) {
            response.addData("turbine",turbine);
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
        turbineMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport list(HttpServletRequest request)
    {
        String token = request.getHeader(JWTService.AUTHENTICATION_KEY);
        String username = TokenUtil.getAudience(token);
        token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",token);

        List<Turbine> turbinelist =turbineMapper.selectByOwner(username);
        response.addData("turbineList",turbinelist);

        return new ErrorReport(0,"success",response);

    }
}
