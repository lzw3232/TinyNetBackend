package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Gas_steam_boilerMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Gas_steam_boiler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Gas_steam_boilerService {

    @Autowired
    protected Gas_steam_boilerMapper gas_steam_boilerMapper;

    private boolean check(int id,String owner)
    {
        if(gas_steam_boilerMapper.selectByPrimaryKey(id)==null||!owner.equals(gas_steam_boilerMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject gas_steam_boiler, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        gas_steam_boiler.put("owner",username);
        gas_steam_boiler.remove("id");
        Gas_steam_boiler gas_steam_boiler1 = JSONObject.toJavaObject(gas_steam_boiler,Gas_steam_boiler.class);

        gas_steam_boilerMapper.insert(gas_steam_boiler1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject gas_steam_boiler, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Gas_steam_boiler gas_steam_boiler1 = JSONObject.toJavaObject(gas_steam_boiler,Gas_steam_boiler.class);
        if(!username.equals(gas_steam_boiler1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(gas_steam_boiler1.getId(),gas_steam_boiler1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        gas_steam_boilerMapper.updateByPrimaryKey(gas_steam_boiler1);
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

        Gas_steam_boiler gas_steam_boiler =gas_steam_boilerMapper.selectByPrimaryKey(id);

        if(gas_steam_boiler!=null){
            response.addData("data",gas_steam_boiler);
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
        gas_steam_boilerMapper.deleteByPrimaryKey(id);
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
        List<Gas_steam_boiler> gas_steam_boilerlist;
        if(val==""){
            gas_steam_boilerlist =gas_steam_boilerMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = gas_steam_boilerMapper.countB();
            response.addData("total",total);
        }
        else{
            gas_steam_boilerlist =gas_steam_boilerMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = gas_steam_boilerMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",gas_steam_boilerlist);

        return new ErrorReport(0,"success",response);

    }

}
