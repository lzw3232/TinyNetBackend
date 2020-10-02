package edu.tju.scs.TinyNetBackend.service;


import com.alibaba.fastjson.JSONObject;
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
        if(turbineMapper.selectByPrimaryKey(id)==null||!owner.equals(turbineMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }

    public ErrorReport add(JSONObject turbine, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        turbine.put("owner",username);
        turbine.remove("id");
        Turbine turbine1 = JSONObject.toJavaObject(turbine,Turbine.class);

        turbineMapper.insert(turbine1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject turbine, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Turbine turbine1 = JSONObject.toJavaObject(turbine,Turbine.class);
        if(!username.equals(turbine1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(turbine1.getId(),turbine1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        turbineMapper.updateByPrimaryKey(turbine1);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport select(String token,int id)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);

        ResponseData response =new ResponseData();
        response.addData("token",new_token);

        if(!check(id,username)){
            return new ErrorReport(31,"id no exist",response);
        }

        Turbine turbine =turbineMapper.selectByPrimaryKey(id);

        if(turbine!=null){
            response.addData("data",turbine);
            return new ErrorReport(0,"success",response);
        }
        else{
            return new ErrorReport(11,"id not found",response);
        }
    }

    public ErrorReport delete(String token,int id)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        System.out.println("delete");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);

        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        if(!check(id,username)){
            return new ErrorReport(31,"id no exist",response);
        }
        turbineMapper.deleteByPrimaryKey(id);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport list(String token,int pi, int ps,String val)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        List<Turbine> turbinelist;
        if(val==""){
            turbinelist =turbineMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = turbineMapper.countB();
            response.addData("total",total);
        }
        else{
            turbinelist =turbineMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = turbineMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",turbinelist);
        System.out.println(turbinelist);

        return new ErrorReport(0,"success",response);

    }
}
