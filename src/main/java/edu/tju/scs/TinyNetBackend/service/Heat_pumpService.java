package edu.tju.scs.TinyNetBackend.service;

import com.alibaba.fastjson.JSONObject;
import edu.tju.scs.TinyNetBackend.common.utils.TokenUtil;
import edu.tju.scs.TinyNetBackend.mapper.Heat_pumpMapper;
import edu.tju.scs.TinyNetBackend.model.dto.ErrorReport;
import edu.tju.scs.TinyNetBackend.model.dto.ResponseData;
import edu.tju.scs.TinyNetBackend.model.po.Heat_pump;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Heat_pumpService {

    @Autowired
    protected Heat_pumpMapper heat_pumpMapper;

    private boolean check(int id,String owner)
    {
        if(heat_pumpMapper.selectByPrimaryKey(id)==null||!owner.equals(heat_pumpMapper.selectByPrimaryKey(id).getOwner()))
            return false;
        return true;
    }


    public ErrorReport add(JSONObject heat_pump, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        heat_pump.put("owner",username);
        heat_pump.remove("id");
        Heat_pump heat_pump1 = JSONObject.toJavaObject(heat_pump,Heat_pump.class);

        heat_pumpMapper.insert(heat_pump1);

        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        return new ErrorReport(0,"success",response);
    }

    public ErrorReport update(JSONObject heat_pump, String token)
    {
        if(!TokenUtil.parseToken(token))
            return new ErrorReport(2,"please login");
        String username = TokenUtil.getAudience(token);
        String new_token=TokenUtil.getToken(username);
        ResponseData response =new ResponseData();
        response.addData("token",new_token);
        Heat_pump heat_pump1 = JSONObject.toJavaObject(heat_pump,Heat_pump.class);
        if(!username.equals(heat_pump1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        if(!check(heat_pump1.getId(),heat_pump1.getOwner()))
            return new ErrorReport(31,"id no exist",response);
        heat_pumpMapper.updateByPrimaryKey(heat_pump1);
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

        Heat_pump heat_pump =heat_pumpMapper.selectByPrimaryKey(id);

        if(heat_pump!=null){
            response.addData("data",heat_pump);
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
        heat_pumpMapper.deleteByPrimaryKey(id);
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
        List<Heat_pump> heat_pumplist;
        if(val==""){
            heat_pumplist =heat_pumpMapper.selectByOwner(username,(pi-1)*ps,ps);
            int total = heat_pumpMapper.countB();
            response.addData("total",total);
        }
        else{
            heat_pumplist =heat_pumpMapper.selectByOwner1(username,(pi-1)*ps,ps,val);
            int total = heat_pumpMapper.countB1(val);
            response.addData("total",total);
        }
        response.addData("list",heat_pumplist);

        return new ErrorReport(0,"success",response);

    }

}
