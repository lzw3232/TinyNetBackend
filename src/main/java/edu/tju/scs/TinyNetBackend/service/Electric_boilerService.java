package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Electric_boilerMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Electric_boiler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Electric_boilerService {

    @Autowired
    protected Electric_boilerMapper electric_boilerMapper;

    private boolean check(int id,String owner)
    {
        if(electric_boilerMapper.selectByPrimaryKey(id)==null||!owner.equals(electric_boilerMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject electric_boiler, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        System.out.println(electric_boiler);
        electric_boiler.put("owner",username);
        electric_boiler.remove("id");
        Electric_boiler electric_boiler1 = JSONObject.toJavaObject(electric_boiler,Electric_boiler.class);

        electric_boilerMapper.insert(electric_boiler1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject electric_boiler, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Electric_boiler electric_boiler1 = JSONObject.toJavaObject(electric_boiler,Electric_boiler.class);
        if(!username.equals(electric_boiler1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(electric_boiler1.getId(),electric_boiler1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        electric_boilerMapper.updateByPrimaryKey(electric_boiler1);
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

        Electric_boiler electric_boiler =electric_boilerMapper.selectByPrimaryKey(id);

        if(electric_boiler!=null){
            response.addData("data",electric_boiler);
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
        electric_boilerMapper.deleteByPrimaryKey(id);
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
        List<Electric_boiler> electric_boilerlist;
        if(val==""){
            electric_boilerlist =electric_boilerMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = electric_boilerMapper.countB();
            response.addData("total",total);
        }
        else{
            electric_boilerlist =electric_boilerMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = electric_boilerMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",electric_boilerlist);

        return new ErrorReport(0,"success",response);

    }

}
