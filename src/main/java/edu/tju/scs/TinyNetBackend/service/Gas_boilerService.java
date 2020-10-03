package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Gas_boilerMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Gas_boiler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Gas_boilerService {

    @Autowired
    protected Gas_boilerMapper gas_boilerMapper;

    private boolean check(int id,String owner)
    {
        if(gas_boilerMapper.selectByPrimaryKey(id)==null||!owner.equals(gas_boilerMapper.selectByPrimaryKey(id).getOwner()))
            return false;        return true;
    }


    public ErrorReport add(JSONObject gas_boiler, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        gas_boiler.put("owner",username);
        gas_boiler.remove("id");
        Gas_boiler gas_boiler1 = JSONObject.toJavaObject(gas_boiler, Gas_boiler.class);

        gas_boilerMapper.insert(gas_boiler1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject gas_boiler, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Gas_boiler gas_boiler1 = JSONObject.toJavaObject(gas_boiler,Gas_boiler.class);
        if(!username.equals(gas_boiler1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(gas_boiler1.getId(),gas_boiler1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        gas_boilerMapper.updateByPrimaryKey(gas_boiler1);
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

        Gas_boiler gas_boiler =gas_boilerMapper.selectByPrimaryKey(id);

        if(gas_boiler!=null){
            response.addData("data",gas_boiler);
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
        gas_boilerMapper.deleteByPrimaryKey(id);
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
        List<Gas_boiler> gas_boilerlist;
        if(val==""){
            gas_boilerlist =gas_boilerMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = gas_boilerMapper.countB();
            response.addData("total",total);
        }
        else{
            gas_boilerlist =gas_boilerMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = gas_boilerMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",gas_boilerlist);

        return new ErrorReport(0,"success",response);

    }
    public ErrorReport lzw()
    {
        return new ErrorReport(0,"success");
    }

}
