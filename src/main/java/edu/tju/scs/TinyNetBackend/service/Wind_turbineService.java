package edu.tju.scs.TinyNetBackend.service;


import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Wind_turbineMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Wind_turbine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Wind_turbineService {

    @Autowired
    protected Wind_turbineMapper wind_turbineMapper;

    private boolean check(int id,String owner)
    {
        if(wind_turbineMapper.selectByPrimaryKey(id)==null||!owner.equals(wind_turbineMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject wind_turbine, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        wind_turbine.put("owner",username);
        wind_turbine.remove("id");
        Wind_turbine wind_turbine1 = JSONObject.toJavaObject(wind_turbine,Wind_turbine.class);

        wind_turbineMapper.insert(wind_turbine1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject wind_turbine, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Wind_turbine wind_turbine1 = JSONObject.toJavaObject(wind_turbine, Wind_turbine.class);
        if(!username.equals(wind_turbine1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(wind_turbine1.getId(),wind_turbine1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        wind_turbineMapper.updateByPrimaryKey(wind_turbine1);
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

        Wind_turbine wind_turbine =wind_turbineMapper.selectByPrimaryKey(id);

        if(wind_turbine!=null){
            response.addData("data",wind_turbine);
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
        wind_turbineMapper.deleteByPrimaryKey(id);
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
        List<Wind_turbine> wind_turbinelist;
        if(val==""){
            wind_turbinelist =wind_turbineMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = wind_turbineMapper.countB();
            response.addData("total",total);
        }
        else{
            wind_turbinelist =wind_turbineMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = wind_turbineMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",wind_turbinelist);

        return new ErrorReport(0,"success",response);

    }
}
