package edu.tju.scs.TinyNetBackend.service;


import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Waste_heat_boilerMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Waste_heat_boiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Waste_heat_boilerService {

    @Autowired
    protected Waste_heat_boilerMapper waste_heat_boilerMapper;

    private boolean check(int id,String owner)
    {
        if(waste_heat_boilerMapper.selectByPrimaryKey(id)==null||!owner.equals(waste_heat_boilerMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }

    public ErrorReport add(JSONObject waste_heat_boiler, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        waste_heat_boiler.put("owner",username);
        waste_heat_boiler.remove("id");
        Waste_heat_boiler waste_heat_boiler1 = JSONObject.toJavaObject(waste_heat_boiler,Waste_heat_boiler.class);

        waste_heat_boilerMapper.insert(waste_heat_boiler1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject waste_heat_boiler, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Waste_heat_boiler waste_heat_boiler1 = JSONObject.toJavaObject(waste_heat_boiler,Waste_heat_boiler.class);
        if(!username.equals(waste_heat_boiler1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(waste_heat_boiler1.getId(),waste_heat_boiler1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        waste_heat_boilerMapper.updateByPrimaryKey(waste_heat_boiler1);
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

        Waste_heat_boiler waste_heat_boiler =waste_heat_boilerMapper.selectByPrimaryKey(id);

        if(waste_heat_boiler!=null){
            response.addData("data",waste_heat_boiler);
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
        waste_heat_boilerMapper.deleteByPrimaryKey(id);
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
        List<Waste_heat_boiler> waste_heat_boilerlist;
        if(val==""){
            waste_heat_boilerlist =waste_heat_boilerMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = waste_heat_boilerMapper.countB();
            response.addData("total",total);
        }
        else{
            waste_heat_boilerlist =waste_heat_boilerMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = waste_heat_boilerMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",waste_heat_boilerlist);

        return new ErrorReport(0,"success",response);

    }
}
